package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ShoppingCoupon. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingCouponServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponService
 * @see com.fsquare.shopping.service.base.ShoppingCouponServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingCouponServiceImpl
 * @generated
 */
public class ShoppingCouponServiceUtil {
    private static ShoppingCouponService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingCouponServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.fsquare.shopping.model.ShoppingCoupon fetchByCode(
        java.lang.String code) {
        return getService().fetchByCode(code);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingCouponService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingCouponService.class.getName());

            if (invokableService instanceof ShoppingCouponService) {
                _service = (ShoppingCouponService) invokableService;
            } else {
                _service = new ShoppingCouponServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ShoppingCouponServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingCouponService service) {
    }
}
