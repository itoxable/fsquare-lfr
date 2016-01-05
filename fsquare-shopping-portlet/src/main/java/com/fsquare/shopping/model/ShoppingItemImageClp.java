package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ShoppingItemImageClp extends BaseModelImpl<ShoppingItemImage>
    implements ShoppingItemImage {
    private long _shoppingItemImageId;
    private long _groupId;
    private long _itemId;
    private long _imageId;
    private boolean _mainImage;
    private int _order;
    private BaseModel<?> _shoppingItemImageRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingItemImageClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingItemImage.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingItemImage.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _shoppingItemImageId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setShoppingItemImageId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _shoppingItemImageId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("shoppingItemImageId", getShoppingItemImageId());
        attributes.put("groupId", getGroupId());
        attributes.put("itemId", getItemId());
        attributes.put("imageId", getImageId());
        attributes.put("mainImage", getMainImage());
        attributes.put("order", getOrder());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long shoppingItemImageId = (Long) attributes.get("shoppingItemImageId");

        if (shoppingItemImageId != null) {
            setShoppingItemImageId(shoppingItemImageId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long itemId = (Long) attributes.get("itemId");

        if (itemId != null) {
            setItemId(itemId);
        }

        Long imageId = (Long) attributes.get("imageId");

        if (imageId != null) {
            setImageId(imageId);
        }

        Boolean mainImage = (Boolean) attributes.get("mainImage");

        if (mainImage != null) {
            setMainImage(mainImage);
        }

        Integer order = (Integer) attributes.get("order");

        if (order != null) {
            setOrder(order);
        }
    }

    @Override
    public long getShoppingItemImageId() {
        return _shoppingItemImageId;
    }

    @Override
    public void setShoppingItemImageId(long shoppingItemImageId) {
        _shoppingItemImageId = shoppingItemImageId;

        if (_shoppingItemImageRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemImageRemoteModel.getClass();

                Method method = clazz.getMethod("setShoppingItemImageId",
                        long.class);

                method.invoke(_shoppingItemImageRemoteModel, shoppingItemImageId);
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

        if (_shoppingItemImageRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemImageRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_shoppingItemImageRemoteModel, groupId);
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

        if (_shoppingItemImageRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemImageRemoteModel.getClass();

                Method method = clazz.getMethod("setItemId", long.class);

                method.invoke(_shoppingItemImageRemoteModel, itemId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getImageId() {
        return _imageId;
    }

    @Override
    public void setImageId(long imageId) {
        _imageId = imageId;

        if (_shoppingItemImageRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemImageRemoteModel.getClass();

                Method method = clazz.getMethod("setImageId", long.class);

                method.invoke(_shoppingItemImageRemoteModel, imageId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getMainImage() {
        return _mainImage;
    }

    @Override
    public boolean isMainImage() {
        return _mainImage;
    }

    @Override
    public void setMainImage(boolean mainImage) {
        _mainImage = mainImage;

        if (_shoppingItemImageRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemImageRemoteModel.getClass();

                Method method = clazz.getMethod("setMainImage", boolean.class);

                method.invoke(_shoppingItemImageRemoteModel, mainImage);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getOrder() {
        return _order;
    }

    @Override
    public void setOrder(int order) {
        _order = order;

        if (_shoppingItemImageRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingItemImageRemoteModel.getClass();

                Method method = clazz.getMethod("setOrder", int.class);

                method.invoke(_shoppingItemImageRemoteModel, order);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getShoppingItemImageRemoteModel() {
        return _shoppingItemImageRemoteModel;
    }

    public void setShoppingItemImageRemoteModel(
        BaseModel<?> shoppingItemImageRemoteModel) {
        _shoppingItemImageRemoteModel = shoppingItemImageRemoteModel;
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

        Class<?> remoteModelClass = _shoppingItemImageRemoteModel.getClass();

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

        Object returnValue = method.invoke(_shoppingItemImageRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingItemImageLocalServiceUtil.addShoppingItemImage(this);
        } else {
            ShoppingItemImageLocalServiceUtil.updateShoppingItemImage(this);
        }
    }

    @Override
    public ShoppingItemImage toEscapedModel() {
        return (ShoppingItemImage) ProxyUtil.newProxyInstance(ShoppingItemImage.class.getClassLoader(),
            new Class[] { ShoppingItemImage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingItemImageClp clone = new ShoppingItemImageClp();

        clone.setShoppingItemImageId(getShoppingItemImageId());
        clone.setGroupId(getGroupId());
        clone.setItemId(getItemId());
        clone.setImageId(getImageId());
        clone.setMainImage(getMainImage());
        clone.setOrder(getOrder());

        return clone;
    }

    @Override
    public int compareTo(ShoppingItemImage shoppingItemImage) {
        long primaryKey = shoppingItemImage.getPrimaryKey();

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

        if (!(obj instanceof ShoppingItemImageClp)) {
            return false;
        }

        ShoppingItemImageClp shoppingItemImage = (ShoppingItemImageClp) obj;

        long primaryKey = shoppingItemImage.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{shoppingItemImageId=");
        sb.append(getShoppingItemImageId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", itemId=");
        sb.append(getItemId());
        sb.append(", imageId=");
        sb.append(getImageId());
        sb.append(", mainImage=");
        sb.append(getMainImage());
        sb.append(", order=");
        sb.append(getOrder());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingItemImage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>shoppingItemImageId</column-name><column-value><![CDATA[");
        sb.append(getShoppingItemImageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>itemId</column-name><column-value><![CDATA[");
        sb.append(getItemId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageId</column-name><column-value><![CDATA[");
        sb.append(getImageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mainImage</column-name><column-value><![CDATA[");
        sb.append(getMainImage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>order</column-name><column-value><![CDATA[");
        sb.append(getOrder());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
