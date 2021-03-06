package com.fsquare.shopping.service.impl;

import java.util.Collection;
import java.util.List;

import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.service.base.ShoppingShippingMethodLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the shopping shipping method local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingShippingMethodLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingShippingMethodLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil
 */
public class ShoppingShippingMethodLocalServiceImpl
    extends ShoppingShippingMethodLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil} to access the shopping shipping method local service.
     */
	
	public double getShippingPrice(ShoppingShippingMethod shoppingShippingMethod, Collection<ShoppingOrderItem> shoppingOrderItems, double total){
		
		if(shoppingShippingMethod == null || shoppingShippingMethod.getFreeTotal() > 0 && total >= shoppingShippingMethod.getFreeTotal()){
			return 0;
		}
		return shoppingShippingMethod.getPrice();
	}
	
	public ShoppingShippingMethod fetchDefaultShipping() throws SystemException{
		return shoppingShippingMethodPersistence.fetchBydefaultShipping(true);
	}
	
	public List<ShoppingShippingMethod> findByCompanyId(long companyId) throws SystemException{
		return shoppingShippingMethodPersistence.findByCompanyId(companyId);
	}
	
	public List<ShoppingShippingMethod> findByCompanyIdAndEnabled(long companyId) throws SystemException{
		return shoppingShippingMethodPersistence.findByCompanyIdAndEnabled(companyId, false);
	}
}

