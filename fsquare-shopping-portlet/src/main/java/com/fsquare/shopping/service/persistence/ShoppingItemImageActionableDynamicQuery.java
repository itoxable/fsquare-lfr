package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemImage;
import com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingItemImageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingItemImageActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ShoppingItemImageLocalServiceUtil.getService());
        setClass(ShoppingItemImage.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("shoppingItemImageId");
    }
}
