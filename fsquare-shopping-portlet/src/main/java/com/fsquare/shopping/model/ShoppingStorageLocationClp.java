package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingStorageLocationLocalServiceUtil;

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


public class ShoppingStorageLocationClp extends BaseModelImpl<ShoppingStorageLocation>
    implements ShoppingStorageLocation {
    private long _storageLocationId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private String _location;
    private BaseModel<?> _shoppingStorageLocationRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingStorageLocationClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingStorageLocation.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingStorageLocation.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _storageLocationId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setStorageLocationId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _storageLocationId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("storageLocationId", getStorageLocationId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("location", getLocation());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long storageLocationId = (Long) attributes.get("storageLocationId");

        if (storageLocationId != null) {
            setStorageLocationId(storageLocationId);
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

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String location = (String) attributes.get("location");

        if (location != null) {
            setLocation(location);
        }
    }

    @Override
    public long getStorageLocationId() {
        return _storageLocationId;
    }

    @Override
    public void setStorageLocationId(long storageLocationId) {
        _storageLocationId = storageLocationId;

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setStorageLocationId",
                        long.class);

                method.invoke(_shoppingStorageLocationRemoteModel,
                    storageLocationId);
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

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_shoppingStorageLocationRemoteModel, companyId);
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

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_shoppingStorageLocationRemoteModel, userId);
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

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_shoppingStorageLocationRemoteModel, userName);
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

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_shoppingStorageLocationRemoteModel, createDate);
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

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_shoppingStorageLocationRemoteModel, modifiedDate);
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

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_shoppingStorageLocationRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_shoppingStorageLocationRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLocation() {
        return _location;
    }

    @Override
    public void setLocation(String location) {
        _location = location;

        if (_shoppingStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setLocation", String.class);

                method.invoke(_shoppingStorageLocationRemoteModel, location);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getShoppingStorageLocationRemoteModel() {
        return _shoppingStorageLocationRemoteModel;
    }

    public void setShoppingStorageLocationRemoteModel(
        BaseModel<?> shoppingStorageLocationRemoteModel) {
        _shoppingStorageLocationRemoteModel = shoppingStorageLocationRemoteModel;
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

        Class<?> remoteModelClass = _shoppingStorageLocationRemoteModel.getClass();

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

        Object returnValue = method.invoke(_shoppingStorageLocationRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingStorageLocationLocalServiceUtil.addShoppingStorageLocation(this);
        } else {
            ShoppingStorageLocationLocalServiceUtil.updateShoppingStorageLocation(this);
        }
    }

    @Override
    public ShoppingStorageLocation toEscapedModel() {
        return (ShoppingStorageLocation) ProxyUtil.newProxyInstance(ShoppingStorageLocation.class.getClassLoader(),
            new Class[] { ShoppingStorageLocation.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingStorageLocationClp clone = new ShoppingStorageLocationClp();

        clone.setStorageLocationId(getStorageLocationId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setLocation(getLocation());

        return clone;
    }

    @Override
    public int compareTo(ShoppingStorageLocation shoppingStorageLocation) {
        long primaryKey = shoppingStorageLocation.getPrimaryKey();

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

        if (!(obj instanceof ShoppingStorageLocationClp)) {
            return false;
        }

        ShoppingStorageLocationClp shoppingStorageLocation = (ShoppingStorageLocationClp) obj;

        long primaryKey = shoppingStorageLocation.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{storageLocationId=");
        sb.append(getStorageLocationId());
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
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", location=");
        sb.append(getLocation());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingStorageLocation");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>storageLocationId</column-name><column-value><![CDATA[");
        sb.append(getStorageLocationId());
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
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>location</column-name><column-value><![CDATA[");
        sb.append(getLocation());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
