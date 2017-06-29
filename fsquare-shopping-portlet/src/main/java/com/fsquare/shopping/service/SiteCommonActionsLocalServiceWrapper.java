package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SiteCommonActionsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommonActionsLocalService
 * @generated
 */
public class SiteCommonActionsLocalServiceWrapper
    implements SiteCommonActionsLocalService,
        ServiceWrapper<SiteCommonActionsLocalService> {
    private SiteCommonActionsLocalService _siteCommonActionsLocalService;

    public SiteCommonActionsLocalServiceWrapper(
        SiteCommonActionsLocalService siteCommonActionsLocalService) {
        _siteCommonActionsLocalService = siteCommonActionsLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _siteCommonActionsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _siteCommonActionsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _siteCommonActionsLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.model.User updatePassword(long userId,
        java.lang.String oldPassword, java.lang.String password1,
        java.lang.String password2)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsLocalService.updatePassword(userId,
            oldPassword, password1, password2);
    }

    @Override
    public java.lang.String getUserPortraitUrl(boolean male, long portraitId) {
        return _siteCommonActionsLocalService.getUserPortraitUrl(male,
            portraitId);
    }

    @Override
    public java.util.List<com.liferay.portal.model.Company> getCompanies()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteCommonActionsLocalService.getCompanies();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SiteCommonActionsLocalService getWrappedSiteCommonActionsLocalService() {
        return _siteCommonActionsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSiteCommonActionsLocalService(
        SiteCommonActionsLocalService siteCommonActionsLocalService) {
        _siteCommonActionsLocalService = siteCommonActionsLocalService;
    }

    @Override
    public SiteCommonActionsLocalService getWrappedService() {
        return _siteCommonActionsLocalService;
    }

    @Override
    public void setWrappedService(
        SiteCommonActionsLocalService siteCommonActionsLocalService) {
        _siteCommonActionsLocalService = siteCommonActionsLocalService;
    }
}
