package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingStoreServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingStoreServiceClpInvoker {
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;
    private String _methodName86;
    private String[] _methodParameterTypes86;
    private String _methodName87;
    private String[] _methodParameterTypes87;
    private String _methodName88;
    private String[] _methodParameterTypes88;

    public ShoppingStoreServiceClpInvoker() {
        _methodName78 = "getBeanIdentifier";

        _methodParameterTypes78 = new String[] {  };

        _methodName79 = "setBeanIdentifier";

        _methodParameterTypes79 = new String[] { "java.lang.String" };

        _methodName84 = "getSettings";

        _methodParameterTypes84 = new String[] {  };

        _methodName85 = "getShoppingAssetCategories";

        _methodParameterTypes85 = new String[] { "long" };

        _methodName86 = "getShoppingStore";

        _methodParameterTypes86 = new String[] { "long" };

        _methodName87 = "addShoppingStore";

        _methodParameterTypes87 = new String[] {
                "com.fsquare.shopping.model.ShoppingStore"
            };

        _methodName88 = "updateShoppingStore";

        _methodParameterTypes88 = new String[] {
                "com.fsquare.shopping.model.ShoppingStore"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return ShoppingStoreServiceUtil.getBeanIdentifier();
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            ShoppingStoreServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return ShoppingStoreServiceUtil.getSettings();
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return ShoppingStoreServiceUtil.getShoppingAssetCategories(((Long) arguments[0]).longValue());
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            return ShoppingStoreServiceUtil.getShoppingStore(((Long) arguments[0]).longValue());
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            return ShoppingStoreServiceUtil.addShoppingStore((com.fsquare.shopping.model.ShoppingStore) arguments[0]);
        }

        if (_methodName88.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
            return ShoppingStoreServiceUtil.updateShoppingStore((com.fsquare.shopping.model.ShoppingStore) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
