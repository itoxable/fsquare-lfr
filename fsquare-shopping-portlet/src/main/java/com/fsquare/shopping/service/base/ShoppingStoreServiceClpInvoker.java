package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingStoreServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingStoreServiceClpInvoker {
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;

    public ShoppingStoreServiceClpInvoker() {
        _methodName46 = "getBeanIdentifier";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "setBeanIdentifier";

        _methodParameterTypes47 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return ShoppingStoreServiceUtil.getBeanIdentifier();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            ShoppingStoreServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
