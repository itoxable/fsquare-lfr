package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemImage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping item image service. This utility wraps {@link ShoppingItemImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemImagePersistence
 * @see ShoppingItemImagePersistenceImpl
 * @generated
 */
public class ShoppingItemImageUtil {
    private static ShoppingItemImagePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(ShoppingItemImage shoppingItemImage) {
        getPersistence().clearCache(shoppingItemImage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ShoppingItemImage> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingItemImage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingItemImage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingItemImage update(ShoppingItemImage shoppingItemImage)
        throws SystemException {
        return getPersistence().update(shoppingItemImage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingItemImage update(
        ShoppingItemImage shoppingItemImage, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(shoppingItemImage, serviceContext);
    }

    /**
    * Returns all the shopping item images where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the shopping item images where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @return the range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping item images where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the shopping item images before and after the current shopping item image in the ordered set where groupId = &#63;.
    *
    * @param shoppingItemImageId the primary key of the current shopping item image
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage[] findByGroupId_PrevAndNext(
        long shoppingItemImageId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(shoppingItemImageId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the shopping item images where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of shopping item images where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @return the matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupIdAndItemId(
        long groupId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupIdAndItemId(groupId, itemId);
    }

    /**
    * Returns a range of all the shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @return the range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupIdAndItemId(
        long groupId, long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndItemId(groupId, itemId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupIdAndItemId(
        long groupId, long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndItemId(groupId, itemId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage findByGroupIdAndItemId_First(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndItemId_First(groupId, itemId,
            orderByComparator);
    }

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemId_First(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdAndItemId_First(groupId, itemId,
            orderByComparator);
    }

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage findByGroupIdAndItemId_Last(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndItemId_Last(groupId, itemId,
            orderByComparator);
    }

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemId_Last(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdAndItemId_Last(groupId, itemId,
            orderByComparator);
    }

    /**
    * Returns the shopping item images before and after the current shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param shoppingItemImageId the primary key of the current shopping item image
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage[] findByGroupIdAndItemId_PrevAndNext(
        long shoppingItemImageId, long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndItemId_PrevAndNext(shoppingItemImageId,
            groupId, itemId, orderByComparator);
    }

    /**
    * Removes all the shopping item images where groupId = &#63; and itemId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupIdAndItemId(long groupId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupIdAndItemId(groupId, itemId);
    }

    /**
    * Returns the number of shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @return the number of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupIdAndItemId(long groupId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupIdAndItemId(groupId, itemId);
    }

    /**
    * Returns the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemImageException} if it could not be found.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage findByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndItemAndMain(groupId, itemId, mainImage);
    }

    /**
    * Returns the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdAndItemAndMain(groupId, itemId, mainImage);
    }

    /**
    * Returns the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupIdAndItemAndMain(groupId, itemId, mainImage,
            retrieveFromCache);
    }

    /**
    * Removes the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; from the database.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the shopping item image that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage removeByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByGroupIdAndItemAndMain(groupId, itemId, mainImage);
    }

    /**
    * Returns the number of shopping item images where groupId = &#63; and itemId = &#63; and mainImage = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the number of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupIdAndItemAndMain(long groupId, long itemId,
        boolean mainImage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByGroupIdAndItemAndMain(groupId, itemId, mainImage);
    }

    /**
    * Caches the shopping item image in the entity cache if it is enabled.
    *
    * @param shoppingItemImage the shopping item image
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage) {
        getPersistence().cacheResult(shoppingItemImage);
    }

    /**
    * Caches the shopping item images in the entity cache if it is enabled.
    *
    * @param shoppingItemImages the shopping item images
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItemImage> shoppingItemImages) {
        getPersistence().cacheResult(shoppingItemImages);
    }

    /**
    * Creates a new shopping item image with the primary key. Does not add the shopping item image to the database.
    *
    * @param shoppingItemImageId the primary key for the new shopping item image
    * @return the new shopping item image
    */
    public static com.fsquare.shopping.model.ShoppingItemImage create(
        long shoppingItemImageId) {
        return getPersistence().create(shoppingItemImageId);
    }

    /**
    * Removes the shopping item image with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage remove(
        long shoppingItemImageId)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(shoppingItemImageId);
    }

    public static com.fsquare.shopping.model.ShoppingItemImage updateImpl(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingItemImage);
    }

    /**
    * Returns the shopping item image with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemImageException} if it could not be found.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage findByPrimaryKey(
        long shoppingItemImageId)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(shoppingItemImageId);
    }

    /**
    * Returns the shopping item image with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image, or <code>null</code> if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemImage fetchByPrimaryKey(
        long shoppingItemImageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(shoppingItemImageId);
    }

    /**
    * Returns all the shopping item images.
    *
    * @return the shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping item images.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping item images from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping item images.
    *
    * @return the number of shopping item images
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingItemImagePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingItemImagePersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingItemImagePersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingItemImageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingItemImagePersistence persistence) {
    }
}
