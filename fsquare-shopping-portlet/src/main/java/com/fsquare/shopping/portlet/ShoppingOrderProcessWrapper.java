package com.fsquare.shopping.portlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.liferay.portal.model.Country;

public class ShoppingOrderProcessWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8891866164950474271L;
	
	
	private Map<String, ShoppingOrderItem> shoppingOrderItemMap = new HashMap<String, ShoppingOrderItem>();
	private ShoppingOrder shoppingOrder;
	private ShoppingCoupon shoppingCoupon;
	private ShoppingShippingMethod shoppingShippingMethod;
	private Country shippingCountry;
	private List<ShoppingShippingMethod> availableShoppingShippingMethodList = new ArrayList<ShoppingShippingMethod>();
	
	
	public ShoppingOrderProcessWrapper(Map<String, ShoppingOrderItem> _shoppingOrderItemMap, ShoppingOrder _shoppingOrder, 
			ShoppingCoupon _shoppingCoupon, ShoppingShippingMethod _shoppingShippingMethod, Country _shippingCountry){
		shoppingOrderItemMap = _shoppingOrderItemMap;
		shoppingOrder = _shoppingOrder;
		shoppingCoupon = _shoppingCoupon;
//		List<ShoppingShippingMethod> availableShoppingShippingMethodList;
		shoppingShippingMethod = _shoppingShippingMethod;
		shippingCountry = _shippingCountry;
	}
	public ShoppingOrderProcessWrapper(){
//		shoppingOrderItemMap = _shoppingOrderItemMap;
//		shoppingOrder = _shoppingOrder;
//		shoppingCoupon = _shoppingCoupon;
////		List<ShoppingShippingMethod> availableShoppingShippingMethodList;
//		shoppingShippingMethod = _shoppingShippingMethod;
//		shippingCountry = _shippingCountry;
	}
	
	public Double getAbsoluteTotal(){
		double total = ShoppingOrderLocalServiceUtil.getOrderTotal(shoppingOrderItemMap.values());
		total = ShoppingCouponLocalServiceUtil.applyCoupon(shoppingCoupon, total);
		if(shoppingShippingMethod != null){
			double shipping = ShoppingShippingMethodLocalServiceUtil.getShippingPrice(shoppingShippingMethod, shoppingOrderItemMap.values(), total);
			total = total + shipping;
		}
		return total;
	}
	
	
	public Double getTotalNoShipping(){
		double total = ShoppingOrderLocalServiceUtil.getOrderTotal(shoppingOrderItemMap.values());
		total = ShoppingCouponLocalServiceUtil.applyCoupon(shoppingCoupon, total);
		return total;
	}
	
	public Double getTotalSimple(){
		double total = ShoppingOrderLocalServiceUtil.getOrderTotal(shoppingOrderItemMap.values());
		return total;
	}
	
	
	public Map<String, ShoppingOrderItem> getShoppingOrderItemMap() {
		return shoppingOrderItemMap;
	}
	public void setShoppingOrderItemMap(Map<String, ShoppingOrderItem> shoppingOrderItemMap) {
		this.shoppingOrderItemMap = shoppingOrderItemMap;
	}
	public ShoppingOrder getShoppingOrder() {
		return shoppingOrder;
	}
	public void setShoppingOrder(ShoppingOrder shoppingOrder) {
		this.shoppingOrder = shoppingOrder;
	}
	public ShoppingCoupon getShoppingCoupon() {
		return shoppingCoupon;
	}
	public void setShoppingCoupon(ShoppingCoupon shoppingCoupon) {
		this.shoppingCoupon = shoppingCoupon;
	}
	public ShoppingShippingMethod getShoppingShippingMethod() {
		return shoppingShippingMethod;
	}
	public void setShoppingShippingMethod(ShoppingShippingMethod shoppingShippingMethod) {
		this.shoppingShippingMethod = shoppingShippingMethod;
	}
	public Country getShippingCountry() {
		return shippingCountry;
	}
	public void setShippingCountry(Country shippingCountry) {
		this.shippingCountry = shippingCountry;
	}
	public List<ShoppingShippingMethod> getAvailableShoppingShippingMethodList() {
		return availableShoppingShippingMethodList;
	}
	public void setAvailableShoppingShippingMethodList(List<ShoppingShippingMethod> availableShoppingShippingMethodList) {
		this.availableShoppingShippingMethodList = availableShoppingShippingMethodList;
	}
}
