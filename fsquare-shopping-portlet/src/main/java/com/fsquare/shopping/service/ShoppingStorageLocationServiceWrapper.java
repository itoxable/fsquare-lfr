package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingStorageLocationService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorageLocationService
 * @generated
 */
public class ShoppingStorageLocationServiceWrapper
    implements ShoppingStorageLocationService,
        ServiceWrapper<ShoppingStorageLocationService> {
    private ShoppingStorageLocationService _shoppingStorageLocationService;

    public ShoppingStorageLocationServiceWrapper(
        ShoppingStorageLocationService shoppingStorageLocationService) {
        _shoppingStorageLocationService = shoppingStorageLocationService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingStorageLocationService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingStorageLocationService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingStorageLocationService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingStorageLocationService getWrappedShoppingStorageLocationService() {
        return _shoppingStorageLocationService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingStorageLocationService(
        ShoppingStorageLocationService shoppingStorageLocationService) {
        _shoppingStorageLocationService = shoppingStorageLocationService;
    }

    @Override
    public ShoppingStorageLocationService getWrappedService() {
        return _shoppingStorageLocationService;
    }

    @Override
    public void setWrappedService(
        ShoppingStorageLocationService shoppingStorageLocationService) {
        _shoppingStorageLocationService = shoppingStorageLocationService;
    }
}
