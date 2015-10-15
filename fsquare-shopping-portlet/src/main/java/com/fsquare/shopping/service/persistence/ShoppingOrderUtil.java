package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingOrder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping order service. This utility wraps {@link ShoppingOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderPersistence
 * @see ShoppingOrderPersistenceImpl
 * @generated
 */
public class ShoppingOrderUtil {
    private static ShoppingOrderPersistence _persistence;

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
    public static void clearCache(ShoppingOrder shoppingOrder) {
        getPersistence().clearCache(shoppingOrder);
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
    public static List<ShoppingOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingOrder update(ShoppingOrder shoppingOrder)
        throws SystemException {
        return getPersistence().update(shoppingOrder);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingOrder update(ShoppingOrder shoppingOrder,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingOrder, serviceContext);
    }

    /**
    * Returns all the shopping orders where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the shopping orders where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the shopping orders before and after the current shopping order in the ordered set where groupId = &#63;.
    *
    * @param orderId the primary key of the current shopping order
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder[] findByGroupId_PrevAndNext(
        long orderId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(orderId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the shopping orders where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of shopping orders where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the shopping order where number = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param number the number
    * @return the matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByNumber(
        java.lang.String number)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNumber(number);
    }

    /**
    * Returns the shopping order where number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param number the number
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByNumber(
        java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNumber(number);
    }

    /**
    * Returns the shopping order where number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param number the number
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByNumber(
        java.lang.String number, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNumber(number, retrieveFromCache);
    }

    /**
    * Removes the shopping order where number = &#63; from the database.
    *
    * @param number the number
    * @return the shopping order that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder removeByNumber(
        java.lang.String number)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByNumber(number);
    }

    /**
    * Returns the number of shopping orders where number = &#63;.
    *
    * @param number the number
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByNumber(java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNumber(number);
    }

    /**
    * Returns the shopping order where ppTxnId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param ppTxnId the pp txn ID
    * @return the matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByPPTxnId(
        java.lang.String ppTxnId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPPTxnId(ppTxnId);
    }

    /**
    * Returns the shopping order where ppTxnId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param ppTxnId the pp txn ID
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByPPTxnId(
        java.lang.String ppTxnId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPPTxnId(ppTxnId);
    }

    /**
    * Returns the shopping order where ppTxnId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param ppTxnId the pp txn ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByPPTxnId(
        java.lang.String ppTxnId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPPTxnId(ppTxnId, retrieveFromCache);
    }

    /**
    * Removes the shopping order where ppTxnId = &#63; from the database.
    *
    * @param ppTxnId the pp txn ID
    * @return the shopping order that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder removeByPPTxnId(
        java.lang.String ppTxnId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByPPTxnId(ppTxnId);
    }

    /**
    * Returns the number of shopping orders where ppTxnId = &#63;.
    *
    * @param ppTxnId the pp txn ID
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByPPTxnId(java.lang.String ppTxnId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPPTxnId(ppTxnId);
    }

    /**
    * Returns the shopping order where status = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param status the status
    * @return the matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByStatus(
        java.lang.String status)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus(status);
    }

    /**
    * Returns the shopping order where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param status the status
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByStatus(
        java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus(status);
    }

    /**
    * Returns the shopping order where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param status the status
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByStatus(
        java.lang.String status, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus(status, retrieveFromCache);
    }

    /**
    * Removes the shopping order where status = &#63; from the database.
    *
    * @param status the status
    * @return the shopping order that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder removeByStatus(
        java.lang.String status)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByStatus(status);
    }

    /**
    * Returns the number of shopping orders where status = &#63;.
    *
    * @param status the status
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByStatus(java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStatus(status);
    }

    /**
    * Returns all the shopping orders where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @return the matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByG_U_PPPS(
        long groupId, long userId, java.lang.String ppPaymentStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U_PPPS(groupId, userId, ppPaymentStatus);
    }

    /**
    * Returns a range of all the shopping orders where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByG_U_PPPS(
        long groupId, long userId, java.lang.String ppPaymentStatus, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_PPPS(groupId, userId, ppPaymentStatus, start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByG_U_PPPS(
        long groupId, long userId, java.lang.String ppPaymentStatus, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_PPPS(groupId, userId, ppPaymentStatus, start,
            end, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByG_U_PPPS_First(
        long groupId, long userId, java.lang.String ppPaymentStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_PPPS_First(groupId, userId, ppPaymentStatus,
            orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByG_U_PPPS_First(
        long groupId, long userId, java.lang.String ppPaymentStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_PPPS_First(groupId, userId, ppPaymentStatus,
            orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByG_U_PPPS_Last(
        long groupId, long userId, java.lang.String ppPaymentStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_PPPS_Last(groupId, userId, ppPaymentStatus,
            orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByG_U_PPPS_Last(
        long groupId, long userId, java.lang.String ppPaymentStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_PPPS_Last(groupId, userId, ppPaymentStatus,
            orderByComparator);
    }

    /**
    * Returns the shopping orders before and after the current shopping order in the ordered set where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * @param orderId the primary key of the current shopping order
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder[] findByG_U_PPPS_PrevAndNext(
        long orderId, long groupId, long userId,
        java.lang.String ppPaymentStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_PPPS_PrevAndNext(orderId, groupId, userId,
            ppPaymentStatus, orderByComparator);
    }

    /**
    * Removes all the shopping orders where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_U_PPPS(long groupId, long userId,
        java.lang.String ppPaymentStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_U_PPPS(groupId, userId, ppPaymentStatus);
    }

    /**
    * Returns the number of shopping orders where groupId = &#63; and userId = &#63; and ppPaymentStatus = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param ppPaymentStatus the pp payment status
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_U_PPPS(long groupId, long userId,
        java.lang.String ppPaymentStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_U_PPPS(groupId, userId, ppPaymentStatus);
    }

    /**
    * Caches the shopping order in the entity cache if it is enabled.
    *
    * @param shoppingOrder the shopping order
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder) {
        getPersistence().cacheResult(shoppingOrder);
    }

    /**
    * Caches the shopping orders in the entity cache if it is enabled.
    *
    * @param shoppingOrders the shopping orders
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingOrder> shoppingOrders) {
        getPersistence().cacheResult(shoppingOrders);
    }

    /**
    * Creates a new shopping order with the primary key. Does not add the shopping order to the database.
    *
    * @param orderId the primary key for the new shopping order
    * @return the new shopping order
    */
    public static com.fsquare.shopping.model.ShoppingOrder create(long orderId) {
        return getPersistence().create(orderId);
    }

    /**
    * Removes the shopping order with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param orderId the primary key of the shopping order
    * @return the shopping order that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder remove(long orderId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(orderId);
    }

    public static com.fsquare.shopping.model.ShoppingOrder updateImpl(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingOrder);
    }

    /**
    * Returns the shopping order with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param orderId the primary key of the shopping order
    * @return the shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByPrimaryKey(
        long orderId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(orderId);
    }

    /**
    * Returns the shopping order with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param orderId the primary key of the shopping order
    * @return the shopping order, or <code>null</code> if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByPrimaryKey(
        long orderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(orderId);
    }

    /**
    * Returns all the shopping orders.
    *
    * @return the shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the shopping orders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping orders from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping orders.
    *
    * @return the number of shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingOrderPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingOrderPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingOrderPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingOrderUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingOrderPersistence persistence) {
    }
}