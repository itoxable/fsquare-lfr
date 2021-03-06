package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingCouponLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponLocalService
 * @generated
 */
public class ShoppingCouponLocalServiceWrapper
    implements ShoppingCouponLocalService,
        ServiceWrapper<ShoppingCouponLocalService> {
    private ShoppingCouponLocalService _shoppingCouponLocalService;

    public ShoppingCouponLocalServiceWrapper(
        ShoppingCouponLocalService shoppingCouponLocalService) {
        _shoppingCouponLocalService = shoppingCouponLocalService;
    }

    /**
    * Adds the shopping coupon to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingCoupon the shopping coupon
    * @return the shopping coupon that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingCoupon addShoppingCoupon(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.addShoppingCoupon(shoppingCoupon);
    }

    /**
    * Creates a new shopping coupon with the primary key. Does not add the shopping coupon to the database.
    *
    * @param couponId the primary key for the new shopping coupon
    * @return the new shopping coupon
    */
    @Override
    public com.fsquare.shopping.model.ShoppingCoupon createShoppingCoupon(
        long couponId) {
        return _shoppingCouponLocalService.createShoppingCoupon(couponId);
    }

    /**
    * Deletes the shopping coupon with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon that was removed
    * @throws PortalException if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingCoupon deleteShoppingCoupon(
        long couponId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.deleteShoppingCoupon(couponId);
    }

    /**
    * Deletes the shopping coupon from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingCoupon the shopping coupon
    * @return the shopping coupon that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingCoupon deleteShoppingCoupon(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.deleteShoppingCoupon(shoppingCoupon);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingCouponLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon fetchShoppingCoupon(
        long couponId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.fetchShoppingCoupon(couponId);
    }

    /**
    * Returns the shopping coupon with the primary key.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon
    * @throws PortalException if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingCoupon getShoppingCoupon(
        long couponId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.getShoppingCoupon(couponId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping coupons.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping coupons
    * @param end the upper bound of the range of shopping coupons (not inclusive)
    * @return the range of shopping coupons
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> getShoppingCoupons(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.getShoppingCoupons(start, end);
    }

    /**
    * Returns the number of shopping coupons.
    *
    * @return the number of shopping coupons
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingCouponsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.getShoppingCouponsCount();
    }

    /**
    * Updates the shopping coupon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingCoupon the shopping coupon
    * @return the shopping coupon that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingCoupon updateShoppingCoupon(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingCouponLocalService.updateShoppingCoupon(shoppingCoupon);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingCouponLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingCouponLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingCouponLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndCompanyId(
        java.lang.String code, long companyId) {
        return _shoppingCouponLocalService.fetchByCodeAndCompanyId(code,
            companyId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        java.lang.Long companyId) {
        return _shoppingCouponLocalService.findByCompanyId(companyId);
    }

    @Override
    public boolean isCouponValid(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon) {
        return _shoppingCouponLocalService.isCouponValid(shoppingCoupon);
    }

    @Override
    public java.lang.String getCouponStatus(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon) {
        return _shoppingCouponLocalService.getCouponStatus(shoppingCoupon);
    }

    @Override
    public java.lang.Double applyCoupon(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon,
        java.lang.Double total) {
        return _shoppingCouponLocalService.applyCoupon(shoppingCoupon, total);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingCouponLocalService getWrappedShoppingCouponLocalService() {
        return _shoppingCouponLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingCouponLocalService(
        ShoppingCouponLocalService shoppingCouponLocalService) {
        _shoppingCouponLocalService = shoppingCouponLocalService;
    }

    @Override
    public ShoppingCouponLocalService getWrappedService() {
        return _shoppingCouponLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingCouponLocalService shoppingCouponLocalService) {
        _shoppingCouponLocalService = shoppingCouponLocalService;
    }
}
