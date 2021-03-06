package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingCoupon;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping coupon service. This utility wraps {@link ShoppingCouponPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponPersistence
 * @see ShoppingCouponPersistenceImpl
 * @generated
 */
public class ShoppingCouponUtil {
    private static ShoppingCouponPersistence _persistence;

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
    public static void clearCache(ShoppingCoupon shoppingCoupon) {
        getPersistence().clearCache(shoppingCoupon);
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
    public static List<ShoppingCoupon> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingCoupon> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingCoupon> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingCoupon update(ShoppingCoupon shoppingCoupon)
        throws SystemException {
        return getPersistence().update(shoppingCoupon);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingCoupon update(ShoppingCoupon shoppingCoupon,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingCoupon, serviceContext);
    }

    /**
    * Returns all the shopping coupons where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the shopping coupons where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping coupons
    * @param end the upper bound of the range of shopping coupons (not inclusive)
    * @return the range of matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping coupons where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping coupons
    * @param end the upper bound of the range of shopping coupons (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the shopping coupons before and after the current shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param couponId the primary key of the current shopping coupon
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon[] findByCompanyId_PrevAndNext(
        long couponId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(couponId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the shopping coupons where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of shopping coupons where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns the shopping coupon where code = &#63; and companyId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingCouponException} if it could not be found.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the matching shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon findByCodeAndCompanyId(
        java.lang.String code, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCodeAndCompanyId(code, companyId);
    }

    /**
    * Returns the shopping coupon where code = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndCompanyId(
        java.lang.String code, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCodeAndCompanyId(code, companyId);
    }

    /**
    * Returns the shopping coupon where code = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param code the code
    * @param companyId the company ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndCompanyId(
        java.lang.String code, long companyId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCodeAndCompanyId(code, companyId, retrieveFromCache);
    }

    /**
    * Removes the shopping coupon where code = &#63; and companyId = &#63; from the database.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the shopping coupon that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon removeByCodeAndCompanyId(
        java.lang.String code, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByCodeAndCompanyId(code, companyId);
    }

    /**
    * Returns the number of shopping coupons where code = &#63; and companyId = &#63;.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the number of matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static int countByCodeAndCompanyId(java.lang.String code,
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCodeAndCompanyId(code, companyId);
    }

    /**
    * Caches the shopping coupon in the entity cache if it is enabled.
    *
    * @param shoppingCoupon the shopping coupon
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon) {
        getPersistence().cacheResult(shoppingCoupon);
    }

    /**
    * Caches the shopping coupons in the entity cache if it is enabled.
    *
    * @param shoppingCoupons the shopping coupons
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingCoupon> shoppingCoupons) {
        getPersistence().cacheResult(shoppingCoupons);
    }

    /**
    * Creates a new shopping coupon with the primary key. Does not add the shopping coupon to the database.
    *
    * @param couponId the primary key for the new shopping coupon
    * @return the new shopping coupon
    */
    public static com.fsquare.shopping.model.ShoppingCoupon create(
        long couponId) {
        return getPersistence().create(couponId);
    }

    /**
    * Removes the shopping coupon with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon remove(
        long couponId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(couponId);
    }

    public static com.fsquare.shopping.model.ShoppingCoupon updateImpl(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingCoupon);
    }

    /**
    * Returns the shopping coupon with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingCouponException} if it could not be found.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon findByPrimaryKey(
        long couponId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(couponId);
    }

    /**
    * Returns the shopping coupon with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon, or <code>null</code> if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingCoupon fetchByPrimaryKey(
        long couponId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(couponId);
    }

    /**
    * Returns all the shopping coupons.
    *
    * @return the shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the shopping coupons.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping coupons
    * @param end the upper bound of the range of shopping coupons (not inclusive)
    * @return the range of shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping coupons.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping coupons
    * @param end the upper bound of the range of shopping coupons (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping coupons from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping coupons.
    *
    * @return the number of shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingCouponPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingCouponPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingCouponPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingCouponUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingCouponPersistence persistence) {
    }
}
