package com.fsquare.shopping.service.impl;

import java.io.IOException;
import java.util.List;

import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.model.ShoppingItemImage;
import com.fsquare.shopping.model.ShoppingItemStorageLocation;
import com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingItemStorageLocationLocalServiceUtil;
import com.fsquare.shopping.service.base.ShoppingItemLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
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
	
	public List<ShoppingItem> findByCompanyId(long companyId) throws SystemException{
		return shoppingItemPersistence.findByCompanyId(companyId);
	}
	
	@Override
    public ShoppingItem addShoppingItem(ShoppingItem shoppingItem, long userId, List<byte[]> images, ServiceContext serviceContext) throws SystemException, PortalException, IOException {
        shoppingItem.setNew(true);
        
        long companyId = shoppingItem.getCompanyId();
        shoppingItem = shoppingItemPersistence.update(shoppingItem);
        resourceLocalService.addResources(companyId, companyId, userId, ShoppingItem.class.getName(), shoppingItem.getItemId(), false,true, true);
        
        AssetEntry assetEntry = assetEntryLocalService.createAssetEntry(counterLocalService.increment());
        
        assetEntry.setUserId(userId);
        assetEntry.setCompanyId(companyId);
        assetEntry.setClassName(ShoppingItem.class.getName());
        assetEntry.setClassUuid(shoppingItem.getUuid());
        assetEntry.setClassPK(shoppingItem.getItemId());
        assetEntry.setDescription(shoppingItem.getDescription());
        assetEntry.setTitle(shoppingItem.getTitle());
        assetEntry.setPublishDate(shoppingItem.getCreateDate());
        assetEntry.setCreateDate(shoppingItem.getCreateDate());
        assetEntry.setModifiedDate(shoppingItem.getCreateDate());
        assetEntry.setUserName(shoppingItem.getUserName());
        assetEntry.setClassTypeId(0);
        assetEntry.setVisible(true);
        String summary = HtmlUtil.extractText(
    			StringUtil.shorten(shoppingItem.getTitle()+"-"+shoppingItem.getDescription(), 500));
        
        assetEntry.setSummary(summary);
        AssetEntryLocalServiceUtil.updateAssetEntry(assetEntry);
        for(int i = 0; i < images.size(); i++){

        	byte[] fileBytes = images.get(i);
        	Image image = ImageLocalServiceUtil.updateImage(counterLocalService.increment(Image.class.getName()), fileBytes);

        	ShoppingItemImage shoppingItemImage = ShoppingItemImageLocalServiceUtil.createShoppingItemImage(counterLocalService.increment(ShoppingItemImage.class.getName()));
        	if(i == 0){
        		shoppingItemImage.setMainImage(true);
        	}
        	shoppingItemImage.setOrder(i);
        	shoppingItemImage.setCompanyId(shoppingItem.getCompanyId());
        	shoppingItemImage.setItemId(shoppingItem.getItemId());
        	shoppingItemImage.setImageId(image.getImageId());
        	
        	ShoppingItemImageLocalServiceUtil.addShoppingItemImage(shoppingItemImage);
        }
                
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ShoppingItem.class);
        indexer.reindex(shoppingItem);
        return shoppingItem;
    }
	
    @Override
    public ShoppingItem deleteShoppingItem(ShoppingItem shoppingItem) throws SystemException, PortalException {
        long companyId = shoppingItem.getCompanyId();
       //shoppingItemPersistence.remove(itemId)
	    resourceLocalService.deleteResource(companyId, ShoppingItem.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL, shoppingItem.getPrimaryKey());
	    assetEntryLocalService.deleteEntry(ShoppingItem.class.getName(), shoppingItem.getItemId());
	    Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ShoppingItem.class);
	    indexer.delete(shoppingItem);

	    List<ShoppingItemImage> shoppingItemImageList = shoppingItemImagePersistence.findByCompanyIdAndItemId(shoppingItem.getCompanyId(), shoppingItem.getItemId());
	    for(ShoppingItemImage shoppingItemImage : shoppingItemImageList){
	    	ImageLocalServiceUtil.deleteImage(shoppingItemImage.getImageId());
		    ShoppingItemImageLocalServiceUtil.deleteShoppingItemImage(shoppingItemImage);
	    }
	    
	    
	    return shoppingItemPersistence.remove(shoppingItem);
	}
    @Override
    public ShoppingItem deleteShoppingItem(long itemId) throws SystemException, PortalException {
    	ShoppingItem shoppingItem = shoppingItemPersistence.remove(itemId);
        long companyId = shoppingItem.getCompanyId();
	    resourceLocalService.deleteResource(companyId, ShoppingItem.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL, shoppingItem.getPrimaryKey());
	    assetEntryLocalService.deleteEntry(ShoppingItem.class.getName(), shoppingItem.getItemId());
	    Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ShoppingItem.class);
	    indexer.delete(shoppingItem);

	    return shoppingItem;
	}
    
    @Override
    public List<ShoppingItemImage> getItemImages(ShoppingItem shoppingItem) throws SystemException, PortalException {
    	List<ShoppingItemImage> shoppingItemImageList = shoppingItemImagePersistence.findByCompanyIdAndItemId(shoppingItem.getCompanyId(), shoppingItem.getItemId());
	    return shoppingItemImageList;
	}
    
    @Override
    public AssetEntry getEntry(long itemId) throws SystemException, PortalException {
    
    	AssetEntry assetEntry = assetEntryLocalService.getEntry(ShoppingItem.class.getName(), itemId);
	    
	    return assetEntry;
	}
    
    @Override
    public int availableQuantity(long itemId) throws SystemException, PortalException {
    	List<ShoppingItemStorageLocation> shoppingItemStorageLocationList = ShoppingItemStorageLocationLocalServiceUtil.findByItemId(itemId);
    	int quantity = 0;
    	for(ShoppingItemStorageLocation itemStorageLocation : shoppingItemStorageLocationList){
    		quantity = quantity + itemStorageLocation.getQuantity();
    	}
    	return quantity;
	}
    
}
