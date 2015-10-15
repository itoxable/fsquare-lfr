package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingShippingMethodService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethodService
 * @generated
 */
public class ShoppingShippingMethodServiceWrapper
    implements ShoppingShippingMethodService,
        ServiceWrapper<ShoppingShippingMethodService> {
    private ShoppingShippingMethodService _shoppingShippingMethodService;

    public ShoppingShippingMethodServiceWrapper(
        ShoppingShippingMethodService shoppingShippingMethodService) {
        _shoppingShippingMethodService = shoppingShippingMethodService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingShippingMethodService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingShippingMethodService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingShippingMethodService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingShippingMethodService getWrappedShoppingShippingMethodService() {
        return _shoppingShippingMethodService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingShippingMethodService(
        ShoppingShippingMethodService shoppingShippingMethodService) {
        _shoppingShippingMethodService = shoppingShippingMethodService;
    }

    @Override
    public ShoppingShippingMethodService getWrappedService() {
        return _shoppingShippingMethodService;
    }

    @Override
    public void setWrappedService(
        ShoppingShippingMethodService shoppingShippingMethodService) {
        _shoppingShippingMethodService = shoppingShippingMethodService;
    }
}
