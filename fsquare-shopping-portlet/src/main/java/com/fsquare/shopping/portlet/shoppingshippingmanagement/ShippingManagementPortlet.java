package com.fsquare.shopping.portlet.shoppingshippingmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ShippingManagementPortlet extends MVCPortlet{
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_SHIPPING_METHOD)) {
				saveShippingMethod(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_DELETE_SHIPPING_METHOD)) {
				deleteShippingMethod(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_SHIPPING_METHOD)) {
				openShippingMethodForm(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_SET_DEFAULT_SHIPPING_METHOD)) {
				setDefaultShippingMethod(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
		}
	}
	
	private void openShippingMethodForm(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException, SystemException, PortalException {

		Long shippingMethodId = ParamUtil.getLong(resourceRequest, "shippingMethodId");
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
		//System.out.println("couponId: "+couponId);
		ShoppingShippingMethod shoppingShippingMethod = null;
        if(shippingMethodId == null || shippingMethodId == 0){
        	shippingMethodId = CounterLocalServiceUtil.increment(ShoppingShippingMethod.class.getName());
        	shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.createShoppingShippingMethod(0);
	        //shoppingCoupon.setCreateDate(new Date());
        }else{
        	shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shippingMethodId);
        }
		
		String path = "/shopping-shipping-management/shipping-method-form.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		
		resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHIPPING, shoppingShippingMethod);
		dispatcher.include(resourceRequest, resourceResponse);
	}

	private void deleteShippingMethod(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
        
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Long shippingMethodId = ParamUtil.getLong(resourceRequest, "shippingMethodId");
        try {
        	ShoppingShippingMethod shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.deleteShoppingShippingMethod(shippingMethodId);
			success = true;
		} catch (PortalException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-shipping-method"));
		} catch (SystemException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-shipping-method"));
		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	private void setDefaultShippingMethod(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long shippingMethodId = ParamUtil.getLong(resourceRequest, "shippingMethodId");
//		Boolean defaultShipping = ParamUtil.getBoolean(resourceRequest, "defaultShipping"); ;
		try {
			long oldDefaultId = 0L;
			ShoppingShippingMethod defaultShoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.fetchDefaultShipping();
			if(defaultShoppingShippingMethod != null){
				oldDefaultId = defaultShoppingShippingMethod.getShippingMethodId();
				defaultShoppingShippingMethod.setDefaultShipping(false);
				ShoppingShippingMethodLocalServiceUtil.updateShoppingShippingMethod(defaultShoppingShippingMethod);
			}
			ShoppingShippingMethod shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shippingMethodId);
			shoppingShippingMethod.setDefaultShipping(true);
			ShoppingShippingMethodLocalServiceUtil.updateShoppingShippingMethod(shoppingShippingMethod);
			
			jsonObject.put("shoppingShippingMethod", JSONFactoryUtil.looseSerialize(shoppingShippingMethod));
			jsonObject.put("oldDefaultId", oldDefaultId);
			
			success = true;
		} catch (PortalException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-updating-shipping-method"));
		} catch (SystemException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-updating-shipping-method"));
		}
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	private void saveShippingMethod(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = true;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try{
			boolean isNew = false;
	        Long shippingMethodId = ParamUtil.getLong(resourceRequest, "shippingMethodId");

	        String name = ParamUtil.getString(resourceRequest, "name"); 
	        String description = ParamUtil.getString(resourceRequest, "description"); 
	        Boolean defaultShipping = ParamUtil.getBoolean(resourceRequest, "defaultShipping"); 
	        Double price = ParamUtil.getDouble(resourceRequest, "price"); 
	        Double freeTotal = ParamUtil.getDouble(resourceRequest, "freeTotal"); 
	        long freeQuantity = ParamUtil.getLong(resourceRequest, "freeQuantity"); 
	        Double weight = ParamUtil.getDouble(resourceRequest, "weight"); 
	        
	        if(defaultShipping){
	        	ShoppingShippingMethod defaultShoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.fetchDefaultShipping();
				defaultShoppingShippingMethod.setDefaultShipping(false);
				ShoppingShippingMethodLocalServiceUtil.updateShoppingShippingMethod(defaultShoppingShippingMethod);
	        }
	        
	        ShoppingShippingMethod shoppingShippingMethod = null;
	        if(shippingMethodId == null || shippingMethodId == 0){
	        	shippingMethodId = CounterLocalServiceUtil.increment(ShoppingShippingMethod.class.getName());
	        	shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.createShoppingShippingMethod(shippingMethodId);  
	        	shoppingShippingMethod.setGroupId(themeDisplay.getScopeGroupId());
	        	shoppingShippingMethod.setCreateDate(new Date());
	        	shoppingShippingMethod.setCompanyId(themeDisplay.getCompanyId());
	        	shoppingShippingMethod.setUserId(themeDisplay.getUserId());
				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				shoppingShippingMethod.setUserName(user.getLogin());
				isNew = true;

	        }else{
	        	shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shippingMethodId);
	        }
	        
	        jsonObject.put("isNew", isNew);
	        
	        shoppingShippingMethod.setDefaultShipping(defaultShipping);
	        shoppingShippingMethod.setWeight(weight);
	        shoppingShippingMethod.setPrice(price);
	        shoppingShippingMethod.setFreeTotal(freeTotal);
	        shoppingShippingMethod.setFreeQuantity(freeQuantity);
	        shoppingShippingMethod.setName(name);
	        shoppingShippingMethod.setDescription(description);
	        shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.updateShoppingShippingMethod(shoppingShippingMethod);
	        
	        jsonObject.put("shoppingShippingMethodJson", JSONFactoryUtil.looseSerialize(shoppingShippingMethod));
	       
		}catch(SystemException e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-shipping-method"));
		}catch(PortalException e){
			success = false;
		}catch(Exception e){
			success = false;
		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

}
