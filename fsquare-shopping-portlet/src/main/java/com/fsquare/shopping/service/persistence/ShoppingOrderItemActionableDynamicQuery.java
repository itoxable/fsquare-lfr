package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingOrderItemActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingOrderItemActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ShoppingOrderItemLocalServiceUtil.getService());
        setClass(ShoppingOrderItem.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("orderItemId");
    }
}
