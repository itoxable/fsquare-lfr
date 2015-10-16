package com.fsquare.shopping.portlet.cartview;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingOrderServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CartViewPortlet extends MVCPortlet {
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpSession session = request.getSession();

		try{			
			Long orderId = CounterLocalServiceUtil.increment(ShoppingOrder.class.getName());
			ShoppingOrder shoppingOrder = ShoppingOrderServiceUtil.createShoppingOrder(orderId);

			
			List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
			for(ShoppingOrderItem orderItem: shoppingOrderItemList){
				orderItem.setOrderId(orderId);
			}
			

			
			
		}catch(Exception e){
			
		}
		
		super.processAction(actionRequest, actionResponse);

	}
}
