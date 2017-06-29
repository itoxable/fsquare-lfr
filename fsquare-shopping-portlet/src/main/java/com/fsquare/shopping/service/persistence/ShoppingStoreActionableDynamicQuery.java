package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ShoppingStoreActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ShoppingStoreActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ShoppingStoreLocalServiceUtil.getService());
        setClass(ShoppingStore.class);

        setClassLoader(com.fsquare.shopping.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("companyId");
    }
}
