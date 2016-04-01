package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingItemStorageLocationService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocationService
 * @generated
 */
public class ShoppingItemStorageLocationServiceWrapper
    implements ShoppingItemStorageLocationService,
        ServiceWrapper<ShoppingItemStorageLocationService> {
    private ShoppingItemStorageLocationService _shoppingItemStorageLocationService;

    public ShoppingItemStorageLocationServiceWrapper(
        ShoppingItemStorageLocationService shoppingItemStorageLocationService) {
        _shoppingItemStorageLocationService = shoppingItemStorageLocationService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingItemStorageLocationService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingItemStorageLocationService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingItemStorageLocationService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation findByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationService.findByItemIdAndStorageLocationId(itemId,
            storageLocationId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByItemId(
        long itemId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationService.findByItemId(itemId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationService.findByStorageLocationId(storageLocationId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> findByGroupId(
        long groupId)
        throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocationService.findByGroupId(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingItemStorageLocationService getWrappedShoppingItemStorageLocationService() {
        return _shoppingItemStorageLocationService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingItemStorageLocationService(
        ShoppingItemStorageLocationService shoppingItemStorageLocationService) {
        _shoppingItemStorageLocationService = shoppingItemStorageLocationService;
    }

    @Override
    public ShoppingItemStorageLocationService getWrappedService() {
        return _shoppingItemStorageLocationService;
    }

    @Override
    public void setWrappedService(
        ShoppingItemStorageLocationService shoppingItemStorageLocationService) {
        _shoppingItemStorageLocationService = shoppingItemStorageLocationService;
    }
}
