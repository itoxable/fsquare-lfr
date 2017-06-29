package com.fsquare.shopping.service.base;

import com.fsquare.shopping.service.SiteCommonActionsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteCommonActionsLocalServiceClpInvoker {
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

    public SiteCommonActionsLocalServiceClpInvoker() {
        _methodName100 = "getBeanIdentifier";

        _methodParameterTypes100 = new String[] {  };

        _methodName101 = "setBeanIdentifier";

        _methodParameterTypes101 = new String[] { "java.lang.String" };

        _methodName104 = "updatePassword";

        _methodParameterTypes104 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName105 = "getUserPortraitUrl";

        _methodParameterTypes105 = new String[] { "boolean", "long" };

        _methodName106 = "getCompanies";

        _methodParameterTypes106 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return SiteCommonActionsLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            SiteCommonActionsLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName104.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
            return SiteCommonActionsLocalServiceUtil.updatePassword(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName105.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
            return SiteCommonActionsLocalServiceUtil.getUserPortraitUrl(((Boolean) arguments[0]).booleanValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName106.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
            return SiteCommonActionsLocalServiceUtil.getCompanies();
        }

        throw new UnsupportedOperationException();
    }
}
