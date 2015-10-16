package com.fsquare.shopping.portlet.minicart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.impl.ShoppingOrderItemImpl;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
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
//		String portletId = PortalUtil.getPortletId(actionRequest);
		
//		PortletSession portletSession = resourceRequest.getPortletSession();
//		PortalUtil.getpo
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = request.getSession();
		int quantity = 0;

		try{
			String entryId = ParamUtil.getString(resourceRequest, "entryId");
			
			List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
			
			ShoppingOrderItem shoppingOrderItem = null;
			if(shoppingOrderItemList == null){
				shoppingOrderItemList = new ArrayList<ShoppingOrderItem>();
			}
			else{
				for(ShoppingOrderItem orderItem: shoppingOrderItemList){
					if(entryId.equals(orderItem.getEntryId())){
						shoppingOrderItem = orderItem;
					}
				}
			}
			
			
			if(shoppingOrderItem == null){
				shoppingOrderItem = new ShoppingOrderItemImpl();
				shoppingOrderItem.setOrderItemId((shoppingOrderItemList.size()+1)*(-1L));
				shoppingOrderItem.setEntryId(entryId);
				shoppingOrderItem.setQuantity(1);
				
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(Long.parseLong(entryId));
				shoppingOrderItem.setName(assetEntry.getTitle(themeDisplay.getSiteDefaultLocale()));
	
				shoppingOrderItemList.add(shoppingOrderItem);
			}else{
				shoppingOrderItem.setQuantity(shoppingOrderItem.getQuantity()+1);
			}
			
			for(ShoppingOrderItem orderItem: shoppingOrderItemList){
				quantity = quantity + orderItem.getQuantity();
			}
			
			session.setAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT, shoppingOrderItemList);
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
}
