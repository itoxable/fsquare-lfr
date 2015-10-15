package com.fsquare.shopping.service;

import com.fsquare.shopping.model.ShoppingCouponClp;
import com.fsquare.shopping.model.ShoppingOrderClp;
import com.fsquare.shopping.model.ShoppingOrderItemClp;
import com.fsquare.shopping.model.ShoppingShippingMethodClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "fsquare-shopping-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "fsquare-shopping-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "fsquare-shopping-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ShoppingCouponClp.class.getName())) {
            return translateInputShoppingCoupon(oldModel);
        }

        if (oldModelClassName.equals(ShoppingOrderClp.class.getName())) {
            return translateInputShoppingOrder(oldModel);
        }

        if (oldModelClassName.equals(ShoppingOrderItemClp.class.getName())) {
            return translateInputShoppingOrderItem(oldModel);
        }

        if (oldModelClassName.equals(ShoppingShippingMethodClp.class.getName())) {
            return translateInputShoppingShippingMethod(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputShoppingCoupon(BaseModel<?> oldModel) {
        ShoppingCouponClp oldClpModel = (ShoppingCouponClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getShoppingCouponRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputShoppingOrder(BaseModel<?> oldModel) {
        ShoppingOrderClp oldClpModel = (ShoppingOrderClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getShoppingOrderRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputShoppingOrderItem(BaseModel<?> oldModel) {
        ShoppingOrderItemClp oldClpModel = (ShoppingOrderItemClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getShoppingOrderItemRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputShoppingShippingMethod(
        BaseModel<?> oldModel) {
        ShoppingShippingMethodClp oldClpModel = (ShoppingShippingMethodClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getShoppingShippingMethodRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.fsquare.shopping.model.impl.ShoppingCouponImpl")) {
            return translateOutputShoppingCoupon(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.fsquare.shopping.model.impl.ShoppingOrderImpl")) {
            return translateOutputShoppingOrder(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.fsquare.shopping.model.impl.ShoppingOrderItemImpl")) {
            return translateOutputShoppingOrderItem(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.fsquare.shopping.model.impl.ShoppingShippingMethodImpl")) {
            return translateOutputShoppingShippingMethod(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("com.fsquare.shopping.BillingCityException")) {
            return new com.fsquare.shopping.BillingCityException();
        }

        if (className.equals("com.fsquare.shopping.BillingCountryException")) {
            return new com.fsquare.shopping.BillingCountryException();
        }

        if (className.equals(
                    "com.fsquare.shopping.BillingEmailAddressException")) {
            return new com.fsquare.shopping.BillingEmailAddressException();
        }

        if (className.equals("com.fsquare.shopping.BillingFirstNameException")) {
            return new com.fsquare.shopping.BillingFirstNameException();
        }

        if (className.equals("com.fsquare.shopping.BillingLastNameException")) {
            return new com.fsquare.shopping.BillingLastNameException();
        }

        if (className.equals("com.fsquare.shopping.BillingPhoneException")) {
            return new com.fsquare.shopping.BillingPhoneException();
        }

        if (className.equals("com.fsquare.shopping.BillingStateException")) {
            return new com.fsquare.shopping.BillingStateException();
        }

        if (className.equals("com.fsquare.shopping.BillingStreetException")) {
            return new com.fsquare.shopping.BillingStreetException();
        }

        if (className.equals("com.fsquare.shopping.BillingZipException")) {
            return new com.fsquare.shopping.BillingZipException();
        }

        if (className.equals("com.fsquare.shopping.CCExpirationException")) {
            return new com.fsquare.shopping.CCExpirationException();
        }

        if (className.equals("com.fsquare.shopping.CCNameException")) {
            return new com.fsquare.shopping.CCNameException();
        }

        if (className.equals("com.fsquare.shopping.CCNumberException")) {
            return new com.fsquare.shopping.CCNumberException();
        }

        if (className.equals("com.fsquare.shopping.CCTypeException")) {
            return new com.fsquare.shopping.CCTypeException();
        }

        if (className.equals("com.fsquare.shopping.CartMinOrderException")) {
            return new com.fsquare.shopping.CartMinOrderException();
        }

        if (className.equals("com.fsquare.shopping.CartMinQuantityException")) {
            return new com.fsquare.shopping.CartMinQuantityException();
        }

        if (className.equals("com.fsquare.shopping.CouponActiveException")) {
            return new com.fsquare.shopping.CouponActiveException();
        }

        if (className.equals("com.fsquare.shopping.CouponCodeException")) {
            return new com.fsquare.shopping.CouponCodeException();
        }

        if (className.equals("com.fsquare.shopping.CouponDateException")) {
            return new com.fsquare.shopping.CouponDateException();
        }

        if (className.equals("com.fsquare.shopping.CouponDescriptionException")) {
            return new com.fsquare.shopping.CouponDescriptionException();
        }

        if (className.equals("com.fsquare.shopping.CouponEndDateException")) {
            return new com.fsquare.shopping.CouponEndDateException();
        }

        if (className.equals(
                    "com.fsquare.shopping.CouponLimitCategoriesException")) {
            return new com.fsquare.shopping.CouponLimitCategoriesException();
        }

        if (className.equals("com.fsquare.shopping.CouponLimitSKUsException")) {
            return new com.fsquare.shopping.CouponLimitSKUsException();
        }

        if (className.equals("com.fsquare.shopping.CouponNameException")) {
            return new com.fsquare.shopping.CouponNameException();
        }

        if (className.equals("com.fsquare.shopping.CouponStartDateException")) {
            return new com.fsquare.shopping.CouponStartDateException();
        }

        if (className.equals(
                    "com.fsquare.shopping.DuplicateCouponCodeException")) {
            return new com.fsquare.shopping.DuplicateCouponCodeException();
        }

        if (className.equals("com.fsquare.shopping.DuplicateItemSKUException")) {
            return new com.fsquare.shopping.DuplicateItemSKUException();
        }

        if (className.equals("com.fsquare.shopping.RequiredCouponException")) {
            return new com.fsquare.shopping.RequiredCouponException();
        }

        if (className.equals("com.fsquare.shopping.ShippingCityException")) {
            return new com.fsquare.shopping.ShippingCityException();
        }

        if (className.equals("com.fsquare.shopping.ShippingCountryException")) {
            return new com.fsquare.shopping.ShippingCountryException();
        }

        if (className.equals(
                    "com.fsquare.shopping.ShippingEmailAddressException")) {
            return new com.fsquare.shopping.ShippingEmailAddressException();
        }

        if (className.equals("com.fsquare.shopping.ShippingFirstNameException")) {
            return new com.fsquare.shopping.ShippingFirstNameException();
        }

        if (className.equals("com.fsquare.shopping.ShippingLastNameException")) {
            return new com.fsquare.shopping.ShippingLastNameException();
        }

        if (className.equals("com.fsquare.shopping.ShippingPhoneException")) {
            return new com.fsquare.shopping.ShippingPhoneException();
        }

        if (className.equals("com.fsquare.shopping.ShippingStateException")) {
            return new com.fsquare.shopping.ShippingStateException();
        }

        if (className.equals("com.fsquare.shopping.ShippingStreetException")) {
            return new com.fsquare.shopping.ShippingStreetException();
        }

        if (className.equals("com.fsquare.shopping.ShippingZipException")) {
            return new com.fsquare.shopping.ShippingZipException();
        }

        if (className.equals(
                    "com.fsquare.shopping.NoSuchShoppingCouponException")) {
            return new com.fsquare.shopping.NoSuchShoppingCouponException();
        }

        if (className.equals(
                    "com.fsquare.shopping.NoSuchShoppingOrderException")) {
            return new com.fsquare.shopping.NoSuchShoppingOrderException();
        }

        if (className.equals(
                    "com.fsquare.shopping.NoSuchShoppingOrderItemException")) {
            return new com.fsquare.shopping.NoSuchShoppingOrderItemException();
        }

        if (className.equals(
                    "com.fsquare.shopping.NoSuchShoppingShippingMethodException")) {
            return new com.fsquare.shopping.NoSuchShoppingShippingMethodException();
        }

        return throwable;
    }

    public static Object translateOutputShoppingCoupon(BaseModel<?> oldModel) {
        ShoppingCouponClp newModel = new ShoppingCouponClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setShoppingCouponRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputShoppingOrder(BaseModel<?> oldModel) {
        ShoppingOrderClp newModel = new ShoppingOrderClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setShoppingOrderRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputShoppingOrderItem(BaseModel<?> oldModel) {
        ShoppingOrderItemClp newModel = new ShoppingOrderItemClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setShoppingOrderItemRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputShoppingShippingMethod(
        BaseModel<?> oldModel) {
        ShoppingShippingMethodClp newModel = new ShoppingShippingMethodClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setShoppingShippingMethodRemoteModel(oldModel);

        return newModel;
    }
}
