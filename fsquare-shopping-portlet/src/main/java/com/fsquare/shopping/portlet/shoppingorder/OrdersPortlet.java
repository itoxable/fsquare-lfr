package com.fsquare.shopping.portlet.shoppingorder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fsquare.shopping.NoSuchShoppingStoreException;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.portlet.BaseShoppingPortlet;
import com.fsquare.shopping.portlet.ShoppingOrderProcessWrapper;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

public class OrdersPortlet extends BaseShoppingPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		HttpSession session = request.getSession();
		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
		ShoppingOrder shoppingOrder = shoppingOrderProcessWrapper.getShoppingOrder();
		
		if(shoppingOrder == null){
			shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(-1L);
			shoppingOrderProcessWrapper.setShoppingOrder(shoppingOrder);
		}
		 super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_CHECKOUT_SHIPPING_ADDRESS)) {
				saveCheckoutShippingAddress(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_CHECKOUT_SHIPPING_METHOD)) {
				saveCheckoutShippingMethod(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_CHECKOUT_PAYMENT)) {
				saveCheckoutPayment(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_GET_CHECKOUT_STEP)) {
				getCheckoutStep(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_GET_ORDER_TOTAL)) {
				getOrderTotal(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_REMOVE_FROM_CART)) {
				removeFromShoppingCart(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_APPLY_COUPON)) {
				applyCoupon(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_UPDATE_CART)) {
				updateCart(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_CALCULATE_SHIPPING_PRICE)) {
				calculateShippingPrice(resourceRequest, resourceResponse);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("success", success);
			jsonObject.put("errorMessage", e.getMessage());
			writer.print(jsonObject.toString());
	        writer.flush();
	        writer.close();
		}
	}

	private void calculateShippingPrice(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
		ShoppingShippingMethod shoppingShippingMethod = shoppingOrderProcessWrapper.getShoppingShippingMethod();

		double total = ShoppingOrderLocalServiceUtil.getOrderTotal(shoppingOrderProcessWrapper.getShoppingOrderItemMap().values());
		double shippingPrice = ShoppingShippingMethodLocalServiceUtil.getShippingPrice(shoppingOrderProcessWrapper.getShoppingShippingMethod(), shoppingOrderProcessWrapper.getShoppingOrderItemMap().values(), total);
		
		ShoppingCoupon shoppingCoupon = shoppingOrderProcessWrapper.getShoppingCoupon();
		
		double couponDiscount =  ShoppingCouponLocalServiceUtil.applyCoupon(shoppingCoupon, total);
		
		success = true;
		jsonObject.put("success", success);
		jsonObject.put("total", ((total+shippingPrice)-couponDiscount));

		jsonObject.put("shoppingShippingMethod", JSONFactoryUtil.looseSerialize(shoppingShippingMethod));

		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	@SuppressWarnings("unchecked")
	private void getOrderTotal(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException, SystemException, IOException {
		
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;

        HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();

		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
		double total = shoppingOrderProcessWrapper.getAbsoluteTotal();

		//shoppingOrder.setTotalPrice(total);
		success = true;
		jsonObject.put("success", success);
		//jsonObject.put("shoppingOrder", JSONFactoryUtil.looseSerialize(shoppingOrder));

		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	private void getCheckoutStep(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
		Integer step = ParamUtil.getInteger(resourceRequest, "step");
		String path = "";
		if(ShoppingPortletUtil.CHECKOUT_STEP_ADDRESS_NR == step){
			path = ShoppingPortletUtil.CHECKOUT_STEP_ADDRESS_FORM;
		}else if(ShoppingPortletUtil.CHECKOUT_STEP_PAYMENT_NR == step){
			path = ShoppingPortletUtil.CHECKOUT_STEP_PAYMENT_FORM;
		} if(ShoppingPortletUtil.CHECKOUT_STEP_SHIPPING_NR == step){
			path = ShoppingPortletUtil.CHECKOUT_STEP_SHIPPING_METHOD;
		}
		
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		dispatcher.include(resourceRequest, resourceResponse);
		
	}

	private void saveCheckoutPayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException, PortletException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
		
		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
		
		ShoppingOrder shoppingOrder = shoppingOrderProcessWrapper.getShoppingOrder();
		
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
		
		double total = shoppingOrderProcessWrapper.getAbsoluteTotal();

		Double t = 100*total;
		
		chargeParams.put("amount", t.intValue());//toString(shoppingOrder.getTotalPrice()));

		chargeParams.put("source", stripeToken);
		chargeParams.put("currency", shoppingStore.getCurrency().toLowerCase());
	
		
		Stripe.apiKey = shoppingStore.isStripeTesting()?shoppingStore.getStripeTestSecretKey():shoppingStore.getStripeLiveSecretKey();
		Stripe.apiVersion = shoppingStore.getStripeApiVersion();
		
		RequestOptions options = RequestOptions.builder().setApiKey(Stripe.apiKey).setStripeVersion(Stripe.apiVersion).setIdempotencyKey(PortalUUIDUtil.generate()).build();
		
		try {
			shoppingOrder.setTotalPrice(total);
			shoppingOrder.setGroupId(themeDisplay.getScopeGroupId());
			shoppingOrder.setShoppingOrderId(CounterLocalServiceUtil.increment(ShoppingOrder.class.getName()));
			shoppingOrder.setCouponCodes(shoppingOrderProcessWrapper.getShoppingCoupon()!=null?shoppingOrderProcessWrapper.getShoppingCoupon().getCode():"");
			shoppingOrder.setShippingMethodId(shoppingOrderProcessWrapper.getShoppingShippingMethod().getShippingMethodId());
			shoppingOrder.setNumber(Long.toString(shoppingOrder.getShoppingOrderId()));
			shoppingOrder = ShoppingOrderLocalServiceUtil.updateShoppingOrder(shoppingOrder);
			
			for(ShoppingOrderItem shoppingOrderItem : shoppingOrderProcessWrapper.getShoppingOrderItemMap().values()){
				shoppingOrderItem.setShoppingOrderId(shoppingOrder.getShoppingOrderId());
				shoppingOrderItem.setShoppingOrderItemId(CounterLocalServiceUtil.increment(ShoppingOrderItem.class.getName()));
				ShoppingOrderItemLocalServiceUtil.updateShoppingOrderItem(shoppingOrderItem);
			}
			
			shoppingOrderProcessWrapper.setShoppingOrder(shoppingOrder);
			chargeParams.put("description", "jo-walton.com painting shopping order id: "+shoppingOrder.getShoppingOrderId());

			Charge charge = Charge.create(chargeParams, options);

			PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
			String path = ShoppingPortletUtil.CHECKOUT_SUCCESS_SCREEN;
			resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHOPPING_ORDER_PROCESS_WRAPPER, shoppingOrderProcessWrapper);
			PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
			dispatcher.include(resourceRequest, resourceResponse);
			
			ShoppingPortletUtil.setSessionShoppingOrderProcessWrapper(session, null);
		
		
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
		
	}

	private void saveCheckoutShippingAddress(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException, PortletException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
		//double total = shoppingOrderProcessWrapper.getAbsoluteTotal();
		
		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
		}catch(NoSuchShoppingStoreException e){
			shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getScopeGroupId());
		}
		String countryCode = ParamUtil.getString(resourceRequest, "country");
		String email = ParamUtil.getString(resourceRequest, "email");
		String city = ParamUtil.getString(resourceRequest, "city");
		String phoneNumber = ParamUtil.getString(resourceRequest, "phoneNumber");
		String postCode = ParamUtil.getString(resourceRequest, "postCode");
		String firstName = ParamUtil.getString(resourceRequest, "firstName");
		String lastName = ParamUtil.getString(resourceRequest, "lastName");
		String streetAddress1 = ParamUtil.getString(resourceRequest, "streetAddress1");
		String streetAddress2 = ParamUtil.getString(resourceRequest, "streetAddress2");
		
		Country country = CountryServiceUtil.fetchCountryByA2(countryCode);
		
		shoppingOrderProcessWrapper.setShippingCountry(country);
		
		boolean iternational = !shoppingStore.getCountry().equalsIgnoreCase(countryCode);
		
		ShoppingOrder shoppingOrder = shoppingOrderProcessWrapper.getShoppingOrder();
		if(shoppingOrder == null){
			shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(-1L);
		}
		shoppingOrder.setShippingCity(city);
		shoppingOrder.setShippingCountry(countryCode);
		shoppingOrder.setShippingEmailAddress(email);
		shoppingOrder.setShippingPhone(phoneNumber);
		shoppingOrder.setShippingPostCode(postCode);
		shoppingOrder.setShippingFirstName(firstName);
		shoppingOrder.setShippingLastName(lastName);
		shoppingOrder.setShippingStreet(streetAddress1);
		shoppingOrder.setShippingStreet2(streetAddress2);
		shoppingOrder.setInternational(iternational);
		success = true;

		List<ShoppingShippingMethod> availableShoppingShippingMethodList = new ArrayList<ShoppingShippingMethod>();
		List<ShoppingShippingMethod> shoppingShippingMethodList = ShoppingShippingMethodLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
		
		for(ShoppingShippingMethod shoppingShippingMethod : shoppingShippingMethodList){
			if(iternational && shoppingShippingMethod.isInternational()){
				availableShoppingShippingMethodList.add(shoppingShippingMethod);
			}else if(!iternational && !shoppingShippingMethod.isInternational()){
				availableShoppingShippingMethodList.add(shoppingShippingMethod);
			}
		}
		
		shoppingOrderProcessWrapper.setAvailableShoppingShippingMethodList(availableShoppingShippingMethodList);
		
		jsonObject.put("success", country.getName(themeDisplay.getLocale()));
		jsonObject.put("countryName", success);
		jsonObject.put("shoppingOrder", JSONFactoryUtil.looseSerialize(shoppingOrder));

		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	@SuppressWarnings("unchecked")
	private void saveCheckoutShippingMethod(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
		
		long shippingMethodId = ParamUtil.getLong(resourceRequest, "shippingMethodId");
		ShoppingShippingMethod shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shippingMethodId);
		shoppingOrderProcessWrapper.setShoppingShippingMethod(shoppingShippingMethod);
		
		double total = shoppingOrderProcessWrapper.getAbsoluteTotal();
	
		success = true;
		jsonObject.put("total", total);
		jsonObject.put("success", success);
		jsonObject.put("shoppingShippingMethod", JSONFactoryUtil.looseSerialize(shoppingShippingMethod));

		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	

}
