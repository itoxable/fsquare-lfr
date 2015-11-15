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
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
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
import com.liferay.portal.model.User;
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

public class OrdersPortlet extends MVCPortlet {
	
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

	private void saveCheckoutPayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
		ShoppingOrder shoppingOrder = (ShoppingOrder)session.getAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT);
		
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
		System.out.println(shoppingOrder.getTotalPrice());
		Double t = 100*shoppingOrder.getTotalPrice();
		System.out.println(t.intValue());
		chargeParams.put("amount", t.intValue());//toString(shoppingOrder.getTotalPrice()));
//		chargeParams.put("cardNumber", cardNumber);
//		chargeParams.put("cvc", cvc);
//		chargeParams.put("expMonth", expMonth);
//		chargeParams.put("expYear", expYear);
		chargeParams.put("description", description);
//		chargeParams.put("statementDescription", statementDescription);
//		chargeParams.put("billingCardHolderName", billingCardHolderName);
//		chargeParams.put("billingStreet", billingStreet);
//		chargeParams.put("billingStreet2", billingStreet2);
//		chargeParams.put("billingCity", billingCity);
//		chargeParams.put("billingPostCode", billingPostCode);
//		chargeParams.put("billingStateProvince", billingStateProvince);
//		chargeParams.put("billingCountry", billingCountry);
//		chargeParams.put("billingEmailReceipe", billingEmailReceipe);
		chargeParams.put("source", stripeToken);
		chargeParams.put("currency", shoppingStore.getCurrency().toLowerCase());
	
		
		Stripe.apiKey = shoppingStore.isStripeTesting()?shoppingStore.getStripeTestSecretKey():shoppingStore.getStripeLiveSecretKey();
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
			jsonObject.put("successMessage", "STATUS: "+charge.getStatus()+"; TRANSFER: "+charge.getTransfer());
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
		
		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
		}catch(NoSuchShoppingStoreException e){
			shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getScopeGroupId());
		}
		String country = ParamUtil.getString(resourceRequest, "country");
		String email = ParamUtil.getString(resourceRequest, "email");
		String city = ParamUtil.getString(resourceRequest, "city");
		String phoneNumber = ParamUtil.getString(resourceRequest, "phoneNumber");
		String postCode = ParamUtil.getString(resourceRequest, "postCode");
		String firstName = ParamUtil.getString(resourceRequest, "firstName");
		String lastName = ParamUtil.getString(resourceRequest, "lastName");
		String streetAddress1 = ParamUtil.getString(resourceRequest, "streetAddress1");
		String streetAddress2 = ParamUtil.getString(resourceRequest, "streetAddress2");
		
		boolean iternational = !shoppingStore.getCountry().equalsIgnoreCase(country);
		
		ShoppingOrder shoppingOrder = (ShoppingOrder)session.getAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT);
		if(shoppingOrder == null){
			shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(CounterLocalServiceUtil.increment(ShoppingOrder.class.getName()));
		}
		shoppingOrder.setShippingCity(city);
		shoppingOrder.setShippingCountry(country);
		shoppingOrder.setShippingEmailAddress(email);
		shoppingOrder.setShippingPhone(phoneNumber);
		shoppingOrder.setShippingPostCode(postCode);
		shoppingOrder.setShippingFirstName(firstName);
		shoppingOrder.setShippingLastName(lastName);
		shoppingOrder.setShippingStreet(streetAddress1);
		shoppingOrder.setShippingStreet2(streetAddress2);
		shoppingOrder.setInternational(iternational);
		success = true;
		session.setAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT, shoppingOrder);

		List<ShoppingShippingMethod> availableShoppingShippingMethodList = new ArrayList<ShoppingShippingMethod>();
		List<ShoppingShippingMethod> shoppingShippingMethodList = ShoppingShippingMethodLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
		
		for(ShoppingShippingMethod shoppingShippingMethod : shoppingShippingMethodList){
			if(iternational && shoppingShippingMethod.isInternational()){
				availableShoppingShippingMethodList.add(shoppingShippingMethod);
			}else if(!iternational && !shoppingShippingMethod.isInternational()){
				availableShoppingShippingMethodList.add(shoppingShippingMethod);
			}
		}
		
		resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_AVAILABLE_SHOPPING_SHIPPING_METHOD_LIST, availableShoppingShippingMethodList);
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
		String path = "/shopping-order/shipping-method.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		dispatcher.include(resourceRequest, resourceResponse);
		
//		jsonObject.put("success", success);
//		jsonObject.put("shoppingOrder", JSONFactoryUtil.looseSerialize(shoppingOrder));
//
//		writer.print(jsonObject.toString());
//        writer.flush();
//        writer.close();
	}

	private void saveCheckoutShippingMethod(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		ShoppingOrder shoppingOrder = (ShoppingOrder)session.getAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT);
		
		long shippingMethodId = ParamUtil.getLong(resourceRequest, "shippingMethodId");

		ShoppingShippingMethod shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shippingMethodId);
		
		
		Map<String,ShoppingOrderItem> shoppingOrderItemMap = (Map<String,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
		if(shoppingOrderItemMap == null){
			shoppingOrderItemMap = new HashMap<String,ShoppingOrderItem>();
		}

		double total = 0;
		for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
			ShoppingOrderItem orderItem = entry.getValue();
			total = total + orderItem.getQuantity() * orderItem.getPrice();
		}

		ShoppingCoupon shoppingCoupon = null;
		Object shoppingCouponObj = session.getAttribute(ShoppingPortletUtil.SESSION_CART_COUPON_CODE);
		if(shoppingCouponObj != null){
			shoppingCoupon = (ShoppingCoupon)shoppingCouponObj;
			total = ShoppingPortletUtil.applyCoupon(shoppingCoupon, total);
		}
		
		
		double shipping = ShoppingShippingMethodLocalServiceUtil.getShippingPrice(shoppingShippingMethod, shoppingOrderItemMap.values(), total);
		total = total + shipping;
		shoppingOrder.setShippingMethodId(shippingMethodId);
		shoppingOrder.setTotalPrice(total);
		
		session.setAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT, shoppingOrder);

		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
		String path = "/shopping-order/payment-form.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		dispatcher.include(resourceRequest, resourceResponse);
		
//		jsonObject.put("success", success);
//		jsonObject.put("shoppingOrder", JSONFactoryUtil.looseSerialize(shoppingOrder));
//
//		writer.print(jsonObject.toString());
//        writer.flush();
//        writer.close();
	}

}
