package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingShippingMethod;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping shipping method service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethodPersistenceImpl
 * @see ShoppingShippingMethodUtil
 * @generated
 */
public interface ShoppingShippingMethodPersistence extends BasePersistence<ShoppingShippingMethod> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingShippingMethodUtil} to access the shopping shipping method persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the shopping shipping method where defaultShipping = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingShippingMethodException} if it could not be found.
    *
    * @param defaultShipping the default shipping
    * @return the matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod findBydefaultShipping(
        boolean defaultShipping)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping shipping method where defaultShipping = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param defaultShipping the default shipping
    * @return the matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod fetchBydefaultShipping(
        boolean defaultShipping)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping shipping method where defaultShipping = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param defaultShipping the default shipping
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod fetchBydefaultShipping(
        boolean defaultShipping, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the shopping shipping method where defaultShipping = &#63; from the database.
    *
    * @param defaultShipping the default shipping
    * @return the shopping shipping method that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod removeBydefaultShipping(
        boolean defaultShipping)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping shipping methods where defaultShipping = &#63;.
    *
    * @param defaultShipping the default shipping
    * @return the number of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public int countBydefaultShipping(boolean defaultShipping)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping shipping methods where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping shipping methods where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @return the range of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping shipping methods where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping shipping methods
    * @param end the upper bound of the range of shopping shipping methods (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping shipping method in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping shipping method in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping shipping method in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping shipping method in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping shipping methods before and after the current shopping shipping method in the ordered set where groupId = &#63;.
    *
    * @param shippingMethodId the primary key of the current shopping shipping method
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod[] findByGroupId_PrevAndNext(
        long shippingMethodId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping shipping methods where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping shipping methods where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping shipping method in the entity cache if it is enabled.
    *
    * @param shoppingShippingMethod the shopping shipping method
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod);

    /**
    * Caches the shopping shipping methods in the entity cache if it is enabled.
    *
    * @param shoppingShippingMethods the shopping shipping methods
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> shoppingShippingMethods);

    /**
    * Creates a new shopping shipping method with the primary key. Does not add the shopping shipping method to the database.
    *
    * @param shippingMethodId the primary key for the new shopping shipping method
    * @return the new shopping shipping method
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod create(
        long shippingMethodId);

    /**
    * Removes the shopping shipping method with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod remove(
        long shippingMethodId)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingShippingMethod updateImpl(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping shipping method with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingShippingMethodException} if it could not be found.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method
    * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod findByPrimaryKey(
        long shippingMethodId)
        throws com.fsquare.shopping.NoSuchShoppingShippingMethodException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping shipping method with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param shippingMethodId the primary key of the shopping shipping method
    * @return the shopping shipping method, or <code>null</code> if a shopping shipping method with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingShippingMethod fetchByPrimaryKey(
        long shippingMethodId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping shipping methods.
    *
    * @return the shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingShippingMethod> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping shipping methods from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping shipping methods.
    *
    * @return the number of shopping shipping methods
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
