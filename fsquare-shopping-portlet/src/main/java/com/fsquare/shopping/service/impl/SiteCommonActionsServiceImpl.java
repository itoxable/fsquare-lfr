package com.fsquare.shopping.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.fsquare.shopping.service.SiteCommonActionsLocalServiceUtil;
import com.fsquare.shopping.service.base.SiteCommonActionsServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Account;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.membershippolicy.SiteMembershipPolicyUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.AccountLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portal.service.permission.LayoutPermissionUtil;
import com.liferay.portal.service.permission.PortalPermissionUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;

/**
 * The implementation of the site common actions remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.SiteCommonActionsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.SiteCommonActionsServiceBaseImpl
 * @see com.fsquare.shopping.service.SiteCommonActionsServiceUtil
 */
public class SiteCommonActionsServiceImpl
    extends SiteCommonActionsServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.SiteCommonActionsServiceUtil} to access the site common actions remote service.
     */
	
	@Override
	public Layout updateLayout(
			long groupId, boolean privateLayout, long layoutId,
			long parentLayoutId, Map<Locale, String> localeNamesMap,
			Map<Locale, String> localeTitlesMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> keywordsMap,
			Map<Locale, String> robotsMap, String type, boolean hidden,
			Map<Locale, String> friendlyURLMap, Boolean iconImage,
			byte[] iconBytes, ServiceContext serviceContext)
		throws PortalException, SystemException {

		LayoutPermissionUtil.check(
			getPermissionChecker(), groupId, privateLayout, layoutId,
			ActionKeys.UPDATE);

		for(Map.Entry<Locale, String> entry: friendlyURLMap.entrySet()){
			if(!entry.getValue().startsWith("/")){
				entry.setValue("/"+entry.getValue());
			}
		}
		
		return LayoutLocalServiceUtil.updateLayout(
			groupId, privateLayout, layoutId, parentLayoutId, localeNamesMap,
			localeTitlesMap, descriptionMap, keywordsMap, robotsMap, type,
			hidden, friendlyURLMap, iconImage, iconBytes, serviceContext);
	}
	@Override
	public Group updateGroup(
			long groupId, long parentGroupId, String name, String description,
			int type, boolean manualMembership, int membershipRestriction,
			String friendlyURL, boolean active, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if(!friendlyURL.startsWith("/")){
			friendlyURL = "/"+friendlyURL;
		}
		
		Group group = groupPersistence.findByPrimaryKey(groupId);

		GroupPermissionUtil.check(
			getPermissionChecker(), group, ActionKeys.UPDATE);

		if (group.getParentGroupId() != parentGroupId) {
			if (parentGroupId == GroupConstants.DEFAULT_PARENT_GROUP_ID) {
				PortalPermissionUtil.check(
					getPermissionChecker(), ActionKeys.ADD_COMMUNITY);
			}
			else {
				GroupPermissionUtil.check(
					getPermissionChecker(), parentGroupId,
					ActionKeys.ADD_COMMUNITY);
			}
		}

		if (group.isSite()) {
			Group oldGroup = group;

			List<AssetCategory> oldAssetCategories =
				AssetCategoryLocalServiceUtil.getCategories(
					Group.class.getName(), groupId);

			List<AssetTag> oldAssetTags = assetTagLocalService.getTags(
				Group.class.getName(), groupId);

			ExpandoBridge oldExpandoBridge = oldGroup.getExpandoBridge();

			Map<String, Serializable> oldExpandoAttributes =
				oldExpandoBridge.getAttributes();

			group = groupLocalService.updateGroup(
				groupId, parentGroupId, name, description, type,
				manualMembership, membershipRestriction, friendlyURL, active,
				serviceContext);

			SiteMembershipPolicyUtil.verifyPolicy(
				group, oldGroup, oldAssetCategories, oldAssetTags,
				oldExpandoAttributes, null);

			return group;
		}
		else {
			return groupLocalService.updateGroup(
				groupId, parentGroupId, name, description, type,
				manualMembership, membershipRestriction, friendlyURL, active,
				serviceContext);
		}
	}
	
	public User updatePassword(long userId, String oldPassword, String password1, String password2) throws PortalException, SystemException{
		return SiteCommonActionsLocalServiceUtil.updatePassword(userId, oldPassword, password1, password2);
	}
	
	public String getUserPortraitUrl(boolean male, long portraitId){
		return SiteCommonActionsLocalServiceUtil.getUserPortraitUrl(male, portraitId);
	}
	
	public List<Map> getAccountsPaged(int start, int end) throws SystemException, PortalException{
		List<Account> accounts =  accountLocalService.getAccounts(start, end);
		List<Map> list = new ArrayList<Map>();
		for(Account account: accounts){
			list.add(buildAccount(account));
		}
		return list;
	}
	public List<Map> getAccounts() throws SystemException, PortalException{
		List<Account> accounts =  accountLocalService.getAccounts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Map> list = new ArrayList<Map>();
		for(Account account: accounts){
			list.add(buildAccount(account));
		}
		return list;
	}
	
	private Map buildAccount(Account account) throws PortalException, SystemException{
		VirtualHost virtualHost = virtualHostLocalService.getVirtualHost(account.getCompanyId(), 0);
		Map<String, PersistedModel> map = new HashMap<String, PersistedModel>();
		map.put("account", account);
		map.put("virtualHost", virtualHost);
		return map;
	}
	
//	public Account updateAccount(Account account) throws SystemException{
//		account =  AccountLocalServiceUtil.updateAccount(account);
//		return account;
//	}
	public Map getAccount(long accountId) throws SystemException, PortalException{
		Account account =  accountLocalService.getAccount(accountId);
		return buildAccount(account);
	}
	
	
	
	
	public List<Company> getCompanies() throws SystemException{
		List<Company> companies =  companyLocalService.getCompanies(false);
		return companies;
		
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public void testFileUpload(File file){
		System.out.println("testFileUpload");
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public void testFilesUpload(List<File> files){
		System.out.println("testFilesUpload");
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public void testFilesUploadArr(File[] files){
		System.out.println("testFilesUploadArr");
	}
	
}
