package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingOrderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderLocalService
 * @generated
 */
public class ShoppingOrderLocalServiceWrapper
    implements ShoppingOrderLocalService,
        ServiceWrapper<ShoppingOrderLocalService> {
    private ShoppingOrderLocalService _shoppingOrderLocalService;

    public ShoppingOrderLocalServiceWrapper(
        ShoppingOrderLocalService shoppingOrderLocalService) {
        _shoppingOrderLocalService = shoppingOrderLocalService;
    }

    /**
    * Adds the shopping order to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrder the shopping order
    * @return the shopping order that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrder addShoppingOrder(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.addShoppingOrder(shoppingOrder);
    }

    /**
    * Creates a new shopping order with the primary key. Does not add the shopping order to the database.
    *
    * @param shoppingOrderId the primary key for the new shopping order
    * @return the new shopping order
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrder createShoppingOrder(
        long shoppingOrderId) {
        return _shoppingOrderLocalService.createShoppingOrder(shoppingOrderId);
    }

    /**
    * Deletes the shopping order with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderId the primary key of the shopping order
    * @return the shopping order that was removed
    * @throws PortalException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrder deleteShoppingOrder(
        long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.deleteShoppingOrder(shoppingOrderId);
    }

    /**
    * Deletes the shopping order from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrder the shopping order
    * @return the shopping order that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrder deleteShoppingOrder(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.deleteShoppingOrder(shoppingOrder);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingOrderLocalService.dynamicQuery();
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
        return _shoppingOrderLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingOrderLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingOrderLocalService.dynamicQuery(dynamicQuery, start,
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
        return _shoppingOrderLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingOrderLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingOrder fetchShoppingOrder(
        long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.fetchShoppingOrder(shoppingOrderId);
    }

    /**
    * Returns the shopping order with the primary key.
    *
    * @param shoppingOrderId the primary key of the shopping order
    * @return the shopping order
    * @throws PortalException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrder getShoppingOrder(
        long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.getShoppingOrder(shoppingOrderId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping orders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of shopping orders
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> getShoppingOrders(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.getShoppingOrders(start, end);
    }

    /**
    * Returns the number of shopping orders.
    *
    * @return the number of shopping orders
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingOrdersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.getShoppingOrdersCount();
    }

    /**
    * Updates the shopping order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrder the shopping order
    * @return the shopping order that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrder updateShoppingOrder(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.updateShoppingOrder(shoppingOrder);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingOrderLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingOrderLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingOrderLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.findByGroupId(groupId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBygroupIdAndUserId(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.findBygroupIdAndUserId(groupId, userId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBygroupIdAndEmail(
        long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderLocalService.findBygroupIdAndEmail(groupId, email);
    }

    @Override
    public double getOrderTotal(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList) {
        return _shoppingOrderLocalService.getOrderTotal(shoppingOrderItemList);
    }

    @Override
    public int getOrderItemsCount(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList) {
        return _shoppingOrderLocalService.getOrderItemsCount(shoppingOrderItemList);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingOrderLocalService getWrappedShoppingOrderLocalService() {
        return _shoppingOrderLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingOrderLocalService(
        ShoppingOrderLocalService shoppingOrderLocalService) {
        _shoppingOrderLocalService = shoppingOrderLocalService;
    }

    @Override
    public ShoppingOrderLocalService getWrappedService() {
        return _shoppingOrderLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingOrderLocalService shoppingOrderLocalService) {
        _shoppingOrderLocalService = shoppingOrderLocalService;
    }
}
