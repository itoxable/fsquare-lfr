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
    public java.lang.Object getCompleteByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemService.getCompleteByCompanyId(companyId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemService.findByCompanyId(companyId);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingItem> findByCompanyId(
        java.lang.Long companyId) {
        return _shoppingItemService.findByCompanyId(companyId);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> getPagedItems(
        java.lang.Long companyId, int start, int end) {
        return _shoppingItemService.getPagedItems(companyId, start, end);
    }

    @Override
    public int countByCompanyId(java.lang.Long companyId) {
        return _shoppingItemService.countByCompanyId(companyId);
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
