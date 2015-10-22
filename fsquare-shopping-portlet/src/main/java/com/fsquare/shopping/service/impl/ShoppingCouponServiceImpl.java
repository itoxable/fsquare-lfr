package com.fsquare.shopping.service.impl;

import java.util.List;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.service.base.ShoppingCouponServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

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
	
	public ShoppingCoupon fetchByCode(String code){
		try {
			return shoppingCouponPersistence.fetchByCode(code);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
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
}
