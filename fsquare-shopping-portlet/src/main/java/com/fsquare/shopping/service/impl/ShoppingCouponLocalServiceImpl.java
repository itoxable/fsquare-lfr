package com.fsquare.shopping.service.impl;

import java.util.List;

import com.fsquare.shopping.model.ShoppingCoupon;
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
	public ShoppingCoupon fetchByCode(String code){
		try {
			return shoppingCouponPersistence.fetchByCode(code);
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
}
