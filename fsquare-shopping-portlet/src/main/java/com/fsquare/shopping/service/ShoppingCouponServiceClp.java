package com.fsquare.shopping.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingCouponServiceClp implements ShoppingCouponService {
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

    public ShoppingCouponServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "testMap";

        _methodParameterTypes3 = new String[] { "java.util.Map" };

        _methodName4 = "fetchByCodeAndCompanyId";

        _methodParameterTypes4 = new String[] { "java.lang.String", "long" };

        _methodName5 = "findByCompanyId";

        _methodParameterTypes5 = new String[] { "java.lang.Long" };

        _methodName6 = "isCouponValid";

        _methodParameterTypes6 = new String[] {
                "com.fsquare.shopping.model.ShoppingCoupon"
            };

        _methodName7 = "getCouponStatus";

        _methodParameterTypes7 = new String[] {
                "com.fsquare.shopping.model.ShoppingCoupon"
            };

        _methodName8 = "findByCompanyIdStartEnd";

        _methodParameterTypes8 = new String[] { "java.lang.Long", "int", "int" };

        _methodName9 = "countByCompanyId";

        _methodParameterTypes9 = new String[] { "java.lang.Long" };

        _methodName10 = "getPagedItems";

        _methodParameterTypes10 = new String[] { "java.lang.Long", "int", "int" };

        _methodName11 = "updateShoppingCoupon";

        _methodParameterTypes11 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.util.Date", "java.util.Date",
                "boolean", "java.lang.String", "java.lang.String", "double",
                "double", "java.lang.String", "long", "long"
            };

        _methodName12 = "deleteCoupon";

        _methodParameterTypes12 = new String[] { "long" };

        _methodName13 = "updateShoppingCoupon";

        _methodParameterTypes13 = new String[] {
                "com.fsquare.shopping.model.ShoppingCoupon"
            };
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
    public java.util.Map<java.util.Locale, java.lang.String> testMap(
        java.util.Map<java.util.Locale, java.lang.String> map) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] { ClpSerializer.translateInput(map) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map<java.util.Locale, java.lang.String>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon fetchByCodeAndCompanyId(
        java.lang.String code, long companyId) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] { ClpSerializer.translateInput(code), companyId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.fsquare.shopping.model.ShoppingCoupon) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyId(
        java.lang.Long companyId) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] { ClpSerializer.translateInput(companyId) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.fsquare.shopping.model.ShoppingCoupon>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public boolean isCouponValid(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] { ClpSerializer.translateInput(shoppingCoupon) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public java.lang.String getCouponStatus(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] { ClpSerializer.translateInput(shoppingCoupon) });
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
    public java.util.List<com.fsquare.shopping.model.ShoppingCoupon> findByCompanyIdStartEnd(
        java.lang.Long companyId, int start, int end) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] {
                        ClpSerializer.translateInput(companyId),
                        
                    start,
                        
                    end
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.fsquare.shopping.model.ShoppingCoupon>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int countByCompanyId(java.lang.Long companyId) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9,
                    new Object[] { ClpSerializer.translateInput(companyId) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> getPagedItems(
        java.lang.Long companyId, int start, int end) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10,
                    new Object[] {
                        ClpSerializer.translateInput(companyId),
                        
                    start,
                        
                    end
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map<java.lang.String, java.lang.Object>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void updateShoppingCoupon(long couponId, long companyId,
        java.lang.String code, java.lang.String name,
        java.lang.String description, java.util.Date startDate,
        java.util.Date endDate, boolean active,
        java.lang.String limitCategories, java.lang.String limitSkus,
        double minOrder, double discount, java.lang.String discountType,
        long maxUses, long userid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName11,
                _methodParameterTypes11,
                new Object[] {
                    couponId,
                    
                companyId,
                    
                ClpSerializer.translateInput(code),
                    
                ClpSerializer.translateInput(name),
                    
                ClpSerializer.translateInput(description),
                    
                ClpSerializer.translateInput(startDate),
                    
                ClpSerializer.translateInput(endDate),
                    
                active,
                    
                ClpSerializer.translateInput(limitCategories),
                    
                ClpSerializer.translateInput(limitSkus),
                    
                minOrder,
                    
                discount,
                    
                ClpSerializer.translateInput(discountType),
                    
                maxUses,
                    
                userid
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
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon deleteCoupon(long couponId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName12,
                    _methodParameterTypes12, new Object[] { couponId });
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

        return (com.fsquare.shopping.model.ShoppingCoupon) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon updateShoppingCoupon(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName13,
                    _methodParameterTypes13,
                    new Object[] { ClpSerializer.translateInput(shoppingCoupon) });
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

        return (com.fsquare.shopping.model.ShoppingCoupon) ClpSerializer.translateOutput(returnObj);
    }
}
