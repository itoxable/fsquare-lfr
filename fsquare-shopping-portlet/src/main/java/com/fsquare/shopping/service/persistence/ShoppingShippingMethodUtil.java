package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingShippingMethod;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping shipping method service. This utility wraps {@link ShoppingShippingMethodPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethodPersistence
 * @see ShoppingShippingMethodPersistenceImpl
 * @generated
 */
public class ShoppingShippingMethodUtil {
    private static ShoppingShippingMethodPersistence _persistence;

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
    public static void clearCache(ShoppingShippingMethod shoppingShippingMethod) {
        getPersistence().clearCache(shoppingShippingMethod);
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
    public static List<ShoppingShippingMethod> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingShippingMethod> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingShippingMethod> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingShippingMethod update(
        ShoppingShippingMethod shoppingShippingMethod)
        throws SystemException {
        return getPersistence().update(shoppingShippingMethod);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingShippingMethod update(
        ShoppingShippingMethod shoppingShippingMethod,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingShippingMethod, serviceContext);
    }

    /**
    * Returns the shopping shipping method where defaultShipping = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingShippingMethodException} if it could not be found.
    *
    * @param defaultShipping the default shipping
    * @return the matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod findBydefaultShipping(
        boolean defaultShipping)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBydefaultShipping(defaultShipping);
    }

    /**
    * Returns the shopping shipping method where defaultShipping = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param defaultShipping the default shipping
    * @return the matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod fetchBydefaultShipping(
        boolean defaultShipping)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBydefaultShipping(defaultShipping);
    }

    /**
    * Returns the shopping shipping method where defaultShipping = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param defaultShipping the default shipping
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod fetchBydefaultShipping(
        boolean defaultShipping, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBydefaultShipping(defaultShipping, retrieveFromCache);
    }

    /**
    * Removes the shopping shipping method where defaultShipping = &#63; from the database.
    *
    * @param defaultShipping the default shipping
    * @return the shopping shipping method that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod removeBydefaultShipping(
        boolean defaultShipping)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeBydefaultShipping(defaultShipping);
    }

    /**
    * Returns the number of shopping shipping methods where defaultShipping = &#63;.
    *
    * @param defaultShipping the default shipping
    * @return the number of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static int countBydefaultShipping(boolean defaultShipping)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBydefaultShipping(defaultShipping);
    }

    /**
    * Returns all the shopping shipping methods where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the shopping shipping methods where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @return the range of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping shipping methods where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping shipping method in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first shopping shipping method in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping shipping method in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping shipping method in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the shopping shipping methods before and after the current shopping shipping method in the ordered set where companyId = &#63;.
    *
    * @param shippingMethodId the primary key of the current shopping shipping method
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod[] findByCompanyId_PrevAndNext(
        long shippingMethodId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(shippingMethodId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the shopping shipping methods where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of shopping shipping methods where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns all the shopping shipping methods where companyId = &#63; and disabled = &#63;.
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @return the matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByCompanyIdAndEnabled(
        long companyId, boolean disabled)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyIdAndEnabled(companyId, disabled);
    }

    /**
    * Returns a range of all the shopping shipping methods where companyId = &#63; and disabled = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @return the range of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByCompanyIdAndEnabled(
        long companyId, boolean disabled, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndEnabled(companyId, disabled, start, end);
    }

    /**
    * Returns an ordered range of all the shopping shipping methods where companyId = &#63; and disabled = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByCompanyIdAndEnabled(
        long companyId, boolean disabled, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndEnabled(companyId, disabled, start, end,
            orderByComparator);
    }

    /**
    * Returns the first shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod findByCompanyIdAndEnabled_First(
        long companyId, boolean disabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndEnabled_First(companyId, disabled,
            orderByComparator);
    }

    /**
    * Returns the first shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod fetchByCompanyIdAndEnabled_First(
        long companyId, boolean disabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyIdAndEnabled_First(companyId, disabled,
            orderByComparator);
    }

    /**
    * Returns the last shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod findByCompanyIdAndEnabled_Last(
        long companyId, boolean disabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndEnabled_Last(companyId, disabled,
            orderByComparator);
    }

    /**
    * Returns the last shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod fetchByCompanyIdAndEnabled_Last(
        long companyId, boolean disabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyIdAndEnabled_Last(companyId, disabled,
            orderByComparator);
    }

    /**
    * Returns the shopping shipping methods before and after the current shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
    *
    * @param shippingMethodId the primary key of the current shopping shipping method
    * @param companyId the company ID
    * @param disabled the disabled
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod[] findByCompanyIdAndEnabled_PrevAndNext(
        long shippingMethodId, long companyId, boolean disabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndEnabled_PrevAndNext(shippingMethodId,
            companyId, disabled, orderByComparator);
    }

    /**
    * Removes all the shopping shipping methods where companyId = &#63; and disabled = &#63; from the database.
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyIdAndEnabled(long companyId,
        boolean disabled)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyIdAndEnabled(companyId, disabled);
    }

    /**
    * Returns the number of shopping shipping methods where companyId = &#63; and disabled = &#63;.
    *
    * @param companyId the company ID
    * @param disabled the disabled
    * @return the number of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyIdAndEnabled(long companyId,
        boolean disabled)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyIdAndEnabled(companyId, disabled);
    }

    /**
    * Caches the shopping shipping method in the entity cache if it is enabled.
    *
    * @param shoppingShippingMethod the shopping shipping method
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod) {
        getPersistence().cacheResult(shoppingShippingMethod);
    }

    /**
    * Caches the shopping shipping methods in the entity cache if it is enabled.
    *
    * @param shoppingShippingMethods the shopping shipping methods
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> shoppingShippingMethods) {
        getPersistence().cacheResult(shoppingShippingMethods);
    }

    /**
    * Creates a new shopping shipping method with the primary key. Does not add the shopping shipping method to the database.
    *
    * @param shippingMethodId the primary key for the new shopping shipping method
    * @return the new shopping shipping method
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod create(
        long shippingMethodId) {
        return getPersistence().create(shippingMethodId);
    }

    /**
    * Removes the shopping shipping method with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod remove(
        long shippingMethodId)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(shippingMethodId);
    }

    public static com.fsquare.shopping.model.ShoppingShippingMethod updateImpl(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingShippingMethod);
    }

    /**
    * Returns the shopping shipping method with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingShippingMethodException} if it could not be found.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod findByPrimaryKey(
        long shippingMethodId)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(shippingMethodId);
    }

    /**
    * Returns the shopping shipping method with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method, or <code>null</code> if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingShippingMethod fetchByPrimaryKey(
        long shippingMethodId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(shippingMethodId);
    }

    /**
    * Returns all the shopping shipping methods.
    *
    * @return the shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the shopping shipping methods.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @return the range of shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping shipping methods.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping shipping methods from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping shipping methods.
    *
    * @return the number of shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingShippingMethodPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingShippingMethodPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingShippingMethodPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingShippingMethodUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingShippingMethodPersistence persistence) {
    }
}
