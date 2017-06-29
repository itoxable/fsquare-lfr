package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingStorageLocation;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping storage location service. This utility wraps {@link ShoppingStorageLocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorageLocationPersistence
 * @see ShoppingStorageLocationPersistenceImpl
 * @generated
 */
public class ShoppingStorageLocationUtil {
    private static ShoppingStorageLocationPersistence _persistence;

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
        ShoppingStorageLocation shoppingStorageLocation) {
        getPersistence().clearCache(shoppingStorageLocation);
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
    public static List<ShoppingStorageLocation> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingStorageLocation> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingStorageLocation> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingStorageLocation update(
        ShoppingStorageLocation shoppingStorageLocation)
        throws SystemException {
        return getPersistence().update(shoppingStorageLocation);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingStorageLocation update(
        ShoppingStorageLocation shoppingStorageLocation,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingStorageLocation, serviceContext);
    }

    /**
    * Returns all the shopping storage locations where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the shopping storage locations where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping storage locations
    * @param end the upper bound of the range of shopping storage locations (not inclusive)
    * @return the range of matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping storage locations where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping storage locations
    * @param end the upper bound of the range of shopping storage locations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping storage location in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first shopping storage location in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping storage location, or <code>null</code> if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping storage location in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping storage location in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping storage location, or <code>null</code> if a matching shopping storage location could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the shopping storage locations before and after the current shopping storage location in the ordered set where companyId = &#63;.
    *
    * @param storageLocationId the primary key of the current shopping storage location
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation[] findByCompanyId_PrevAndNext(
        long storageLocationId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(storageLocationId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the shopping storage locations where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of shopping storage locations where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Caches the shopping storage location in the entity cache if it is enabled.
    *
    * @param shoppingStorageLocation the shopping storage location
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation) {
        getPersistence().cacheResult(shoppingStorageLocation);
    }

    /**
    * Caches the shopping storage locations in the entity cache if it is enabled.
    *
    * @param shoppingStorageLocations the shopping storage locations
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> shoppingStorageLocations) {
        getPersistence().cacheResult(shoppingStorageLocations);
    }

    /**
    * Creates a new shopping storage location with the primary key. Does not add the shopping storage location to the database.
    *
    * @param storageLocationId the primary key for the new shopping storage location
    * @return the new shopping storage location
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation create(
        long storageLocationId) {
        return getPersistence().create(storageLocationId);
    }

    /**
    * Removes the shopping storage location with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation remove(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(storageLocationId);
    }

    public static com.fsquare.shopping.model.ShoppingStorageLocation updateImpl(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingStorageLocation);
    }

    /**
    * Returns the shopping storage location with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingStorageLocationException} if it could not be found.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location
    * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation findByPrimaryKey(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(storageLocationId);
    }

    /**
    * Returns the shopping storage location with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param storageLocationId the primary key of the shopping storage location
    * @return the shopping storage location, or <code>null</code> if a shopping storage location with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStorageLocation fetchByPrimaryKey(
        long storageLocationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(storageLocationId);
    }

    /**
    * Returns all the shopping storage locations.
    *
    * @return the shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.fsquare.shopping.model.ShoppingStorageLocation> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping storage locations from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping storage locations.
    *
    * @return the number of shopping storage locations
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingStorageLocationPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingStorageLocationPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingStorageLocationPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingStorageLocationUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingStorageLocationPersistence persistence) {
    }
}
