package com.fsquare.shopping.service.http;

import com.fsquare.shopping.service.ShoppingCouponServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.fsquare.shopping.service.ShoppingCouponServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.fsquare.shopping.model.ShoppingCouponSoap}.
 * If the method in the service utility returns a
 * {@link com.fsquare.shopping.model.ShoppingCoupon}, that is translated to a
 * {@link com.fsquare.shopping.model.ShoppingCouponSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponServiceHttp
 * @see com.fsquare.shopping.model.ShoppingCouponSoap
 * @see com.fsquare.shopping.service.ShoppingCouponServiceUtil
 * @generated
 */
public class ShoppingCouponServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ShoppingCouponServiceSoap.class);

    public static com.fsquare.shopping.model.ShoppingCouponSoap fetchByCodeAndGroupId(
        java.lang.String code, long groupId) throws RemoteException {
        try {
            com.fsquare.shopping.model.ShoppingCoupon returnValue = ShoppingCouponServiceUtil.fetchByCodeAndGroupId(code,
                    groupId);

            return com.fsquare.shopping.model.ShoppingCouponSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingCouponSoap[] findByGroupId(
        java.lang.Long groupId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingCoupon> returnValue =
                ShoppingCouponServiceUtil.findByGroupId(groupId);

            return com.fsquare.shopping.model.ShoppingCouponSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static boolean isCouponValid(
        com.fsquare.shopping.model.ShoppingCouponSoap shoppingCoupon)
        throws RemoteException {
        try {
            boolean returnValue = ShoppingCouponServiceUtil.isCouponValid(com.fsquare.shopping.model.impl.ShoppingCouponModelImpl.toModel(
                        shoppingCoupon));

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getCouponStatus(
        com.fsquare.shopping.model.ShoppingCouponSoap shoppingCoupon)
        throws RemoteException {
        try {
            java.lang.String returnValue = ShoppingCouponServiceUtil.getCouponStatus(com.fsquare.shopping.model.impl.ShoppingCouponModelImpl.toModel(
                        shoppingCoupon));

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingCouponSoap[] findByGroupIdStartEnd(
        java.lang.Long groupId, int start, int end) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingCoupon> returnValue =
                ShoppingCouponServiceUtil.findByGroupIdStartEnd(groupId, start,
                    end);

            return com.fsquare.shopping.model.ShoppingCouponSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countByGroupId(java.lang.Long groupId)
        throws RemoteException {
        try {
            int returnValue = ShoppingCouponServiceUtil.countByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void updateShoppingCoupon(long couponId, long groupId,
        java.lang.String code, java.lang.String name,
        java.lang.String description, java.util.Date startDate,
        java.util.Date endDate, boolean active,
        java.lang.String limitCategories, java.lang.String limitSkus,
        double minOrder, double discount, java.lang.String discountType,
        long maxUses, long userid, long companyId) throws RemoteException {
        try {
            ShoppingCouponServiceUtil.updateShoppingCoupon(couponId, groupId,
                code, name, description, startDate, endDate, active,
                limitCategories, limitSkus, minOrder, discount, discountType,
                maxUses, userid, companyId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingCouponSoap deleteCoupon(
        long couponId) throws RemoteException {
        try {
            com.fsquare.shopping.model.ShoppingCoupon returnValue = ShoppingCouponServiceUtil.deleteCoupon(couponId);

            return com.fsquare.shopping.model.ShoppingCouponSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingCouponSoap updateShoppingCoupon(
        com.fsquare.shopping.model.ShoppingCouponSoap shoppingCoupon)
        throws RemoteException {
        try {
            com.fsquare.shopping.model.ShoppingCoupon returnValue = ShoppingCouponServiceUtil.updateShoppingCoupon(com.fsquare.shopping.model.impl.ShoppingCouponModelImpl.toModel(
                        shoppingCoupon));

            return com.fsquare.shopping.model.ShoppingCouponSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
