package com.fsquare.shopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ShoppingStore. This utility wraps
 * {@link com.fsquare.shopping.service.impl.ShoppingStoreServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStoreService
 * @see com.fsquare.shopping.service.base.ShoppingStoreServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingStoreServiceImpl
 * @generated
 */
public class ShoppingStoreServiceUtil {
    private static ShoppingStoreService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingStoreServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static java.util.Map<java.lang.String, java.lang.String[]> getSettings() {
        return getService().getSettings();
    }

    public static java.util.List<com.liferay.portlet.asset.model.AssetCategory> getShoppingAssetCategories(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingAssetCategories(groupId);
    }

    public static com.fsquare.shopping.model.ShoppingStore getShoppingStore(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getShoppingStore(groupId);
    }

    public static com.fsquare.shopping.model.ShoppingStore addShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addShoppingStore(shoppingStore);
    }

    public static com.fsquare.shopping.model.ShoppingStore updateShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateShoppingStore(shoppingStore);
    }

    public static void clearService() {
        _service = null;
    }

    public static ShoppingStoreService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ShoppingStoreService.class.getName());

            if (invokableService instanceof ShoppingStoreService) {
                _service = (ShoppingStoreService) invokableService;
            } else {
                _service = new ShoppingStoreServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ShoppingStoreServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ShoppingStoreService service) {
    }
}
