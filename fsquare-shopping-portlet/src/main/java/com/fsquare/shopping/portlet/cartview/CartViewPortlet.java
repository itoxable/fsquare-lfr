package com.fsquare.shopping.portlet.cartview;

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

public class CartViewPortlet extends MVCPortlet {
	
	
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
	private void updateCart(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
        
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Integer quantity = ParamUtil.getInteger(resourceRequest, "quantity");
        String articleId = ParamUtil.getString(resourceRequest, "articleId");
        
        Map<String, String> productDetails = ShoppingPortletUtil.getProductDetails(themeDisplay, articleId);
        Integer productQuantity = Integer.parseInt(productDetails.get(ShoppingPortletUtil.PRODUCT_QUANTITY));
        
        if(quantity > productQuantity){
        	success = false;
        	jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-not-enough-quantity"));
        }else  if(quantity < 1){
        	removeFromShoppingCart(resourceRequest, resourceResponse);
        	return;
        }else{
        
	        double price = 0;
	        double total = 0;
	        
	        HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
			HttpSession session = request.getSession();
			Map<String,ShoppingOrderItem> shoppingOrderItemMap = (Map<String,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
	
			shoppingOrderItemMap.get(articleId).setQuantity(quantity);
	        for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
	        	ShoppingOrderItem orderItem = entry.getValue();
	        	total = total + orderItem.getQuantity() * orderItem.getPrice();
	        }
	        
	        jsonObject.put("total", total);
	        jsonObject.put("price", price);
	        success = true;
        }
        
        jsonObject.put("success", success);
        
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	@SuppressWarnings("unchecked")
	public void applyCoupon(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		
        boolean success = false;
		String couponCode = ParamUtil.getString(resourceRequest, "couponCode");
		ShoppingCoupon shoppingCoupon = ShoppingCouponLocalServiceUtil.fetchByCode(couponCode);
		if(shoppingCoupon != null){
			session.setAttribute(ShoppingPortletUtil.SESSION_CART_COUPON_CODE, shoppingCoupon);
		        
	        Map<String,ShoppingOrderItem> shoppingOrderItemMap = (Map<String,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
	        if(shoppingOrderItemMap == null){
	        	shoppingOrderItemMap = new HashMap<String,ShoppingOrderItem>();
	        }
	
	        double total = 0;
	        for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
	        	ShoppingOrderItem orderItem = entry.getValue();
	        	total = total + orderItem.getQuantity() * orderItem.getPrice();
	        }
	        
	        total = ShoppingPortletUtil.applyCoupon(shoppingCoupon, total);
	        
	        jsonObject.put("total", total);
	        success = true;
		}else{
			
		}
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public void removeFromShoppingCart(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean success = true;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		try{
			String articleId = ParamUtil.getString(resourceRequest, "articleId");
			
			Map<String,ShoppingOrderItem> shoppingOrderItemMap = (Map<String,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
			StringBuilder sb = new StringBuilder("");
			
			ShoppingOrderItem shoppingOrderItem = shoppingOrderItemMap.remove(articleId);
			if(shoppingOrderItem == null){
				success = false;
			}
			session.setAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT, shoppingOrderItemMap);
			if(shoppingOrderItemMap != null && !shoppingOrderItemMap.isEmpty()){
				sb.append("<table class='cart-table'><tbody><tr class='table-header'><td></td><td></td><td>PRODUCT</td><td align='center'>QTY</td><td align='right'>PRICE</td></tr>");
					  	
			  	for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
			  		ShoppingOrderItem orderItem = entry.getValue();
			  		JournalArticle journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getScopeGroupId(), orderItem.getArticleId());
			  		sb.append("<tr class='cart-row-").append(orderItem.getArticleId()).append("'><td>a href='javascript:;' data-article-id='")
			  		.append(orderItem.getArticleId()).append("' class='fa fa-times-circle remove-from-shopping-cart-button' title='remove'></a></td><td><img src='")
			  		.append(ShoppingPortletUtil.getMainImageURL(journalArticle)).append("' alt='' class=''cart-item-img'></td><td><strong>")
				    .append(journalArticle.getTitle(themeDisplay.getSiteDefaultLocale())).append("</strong></td><td align='center'><input value='")
				    .append(orderItem.getQuantity()).append("' type='number'/></td><td align='right'>£<span class=''cart-item-price'>")
				    .append(orderItem.getPrice()).append("</span></td></tr>");
				    	
		    	}
					  	
				    
			  	sb.append("</tbody></table>");
			}else{
				sb.append("<h2>Empty Cart</h2>");
			}
		  	jsonObject.put("redraw", sb.toString());
			
			
		}catch(Exception e){
			e.printStackTrace();
			success = false;
		}
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpSession session = request.getSession();

		try{			
			Long orderId = CounterLocalServiceUtil.increment(ShoppingOrder.class.getName());
			ShoppingOrder shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(orderId);

			
			List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
			for(ShoppingOrderItem orderItem: shoppingOrderItemList){
				orderItem.setShoppingOrderItemId(orderId);
			}
			
		}catch(Exception e){
			
		}
		
		super.processAction(actionRequest, actionResponse);

	}
	
	public void checkout( ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
//		Long shoppingOrderId = CounterLocalServiceUtil.increment(ShoppingOrder.class.getName());
//		ShoppingOrder shoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(shoppingOrderId);
//		shoppingOrder.setStatus(ShoppingPortletUtil.ORDER_STATUS_INITIAL);
		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
		}catch(NoSuchShoppingStoreException e){
			shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getScopeGroupId());
		}
		
		Layout checkoutPageLayout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(shoppingStore.getCheckoutPageUuid(), themeDisplay.getScopeGroupId(), false);
		NavItem checkoutPageNavItem = new NavItem(request, checkoutPageLayout, null);
		String redirect = checkoutPageNavItem.getRegularURL();
		redirect = PortalUtil.escapeRedirect(redirect);
		actionResponse.sendRedirect(redirect);
	}
}
