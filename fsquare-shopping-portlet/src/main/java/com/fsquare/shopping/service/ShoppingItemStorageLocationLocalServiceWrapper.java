package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingItemStorageLocationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocationLocalService
 * @generated
 */
public class ShoppingItemStorageLocationLocalServiceWrapper
    implements ShoppingItemStorageLocationLocalService,
        ServiceWrapper<ShoppingItemStorageLocationLocalService> {
    private ShoppingItemStorageLocationLocalService _shoppingItemStorageLocationLocalService;

    public ShoppingItemStorageLocationLocalServiceWrapper(
        ShoppingItemStorageLocationLocalService shoppingItemStorageLocationLocalService) {
        _shoppingItemStorageLocationLocalService = shoppingItemStorageLocationLocalService;
    }

    /**
    * Adds the shopping item storage location to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    * @return the shopping item storage location that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation addShoppingItemStorageLocation(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.addShoppingItemStorageLocation(shoppingItemStorageLocation);
    }

    /**
    * Creates a new shopping item storage location with the primary key. Does not add the shopping item storage location to the database.
    *
    * @param itemStorageLocationId the primary key for the new shopping item storage location
    * @return the new shopping item storage location
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation createShoppingItemStorageLocation(
        long itemStorageLocationId) {
        return _shoppingItemStorageLocationLocalService.createShoppingItemStorageLocation(itemStorageLocationId);
    }

    /**
    * Deletes the shopping item storage location with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location that was removed
    * @throws PortalException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation deleteShoppingItemStorageLocation(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.deleteShoppingItemStorageLocation(itemStorageLocationId);
    }

    /**
    * Deletes the shopping item storage location from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    * @return the shopping item storage location that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation deleteShoppingItemStorageLocation(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.deleteShoppingItemStorageLocation(shoppingItemStorageLocation);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingItemStorageLocationLocalService.dynamicQuery();
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
        return _shoppingItemStorageLocationLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingItemStorageLocationLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingItemStorageLocationLocalService.dynamicQuery(dynamicQuery,
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
        return _shoppingItemStorageLocationLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingItemStorageLocationLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchShoppingItemStorageLocation(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.fetchShoppingItemStorageLocation(itemStorageLocationId);
    }

    /**
    * Returns the shopping item storage location with the primary key.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location
    * @throws PortalException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation getShoppingItemStorageLocation(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.getShoppingItemStorageLocation(itemStorageLocationId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping item storage locations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @return the range of shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> getShoppingItemStorageLocations(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.getShoppingItemStorageLocations(start,
            end);
    }

    /**
    * Returns the number of shopping item storage locations.
    *
    * @return the number of shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingItemStorageLocationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.getShoppingItemStorageLocationsCount();
    }

    /**
    * Updates the shopping item storage location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    * @return the shopping item storage location that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation updateShoppingItemStorageLocation(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.updateShoppingItemStorageLocation(shoppingItemStorageLocation);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingItemStorageLocationLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingItemStorageLocationLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingItemStorageLocationLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.findByItemIdAndStorageLocationId(itemId,
            storageLocationId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByItemId(
        long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.findByItemId(itemId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.findByStorageLocationId(storageLocationId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByCompanyId(
        long companyId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationLocalService.findByCompanyId(companyId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingItemStorageLocationLocalService getWrappedShoppingItemStorageLocationLocalService() {
        return _shoppingItemStorageLocationLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingItemStorageLocationLocalService(
        ShoppingItemStorageLocationLocalService shoppingItemStorageLocationLocalService) {
        _shoppingItemStorageLocationLocalService = shoppingItemStorageLocationLocalService;
    }

    @Override
    public ShoppingItemStorageLocationLocalService getWrappedService() {
        return _shoppingItemStorageLocationLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingItemStorageLocationLocalService shoppingItemStorageLocationLocalService) {
        _shoppingItemStorageLocationLocalService = shoppingItemStorageLocationLocalService;
    }
}
