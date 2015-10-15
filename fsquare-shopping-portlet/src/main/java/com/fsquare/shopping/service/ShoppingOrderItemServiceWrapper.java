package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingOrderItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemService
 * @generated
 */
public class ShoppingOrderItemServiceWrapper implements ShoppingOrderItemService,
    ServiceWrapper<ShoppingOrderItemService> {
    private ShoppingOrderItemService _shoppingOrderItemService;

    public ShoppingOrderItemServiceWrapper(
        ShoppingOrderItemService shoppingOrderItemService) {
        _shoppingOrderItemService = shoppingOrderItemService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingOrderItemService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingOrderItemService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingOrderItemService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingOrderItemService getWrappedShoppingOrderItemService() {
        return _shoppingOrderItemService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingOrderItemService(
        ShoppingOrderItemService shoppingOrderItemService) {
        _shoppingOrderItemService = shoppingOrderItemService;
    }

    @Override
    public ShoppingOrderItemService getWrappedService() {
        return _shoppingOrderItemService;
    }

    @Override
    public void setWrappedService(
        ShoppingOrderItemService shoppingOrderItemService) {
        _shoppingOrderItemService = shoppingOrderItemService;
    }
}
