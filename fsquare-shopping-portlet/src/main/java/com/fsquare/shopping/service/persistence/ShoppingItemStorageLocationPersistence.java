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
