package com.fsquare.shopping.portlet.inventorymanagement;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.model.ShoppingItemType;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingItemLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingItemTypeLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class InventoryManagementPortlet extends MVCPortlet{
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_SHOPPING_ITEM_FORM)) {
				openShoppingItemForm(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_SHOPPING_ITEM_TYPE_FORM)) {
				openShoppingItemTypeForm(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_SHOPPING_ITEM_TYPE)) {
				saveShoppingItem(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_SHOPPING_ITEM)) {
				saveShoppingItemType(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_DELETE_SHOPPING_ITEM_TYPE)) {
				deleteShoppingItemType(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_DELETE_SHOPPING_ITEM)) {
				deleteShoppingItem(resourceRequest, resourceResponse);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveShoppingItem(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = true;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try{
			boolean isNew = false;
	        Long itemId = ParamUtil.getLong(resourceRequest, "itemId");
	        String name = ParamUtil.getString(resourceRequest, "name"); 
	        String description = ParamUtil.getString(resourceRequest, "description"); 
	        Double price = ParamUtil.getDouble(resourceRequest, "price"); 
	        Double discountPrice = ParamUtil.getDouble(resourceRequest, "discountPrice"); 
	        String sku = ParamUtil.getString(resourceRequest, "sku"); 
	        long itemTypeId = ParamUtil.getLong(resourceRequest, "itemTypeId"); 

	        
	        UploadPortletRequest uploadrequest = PortalUtil.getUploadPortletRequest(resourceRequest);
	        File image1 = uploadrequest.getFile("image1");
	        //uploadrequest.get
	        String imageURL1 = ParamUtil.getString(resourceRequest, "imageURL1");
	        if(Validator.isNotNull(imageURL1)){
	        	HttpUtil.URLtoByteArray(imageURL1);
	        }
	        List<byte[]> images = new ArrayList<byte[]>();
	        images.add(FileUtil.getBytes(image1));
	        
	        ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
			serviceContext.setCompanyId(themeDisplay.getCompanyId());
	        User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
	        
	        ShoppingItem shoppingItem = null;
	        if(itemId == null || itemId == 0){
	        	Date createDate = new Date();
	        	itemId = CounterLocalServiceUtil.increment(ShoppingItem.class.getName());
	        	shoppingItem = ShoppingItemLocalServiceUtil.createShoppingItem(itemId);  
	        	shoppingItem.setGroupId(themeDisplay.getScopeGroupId());
	        	shoppingItem.setCreateDate(createDate);
	        	shoppingItem.setCompanyId(themeDisplay.getCompanyId());
	        	shoppingItem.setUserId(themeDisplay.getUserId());
				shoppingItem.setUserName(user.getLogin());
				shoppingItem.setUserUuid(PortalUUIDUtil.generate());
				isNew = true;
				serviceContext.setCreateDate(createDate);

	        }else{
	        	shoppingItem = ShoppingItemLocalServiceUtil.getShoppingItem(itemId);
	        }
	        
	        serviceContext.setUuid(shoppingItem.getUuid());
	        jsonObject.put("isNew", isNew);
	        
	        shoppingItem.setPrice(price);
	        shoppingItem.setName(name);
	        shoppingItem.setDescription(description);
	        shoppingItem.setDiscountPrice(discountPrice);
	        shoppingItem.setSku(sku);
	        shoppingItem.setItemTypeId(itemTypeId);
	        
	        
	        if(isNew){
	        	shoppingItem = ShoppingItemLocalServiceUtil.addShoppingItem(shoppingItem, themeDisplay.getUserId(), images, serviceContext);
	        }else{
	        	shoppingItem = ShoppingItemLocalServiceUtil.updateShoppingItem(shoppingItem);
	        }
	        
	        jsonObject.put("shoppingItem", JSONFactoryUtil.looseSerialize(shoppingItem));
	       
		}catch(SystemException e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-shopping-item"));
		}catch(PortalException e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-shopping-item"));
		}catch(Exception e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-shopping-item"));
		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
		
	}

	private void saveShoppingItemType(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = true;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try{
			boolean isNew = false;
	        Long itemTypeId = ParamUtil.getLong(resourceRequest, "itemTypeId");
	        String name = ParamUtil.getString(resourceRequest, "name"); 
	        String description = ParamUtil.getString(resourceRequest, "description"); 
	        

	        
	        ShoppingItemType shoppingItemType = null;
	        if(itemTypeId == null || itemTypeId == 0){
	        	itemTypeId = CounterLocalServiceUtil.increment(ShoppingItem.class.getName());
	        	shoppingItemType = ShoppingItemTypeLocalServiceUtil.createShoppingItemType(itemTypeId);  
	        	shoppingItemType.setGroupId(themeDisplay.getScopeGroupId());
	        	shoppingItemType.setCreateDate(new Date());
	        	shoppingItemType.setCompanyId(themeDisplay.getCompanyId());
	        	shoppingItemType.setUserId(themeDisplay.getUserId());
				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				shoppingItemType.setUserName(user.getLogin());
				isNew = true;

	        }else{
	        	shoppingItemType = ShoppingItemTypeLocalServiceUtil.getShoppingItemType(itemTypeId);
	        }
	        
	        jsonObject.put("isNew", isNew);
	        
	        shoppingItemType.setName(name);
	        shoppingItemType.setDescription(description);
	        shoppingItemType = ShoppingItemTypeLocalServiceUtil.updateShoppingItemType(shoppingItemType);
	        
	        jsonObject.put("shoppingItemType", JSONFactoryUtil.looseSerialize(shoppingItemType));
	       
		}catch(SystemException e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-shopping-item-type"));
		}catch(PortalException e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-shopping-item-type"));
		}catch(Exception e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-shopping-item-type"));
		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}


	private void deleteShoppingItemType(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
        
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Long itemTypeId = ParamUtil.getLong(resourceRequest, "itemTypeId");
        try {
			ShoppingItemType shoppingItemType = ShoppingItemTypeLocalServiceUtil.deleteShoppingItemType(itemTypeId);
			success = true;
		} catch (PortalException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-item-type"));
		} catch (SystemException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-item-type"));
		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	private void deleteShoppingItem(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
        
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Long itemId = ParamUtil.getLong(resourceRequest, "itemId");
        try {
			ShoppingItem shoppingItem = ShoppingItemLocalServiceUtil.deleteShoppingItem(itemId);
			success = true;
		} catch (PortalException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-item"));
		} catch (SystemException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-item"));
		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	private void openShoppingItemForm(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException, SystemException, PortalException {

		Long itemId = ParamUtil.getLong(resourceRequest, "itemId");
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();

		ShoppingItem shoppingItem = null;
        if(itemId == null || itemId == 0){
        	itemId = CounterLocalServiceUtil.increment(ShoppingItem.class.getName());
        	shoppingItem = ShoppingItemLocalServiceUtil.createShoppingItem(0);
        }else{
        	shoppingItem = ShoppingItemLocalServiceUtil.getShoppingItem(itemId);
        }
		
		String path = "/inventory-management/inventory-item-form.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		
		resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHOPPING_ITEM, shoppingItem);
		dispatcher.include(resourceRequest, resourceResponse);
	}

	
	private void openShoppingItemTypeForm(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException, SystemException, PortalException {

		Long itemTypeId = ParamUtil.getLong(resourceRequest, "itemTypeId");
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();

		ShoppingItemType shoppingItemType = null;
        if(itemTypeId == null || itemTypeId == 0){
        	itemTypeId = CounterLocalServiceUtil.increment(ShoppingItemType.class.getName());
        	shoppingItemType = ShoppingItemTypeLocalServiceUtil.createShoppingItemType(0);
        }else{
        	shoppingItemType = ShoppingItemTypeLocalServiceUtil.getShoppingItemType(itemTypeId);
        }
		
		String path = "/inventory-management/inventory-item-type-form.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		
		resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_SHOPPING_ITEM_TYPE, shoppingItemType);
		dispatcher.include(resourceRequest, resourceResponse);
	}
}
