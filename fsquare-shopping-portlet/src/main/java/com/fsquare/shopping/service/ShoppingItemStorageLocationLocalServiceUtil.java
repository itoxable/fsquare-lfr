package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ShoppingItemStorageLocation. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingItemStorageLocationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocationLocalService
 * @see com.fsquare.shopping.service.base.ShoppingItemStorageLocationLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingItemStorageLocationLocalServiceImpl
 * @generated
 */
public class ShoppingItemStorageLocationLocalServiceUtil {
    private static ShoppingItemStorageLocationLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingItemStorageLocationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the shopping item storage location to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    * @return the shopping item storage location that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation addShoppingItemStorageLocation(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addShoppingItemStorageLocation(shoppingItemStorageLocation);
    }

    /**
    * Creates a new shopping item storage location with the primary key. Does not add the shopping item storage location to the database.
    *
    * @param itemStorageLocationId the primary key for the new shopping item storage location
    * @return the new shopping item storage location
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation createShoppingItemStorageLocation(
        long itemStorageLocationId) {
        return getService()
                   .createShoppingItemStorageLocation(itemStorageLocationId);
    }

    /**
    * Deletes the shopping item storage location with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location that was removed
    * @throws PortalException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation deleteShoppingItemStorageLocation(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteShoppingItemStorageLocation(itemStorageLocationId);
    }

    /**
    * Deletes the shopping item storage location from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    * @return the shopping item storage location that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation deleteShoppingItemStorageLocation(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteShoppingItemStorageLocation(shoppingItemStorageLocation);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.fsquare.shopping.model.ShoppingItemStorageLocation fetchShoppingItemStorageLocation(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .fetchShoppingItemStorageLocation(itemStorageLocationId);
    }

    /**
    * Returns the shopping item storage location with the primary key.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location
    * @throws PortalException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation getShoppingItemStorageLocation(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemStorageLocation(itemStorageLocationId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> getShoppingItemStorageLocations(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemStorageLocations(start, end);
    }

    /**
    * Returns the number of shopping item storage locations.
    *
    * @return the number of shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public static int getShoppingItemStorageLocationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemStorageLocationsCount();
    }

    /**
    * Updates the shopping item storage location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    * @return the shopping item storage location that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation updateShoppingItemStorageLocation(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateShoppingItemStorageLocation(shoppingItemStorageLocation);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.fsquare.shopping.model.ShoppingItemStorageLocation findByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByItemIdAndStorageLocationId(itemId, storageLocationId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByItemId(
        long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByItemId(itemId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByStorageLocationId(storageLocationId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByGroupId(
        long groupId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByGroupId(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingItemStorageLocationLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingItemStorageLocationLocalService.class.getName());

            if (invokableLocalService instanceof ShoppingItemStorageLocationLocalService) {
                _service = (ShoppingItemStorageLocationLocalService) invokableLocalService;
            } else {
                _service = new ShoppingItemStorageLocationLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ShoppingItemStorageLocationLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingItemStorageLocationLocalService service) {
    }
}
