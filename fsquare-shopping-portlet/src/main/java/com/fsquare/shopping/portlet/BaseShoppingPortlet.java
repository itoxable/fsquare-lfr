package com.fsquare.shopping.portlet;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BaseShoppingPortlet extends MVCPortlet {
	
	@SuppressWarnings("unchecked")
	protected void applyCoupon(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		
        boolean success = false;
		String couponCode = ParamUtil.getString(resourceRequest, "couponCode");
		
		ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
		ShoppingCoupon shoppingCoupon = shoppingOrderProcessWrapper.getShoppingCoupon();
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(Validator.isNotNull(couponCode)){
			if(shoppingCoupon == null || !couponCode.equals(shoppingCoupon.getCode())){
				shoppingCoupon = ShoppingCouponLocalServiceUtil.fetchByCodeAndCompanyId(couponCode, themeDisplay.getCompanyId());
				
				if(shoppingCoupon != null){
					
					shoppingOrderProcessWrapper.setShoppingCoupon(shoppingCoupon);
			        double total = ShoppingOrderLocalServiceUtil.getOrderTotal(shoppingOrderProcessWrapper.getShoppingOrderItemMap().values());
			        
			        total = ShoppingCouponLocalServiceUtil.applyCoupon(shoppingCoupon, total);
			        jsonObject.put("shoppingCouponJson", JSONFactoryUtil.looseSerialize(shoppingCoupon));
			        jsonObject.put("total", total);
			        success = true;
					
				}
			}
		}else{
			return;
		}
		
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	@SuppressWarnings("unchecked")
	protected void removeFromShoppingCart(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean success = true;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		try{
			String articleId = ParamUtil.getString(resourceRequest, "articleId");
			
			ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);

			
			//Map<String, ShoppingOrderItem> shoppingOrderItemMap = ShoppingPortletUtil.getSessionShoppingOrderItemMap(session);
			StringBuilder sb = new StringBuilder("");
			
			ShoppingOrderItem shoppingOrderItem = shoppingOrderProcessWrapper.getShoppingOrderItemMap().remove(articleId);
			if(shoppingOrderItem == null){
				success = false;
			}
			Map<String, ShoppingOrderItem> shoppingOrderItemMap = shoppingOrderProcessWrapper.getShoppingOrderItemMap();
			//session.setAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT, shoppingOrderItemMap);
			
			if(shoppingOrderItemMap != null && !shoppingOrderItemMap.isEmpty()){
				sb.append("<table class='cart-table'><tbody><tr class='table-header'><td></td><td></td><td>PRODUCT</td><td align='center'>QTY</td><td align='right'>PRICE</td></tr>");
			  	for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
			  		ShoppingOrderItem orderItem = entry.getValue();
			  		JournalArticle journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getCompanyId(), orderItem.getArticleId());
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
	protected void updateCart(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
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
			
			ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);

			
			Map<String, ShoppingOrderItem> shoppingOrderItemMap = shoppingOrderProcessWrapper.getShoppingOrderItemMap();
	
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
}
