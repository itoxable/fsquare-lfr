package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemType;
import com.fsquare.shopping.service.ShoppingItemTypeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingItemTypeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingItemTypeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ShoppingItemTypeLocalServiceUtil.getService());
        setClass(ShoppingItemType.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("itemTypeId");
    }
}
