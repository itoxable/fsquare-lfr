package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingStorageLocation;
import com.fsquare.shopping.service.ShoppingStorageLocationLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingStorageLocationActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingStorageLocationActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(ShoppingStorageLocationLocalServiceUtil.getService());
        setClass(ShoppingStorageLocation.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("storageLocationId");
    }
}
