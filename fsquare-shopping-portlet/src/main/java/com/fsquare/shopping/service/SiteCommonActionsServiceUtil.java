package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SiteCommonActions. This utility wraps
 * {@link com.fsquare.shopping.service.impl.SiteCommonActionsServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommonActionsService
 * @see com.fsquare.shopping.service.base.SiteCommonActionsServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.SiteCommonActionsServiceImpl
 * @generated
 */
public class SiteCommonActionsServiceUtil {
    private static SiteCommonActionsService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.SiteCommonActionsServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.portal.model.Layout updateLayout(long groupId,
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
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateLayout(groupId, privateLayout, layoutId,
            parentLayoutId, localeNamesMap, localeTitlesMap, descriptionMap,
            keywordsMap, robotsMap, type, hidden, friendlyURLMap, iconImage,
            iconBytes, serviceContext);
    }

    public static com.liferay.portal.model.Group updateGroup(long groupId,
        long parentGroupId, java.lang.String name,
        java.lang.String description, int type, boolean manualMembership,
        int membershipRestriction, java.lang.String friendlyURL,
        boolean active, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateGroup(groupId, parentGroupId, name, description,
            type, manualMembership, membershipRestriction, friendlyURL, active,
            serviceContext);
    }

    public static com.liferay.portal.model.User updatePassword(long userId,
        java.lang.String oldPassword, java.lang.String password1,
        java.lang.String password2)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updatePassword(userId, oldPassword, password1, password2);
    }

    public static java.lang.String getUserPortraitUrl(boolean male,
        long portraitId) {
        return getService().getUserPortraitUrl(male, portraitId);
    }

    public static java.util.List<java.util.Map> getAccountsPaged(int start,
        int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAccountsPaged(start, end);
    }

    public static java.util.List<java.util.Map> getAccounts()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAccounts();
    }

    public static java.util.Map getAccount(long accountId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAccount(accountId);
    }

    public static java.util.List<com.liferay.portal.model.Company> getCompanies()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCompanies();
    }

    public static void testFileUpload(java.io.File file) {
        getService().testFileUpload(file);
    }

    public static void testFilesUpload(java.util.List<java.io.File> files) {
        getService().testFilesUpload(files);
    }

    public static void testFilesUploadArr(java.io.File[] files) {
        getService().testFilesUploadArr(files);
    }

    public static void clearService() {
        _service = null;
    }

    public static SiteCommonActionsService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SiteCommonActionsService.class.getName());

            if (invokableService instanceof SiteCommonActionsService) {
                _service = (SiteCommonActionsService) invokableService;
            } else {
                _service = new SiteCommonActionsServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(SiteCommonActionsServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(SiteCommonActionsService service) {
    }
}
