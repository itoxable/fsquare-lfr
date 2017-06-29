package com.fsquare.shopping.service.impl;

import java.util.List;

import com.fsquare.shopping.NoSuchShoppingItemStorageLocationException;
import com.fsquare.shopping.model.ShoppingItemStorageLocation;
import com.fsquare.shopping.service.base.ShoppingItemStorageLocationLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the shopping item storage location local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingItemStorageLocationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingItemStorageLocationLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingItemStorageLocationLocalServiceUtil
 */
public class ShoppingItemStorageLocationLocalServiceImpl
    extends ShoppingItemStorageLocationLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingItemStorageLocationLocalServiceUtil} to access the shopping item storage location local service.
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
	public List<ShoppingItemStorageLocation> findByCompanyId(long companyId) throws NoSuchShoppingItemStorageLocationException, SystemException{
		return shoppingItemStorageLocationPersistence.findByCompanyId(companyId);
	}
}
