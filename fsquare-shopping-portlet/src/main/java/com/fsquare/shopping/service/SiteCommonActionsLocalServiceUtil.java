package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SiteCommonActions. This utility wraps
 * {@link com.fsquare.shopping.service.impl.SiteCommonActionsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommonActionsLocalService
 * @see com.fsquare.shopping.service.base.SiteCommonActionsLocalServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.SiteCommonActionsLocalServiceImpl
 * @generated
 */
public class SiteCommonActionsLocalServiceUtil {
    private static SiteCommonActionsLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.SiteCommonActionsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static java.util.List<com.liferay.portal.model.Company> getCompanies()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCompanies();
    }

    public static void clearService() {
        _service = null;
    }

    public static SiteCommonActionsLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SiteCommonActionsLocalService.class.getName());

            if (invokableLocalService instanceof SiteCommonActionsLocalService) {
                _service = (SiteCommonActionsLocalService) invokableLocalService;
            } else {
                _service = new SiteCommonActionsLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SiteCommonActionsLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(SiteCommonActionsLocalService service) {
    }
}
