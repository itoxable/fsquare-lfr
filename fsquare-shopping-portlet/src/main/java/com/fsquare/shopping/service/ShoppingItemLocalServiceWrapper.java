package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingItemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemLocalService
 * @generated
 */
public class ShoppingItemLocalServiceWrapper implements ShoppingItemLocalService,
    ServiceWrapper<ShoppingItemLocalService> {
    private ShoppingItemLocalService _shoppingItemLocalService;

    public ShoppingItemLocalServiceWrapper(
        ShoppingItemLocalService shoppingItemLocalService) {
        _shoppingItemLocalService = shoppingItemLocalService;
    }

    /**
    * Adds the shopping item to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItem the shopping item
    * @return the shopping item that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem addShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.addShoppingItem(shoppingItem);
    }

    /**
    * Creates a new shopping item with the primary key. Does not add the shopping item to the database.
    *
    * @param itemId the primary key for the new shopping item
    * @return the new shopping item
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem createShoppingItem(
        long itemId) {
        return _shoppingItemLocalService.createShoppingItem(itemId);
    }

    /**
    * Deletes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item that was removed
    * @throws PortalException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem deleteShoppingItem(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.deleteShoppingItem(itemId);
    }

    /**
    * Deletes the shopping item from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItem the shopping item
    * @return the shopping item that was removed
    * @throws PortalException
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem deleteShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.deleteShoppingItem(shoppingItem);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingItemLocalService.dynamicQuery();
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
        return _shoppingItemLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingItemLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingItemLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _shoppingItemLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingItemLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItem fetchShoppingItem(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.fetchShoppingItem(itemId);
    }

    /**
    * Returns the shopping item with the matching UUID and company.
    *
    * @param uuid the shopping item's UUID
    * @param companyId the primary key of the company
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem fetchShoppingItemByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.fetchShoppingItemByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the shopping item matching the UUID and group.
    *
    * @param uuid the shopping item's UUID
    * @param groupId the primary key of the group
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem fetchShoppingItemByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.fetchShoppingItemByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the shopping item with the primary key.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item
    * @throws PortalException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem getShoppingItem(long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getShoppingItem(itemId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the shopping item with the matching UUID and company.
    *
    * @param uuid the shopping item's UUID
    * @param companyId the primary key of the company
    * @return the matching shopping item
    * @throws PortalException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem getShoppingItemByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getShoppingItemByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the shopping item matching the UUID and group.
    *
    * @param uuid the shopping item's UUID
    * @param groupId the primary key of the group
    * @return the matching shopping item
    * @throws PortalException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem getShoppingItemByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getShoppingItemByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the shopping items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @return the range of shopping items
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> getShoppingItems(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getShoppingItems(start, end);
    }

    /**
    * Returns the number of shopping items.
    *
    * @return the number of shopping items
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingItemsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getShoppingItemsCount();
    }

    /**
    * Updates the shopping item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingItem the shopping item
    * @return the shopping item that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItem updateShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.updateShoppingItem(shoppingItem);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingItemLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingItemLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingItemLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.findByGroupId(groupId);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItem addShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem, long userId,
        java.util.List<byte[]> images,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _shoppingItemLocalService.addShoppingItem(shoppingItem, userId,
            images, serviceContext);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> getItemImages(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getItemImages(shoppingItem);
    }

    @Override
    public com.liferay.portlet.asset.model.AssetEntry getEntry(long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.getEntry(itemId);
    }

    @Override
    public int availableQuantity(long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemLocalService.availableQuantity(itemId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingItemLocalService getWrappedShoppingItemLocalService() {
        return _shoppingItemLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingItemLocalService(
        ShoppingItemLocalService shoppingItemLocalService) {
        _shoppingItemLocalService = shoppingItemLocalService;
    }

    @Override
    public ShoppingItemLocalService getWrappedService() {
        return _shoppingItemLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingItemLocalService shoppingItemLocalService) {
        _shoppingItemLocalService = shoppingItemLocalService;
    }
}
