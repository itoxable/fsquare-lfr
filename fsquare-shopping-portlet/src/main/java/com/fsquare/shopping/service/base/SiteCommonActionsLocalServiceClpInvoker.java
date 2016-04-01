package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.SiteCommonActionsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteCommonActionsLocalServiceClpInvoker {
    private String _methodName116;
    private String[] _methodParameterTypes116;
    private String _methodName117;
    private String[] _methodParameterTypes117;
    private String _methodName120;
    private String[] _methodParameterTypes120;
    private String _methodName121;
    private String[] _methodParameterTypes121;

    public SiteCommonActionsLocalServiceClpInvoker() {
        _methodName116 = "getBeanIdentifier";

        _methodParameterTypes116 = new String[] {  };

        _methodName117 = "setBeanIdentifier";

        _methodParameterTypes117 = new String[] { "java.lang.String" };

        _methodName120 = "updatePassword";

        _methodParameterTypes120 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName121 = "getUserPortraitUrl";

        _methodParameterTypes121 = new String[] { "boolean", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName116.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
            return SiteCommonActionsLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName117.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
            SiteCommonActionsLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName120.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
            return SiteCommonActionsLocalServiceUtil.updatePassword(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName121.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
            return SiteCommonActionsLocalServiceUtil.getUserPortraitUrl(((Boolean) arguments[0]).booleanValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
