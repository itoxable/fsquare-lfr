package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingShippingMethodLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethodLocalService
 * @generated
 */
public class ShoppingShippingMethodLocalServiceWrapper
    implements ShoppingShippingMethodLocalService,
        ServiceWrapper<ShoppingShippingMethodLocalService> {
    private ShoppingShippingMethodLocalService _shoppingShippingMethodLocalService;

    public ShoppingShippingMethodLocalServiceWrapper(
        ShoppingShippingMethodLocalService shoppingShippingMethodLocalService) {
        _shoppingShippingMethodLocalService = shoppingShippingMethodLocalService;
    }

    /**
    * Adds the shopping shipping method to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingShippingMethod the shopping shipping method
    * @return the shopping shipping method that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod addShoppingShippingMethod(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.addShoppingShippingMethod(shoppingShippingMethod);
    }

    /**
    * Creates a new shopping shipping method with the primary key. Does not add the shopping shipping method to the database.
    *
    * @param shippingMethodId the primary key for the new shopping shipping method
    * @return the new shopping shipping method
    */
    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod createShoppingShippingMethod(
        long shippingMethodId) {
        return _shoppingShippingMethodLocalService.createShoppingShippingMethod(shippingMethodId);
    }

    /**
    * Deletes the shopping shipping method with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method that was removed
    * @throws PortalException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod deleteShoppingShippingMethod(
        long shippingMethodId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.deleteShoppingShippingMethod(shippingMethodId);
    }

    /**
    * Deletes the shopping shipping method from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingShippingMethod the shopping shipping method
    * @return the shopping shipping method that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod deleteShoppingShippingMethod(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.deleteShoppingShippingMethod(shoppingShippingMethod);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingShippingMethodLocalService.dynamicQuery();
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
        return _shoppingShippingMethodLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingShippingMethodLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingShippingMethodLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _shoppingShippingMethodLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingShippingMethodLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod fetchShoppingShippingMethod(
        long shippingMethodId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.fetchShoppingShippingMethod(shippingMethodId);
    }

    /**
    * Returns the shopping shipping method with the primary key.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method
    * @throws PortalException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod getShoppingShippingMethod(
        long shippingMethodId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.getShoppingShippingMethod(shippingMethodId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping shipping methods.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @return the range of shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> getShoppingShippingMethods(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.getShoppingShippingMethods(start,
            end);
    }

    /**
    * Returns the number of shopping shipping methods.
    *
    * @return the number of shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingShippingMethodsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.getShoppingShippingMethodsCount();
    }

    /**
    * Updates the shopping shipping method in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingShippingMethod the shopping shipping method
    * @return the shopping shipping method that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod updateShoppingShippingMethod(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.updateShoppingShippingMethod(shoppingShippingMethod);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingShippingMethodLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingShippingMethodLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingShippingMethodLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.lang.Long getShippingPrice(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod,
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItems,
        long total) {
        return _shoppingShippingMethodLocalService.getShippingPrice(shoppingShippingMethod,
            shoppingOrderItems, total);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod fetchDefaultShipping()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.fetchDefaultShipping();
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethodLocalService.findByGroupId(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingShippingMethodLocalService getWrappedShoppingShippingMethodLocalService() {
        return _shoppingShippingMethodLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingShippingMethodLocalService(
        ShoppingShippingMethodLocalService shoppingShippingMethodLocalService) {
        _shoppingShippingMethodLocalService = shoppingShippingMethodLocalService;
    }

    @Override
    public ShoppingShippingMethodLocalService getWrappedService() {
        return _shoppingShippingMethodLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingShippingMethodLocalService shoppingShippingMethodLocalService) {
        _shoppingShippingMethodLocalService = shoppingShippingMethodLocalService;
    }
}
