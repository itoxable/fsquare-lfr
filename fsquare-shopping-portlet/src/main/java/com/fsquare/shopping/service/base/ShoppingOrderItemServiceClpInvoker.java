package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingOrderItemServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingOrderItemServiceClpInvoker {
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;

    public ShoppingOrderItemServiceClpInvoker() {
        _methodName80 = "getBeanIdentifier";

        _methodParameterTypes80 = new String[] {  };

        _methodName81 = "setBeanIdentifier";

        _methodParameterTypes81 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return ShoppingOrderItemServiceUtil.getBeanIdentifier();
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            ShoppingOrderItemServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
