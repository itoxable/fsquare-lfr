package com.fsquare.shopping.service.impl;

import com.fsquare.shopping.model.ShoppingOrder;
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
	
	public ShoppingOrder addShoppingOrder(ShoppingOrder shoppingOrder)
        throws SystemException {
        shoppingOrder.setNew(true);

        return shoppingOrderPersistence.update(shoppingOrder);
    }

    public ShoppingOrder createShoppingOrder(long orderId) {
        return shoppingOrderPersistence.create(orderId);
    }
	
}
