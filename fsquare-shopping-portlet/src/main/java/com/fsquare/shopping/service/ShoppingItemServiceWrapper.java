package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemService
 * @generated
 */
public class ShoppingItemServiceWrapper implements ShoppingItemService,
    ServiceWrapper<ShoppingItemService> {
    private ShoppingItemService _shoppingItemService;

    public ShoppingItemServiceWrapper(ShoppingItemService shoppingItemService) {
        _shoppingItemService = shoppingItemService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingItemService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingItemService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingItemService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingItemService getWrappedShoppingItemService() {
        return _shoppingItemService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingItemService(
        ShoppingItemService shoppingItemService) {
        _shoppingItemService = shoppingItemService;
    }

    @Override
    public ShoppingItemService getWrappedService() {
        return _shoppingItemService;
    }

    @Override
    public void setWrappedService(ShoppingItemService shoppingItemService) {
        _shoppingItemService = shoppingItemService;
    }
}
