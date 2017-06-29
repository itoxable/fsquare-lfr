package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.SiteCommonActionsServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteCommonActionsServiceClpInvoker {
    private String _methodName100;
    private String[] _methodParameterTypes100;
    private String _methodName101;
    private String[] _methodParameterTypes101;
    private String _methodName104;
    private String[] _methodParameterTypes104;
    private String _methodName105;
    private String[] _methodParameterTypes105;
    private String _methodName106;
    private String[] _methodParameterTypes106;
    private String _methodName107;
    private String[] _methodParameterTypes107;
    private String _methodName108;
    private String[] _methodParameterTypes108;
    private String _methodName109;
    private String[] _methodParameterTypes109;
    private String _methodName111;
    private String[] _methodParameterTypes111;
    private String _methodName112;
    private String[] _methodParameterTypes112;
    private String _methodName113;
    private String[] _methodParameterTypes113;
    private String _methodName114;
    private String[] _methodParameterTypes114;
    private String _methodName115;
    private String[] _methodParameterTypes115;

    public SiteCommonActionsServiceClpInvoker() {
        _methodName100 = "getBeanIdentifier";

        _methodParameterTypes100 = new String[] {  };

        _methodName101 = "setBeanIdentifier";

        _methodParameterTypes101 = new String[] { "java.lang.String" };

        _methodName104 = "updateLayout";

        _methodParameterTypes104 = new String[] {
                "long", "boolean", "long", "long", "java.util.Map",
                "java.util.Map", "java.util.Map", "java.util.Map",
                "java.util.Map", "java.lang.String", "boolean", "java.util.Map",
                "java.lang.Boolean", "byte[][]",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName105 = "updateGroup";

        _methodParameterTypes105 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "int",
                "boolean", "int", "java.lang.String", "boolean",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName106 = "updatePassword";

        _methodParameterTypes106 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName107 = "getUserPortraitUrl";

        _methodParameterTypes107 = new String[] { "boolean", "long" };

        _methodName108 = "getAccountsPaged";

        _methodParameterTypes108 = new String[] { "int", "int" };

        _methodName109 = "getAccounts";

        _methodParameterTypes109 = new String[] {  };

        _methodName111 = "getAccount";

        _methodParameterTypes111 = new String[] { "long" };

        _methodName112 = "getCompanies";

        _methodParameterTypes112 = new String[] {  };

        _methodName113 = "testFileUpload";

        _methodParameterTypes113 = new String[] { "java.io.File" };

        _methodName114 = "testFilesUpload";

        _methodParameterTypes114 = new String[] { "java.util.List" };

        _methodName115 = "testFilesUploadArr";

        _methodParameterTypes115 = new String[] { "java.io.File[][]" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getBeanIdentifier();
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            SiteCommonActionsServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName104.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
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

        if (_methodName105.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
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

        if (_methodName106.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
            return SiteCommonActionsServiceUtil.updatePassword(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName107.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getUserPortraitUrl(((Boolean) arguments[0]).booleanValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName108.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getAccountsPaged(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName109.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getAccounts();
        }

        if (_methodName111.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getAccount(((Long) arguments[0]).longValue());
        }

        if (_methodName112.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
            return SiteCommonActionsServiceUtil.getCompanies();
        }

        if (_methodName113.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
            SiteCommonActionsServiceUtil.testFileUpload((java.io.File) arguments[0]);

            return null;
        }

        if (_methodName114.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
            SiteCommonActionsServiceUtil.testFilesUpload((java.util.List<java.io.File>) arguments[0]);

            return null;
        }

        if (_methodName115.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
            SiteCommonActionsServiceUtil.testFilesUploadArr((java.io.File[]) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
