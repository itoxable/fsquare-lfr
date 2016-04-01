package com.fsquare.shopping.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.fsquare.shopping.ShoppingUtil;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.model.impl.ShoppingCouponImpl;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.base.ShoppingCouponServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the shopping coupon remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingCouponService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingCouponServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingCouponServiceUtil
 */
public class ShoppingCouponServiceImpl extends ShoppingCouponServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingCouponServiceUtil} to access the shopping coupon remote service.
     */
	
	public Map<Locale, String> testMap(Map<Locale, String> map){
		return map;
	}
	
	public ShoppingCoupon fetchByCodeAndGroupId(String code, long groupId){
		try {
			return shoppingCouponPersistence.fetchByCodeAndGroupId(code, groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ShoppingCoupon> findByGroupId(Long groupId){
		try {
			return shoppingCouponPersistence.findByGroupId(groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	public boolean isCouponValid(ShoppingCoupon shoppingCoupon){
		return shoppingCouponLocalService.isCouponValid(shoppingCoupon);
	}
	
	public String getCouponStatus(ShoppingCoupon shoppingCoupon){
		return shoppingCouponLocalService.getCouponStatus(shoppingCoupon);
	}
	
	@Override
	public List<ShoppingCoupon> findByGroupIdStartEnd(Long groupId, int start, int end){
		try {
			return shoppingCouponPersistence.findByGroupId(groupId, start, end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int countByGroupId(Long groupId){
		try {
			return shoppingCouponPersistence.countByGroupId(groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Map<String, Object> getPagedItems(Long groupId, int start, int end){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer total = shoppingCouponPersistence.countByGroupId(groupId);
			List<ShoppingCoupon> items = shoppingCouponPersistence.findByGroupId(groupId, start, end);
			result.put("total", total.toString());
			result.put("items", items);
			result.put("quant", items.size());
			result.put("start", start);
			result.put("end", end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void updateShoppingCoupon(long couponId, long groupId, String code, String name, 
			String description, Date startDate, Date endDate, boolean active, String limitCategories, String limitSkus, 
			double minOrder, double discount, String discountType, long maxUses, long userid, long companyId) throws SystemException, PortalException{
		
		Date date = new Date();
		ShoppingCoupon shoppingCoupon = null;
		if(Validator.isNotNull(couponId)){
			shoppingCoupon = shoppingCouponLocalService.getShoppingCoupon(couponId);
		}else{
			couponId = CounterLocalServiceUtil.increment(ShoppingCoupon.class.getName());
			shoppingCoupon = shoppingCouponLocalService.createShoppingCoupon(couponId);	        
			shoppingCoupon.setGroupId(groupId);
			shoppingCoupon.setCreateDate(date);
			shoppingCoupon.setCompanyId(companyId);
			shoppingCoupon.setUserId(userid);
		}
		
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
        shoppingCoupon.setModifiedDate(date);
		 
		shoppingCouponLocalService.updateShoppingCoupon(shoppingCoupon);
		
	}
	
	public ShoppingCoupon deleteCoupon(long couponId) throws SystemException, PortalException{
		ShoppingCoupon shoppingCoupon = shoppingCouponPersistence.remove(couponId);
		return shoppingCoupon;
	}
	
	@Override
	public ShoppingCoupon updateShoppingCoupon(ShoppingCoupon shoppingCoupon) throws SystemException, PortalException{
		
		Date date = new Date();

		if(shoppingCoupon.isNew()){
			long couponId = CounterLocalServiceUtil.increment(ShoppingCoupon.class.getName());
			shoppingCoupon.setCouponId(couponId);

			shoppingCoupon.setCreateDate(date);
//			shoppingCoupon.setCompanyId(companyId);
//			shoppingCoupon.setUserId(userid);
		}else{
			//couponId = CounterLocalServiceUtil.increment(ShoppingCoupon.class.getName());
//			shoppingCoupon = shoppingCouponLocalService.createShoppingCoupon(couponId);	        
			
		}
		shoppingCoupon.setModifiedDate(date);
        
		shoppingCoupon = shoppingCouponLocalService.updateShoppingCoupon(shoppingCoupon);
        
		return shoppingCoupon;
	}
	
	
}
