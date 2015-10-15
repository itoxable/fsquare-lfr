package com.fsquare.shopping.service.impl;

import com.fsquare.shopping.model.ShoppingOrder;
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
	
	public ShoppingOrder addShoppingOrder(ShoppingOrder shoppingOrder)
        throws SystemException {
        shoppingOrder.setNew(true);

        return shoppingOrderPersistence.update(shoppingOrder);
    }

    public ShoppingOrder createShoppingOrder(long orderId) {
        return shoppingOrderPersistence.create(orderId);
    }
}
