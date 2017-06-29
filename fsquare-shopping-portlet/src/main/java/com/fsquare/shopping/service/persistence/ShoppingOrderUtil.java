package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingOrder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping order service. This utility wraps {@link ShoppingOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderPersistence
 * @see ShoppingOrderPersistenceImpl
 * @generated
 */
public class ShoppingOrderUtil {
    private static ShoppingOrderPersistence _persistence;

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
    public static void clearCache(ShoppingOrder shoppingOrder) {
        getPersistence().clearCache(shoppingOrder);
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
    public static List<ShoppingOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ShoppingOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ShoppingOrder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ShoppingOrder update(ShoppingOrder shoppingOrder)
        throws SystemException {
        return getPersistence().update(shoppingOrder);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ShoppingOrder update(ShoppingOrder shoppingOrder,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(shoppingOrder, serviceContext);
    }

    /**
    * Returns all the shopping orders where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the shopping orders where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the shopping orders before and after the current shopping order in the ordered set where companyId = &#63;.
    *
    * @param shoppingOrderId the primary key of the current shopping order
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder[] findByCompanyId_PrevAndNext(
        long shoppingOrderId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(shoppingOrderId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the shopping orders where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of shopping orders where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns the shopping order where number = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param number the number
    * @return the matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByNumber(
        java.lang.String number)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNumber(number);
    }

    /**
    * Returns the shopping order where number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param number the number
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByNumber(
        java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNumber(number);
    }

    /**
    * Returns the shopping order where number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param number the number
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByNumber(
        java.lang.String number, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNumber(number, retrieveFromCache);
    }

    /**
    * Removes the shopping order where number = &#63; from the database.
    *
    * @param number the number
    * @return the shopping order that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder removeByNumber(
        java.lang.String number)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByNumber(number);
    }

    /**
    * Returns the number of shopping orders where number = &#63;.
    *
    * @param number the number
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByNumber(java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNumber(number);
    }

    /**
    * Returns all the shopping orders where paymentType = &#63;.
    *
    * @param paymentType the payment type
    * @return the matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByPaymentType(
        java.lang.String paymentType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPaymentType(paymentType);
    }

    /**
    * Returns a range of all the shopping orders where paymentType = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param paymentType the payment type
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByPaymentType(
        java.lang.String paymentType, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPaymentType(paymentType, start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders where paymentType = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param paymentType the payment type
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByPaymentType(
        java.lang.String paymentType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPaymentType(paymentType, start, end, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where paymentType = &#63;.
    *
    * @param paymentType the payment type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByPaymentType_First(
        java.lang.String paymentType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPaymentType_First(paymentType, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where paymentType = &#63;.
    *
    * @param paymentType the payment type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByPaymentType_First(
        java.lang.String paymentType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPaymentType_First(paymentType, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where paymentType = &#63;.
    *
    * @param paymentType the payment type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByPaymentType_Last(
        java.lang.String paymentType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPaymentType_Last(paymentType, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where paymentType = &#63;.
    *
    * @param paymentType the payment type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByPaymentType_Last(
        java.lang.String paymentType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPaymentType_Last(paymentType, orderByComparator);
    }

    /**
    * Returns the shopping orders before and after the current shopping order in the ordered set where paymentType = &#63;.
    *
    * @param shoppingOrderId the primary key of the current shopping order
    * @param paymentType the payment type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder[] findByPaymentType_PrevAndNext(
        long shoppingOrderId, java.lang.String paymentType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPaymentType_PrevAndNext(shoppingOrderId, paymentType,
            orderByComparator);
    }

    /**
    * Removes all the shopping orders where paymentType = &#63; from the database.
    *
    * @param paymentType the payment type
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPaymentType(java.lang.String paymentType)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPaymentType(paymentType);
    }

    /**
    * Returns the number of shopping orders where paymentType = &#63;.
    *
    * @param paymentType the payment type
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByPaymentType(java.lang.String paymentType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPaymentType(paymentType);
    }

    /**
    * Returns the shopping order where externalPaymentId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param externalPaymentId the external payment ID
    * @return the matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByExternalPaymentId(
        java.lang.String externalPaymentId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByExternalPaymentId(externalPaymentId);
    }

    /**
    * Returns the shopping order where externalPaymentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param externalPaymentId the external payment ID
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByExternalPaymentId(
        java.lang.String externalPaymentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByExternalPaymentId(externalPaymentId);
    }

    /**
    * Returns the shopping order where externalPaymentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param externalPaymentId the external payment ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByExternalPaymentId(
        java.lang.String externalPaymentId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByExternalPaymentId(externalPaymentId,
            retrieveFromCache);
    }

    /**
    * Removes the shopping order where externalPaymentId = &#63; from the database.
    *
    * @param externalPaymentId the external payment ID
    * @return the shopping order that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder removeByExternalPaymentId(
        java.lang.String externalPaymentId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByExternalPaymentId(externalPaymentId);
    }

    /**
    * Returns the number of shopping orders where externalPaymentId = &#63;.
    *
    * @param externalPaymentId the external payment ID
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByExternalPaymentId(
        java.lang.String externalPaymentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByExternalPaymentId(externalPaymentId);
    }

    /**
    * Returns the shopping order where status = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param status the status
    * @return the matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByStatus(
        java.lang.String status)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus(status);
    }

    /**
    * Returns the shopping order where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param status the status
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByStatus(
        java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus(status);
    }

    /**
    * Returns the shopping order where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param status the status
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByStatus(
        java.lang.String status, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus(status, retrieveFromCache);
    }

    /**
    * Removes the shopping order where status = &#63; from the database.
    *
    * @param status the status
    * @return the shopping order that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder removeByStatus(
        java.lang.String status)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByStatus(status);
    }

    /**
    * Returns the number of shopping orders where status = &#63;.
    *
    * @param status the status
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByStatus(java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStatus(status);
    }

    /**
    * Returns all the shopping orders where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @return the matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBycompanyIdAndUserId(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycompanyIdAndUserId(companyId, userId);
    }

    /**
    * Returns a range of all the shopping orders where companyId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBycompanyIdAndUserId(
        long companyId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndUserId(companyId, userId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders where companyId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBycompanyIdAndUserId(
        long companyId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndUserId(companyId, userId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findBycompanyIdAndUserId_First(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndUserId_First(companyId, userId,
            orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchBycompanyIdAndUserId_First(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycompanyIdAndUserId_First(companyId, userId,
            orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findBycompanyIdAndUserId_Last(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndUserId_Last(companyId, userId,
            orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchBycompanyIdAndUserId_Last(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycompanyIdAndUserId_Last(companyId, userId,
            orderByComparator);
    }

    /**
    * Returns the shopping orders before and after the current shopping order in the ordered set where companyId = &#63; and userId = &#63;.
    *
    * @param shoppingOrderId the primary key of the current shopping order
    * @param companyId the company ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder[] findBycompanyIdAndUserId_PrevAndNext(
        long shoppingOrderId, long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndUserId_PrevAndNext(shoppingOrderId,
            companyId, userId, orderByComparator);
    }

    /**
    * Removes all the shopping orders where companyId = &#63; and userId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycompanyIdAndUserId(long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycompanyIdAndUserId(companyId, userId);
    }

    /**
    * Returns the number of shopping orders where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countBycompanyIdAndUserId(long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycompanyIdAndUserId(companyId, userId);
    }

    /**
    * Returns all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @return the matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBycompanyIdAndEmail(
        long companyId, java.lang.String shippingEmailAddress)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndEmail(companyId, shippingEmailAddress);
    }

    /**
    * Returns a range of all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBycompanyIdAndEmail(
        long companyId, java.lang.String shippingEmailAddress, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndEmail(companyId, shippingEmailAddress,
            start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBycompanyIdAndEmail(
        long companyId, java.lang.String shippingEmailAddress, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndEmail(companyId, shippingEmailAddress,
            start, end, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findBycompanyIdAndEmail_First(
        long companyId, java.lang.String shippingEmailAddress,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndEmail_First(companyId,
            shippingEmailAddress, orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchBycompanyIdAndEmail_First(
        long companyId, java.lang.String shippingEmailAddress,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycompanyIdAndEmail_First(companyId,
            shippingEmailAddress, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findBycompanyIdAndEmail_Last(
        long companyId, java.lang.String shippingEmailAddress,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndEmail_Last(companyId,
            shippingEmailAddress, orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchBycompanyIdAndEmail_Last(
        long companyId, java.lang.String shippingEmailAddress,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycompanyIdAndEmail_Last(companyId,
            shippingEmailAddress, orderByComparator);
    }

    /**
    * Returns the shopping orders before and after the current shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * @param shoppingOrderId the primary key of the current shopping order
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder[] findBycompanyIdAndEmail_PrevAndNext(
        long shoppingOrderId, long companyId,
        java.lang.String shippingEmailAddress,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyIdAndEmail_PrevAndNext(shoppingOrderId,
            companyId, shippingEmailAddress, orderByComparator);
    }

    /**
    * Removes all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63; from the database.
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycompanyIdAndEmail(long companyId,
        java.lang.String shippingEmailAddress)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeBycompanyIdAndEmail(companyId, shippingEmailAddress);
    }

    /**
    * Returns the number of shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
    *
    * @param companyId the company ID
    * @param shippingEmailAddress the shipping email address
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countBycompanyIdAndEmail(long companyId,
        java.lang.String shippingEmailAddress)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countBycompanyIdAndEmail(companyId, shippingEmailAddress);
    }

    /**
    * Returns all the shopping orders where shippingMethodId = &#63;.
    *
    * @param shippingMethodId the shipping method ID
    * @return the matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByShippingMethodId(
        long shippingMethodId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByShippingMethodId(shippingMethodId);
    }

    /**
    * Returns a range of all the shopping orders where shippingMethodId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param shippingMethodId the shipping method ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByShippingMethodId(
        long shippingMethodId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShippingMethodId(shippingMethodId, start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders where shippingMethodId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param shippingMethodId the shipping method ID
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByShippingMethodId(
        long shippingMethodId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShippingMethodId(shippingMethodId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where shippingMethodId = &#63;.
    *
    * @param shippingMethodId the shipping method ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByShippingMethodId_First(
        long shippingMethodId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShippingMethodId_First(shippingMethodId,
            orderByComparator);
    }

    /**
    * Returns the first shopping order in the ordered set where shippingMethodId = &#63;.
    *
    * @param shippingMethodId the shipping method ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByShippingMethodId_First(
        long shippingMethodId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByShippingMethodId_First(shippingMethodId,
            orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where shippingMethodId = &#63;.
    *
    * @param shippingMethodId the shipping method ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByShippingMethodId_Last(
        long shippingMethodId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShippingMethodId_Last(shippingMethodId,
            orderByComparator);
    }

    /**
    * Returns the last shopping order in the ordered set where shippingMethodId = &#63;.
    *
    * @param shippingMethodId the shipping method ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByShippingMethodId_Last(
        long shippingMethodId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByShippingMethodId_Last(shippingMethodId,
            orderByComparator);
    }

    /**
    * Returns the shopping orders before and after the current shopping order in the ordered set where shippingMethodId = &#63;.
    *
    * @param shoppingOrderId the primary key of the current shopping order
    * @param shippingMethodId the shipping method ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder[] findByShippingMethodId_PrevAndNext(
        long shoppingOrderId, long shippingMethodId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByShippingMethodId_PrevAndNext(shoppingOrderId,
            shippingMethodId, orderByComparator);
    }

    /**
    * Removes all the shopping orders where shippingMethodId = &#63; from the database.
    *
    * @param shippingMethodId the shipping method ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByShippingMethodId(long shippingMethodId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByShippingMethodId(shippingMethodId);
    }

    /**
    * Returns the number of shopping orders where shippingMethodId = &#63;.
    *
    * @param shippingMethodId the shipping method ID
    * @return the number of matching shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countByShippingMethodId(long shippingMethodId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByShippingMethodId(shippingMethodId);
    }

    /**
    * Caches the shopping order in the entity cache if it is enabled.
    *
    * @param shoppingOrder the shopping order
    */
    public static void cacheResult(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder) {
        getPersistence().cacheResult(shoppingOrder);
    }

    /**
    * Caches the shopping orders in the entity cache if it is enabled.
    *
    * @param shoppingOrders the shopping orders
    */
    public static void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingOrder> shoppingOrders) {
        getPersistence().cacheResult(shoppingOrders);
    }

    /**
    * Creates a new shopping order with the primary key. Does not add the shopping order to the database.
    *
    * @param shoppingOrderId the primary key for the new shopping order
    * @return the new shopping order
    */
    public static com.fsquare.shopping.model.ShoppingOrder create(
        long shoppingOrderId) {
        return getPersistence().create(shoppingOrderId);
    }

    /**
    * Removes the shopping order with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderId the primary key of the shopping order
    * @return the shopping order that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder remove(
        long shoppingOrderId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(shoppingOrderId);
    }

    public static com.fsquare.shopping.model.ShoppingOrder updateImpl(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(shoppingOrder);
    }

    /**
    * Returns the shopping order with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
    *
    * @param shoppingOrderId the primary key of the shopping order
    * @return the shopping order
    * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder findByPrimaryKey(
        long shoppingOrderId)
        throws com.fsquare.shopping.NoSuchShoppingOrderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(shoppingOrderId);
    }

    /**
    * Returns the shopping order with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param shoppingOrderId the primary key of the shopping order
    * @return the shopping order, or <code>null</code> if a shopping order with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.fsquare.shopping.model.ShoppingOrder fetchByPrimaryKey(
        long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(shoppingOrderId);
    }

    /**
    * Returns all the shopping orders.
    *
    * @return the shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the shopping orders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @return the range of shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the shopping orders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping orders
    * @param end the upper bound of the range of shopping orders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the shopping orders from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of shopping orders.
    *
    * @return the number of shopping orders
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ShoppingOrderPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ShoppingOrderPersistence) PortletBeanLocatorUtil.locate(com.fsquare.shopping.service.ClpSerializer.getServletContextName(),
                    ShoppingOrderPersistence.class.getName());

            ReferenceRegistry.registerReference(ShoppingOrderUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ShoppingOrderPersistence persistence) {
    }
}
