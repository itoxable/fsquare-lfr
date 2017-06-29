package com.fsquare.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.fsquare.shopping.model.ShoppingStorageLocation;
import com.fsquare.shopping.service.base.ShoppingStoreLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;

/**
 * The implementation of the shopping store local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingStoreLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingStoreLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil
 */
public class ShoppingStoreLocalServiceImpl
    extends ShoppingStoreLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil} to access the shopping store local service.
     */
	
	public List<ShoppingStorageLocation> getShoppingStorageLocationsByGroup(long companyId) throws SystemException{
		return shoppingStorageLocationPersistence.findByCompanyId(companyId);
	}
	
	public List<String[]> getShoppingLayouts(long companyId){
		Locale locale = LocaleUtil.getDefault();
		List<String[]> shoppingLayouts = new ArrayList<String[]>();
		try {
			List<Layout> layoutsTemp = LayoutLocalServiceUtil.getLayouts(companyId, false);
			for(Layout lay : layoutsTemp){
				String[] val = new String[]{lay.getUuid(), ""};
				shoppingLayouts.add(val);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return shoppingLayouts;
	}
}
