package com.fsquare.shopping.service.http;

import com.fsquare.shopping.service.ShoppingOrderServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.fsquare.shopping.service.ShoppingOrderServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.fsquare.shopping.model.ShoppingOrderSoap}.
 * If the method in the service utility returns a
 * {@link com.fsquare.shopping.model.ShoppingOrder}, that is translated to a
 * {@link com.fsquare.shopping.model.ShoppingOrderSoap}. Methods that SOAP cannot
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
 * @see ShoppingOrderServiceHttp
 * @see com.fsquare.shopping.model.ShoppingOrderSoap
 * @see com.fsquare.shopping.service.ShoppingOrderServiceUtil
 * @generated
 */
public class ShoppingOrderServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ShoppingOrderServiceSoap.class);

    public static com.fsquare.shopping.model.ShoppingOrderSoap[] findByCompanyId(
        long companyId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingOrder> returnValue =
                ShoppingOrderServiceUtil.findByCompanyId(companyId);

            return com.fsquare.shopping.model.ShoppingOrderSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingOrderSoap[] findByCompanyIdAndUserId(
        long companyId, long userId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingOrder> returnValue =
                ShoppingOrderServiceUtil.findByCompanyIdAndUserId(companyId,
                    userId);

            return com.fsquare.shopping.model.ShoppingOrderSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingOrderSoap[] findBygroupIdAndEmail(
        long companyId, java.lang.String email) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingOrder> returnValue =
                ShoppingOrderServiceUtil.findBygroupIdAndEmail(companyId, email);

            return com.fsquare.shopping.model.ShoppingOrderSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static double getOrderTotal(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList)
        throws RemoteException {
        try {
            double returnValue = ShoppingOrderServiceUtil.getOrderTotal(shoppingOrderItemList);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getOrderItemsCount(
        java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem> shoppingOrderItemList)
        throws RemoteException {
        try {
            int returnValue = ShoppingOrderServiceUtil.getOrderItemsCount(shoppingOrderItemList);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
