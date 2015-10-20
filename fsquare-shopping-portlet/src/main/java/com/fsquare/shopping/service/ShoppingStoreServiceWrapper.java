package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingStoreService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStoreService
 * @generated
 */
public class ShoppingStoreServiceWrapper implements ShoppingStoreService,
    ServiceWrapper<ShoppingStoreService> {
    private ShoppingStoreService _shoppingStoreService;

    public ShoppingStoreServiceWrapper(
        ShoppingStoreService shoppingStoreService) {
        _shoppingStoreService = shoppingStoreService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingStoreService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingStoreService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingStoreService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingStoreService getWrappedShoppingStoreService() {
        return _shoppingStoreService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingStoreService(
        ShoppingStoreService shoppingStoreService) {
        _shoppingStoreService = shoppingStoreService;
    }

    @Override
    public ShoppingStoreService getWrappedService() {
        return _shoppingStoreService;
    }

    @Override
    public void setWrappedService(ShoppingStoreService shoppingStoreService) {
        _shoppingStoreService = shoppingStoreService;
    }
}
