package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingItemTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemTypeService
 * @generated
 */
public class ShoppingItemTypeServiceWrapper implements ShoppingItemTypeService,
    ServiceWrapper<ShoppingItemTypeService> {
    private ShoppingItemTypeService _shoppingItemTypeService;

    public ShoppingItemTypeServiceWrapper(
        ShoppingItemTypeService shoppingItemTypeService) {
        _shoppingItemTypeService = shoppingItemTypeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingItemTypeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingItemTypeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingItemTypeService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingItemTypeService getWrappedShoppingItemTypeService() {
        return _shoppingItemTypeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingItemTypeService(
        ShoppingItemTypeService shoppingItemTypeService) {
        _shoppingItemTypeService = shoppingItemTypeService;
    }

    @Override
    public ShoppingItemTypeService getWrappedService() {
        return _shoppingItemTypeService;
    }

    @Override
    public void setWrappedService(
        ShoppingItemTypeService shoppingItemTypeService) {
        _shoppingItemTypeService = shoppingItemTypeService;
    }
}
