package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingCouponServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingCouponServiceClpInvoker {
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;

    public ShoppingCouponServiceClpInvoker() {
        _methodName46 = "getBeanIdentifier";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "setBeanIdentifier";

        _methodParameterTypes47 = new String[] { "java.lang.String" };

        _methodName52 = "fetchByCode";

        _methodParameterTypes52 = new String[] { "java.lang.String" };

        _methodName53 = "findByGroupId";

        _methodParameterTypes53 = new String[] { "java.lang.Long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return ShoppingCouponServiceUtil.getBeanIdentifier();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            ShoppingCouponServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return ShoppingCouponServiceUtil.fetchByCode((java.lang.String) arguments[0]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return ShoppingCouponServiceUtil.findByGroupId((java.lang.Long) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
