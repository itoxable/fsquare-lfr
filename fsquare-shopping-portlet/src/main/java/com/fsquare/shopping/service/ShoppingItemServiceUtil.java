package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ShoppingItem. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingItemServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemService
 * @see com.fsquare.shopping.service.base.ShoppingItemServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingItemServiceImpl
 * @generated
 */
public class ShoppingItemServiceUtil {
    private static ShoppingItemService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static boolean fixDeletedItem(long itemId, long companyId,
        java.lang.String uid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().fixDeletedItem(itemId, companyId, uid);
    }

    public static java.lang.Object getCompleteByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCompleteByGroupId(groupId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByGroupId(groupId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItem> findByGroupId(
        java.lang.Long groupId) {
        return getService().findByGroupId(groupId);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> getPagedItems(
        java.lang.Long groupId, int start, int end) {
        return getService().getPagedItems(groupId, start, end);
    }

    public static int countByGroupId(java.lang.Long groupId) {
        return getService().countByGroupId(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingItemService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingItemService.class.getName());

            if (invokableService instanceof ShoppingItemService) {
                _service = (ShoppingItemService) invokableService;
            } else {
                _service = new ShoppingItemServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ShoppingItemServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingItemService service) {
    }
}
