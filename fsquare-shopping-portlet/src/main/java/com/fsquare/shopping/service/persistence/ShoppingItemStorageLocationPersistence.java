package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemStorageLocation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping item storage location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocationPersistenceImpl
 * @see ShoppingItemStorageLocationUtil
 * @generated
 */
public interface ShoppingItemStorageLocationPersistence extends BasePersistence<ShoppingItemStorageLocation> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingItemStorageLocationUtil} to access the shopping item storage location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the shopping item storage locations where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping item storage locations where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @return the range of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping item storage locations where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage locations before and after the current shopping item storage location in the ordered set where groupId = &#63;.
    *
    * @param itemStorageLocationId the primary key of the current shopping item storage location
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation[] findByGroupId_PrevAndNext(
        long itemStorageLocationId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item storage locations where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item storage locations where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping item storage locations where storageLocationId = &#63;.
    *
    * @param storageLocationId the storage location ID
    * @return the matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping item storage locations where storageLocationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param storageLocationId the storage location ID
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @return the range of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping item storage locations where storageLocationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param storageLocationId the storage location ID
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item storage location in the ordered set where storageLocationId = &#63;.
    *
    * @param storageLocationId the storage location ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByStorageLocationId_First(
        long storageLocationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item storage location in the ordered set where storageLocationId = &#63;.
    *
    * @param storageLocationId the storage location ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByStorageLocationId_First(
        long storageLocationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item storage location in the ordered set where storageLocationId = &#63;.
    *
    * @param storageLocationId the storage location ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByStorageLocationId_Last(
        long storageLocationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item storage location in the ordered set where storageLocationId = &#63;.
    *
    * @param storageLocationId the storage location ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByStorageLocationId_Last(
        long storageLocationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage locations before and after the current shopping item storage location in the ordered set where storageLocationId = &#63;.
    *
    * @param itemStorageLocationId the primary key of the current shopping item storage location
    * @param storageLocationId the storage location ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation[] findByStorageLocationId_PrevAndNext(
        long itemStorageLocationId, long storageLocationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item storage locations where storageLocationId = &#63; from the database.
    *
    * @param storageLocationId the storage location ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByStorageLocationId(long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item storage locations where storageLocationId = &#63;.
    *
    * @param storageLocationId the storage location ID
    * @return the number of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public int countByStorageLocationId(long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping item storage locations where itemId = &#63;.
    *
    * @param itemId the item ID
    * @return the matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByItemId(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping item storage locations where itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemId the item ID
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @return the range of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByItemId(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping item storage locations where itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemId the item ID
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByItemId(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item storage location in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByItemId_First(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item storage location in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByItemId_First(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item storage location in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByItemId_Last(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item storage location in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByItemId_Last(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage locations before and after the current shopping item storage location in the ordered set where itemId = &#63;.
    *
    * @param itemStorageLocationId the primary key of the current shopping item storage location
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation[] findByItemId_PrevAndNext(
        long itemStorageLocationId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item storage locations where itemId = &#63; from the database.
    *
    * @param itemId the item ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByItemId(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item storage locations where itemId = &#63;.
    *
    * @param itemId the item ID
    * @return the number of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public int countByItemId(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage location where itemId = &#63; and storageLocationId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemStorageLocationException} if it could not be found.
    *
    * @param itemId the item ID
    * @param storageLocationId the storage location ID
    * @return the matching shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage location where itemId = &#63; and storageLocationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param itemId the item ID
    * @param storageLocationId the storage location ID
    * @return the matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage location where itemId = &#63; and storageLocationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param itemId the item ID
    * @param storageLocationId the storage location ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByItemIdAndStorageLocationId(
        long itemId, long storageLocationId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the shopping item storage location where itemId = &#63; and storageLocationId = &#63; from the database.
    *
    * @param itemId the item ID
    * @param storageLocationId the storage location ID
    * @return the shopping item storage location that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation removeByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item storage locations where itemId = &#63; and storageLocationId = &#63;.
    *
    * @param itemId the item ID
    * @param storageLocationId the storage location ID
    * @return the number of matching shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public int countByItemIdAndStorageLocationId(long itemId,
        long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping item storage location in the entity cache if it is enabled.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation);

    /**
    * Caches the shopping item storage locations in the entity cache if it is enabled.
    *
    * @param shoppingItemStorageLocations the shopping item storage locations
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> shoppingItemStorageLocations);

    /**
    * Creates a new shopping item storage location with the primary key. Does not add the shopping item storage location to the database.
    *
    * @param itemStorageLocationId the primary key for the new shopping item storage location
    * @return the new shopping item storage location
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation create(
        long itemStorageLocationId);

    /**
    * Removes the shopping item storage location with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation remove(
        long itemStorageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingItemStorageLocation updateImpl(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage location with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemStorageLocationException} if it could not be found.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByPrimaryKey(
        long itemStorageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item storage location with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location, or <code>null</code> if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByPrimaryKey(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping item storage locations.
    *
    * @return the shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping item storage locations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item storage locations
    * @param end the upper bound of the range of shopping item storage locations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item storage locations from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item storage locations.
    *
    * @return the number of shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
