package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ShoppingItemImage. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingItemImageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemImageLocalService
 * @see com.fsquare.shopping.service.base.ShoppingItemImageLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingItemImageLocalServiceImpl
 * @generated
 */
public class ShoppingItemImageLocalServiceUtil {
    private static ShoppingItemImageLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingItemImageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the shopping item image to the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemImage the shopping item image
    * @return the shopping item image that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage addShoppingItemImage(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addShoppingItemImage(shoppingItemImage);
    }

    /**
    * Creates a new shopping item image with the primary key. Does not add the shopping item image to the database.
    *
    * @param shoppingItemImageId the primary key for the new shopping item image
    * @return the new shopping item image
    */
    public static com.fsquare.shopping.model.ShoppingItemImage createShoppingItemImage(
        long shoppingItemImageId) {
        return getService().createShoppingItemImage(shoppingItemImageId);
    }

    /**
    * Deletes the shopping item image with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image that was removed
    * @throws PortalException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage deleteShoppingItemImage(
        long shoppingItemImageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteShoppingItemImage(shoppingItemImageId);
    }

    /**
    * Deletes the shopping item image from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemImage the shopping item image
    * @return the shopping item image that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage deleteShoppingItemImage(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteShoppingItemImage(shoppingItemImage);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.fsquare.shopping.model.ShoppingItemImage fetchShoppingItemImage(
        long shoppingItemImageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchShoppingItemImage(shoppingItemImageId);
    }

    /**
    * Returns the shopping item image with the primary key.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image
    * @throws PortalException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage getShoppingItemImage(
        long shoppingItemImageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemImage(shoppingItemImageId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the shopping item images.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @return the range of shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> getShoppingItemImages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemImages(start, end);
    }

    /**
    * Returns the number of shopping item images.
    *
    * @return the number of shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static int getShoppingItemImagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingItemImagesCount();
    }

    /**
    * Updates the shopping item image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemImage the shopping item image
    * @return the shopping item image that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage updateShoppingItemImage(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateShoppingItemImage(shoppingItemImage);
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

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByCompanyIdAndItemId(
        long companyId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCompanyIdAndItemId(companyId, itemId);
    }

    public static com.fsquare.shopping.model.ShoppingItemImage getItemMainImage(
        long companyId, long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getItemMainImage(companyId, itemId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingItemImageLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingItemImageLocalService.class.getName());

            if (invokableLocalService instanceof ShoppingItemImageLocalService) {
                _service = (ShoppingItemImageLocalService) invokableLocalService;
            } else {
                _service = new ShoppingItemImageLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ShoppingItemImageLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingItemImageLocalService service) {
    }
}
