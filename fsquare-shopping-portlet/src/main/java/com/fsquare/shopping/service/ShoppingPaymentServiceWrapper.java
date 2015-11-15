package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingPaymentService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingPaymentService
 * @generated
 */
public class ShoppingPaymentServiceWrapper implements ShoppingPaymentService,
    ServiceWrapper<ShoppingPaymentService> {
    private ShoppingPaymentService _shoppingPaymentService;

    public ShoppingPaymentServiceWrapper(
        ShoppingPaymentService shoppingPaymentService) {
        _shoppingPaymentService = shoppingPaymentService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingPaymentService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingPaymentService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingPaymentService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingPaymentService getWrappedShoppingPaymentService() {
        return _shoppingPaymentService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingPaymentService(
        ShoppingPaymentService shoppingPaymentService) {
        _shoppingPaymentService = shoppingPaymentService;
    }

    @Override
    public ShoppingPaymentService getWrappedService() {
        return _shoppingPaymentService;
    }

    @Override
    public void setWrappedService(ShoppingPaymentService shoppingPaymentService) {
        _shoppingPaymentService = shoppingPaymentService;
    }
}
