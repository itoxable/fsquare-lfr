package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingCoupon;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping coupon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponPersistenceImpl
 * @see ShoppingCouponUtil
 * @generated
 */
public interface ShoppingCouponPersistence extends BasePersistence<ShoppingCoupon> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingCouponUtil} to access the shopping coupon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the shopping coupons where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping coupon in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.fsquare.shopping.model.ShoppingCoupon[] findByCompanyId_PrevAndNext(
        long couponId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping coupons where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping coupons where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping coupon where code = &#63; and companyId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingCouponException} if it could not be found.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the matching shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon findByCodeAndCompanyId(
        java.lang.String code, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping coupon where code = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndCompanyId(
        java.lang.String code, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping coupon where code = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param code the code
    * @param companyId the company ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping coupon, or <code>null</code> if a matching shopping coupon could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndCompanyId(
        java.lang.String code, long companyId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the shopping coupon where code = &#63; and companyId = &#63; from the database.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the shopping coupon that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon removeByCodeAndCompanyId(
        java.lang.String code, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping coupons where code = &#63; and companyId = &#63;.
    *
    * @param code the code
    * @param companyId the company ID
    * @return the number of matching shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public int countByCodeAndCompanyId(java.lang.String code, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping coupon in the entity cache if it is enabled.
    *
    * @param shoppingCoupon the shopping coupon
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon);

    /**
    * Caches the shopping coupons in the entity cache if it is enabled.
    *
    * @param shoppingCoupons the shopping coupons
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingCoupon> shoppingCoupons);

    /**
    * Creates a new shopping coupon with the primary key. Does not add the shopping coupon to the database.
    *
    * @param couponId the primary key for the new shopping coupon
    * @return the new shopping coupon
    */
    public com.fsquare.shopping.model.ShoppingCoupon create(long couponId);

    /**
    * Removes the shopping coupon with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon remove(long couponId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingCoupon updateImpl(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping coupon with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingCouponException} if it could not be found.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon
    * @throws com.fsquare.shopping.NoSuchShoppingCouponException if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon findByPrimaryKey(
        long couponId)
        throws com.fsquare.shopping.NoSuchShoppingCouponException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping coupon with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param couponId the primary key of the shopping coupon
    * @return the shopping coupon, or <code>null</code> if a shopping coupon with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingCoupon fetchByPrimaryKey(
        long couponId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping coupons.
    *
    * @return the shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping coupons from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping coupons.
    *
    * @return the number of shopping coupons
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
