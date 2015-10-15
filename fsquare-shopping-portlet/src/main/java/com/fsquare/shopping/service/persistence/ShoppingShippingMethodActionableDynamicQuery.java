package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingShippingMethodActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingShippingMethodActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(ShoppingShippingMethodLocalServiceUtil.getService());
        setClass(ShoppingShippingMethod.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("shippingMethodId");
    }
}
