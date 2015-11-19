package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ShoppingStoreClp extends BaseModelImpl<ShoppingStore>
    implements ShoppingStore {
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _cartPageUuid;
    private String _checkoutPageUuid;
    private String _onAddToCart;
    private String _currency;
    private String _country;
    private String _userTypes;
    private String _orderCreatedEmailTemplate;
    private String _orderShippedEmailTemplate;
    private String _orderCreatedEmailSubject;
    private String _orderCreatedEmailFromAddress;
    private boolean _integrateWithStripe;
    private String _stripeTestSecretKey;
    private String _stripeTestPublishableKey;
    private boolean _stripeTesting;
    private String _stripeLiveSecretKey;
    private String _stripeLivePublishableKey;
    private String _stripeApiVersion;
    private BaseModel<?> _shoppingStoreRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingStoreClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingStore.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingStore.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _groupId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setGroupId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _groupId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("cartPageUuid", getCartPageUuid());
        attributes.put("checkoutPageUuid", getCheckoutPageUuid());
        attributes.put("onAddToCart", getOnAddToCart());
        attributes.put("currency", getCurrency());
        attributes.put("country", getCountry());
        attributes.put("userTypes", getUserTypes());
        attributes.put("orderCreatedEmailTemplate",
            getOrderCreatedEmailTemplate());
        attributes.put("orderShippedEmailTemplate",
            getOrderShippedEmailTemplate());
        attributes.put("orderCreatedEmailSubject", getOrderCreatedEmailSubject());
        attributes.put("orderCreatedEmailFromAddress",
            getOrderCreatedEmailFromAddress());
        attributes.put("integrateWithStripe", getIntegrateWithStripe());
        attributes.put("stripeTestSecretKey", getStripeTestSecretKey());
        attributes.put("stripeTestPublishableKey", getStripeTestPublishableKey());
        attributes.put("stripeTesting", getStripeTesting());
        attributes.put("stripeLiveSecretKey", getStripeLiveSecretKey());
        attributes.put("stripeLivePublishableKey", getStripeLivePublishableKey());
        attributes.put("stripeApiVersion", getStripeApiVersion());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String cartPageUuid = (String) attributes.get("cartPageUuid");

        if (cartPageUuid != null) {
            setCartPageUuid(cartPageUuid);
        }

        String checkoutPageUuid = (String) attributes.get("checkoutPageUuid");

        if (checkoutPageUuid != null) {
            setCheckoutPageUuid(checkoutPageUuid);
        }

        String onAddToCart = (String) attributes.get("onAddToCart");

        if (onAddToCart != null) {
            setOnAddToCart(onAddToCart);
        }

        String currency = (String) attributes.get("currency");

        if (currency != null) {
            setCurrency(currency);
        }

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }

        String userTypes = (String) attributes.get("userTypes");

        if (userTypes != null) {
            setUserTypes(userTypes);
        }

        String orderCreatedEmailTemplate = (String) attributes.get(
                "orderCreatedEmailTemplate");

        if (orderCreatedEmailTemplate != null) {
            setOrderCreatedEmailTemplate(orderCreatedEmailTemplate);
        }

        String orderShippedEmailTemplate = (String) attributes.get(
                "orderShippedEmailTemplate");

        if (orderShippedEmailTemplate != null) {
            setOrderShippedEmailTemplate(orderShippedEmailTemplate);
        }

        String orderCreatedEmailSubject = (String) attributes.get(
                "orderCreatedEmailSubject");

        if (orderCreatedEmailSubject != null) {
            setOrderCreatedEmailSubject(orderCreatedEmailSubject);
        }

        String orderCreatedEmailFromAddress = (String) attributes.get(
                "orderCreatedEmailFromAddress");

        if (orderCreatedEmailFromAddress != null) {
            setOrderCreatedEmailFromAddress(orderCreatedEmailFromAddress);
        }

        Boolean integrateWithStripe = (Boolean) attributes.get(
                "integrateWithStripe");

        if (integrateWithStripe != null) {
            setIntegrateWithStripe(integrateWithStripe);
        }

        String stripeTestSecretKey = (String) attributes.get(
                "stripeTestSecretKey");

        if (stripeTestSecretKey != null) {
            setStripeTestSecretKey(stripeTestSecretKey);
        }

        String stripeTestPublishableKey = (String) attributes.get(
                "stripeTestPublishableKey");

        if (stripeTestPublishableKey != null) {
            setStripeTestPublishableKey(stripeTestPublishableKey);
        }

        Boolean stripeTesting = (Boolean) attributes.get("stripeTesting");

        if (stripeTesting != null) {
            setStripeTesting(stripeTesting);
        }

        String stripeLiveSecretKey = (String) attributes.get(
                "stripeLiveSecretKey");

        if (stripeLiveSecretKey != null) {
            setStripeLiveSecretKey(stripeLiveSecretKey);
        }

        String stripeLivePublishableKey = (String) attributes.get(
                "stripeLivePublishableKey");

        if (stripeLivePublishableKey != null) {
            setStripeLivePublishableKey(stripeLivePublishableKey);
        }

        String stripeApiVersion = (String) attributes.get("stripeApiVersion");

        if (stripeApiVersion != null) {
            setStripeApiVersion(stripeApiVersion);
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_shoppingStoreRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_shoppingStoreRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_shoppingStoreRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_shoppingStoreRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_shoppingStoreRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_shoppingStoreRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_shoppingStoreRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCartPageUuid() {
        return _cartPageUuid;
    }

    @Override
    public void setCartPageUuid(String cartPageUuid) {
        _cartPageUuid = cartPageUuid;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCartPageUuid", String.class);

                method.invoke(_shoppingStoreRemoteModel, cartPageUuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCheckoutPageUuid() {
        return _checkoutPageUuid;
    }

    @Override
    public void setCheckoutPageUuid(String checkoutPageUuid) {
        _checkoutPageUuid = checkoutPageUuid;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCheckoutPageUuid",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel, checkoutPageUuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOnAddToCart() {
        return _onAddToCart;
    }

    @Override
    public void setOnAddToCart(String onAddToCart) {
        _onAddToCart = onAddToCart;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setOnAddToCart", String.class);

                method.invoke(_shoppingStoreRemoteModel, onAddToCart);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCurrency() {
        return _currency;
    }

    @Override
    public void setCurrency(String currency) {
        _currency = currency;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCurrency", String.class);

                method.invoke(_shoppingStoreRemoteModel, currency);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCountry() {
        return _country;
    }

    @Override
    public void setCountry(String country) {
        _country = country;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCountry", String.class);

                method.invoke(_shoppingStoreRemoteModel, country);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserTypes() {
        return _userTypes;
    }

    @Override
    public void setUserTypes(String userTypes) {
        _userTypes = userTypes;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setUserTypes", String.class);

                method.invoke(_shoppingStoreRemoteModel, userTypes);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrderCreatedEmailTemplate() {
        return _orderCreatedEmailTemplate;
    }

    @Override
    public void setOrderCreatedEmailTemplate(String orderCreatedEmailTemplate) {
        _orderCreatedEmailTemplate = orderCreatedEmailTemplate;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setOrderCreatedEmailTemplate",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel,
                    orderCreatedEmailTemplate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrderShippedEmailTemplate() {
        return _orderShippedEmailTemplate;
    }

    @Override
    public void setOrderShippedEmailTemplate(String orderShippedEmailTemplate) {
        _orderShippedEmailTemplate = orderShippedEmailTemplate;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setOrderShippedEmailTemplate",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel,
                    orderShippedEmailTemplate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrderCreatedEmailSubject() {
        return _orderCreatedEmailSubject;
    }

    @Override
    public void setOrderCreatedEmailSubject(String orderCreatedEmailSubject) {
        _orderCreatedEmailSubject = orderCreatedEmailSubject;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setOrderCreatedEmailSubject",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel,
                    orderCreatedEmailSubject);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrderCreatedEmailFromAddress() {
        return _orderCreatedEmailFromAddress;
    }

    @Override
    public void setOrderCreatedEmailFromAddress(
        String orderCreatedEmailFromAddress) {
        _orderCreatedEmailFromAddress = orderCreatedEmailFromAddress;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setOrderCreatedEmailFromAddress",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel,
                    orderCreatedEmailFromAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getIntegrateWithStripe() {
        return _integrateWithStripe;
    }

    @Override
    public boolean isIntegrateWithStripe() {
        return _integrateWithStripe;
    }

    @Override
    public void setIntegrateWithStripe(boolean integrateWithStripe) {
        _integrateWithStripe = integrateWithStripe;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setIntegrateWithStripe",
                        boolean.class);

                method.invoke(_shoppingStoreRemoteModel, integrateWithStripe);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStripeTestSecretKey() {
        return _stripeTestSecretKey;
    }

    @Override
    public void setStripeTestSecretKey(String stripeTestSecretKey) {
        _stripeTestSecretKey = stripeTestSecretKey;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setStripeTestSecretKey",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel, stripeTestSecretKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStripeTestPublishableKey() {
        return _stripeTestPublishableKey;
    }

    @Override
    public void setStripeTestPublishableKey(String stripeTestPublishableKey) {
        _stripeTestPublishableKey = stripeTestPublishableKey;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setStripeTestPublishableKey",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel,
                    stripeTestPublishableKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getStripeTesting() {
        return _stripeTesting;
    }

    @Override
    public boolean isStripeTesting() {
        return _stripeTesting;
    }

    @Override
    public void setStripeTesting(boolean stripeTesting) {
        _stripeTesting = stripeTesting;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setStripeTesting",
                        boolean.class);

                method.invoke(_shoppingStoreRemoteModel, stripeTesting);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStripeLiveSecretKey() {
        return _stripeLiveSecretKey;
    }

    @Override
    public void setStripeLiveSecretKey(String stripeLiveSecretKey) {
        _stripeLiveSecretKey = stripeLiveSecretKey;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setStripeLiveSecretKey",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel, stripeLiveSecretKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStripeLivePublishableKey() {
        return _stripeLivePublishableKey;
    }

    @Override
    public void setStripeLivePublishableKey(String stripeLivePublishableKey) {
        _stripeLivePublishableKey = stripeLivePublishableKey;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setStripeLivePublishableKey",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel,
                    stripeLivePublishableKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStripeApiVersion() {
        return _stripeApiVersion;
    }

    @Override
    public void setStripeApiVersion(String stripeApiVersion) {
        _stripeApiVersion = stripeApiVersion;

        if (_shoppingStoreRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStoreRemoteModel.getClass();

                Method method = clazz.getMethod("setStripeApiVersion",
                        String.class);

                method.invoke(_shoppingStoreRemoteModel, stripeApiVersion);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getShoppingStoreRemoteModel() {
        return _shoppingStoreRemoteModel;
    }

    public void setShoppingStoreRemoteModel(
        BaseModel<?> shoppingStoreRemoteModel) {
        _shoppingStoreRemoteModel = shoppingStoreRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _shoppingStoreRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_shoppingStoreRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingStoreLocalServiceUtil.addShoppingStore(this);
        } else {
            ShoppingStoreLocalServiceUtil.updateShoppingStore(this);
        }
    }

    @Override
    public ShoppingStore toEscapedModel() {
        return (ShoppingStore) ProxyUtil.newProxyInstance(ShoppingStore.class.getClassLoader(),
            new Class[] { ShoppingStore.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingStoreClp clone = new ShoppingStoreClp();

        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setCartPageUuid(getCartPageUuid());
        clone.setCheckoutPageUuid(getCheckoutPageUuid());
        clone.setOnAddToCart(getOnAddToCart());
        clone.setCurrency(getCurrency());
        clone.setCountry(getCountry());
        clone.setUserTypes(getUserTypes());
        clone.setOrderCreatedEmailTemplate(getOrderCreatedEmailTemplate());
        clone.setOrderShippedEmailTemplate(getOrderShippedEmailTemplate());
        clone.setOrderCreatedEmailSubject(getOrderCreatedEmailSubject());
        clone.setOrderCreatedEmailFromAddress(getOrderCreatedEmailFromAddress());
        clone.setIntegrateWithStripe(getIntegrateWithStripe());
        clone.setStripeTestSecretKey(getStripeTestSecretKey());
        clone.setStripeTestPublishableKey(getStripeTestPublishableKey());
        clone.setStripeTesting(getStripeTesting());
        clone.setStripeLiveSecretKey(getStripeLiveSecretKey());
        clone.setStripeLivePublishableKey(getStripeLivePublishableKey());
        clone.setStripeApiVersion(getStripeApiVersion());

        return clone;
    }

    @Override
    public int compareTo(ShoppingStore shoppingStore) {
        long primaryKey = shoppingStore.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingStoreClp)) {
            return false;
        }

        ShoppingStoreClp shoppingStore = (ShoppingStoreClp) obj;

        long primaryKey = shoppingStore.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(49);

        sb.append("{groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", cartPageUuid=");
        sb.append(getCartPageUuid());
        sb.append(", checkoutPageUuid=");
        sb.append(getCheckoutPageUuid());
        sb.append(", onAddToCart=");
        sb.append(getOnAddToCart());
        sb.append(", currency=");
        sb.append(getCurrency());
        sb.append(", country=");
        sb.append(getCountry());
        sb.append(", userTypes=");
        sb.append(getUserTypes());
        sb.append(", orderCreatedEmailTemplate=");
        sb.append(getOrderCreatedEmailTemplate());
        sb.append(", orderShippedEmailTemplate=");
        sb.append(getOrderShippedEmailTemplate());
        sb.append(", orderCreatedEmailSubject=");
        sb.append(getOrderCreatedEmailSubject());
        sb.append(", orderCreatedEmailFromAddress=");
        sb.append(getOrderCreatedEmailFromAddress());
        sb.append(", integrateWithStripe=");
        sb.append(getIntegrateWithStripe());
        sb.append(", stripeTestSecretKey=");
        sb.append(getStripeTestSecretKey());
        sb.append(", stripeTestPublishableKey=");
        sb.append(getStripeTestPublishableKey());
        sb.append(", stripeTesting=");
        sb.append(getStripeTesting());
        sb.append(", stripeLiveSecretKey=");
        sb.append(getStripeLiveSecretKey());
        sb.append(", stripeLivePublishableKey=");
        sb.append(getStripeLivePublishableKey());
        sb.append(", stripeApiVersion=");
        sb.append(getStripeApiVersion());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(76);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingStore");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cartPageUuid</column-name><column-value><![CDATA[");
        sb.append(getCartPageUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>checkoutPageUuid</column-name><column-value><![CDATA[");
        sb.append(getCheckoutPageUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>onAddToCart</column-name><column-value><![CDATA[");
        sb.append(getOnAddToCart());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currency</column-name><column-value><![CDATA[");
        sb.append(getCurrency());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>country</column-name><column-value><![CDATA[");
        sb.append(getCountry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userTypes</column-name><column-value><![CDATA[");
        sb.append(getUserTypes());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orderCreatedEmailTemplate</column-name><column-value><![CDATA[");
        sb.append(getOrderCreatedEmailTemplate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orderShippedEmailTemplate</column-name><column-value><![CDATA[");
        sb.append(getOrderShippedEmailTemplate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orderCreatedEmailSubject</column-name><column-value><![CDATA[");
        sb.append(getOrderCreatedEmailSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orderCreatedEmailFromAddress</column-name><column-value><![CDATA[");
        sb.append(getOrderCreatedEmailFromAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>integrateWithStripe</column-name><column-value><![CDATA[");
        sb.append(getIntegrateWithStripe());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeTestSecretKey</column-name><column-value><![CDATA[");
        sb.append(getStripeTestSecretKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeTestPublishableKey</column-name><column-value><![CDATA[");
        sb.append(getStripeTestPublishableKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeTesting</column-name><column-value><![CDATA[");
        sb.append(getStripeTesting());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeLiveSecretKey</column-name><column-value><![CDATA[");
        sb.append(getStripeLiveSecretKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeLivePublishableKey</column-name><column-value><![CDATA[");
        sb.append(getStripeLivePublishableKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeApiVersion</column-name><column-value><![CDATA[");
        sb.append(getStripeApiVersion());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
