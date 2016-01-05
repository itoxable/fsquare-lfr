package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.service.ShoppingItemLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingItemActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingItemActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ShoppingItemLocalServiceUtil.getService());
        setClass(ShoppingItem.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("itemId");
    }
}
