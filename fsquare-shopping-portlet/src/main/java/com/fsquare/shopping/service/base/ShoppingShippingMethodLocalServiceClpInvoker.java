package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingShippingMethodLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName90;
    private String[] _methodParameterTypes90;
    private String _methodName91;
    private String[] _methodParameterTypes91;
    private String _methodName96;
    private String[] _methodParameterTypes96;
    private String _methodName97;
    private String[] _methodParameterTypes97;
    private String _methodName98;
    private String[] _methodParameterTypes98;
    private String _methodName99;
    private String[] _methodParameterTypes99;

    public ShoppingShippingMethodLocalServiceClpInvoker() {
        _methodName0 = "addShoppingShippingMethod";

        _methodParameterTypes0 = new String[] {
                "com.fsquare.shopping.model.ShoppingShippingMethod"
            };

        _methodName1 = "createShoppingShippingMethod";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteShoppingShippingMethod";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteShoppingShippingMethod";

        _methodParameterTypes3 = new String[] {
                "com.fsquare.shopping.model.ShoppingShippingMethod"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchShoppingShippingMethod";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getShoppingShippingMethod";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getShoppingShippingMethods";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getShoppingShippingMethodsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateShoppingShippingMethod";

        _methodParameterTypes15 = new String[] {
                "com.fsquare.shopping.model.ShoppingShippingMethod"
            };

        _methodName90 = "getBeanIdentifier";

        _methodParameterTypes90 = new String[] {  };

        _methodName91 = "setBeanIdentifier";

        _methodParameterTypes91 = new String[] { "java.lang.String" };

        _methodName96 = "getShippingPrice";

        _methodParameterTypes96 = new String[] {
                "com.fsquare.shopping.model.ShoppingShippingMethod",
                "java.util.Collection", "double"
            };

        _methodName97 = "fetchDefaultShipping";

        _methodParameterTypes97 = new String[] {  };

        _methodName98 = "findByGroupId";

        _methodParameterTypes98 = new String[] { "long" };

        _methodName99 = "findByGroupIdAndEnabled";

        _methodParameterTypes99 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.addShoppingShippingMethod((com.fsquare.shopping.model.ShoppingShippingMethod) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.createShoppingShippingMethod(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.deleteShoppingShippingMethod(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.deleteShoppingShippingMethod((com.fsquare.shopping.model.ShoppingShippingMethod) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.fetchShoppingShippingMethod(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethods(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethodsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.updateShoppingShippingMethod((com.fsquare.shopping.model.ShoppingShippingMethod) arguments[0]);
        }

        if (_methodName90.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName91.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
            ShoppingShippingMethodLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName96.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.getShippingPrice((com.fsquare.shopping.model.ShoppingShippingMethod) arguments[0],
                (java.util.Collection<com.fsquare.shopping.model.ShoppingOrderItem>) arguments[1],
                ((Double) arguments[2]).doubleValue());
        }

        if (_methodName97.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.fetchDefaultShipping();
        }

        if (_methodName98.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.findByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName99.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
            return ShoppingShippingMethodLocalServiceUtil.findByGroupIdAndEnabled(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
