package com.fsquare.shopping.service.impl;

import java.util.List;

import com.fsquare.shopping.service.base.SiteCommonActionsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.service.CompanyLocalServiceUtil;

/**
 * The implementation of the site common actions local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsquare.shopping.service.SiteCommonActionsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.base.SiteCommonActionsLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.SiteCommonActionsLocalServiceUtil
 */
public class SiteCommonActionsLocalServiceImpl
    extends SiteCommonActionsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.fsquare.shopping.service.SiteCommonActionsLocalServiceUtil} to access the site common actions local service.
     */
	public static final String PASSWORDS_ENCRYPTION_ALGORITHM = StringUtil.toUpperCase(GetterUtil.getString(PropsUtil.get(PropsKeys.PASSWORDS_ENCRYPTION_ALGORITHM)));
	
	public User updatePassword(long userId, String oldPassword, String password1, String password2)
		throws PortalException, SystemException {

		if(!passwordTrackerLocalService.isSameAsCurrentPassword(userId, oldPassword)){
			throw new PortalException("Wrong passoword");
		}
		
		return userLocalService.updatePassword(userId, password1, password2, false, false);
	}
	
	public String getUserPortraitUrl(boolean male, long portraitId){
		return UserConstants.getPortraitURL("/image", male, portraitId);
	}
	
	@Override
	public List<Company> getCompanies() throws SystemException{
//		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Company.class, PortalClassLoaderUtil.getClassLoader());
//		Criterion criterion = null;
//		criterion = RestrictionsFactoryUtil.in("companyId", new ArrayList<Long>());
//		dynamicQuery.add(criterion);
//		
//		
//		CompanyLocalServiceUtil.dynamicQuery(dynamicQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Company> companies =  CompanyLocalServiceUtil.getCompanies(false);
		return companies;
		
	}
	
}
