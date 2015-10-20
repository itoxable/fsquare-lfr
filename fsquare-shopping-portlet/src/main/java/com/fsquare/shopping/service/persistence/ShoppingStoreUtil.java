package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingStore;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping store service. This utility wraps {@link ShoppingStorePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorePersistence
 * @see ShoppingStorePersistenceImpl
 * @generated
 */
public class ShoppingStoreUtil {
    private static ShoppingStorePersistence _persistence;

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
    public static void clearCache(ShoppingStore shoppingStore) {
        getPersistence().clearCache(shoppingStore);
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
    public static List<ShoppingStore> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingStore> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingStore> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingStore update(ShoppingStore shoppingStore)
        throws SystemException {
        return getPersistence().update(shoppingStore);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingStore update(ShoppingStore shoppingStore,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingStore, serviceContext);
    }

    /**
    * Caches the shopping store in the entity cache if it is enabled.
    *
    * @param shoppingStore the shopping store
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingStore shoppingStore) {
        getPersistence().cacheResult(shoppingStore);
    }

    /**
    * Caches the shopping stores in the entity cache if it is enabled.
    *
    * @param shoppingStores the shopping stores
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingStore> shoppingStores) {
        getPersistence().cacheResult(shoppingStores);
    }

    /**
    * Creates a new shopping store with the primary key. Does not add the shopping store to the database.
    *
    * @param groupId the primary key for the new shopping store
    * @return the new shopping store
    */
    public static com.fsquare.shopping.model.ShoppingStore create(long groupId) {
        return getPersistence().create(groupId);
    }

    /**
    * Removes the shopping store with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param groupId the primary key of the shopping store
    * @return the shopping store that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore remove(long groupId)
        throws com.fsquare.shopping.NoSuchShoppingStoreException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(groupId);
    }

    public static com.fsquare.shopping.model.ShoppingStore updateImpl(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingStore);
    }

    /**
    * Returns the shopping store with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingStoreException} if it could not be found.
    *
    * @param groupId the primary key of the shopping store
    * @return the shopping store
    * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore findByPrimaryKey(
        long groupId)
        throws com.fsquare.shopping.NoSuchShoppingStoreException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(groupId);
    }

    /**
    * Returns the shopping store with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param groupId the primary key of the shopping store
    * @return the shopping store, or <code>null</code> if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingStore fetchByPrimaryKey(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(groupId);
    }

    /**
    * Returns all the shopping stores.
    *
    * @return the shopping stores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingStore> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the shopping stores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping stores
    * @param end the upper bound of the range of shopping stores (not inclusive)
    * @return the range of shopping stores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingStore> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping stores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping stores
    * @param end the upper bound of the range of shopping stores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping stores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingStore> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping stores from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping stores.
    *
    * @return the number of shopping stores
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingStorePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingStorePersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingStorePersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingStoreUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingStorePersistence persistence) {
    }
}
