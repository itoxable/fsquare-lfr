package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingOrderServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingOrderServiceClpInvoker {
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

    public ShoppingOrderServiceClpInvoker() {
        _methodName78 = "getBeanIdentifier";

        _methodParameterTypes78 = new String[] {  };

        _methodName79 = "setBeanIdentifier";

        _methodParameterTypes79 = new String[] { "java.lang.String" };

        _methodName84 = "findByCompanyId";

        _methodParameterTypes84 = new String[] { "long" };

        _methodName85 = "findByCompanyIdAndUserId";

        _methodParameterTypes85 = new String[] { "long", "long" };

        _methodName86 = "findBygroupIdAndEmail";

        _methodParameterTypes86 = new String[] { "long", "java.lang.String" };

        _methodName87 = "getOrderTotal";

        _methodParameterTypes87 = new String[] { "java.util.Collection" };

        _methodName88 = "getOrderItemsCount";

        _methodParameterTypes88 = new String[] { "java.util.Collection" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return ShoppingOrderServiceUtil.getBeanIdentifier();
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            ShoppingOrderServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return ShoppingOrderServiceUtil.findByCompanyId(((Long) arguments[0]).longValue());
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return ShoppingOrderServiceUtil.findByCompanyIdAndUserId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            return ShoppingOrderServiceUtil.findBygroupIdAndEmail(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            return ShoppingOrderServiceUtil.getOrderTotal((java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem>) arguments[0]);
        }

        if (_methodName88.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
            return ShoppingOrderServiceUtil.getOrderItemsCount((java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem>) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
