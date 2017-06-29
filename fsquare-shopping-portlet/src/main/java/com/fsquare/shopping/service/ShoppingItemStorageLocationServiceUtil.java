package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ShoppingItemStorageLocation. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingItemStorageLocationServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocationService
 * @see com.fsquare.shopping.service.base.ShoppingItemStorageLocationServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingItemStorageLocationServiceImpl
 * @generated
 */
public class ShoppingItemStorageLocationServiceUtil {
    private static ShoppingItemStorageLocationService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingItemStorageLocationServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.fsquare.shopping.model.ShoppingItemStorageLocation findByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByItemIdAndStorageLocationId(itemId, storageLocationId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByItemId(
        long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByItemId(itemId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByStorageLocationId(storageLocationId);
    }

    public static java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByCompanyId(
        long companyId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCompanyId(companyId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingItemStorageLocationService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingItemStorageLocationService.class.getName());

            if (invokableService instanceof ShoppingItemStorageLocationService) {
                _service = (ShoppingItemStorageLocationService) invokableService;
            } else {
                _service = new ShoppingItemStorageLocationServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ShoppingItemStorageLocationServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingItemStorageLocationService service) {
    }
}
