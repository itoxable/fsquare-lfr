package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingOrderItemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemLocalService
 * @generated
 */
public class ShoppingOrderItemLocalServiceWrapper
    implements ShoppingOrderItemLocalService,
        ServiceWrapper<ShoppingOrderItemLocalService> {
    private ShoppingOrderItemLocalService _shoppingOrderItemLocalService;

    public ShoppingOrderItemLocalServiceWrapper(
        ShoppingOrderItemLocalService shoppingOrderItemLocalService) {
        _shoppingOrderItemLocalService = shoppingOrderItemLocalService;
    }

    /**
    * Adds the shopping order item to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderItem the shopping order item
    * @return the shopping order item that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem addShoppingOrderItem(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.addShoppingOrderItem(shoppingOrderItem);
    }

    /**
    * Creates a new shopping order item with the primary key. Does not add the shopping order item to the database.
    *
    * @param shoppingOrderItemId the primary key for the new shopping order item
    * @return the new shopping order item
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem createShoppingOrderItem(
        long shoppingOrderItemId) {
        return _shoppingOrderItemLocalService.createShoppingOrderItem(shoppingOrderItemId);
    }

    /**
    * Deletes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item that was removed
    * @throws PortalException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem deleteShoppingOrderItem(
        long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.deleteShoppingOrderItem(shoppingOrderItemId);
    }

    /**
    * Deletes the shopping order item from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderItem the shopping order item
    * @return the shopping order item that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem deleteShoppingOrderItem(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.deleteShoppingOrderItem(shoppingOrderItem);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingOrderItemLocalService.dynamicQuery();
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
        return _shoppingOrderItemLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingOrderItemLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingOrderItemLocalService.dynamicQuery(dynamicQuery, start,
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
        return _shoppingOrderItemLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingOrderItemLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem fetchShoppingOrderItem(
        long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.fetchShoppingOrderItem(shoppingOrderItemId);
    }

    /**
    * Returns the shopping order item with the primary key.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item
    * @throws PortalException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem getShoppingOrderItem(
        long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.getShoppingOrderItem(shoppingOrderItemId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping order items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @return the range of shopping order items
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> getShoppingOrderItems(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.getShoppingOrderItems(start, end);
    }

    /**
    * Returns the number of shopping order items.
    *
    * @return the number of shopping order items
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingOrderItemsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.getShoppingOrderItemsCount();
    }

    /**
    * Updates the shopping order item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderItem the shopping order item
    * @return the shopping order item that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem updateShoppingOrderItem(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.updateShoppingOrderItem(shoppingOrderItem);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingOrderItemLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingOrderItemLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingOrderItemLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByShoppingOrderId(
        long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderItemLocalService.findByShoppingOrderId(shoppingOrderId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingOrderItemLocalService getWrappedShoppingOrderItemLocalService() {
        return _shoppingOrderItemLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingOrderItemLocalService(
        ShoppingOrderItemLocalService shoppingOrderItemLocalService) {
        _shoppingOrderItemLocalService = shoppingOrderItemLocalService;
    }

    @Override
    public ShoppingOrderItemLocalService getWrappedService() {
        return _shoppingOrderItemLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingOrderItemLocalService shoppingOrderItemLocalService) {
        _shoppingOrderItemLocalService = shoppingOrderItemLocalService;
    }
}
