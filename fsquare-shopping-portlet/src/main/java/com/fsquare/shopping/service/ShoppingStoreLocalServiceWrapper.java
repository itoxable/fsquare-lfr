package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingStoreLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStoreLocalService
 * @generated
 */
public class ShoppingStoreLocalServiceWrapper
    implements ShoppingStoreLocalService,
        ServiceWrapper<ShoppingStoreLocalService> {
    private ShoppingStoreLocalService _shoppingStoreLocalService;

    public ShoppingStoreLocalServiceWrapper(
        ShoppingStoreLocalService shoppingStoreLocalService) {
        _shoppingStoreLocalService = shoppingStoreLocalService;
    }

    /**
    * Adds the shopping store to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingStore the shopping store
    * @return the shopping store that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStore addShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.addShoppingStore(shoppingStore);
    }

    /**
    * Creates a new shopping store with the primary key. Does not add the shopping store to the database.
    *
    * @param groupId the primary key for the new shopping store
    * @return the new shopping store
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStore createShoppingStore(
        long groupId) {
        return _shoppingStoreLocalService.createShoppingStore(groupId);
    }

    /**
    * Deletes the shopping store with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param groupId the primary key of the shopping store
    * @return the shopping store that was removed
    * @throws PortalException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStore deleteShoppingStore(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.deleteShoppingStore(groupId);
    }

    /**
    * Deletes the shopping store from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingStore the shopping store
    * @return the shopping store that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStore deleteShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.deleteShoppingStore(shoppingStore);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingStoreLocalService.dynamicQuery();
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
        return _shoppingStoreLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingStoreLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingStoreLocalService.dynamicQuery(dynamicQuery, start,
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
        return _shoppingStoreLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingStoreLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStore fetchShoppingStore(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.fetchShoppingStore(groupId);
    }

    /**
    * Returns the shopping store with the primary key.
    *
    * @param groupId the primary key of the shopping store
    * @return the shopping store
    * @throws PortalException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStore getShoppingStore(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.getShoppingStore(groupId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping stores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping stores
    * @param end the upper bound of the range of shopping stores (not inclusive)
    * @return the range of shopping stores
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingStore> getShoppingStores(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.getShoppingStores(start, end);
    }

    /**
    * Returns the number of shopping stores.
    *
    * @return the number of shopping stores
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingStoresCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.getShoppingStoresCount();
    }

    /**
    * Updates the shopping store in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingStore the shopping store
    * @return the shopping store that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingStore updateShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.updateShoppingStore(shoppingStore);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingStoreLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingStoreLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingStoreLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> getShoppingStorageLocationsByGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreLocalService.getShoppingStorageLocationsByGroup(groupId);
    }

    @Override
    public java.util.List<java.lang.String[]> getShoppingLayouts(long groupId) {
        return _shoppingStoreLocalService.getShoppingLayouts(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingStoreLocalService getWrappedShoppingStoreLocalService() {
        return _shoppingStoreLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingStoreLocalService(
        ShoppingStoreLocalService shoppingStoreLocalService) {
        _shoppingStoreLocalService = shoppingStoreLocalService;
    }

    @Override
    public ShoppingStoreLocalService getWrappedService() {
        return _shoppingStoreLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingStoreLocalService shoppingStoreLocalService) {
        _shoppingStoreLocalService = shoppingStoreLocalService;
    }
}
