package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ShoppingOrderItemClp extends BaseModelImpl<ShoppingOrderItem>
    implements ShoppingOrderItem {
    private long _shoppingOrderItemId;
    private long _shoppingOrderId;
    private String _articleId;
    private String _sku;
    private String _name;
    private String _description;
    private String _properties;
    private double _price;
    private int _quantity;
    private Date _shippedDate;
    private BaseModel<?> _shoppingOrderItemRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingOrderItemClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingOrderItem.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingOrderItem.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _shoppingOrderItemId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setShoppingOrderItemId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _shoppingOrderItemId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("shoppingOrderItemId", getShoppingOrderItemId());
        attributes.put("shoppingOrderId", getShoppingOrderId());
        attributes.put("articleId", getArticleId());
        attributes.put("sku", getSku());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("properties", getProperties());
        attributes.put("price", getPrice());
        attributes.put("quantity", getQuantity());
        attributes.put("shippedDate", getShippedDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long shoppingOrderItemId = (Long) attributes.get("shoppingOrderItemId");

        if (shoppingOrderItemId != null) {
            setShoppingOrderItemId(shoppingOrderItemId);
        }

        Long shoppingOrderId = (Long) attributes.get("shoppingOrderId");

        if (shoppingOrderId != null) {
            setShoppingOrderId(shoppingOrderId);
        }

        String articleId = (String) attributes.get("articleId");

        if (articleId != null) {
            setArticleId(articleId);
        }

        String sku = (String) attributes.get("sku");

        if (sku != null) {
            setSku(sku);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String properties = (String) attributes.get("properties");

        if (properties != null) {
            setProperties(properties);
        }

        Double price = (Double) attributes.get("price");

        if (price != null) {
            setPrice(price);
        }

        Integer quantity = (Integer) attributes.get("quantity");

        if (quantity != null) {
            setQuantity(quantity);
        }

        Date shippedDate = (Date) attributes.get("shippedDate");

        if (shippedDate != null) {
            setShippedDate(shippedDate);
        }
    }

    @Override
    public long getShoppingOrderItemId() {
        return _shoppingOrderItemId;
    }

    @Override
    public void setShoppingOrderItemId(long shoppingOrderItemId) {
        _shoppingOrderItemId = shoppingOrderItemId;

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setShoppingOrderItemId",
                        long.class);

                method.invoke(_shoppingOrderItemRemoteModel, shoppingOrderItemId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getShoppingOrderId() {
        return _shoppingOrderId;
    }

    @Override
    public void setShoppingOrderId(long shoppingOrderId) {
        _shoppingOrderId = shoppingOrderId;

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setShoppingOrderId", long.class);

                method.invoke(_shoppingOrderItemRemoteModel, shoppingOrderId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getArticleId() {
        return _articleId;
    }

    @Override
    public void setArticleId(String articleId) {
        _articleId = articleId;

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setArticleId", String.class);

                method.invoke(_shoppingOrderItemRemoteModel, articleId);
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

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSku", String.class);

                method.invoke(_shoppingOrderItemRemoteModel, sku);
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

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_shoppingOrderItemRemoteModel, name);
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

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_shoppingOrderItemRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProperties() {
        return _properties;
    }

    @Override
    public void setProperties(String properties) {
        _properties = properties;

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setProperties", String.class);

                method.invoke(_shoppingOrderItemRemoteModel, properties);
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

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setPrice", double.class);

                method.invoke(_shoppingOrderItemRemoteModel, price);
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

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setQuantity", int.class);

                method.invoke(_shoppingOrderItemRemoteModel, quantity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getShippedDate() {
        return _shippedDate;
    }

    @Override
    public void setShippedDate(Date shippedDate) {
        _shippedDate = shippedDate;

        if (_shoppingOrderItemRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

                Method method = clazz.getMethod("setShippedDate", Date.class);

                method.invoke(_shoppingOrderItemRemoteModel, shippedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getShoppingOrderItemRemoteModel() {
        return _shoppingOrderItemRemoteModel;
    }

    public void setShoppingOrderItemRemoteModel(
        BaseModel<?> shoppingOrderItemRemoteModel) {
        _shoppingOrderItemRemoteModel = shoppingOrderItemRemoteModel;
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

        Class<?> remoteModelClass = _shoppingOrderItemRemoteModel.getClass();

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

        Object returnValue = method.invoke(_shoppingOrderItemRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingOrderItemLocalServiceUtil.addShoppingOrderItem(this);
        } else {
            ShoppingOrderItemLocalServiceUtil.updateShoppingOrderItem(this);
        }
    }

    @Override
    public ShoppingOrderItem toEscapedModel() {
        return (ShoppingOrderItem) ProxyUtil.newProxyInstance(ShoppingOrderItem.class.getClassLoader(),
            new Class[] { ShoppingOrderItem.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingOrderItemClp clone = new ShoppingOrderItemClp();

        clone.setShoppingOrderItemId(getShoppingOrderItemId());
        clone.setShoppingOrderId(getShoppingOrderId());
        clone.setArticleId(getArticleId());
        clone.setSku(getSku());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setProperties(getProperties());
        clone.setPrice(getPrice());
        clone.setQuantity(getQuantity());
        clone.setShippedDate(getShippedDate());

        return clone;
    }

    @Override
    public int compareTo(ShoppingOrderItem shoppingOrderItem) {
        int value = 0;

        value = getName().compareTo(shoppingOrderItem.getName());

        if (value != 0) {
            return value;
        }

        value = getDescription().compareTo(shoppingOrderItem.getDescription());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingOrderItemClp)) {
            return false;
        }

        ShoppingOrderItemClp shoppingOrderItem = (ShoppingOrderItemClp) obj;

        long primaryKey = shoppingOrderItem.getPrimaryKey();

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

        sb.append("{shoppingOrderItemId=");
        sb.append(getShoppingOrderItemId());
        sb.append(", shoppingOrderId=");
        sb.append(getShoppingOrderId());
        sb.append(", articleId=");
        sb.append(getArticleId());
        sb.append(", sku=");
        sb.append(getSku());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", properties=");
        sb.append(getProperties());
        sb.append(", price=");
        sb.append(getPrice());
        sb.append(", quantity=");
        sb.append(getQuantity());
        sb.append(", shippedDate=");
        sb.append(getShippedDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingOrderItem");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>shoppingOrderItemId</column-name><column-value><![CDATA[");
        sb.append(getShoppingOrderItemId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shoppingOrderId</column-name><column-value><![CDATA[");
        sb.append(getShoppingOrderId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>articleId</column-name><column-value><![CDATA[");
        sb.append(getArticleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sku</column-name><column-value><![CDATA[");
        sb.append(getSku());
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
            "<column><column-name>properties</column-name><column-value><![CDATA[");
        sb.append(getProperties());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>price</column-name><column-value><![CDATA[");
        sb.append(getPrice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quantity</column-name><column-value><![CDATA[");
        sb.append(getQuantity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippedDate</column-name><column-value><![CDATA[");
        sb.append(getShippedDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
