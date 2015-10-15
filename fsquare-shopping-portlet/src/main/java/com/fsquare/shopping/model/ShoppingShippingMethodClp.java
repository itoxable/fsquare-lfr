package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;

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


public class ShoppingShippingMethodClp extends BaseModelImpl<ShoppingShippingMethod>
    implements ShoppingShippingMethod {
    private long _shippingMethodId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private double _price;
    private String _name;
    private String _methodName;
    private BaseModel<?> _shoppingShippingMethodRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingShippingMethodClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingShippingMethod.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingShippingMethod.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _shippingMethodId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setShippingMethodId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _shippingMethodId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("shippingMethodId", getShippingMethodId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("price", getPrice());
        attributes.put("name", getName());
        attributes.put("methodName", getMethodName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long shippingMethodId = (Long) attributes.get("shippingMethodId");

        if (shippingMethodId != null) {
            setShippingMethodId(shippingMethodId);
        }

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

        Double price = (Double) attributes.get("price");

        if (price != null) {
            setPrice(price);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String methodName = (String) attributes.get("methodName");

        if (methodName != null) {
            setMethodName(methodName);
        }
    }

    @Override
    public long getShippingMethodId() {
        return _shippingMethodId;
    }

    @Override
    public void setShippingMethodId(long shippingMethodId) {
        _shippingMethodId = shippingMethodId;

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingMethodId",
                        long.class);

                method.invoke(_shoppingShippingMethodRemoteModel,
                    shippingMethodId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_shoppingShippingMethodRemoteModel, groupId);
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

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_shoppingShippingMethodRemoteModel, companyId);
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

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_shoppingShippingMethodRemoteModel, userId);
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

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_shoppingShippingMethodRemoteModel, userName);
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

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_shoppingShippingMethodRemoteModel, createDate);
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

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_shoppingShippingMethodRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getPrice() {
        return _price;
    }

    @Override
    public void setPrice(double price) {
        _price = price;

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setPrice", double.class);

                method.invoke(_shoppingShippingMethodRemoteModel, price);
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

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_shoppingShippingMethodRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMethodName() {
        return _methodName;
    }

    @Override
    public void setMethodName(String methodName) {
        _methodName = methodName;

        if (_shoppingShippingMethodRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingShippingMethodRemoteModel.getClass();

                Method method = clazz.getMethod("setMethodName", String.class);

                method.invoke(_shoppingShippingMethodRemoteModel, methodName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getShoppingShippingMethodRemoteModel() {
        return _shoppingShippingMethodRemoteModel;
    }

    public void setShoppingShippingMethodRemoteModel(
        BaseModel<?> shoppingShippingMethodRemoteModel) {
        _shoppingShippingMethodRemoteModel = shoppingShippingMethodRemoteModel;
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

        Class<?> remoteModelClass = _shoppingShippingMethodRemoteModel.getClass();

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

        Object returnValue = method.invoke(_shoppingShippingMethodRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingShippingMethodLocalServiceUtil.addShoppingShippingMethod(this);
        } else {
            ShoppingShippingMethodLocalServiceUtil.updateShoppingShippingMethod(this);
        }
    }

    @Override
    public ShoppingShippingMethod toEscapedModel() {
        return (ShoppingShippingMethod) ProxyUtil.newProxyInstance(ShoppingShippingMethod.class.getClassLoader(),
            new Class[] { ShoppingShippingMethod.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingShippingMethodClp clone = new ShoppingShippingMethodClp();

        clone.setShippingMethodId(getShippingMethodId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setPrice(getPrice());
        clone.setName(getName());
        clone.setMethodName(getMethodName());

        return clone;
    }

    @Override
    public int compareTo(ShoppingShippingMethod shoppingShippingMethod) {
        long primaryKey = shoppingShippingMethod.getPrimaryKey();

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

        if (!(obj instanceof ShoppingShippingMethodClp)) {
            return false;
        }

        ShoppingShippingMethodClp shoppingShippingMethod = (ShoppingShippingMethodClp) obj;

        long primaryKey = shoppingShippingMethod.getPrimaryKey();

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

        sb.append("{shippingMethodId=");
        sb.append(getShippingMethodId());
        sb.append(", groupId=");
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
        sb.append(", price=");
        sb.append(getPrice());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", methodName=");
        sb.append(getMethodName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingShippingMethod");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>shippingMethodId</column-name><column-value><![CDATA[");
        sb.append(getShippingMethodId());
        sb.append("]]></column-value></column>");
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
            "<column><column-name>price</column-name><column-value><![CDATA[");
        sb.append(getPrice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>methodName</column-name><column-value><![CDATA[");
        sb.append(getMethodName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}