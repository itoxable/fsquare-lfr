package com.fsquare.shopping.portlet.minicart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fsquare.shopping.NoSuchShoppingStoreException;
import com.fsquare.shopping.ShoppingUtil;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.model.impl.ShoppingOrderItemImpl;
import com.fsquare.shopping.portlet.ShoppingOrderProcessWrapper;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.NavItem;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.NoSuchEntryException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MiniCartPortlet extends MVCPortlet {
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_ADD_TO_CART)) {
				addToCart(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_STRIPE_WEBHOOK)) {
				stripeWebhook(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_BRAINTREE_WEBHOOK)) {
				braintreeWebhook(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
		}
	}
	
	
	private void braintreeWebhook(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		System.out.println("BRAINTREE WEBHOOK");
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        String data = resourceRequest.getParameter("data");
        
        Map<String, String> dataMap = new HashMap<String, String>();
        String[] queryString = data.split("&");
        for(String d: queryString){
        	String[] val = d.split("=");
        	dataMap.put(val[0], val[1]);
        }
        
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
        	System.out.println(entry.getKey()+": "+entry.getValue());
		}
        
        
        //        request.queryParams("bt_signature"),
//        request.queryParams("bt_payload")
        //http://localhost:8080/web/guest/home/-/store/braintree-webhook?bt_signature=jduschdjdc&bt_payload=7663636
        System.out.println(data);
        jsonObject.put("braintree", "BRAINTREE WEBHOOK");
		
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	private void stripeWebhook(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		System.out.println("STRIPE WEBHOOK");
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        
        jsonObject.put("stripe", "STRIPE WEBHOOK");
		
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public void addToCart(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean success = true;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		int quantity = 0;

		try{
			String articleId = ParamUtil.getString(resourceRequest, "articleId");
			ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);
			Map<String, ShoppingOrderItem> shoppingOrderItemMap = shoppingOrderProcessWrapper.getShoppingOrderItemMap();
			
			ShoppingOrderItem shoppingOrderItem = shoppingOrderItemMap.get(articleId);
			
			if(shoppingOrderItem == null){
				
				JournalArticle journalArticle = findAssetEntry(articleId, themeDisplay);
				if(journalArticle == null){
					success = false;
				}else{
					
					Map<String, String> product = ShoppingPortletUtil.getProductDetails(journalArticle);
					
					shoppingOrderItem = new ShoppingOrderItemImpl();
					shoppingOrderItem.setShoppingOrderId((shoppingOrderItemMap.size()+1)*(-1L));
					shoppingOrderItem.setArticleId(articleId);
					shoppingOrderItem.setQuantity(1);
					shoppingOrderItem.setPrice(Double.parseDouble(product.get(ShoppingPortletUtil.PRODUCT_PRICE)));
					
					shoppingOrderItem.setName(journalArticle.getTitle(themeDisplay.getSiteDefaultLocale()));
		
					shoppingOrderItemMap.put(articleId, shoppingOrderItem);
				}
			}else{
				shoppingOrderItem.setQuantity(shoppingOrderItem.getQuantity()+1);
			}
			
			for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
				quantity = quantity + entry.getValue().getQuantity();
			}
			
			//session.setAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT, shoppingOrderItemMap);
			
			
			ShoppingStore shoppingStore = null;
			try{
				shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getCompanyId());
			}catch(NoSuchShoppingStoreException e){
				shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getCompanyId());
			}
			
			jsonObject.put("redirect", ShoppingUtil.ON_ADD_TO_CART_JUMP_TO_CART.equals(shoppingStore.getOnAddToCart()));
			
		}catch(Exception e){
			e.printStackTrace();
			success = false;
		}
		jsonObject.put("success", success);
		jsonObject.put("size", Integer.toString(quantity));
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	private JournalArticle findAssetEntry(String articleId, ThemeDisplay themeDisplay) throws PortalException, SystemException{
		JournalArticle journalArticle = null;
			
		journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getCompanyId(), articleId);
		
		return journalArticle;
	}
}
