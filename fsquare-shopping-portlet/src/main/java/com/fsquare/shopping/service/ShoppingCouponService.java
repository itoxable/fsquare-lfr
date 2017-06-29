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
 * Provides the remote service interface for ShoppingCoupon. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponServiceUtil
 * @see com.fsquare.shopping.service.base.ShoppingCouponServiceBaseImpl
 * @see com.fsquare.shopping.service.impl.ShoppingCouponServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ShoppingCouponService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ShoppingCouponServiceUtil} to access the shopping coupon remote service. Add custom service methods to {@link com.fsquare.shopping.service.impl.ShoppingCouponServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

    public java.util.Map<java.util.Locale, java.lang.String> testMap(
        java.util.Map<java.util.Locale, java.lang.String> map);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndCompanyId(
        java.lang.String code, long companyId);

    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        java.lang.Long companyId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean isCouponValid(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getCouponStatus(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon);

    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyIdStartEnd(
        java.lang.Long companyId, int start, int end);

    public int countByCompanyId(java.lang.Long companyId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> getPagedItems(
        java.lang.Long companyId, int start, int end);

    public void updateShoppingCoupon(long couponId, long companyId,
        java.lang.String code, java.lang.String name,
        java.lang.String description, java.util.Date startDate,
        java.util.Date endDate, boolean active,
        java.lang.String limitCategories, java.lang.String limitSkus,
        double minOrder, double discount, java.lang.String discountType,
        long maxUses, long userid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingCoupon deleteCoupon(long couponId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.fsquare.shopping.model.ShoppingCoupon updateShoppingCoupon(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
