package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.ShoppingItemLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingItemLocalServiceClpInvoker {
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
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName112;
    private String[] _methodParameterTypes112;
    private String _methodName113;
    private String[] _methodParameterTypes113;
    private String _methodName118;
    private String[] _methodParameterTypes118;
    private String _methodName119;
    private String[] _methodParameterTypes119;
    private String _methodName120;
    private String[] _methodParameterTypes120;
    private String _methodName121;
    private String[] _methodParameterTypes121;
    private String _methodName122;
    private String[] _methodParameterTypes122;
    private String _methodName123;
    private String[] _methodParameterTypes123;
    private String _methodName124;
    private String[] _methodParameterTypes124;

    public ShoppingItemLocalServiceClpInvoker() {
        _methodName0 = "addShoppingItem";

        _methodParameterTypes0 = new String[] {
                "com.fsquare.shopping.model.ShoppingItem"
            };

        _methodName1 = "createShoppingItem";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteShoppingItem";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteShoppingItem";

        _methodParameterTypes3 = new String[] {
                "com.fsquare.shopping.model.ShoppingItem"
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

        _methodName10 = "fetchShoppingItem";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "fetchShoppingItemByUuidAndCompanyId";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "fetchShoppingItemByUuidAndGroupId";

        _methodParameterTypes12 = new String[] { "java.lang.String", "long" };

        _methodName13 = "getShoppingItem";

        _methodParameterTypes13 = new String[] { "long" };

        _methodName14 = "getPersistedModel";

        _methodParameterTypes14 = new String[] { "java.io.Serializable" };

        _methodName15 = "getShoppingItemByUuidAndCompanyId";

        _methodParameterTypes15 = new String[] { "java.lang.String", "long" };

        _methodName16 = "getShoppingItemByUuidAndGroupId";

        _methodParameterTypes16 = new String[] { "java.lang.String", "long" };

        _methodName17 = "getShoppingItems";

        _methodParameterTypes17 = new String[] { "int", "int" };

        _methodName18 = "getShoppingItemsCount";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "updateShoppingItem";

        _methodParameterTypes19 = new String[] {
                "com.fsquare.shopping.model.ShoppingItem"
            };

        _methodName112 = "getBeanIdentifier";

        _methodParameterTypes112 = new String[] {  };

        _methodName113 = "setBeanIdentifier";

        _methodParameterTypes113 = new String[] { "java.lang.String" };

        _methodName118 = "findByCompanyId";

        _methodParameterTypes118 = new String[] { "long" };

        _methodName119 = "addShoppingItem";

        _methodParameterTypes119 = new String[] {
                "com.fsquare.shopping.model.ShoppingItem", "long",
                "java.util.List", "com.liferay.portal.service.ServiceContext"
            };

        _methodName120 = "deleteShoppingItem";

        _methodParameterTypes120 = new String[] {
                "com.fsquare.shopping.model.ShoppingItem"
            };

        _methodName121 = "deleteShoppingItem";

        _methodParameterTypes121 = new String[] { "long" };

        _methodName122 = "getItemImages";

        _methodParameterTypes122 = new String[] {
                "com.fsquare.shopping.model.ShoppingItem"
            };

        _methodName123 = "getEntry";

        _methodParameterTypes123 = new String[] { "long" };

        _methodName124 = "availableQuantity";

        _methodParameterTypes124 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.addShoppingItem((com.fsquare.shopping.model.ShoppingItem) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.createShoppingItem(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.deleteShoppingItem(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.deleteShoppingItem((com.fsquare.shopping.model.ShoppingItem) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.fetchShoppingItem(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.fetchShoppingItemByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.fetchShoppingItemByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getShoppingItem(((Long) arguments[0]).longValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getShoppingItemByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getShoppingItemByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getShoppingItems(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getShoppingItemsCount();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.updateShoppingItem((com.fsquare.shopping.model.ShoppingItem) arguments[0]);
        }

        if (_methodName112.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName113.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
            ShoppingItemLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName118.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.findByCompanyId(((Long) arguments[0]).longValue());
        }

        if (_methodName119.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.addShoppingItem((com.fsquare.shopping.model.ShoppingItem) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.util.List<byte[]>) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName120.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.deleteShoppingItem((com.fsquare.shopping.model.ShoppingItem) arguments[0]);
        }

        if (_methodName121.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.deleteShoppingItem(((Long) arguments[0]).longValue());
        }

        if (_methodName122.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getItemImages((com.fsquare.shopping.model.ShoppingItem) arguments[0]);
        }

        if (_methodName123.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.getEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName124.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
            return ShoppingItemLocalServiceUtil.availableQuantity(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
