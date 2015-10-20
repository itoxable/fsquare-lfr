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
    private String _cartPageUuid;
    private String _checkoutPageUuid;
    private String _onAddToCart;
    private String _currency;
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
        attributes.put("cartPageUuid", getCartPageUuid());
        attributes.put("checkoutPageUuid", getCheckoutPageUuid());
        attributes.put("onAddToCart", getOnAddToCart());
        attributes.put("currency", getCurrency());

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
        clone.setCartPageUuid(getCartPageUuid());
        clone.setCheckoutPageUuid(getCheckoutPageUuid());
        clone.setOnAddToCart(getOnAddToCart());
        clone.setCurrency(getCurrency());

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
        StringBundler sb = new StringBundler(21);

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
        sb.append(", cartPageUuid=");
        sb.append(getCartPageUuid());
        sb.append(", checkoutPageUuid=");
        sb.append(getCheckoutPageUuid());
        sb.append(", onAddToCart=");
        sb.append(getOnAddToCart());
        sb.append(", currency=");
        sb.append(getCurrency());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

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

        sb.append("</model>");

        return sb.toString();
    }
}
