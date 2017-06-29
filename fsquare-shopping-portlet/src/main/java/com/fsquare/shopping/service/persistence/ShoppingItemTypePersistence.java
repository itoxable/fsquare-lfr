package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemTypePersistenceImpl
 * @see ShoppingItemTypeUtil
 * @generated
 */
public interface ShoppingItemTypePersistence extends BasePersistence<ShoppingItemType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingItemTypeUtil} to access the shopping item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the shopping item types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemType> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItemType> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItemType> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.fsquare.shopping.model.ShoppingItemType[] findByCompanyId_PrevAndNext(
        long itemTypeId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item types where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item type where name = &#63; and companyId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemTypeException} if it could not be found.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the matching shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType findByNameAndCompanyId(
        java.lang.String name, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item type where name = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType fetchByNameAndCompanyId(
        java.lang.String name, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item type where name = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param companyId the company ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType fetchByNameAndCompanyId(
        java.lang.String name, long companyId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the shopping item type where name = &#63; and companyId = &#63; from the database.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the shopping item type that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType removeByNameAndCompanyId(
        java.lang.String name, long companyId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item types where name = &#63; and companyId = &#63;.
    *
    * @param name the name
    * @param companyId the company ID
    * @return the number of matching shopping item types
    * @throws SystemException if a system exception occurred
    */
    public int countByNameAndCompanyId(java.lang.String name, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping item type in the entity cache if it is enabled.
    *
    * @param shoppingItemType the shopping item type
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType);

    /**
    * Caches the shopping item types in the entity cache if it is enabled.
    *
    * @param shoppingItemTypes the shopping item types
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItemType> shoppingItemTypes);

    /**
    * Creates a new shopping item type with the primary key. Does not add the shopping item type to the database.
    *
    * @param itemTypeId the primary key for the new shopping item type
    * @return the new shopping item type
    */
    public com.fsquare.shopping.model.ShoppingItemType create(long itemTypeId);

    /**
    * Removes the shopping item type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType remove(long itemTypeId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingItemType updateImpl(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item type with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemTypeException} if it could not be found.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type
    * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType findByPrimaryKey(
        long itemTypeId)
        throws com.fsquare.shopping.NoSuchShoppingItemTypeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemTypeId the primary key of the shopping item type
    * @return the shopping item type, or <code>null</code> if a shopping item type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemType fetchByPrimaryKey(
        long itemTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping item types.
    *
    * @return the shopping item types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItemType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.fsquare.shopping.model.ShoppingItemType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item types.
    *
    * @return the number of shopping item types
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
