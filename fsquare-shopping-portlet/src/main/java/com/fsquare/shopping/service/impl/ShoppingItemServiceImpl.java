package com.fsquare.shopping.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsquare.shopping.NoSuchShoppingItemImageException;
import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.model.ShoppingItemImage;
import com.fsquare.shopping.service.base.ShoppingItemServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;

/**
 * The implementation of the shopping item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingItemService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingItemServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingItemServiceUtil
 */
public class ShoppingItemServiceImpl extends ShoppingItemServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingItemServiceUtil} to access the shopping item remote service.
     */
	
	@Override
    public boolean fixDeletedItem(long itemId, long companyId, String uid) throws SystemException, PortalException {
    	try{
    		ShoppingItem shoppingItem = shoppingItemPersistence.remove(itemId);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	    resourceLocalService.deleteResource(companyId, ShoppingItem.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL, itemId);
	    assetEntryLocalService.deleteEntry(ShoppingItem.class.getName(), itemId);
	    Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ShoppingItem.class);
	    indexer.delete(companyId, uid);

	    return true;
	}

	public Object getCompleteByGroupId(long groupId) throws SystemException{
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<ShoppingItem> items = shoppingItemPersistence.findByGroupId(groupId);
		for(ShoppingItem item: items){
			Map<String, Object> detailMap = new HashMap<String, Object>();
			detailMap.put("item", item);
	  		ShoppingItemImage mainImage = null;
			try {
				mainImage = shoppingItemImagePersistence.findByGroupIdAndItemAndMain(item.getGroupId(), item.getItemId(), true);
			} catch (NoSuchShoppingItemImageException e) {
				e.printStackTrace();
			}
			
			detailMap.put("mainImage", mainImage);
			
			List<ShoppingItemImage> images = shoppingItemImagePersistence.findByGroupIdAndItemId(item.getGroupId(), item.getItemId());
			
			detailMap.put("images", images);
			result.add(detailMap);
		}
		
		return result;
	}
	
	public List<ShoppingItem> findByGroupId(long groupId) throws SystemException{
		return shoppingItemPersistence.findByGroupId(groupId);
	}
	
	public List<ShoppingItem> findByGroupId(Long groupId){
		try {
			return shoppingItemPersistence.findByGroupId(groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	public Map<String, Object> getPagedItems(Long groupId, int start, int end){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer total = shoppingItemPersistence.countByGroupId(groupId);
			List<ShoppingItem> items = shoppingItemPersistence.findByGroupId(groupId, start, end);
			result.put("total", total.toString());
			result.put("items", items);
			result.put("quant", items.size());
			result.put("start", start);
			result.put("end", end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return result;
	}
	
		
	public int countByGroupId(Long groupId){
		try {
			return shoppingItemPersistence.countByGroupId(groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
