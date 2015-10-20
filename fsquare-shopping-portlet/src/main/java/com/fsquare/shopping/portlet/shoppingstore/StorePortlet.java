package com.fsquare.shopping.portlet.shoppingstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsquare.shopping.NoSuchShoppingStoreException;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class StorePortlet extends MVCPortlet{
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_STORE)) {
				saveStore(resourceRequest, resourceResponse);
			}
			
			
		}
		catch (Exception e) {
		}
	}

	private void saveStore(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = true;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ShoppingStore shoppingStore = null;
		try{
			shoppingStore = ShoppingStoreLocalServiceUtil.getShoppingStore(themeDisplay.getScopeGroupId());
		}catch(NoSuchShoppingStoreException e){
			shoppingStore = ShoppingStoreLocalServiceUtil.createShoppingStore(themeDisplay.getScopeGroupId());
			
			shoppingStore.setCreateDate(new Date());
			shoppingStore.setCompanyId(themeDisplay.getCompanyId());
			shoppingStore.setUserId(themeDisplay.getUserId());
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			shoppingStore.setUserName(user.getLogin());
			
		}
		shoppingStore.setModifiedDate(new Date());
		
		String checkoutDisplayPage = ParamUtil.getString(resourceRequest, "checkoutDisplayPage"); 
		shoppingStore.setCheckoutPageUuid(checkoutDisplayPage);
        String cartDisplayPage = ParamUtil.getString(resourceRequest, "cartDisplayPage");  
		shoppingStore.setCartPageUuid(cartDisplayPage);
		String currency = ParamUtil.getString(resourceRequest, "currency");  
		shoppingStore.setCurrency(currency);
		String onAddToCart = ParamUtil.getString(resourceRequest, "onAddToCart");  
		shoppingStore.setOnAddToCart(onAddToCart);
		
		ShoppingStoreLocalServiceUtil.updateShoppingStore(shoppingStore);
		
		
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
}
