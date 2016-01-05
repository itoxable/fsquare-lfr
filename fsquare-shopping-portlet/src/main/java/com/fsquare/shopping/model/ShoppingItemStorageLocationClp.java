package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingItemStorageLocationLocalServiceUtil;

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


public class ShoppingItemStorageLocationClp extends BaseModelImpl<ShoppingItemStorageLocation>
    implements ShoppingItemStorageLocation {
    private long _itemStorageLocationId;
    private long _itemId;
    private long _storageLocationId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private int _quantity;
    private String _movementType;
    private BaseModel<?> _shoppingItemStorageLocationRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingItemStorageLocationClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingItemStorageLocation.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingItemStorageLocation.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _itemStorageLocationId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setItemStorageLocationId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _itemStorageLocationId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("itemStorageLocationId", getItemStorageLocationId());
        attributes.put("itemId", getItemId());
        attributes.put("storageLocationId", getStorageLocationId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("quantity", getQuantity());
        attributes.put("movementType", getMovementType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long itemStorageLocationId = (Long) attributes.get(
                "itemStorageLocationId");

        if (itemStorageLocationId != null) {
            setItemStorageLocationId(itemStorageLocationId);
        }

        Long itemId = (Long) attributes.get("itemId");

        if (itemId != null) {
            setItemId(itemId);
        }

        Long storageLocationId = (Long) attributes.get("storageLocationId");

        if (storageLocationId != null) {
            setStorageLocationId(storageLocationId);
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

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Integer quantity = (Integer) attributes.get("quantity");

        if (quantity != null) {
            setQuantity(quantity);
        }

        String movementType = (String) attributes.get("movementType");

        if (movementType != null) {
            setMovementType(movementType);
        }
    }

    @Override
    public long getItemStorageLocationId() {
        return _itemStorageLocationId;
    }

    @Override
    public void setItemStorageLocationId(long itemStorageLocationId) {
        _itemStorageLocationId = itemStorageLocationId;

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setItemStorageLocationId",
                        long.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel,
                    itemStorageLocationId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getItemId() {
        return _itemId;
    }

    @Override
    public void setItemId(long itemId) {
        _itemId = itemId;

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setItemId", long.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel, itemId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStorageLocationId() {
        return _storageLocationId;
    }

    @Override
    public void setStorageLocationId(long storageLocationId) {
        _storageLocationId = storageLocationId;

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setStorageLocationId",
                        long.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel,
                    storageLocationId);
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

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel, groupId);
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

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel, companyId);
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

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel, userId);
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

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel, userName);
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

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel,
                    createDate);
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

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel,
                    modifiedDate);
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

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getQuantity() {
        return _quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        _quantity = quantity;

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setQuantity", int.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel, quantity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMovementType() {
        return _movementType;
    }

    @Override
    public void setMovementType(String movementType) {
        _movementType = movementType;

        if (_shoppingItemStorageLocationRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemStorageLocationRemoteModel.getClass();

                Method method = clazz.getMethod("setMovementType", String.class);

                method.invoke(_shoppingItemStorageLocationRemoteModel,
                    movementType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getShoppingItemStorageLocationRemoteModel() {
        return _shoppingItemStorageLocationRemoteModel;
    }

    public void setShoppingItemStorageLocationRemoteModel(
        BaseModel<?> shoppingItemStorageLocationRemoteModel) {
        _shoppingItemStorageLocationRemoteModel = shoppingItemStorageLocationRemoteModel;
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

        Class<?> remoteModelClass = _shoppingItemStorageLocationRemoteModel.getClass();

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

        Object returnValue = method.invoke(_shoppingItemStorageLocationRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingItemStorageLocationLocalServiceUtil.addShoppingItemStorageLocation(this);
        } else {
            ShoppingItemStorageLocationLocalServiceUtil.updateShoppingItemStorageLocation(this);
        }
    }

    @Override
    public ShoppingItemStorageLocation toEscapedModel() {
        return (ShoppingItemStorageLocation) ProxyUtil.newProxyInstance(ShoppingItemStorageLocation.class.getClassLoader(),
            new Class[] { ShoppingItemStorageLocation.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingItemStorageLocationClp clone = new ShoppingItemStorageLocationClp();

        clone.setItemStorageLocationId(getItemStorageLocationId());
        clone.setItemId(getItemId());
        clone.setStorageLocationId(getStorageLocationId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setQuantity(getQuantity());
        clone.setMovementType(getMovementType());

        return clone;
    }

    @Override
    public int compareTo(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        long primaryKey = shoppingItemStorageLocation.getPrimaryKey();

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

        if (!(obj instanceof ShoppingItemStorageLocationClp)) {
            return false;
        }

        ShoppingItemStorageLocationClp shoppingItemStorageLocation = (ShoppingItemStorageLocationClp) obj;

        long primaryKey = shoppingItemStorageLocation.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{itemStorageLocationId=");
        sb.append(getItemStorageLocationId());
        sb.append(", itemId=");
        sb.append(getItemId());
        sb.append(", storageLocationId=");
        sb.append(getStorageLocationId());
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
        sb.append(", name=");
        sb.append(getName());
        sb.append(", quantity=");
        sb.append(getQuantity());
        sb.append(", movementType=");
        sb.append(getMovementType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingItemStorageLocation");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>itemStorageLocationId</column-name><column-value><![CDATA[");
        sb.append(getItemStorageLocationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>itemId</column-name><column-value><![CDATA[");
        sb.append(getItemId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>storageLocationId</column-name><column-value><![CDATA[");
        sb.append(getStorageLocationId());
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
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quantity</column-name><column-value><![CDATA[");
        sb.append(getQuantity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>movementType</column-name><column-value><![CDATA[");
        sb.append(getMovementType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
