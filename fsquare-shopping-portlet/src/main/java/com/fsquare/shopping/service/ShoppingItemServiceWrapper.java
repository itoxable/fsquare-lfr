package com.fsquare.shopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemService
 * @generated
 */
public class ShoppingItemServiceWrapper implements ShoppingItemService,
    ServiceWrapper<ShoppingItemService> {
    private ShoppingItemService _shoppingItemService;

    public ShoppingItemServiceWrapper(ShoppingItemService shoppingItemService) {
        _shoppingItemService = shoppingItemService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _shoppingItemService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _shoppingItemService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _shoppingItemService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public boolean fixDeletedItem(long itemId, long companyId,
        java.lang.String uid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemService.fixDeletedItem(itemId, companyId, uid);
    }

    @Override
    public java.lang.Object getCompleteByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemService.getCompleteByGroupId(groupId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemService.findByGroupId(groupId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByGroupId(
        java.lang.Long groupId) {
        return _shoppingItemService.findByGroupId(groupId);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> getPagedItems(
        java.lang.Long groupId, int start, int end) {
        return _shoppingItemService.getPagedItems(groupId, start, end);
    }

    @Override
    public int countByGroupId(java.lang.Long groupId) {
        return _shoppingItemService.countByGroupId(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ShoppingItemService getWrappedShoppingItemService() {
        return _shoppingItemService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedShoppingItemService(
        ShoppingItemService shoppingItemService) {
        _shoppingItemService = shoppingItemService;
    }

    @Override
    public ShoppingItemService getWrappedService() {
        return _shoppingItemService;
    }

    @Override
    public void setWrappedService(ShoppingItemService shoppingItemService) {
        _shoppingItemService = shoppingItemService;
    }
}
