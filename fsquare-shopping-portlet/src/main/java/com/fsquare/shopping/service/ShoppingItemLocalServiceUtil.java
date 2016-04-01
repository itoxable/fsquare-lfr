package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ShoppingItem. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemLocalService
 * @see com.fsquare.shopping.service.base.ShoppingItemLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingItemLocalServiceImpl
 * @generated
 */
public class ShoppingItemLocalServiceUtil {
    private static ShoppingItemLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the shopping item to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItem the shopping item
    * @return the shopping item that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem addShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addShoppingItem(shoppingItem);
    }

    /**
    * Creates a new shopping item with the primary key. Does not add the shopping item to the database.
    *
    * @param itemId the primary key for the new shopping item
    * @return the new shopping item
    */
    public static com.fsquare.shopping.model.ShoppingItem createShoppingItem(
        long itemId) {
        return getService().createShoppingItem(itemId);
    }

    /**
    * Deletes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item that was removed
    * @throws PortalException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem deleteShoppingItem(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteShoppingItem(itemId);
    }

    /**
    * Deletes the shopping item from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItem the shopping item
    * @return the shopping item that was removed
    * @throws PortalException
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem deleteShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteShoppingItem(shoppingItem);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.fsquare.shopping.model.ShoppingItem fetchShoppingItem(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchShoppingItem(itemId);
    }

    /**
    * Returns the shopping item with the matching UUID and company.
    *
    * @param uuid the shopping item's UUID
    * @param companyId the primary key of the company
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchShoppingItemByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchShoppingItemByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the shopping item matching the UUID and group.
    *
    * @param uuid the shopping item's UUID
    * @param groupId the primary key of the group
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchShoppingItemByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchShoppingItemByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the shopping item with the primary key.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item
    * @throws PortalException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem getShoppingItem(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItem(itemId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static com.fsquare.shopping.model.ShoppingItem getShoppingItemByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemByUuidAndCompanyId(uuid, companyId);
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
    public static com.fsquare.shopping.model.ShoppingItem getShoppingItemByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemByUuidAndGroupId(uuid, groupId);
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
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> getShoppingItems(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItems(start, end);
    }

    /**
    * Returns the number of shopping items.
    *
    * @return the number of shopping items
    * @throws SystemException if a system exception occurred
    */
    public static int getShoppingItemsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemsCount();
    }

    /**
    * Updates the shopping item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingItem the shopping item
    * @return the shopping item that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem updateShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateShoppingItem(shoppingItem);
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

    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByGroupId(groupId);
    }

    public static com.fsquare.shopping.model.ShoppingItem addShoppingItem(
        com.fsquare.shopping.model.ShoppingItem shoppingItem, long userId,
        java.util.List<byte[]> images,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return getService()
                   .addShoppingItem(shoppingItem, userId, images, serviceContext);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> getItemImages(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getItemImages(shoppingItem);
    }

    public static com.liferay.portlet.asset.model.AssetEntry getEntry(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEntry(itemId);
    }

    public static int availableQuantity(long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().availableQuantity(itemId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingItemLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingItemLocalService.class.getName());

            if (invokableLocalService instanceof ShoppingItemLocalService) {
                _service = (ShoppingItemLocalService) invokableLocalService;
            } else {
                _service = new ShoppingItemLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ShoppingItemLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingItemLocalService service) {
    }
}
