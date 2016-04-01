package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingCouponServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingCouponServiceClpInvoker {
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
    private String _methodName89;
    private String[] _methodParameterTypes89;
    private String _methodName90;
    private String[] _methodParameterTypes90;
    private String _methodName91;
    private String[] _methodParameterTypes91;
    private String _methodName92;
    private String[] _methodParameterTypes92;
    private String _methodName93;
    private String[] _methodParameterTypes93;
    private String _methodName94;
    private String[] _methodParameterTypes94;

    public ShoppingCouponServiceClpInvoker() {
        _methodName78 = "getBeanIdentifier";

        _methodParameterTypes78 = new String[] {  };

        _methodName79 = "setBeanIdentifier";

        _methodParameterTypes79 = new String[] { "java.lang.String" };

        _methodName84 = "testMap";

        _methodParameterTypes84 = new String[] { "java.util.Map" };

        _methodName85 = "fetchByCodeAndGroupId";

        _methodParameterTypes85 = new String[] { "java.lang.String", "long" };

        _methodName86 = "findByGroupId";

        _methodParameterTypes86 = new String[] { "java.lang.Long" };

        _methodName87 = "isCouponValid";

        _methodParameterTypes87 = new String[] {
                "com.fsquare.shopping.model.ShoppingCoupon"
            };

        _methodName88 = "getCouponStatus";

        _methodParameterTypes88 = new String[] {
                "com.fsquare.shopping.model.ShoppingCoupon"
            };

        _methodName89 = "findByGroupIdStartEnd";

        _methodParameterTypes89 = new String[] { "java.lang.Long", "int", "int" };

        _methodName90 = "countByGroupId";

        _methodParameterTypes90 = new String[] { "java.lang.Long" };

        _methodName91 = "getPagedItems";

        _methodParameterTypes91 = new String[] { "java.lang.Long", "int", "int" };

        _methodName92 = "updateShoppingCoupon";

        _methodParameterTypes92 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.util.Date", "java.util.Date",
                "boolean", "java.lang.String", "java.lang.String", "double",
                "double", "java.lang.String", "long", "long", "long"
            };

        _methodName93 = "deleteCoupon";

        _methodParameterTypes93 = new String[] { "long" };

        _methodName94 = "updateShoppingCoupon";

        _methodParameterTypes94 = new String[] {
                "com.fsquare.shopping.model.ShoppingCoupon"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return ShoppingCouponServiceUtil.getBeanIdentifier();
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            ShoppingCouponServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return ShoppingCouponServiceUtil.testMap((java.util.Map<java.util.Locale, java.lang.String>) arguments[0]);
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return ShoppingCouponServiceUtil.fetchByCodeAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            return ShoppingCouponServiceUtil.findByGroupId((java.lang.Long) arguments[0]);
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            return ShoppingCouponServiceUtil.isCouponValid((com.fsquare.shopping.model.ShoppingCoupon) arguments[0]);
        }

        if (_methodName88.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
            return ShoppingCouponServiceUtil.getCouponStatus((com.fsquare.shopping.model.ShoppingCoupon) arguments[0]);
        }

        if (_methodName89.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
            return ShoppingCouponServiceUtil.findByGroupIdStartEnd((java.lang.Long) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName90.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
            return ShoppingCouponServiceUtil.countByGroupId((java.lang.Long) arguments[0]);
        }

        if (_methodName91.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
            return ShoppingCouponServiceUtil.getPagedItems((java.lang.Long) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            ShoppingCouponServiceUtil.updateShoppingCoupon(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.util.Date) arguments[5],
                (java.util.Date) arguments[6],
                ((Boolean) arguments[7]).booleanValue(),
                (java.lang.String) arguments[8],
                (java.lang.String) arguments[9],
                ((Double) arguments[10]).doubleValue(),
                ((Double) arguments[11]).doubleValue(),
                (java.lang.String) arguments[12],
                ((Long) arguments[13]).longValue(),
                ((Long) arguments[14]).longValue(),
                ((Long) arguments[15]).longValue());

            return null;
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            return ShoppingCouponServiceUtil.deleteCoupon(((Long) arguments[0]).longValue());
        }

        if (_methodName94.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
            return ShoppingCouponServiceUtil.updateShoppingCoupon((com.fsquare.shopping.model.ShoppingCoupon) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
