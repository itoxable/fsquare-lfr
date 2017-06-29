package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping item type service. This utility wraps {@link ShoppingItemTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemTypePersistence
 * @see ShoppingItemTypePersistenceImpl
 * @generated
 */
public class ShoppingItemTypeUtil {
    private static ShoppingItemTypePersistence _persistence;

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
    public static void clearCache(ShoppingItemType shoppingItemType) {
        getPersistence().clearCache(shoppingItemType);
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
    public static List<ShoppingItemType> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingItemType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingItemType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingItemType update(ShoppingItemType shoppingItemType)
        throws SystemException {
        return getPersistence().update(shoppingItemType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingItemType update(ShoppingItemType shoppingItemType,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingItemType, serviceContext);
    }

    /**
    * Returns all the shopping item types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemType> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the shopping item types where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping item types
    * @param end the upper bound of the range of shopping item types (not inclusive)
    * @return the range of matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemType> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping item types where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping item types
    * @param end the upper bound of the range of shopping item types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemType> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the shopping item types before and after the current shopping item type in the ordered set where companyId = &#63;.
    *
    * @param itemTypeId the primary key of the current shopping item type
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType[] findByCompanyId_PrevAndNext(
        long itemTypeId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(itemTypeId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the shopping item types where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of shopping item types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns the shopping item type where name = &#63; and companyId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemTypeException} if it could not be found.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the matching shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType findByNameAndCompanyId(
        java.lang.String name, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNameAndCompanyId(name, companyId);
    }

    /**
    * Returns the shopping item type where name = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType fetchByNameAndCompanyId(
        java.lang.String name, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNameAndCompanyId(name, companyId);
    }

    /**
    * Returns the shopping item type where name = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param companyId the company ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType fetchByNameAndCompanyId(
        java.lang.String name, long companyId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNameAndCompanyId(name, companyId, retrieveFromCache);
    }

    /**
    * Removes the shopping item type where name = &#63; and companyId = &#63; from the database.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the shopping item type that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType removeByNameAndCompanyId(
        java.lang.String name, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByNameAndCompanyId(name, companyId);
    }

    /**
    * Returns the number of shopping item types where name = &#63; and companyId = &#63;.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the number of matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static int countByNameAndCompanyId(java.lang.String name,
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNameAndCompanyId(name, companyId);
    }

    /**
    * Caches the shopping item type in the entity cache if it is enabled.
    *
    * @param shoppingItemType the shopping item type
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType) {
        getPersistence().cacheResult(shoppingItemType);
    }

    /**
    * Caches the shopping item types in the entity cache if it is enabled.
    *
    * @param shoppingItemTypes the shopping item types
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItemType> shoppingItemTypes) {
        getPersistence().cacheResult(shoppingItemTypes);
    }

    /**
    * Creates a new shopping item type with the primary key. Does not add the shopping item type to the database.
    *
    * @param itemTypeId the primary key for the new shopping item type
    * @return the new shopping item type
    */
    public static com.fsquare.shopping.model.ShoppingItemType create(
        long itemTypeId) {
        return getPersistence().create(itemTypeId);
    }

    /**
    * Removes the shopping item type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType remove(
        long itemTypeId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(itemTypeId);
    }

    public static com.fsquare.shopping.model.ShoppingItemType updateImpl(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingItemType);
    }

    /**
    * Returns the shopping item type with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemTypeException} if it could not be found.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType findByPrimaryKey(
        long itemTypeId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(itemTypeId);
    }

    /**
    * Returns the shopping item type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type, or <code>null</code> if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingItemType fetchByPrimaryKey(
        long itemTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(itemTypeId);
    }

    /**
    * Returns all the shopping item types.
    *
    * @return the shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the shopping item types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item types
    * @param end the upper bound of the range of shopping item types (not inclusive)
    * @return the range of shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping item types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item types
    * @param end the upper bound of the range of shopping item types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingItemType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping item types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping item types.
    *
    * @return the number of shopping item types
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingItemTypePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingItemTypePersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingItemTypePersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingItemTypeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingItemTypePersistence persistence) {
    }
}
