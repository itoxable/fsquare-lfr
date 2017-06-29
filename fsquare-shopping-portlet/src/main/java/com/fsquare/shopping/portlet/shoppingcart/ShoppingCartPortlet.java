package com.fsquare.shopping.portlet.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fsquare.shopping.NoSuchShoppingStoreException;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.portlet.BaseShoppingPortlet;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingCouponLocalService;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderServiceUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.NavItem;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ShoppingCartPortlet extends BaseShoppingPortlet {
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_REMOVE_FROM_CART)) {
				removeFromShoppingCart(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_APPLY_COUPON)) {
				applyCoupon(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_UPDATE_CART)) {
				updateCart(resourceRequest, resourceResponse);
			}			
		}
		catch (Exception e) {
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpSession session = request.getSession();

		try{			
			
//			ShoppingOrder shoppingOrder = ShoppingPortletUtil.getSessionShoppingOrder(session);
//			if(shoppingOrder == null){
//				Long orderId = CounterLocalServiceUtil.increment(ShoppingOrder.class.getName());
//				shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(orderId);
//			}
			
//			Map<String, ShoppingOrderItem> shoppingOrderItemMap = ShoppingPortletUtil.getSessionShoppingOrderItemMap(session);
//			//List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
//			for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap){
//				entry.getValue().setShoppingOrderItemId(orderId);
//			}
			
		}catch(Exception e){
			
		}
		
		super.processAction(actionRequest, actionResponse);

	}
	
	public void checkout( ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpSession session = request.getSession();

//		Map<String, ShoppingOrderItem> shoppingOrderItemMap = ShoppingPortletUtil.getSessionShoppingOrderItemMap(session);
		
		//ShoppingCoupon shoppingCoupon = ShoppingPortletUtil.getSessionCoupon(session);
//		Long shoppingOrderId = CounterLocalServiceUtil.increment(ShoppingOrder.class.getName());
		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getCompanyId());
			
//			ShoppingOrder shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(shoppingOrderId);
			
//			if(shoppingCoupon != null){
//				shoppingOrder.setCouponCodes(shoppingCoupon.getCode());
//			}
			
//			session.setAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT, shoppingOrder);
			
		}catch(NoSuchShoppingStoreException e){
			shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getCompanyId());
		}
		
		Layout checkoutPageLayout = LayoutLocalServiceUtil.getLayoutByUuidAndCompanyId(shoppingStore.getCheckoutPageUuid(), themeDisplay.getCompanyId());
		NavItem checkoutPageNavItem = new NavItem(request, checkoutPageLayout, null);
		String redirect = checkoutPageNavItem.getRegularURL();
		redirect = PortalUtil.escapeRedirect(redirect);
		actionResponse.sendRedirect(redirect);
	}
}
