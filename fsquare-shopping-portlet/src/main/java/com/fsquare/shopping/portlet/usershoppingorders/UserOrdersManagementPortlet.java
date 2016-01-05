package com.fsquare.shopping.portlet.usershoppingorders;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.braintreegateway.exceptions.NotFoundException;
import com.fsquare.shopping.messaging.Destinations;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.portlet.BraintreePayment;
import com.fsquare.shopping.portlet.StripePaymet;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

public class UserOrdersManagementPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_SHIPPING_ADDRESS)) {
				openShippingAddress(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_ORDER_ITEMS)) {
				openOrderItems(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_UPDATE_ORDER_STATUS)) {
				updateOrderStatus(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_SEND_STATUS_EMAIL)) {
				sendStatusEmail(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_CHECK_PAYMENT_STATUS)) {
				checkPaymentStatus(resourceRequest, resourceResponse);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private BraintreePayment braintreePayment;
	private void checkPaymentStatus(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		
        String externalTxId = ParamUtil.getString(resourceRequest, "externalTxId");
		String paymentType = ParamUtil.getString(resourceRequest, "paymentType");
		
		try{
			String transactionStatus = "";
			if(BraintreePayment.PAYMENT_METHOD_CREDIT_CARD.equals(paymentType) || BraintreePayment.PAYMENT_METHOD_PAYPAL.equals(paymentType)){
				transactionStatus = getBraintreeGateway(resourceRequest).getBraintreeTransactionStatus(externalTxId);
			}else if(StripePaymet.PAYMENT_METHOD_CREDIT_CARD.equals(paymentType)){
				ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
				
				Stripe.apiKey = shoppingStore.isStripeTesting()?shoppingStore.getStripeTestSecretKey():shoppingStore.getStripeLiveSecretKey();
				Stripe.apiVersion = shoppingStore.getStripeApiVersion();
				RequestOptions options = RequestOptions.builder().setApiKey(Stripe.apiKey).setStripeVersion(Stripe.apiVersion).setIdempotencyKey(PortalUUIDUtil.generate()).build();

				
				Charge charge = Charge.retrieve(externalTxId);
				transactionStatus = charge.getStatus();
			}
			
			jsonObject.put("orderStatus", transactionStatus);
			success = true;
		}catch(NotFoundException e){
			jsonObject.put("orderStatus", e.getMessage());
		} catch (AuthenticationException e) {
			jsonObject.put("orderStatus", e.getMessage());
		} catch (InvalidRequestException e) {
			jsonObject.put("orderStatus", e.getMessage());
		} catch (APIConnectionException e) {
			jsonObject.put("orderStatus", e.getMessage());
		} catch (CardException e) {
			jsonObject.put("orderStatus", e.getMessage());
		} catch (APIException e) {
			jsonObject.put("orderStatus", e.getMessage());
		}
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

	private void sendStatusEmail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		
		Long shoppingOrderId = ParamUtil.getLong(resourceRequest, "shoppingOrderId");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			System.out.println("BEFORE");
			ShoppingOrder shoppingOrder = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(shoppingOrderId);
			Message message = new Message();
			ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
			message.put("shoppingOrder", shoppingOrder);
			message.put("shoppingStore", shoppingStore);
			MessageBusUtil.sendMessage(Destinations.SHOPPING_SUCCESS_ORDER_MAIL, message);
			System.out.println("AFTER");
			success = true;
			jsonObject.put("successText", "Sent");

		} catch (SystemException e) {
			e.printStackTrace();
			jsonObject.put("errorText", e.getMessage());
		}
		
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	private void openShippingAddress(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException, PortalException {
		Long shoppingOrderId = ParamUtil.getLong(resourceRequest, "shoppingOrderId");
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();

		ShoppingOrder shoppingOrder;
		try {
			shoppingOrder = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(shoppingOrderId);
			ShoppingShippingMethod shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shoppingOrder.getShippingMethodId());
			resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHOPPING_ORDER, shoppingOrder);
			resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHIPPING, shoppingShippingMethod);

		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		String path = "/shopping-orders-management/order-address.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		
		
		dispatcher.include(resourceRequest, resourceResponse);
	}

	private void openOrderItems(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		Long shoppingOrderId = ParamUtil.getLong(resourceRequest, "shoppingOrderId");
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();

		try {
			List<ShoppingOrderItem> shoppingOrderItems = ShoppingOrderItemLocalServiceUtil.findByShoppingOrderId(shoppingOrderId);
			resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_ORDER_ITEMS, shoppingOrderItems);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		String path = "/shopping-orders-management/order-items.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		
		
		dispatcher.include(resourceRequest, resourceResponse);
	}
	
	private void updateOrderStatus(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		
		Long shoppingOrderId = ParamUtil.getLong(resourceRequest, "shoppingOrderId");
		String status = ParamUtil.getString(resourceRequest, "orderStatus");

		ShoppingOrder shoppingOrder;
		try {
			shoppingOrder = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(shoppingOrderId);
			shoppingOrder.setStatus(status);
			shoppingOrder.setModifiedDate(new Date());
		
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
}
