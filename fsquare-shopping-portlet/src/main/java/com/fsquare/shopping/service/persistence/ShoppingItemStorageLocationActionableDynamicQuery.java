package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemStorageLocation;
import com.fsquare.shopping.service.ShoppingItemStorageLocationLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingItemStorageLocationActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingItemStorageLocationActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(ShoppingItemStorageLocationLocalServiceUtil.getService());
        setClass(ShoppingItemStorageLocation.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("itemStorageLocationId");
    }
}
