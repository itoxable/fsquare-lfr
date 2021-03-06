package com.fsquare.shopping.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for ShoppingOrder. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderServiceUtil
 * @see com.fsquare.shopping.service.base.ShoppingOrderServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingOrderServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ShoppingOrderService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingOrderServiceUtil} to access the shopping order remote service. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingOrderServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findByCompanyIdAndUserId(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.fsquare.shopping.model.ShoppingOrder> findBygroupIdAndEmail(
        long companyId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public double getOrderTotal(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getOrderItemsCount(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList);
}
