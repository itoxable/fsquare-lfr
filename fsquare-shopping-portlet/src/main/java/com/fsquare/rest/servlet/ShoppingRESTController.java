package com.fsquare.rest.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.http.HttpStatus;

import com.fsquare.shopping.ShoppingUtil;
import com.fsquare.shopping.model.ShoppingCouponSoap;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.model.ShoppingStoreSoap;
import com.fsquare.shopping.model.impl.ShoppingStoreModelImpl;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanySoap;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;

@Controller
public class ShoppingRESTController{

	
	@RequestMapping(value = "/store/groupId/{groupId}", method=RequestMethod.GET)
	@JsonView(ShoppingStoreSoap.class)
	public @ResponseBody List<ShoppingStoreSoap> shoppingStore(@PathVariable("groupId") Long groupId, HttpServletRequest request) throws SystemException {
		ShoppingStore shoppingStore = ShoppingStoreLocalServiceUtil.fetchShoppingStore(groupId);
		ShoppingStoreSoap shoppingStoreSoap = ShoppingStoreSoap.toSoapModel(shoppingStore);
		List<ShoppingStoreSoap> layoutsKeyValuePair = new ArrayList<ShoppingStoreSoap>();
		layoutsKeyValuePair.add(shoppingStoreSoap);
		return layoutsKeyValuePair;
	}
	
	
	@RequestMapping(value = "/shoppinglayouts/groupId/{groupId}", method=RequestMethod.GET)
	public @ResponseBody List<KeyValuePair> shoppingLayouts(@PathVariable("groupId") Long groupId, HttpServletRequest request) throws SystemException {
		
		Locale locale = LocaleUtil.getDefault();
		List<KeyValuePair> layoutsKeyValuePair = new ArrayList<KeyValuePair>();

		try {
			List<Layout> layoutsTemp = LayoutLocalServiceUtil.getLayouts(groupId, false);
			for(Layout lay : layoutsTemp){
				layoutsKeyValuePair.add(new KeyValuePair(lay.getUuid(), ShoppingUtil.getLayoutBreadcrumb(lay, locale)));
			}
			
			
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return layoutsKeyValuePair;
		
	}
	
	
	
	@RequestMapping(value = "/store/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ShoppingStoreSoap saveShoppingStore(@RequestBody ShoppingStoreSoap shoppingStoreSoap) throws SystemException {
		ShoppingStore shoppingStore = ShoppingStoreModelImpl.toModel(shoppingStoreSoap);
		shoppingStore =  ShoppingStoreLocalServiceUtil.addShoppingStore(shoppingStore);
		shoppingStoreSoap = ShoppingStoreSoap.toSoapModel(shoppingStore);
		return shoppingStoreSoap;
		
	}
	
	@RequestMapping(value = "/store", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ShoppingStore createSample(@RequestBody ShoppingStore shoppingStore) throws SystemException {
		ShoppingStore createdObject = ShoppingStoreLocalServiceUtil.addShoppingStore(shoppingStore);
		return createdObject;
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)  
	@ExceptionHandler(SystemException.class)
	public void handleConflict(SystemException se) {
	    if(se.getCause() instanceof ORMException){
	    	throw (ORMException) se.getCause();
	    }
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler(ORMException.class)
	public void handleBadRequest(SystemException se) {
	    
	}
}
