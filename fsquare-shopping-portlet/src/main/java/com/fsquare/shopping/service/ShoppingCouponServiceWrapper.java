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
    public java.util.Map<java.util.Locale, java.lang.String> testMap(
        java.util.Map<java.util.Locale, java.lang.String> map) {
        return _shoppingCouponService.testMap(map);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndGroupId(
        java.lang.String code, long groupId) {
        return _shoppingCouponService.fetchByCodeAndGroupId(code, groupId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByGroupId(
        java.lang.Long groupId) {
        return _shoppingCouponService.findByGroupId(groupId);
    }

    @Override
    public boolean isCouponValid(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon) {
        return _shoppingCouponService.isCouponValid(shoppingCoupon);
    }

    @Override
    public java.lang.String getCouponStatus(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon) {
        return _shoppingCouponService.getCouponStatus(shoppingCoupon);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByGroupIdStartEnd(
        java.lang.Long groupId, int start, int end) {
        return _shoppingCouponService.findByGroupIdStartEnd(groupId, start, end);
    }

    @Override
    public int countByGroupId(java.lang.Long groupId) {
        return _shoppingCouponService.countByGroupId(groupId);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> getPagedItems(
        java.lang.Long groupId, int start, int end) {
        return _shoppingCouponService.getPagedItems(groupId, start, end);
    }

    @Override
    public void updateShoppingCoupon(long couponId, long groupId,
        java.lang.String code, java.lang.String name,
        java.lang.String description, java.util.Date startDate,
        java.util.Date endDate, boolean active,
        java.lang.String limitCategories, java.lang.String limitSkus,
        double minOrder, double discount, java.lang.String discountType,
        long maxUses, long userid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _shoppingCouponService.updateShoppingCoupon(couponId, groupId, code,
            name, description, startDate, endDate, active, limitCategories,
            limitSkus, minOrder, discount, discountType, maxUses, userid,
            companyId);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon deleteCoupon(long couponId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponService.deleteCoupon(couponId);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon updateShoppingCoupon(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponService.updateShoppingCoupon(shoppingCoupon);
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
