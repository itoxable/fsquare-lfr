package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ShoppingCoupon service. Represents a row in the &quot;FsquareShopping_ShoppingCoupon&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingCouponImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponImpl
 * @see com.fsquare.shopping.model.ShoppingCoupon
 * @generated
 */
public abstract class ShoppingCouponBaseImpl extends ShoppingCouponModelImpl
    implements ShoppingCoupon {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a shopping coupon model instance should use the {@link ShoppingCoupon} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingCouponLocalServiceUtil.addShoppingCoupon(this);
        } else {
            ShoppingCouponLocalServiceUtil.updateShoppingCoupon(this);
        }
    }
}
