package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingCouponService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponService
 * @generated
 */
public class ShoppingCouponServiceWrapper implements ShoppingCouponService,
    ServiceWrapper<ShoppingCouponService> {
    private ShoppingCouponService _shoppingCouponService;

    public ShoppingCouponServiceWrapper(
        ShoppingCouponService shoppingCouponService) {
        _shoppingCouponService = shoppingCouponService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingCouponService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingCouponService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingCouponService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCode(
        java.lang.String code) {
        return _shoppingCouponService.fetchByCode(code);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByGroupId(
        java.lang.Long groupId) {
        return _shoppingCouponService.findByGroupId(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingCouponService getWrappedShoppingCouponService() {
        return _shoppingCouponService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingCouponService(
        ShoppingCouponService shoppingCouponService) {
        _shoppingCouponService = shoppingCouponService;
    }

    @Override
    public ShoppingCouponService getWrappedService() {
        return _shoppingCouponService;
    }

    @Override
    public void setWrappedService(ShoppingCouponService shoppingCouponService) {
        _shoppingCouponService = shoppingCouponService;
    }
}
