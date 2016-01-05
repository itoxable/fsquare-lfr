package com.fsquare.shopping.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.model.ShoppingItemImage;
import com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil;
import com.fsquare.shopping.service.base.ShoppingItemLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

/**
 * The implementation of the shopping item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingItemLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingItemLocalServiceUtil
 */          
public class ShoppingItemLocalServiceImpl
    extends ShoppingItemLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingItemLocalServiceUtil} to access the shopping item local service.
     */
	
	public List<ShoppingItem> findByGroupId(long groupId) throws SystemException{
		return shoppingItemPersistence.findByGroupId(groupId);
	}
	
	@Override
    public ShoppingItem addShoppingItem(ShoppingItem shoppingItem, long userId, List<byte[]> images, ServiceContext serviceContext) throws SystemException, PortalException, IOException {
        shoppingItem.setNew(true);
        
        long groupId = shoppingItem.getGroupId();
        long companyId = shoppingItem.getCompanyId();
        shoppingItem = shoppingItemPersistence.update(shoppingItem);
        ResourceLocalServiceUtil.addResources(companyId, groupId, userId, ShoppingItem.class.getName(), shoppingItem.getItemId(), false,true, true);
        
        AssetEntry assetEntry = AssetEntryLocalServiceUtil.createAssetEntry(counterLocalService.increment());
        
//        AssetEntryLocalServiceUtil.updateEntry(userId, groupId, ShoppingItem.class.getName(), shoppingItem.getItemId(), serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());
//        AssetEntryLocalServiceUtil.updateEntry(userId, groupId, className, classPK, classUuid, classTypeId, categoryIds, tagNames, visible, startDate, endDate, expirationDate, mimeType, title, description, summary, url, layoutUuid, height, width, priority, sync)dateEntry(userId, groupId, ShoppingItem.class.getName(), shoppingItem.getItemId(), serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());

        assetEntry.setUserId(userId);
        assetEntry.setGroupId(groupId);
        assetEntry.setCompanyId(companyId);
        assetEntry.setClassName(ShoppingItem.class.getName());
        assetEntry.setClassUuid(shoppingItem.getUuid());
        assetEntry.setClassPK(shoppingItem.getItemId());
        assetEntry.setDescription(shoppingItem.getDescription());
        assetEntry.setTitle(shoppingItem.getName());
        assetEntry.setPublishDate(shoppingItem.getCreateDate());
        assetEntry.setCreateDate(shoppingItem.getCreateDate());
        assetEntry.setModifiedDate(shoppingItem.getCreateDate());
        assetEntry.setUserName(UserServiceUtil.getUserById(userId).getScreenName());
//        assetEntry.set
        
        AssetEntryLocalServiceUtil.updateAssetEntry(assetEntry);
        for(int i = 0; i < images.size(); i++){

        	byte[] fileBytes = images.get(i);
        	Image image = ImageLocalServiceUtil.updateImage(counterLocalService.increment(Image.class.getName()), fileBytes);
//        	ImageToolUtil

        	ShoppingItemImage shoppingItemImage = ShoppingItemImageLocalServiceUtil.createShoppingItemImage(counterLocalService.increment(ShoppingItemImage.class.getName()));
        	if(i == 0){
        		shoppingItemImage.setMainImage(true);
        	}
        	shoppingItemImage.setOrder(i);
        	shoppingItemImage.setGroupId(shoppingItem.getGroupId());
        	shoppingItemImage.setItemId(shoppingItem.getItemId());
        	shoppingItemImage.setImageId(image.getImageId());
        	
        	ShoppingItemImageLocalServiceUtil.addShoppingItemImage(shoppingItemImage);
        }
        return shoppingItem;
    }
	
    @Override
    public ShoppingItem deleteShoppingItem(ShoppingItem shoppingItem) throws SystemException, PortalException {
        long companyId = shoppingItem.getCompanyId();
	    resourceLocalService.deleteResource(companyId, ShoppingItem.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL, shoppingItem.getPrimaryKey());
	    assetEntryLocalService.deleteEntry(ShoppingItem.class.getName(), shoppingItem.getItemId());
	    return shoppingItemPersistence.remove(shoppingItem);
	}
}
