package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPersistenceImpl
 * @see ShoppingItemUtil
 * @generated
 */
public interface ShoppingItemPersistence extends BasePersistence<ShoppingItem> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingItemUtil} to access the shopping item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the shopping items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.fsquare.shopping.model.ShoppingItem[] findByUuid_PrevAndNext(
        long itemId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping items where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item where uuid = &#63; and groupId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the shopping item where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the shopping item that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping items where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping items where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.fsquare.shopping.model.ShoppingItem findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.fsquare.shopping.model.ShoppingItem findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.fsquare.shopping.model.ShoppingItem[] findByUuid_C_PrevAndNext(
        long itemId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping items where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping items where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping items where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.fsquare.shopping.model.ShoppingItem[] findByCompanyId_PrevAndNext(
        long itemId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping items where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping items where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping items
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping item in the entity cache if it is enabled.
    *
    * @param shoppingItem the shopping item
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingItem shoppingItem);

    /**
    * Caches the shopping items in the entity cache if it is enabled.
    *
    * @param shoppingItems the shopping items
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItem> shoppingItems);

    /**
    * Creates a new shopping item with the primary key. Does not add the shopping item to the database.
    *
    * @param itemId the primary key for the new shopping item
    * @return the new shopping item
    */
    public com.fsquare.shopping.model.ShoppingItem create(long itemId);

    /**
    * Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem remove(long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingItem updateImpl(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemException} if it could not be found.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item
    * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem findByPrimaryKey(long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemId the primary key of the shopping item
    * @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItem fetchByPrimaryKey(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping items.
    *
    * @return the shopping items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping items.
    *
    * @return the number of shopping items
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
