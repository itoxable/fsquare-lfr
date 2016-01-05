package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingItemTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemTypeLocalService
 * @generated
 */
public class ShoppingItemTypeLocalServiceWrapper
    implements ShoppingItemTypeLocalService,
        ServiceWrapper<ShoppingItemTypeLocalService> {
    private ShoppingItemTypeLocalService _shoppingItemTypeLocalService;

    public ShoppingItemTypeLocalServiceWrapper(
        ShoppingItemTypeLocalService shoppingItemTypeLocalService) {
        _shoppingItemTypeLocalService = shoppingItemTypeLocalService;
    }

    /**
    * Adds the shopping item type to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemType the shopping item type
    * @return the shopping item type that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemType addShoppingItemType(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.addShoppingItemType(shoppingItemType);
    }

    /**
    * Creates a new shopping item type with the primary key. Does not add the shopping item type to the database.
    *
    * @param itemTypeId the primary key for the new shopping item type
    * @return the new shopping item type
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemType createShoppingItemType(
        long itemTypeId) {
        return _shoppingItemTypeLocalService.createShoppingItemType(itemTypeId);
    }

    /**
    * Deletes the shopping item type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type that was removed
    * @throws PortalException if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemType deleteShoppingItemType(
        long itemTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.deleteShoppingItemType(itemTypeId);
    }

    /**
    * Deletes the shopping item type from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemType the shopping item type
    * @return the shopping item type that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemType deleteShoppingItemType(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.deleteShoppingItemType(shoppingItemType);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _shoppingItemTypeLocalService.dynamicQuery();
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
        return _shoppingItemTypeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingItemTypeLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _shoppingItemTypeLocalService.dynamicQuery(dynamicQuery, start,
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
        return _shoppingItemTypeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _shoppingItemTypeLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemType fetchShoppingItemType(
        long itemTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.fetchShoppingItemType(itemTypeId);
    }

    /**
    * Returns the shopping item type with the primary key.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type
    * @throws PortalException if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemType getShoppingItemType(
        long itemTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.getShoppingItemType(itemTypeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping item types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item types
    * @param end the upper bound of the range of shopping item types (not inclusive)
    * @return the range of shopping item types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemType> getShoppingItemTypes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.getShoppingItemTypes(start, end);
    }

    /**
    * Returns the number of shopping item types.
    *
    * @return the number of shopping item types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getShoppingItemTypesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.getShoppingItemTypesCount();
    }

    /**
    * Updates the shopping item type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemType the shopping item type
    * @return the shopping item type that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.fsquare.shopping.model.ShoppingItemType updateShoppingItemType(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemTypeLocalService.updateShoppingItemType(shoppingItemType);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingItemTypeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingItemTypeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingItemTypeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingItemTypeLocalService getWrappedShoppingItemTypeLocalService() {
        return _shoppingItemTypeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingItemTypeLocalService(
        ShoppingItemTypeLocalService shoppingItemTypeLocalService) {
        _shoppingItemTypeLocalService = shoppingItemTypeLocalService;
    }

    @Override
    public ShoppingItemTypeLocalService getWrappedService() {
        return _shoppingItemTypeLocalService;
    }

    @Override
    public void setWrappedService(
        ShoppingItemTypeLocalService shoppingItemTypeLocalService) {
        _shoppingItemTypeLocalService = shoppingItemTypeLocalService;
    }
}
