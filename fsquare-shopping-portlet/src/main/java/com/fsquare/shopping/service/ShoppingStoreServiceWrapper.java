package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingStoreService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStoreService
 * @generated
 */
public class ShoppingStoreServiceWrapper implements ShoppingStoreService,
    ServiceWrapper<ShoppingStoreService> {
    private ShoppingStoreService _shoppingStoreService;

    public ShoppingStoreServiceWrapper(
        ShoppingStoreService shoppingStoreService) {
        _shoppingStoreService = shoppingStoreService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingStoreService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingStoreService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingStoreService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.String[]> getSettings() {
        return _shoppingStoreService.getSettings();
    }

    @Override
    public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getShoppingAssetCategories(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreService.getShoppingAssetCategories(groupId);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStore getShoppingStore(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreService.getShoppingStore(groupId);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStore addShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreService.addShoppingStore(shoppingStore);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStore updateShoppingStore(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStoreService.updateShoppingStore(shoppingStore);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingStoreService getWrappedShoppingStoreService() {
        return _shoppingStoreService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingStoreService(
        ShoppingStoreService shoppingStoreService) {
        _shoppingStoreService = shoppingStoreService;
    }

    @Override
    public ShoppingStoreService getWrappedService() {
        return _shoppingStoreService;
    }

    @Override
    public void setWrappedService(ShoppingStoreService shoppingStoreService) {
        _shoppingStoreService = shoppingStoreService;
    }
}
