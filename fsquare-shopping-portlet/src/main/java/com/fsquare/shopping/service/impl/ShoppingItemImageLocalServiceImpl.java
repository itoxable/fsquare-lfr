package com.fsquare.shopping.service.impl;

import java.util.List;

import com.fsquare.shopping.NoSuchShoppingItemImageException;
import com.fsquare.shopping.model.ShoppingItemImage;
import com.fsquare.shopping.service.base.ShoppingItemImageLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the shopping item image local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingItemImageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingItemImageLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil
 */
public class ShoppingItemImageLocalServiceImpl
    extends ShoppingItemImageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil} to access the shopping item image local service.
     */
	
	@Override
	public List<ShoppingItemImage> findByGroupIdAndItemId(long groupId, long itemId) throws SystemException{
		return shoppingItemImagePersistence.findByGroupIdAndItemId(groupId, itemId);
	}
	
	@Override
	public ShoppingItemImage getItemMainImage(long groupId, long itemId) throws SystemException, NoSuchShoppingItemImageException{
		return shoppingItemImagePersistence.findByGroupIdAndItemAndMain(groupId, itemId, true);
	}
}
