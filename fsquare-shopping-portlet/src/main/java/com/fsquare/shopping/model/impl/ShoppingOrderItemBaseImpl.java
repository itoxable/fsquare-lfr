package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ShoppingOrderItem service. Represents a row in the &quot;FsquareShopping_ShoppingOrderItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingOrderItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemImpl
 * @see com.fsquare.shopping.model.ShoppingOrderItem
 * @generated
 */
public abstract class ShoppingOrderItemBaseImpl
    extends ShoppingOrderItemModelImpl implements ShoppingOrderItem {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a shopping order item model instance should use the {@link ShoppingOrderItem} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingOrderItemLocalServiceUtil.addShoppingOrderItem(this);
        } else {
            ShoppingOrderItemLocalServiceUtil.updateShoppingOrderItem(this);
        }
    }
}
