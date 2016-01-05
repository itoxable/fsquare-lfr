package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingStorageLocationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorageLocationLocalService
 * @generated
 */
public class ShoppingStorageLocationLocalServiceWrapper
    implements ShoppingStorageLocationLocalService,
        ServiceWrapper<ShoppingStorageLocationLocalService> {
    private ShoppingStorageLocationLocalService _shoppingStorageLocationLocalService;

    public ShoppingStorageLocationLocalServiceWrapper(
        ShoppingStorageLocationLocalService shoppingStorageLocationLocalService) {
        _shoppingStorageLocationLocalService = shoppingStorageLocationLocalService;
    }

    /**
    * Adds the shopping storage location to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingStorageLocation the shopping storage location
    * @return the shopping storage location that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation addShoppingStorageLocation(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.addShoppingStorageLocation(shoppingStorageLocation);
    }

    /**
    * Creates a new shopping storage location with the primary key. Does not add the shopping storage location to the database.
    *
    * @param storageLocationId the primary key for the new shopping storage location
    * @return the new shopping storage location
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation createShoppingStorageLocation(
        long storageLocationId) {
        return _shoppingStorageLocationLocalService.createShoppingStorageLocation(storageLocationId);
    }

    /**
    * Deletes the shopping storage location with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location that was removed
    * @throws PortalException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation deleteShoppingStorageLocation(
        long storageLocationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.deleteShoppingStorageLocation(storageLocationId);
    }

    /**
    * Deletes the shopping storage location from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingStorageLocation the shopping storage location
    * @return the shopping storage location that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation deleteShoppingStorageLocation(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.deleteShoppingStorageLocation(shoppingStorageLocation);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingStorageLocationLocalService.dynamicQuery();
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
        return _shoppingStorageLocationLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingStorageLocationLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingStorageLocationLocalService.dynamicQuery(dynamicQuery,
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
        return _shoppingStorageLocationLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingStorageLocationLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation fetchShoppingStorageLocation(
        long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.fetchShoppingStorageLocation(storageLocationId);
    }

    /**
    * Returns the shopping storage location with the primary key.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location
    * @throws PortalException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation getShoppingStorageLocation(
        long storageLocationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.getShoppingStorageLocation(storageLocationId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping storage locations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping storage locations
    * @param end the upper bound of the range of shopping storage locations (not inclusive)
    * @return the range of shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> getShoppingStorageLocations(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.getShoppingStorageLocations(start,
            end);
    }

    /**
    * Returns the number of shopping storage locations.
    *
    * @return the number of shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingStorageLocationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.getShoppingStorageLocationsCount();
    }

    /**
    * Updates the shopping storage location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingStorageLocation the shopping storage location
    * @return the shopping storage location that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation updateShoppingStorageLocation(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocationLocalService.updateShoppingStorageLocation(shoppingStorageLocation);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingStorageLocationLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingStorageLocationLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingStorageLocationLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingStorageLocationLocalService getWrappedShoppingStorageLocationLocalService() {
        return _shoppingStorageLocationLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingStorageLocationLocalService(
        ShoppingStorageLocationLocalService shoppingStorageLocationLocalService) {
        _shoppingStorageLocationLocalService = shoppingStorageLocationLocalService;
    }

    @Override
    public ShoppingStorageLocationLocalService getWrappedService() {
        return _shoppingStorageLocationLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingStorageLocationLocalService shoppingStorageLocationLocalService) {
        _shoppingStorageLocationLocalService = shoppingStorageLocationLocalService;
    }
}
