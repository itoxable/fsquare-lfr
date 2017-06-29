package com.fsquare.shopping.service.http;

import com.fsquare.shopping.service.ShoppingStoreServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.fsquare.shopping.service.ShoppingStoreServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.fsquare.shopping.model.ShoppingStoreSoap}.
 * If the method in the service utility returns a
 * {@link com.fsquare.shopping.model.ShoppingStore}, that is translated to a
 * {@link com.fsquare.shopping.model.ShoppingStoreSoap}. Methods that SOAP cannot
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
 * @see ShoppingStoreServiceHttp
 * @see com.fsquare.shopping.model.ShoppingStoreSoap
 * @see com.fsquare.shopping.service.ShoppingStoreServiceUtil
 * @generated
 */
public class ShoppingStoreServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ShoppingStoreServiceSoap.class);

    public static com.liferay.portlet.asset.model.AssetCategorySoap[] getShoppingAssetCategories(
        long companyId) throws RemoteException {
        try {
            java.util.List<com.liferay.portlet.asset.model.AssetCategory> returnValue =
                ShoppingStoreServiceUtil.getShoppingAssetCategories(companyId);

            return com.liferay.portlet.asset.model.AssetCategorySoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingStoreSoap getShoppingStore(
        long companyId) throws RemoteException {
        try {
            com.fsquare.shopping.model.ShoppingStore returnValue = ShoppingStoreServiceUtil.getShoppingStore(companyId);

            return com.fsquare.shopping.model.ShoppingStoreSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingStoreSoap addShoppingStore(
        com.fsquare.shopping.model.ShoppingStoreSoap shoppingStore)
        throws RemoteException {
        try {
            com.fsquare.shopping.model.ShoppingStore returnValue = ShoppingStoreServiceUtil.addShoppingStore(com.fsquare.shopping.model.impl.ShoppingStoreModelImpl.toModel(
                        shoppingStore));

            return com.fsquare.shopping.model.ShoppingStoreSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.fsquare.shopping.model.ShoppingStoreSoap updateShoppingStore(
        com.fsquare.shopping.model.ShoppingStoreSoap shoppingStore)
        throws RemoteException {
        try {
            com.fsquare.shopping.model.ShoppingStore returnValue = ShoppingStoreServiceUtil.updateShoppingStore(com.fsquare.shopping.model.impl.ShoppingStoreModelImpl.toModel(
                        shoppingStore));

            return com.fsquare.shopping.model.ShoppingStoreSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
