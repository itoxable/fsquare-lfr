package com.fsquare.shopping.service.impl;

import java.util.Collection;
import java.util.List;

import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.service.base.ShoppingOrderServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the shopping order remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingOrderService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingOrderServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingOrderServiceUtil
 */
public class ShoppingOrderServiceImpl extends ShoppingOrderServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingOrderServiceUtil} to access the shopping order remote service.
     */
	
	public List<ShoppingOrder> findByGroupId(long groupId) throws SystemException{
		return shoppingOrderPersistence.findByGroupId(groupId);
	}
	
	public List<ShoppingOrder> findBygroupIdAndUserId(long groupId, long userId) throws SystemException{
		return shoppingOrderPersistence.findBygroupIdAndUserId(groupId, userId);
	}
	
	public List<ShoppingOrder> findBygroupIdAndEmail(long groupId, String email) throws SystemException{
		return shoppingOrderPersistence.findBygroupIdAndEmail(groupId, email);
	}
	
	public double getOrderTotal(Collection<ShoppingOrderItem> shoppingOrderItemList){
		double total = 0;
		for(ShoppingOrderItem shoppingOrderItem: shoppingOrderItemList){
			total = total + shoppingOrderItem.getQuantity() * shoppingOrderItem.getPrice();
		}
		return total;
	}
	
	public int getOrderItemsCount(Collection<ShoppingOrderItem> shoppingOrderItemList){
		int total = 0;
		for(ShoppingOrderItem shoppingOrderItem: shoppingOrderItemList){
			total = total + shoppingOrderItem.getQuantity();
		}
		return total;
	}
}
