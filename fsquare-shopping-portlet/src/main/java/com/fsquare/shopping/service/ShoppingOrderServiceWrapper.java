package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingOrderService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderService
 * @generated
 */
public class ShoppingOrderServiceWrapper implements ShoppingOrderService,
    ServiceWrapper<ShoppingOrderService> {
    private ShoppingOrderService _shoppingOrderService;

    public ShoppingOrderServiceWrapper(
        ShoppingOrderService shoppingOrderService) {
        _shoppingOrderService = shoppingOrderService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingOrderService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingOrderService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingOrderService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderService.findByGroupId(groupId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBygroupIdAndUserId(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderService.findBygroupIdAndUserId(groupId, userId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBygroupIdAndEmail(
        long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrderService.findBygroupIdAndEmail(groupId, email);
    }

    @Override
    public double getOrderTotal(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList) {
        return _shoppingOrderService.getOrderTotal(shoppingOrderItemList);
    }

    @Override
    public int getOrderItemsCount(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList) {
        return _shoppingOrderService.getOrderItemsCount(shoppingOrderItemList);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingOrderService getWrappedShoppingOrderService() {
        return _shoppingOrderService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingOrderService(
        ShoppingOrderService shoppingOrderService) {
        _shoppingOrderService = shoppingOrderService;
    }

    @Override
    public ShoppingOrderService getWrappedService() {
        return _shoppingOrderService;
    }

    @Override
    public void setWrappedService(ShoppingOrderService shoppingOrderService) {
        _shoppingOrderService = shoppingOrderService;
    }
}
