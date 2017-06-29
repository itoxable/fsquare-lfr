package com.fsquare.shopping.service.http;

import com.fsquare.shopping.service.ShoppingItemStorageLocationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.fsquare.shopping.service.ShoppingItemStorageLocationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.fsquare.shopping.model.ShoppingItemStorageLocationSoap}.
 * If the method in the service utility returns a
 * {@link com.fsquare.shopping.model.ShoppingItemStorageLocation}, that is translated to a
 * {@link com.fsquare.shopping.model.ShoppingItemStorageLocationSoap}. Methods that SOAP cannot
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
 * @see ShoppingItemStorageLocationServiceHttp
 * @see com.fsquare.shopping.model.ShoppingItemStorageLocationSoap
 * @see com.fsquare.shopping.service.ShoppingItemStorageLocationServiceUtil
 * @generated
 */
public class ShoppingItemStorageLocationServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ShoppingItemStorageLocationServiceSoap.class);

    public static com.fsquare.shopping.model.ShoppingItemStorageLocationSoap findByItemIdAndStorageLocationId(
        long itemId, long storageLocationId) throws RemoteException {
        try {
            com.fsquare.shopping.model.ShoppingItemStorageLocation returnValue = ShoppingItemStorageLocationServiceUtil.findByItemIdAndStorageLocationId(itemId,
                    storageLocationId);

            return com.fsquare.shopping.model.ShoppingItemStorageLocationSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingItemStorageLocationSoap[] findByItemId(
        long itemId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> returnValue =
                ShoppingItemStorageLocationServiceUtil.findByItemId(itemId);

            return com.fsquare.shopping.model.ShoppingItemStorageLocationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingItemStorageLocationSoap[] findByStorageLocationId(
        long storageLocationId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> returnValue =
                ShoppingItemStorageLocationServiceUtil.findByStorageLocationId(storageLocationId);

            return com.fsquare.shopping.model.ShoppingItemStorageLocationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingItemStorageLocationSoap[] findByCompanyId(
        long companyId) throws RemoteException {
        try {
            java.util.List<com.fsquare.shopping.model.ShoppingItemStorageLocation> returnValue =
                ShoppingItemStorageLocationServiceUtil.findByCompanyId(companyId);

            return com.fsquare.shopping.model.ShoppingItemStorageLocationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
