package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingOrderItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping order item service. This utility wraps {@link ShoppingOrderItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemPersistence
 * @see ShoppingOrderItemPersistenceImpl
 * @generated
 */
public class ShoppingOrderItemUtil {
    private static ShoppingOrderItemPersistence _persistence;

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
    public static void clearCache(ShoppingOrderItem shoppingOrderItem) {
        getPersistence().clearCache(shoppingOrderItem);
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
    public static List<ShoppingOrderItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingOrderItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingOrderItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingOrderItem update(ShoppingOrderItem shoppingOrderItem)
        throws SystemException {
        return getPersistence().update(shoppingOrderItem);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingOrderItem update(
        ShoppingOrderItem shoppingOrderItem, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(shoppingOrderItem, serviceContext);
    }

    /**
    * Returns all the shopping order items where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @return the matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByShoppingOrderId(
        long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByShoppingOrderId(shoppingOrderId);
    }

    /**
    * Returns a range of all the shopping order items where shoppingOrderId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param shoppingOrderId the shopping order ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @return the range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByShoppingOrderId(
        long shoppingOrderId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShoppingOrderId(shoppingOrderId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping order items where shoppingOrderId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param shoppingOrderId the shopping order ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByShoppingOrderId(
        long shoppingOrderId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShoppingOrderId(shoppingOrderId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem findByShoppingOrderId_First(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShoppingOrderId_First(shoppingOrderId,
            orderByComparator);
    }

    /**
    * Returns the first shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderId_First(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByShoppingOrderId_First(shoppingOrderId,
            orderByComparator);
    }

    /**
    * Returns the last shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem findByShoppingOrderId_Last(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShoppingOrderId_Last(shoppingOrderId,
            orderByComparator);
    }

    /**
    * Returns the last shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderId_Last(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByShoppingOrderId_Last(shoppingOrderId,
            orderByComparator);
    }

    /**
    * Returns the shopping order items before and after the current shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderItemId the primary key of the current shopping order item
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem[] findByShoppingOrderId_PrevAndNext(
        long shoppingOrderItemId, long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShoppingOrderId_PrevAndNext(shoppingOrderItemId,
            shoppingOrderId, orderByComparator);
    }

    /**
    * Removes all the shopping order items where shoppingOrderId = &#63; from the database.
    *
    * @param shoppingOrderId the shopping order ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByShoppingOrderId(long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByShoppingOrderId(shoppingOrderId);
    }

    /**
    * Returns the number of shopping order items where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @return the number of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static int countByShoppingOrderId(long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByShoppingOrderId(shoppingOrderId);
    }

    /**
    * Returns the shopping order item where shoppingOrderItemId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderItemException} if it could not be found.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem findByShoppingOrderItemId(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByShoppingOrderItemId(shoppingOrderItemId);
    }

    /**
    * Returns the shopping order item where shoppingOrderItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderItemId(
        long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByShoppingOrderItemId(shoppingOrderItemId);
    }

    /**
    * Returns the shopping order item where shoppingOrderItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderItemId(
        long shoppingOrderItemId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByShoppingOrderItemId(shoppingOrderItemId,
            retrieveFromCache);
    }

    /**
    * Removes the shopping order item where shoppingOrderItemId = &#63; from the database.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the shopping order item that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem removeByShoppingOrderItemId(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByShoppingOrderItemId(shoppingOrderItemId);
    }

    /**
    * Returns the number of shopping order items where shoppingOrderItemId = &#63;.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the number of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static int countByShoppingOrderItemId(long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByShoppingOrderItemId(shoppingOrderItemId);
    }

    /**
    * Returns all the shopping order items where articleId = &#63;.
    *
    * @param articleId the article ID
    * @return the matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByArticleId(
        java.lang.String articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByArticleId(articleId);
    }

    /**
    * Returns a range of all the shopping order items where articleId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param articleId the article ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @return the range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByArticleId(
        java.lang.String articleId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByArticleId(articleId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping order items where articleId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param articleId the article ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByArticleId(
        java.lang.String articleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByArticleId(articleId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem findByArticleId_First(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByArticleId_First(articleId, orderByComparator);
    }

    /**
    * Returns the first shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem fetchByArticleId_First(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByArticleId_First(articleId, orderByComparator);
    }

    /**
    * Returns the last shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem findByArticleId_Last(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByArticleId_Last(articleId, orderByComparator);
    }

    /**
    * Returns the last shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem fetchByArticleId_Last(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByArticleId_Last(articleId, orderByComparator);
    }

    /**
    * Returns the shopping order items before and after the current shopping order item in the ordered set where articleId = &#63;.
    *
    * @param shoppingOrderItemId the primary key of the current shopping order item
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem[] findByArticleId_PrevAndNext(
        long shoppingOrderItemId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByArticleId_PrevAndNext(shoppingOrderItemId, articleId,
            orderByComparator);
    }

    /**
    * Removes all the shopping order items where articleId = &#63; from the database.
    *
    * @param articleId the article ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByArticleId(java.lang.String articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByArticleId(articleId);
    }

    /**
    * Returns the number of shopping order items where articleId = &#63;.
    *
    * @param articleId the article ID
    * @return the number of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static int countByArticleId(java.lang.String articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByArticleId(articleId);
    }

    /**
    * Caches the shopping order item in the entity cache if it is enabled.
    *
    * @param shoppingOrderItem the shopping order item
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem) {
        getPersistence().cacheResult(shoppingOrderItem);
    }

    /**
    * Caches the shopping order items in the entity cache if it is enabled.
    *
    * @param shoppingOrderItems the shopping order items
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItems) {
        getPersistence().cacheResult(shoppingOrderItems);
    }

    /**
    * Creates a new shopping order item with the primary key. Does not add the shopping order item to the database.
    *
    * @param shoppingOrderItemId the primary key for the new shopping order item
    * @return the new shopping order item
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem create(
        long shoppingOrderItemId) {
        return getPersistence().create(shoppingOrderItemId);
    }

    /**
    * Removes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem remove(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(shoppingOrderItemId);
    }

    public static com.fsquare.shopping.model.ShoppingOrderItem updateImpl(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingOrderItem);
    }

    /**
    * Returns the shopping order item with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderItemException} if it could not be found.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem findByPrimaryKey(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(shoppingOrderItemId);
    }

    /**
    * Returns the shopping order item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item, or <code>null</code> if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrderItem fetchByPrimaryKey(
        long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(shoppingOrderItemId);
    }

    /**
    * Returns all the shopping order items.
    *
    * @return the shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the shopping order items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @return the range of shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping order items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping order items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping order items.
    *
    * @return the number of shopping order items
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingOrderItemPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingOrderItemPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingOrderItemPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingOrderItemUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingOrderItemPersistence persistence) {
    }
}
