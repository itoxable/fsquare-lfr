package com.fsquare.shopping.service.impl;

import java.util.Calendar;
import java.util.List;

import com.fsquare.shopping.ShoppingUtil;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.base.ShoppingCouponLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the shopping coupon local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingCouponLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingCouponLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil
 */
public class ShoppingCouponLocalServiceImpl
    extends ShoppingCouponLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil} to access the shopping coupon local service.
     */
	
	//@Override
	public ShoppingCoupon fetchByCodeAndGroupId(String code, long groupId){
		try {
			return shoppingCouponPersistence.fetchByCodeAndGroupId(code, groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ShoppingCoupon> findByGroupId(Long groupId){
		try {
			return shoppingCouponPersistence.findByGroupId(groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public boolean isCouponValid(ShoppingCoupon shoppingCoupon){
		if(shoppingCoupon == null){
			return false;
		}
		
		if(!shoppingCoupon.isActive()){
			return false;
		}
		
		Calendar calendar = Calendar.getInstance();

		boolean started = calendar.getTimeInMillis() >= shoppingCoupon.getStartDate().getTime();
		boolean ended = calendar.getTimeInMillis() >= shoppingCoupon.getEndDate().getTime();

		if(started && !ended){
			return true;
		}
		
		return false;
	}

	public String getCouponStatus(ShoppingCoupon shoppingCoupon){
		
		if(shoppingCoupon == null){
			return "";
		}
		
		Calendar calendar = Calendar.getInstance();

		boolean started = calendar.getTimeInMillis() >= shoppingCoupon.getStartDate().getTime();
		boolean ended = calendar.getTimeInMillis() >= shoppingCoupon.getEndDate().getTime();

		if(started && !ended){
			return ShoppingUtil.COUNPON_STATE_RUNNING;
		}else if(ended){
			return ShoppingUtil.COUNPON_STATE_EXPIRED;
		}else if(!started){
			return ShoppingUtil.COUNPON_STATE_NOT_STARTED;
		}
		
		return ShoppingUtil.COUNPON_STATE_RUNNING;
	}
	
	public Double applyCoupon(ShoppingCoupon shoppingCoupon, Double total){
		if(shoppingCoupon == null || !isCouponValid(shoppingCoupon)){
			return total;
		}
		Double discount = shoppingCoupon.getDiscount();
        String discountType = shoppingCoupon.getDiscountType();
        
        if(discountType.equals(ShoppingUtil.DISCOUNT_TYPE_PERCENTAGE)){
        	total = total * (1-(discount/100));
        }else if(discountType.equals(ShoppingUtil.DISCOUNT_TYPE_VALUE)){
        	total = total - discount;
        }
        return total;
	}
}
