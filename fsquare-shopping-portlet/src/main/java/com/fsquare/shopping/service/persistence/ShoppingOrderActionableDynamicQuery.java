package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingOrderActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingOrderActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ShoppingOrderLocalServiceUtil.getService());
        setClass(ShoppingOrder.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("orderId");
    }
}
