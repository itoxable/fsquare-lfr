package com.fsquare.shopping.portlet.shoppingordersmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsquare.shopping.messaging.Destinations;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class OrdersManagementPortlet extends MVCPortlet {
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
			}
			
			
		}
		catch (Exception e) {
		}
	}

	private void sendStatusEmail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		
		Long shoppingOrderId = ParamUtil.getLong(resourceRequest, "shoppingOrderId");

		try {
			
			System.out.println("BEFORE");
			ShoppingOrder shoppingOrder = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(shoppingOrderId);
		
			MessageBusUtil.sendMessage(Destinations.SHOPPING_SUCCESS_ORDER_MAIL, shoppingOrder);
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
