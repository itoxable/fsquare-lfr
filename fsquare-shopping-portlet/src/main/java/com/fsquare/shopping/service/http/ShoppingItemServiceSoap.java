package com.fsquare.shopping.service.http;

import com.fsquare.shopping.service.ShoppingItemServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.fsquare.shopping.service.ShoppingItemServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.fsquare.shopping.model.ShoppingItemSoap}.
 * If the method in the service utility returns a
 * {@link com.fsquare.shopping.model.ShoppingItem}, that is translated to a
 * {@link com.fsquare.shopping.model.ShoppingItemSoap}. Methods that SOAP cannot
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
 * @see ShoppingItemServiceHttp
 * @see com.fsquare.shopping.model.ShoppingItemSoap
 * @see com.fsquare.shopping.service.ShoppingItemServiceUtil
 * @generated
 */
public class ShoppingItemServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ShoppingItemServiceSoap.class);

    public static boolean fixDeletedItem(long itemId, long companyId,
        java.lang.String uid) throws RemoteException {
        try {
            boolean returnValue = ShoppingItemServiceUtil.fixDeletedItem(itemId,
                    companyId, uid);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.Object getCompleteByGroupId(long groupId)
        throws RemoteException {
        try {
            java.lang.Object returnValue = ShoppingItemServiceUtil.getCompleteByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingItemSoap[] findByGroupId(
        long groupId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingItem> returnValue = ShoppingItemServiceUtil.findByGroupId(groupId);

            return com.fsquare.shopping.model.ShoppingItemSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingItemSoap[] findByGroupId(
        java.lang.Long groupId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingItem> returnValue = ShoppingItemServiceUtil.findByGroupId(groupId);

            return com.fsquare.shopping.model.ShoppingItemSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countByGroupId(java.lang.Long groupId)
        throws RemoteException {
        try {
            int returnValue = ShoppingItemServiceUtil.countByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
