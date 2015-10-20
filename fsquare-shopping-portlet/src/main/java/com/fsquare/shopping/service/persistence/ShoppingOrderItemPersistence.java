package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingOrderItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping order item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemPersistenceImpl
 * @see ShoppingOrderItemUtil
 * @generated
 */
public interface ShoppingOrderItemPersistence extends BasePersistence<ShoppingOrderItem> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingOrderItemUtil} to access the shopping order item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the shopping order items where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @return the matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByShoppingOrderId(
        long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping order items where shoppingOrderId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param shoppingOrderId the shopping order ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @return the range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByShoppingOrderId(
        long shoppingOrderId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping order items where shoppingOrderId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param shoppingOrderId the shopping order ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByShoppingOrderId(
        long shoppingOrderId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem findByShoppingOrderId_First(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderId_First(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem findByShoppingOrderId_Last(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderId_Last(
        long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping order items before and after the current shopping order item in the ordered set where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderItemId the primary key of the current shopping order item
    * @param shoppingOrderId the shopping order ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem[] findByShoppingOrderId_PrevAndNext(
        long shoppingOrderItemId, long shoppingOrderId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping order items where shoppingOrderId = &#63; from the database.
    *
    * @param shoppingOrderId the shopping order ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByShoppingOrderId(long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping order items where shoppingOrderId = &#63;.
    *
    * @param shoppingOrderId the shopping order ID
    * @return the number of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public int countByShoppingOrderId(long shoppingOrderId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping order item where shoppingOrderItemId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderItemException} if it could not be found.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem findByShoppingOrderItemId(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping order item where shoppingOrderItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderItemId(
        long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping order item where shoppingOrderItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem fetchByShoppingOrderItemId(
        long shoppingOrderItemId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the shopping order item where shoppingOrderItemId = &#63; from the database.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the shopping order item that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem removeByShoppingOrderItemId(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping order items where shoppingOrderItemId = &#63;.
    *
    * @param shoppingOrderItemId the shopping order item ID
    * @return the number of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public int countByShoppingOrderItemId(long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping order items where articleId = &#63;.
    *
    * @param articleId the article ID
    * @return the matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByArticleId(
        java.lang.String articleId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping order items where articleId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param articleId the article ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @return the range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByArticleId(
        java.lang.String articleId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping order items where articleId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param articleId the article ID
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findByArticleId(
        java.lang.String articleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem findByArticleId_First(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem fetchByArticleId_First(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem findByArticleId_Last(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping order item in the ordered set where articleId = &#63;.
    *
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem fetchByArticleId_Last(
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping order items before and after the current shopping order item in the ordered set where articleId = &#63;.
    *
    * @param shoppingOrderItemId the primary key of the current shopping order item
    * @param articleId the article ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem[] findByArticleId_PrevAndNext(
        long shoppingOrderItemId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping order items where articleId = &#63; from the database.
    *
    * @param articleId the article ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByArticleId(java.lang.String articleId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping order items where articleId = &#63;.
    *
    * @param articleId the article ID
    * @return the number of matching shopping order items
    * @throws SystemException if a system exception occurred
    */
    public int countByArticleId(java.lang.String articleId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping order item in the entity cache if it is enabled.
    *
    * @param shoppingOrderItem the shopping order item
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem);

    /**
    * Caches the shopping order items in the entity cache if it is enabled.
    *
    * @param shoppingOrderItems the shopping order items
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItems);

    /**
    * Creates a new shopping order item with the primary key. Does not add the shopping order item to the database.
    *
    * @param shoppingOrderItemId the primary key for the new shopping order item
    * @return the new shopping order item
    */
    public com.fsquare.shopping.model.ShoppingOrderItem create(
        long shoppingOrderItemId);

    /**
    * Removes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem remove(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingOrderItem updateImpl(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping order item with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderItemException} if it could not be found.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item
    * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem findByPrimaryKey(
        long shoppingOrderItemId)
        throws com.fsquare.shopping.NoSuchShoppingOrderItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping order item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param shoppingOrderItemId the primary key of the shopping order item
    * @return the shopping order item, or <code>null</code> if a shopping order item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingOrderItem fetchByPrimaryKey(
        long shoppingOrderItemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping order items.
    *
    * @return the shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping order items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @return the range of shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping order items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping order items
    * @param end the upper bound of the range of shopping order items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping order items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingOrderItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping order items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping order items.
    *
    * @return the number of shopping order items
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
