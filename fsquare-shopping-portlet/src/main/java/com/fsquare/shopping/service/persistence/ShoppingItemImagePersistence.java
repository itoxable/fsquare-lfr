package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.model.ShoppingItemImage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping item image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemImagePersistenceImpl
 * @see ShoppingItemImageUtil
 * @generated
 */
public interface ShoppingItemImagePersistence extends BasePersistence<ShoppingItemImage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingItemImageUtil} to access the shopping item image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the shopping item images where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping item images where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @return the range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping item images where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item images before and after the current shopping item image in the ordered set where groupId = &#63;.
    *
    * @param shoppingItemImageId the primary key of the current shopping item image
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage[] findByGroupId_PrevAndNext(
        long shoppingItemImageId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item images where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item images where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @return the matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupIdAndItemId(
        long groupId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @return the range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupIdAndItemId(
        long groupId, long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findByGroupIdAndItemId(
        long groupId, long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage findByGroupIdAndItemId_First(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemId_First(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage findByGroupIdAndItemId_Last(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemId_Last(
        long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item images before and after the current shopping item image in the ordered set where groupId = &#63; and itemId = &#63;.
    *
    * @param shoppingItemImageId the primary key of the current shopping item image
    * @param groupId the group ID
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage[] findByGroupIdAndItemId_PrevAndNext(
        long shoppingItemImageId, long groupId, long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item images where groupId = &#63; and itemId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupIdAndItemId(long groupId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item images where groupId = &#63; and itemId = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @return the number of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupIdAndItemId(long groupId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemImageException} if it could not be found.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the matching shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage findByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage fetchByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the shopping item image where groupId = &#63; and itemId = &#63; and mainImage = &#63; from the database.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the shopping item image that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage removeByGroupIdAndItemAndMain(
        long groupId, long itemId, boolean mainImage)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item images where groupId = &#63; and itemId = &#63; and mainImage = &#63;.
    *
    * @param groupId the group ID
    * @param itemId the item ID
    * @param mainImage the main image
    * @return the number of matching shopping item images
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupIdAndItemAndMain(long groupId, long itemId,
        boolean mainImage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the shopping item image in the entity cache if it is enabled.
    *
    * @param shoppingItemImage the shopping item image
    */
    public void cacheResult(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage);

    /**
    * Caches the shopping item images in the entity cache if it is enabled.
    *
    * @param shoppingItemImages the shopping item images
    */
    public void cacheResult(
        java.util.List<com.fsquare.shopping.model.ShoppingItemImage> shoppingItemImages);

    /**
    * Creates a new shopping item image with the primary key. Does not add the shopping item image to the database.
    *
    * @param shoppingItemImageId the primary key for the new shopping item image
    * @return the new shopping item image
    */
    public com.fsquare.shopping.model.ShoppingItemImage create(
        long shoppingItemImageId);

    /**
    * Removes the shopping item image with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image that was removed
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage remove(
        long shoppingItemImageId)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingItemImage updateImpl(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item image with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemImageException} if it could not be found.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image
    * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage findByPrimaryKey(
        long shoppingItemImageId)
        throws com.fsquare.shopping.NoSuchShoppingItemImageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the shopping item image with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param shoppingItemImageId the primary key of the shopping item image
    * @return the shopping item image, or <code>null</code> if a shopping item image with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.fsquare.shopping.model.ShoppingItemImage fetchByPrimaryKey(
        long shoppingItemImageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the shopping item images.
    *
    * @return the shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the shopping item images.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @return the range of shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the shopping item images.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of shopping item images
    * @param end the upper bound of the range of shopping item images (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of shopping item images
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.fsquare.shopping.model.ShoppingItemImage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the shopping item images from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of shopping item images.
    *
    * @return the number of shopping item images
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
