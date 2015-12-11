package com.fsquare.shopping.portlet.shoppingstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.Transaction.GatewayRejectionReason;
import com.braintreegateway.TransactionRequest;
import com.fsquare.shopping.NoSuchShoppingStoreException;
import com.fsquare.shopping.messaging.Destinations;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.model.impl.ShoppingOrderImpl;
import com.fsquare.shopping.model.impl.ShoppingOrderItemImpl;
import com.fsquare.shopping.portlet.BraintreePayment;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalService;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMStructureFinderUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.StripeCollectionAPIResource;
import com.stripe.model.StripeObject;
import com.stripe.net.RequestOptions;

public class StorePortlet extends MVCPortlet{
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_STORE)) {
				saveStore(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_TEST_STRIPE_FORM)) {
				openTestStripeForm(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_TEST_STRIPE)) {
				testStripePayment(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_SEND_TEST_EMAIL)) {
				sendTestEmail(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_STRIPE_WEBHOOK)) {
				stripeWebhook(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_TEST_BRAINTREE_PAYPAL)) {
				openTestBraintreePaypalForm(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_GET_BRAINTREE_CLIENT_TOKEN)) {
				getBraintreeClientToken(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_BRAINTREE_TRANSACTION)) {
				doBraintreeTransaction(resourceRequest, resourceResponse);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private BraintreePayment braintreePayment;
	
	private void doBraintreeTransaction(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException {

		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;

		String nonce = ParamUtil.getString(resourceRequest, "nonce");
		String amount = ParamUtil.getString(resourceRequest, "amount");
		
		Result<Transaction> result = getBraintreeGateway(resourceRequest).doBraintreeTransaction(nonce, amount);
		
        jsonObject.put("braintreeResult", JSONFactoryUtil.looseSerialize(result));
        success = true;
		
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	private BraintreePayment getBraintreeGateway(ResourceRequest resourceRequest) throws PortalException, SystemException{
		if(braintreePayment == null){
			System.out.println("--- BraintreePayment ---");
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
			braintreePayment = new BraintreePayment(shoppingStore);
		}
		return braintreePayment;
	}
	
	private void getBraintreeClientToken(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());

        String clientToken = getBraintreeGateway(resourceRequest).getBraintreeClientToken("");
        jsonObject.put("braintreeClientToken", clientToken);
        
        success = true;
        
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}


	private void openTestBraintreePaypalForm(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException, SystemException, PortletException, IOException {
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
			resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHOPPING_STORE, shoppingStore);
			ClassName journalArticleClassName =  ClassNameLocalServiceUtil.getClassName(JournalArticle.class.getName());
			List<DDMStructure> structureList = DDMStructureLocalServiceUtil.getClassStructures(themeDisplay.getCompanyId(), journalArticleClassName.getClassNameId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			DDMStructure ddmStructure = null;
			for(DDMStructure structure: structureList){
				if("product".equalsIgnoreCase(structure.getName(themeDisplay.getLocale()))){
					ddmStructure = structure;
					break;
				}
			}
			if(ddmStructure != null){
				List<JournalArticle> artilceList = JournalArticleServiceUtil.getArticlesByStructureId(themeDisplay.getScopeGroupId(), ddmStructure.getStructureKey(), 0, 1, (OrderByComparator)null);
				JournalArticle journalArticle = artilceList.get(0);
				if(journalArticle != null){
					ShoppingOrderItem shoppingOrderItem = new ShoppingOrderItemImpl();
					Map<String, String> productMap = ShoppingPortletUtil.getProductDetails(journalArticle);
					shoppingOrderItem.setArticleId(journalArticle.getArticleId());
					shoppingOrderItem.setPrice(Double.parseDouble(productMap.get(ShoppingPortletUtil.PRODUCT_PRICE)));
					shoppingOrderItem.setQuantity(1);
					shoppingOrderItem.setSku(productMap.get(ShoppingPortletUtil.PRODUCT_SKU));
					resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_ORDER_ITEM, shoppingOrderItem);
				}
			}
			
			
		}catch(NoSuchShoppingStoreException e){}
		
		String path = "/shopping-store/test-braintree-paypal-form.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		dispatcher.include(resourceRequest, resourceResponse);
		
	}


	private void stripeWebhook(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		// TODO Auto-generated method stub
		
	}


	private void sendTestEmail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
        ShoppingOrder shoppingOrder = new ShoppingOrderImpl();
        
        shoppingOrder.setShippingEmailAddress(themeDisplay.getUser().getDisplayEmailAddress());
        
        success = true;
        Message message = new Message();
        
		message.put("shoppingOrder", shoppingOrder);
		message.put("shoppingStore", shoppingStore);
		System.out.println("START");
		MessageBusUtil.sendMessage(Destinations.SHOPPING_SUCCESS_ORDER_MAIL, message);
		System.out.println("END");
        
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}


	private void testStripePayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException, PortletException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
			resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHOPPING_STORE, shoppingStore);
		
			Long amount = ParamUtil.getLong(resourceRequest, "amount");
			
			String description = ParamUtil.getString(resourceRequest, "description");
			
			String stripeToken = ParamUtil.getString(resourceRequest, "stripeToken");
			
			Map<String, Object> chargeParams = new HashMap<String, Object>();
			chargeParams.put("amount", amount);
			chargeParams.put("description", description);
			chargeParams.put("source", stripeToken);
			chargeParams.put("currency", shoppingStore.getCurrency().toLowerCase());
		
			
			Stripe.apiKey = shoppingStore.getStripeTestSecretKey();
			Stripe.apiVersion = shoppingStore.getStripeApiVersion();
			
			RequestOptions options = RequestOptions.builder()
					.setApiKey(Stripe.apiKey)
					.setStripeVersion(Stripe.apiVersion)
					.setIdempotencyKey(PortalUUIDUtil.generate()).build();
			
			try {

				Charge charge = Charge.create(chargeParams, options);
				System.out.println("charge.getStatus(): "+charge.getStatus());
				System.out.println("charge: "+charge.toString());
				System.out.println("charge: "+charge);
				success = true;

				PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();

				String path = "/shopping-store/checkout-success.jsp";
				PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
				dispatcher.include(resourceRequest, resourceResponse);
				
			} catch (AuthenticationException e) {
				jsonObject.put("errorMessage", e.getMessage());
				e.printStackTrace();
			} catch (InvalidRequestException e) {
				jsonObject.put("errorMessage", e.getMessage());
				e.printStackTrace();
			} catch (APIConnectionException e) {
				jsonObject.put("errorMessage", e.getMessage());
				e.printStackTrace();
			} catch (CardException e) {
				jsonObject.put("errorMessage", e.getMessage());
				e.printStackTrace();
			} catch (APIException e) {
				jsonObject.put("errorMessage", e.getMessage());
				e.printStackTrace();
			}

		
		}catch(NoSuchShoppingStoreException e){
			jsonObject.put("errorMessage", e.getMessage());
		}
		
	}


	private void openTestStripeForm(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException, PortalException, SystemException {
		
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
			resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHOPPING_STORE, shoppingStore);
		}catch(NoSuchShoppingStoreException e){}
		
		String path = "/shopping-store/test-stripe-form.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		dispatcher.include(resourceRequest, resourceResponse);
		
	}


	private void saveStore(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
		}catch(NoSuchShoppingStoreException e){
			shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getScopeGroupId());
			
			shoppingStore.setCreateDate(new Date());
			shoppingStore.setCompanyId(themeDisplay.getCompanyId());
			shoppingStore.setUserId(themeDisplay.getUserId());
			User user = themeDisplay.getUser();
			shoppingStore.setUserName(user.getLogin());
			
		}
		try{
			shoppingStore.setModifiedDate(new Date());
			String name = ParamUtil.getString(resourceRequest, "name");
			shoppingStore.setName(name);
			
			String defaultEmailAddress = ParamUtil.getString(resourceRequest, "defaultEmailAddress");
			shoppingStore.setDefaultEmailAddress(defaultEmailAddress);;
			
			String storeCountry = ParamUtil.getString(resourceRequest, "storeCountry");
			shoppingStore.setCountry(storeCountry);
			String checkoutDisplayPage = ParamUtil.getString(resourceRequest, "checkoutDisplayPage"); 
			shoppingStore.setCheckoutPageUuid(checkoutDisplayPage);
	        String cartDisplayPage = ParamUtil.getString(resourceRequest, "cartDisplayPage");  
			shoppingStore.setCartPageUuid(cartDisplayPage);
			String productsMainPage = ParamUtil.getString(resourceRequest, "productsMainPage");  
			shoppingStore.setProductsMainPageUuid(productsMainPage);
			
			boolean checkoutPageFullscreen = ParamUtil.getBoolean(resourceRequest, "checkoutPageFullscreen");  
			shoppingStore.setCheckoutPageFullscreen(checkoutPageFullscreen);
			
			String checkoutCompletePageTemplate = ParamUtil.getString(resourceRequest, "checkoutCompletePageTemplate");  
			shoppingStore.setCheckoutCompletePageTemplate(checkoutCompletePageTemplate);
			
			String currency = ParamUtil.getString(resourceRequest, "currency");  
			shoppingStore.setCurrency(currency);
			String onAddToCart = ParamUtil.getString(resourceRequest, "onAddToCart");  
			shoppingStore.setOnAddToCart(onAddToCart);
			String usersType = ParamUtil.getString(resourceRequest, "usersType");  
			shoppingStore.setUserTypes(usersType);
			
			String orderCreatedEmailTemplate = ParamUtil.getString(resourceRequest, "orderCreatedEmailTemplate");  
			String orderShippedEmailTemplate = ParamUtil.getString(resourceRequest, "orderShippedEmailTemplate");  
			String orderCreatedEmailSubject = ParamUtil.getString(resourceRequest, "orderCreatedEmailSubject");  
			String orderCreatedEmailFromAddress = ParamUtil.getString(resourceRequest, "orderCreatedEmailFromAddress");  

			shoppingStore.setOrderCreatedEmailTemplate(orderCreatedEmailTemplate);
			shoppingStore.setOrderShippedEmailTemplate(orderShippedEmailTemplate);
			shoppingStore.setOrderCreatedEmailSubject(orderCreatedEmailSubject);
			shoppingStore.setOrderCreatedEmailFromAddress(orderCreatedEmailFromAddress);
			
			
			String stripeLiveSecretKey = ParamUtil.getString(resourceRequest, "stripeLiveSecretKey");  
			shoppingStore.setStripeLiveSecretKey(stripeLiveSecretKey);
			String stripeLivePublishableKey = ParamUtil.getString(resourceRequest, "stripeLivePublishableKey");  
			shoppingStore.setStripeLivePublishableKey(stripeLivePublishableKey);
			String stripeTestSecretKey = ParamUtil.getString(resourceRequest, "stripeTestSecretKey");  
			shoppingStore.setStripeTestSecretKey(stripeTestSecretKey);
			String stripeTestPublishableKey = ParamUtil.getString(resourceRequest, "stripeTestPublishableKey");  
			shoppingStore.setStripeTestPublishableKey(stripeTestPublishableKey);
			boolean stripeTesting = ParamUtil.getBoolean(resourceRequest, "stripeTesting");  
			shoppingStore.setStripeTesting(stripeTesting);
			boolean integrateWithStripe = ParamUtil.getBoolean(resourceRequest, "integrateWithStripe");  
			shoppingStore.setIntegrateWithStripe(integrateWithStripe);
			String stripeApiVersion = ParamUtil.getString(resourceRequest, "stripeApiVersion");  
			shoppingStore.setStripeApiVersion(stripeApiVersion);
		
			boolean integrateWithBraintree = ParamUtil.getBoolean(resourceRequest, "integrateWithBraintree");  
			shoppingStore.setIntegrateWithBraintree(integrateWithBraintree);
			String braintreePrivateKey = ParamUtil.getString(resourceRequest, "braintreePrivateKey"); 
			shoppingStore.setBraintreePrivateKey(braintreePrivateKey);
			String braintreePublicKey = ParamUtil.getString(resourceRequest, "braintreePublicKey"); 
			shoppingStore.setBraintreePublicKey(braintreePublicKey);
			String braintreeMerchantId = ParamUtil.getString(resourceRequest, "braintreeMerchantId"); 
			shoppingStore.setBraintreeMerchantId(braintreeMerchantId);
			
			boolean useBraintreeSandbox = ParamUtil.getBoolean(resourceRequest, "useBraintreeSandbox");  
			shoppingStore.setUseBraintreeSandbox(useBraintreeSandbox);;
			String braintreeSandboxPrivateKey = ParamUtil.getString(resourceRequest, "braintreeSandboxPrivateKey"); 
			shoppingStore.setBraintreeSandboxPrivateKey(braintreeSandboxPrivateKey);
			String braintreeSandboxPublicKey = ParamUtil.getString(resourceRequest, "braintreeSandboxPublicKey");
			shoppingStore.setBraintreeSandboxPublicKey(braintreeSandboxPublicKey);
			String braintreeSandboxMerchantId = ParamUtil.getString(resourceRequest, "braintreeSandboxMerchantId"); 
			shoppingStore.setBraintreeSandboxMerchantId(braintreeSandboxMerchantId);
			
			ShoppingStoreLocalServiceUtil.updateShoppingStore(shoppingStore);
	        jsonObject.put("successMessage", "Success");
	        success = true;
		}catch(Exception e){
			jsonObject.put("errorMessage", e.getMessage());

		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
}
