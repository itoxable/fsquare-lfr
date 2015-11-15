package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingOrderItemServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingOrderItemServiceClpInvoker {
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;

    public ShoppingOrderItemServiceClpInvoker() {
        _methodName52 = "getBeanIdentifier";

        _methodParameterTypes52 = new String[] {  };

        _methodName53 = "setBeanIdentifier";

        _methodParameterTypes53 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return ShoppingOrderItemServiceUtil.getBeanIdentifier();
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            ShoppingOrderItemServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
