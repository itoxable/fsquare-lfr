package com.fsquare.shopping.portlet.shoppingcouponmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CouponManagementPortlet extends MVCPortlet{
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals(ShoppingPortletUtil.CMD_SAVE_COUPON)) {
				saveCoupon(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_DELETE_COUPON)) {
				deleteCoupon(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_OPEN_COUPON_FORM)) {
				openCouponForm(resourceRequest, resourceResponse);
			}else if (cmd.equals(ShoppingPortletUtil.CMD_ACTIVATE_COUPON)) {
				activateCoupon(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
		}
	}
	
	private void openCouponForm(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException, SystemException, PortalException {

		Long couponId = ParamUtil.getLong(resourceRequest, "couponId");
		PortletContext portletContext = resourceRequest.getPortletSession().getPortletContext();
		//System.out.println("couponId: "+couponId);
		ShoppingCoupon shoppingCoupon = null;
        if(couponId == null || couponId == 0){
	        couponId = CounterLocalServiceUtil.increment(ShoppingCoupon.class.getName());
	        shoppingCoupon = ShoppingCouponLocalServiceUtil.createShoppingCoupon(0);
	        //shoppingCoupon.setCreateDate(new Date());
        }else{
        	shoppingCoupon = ShoppingCouponLocalServiceUtil.getShoppingCoupon(couponId);
        }
		
		String path = "/shopping-coupon-management/coupon-form.jsp";
		PortletRequestDispatcher dispatcher = portletContext.getRequestDispatcher(path);
		
		resourceRequest.setAttribute(ShoppingPortletUtil.ATTR_COUPON, shoppingCoupon);
		dispatcher.include(resourceRequest, resourceResponse);
	}

	private void deleteCoupon(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
        
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Long couponId = ParamUtil.getLong(resourceRequest, "couponId");
        try {
			ShoppingCoupon shoppingCoupon = ShoppingCouponLocalServiceUtil.deleteShoppingCoupon(couponId);
			success = true;
		} catch (PortalException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-coupon"));
		} catch (SystemException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-deleting-coupon"));
		}
        jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}

	private void activateCoupon(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long couponId = ParamUtil.getLong(resourceRequest, "couponId");
		Boolean active = ParamUtil.getBoolean(resourceRequest, "activate"); ;
		try {
			ShoppingCoupon shoppingCoupon = ShoppingCouponLocalServiceUtil.getShoppingCoupon(couponId);
			shoppingCoupon.setActive(active);
			shoppingCoupon = ShoppingCouponLocalServiceUtil.updateShoppingCoupon(shoppingCoupon);
			jsonObject.put("shoppingCouponJson", JSONFactoryUtil.looseSerialize(shoppingCoupon));
			success = true;
		} catch (PortalException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-updating-coupon"));
		} catch (SystemException e) {
			e.printStackTrace();
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-updating-coupon"));
		}
		jsonObject.put("success", success);
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
	}
	
	private void saveCoupon(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        boolean success = true;
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try{
			boolean isNew = false;
	        Long couponId = ParamUtil.getLong(resourceRequest, "couponId");
	        String code = ParamUtil.getString(resourceRequest, "code");
	        
	        ShoppingCoupon existingShoppingCoupon = ShoppingCouponLocalServiceUtil.fetchByCode(code);
	        if(existingShoppingCoupon == null || (existingShoppingCoupon.getCouponId() == couponId)){
		        String name = ParamUtil.getString(resourceRequest, "name"); 
		        String description = ParamUtil.getString(resourceRequest, "description"); 
		        Date startDate = ParamUtil.getDate(resourceRequest, "startDate", DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy")); 
		        Date endDate = ParamUtil.getDate(resourceRequest, "endDate", DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy")); 
		        Boolean active = ParamUtil.getBoolean(resourceRequest, "active"); 
		        String limitCategories = ParamUtil.getString(resourceRequest, "limitCategories"); 
		        String limitSkus = ParamUtil.getString(resourceRequest, "limitSkus");
		        Double minOrder = ParamUtil.getDouble(resourceRequest, "minOrder"); 
		        Double discount = ParamUtil.getDouble(resourceRequest, "discount"); 
		        String discountType = ParamUtil.getString(resourceRequest, "discountType"); 
		        
		        ShoppingCoupon shoppingCoupon = null;
		        if(couponId == null || couponId == 0){
			        couponId = CounterLocalServiceUtil.increment(ShoppingCoupon.class.getName());
			        shoppingCoupon = ShoppingCouponLocalServiceUtil.createShoppingCoupon(couponId);	        
					shoppingCoupon.setGroupId(themeDisplay.getScopeGroupId());
					shoppingCoupon.setCreateDate(new Date());
					shoppingCoupon.setCompanyId(themeDisplay.getCompanyId());
					shoppingCoupon.setUserId(themeDisplay.getUserId());
					User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
					shoppingCoupon.setUserName(user.getLogin());
					isNew = true;

		        }else{
		        	shoppingCoupon = ShoppingCouponLocalServiceUtil.getShoppingCoupon(couponId);
		        }
		        
		        jsonObject.put("isNew", isNew);
		        
		        shoppingCoupon.setActive(active);
		        shoppingCoupon.setCode(code);
		        shoppingCoupon.setName(name);
		        shoppingCoupon.setDescription(description);
		        shoppingCoupon.setStartDate(startDate);
		        shoppingCoupon.setEndDate(endDate);
		        shoppingCoupon.setLimitCategories(limitCategories);
		        shoppingCoupon.setLimitSkus(limitSkus);
		        shoppingCoupon.setMinOrder(minOrder);
		        shoppingCoupon.setDiscount(discount);
		        shoppingCoupon.setDiscountType(discountType);
		        shoppingCoupon.setModifiedDate(new Date());
		        
		        shoppingCoupon = ShoppingCouponLocalServiceUtil.updateShoppingCoupon(shoppingCoupon);
		        
		        jsonObject.put("shoppingCouponJson", JSONFactoryUtil.looseSerialize(shoppingCoupon));
	        }else{
	        	success = false;
				jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "coupon-code-already-exists"));
	        }
		}catch(SystemException e){
			success = false;
			jsonObject.put("errorMessage", LanguageUtil.get(themeDisplay.getLocale(), "error-saving-coupon"));
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
