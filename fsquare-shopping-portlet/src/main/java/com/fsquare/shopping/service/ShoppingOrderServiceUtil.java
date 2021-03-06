package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ShoppingOrder. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingOrderServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderService
 * @see com.fsquare.shopping.service.base.ShoppingOrderServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingOrderServiceImpl
 * @generated
 */
public class ShoppingOrderServiceUtil {
    private static ShoppingOrderService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingOrderServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCompanyId(companyId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByCompanyIdAndUserId(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCompanyIdAndUserId(companyId, userId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBygroupIdAndEmail(
        long companyId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findBygroupIdAndEmail(companyId, email);
    }

    public static double getOrderTotal(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList) {
        return getService().getOrderTotal(shoppingOrderItemList);
    }

    public static int getOrderItemsCount(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList) {
        return getService().getOrderItemsCount(shoppingOrderItemList);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingOrderService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingOrderService.class.getName());

            if (invokableService instanceof ShoppingOrderService) {
                _service = (ShoppingOrderService) invokableService;
            } else {
                _service = new ShoppingOrderServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ShoppingOrderServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingOrderService service) {
    }
}
