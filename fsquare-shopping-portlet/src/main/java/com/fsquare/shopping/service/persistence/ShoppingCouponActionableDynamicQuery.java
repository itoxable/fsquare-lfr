package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingCouponActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingCouponActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ShoppingCouponLocalServiceUtil.getService());
        setClass(ShoppingCoupon.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("couponId");
    }
}
