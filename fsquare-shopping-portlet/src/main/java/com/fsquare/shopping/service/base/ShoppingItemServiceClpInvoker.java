package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingItemServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingItemServiceClpInvoker {
    private String _methodName92;
    private String[] _methodParameterTypes92;
    private String _methodName93;
    private String[] _methodParameterTypes93;
    private String _methodName98;
    private String[] _methodParameterTypes98;
    private String _methodName99;
    private String[] _methodParameterTypes99;
    private String _methodName100;
    private String[] _methodParameterTypes100;
    private String _methodName101;
    private String[] _methodParameterTypes101;
    private String _methodName102;
    private String[] _methodParameterTypes102;
    private String _methodName103;
    private String[] _methodParameterTypes103;

    public ShoppingItemServiceClpInvoker() {
        _methodName92 = "getBeanIdentifier";

        _methodParameterTypes92 = new String[] {  };

        _methodName93 = "setBeanIdentifier";

        _methodParameterTypes93 = new String[] { "java.lang.String" };

        _methodName98 = "fixDeletedItem";

        _methodParameterTypes98 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName99 = "getCompleteByGroupId";

        _methodParameterTypes99 = new String[] { "long" };

        _methodName100 = "findByGroupId";

        _methodParameterTypes100 = new String[] { "long" };

        _methodName101 = "findByGroupId";

        _methodParameterTypes101 = new String[] { "java.lang.Long" };

        _methodName102 = "getPagedItems";

        _methodParameterTypes102 = new String[] { "java.lang.Long", "int", "int" };

        _methodName103 = "countByGroupId";

        _methodParameterTypes103 = new String[] { "java.lang.Long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            return ShoppingItemServiceUtil.getBeanIdentifier();
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            ShoppingItemServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName98.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
            return ShoppingItemServiceUtil.fixDeletedItem(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName99.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
            return ShoppingItemServiceUtil.getCompleteByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return ShoppingItemServiceUtil.findByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            return ShoppingItemServiceUtil.findByGroupId((java.lang.Long) arguments[0]);
        }

        if (_methodName102.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
            return ShoppingItemServiceUtil.getPagedItems((java.lang.Long) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName103.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
            return ShoppingItemServiceUtil.countByGroupId((java.lang.Long) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
