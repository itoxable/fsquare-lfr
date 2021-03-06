package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ShoppingStore. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingStoreLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStoreLocalService
 * @see com.fsquare.shopping.service.base.ShoppingStoreLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingStoreLocalServiceImpl
 * @generated
 */
public class ShoppingStoreLocalServiceUtil {
    private static ShoppingStoreLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingStoreLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the shopping store to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingStore the shopping store
    * @return the shopping store that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore addShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addShoppingStore(shoppingStore);
    }

    /**
    * Creates a new shopping store with the primary key. Does not add the shopping store to the database.
    *
    * @param companyId the primary key for the new shopping store
    * @return the new shopping store
    */
    public static com.fsquare.shopping.model.ShoppingStore createShoppingStore(
        long companyId) {
        return getService().createShoppingStore(companyId);
    }

    /**
    * Deletes the shopping store with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param companyId the primary key of the shopping store
    * @return the shopping store that was removed
    * @throws PortalException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore deleteShoppingStore(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteShoppingStore(companyId);
    }

    /**
    * Deletes the shopping store from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingStore the shopping store
    * @return the shopping store that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore deleteShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteShoppingStore(shoppingStore);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.fsquare.shopping.model.ShoppingStore fetchShoppingStore(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchShoppingStore(companyId);
    }

    /**
    * Returns the shopping store with the primary key.
    *
    * @param companyId the primary key of the shopping store
    * @return the shopping store
    * @throws PortalException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore getShoppingStore(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingStore(companyId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.fsquare.shopping.model.ShoppingStore> getShoppingStores(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingStores(start, end);
    }

    /**
    * Returns the number of shopping stores.
    *
    * @return the number of shopping stores
    * @throws SystemException if a system exception occurred
    */
    public static int getShoppingStoresCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingStoresCount();
    }

    /**
    * Updates the shopping store in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingStore the shopping store
    * @return the shopping store that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore updateShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateShoppingStore(shoppingStore);
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

    public static java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> getShoppingStorageLocationsByGroup(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingStorageLocationsByGroup(companyId);
    }

    public static java.util.List<java.lang.String[]> getShoppingLayouts(
        long companyId) {
        return getService().getShoppingLayouts(companyId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingStoreLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingStoreLocalService.class.getName());

            if (invokableLocalService instanceof ShoppingStoreLocalService) {
                _service = (ShoppingStoreLocalService) invokableLocalService;
            } else {
                _service = new ShoppingStoreLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ShoppingStoreLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingStoreLocalService service) {
    }
}
