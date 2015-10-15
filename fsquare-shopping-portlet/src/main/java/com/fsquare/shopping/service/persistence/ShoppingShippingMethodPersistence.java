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
