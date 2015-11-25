package com.fsquare.shopping.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fsquare.shopping.model.ShoppingCoupon;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.portlet.util.ShoppingPortletUtil;
import com.fsquare.shopping.service.base.ShoppingOrderLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the shopping order local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingOrderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingOrderLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil
 */
public class ShoppingOrderLocalServiceImpl
    extends ShoppingOrderLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil} to access the shopping order local service.
     */
	public List<ShoppingOrder> findByGroupId(long groupId) throws SystemException{
		return shoppingOrderPersistence.findByGroupId(groupId);
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
	
//	public ShoppingOrder setOrderTotal(ShoppingOrder shoppingOrder, Collection<ShoppingOrderItem> shoppingOrderItemList){
//		shoppingOrder.setTotalPrice(totalPrice);
//		return shoppingOrder;
//	}
	
}
