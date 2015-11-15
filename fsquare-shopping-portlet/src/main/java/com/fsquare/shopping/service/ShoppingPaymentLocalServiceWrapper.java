package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingPaymentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingPaymentLocalService
 * @generated
 */
public class ShoppingPaymentLocalServiceWrapper
    implements ShoppingPaymentLocalService,
        ServiceWrapper<ShoppingPaymentLocalService> {
    private ShoppingPaymentLocalService _shoppingPaymentLocalService;

    public ShoppingPaymentLocalServiceWrapper(
        ShoppingPaymentLocalService shoppingPaymentLocalService) {
        _shoppingPaymentLocalService = shoppingPaymentLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingPaymentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingPaymentLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingPaymentLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingPaymentLocalService getWrappedShoppingPaymentLocalService() {
        return _shoppingPaymentLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingPaymentLocalService(
        ShoppingPaymentLocalService shoppingPaymentLocalService) {
        _shoppingPaymentLocalService = shoppingPaymentLocalService;
    }

    @Override
    public ShoppingPaymentLocalService getWrappedService() {
        return _shoppingPaymentLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingPaymentLocalService shoppingPaymentLocalService) {
        _shoppingPaymentLocalService = shoppingPaymentLocalService;
    }
}
