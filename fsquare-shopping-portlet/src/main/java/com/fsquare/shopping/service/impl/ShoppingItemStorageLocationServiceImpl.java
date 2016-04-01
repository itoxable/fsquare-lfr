package com.fsquare.shopping.service.impl;

import java.util.List;

import com.fsquare.shopping.NoSuchShoppingItemStorageLocationException;
import com.fsquare.shopping.model.ShoppingItemStorageLocation;
import com.fsquare.shopping.service.base.ShoppingItemStorageLocationServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the shopping item storage location remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingItemStorageLocationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingItemStorageLocationServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingItemStorageLocationServiceUtil
 */
public class ShoppingItemStorageLocationServiceImpl
    extends ShoppingItemStorageLocationServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingItemStorageLocationServiceUtil} to access the shopping item storage location remote service.
     */
	@Override
	public ShoppingItemStorageLocation findByItemIdAndStorageLocationId(long itemId, long storageLocationId) throws NoSuchShoppingItemStorageLocationException, SystemException{
		return shoppingItemStorageLocationPersistence.findByItemIdAndStorageLocationId(itemId, storageLocationId);
	}
	
	@Override
	public List<ShoppingItemStorageLocation> findByItemId(long itemId) throws NoSuchShoppingItemStorageLocationException, SystemException{
		return shoppingItemStorageLocationPersistence.findByItemId(itemId);
	}
	
	@Override
	public List<ShoppingItemStorageLocation> findByStorageLocationId(long storageLocationId) throws NoSuchShoppingItemStorageLocationException, SystemException{
		return shoppingItemStorageLocationPersistence.findByStorageLocationId(storageLocationId);
	}
	
	@Override
	public List<ShoppingItemStorageLocation> findByGroupId(long groupId) throws NoSuchShoppingItemStorageLocationException, SystemException{
		return shoppingItemStorageLocationPersistence.findByGroupId(groupId);
	}
}
