package com.fsquare.shopping.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for SiteCommonActions. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommonActionsServiceUtil
 * @see com.fsquare.shopping.service.base.SiteCommonActionsServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.SiteCommonActionsServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface SiteCommonActionsService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SiteCommonActionsServiceUtil} to access the site common actions remote service. Add custom service methods to {@link com.fsquare.shopping.service.impl.SiteCommonActionsServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public com.liferay.portal.model.Layout updateLayout(long companyId,
        boolean privateLayout, long layoutId, long parentLayoutId,
        java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
        java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
        java.util.Map<java.util.Locale, java.lang.String> robotsMap,
        java.lang.String type, boolean hidden,
        java.util.Map<java.util.Locale, java.lang.String> friendlyURLMap,
        java.lang.Boolean iconImage, byte[] iconBytes,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.model.Group updateGroup(long groupId,
        long parentGroupId, java.lang.String name,
        java.lang.String description, int type, boolean manualMembership,
        int membershipRestriction, java.lang.String friendlyURL,
        boolean active, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.model.User updatePassword(long userId,
        java.lang.String oldPassword, java.lang.String password1,
        java.lang.String password2)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getUserPortraitUrl(boolean male, long portraitId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.Map> getAccountsPaged(int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.Map> getAccounts()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map getAccount(long accountId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portal.model.Company> getCompanies()
        throws com.liferay.portal.kernel.exception.SystemException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public void testFileUpload(java.io.File file);

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public void testFilesUpload(java.util.List<java.io.File> files);

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public void testFilesUploadArr(java.io.File[] files);
}
