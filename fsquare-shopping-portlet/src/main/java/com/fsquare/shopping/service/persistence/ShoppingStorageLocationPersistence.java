package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingStorageLocation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping storage location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorageLocationPersistenceImpl
 * @see ShoppingStorageLocationUtil
 * @generated
 */
public interface ShoppingStorageLocationPersistence extends BasePersistence<ShoppingStorageLocation> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingStorageLocationUtil} to access the shopping storage location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the shopping storage locations where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping storage locations where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping storage locations
    * @param end the upper bound of the range of shopping storage locations (not inclusive)
    * @return the range of matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping storage locations where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping storage locations
    * @param end the upper bound of the range of shopping storage locations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping storage location, or <code>null</code> if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping storage location in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping storage location, or <code>null</code> if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping storage locations before and after the current shopping storage location in the ordered set where groupId = &#63;.
    *
    * @param storageLocationId the primary key of the current shopping storage location
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation[] findByGroupId_PrevAndNext(
        long storageLocationId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping storage locations where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping storage locations where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping storage location in the entity cache if it is enabled.
    *
    * @param shoppingStorageLocation the shopping storage location
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation);

    /**
    * Caches the shopping storage locations in the entity cache if it is enabled.
    *
    * @param shoppingStorageLocations the shopping storage locations
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> shoppingStorageLocations);

    /**
    * Creates a new shopping storage location with the primary key. Does not add the shopping storage location to the database.
    *
    * @param storageLocationId the primary key for the new shopping storage location
    * @return the new shopping storage location
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation create(
        long storageLocationId);

    /**
    * Removes the shopping storage location with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation remove(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingStorageLocation updateImpl(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping storage location with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingStorageLocationException} if it could not be found.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation findByPrimaryKey(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping storage location with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location, or <code>null</code> if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStorageLocation fetchByPrimaryKey(
        long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping storage locations.
    *
    * @return the shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping storage locations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping storage locations
    * @param end the upper bound of the range of shopping storage locations (not inclusive)
    * @return the range of shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping storage locations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping storage locations
    * @param end the upper bound of the range of shopping storage locations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping storage locations from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping storage locations.
    *
    * @return the number of shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
