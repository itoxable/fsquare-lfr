package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingItemLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ShoppingItemClp extends BaseModelImpl<ShoppingItem>
    implements ShoppingItem {
    private String _uuid;
    private long _itemId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _classNameId;
    private long _classPK;
    private String _name;
    private String _description;
    private double _price;
    private double _discountPrice;
    private String _sku;
    private long _itemTypeId;
    private BaseModel<?> _shoppingItemRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingItemClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingItem.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingItem.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _itemId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setItemId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _itemId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("itemId", getItemId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("classNameId", getClassNameId());
        attributes.put("classPK", getClassPK());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("price", getPrice());
        attributes.put("discountPrice", getDiscountPrice());
        attributes.put("sku", getSku());
        attributes.put("itemTypeId", getItemTypeId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long itemId = (Long) attributes.get("itemId");

        if (itemId != null) {
            setItemId(itemId);
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

        Long classNameId = (Long) attributes.get("classNameId");

        if (classNameId != null) {
            setClassNameId(classNameId);
        }

        Long classPK = (Long) attributes.get("classPK");

        if (classPK != null) {
            setClassPK(classPK);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Double price = (Double) attributes.get("price");

        if (price != null) {
            setPrice(price);
        }

        Double discountPrice = (Double) attributes.get("discountPrice");

        if (discountPrice != null) {
            setDiscountPrice(discountPrice);
        }

        String sku = (String) attributes.get("sku");

        if (sku != null) {
            setSku(sku);
        }

        Long itemTypeId = (Long) attributes.get("itemTypeId");

        if (itemTypeId != null) {
            setItemTypeId(itemTypeId);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_shoppingItemRemoteModel, uuid);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setItemId", long.class);

                method.invoke(_shoppingItemRemoteModel, itemId);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_shoppingItemRemoteModel, groupId);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_shoppingItemRemoteModel, companyId);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_shoppingItemRemoteModel, userId);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_shoppingItemRemoteModel, userName);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_shoppingItemRemoteModel, createDate);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_shoppingItemRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getClassName() {
        if (getClassNameId() <= 0) {
            return StringPool.BLANK;
        }

        return PortalUtil.getClassName(getClassNameId());
    }

    @Override
    public void setClassName(String className) {
        long classNameId = 0;

        if (Validator.isNotNull(className)) {
            classNameId = PortalUtil.getClassNameId(className);
        }

        setClassNameId(classNameId);
    }

    @Override
    public long getClassNameId() {
        return _classNameId;
    }

    @Override
    public void setClassNameId(long classNameId) {
        _classNameId = classNameId;

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setClassNameId", long.class);

                method.invoke(_shoppingItemRemoteModel, classNameId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getClassPK() {
        return _classPK;
    }

    @Override
    public void setClassPK(long classPK) {
        _classPK = classPK;

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setClassPK", long.class);

                method.invoke(_shoppingItemRemoteModel, classPK);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_shoppingItemRemoteModel, name);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_shoppingItemRemoteModel, description);
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

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setPrice", double.class);

                method.invoke(_shoppingItemRemoteModel, price);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getDiscountPrice() {
        return _discountPrice;
    }

    @Override
    public void setDiscountPrice(double discountPrice) {
        _discountPrice = discountPrice;

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setDiscountPrice", double.class);

                method.invoke(_shoppingItemRemoteModel, discountPrice);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSku() {
        return _sku;
    }

    @Override
    public void setSku(String sku) {
        _sku = sku;

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSku", String.class);

                method.invoke(_shoppingItemRemoteModel, sku);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getItemTypeId() {
        return _itemTypeId;
    }

    @Override
    public void setItemTypeId(long itemTypeId) {
        _itemTypeId = itemTypeId;

        if (_shoppingItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemRemoteModel.getClass();

                Method method = clazz.getMethod("setItemTypeId", long.class);

                method.invoke(_shoppingItemRemoteModel, itemTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                ShoppingItem.class.getName()), getClassNameId());
    }

    public BaseModel<?> getShoppingItemRemoteModel() {
        return _shoppingItemRemoteModel;
    }

    public void setShoppingItemRemoteModel(BaseModel<?> shoppingItemRemoteModel) {
        _shoppingItemRemoteModel = shoppingItemRemoteModel;
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

        Class<?> remoteModelClass = _shoppingItemRemoteModel.getClass();

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

        Object returnValue = method.invoke(_shoppingItemRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingItemLocalServiceUtil.addShoppingItem(this);
        } else {
            ShoppingItemLocalServiceUtil.updateShoppingItem(this);
        }
    }

    @Override
    public ShoppingItem toEscapedModel() {
        return (ShoppingItem) ProxyUtil.newProxyInstance(ShoppingItem.class.getClassLoader(),
            new Class[] { ShoppingItem.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingItemClp clone = new ShoppingItemClp();

        clone.setUuid(getUuid());
        clone.setItemId(getItemId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setClassNameId(getClassNameId());
        clone.setClassPK(getClassPK());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setPrice(getPrice());
        clone.setDiscountPrice(getDiscountPrice());
        clone.setSku(getSku());
        clone.setItemTypeId(getItemTypeId());

        return clone;
    }

    @Override
    public int compareTo(ShoppingItem shoppingItem) {
        long primaryKey = shoppingItem.getPrimaryKey();

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

        if (!(obj instanceof ShoppingItemClp)) {
            return false;
        }

        ShoppingItemClp shoppingItem = (ShoppingItemClp) obj;

        long primaryKey = shoppingItem.getPrimaryKey();

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
        StringBundler sb = new StringBundler(33);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", itemId=");
        sb.append(getItemId());
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
        sb.append(", classNameId=");
        sb.append(getClassNameId());
        sb.append(", classPK=");
        sb.append(getClassPK());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", price=");
        sb.append(getPrice());
        sb.append(", discountPrice=");
        sb.append(getDiscountPrice());
        sb.append(", sku=");
        sb.append(getSku());
        sb.append(", itemTypeId=");
        sb.append(getItemTypeId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(52);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingItem");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>itemId</column-name><column-value><![CDATA[");
        sb.append(getItemId());
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
            "<column><column-name>classNameId</column-name><column-value><![CDATA[");
        sb.append(getClassNameId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>classPK</column-name><column-value><![CDATA[");
        sb.append(getClassPK());
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
            "<column><column-name>price</column-name><column-value><![CDATA[");
        sb.append(getPrice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>discountPrice</column-name><column-value><![CDATA[");
        sb.append(getDiscountPrice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sku</column-name><column-value><![CDATA[");
        sb.append(getSku());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
        sb.append(getItemTypeId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
