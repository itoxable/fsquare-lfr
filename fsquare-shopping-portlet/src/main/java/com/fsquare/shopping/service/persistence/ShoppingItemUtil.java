package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping item service. This utility wraps {@link ShoppingItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPersistence
 * @see ShoppingItemPersistenceImpl
 * @generated
 */
public class ShoppingItemUtil {
    private static ShoppingItemPersistence _persistence;

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
    public static void clearCache(ShoppingItem shoppingItem) {
        getPersistence().clearCache(shoppingItem);
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
    public static List<ShoppingItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingItem update(ShoppingItem shoppingItem)
        throws SystemException {
        return getPersistence().update(shoppingItem);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingItem update(ShoppingItem shoppingItem,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingItem, serviceContext);
    }

    /**
    * Returns all the shopping items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the shopping items where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @return the range of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the shopping items where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the shopping items before and after the current shopping item in the ordered set where uuid = &#63;.
    *
    * @param itemId the primary key of the current shopping item
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem[] findByUuid_PrevAndNext(
        long itemId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(itemId, uuid, orderByComparator);
    }

    /**
    * Removes all the shopping items where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of shopping items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the shopping item where uuid = &#63; and groupId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the shopping item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the shopping item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the shopping item where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the shopping item that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of shopping items where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the shopping items where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the shopping items where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @return the range of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping items where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the shopping items before and after the current shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param itemId the primary key of the current shopping item
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem[] findByUuid_C_PrevAndNext(
        long itemId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(itemId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the shopping items where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of shopping items where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the shopping items where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the shopping items where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @return the range of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping items where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the shopping items before and after the current shopping item in the ordered set where companyId = &#63;.
    *
    * @param itemId the primary key of the current shopping item
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem[] findByCompanyId_PrevAndNext(
        long itemId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(itemId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the shopping items where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of shopping items where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Caches the shopping item in the entity cache if it is enabled.
    *
    * @param shoppingItem the shopping item
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingItem shoppingItem) {
        getPersistence().cacheResult(shoppingItem);
    }

    /**
    * Caches the shopping items in the entity cache if it is enabled.
    *
    * @param shoppingItems the shopping items
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItem> shoppingItems) {
        getPersistence().cacheResult(shoppingItems);
    }

    /**
    * Creates a new shopping item with the primary key. Does not add the shopping item to the database.
    *
    * @param itemId the primary key for the new shopping item
    * @return the new shopping item
    */
    public static com.fsquare.shopping.model.ShoppingItem create(long itemId) {
        return getPersistence().create(itemId);
    }

    /**
    * Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem remove(long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(itemId);
    }

    public static com.fsquare.shopping.model.ShoppingItem updateImpl(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingItem);
    }

    /**
    * Returns the shopping item with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemException} if it could not be found.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem findByPrimaryKey(
        long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(itemId);
    }

    /**
    * Returns the shopping item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItem fetchByPrimaryKey(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(itemId);
    }

    /**
    * Returns all the shopping items.
    *
    * @return the shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping items
    * @param end the upper bound of the range of shopping items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping items.
    *
    * @return the number of shopping items
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingItemPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingItemPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingItemPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingItemUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingItemPersistence persistence) {
    }
}
