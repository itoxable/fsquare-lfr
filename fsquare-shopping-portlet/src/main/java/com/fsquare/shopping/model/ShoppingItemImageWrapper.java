package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingItemImage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemImage
 * @generated
 */
public class ShoppingItemImageWrapper implements ShoppingItemImage,
    ModelWrapper<ShoppingItemImage> {
    private ShoppingItemImage _shoppingItemImage;

    public ShoppingItemImageWrapper(ShoppingItemImage shoppingItemImage) {
        _shoppingItemImage = shoppingItemImage;
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

    /**
    * Returns the primary key of this shopping item image.
    *
    * @return the primary key of this shopping item image
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingItemImage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping item image.
    *
    * @param primaryKey the primary key of this shopping item image
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingItemImage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the shopping item image ID of this shopping item image.
    *
    * @return the shopping item image ID of this shopping item image
    */
    @Override
    public long getShoppingItemImageId() {
        return _shoppingItemImage.getShoppingItemImageId();
    }

    /**
    * Sets the shopping item image ID of this shopping item image.
    *
    * @param shoppingItemImageId the shopping item image ID of this shopping item image
    */
    @Override
    public void setShoppingItemImageId(long shoppingItemImageId) {
        _shoppingItemImage.setShoppingItemImageId(shoppingItemImageId);
    }

    /**
    * Returns the group ID of this shopping item image.
    *
    * @return the group ID of this shopping item image
    */
    @Override
    public long getGroupId() {
        return _shoppingItemImage.getGroupId();
    }

    /**
    * Sets the group ID of this shopping item image.
    *
    * @param groupId the group ID of this shopping item image
    */
    @Override
    public void setGroupId(long groupId) {
        _shoppingItemImage.setGroupId(groupId);
    }

    /**
    * Returns the item ID of this shopping item image.
    *
    * @return the item ID of this shopping item image
    */
    @Override
    public long getItemId() {
        return _shoppingItemImage.getItemId();
    }

    /**
    * Sets the item ID of this shopping item image.
    *
    * @param itemId the item ID of this shopping item image
    */
    @Override
    public void setItemId(long itemId) {
        _shoppingItemImage.setItemId(itemId);
    }

    /**
    * Returns the image ID of this shopping item image.
    *
    * @return the image ID of this shopping item image
    */
    @Override
    public long getImageId() {
        return _shoppingItemImage.getImageId();
    }

    /**
    * Sets the image ID of this shopping item image.
    *
    * @param imageId the image ID of this shopping item image
    */
    @Override
    public void setImageId(long imageId) {
        _shoppingItemImage.setImageId(imageId);
    }

    /**
    * Returns the main image of this shopping item image.
    *
    * @return the main image of this shopping item image
    */
    @Override
    public boolean getMainImage() {
        return _shoppingItemImage.getMainImage();
    }

    /**
    * Returns <code>true</code> if this shopping item image is main image.
    *
    * @return <code>true</code> if this shopping item image is main image; <code>false</code> otherwise
    */
    @Override
    public boolean isMainImage() {
        return _shoppingItemImage.isMainImage();
    }

    /**
    * Sets whether this shopping item image is main image.
    *
    * @param mainImage the main image of this shopping item image
    */
    @Override
    public void setMainImage(boolean mainImage) {
        _shoppingItemImage.setMainImage(mainImage);
    }

    /**
    * Returns the order of this shopping item image.
    *
    * @return the order of this shopping item image
    */
    @Override
    public int getOrder() {
        return _shoppingItemImage.getOrder();
    }

    /**
    * Sets the order of this shopping item image.
    *
    * @param order the order of this shopping item image
    */
    @Override
    public void setOrder(int order) {
        _shoppingItemImage.setOrder(order);
    }

    @Override
    public boolean isNew() {
        return _shoppingItemImage.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingItemImage.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingItemImage.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingItemImage.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingItemImage.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingItemImage.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingItemImage.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingItemImage.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingItemImage.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingItemImage.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingItemImage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingItemImageWrapper((ShoppingItemImage) _shoppingItemImage.clone());
    }

    @Override
    public int compareTo(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage) {
        return _shoppingItemImage.compareTo(shoppingItemImage);
    }

    @Override
    public int hashCode() {
        return _shoppingItemImage.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingItemImage> toCacheModel() {
        return _shoppingItemImage.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemImage toEscapedModel() {
        return new ShoppingItemImageWrapper(_shoppingItemImage.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemImage toUnescapedModel() {
        return new ShoppingItemImageWrapper(_shoppingItemImage.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingItemImage.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingItemImage.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingItemImage.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingItemImageWrapper)) {
            return false;
        }

        ShoppingItemImageWrapper shoppingItemImageWrapper = (ShoppingItemImageWrapper) obj;

        if (Validator.equals(_shoppingItemImage,
                    shoppingItemImageWrapper._shoppingItemImage)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingItemImage getWrappedShoppingItemImage() {
        return _shoppingItemImage;
    }

    @Override
    public ShoppingItemImage getWrappedModel() {
        return _shoppingItemImage;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingItemImage.resetOriginalValues();
    }
}
