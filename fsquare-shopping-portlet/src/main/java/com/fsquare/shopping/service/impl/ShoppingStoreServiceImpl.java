package com.fsquare.shopping.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.fsquare.shopping.ShoppingUtil;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.service.base.ShoppingStoreServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

/**
 * The implementation of the shopping store remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.ShoppingStoreService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.ShoppingStoreServiceBaseImpl
 * @see com.fsquare.shopping.service.ShoppingStoreServiceUtil
 */
public class ShoppingStoreServiceImpl extends ShoppingStoreServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.ShoppingStoreServiceUtil} to access the shopping store remote service.
     */

	public Map<String, String[]> getSettings(){
		Map<String, String[]> settings = ShoppingUtil.getSettings();
		return settings;
	}
	
	public List<AssetCategory> getShoppingAssetCategories(long groupId) throws PortalException, SystemException{
		AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, "Shopping");
		List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(assetVocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		return categories;
	}
	
	public ShoppingStore getShoppingStore(long groupId) throws PortalException, SystemException{
		return shoppingStoreLocalService.getShoppingStore(groupId);
	}
	
	public ShoppingStore addShoppingStore(ShoppingStore shoppingStore) throws PortalException, SystemException{
		return shoppingStoreLocalService.addShoppingStore(shoppingStore);
	}
	
	public ShoppingStore updateShoppingStore(ShoppingStore shoppingStore) throws PortalException, SystemException{
		return shoppingStoreLocalService.updateShoppingStore(shoppingStore);
	}
}
