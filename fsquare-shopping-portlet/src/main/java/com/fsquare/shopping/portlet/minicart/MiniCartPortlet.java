package com.fsquare.shopping.portlet.minicart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.model.impl.ShoppingOrderItemImpl;
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
			}
			
		}
		catch (Exception e) {
		}
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
			
			Map<String,ShoppingOrderItem> shoppingOrderItemMap = (Map<String,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
			
			ShoppingOrderItem shoppingOrderItem = null;
			if(shoppingOrderItemMap == null){
				shoppingOrderItemMap = new HashMap<String, ShoppingOrderItem>();
			}
			else{
				shoppingOrderItem = shoppingOrderItemMap.get(articleId);
			}
			
			
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
			
			session.setAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT, shoppingOrderItemMap);
			
			
			ShoppingStore shoppingStore = null;
			try{
				shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
			}catch(NoSuchShoppingStoreException e){
				shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getScopeGroupId());
			}
			
			jsonObject.put("redirect", ShoppingPortletUtil.ON_ADD_TO_CART_JUMP_TO_CART.equals(shoppingStore.getOnAddToCart()));
			
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
			
		journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getScopeGroupId(), articleId);
		
		return journalArticle;
	}
}
