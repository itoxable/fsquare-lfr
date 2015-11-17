package com.fsquare.shopping.portlet.shoppingstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsquare.shopping.NoSuchShoppingStoreException;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
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
			}
			
		}
		catch (Exception e) {
		}
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
			String cardNumber = ParamUtil.getString(resourceRequest, "cardNumber");
			String cvc = ParamUtil.getString(resourceRequest, "cvc");
			Integer expMonth = ParamUtil.getInteger(resourceRequest, "expMonth");
			Integer expYear = ParamUtil.getInteger(resourceRequest, "expYear");
			String description = ParamUtil.getString(resourceRequest, "description");
			String statementDescription = ParamUtil.getString(resourceRequest, "statementDescription");
			String billingCardHolderName = ParamUtil.getString(resourceRequest, "billingCardHolderName");
			String billingStreet = ParamUtil.getString(resourceRequest, "billingStreet");
			String billingStreet2 = ParamUtil.getString(resourceRequest, "billingStreet2");
			String billingCity = ParamUtil.getString(resourceRequest, "billingCity");
			String billingPostCode = ParamUtil.getString(resourceRequest, "billingPostCode");
			String billingStateProvince = ParamUtil.getString(resourceRequest, "billingStateProvince");
			String billingCountry = ParamUtil.getString(resourceRequest, "billingCountry");
			String billingEmailReceipe = ParamUtil.getString(resourceRequest, "billingEmailReceipe");
			String stripeToken = ParamUtil.getString(resourceRequest, "stripeToken");
			
			Map<String, Object> chargeParams = new HashMap<String, Object>();
			chargeParams.put("amount", amount);
//			chargeParams.put("cardNumber", cardNumber);
//			chargeParams.put("cvc", cvc);
//			chargeParams.put("expMonth", expMonth);
//			chargeParams.put("expYear", expYear);
			chargeParams.put("description", description);
//			chargeParams.put("statementDescription", statementDescription);
//			chargeParams.put("billingCardHolderName", billingCardHolderName);
//			chargeParams.put("billingStreet", billingStreet);
//			chargeParams.put("billingStreet2", billingStreet2);
//			chargeParams.put("billingCity", billingCity);
//			chargeParams.put("billingPostCode", billingPostCode);
//			chargeParams.put("billingStateProvince", billingStateProvince);
//			chargeParams.put("billingCountry", billingCountry);
//			chargeParams.put("billingEmailReceipe", billingEmailReceipe);
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
		
//		jsonObject.put("success", success);
//		writer.print(jsonObject.toString());
//        writer.flush();
//        writer.close();
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
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			shoppingStore.setUserName(user.getLogin());
			
		}
		try{
			shoppingStore.setModifiedDate(new Date());
			
			String storeCountry = ParamUtil.getString(resourceRequest, "storeCountry");
			shoppingStore.setCountry(storeCountry);
			String checkoutDisplayPage = ParamUtil.getString(resourceRequest, "checkoutDisplayPage"); 
			shoppingStore.setCheckoutPageUuid(checkoutDisplayPage);
	        String cartDisplayPage = ParamUtil.getString(resourceRequest, "cartDisplayPage");  
			shoppingStore.setCartPageUuid(cartDisplayPage);
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
