package com.fsquare.shopping.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteCommonActionsServiceClp implements SiteCommonActionsService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
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

    public SiteCommonActionsServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "updateLayout";

        _methodParameterTypes3 = new String[] {
                "long", "boolean", "long", "long", "java.util.Map",
                "java.util.Map", "java.util.Map", "java.util.Map",
                "java.util.Map", "java.lang.String", "boolean", "java.util.Map",
                "java.lang.Boolean", "byte[][]",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName4 = "updateGroup";

        _methodParameterTypes4 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "int",
                "boolean", "int", "java.lang.String", "boolean",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName5 = "updatePassword";

        _methodParameterTypes5 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName6 = "getUserPortraitUrl";

        _methodParameterTypes6 = new String[] { "boolean", "long" };

        _methodName7 = "getAccountsPaged";

        _methodParameterTypes7 = new String[] { "int", "int" };

        _methodName8 = "getAccounts";

        _methodParameterTypes8 = new String[] {  };

        _methodName9 = "getAccount";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getCompanies";

        _methodParameterTypes10 = new String[] {  };

        _methodName11 = "testFileUpload";

        _methodParameterTypes11 = new String[] { "java.io.File" };

        _methodName12 = "testFilesUpload";

        _methodParameterTypes12 = new String[] { "java.util.List" };

        _methodName13 = "testFilesUploadArr";

        _methodParameterTypes13 = new String[] { "java.io.File[][]" };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public com.liferay.portal.model.Layout updateLayout(long companyId,
        boolean privateLayout, long layoutId, long parentLayoutId,
        java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
        java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
        java.util.Map<java.util.Locale, java.lang.String> robotsMap,
        java.lang.String type, boolean hidden,
        java.util.Map<java.util.Locale, java.lang.String> friendlyURLMap,
        java.lang.Boolean iconImage, byte[] iconBytes,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        companyId,
                        
                    privateLayout,
                        
                    layoutId,
                        
                    parentLayoutId,
                        
                    ClpSerializer.translateInput(localeNamesMap),
                        
                    ClpSerializer.translateInput(localeTitlesMap),
                        
                    ClpSerializer.translateInput(descriptionMap),
                        
                    ClpSerializer.translateInput(keywordsMap),
                        
                    ClpSerializer.translateInput(robotsMap),
                        
                    ClpSerializer.translateInput(type),
                        
                    hidden,
                        
                    ClpSerializer.translateInput(friendlyURLMap),
                        
                    ClpSerializer.translateInput(iconImage),
                        
                    ClpSerializer.translateInput(iconBytes),
                        
                    ClpSerializer.translateInput(serviceContext)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.model.Layout) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.model.Group updateGroup(long groupId,
        long parentGroupId, java.lang.String name,
        java.lang.String description, int type, boolean manualMembership,
        int membershipRestriction, java.lang.String friendlyURL,
        boolean active, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        groupId,
                        
                    parentGroupId,
                        
                    ClpSerializer.translateInput(name),
                        
                    ClpSerializer.translateInput(description),
                        
                    type,
                        
                    manualMembership,
                        
                    membershipRestriction,
                        
                    ClpSerializer.translateInput(friendlyURL),
                        
                    active,
                        
                    ClpSerializer.translateInput(serviceContext)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.model.Group) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.model.User updatePassword(long userId,
        java.lang.String oldPassword, java.lang.String password1,
        java.lang.String password2)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        userId,
                        
                    ClpSerializer.translateInput(oldPassword),
                        
                    ClpSerializer.translateInput(password1),
                        
                    ClpSerializer.translateInput(password2)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.model.User) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.lang.String getUserPortraitUrl(boolean male, long portraitId) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6, new Object[] { male, portraitId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<java.util.Map> getAccountsPaged(int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7, new Object[] { start, end });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.Map>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<java.util.Map> getAccounts()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.Map>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.Map getAccount(long accountId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9, new Object[] { accountId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.liferay.portal.model.Company> getCompanies()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.portal.model.Company>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void testFileUpload(java.io.File file) {
        try {
            _invokableService.invokeMethod(_methodName11,
                _methodParameterTypes11,
                new Object[] { ClpSerializer.translateInput(file) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void testFilesUpload(java.util.List<java.io.File> files) {
        try {
            _invokableService.invokeMethod(_methodName12,
                _methodParameterTypes12,
                new Object[] { ClpSerializer.translateInput(files) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void testFilesUploadArr(java.io.File[] files) {
        try {
            _invokableService.invokeMethod(_methodName13,
                _methodParameterTypes13,
                new Object[] { ClpSerializer.translateInput(files) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }
}
