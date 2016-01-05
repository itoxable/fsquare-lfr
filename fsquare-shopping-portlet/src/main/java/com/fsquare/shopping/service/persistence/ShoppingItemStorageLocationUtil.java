package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemStorageLocation;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping item storage location service. This utility wraps {@link ShoppingItemStorageLocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocationPersistence
 * @see ShoppingItemStorageLocationPersistenceImpl
 * @generated
 */
public class ShoppingItemStorageLocationUtil {
    private static ShoppingItemStorageLocationPersistence _persistence;

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
    public static void clearCache(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        getPersistence().clearCache(shoppingItemStorageLocation);
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
    public static List<ShoppingItemStorageLocation> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingItemStorageLocation> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingItemStorageLocation> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingItemStorageLocation update(
        ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws SystemException {
        return getPersistence().update(shoppingItemStorageLocation);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingItemStorageLocation update(
        ShoppingItemStorageLocation shoppingItemStorageLocation,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(shoppingItemStorageLocation, serviceContext);
    }

    /**
    * Caches the shopping item storage location in the entity cache if it is enabled.
    *
    * @param shoppingItemStorageLocation the shopping item storage location
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation) {
        getPersistence().cacheResult(shoppingItemStorageLocation);
    }

    /**
    * Caches the shopping item storage locations in the entity cache if it is enabled.
    *
    * @param shoppingItemStorageLocations the shopping item storage locations
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> shoppingItemStorageLocations) {
        getPersistence().cacheResult(shoppingItemStorageLocations);
    }

    /**
    * Creates a new shopping item storage location with the primary key. Does not add the shopping item storage location to the database.
    *
    * @param itemStorageLocationId the primary key for the new shopping item storage location
    * @return the new shopping item storage location
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation create(
        long itemStorageLocationId) {
        return getPersistence().create(itemStorageLocationId);
    }

    /**
    * Removes the shopping item storage location with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation remove(
        long itemStorageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(itemStorageLocationId);
    }

    public static com.fsquare.shopping.model.ShoppingItemStorageLocation updateImpl(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingItemStorageLocation);
    }

    /**
    * Returns the shopping item storage location with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemStorageLocationException} if it could not be found.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location
    * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation findByPrimaryKey(
        long itemStorageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(itemStorageLocationId);
    }

    /**
    * Returns the shopping item storage location with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemStorageLocationId the primary key of the shopping item storage location
    * @return the shopping item storage location, or <code>null</code> if a shopping item storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemStorageLocation fetchByPrimaryKey(
        long itemStorageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(itemStorageLocationId);
    }

    /**
    * Returns all the shopping item storage locations.
    *
    * @return the shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping item storage locations from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping item storage locations.
    *
    * @return the number of shopping item storage locations
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingItemStorageLocationPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingItemStorageLocationPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingItemStorageLocationPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingItemStorageLocationUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(
        ShoppingItemStorageLocationPersistence persistence) {
    }
}
