package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.SiteCommonActionsServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteCommonActionsServiceClpInvoker {
    private String _methodName116;
    private String[] _methodParameterTypes116;
    private String _methodName117;
    private String[] _methodParameterTypes117;
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
    private String _methodName125;
    private String[] _methodParameterTypes125;
    private String _methodName127;
    private String[] _methodParameterTypes127;
    private String _methodName128;
    private String[] _methodParameterTypes128;
    private String _methodName129;
    private String[] _methodParameterTypes129;
    private String _methodName130;
    private String[] _methodParameterTypes130;
    private String _methodName131;
    private String[] _methodParameterTypes131;

    public SiteCommonActionsServiceClpInvoker() {
        _methodName116 = "getBeanIdentifier";

        _methodParameterTypes116 = new String[] {  };

        _methodName117 = "setBeanIdentifier";

        _methodParameterTypes117 = new String[] { "java.lang.String" };

        _methodName120 = "updateLayout";

        _methodParameterTypes120 = new String[] {
                "long", "boolean", "long", "long", "java.util.Map",
                "java.util.Map", "java.util.Map", "java.util.Map",
                "java.util.Map", "java.lang.String", "boolean", "java.util.Map",
                "java.lang.Boolean", "byte[][]",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName121 = "updateGroup";

        _methodParameterTypes121 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "int",
                "boolean", "int", "java.lang.String", "boolean",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName122 = "updatePassword";

        _methodParameterTypes122 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName123 = "getUserPortraitUrl";

        _methodParameterTypes123 = new String[] { "boolean", "long" };

        _methodName124 = "getAccountsPaged";

        _methodParameterTypes124 = new String[] { "int", "int" };

        _methodName125 = "getAccounts";

        _methodParameterTypes125 = new String[] {  };

        _methodName127 = "getAccount";

        _methodParameterTypes127 = new String[] { "long" };

        _methodName128 = "getCompanies";

        _methodParameterTypes128 = new String[] {  };

        _methodName129 = "testFileUpload";

        _methodParameterTypes129 = new String[] { "java.io.File" };

        _methodName130 = "testFilesUpload";

        _methodParameterTypes130 = new String[] { "java.util.List" };

        _methodName131 = "testFilesUploadArr";

        _methodParameterTypes131 = new String[] { "java.io.File[][]" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName116.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getBeanIdentifier();
        }

        if (_methodName117.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
            SiteCommonActionsServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName120.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
            return SiteCommonActionsServiceUtil.updateLayout(((Long) arguments[0]).longValue(),
                ((Boolean) arguments[1]).booleanValue(),
                ((Long) arguments[2]).longValue(),
                ((Long) arguments[3]).longValue(),
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[4],
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[5],
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[6],
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[7],
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[8],
                (java.lang.String) arguments[9],
                ((Boolean) arguments[10]).booleanValue(),
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[11],
                (java.lang.Boolean) arguments[12], (byte[]) arguments[13],
                (com.liferay.portal.service.ServiceContext) arguments[14]);
        }

        if (_methodName121.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
            return SiteCommonActionsServiceUtil.updateGroup(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Integer) arguments[4]).intValue(),
                ((Boolean) arguments[5]).booleanValue(),
                ((Integer) arguments[6]).intValue(),
                (java.lang.String) arguments[7],
                ((Boolean) arguments[8]).booleanValue(),
                (com.liferay.portal.service.ServiceContext) arguments[9]);
        }

        if (_methodName122.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
            return SiteCommonActionsServiceUtil.updatePassword(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName123.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getUserPortraitUrl(((Boolean) arguments[0]).booleanValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName124.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getAccountsPaged(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName125.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getAccounts();
        }

        if (_methodName127.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getAccount(((Long) arguments[0]).longValue());
        }

        if (_methodName128.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getCompanies();
        }

        if (_methodName129.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
            SiteCommonActionsServiceUtil.testFileUpload((java.io.File) arguments[0]);

            return null;
        }

        if (_methodName130.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
            SiteCommonActionsServiceUtil.testFilesUpload((java.util.List<java.io.File>) arguments[0]);

            return null;
        }

        if (_methodName131.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
            SiteCommonActionsServiceUtil.testFilesUploadArr((java.io.File[]) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
