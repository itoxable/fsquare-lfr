package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingStore;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping store service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorePersistenceImpl
 * @see ShoppingStoreUtil
 * @generated
 */
public interface ShoppingStorePersistence extends BasePersistence<ShoppingStore> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingStoreUtil} to access the shopping store persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the shopping store in the entity cache if it is enabled.
    *
    * @param shoppingStore the shopping store
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingStore shoppingStore);

    /**
    * Caches the shopping stores in the entity cache if it is enabled.
    *
    * @param shoppingStores the shopping stores
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingStore> shoppingStores);

    /**
    * Creates a new shopping store with the primary key. Does not add the shopping store to the database.
    *
    * @param companyId the primary key for the new shopping store
    * @return the new shopping store
    */
    public com.fsquare.shopping.model.ShoppingStore create(long companyId);

    /**
    * Removes the shopping store with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param companyId the primary key of the shopping store
    * @return the shopping store that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStore remove(long companyId)
        throws com.fsquare.shopping.NoSuchShoppingStoreException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingStore updateImpl(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping store with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingStoreException} if it could not be found.
    *
    * @param companyId the primary key of the shopping store
    * @return the shopping store
    * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStore findByPrimaryKey(
        long companyId)
        throws com.fsquare.shopping.NoSuchShoppingStoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping store with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param companyId the primary key of the shopping store
    * @return the shopping store, or <code>null</code> if a shopping store with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingStore fetchByPrimaryKey(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping stores.
    *
    * @return the shopping stores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingStore> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingStore> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingStore> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping stores from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping stores.
    *
    * @return the number of shopping stores
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
