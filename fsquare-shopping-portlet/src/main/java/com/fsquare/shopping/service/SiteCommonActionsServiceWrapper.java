package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SiteCommonActionsService}.
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommonActionsService
 * @generated
 */
public class SiteCommonActionsServiceWrapper implements SiteCommonActionsService,
    ServiceWrapper<SiteCommonActionsService> {
    private SiteCommonActionsService _siteCommonActionsService;

    public SiteCommonActionsServiceWrapper(
        SiteCommonActionsService siteCommonActionsService) {
        _siteCommonActionsService = siteCommonActionsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _siteCommonActionsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _siteCommonActionsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _siteCommonActionsService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.liferay.portal.model.Layout updateLayout(long groupId,
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
        return _siteCommonActionsService.updateLayout(groupId, privateLayout,
            layoutId, parentLayoutId, localeNamesMap, localeTitlesMap,
            descriptionMap, keywordsMap, robotsMap, type, hidden,
            friendlyURLMap, iconImage, iconBytes, serviceContext);
    }

    @Override
    public com.liferay.portal.model.Group updateGroup(long groupId,
        long parentGroupId, java.lang.String name,
        java.lang.String description, int type, boolean manualMembership,
        int membershipRestriction, java.lang.String friendlyURL,
        boolean active, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsService.updateGroup(groupId, parentGroupId,
            name, description, type, manualMembership, membershipRestriction,
            friendlyURL, active, serviceContext);
    }

    @Override
    public com.liferay.portal.model.User updatePassword(long userId,
        java.lang.String oldPassword, java.lang.String password1,
        java.lang.String password2)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsService.updatePassword(userId, oldPassword,
            password1, password2);
    }

    @Override
    public java.lang.String getUserPortraitUrl(boolean male, long portraitId) {
        return _siteCommonActionsService.getUserPortraitUrl(male, portraitId);
    }

    @Override
    public java.util.List<java.util.Map> getAccountsPaged(int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsService.getAccountsPaged(start, end);
    }

    @Override
    public java.util.List<java.util.Map> getAccounts()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsService.getAccounts();
    }

    @Override
    public java.util.Map getAccount(long accountId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsService.getAccount(accountId);
    }

    @Override
    public java.util.List<com.liferay.portal.model.Company> getCompanies()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsService.getCompanies();
    }

    @Override
    public void testFileUpload(java.io.File file) {
        _siteCommonActionsService.testFileUpload(file);
    }

    @Override
    public void testFilesUpload(java.util.List<java.io.File> files) {
        _siteCommonActionsService.testFilesUpload(files);
    }

    @Override
    public void testFilesUploadArr(java.io.File[] files) {
        _siteCommonActionsService.testFilesUploadArr(files);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SiteCommonActionsService getWrappedSiteCommonActionsService() {
        return _siteCommonActionsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSiteCommonActionsService(
        SiteCommonActionsService siteCommonActionsService) {
        _siteCommonActionsService = siteCommonActionsService;
    }

    @Override
    public SiteCommonActionsService getWrappedService() {
        return _siteCommonActionsService;
    }

    @Override
    public void setWrappedService(
        SiteCommonActionsService siteCommonActionsService) {
        _siteCommonActionsService = siteCommonActionsService;
    }
}
