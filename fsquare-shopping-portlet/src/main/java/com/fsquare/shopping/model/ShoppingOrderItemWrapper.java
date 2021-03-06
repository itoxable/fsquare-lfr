package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingOrderItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItem
 * @generated
 */
public class ShoppingOrderItemWrapper implements ShoppingOrderItem,
    ModelWrapper<ShoppingOrderItem> {
    private ShoppingOrderItem _shoppingOrderItem;

    public ShoppingOrderItemWrapper(ShoppingOrderItem shoppingOrderItem) {
        _shoppingOrderItem = shoppingOrderItem;
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

    /**
    * Returns the primary key of this shopping order item.
    *
    * @return the primary key of this shopping order item
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingOrderItem.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping order item.
    *
    * @param primaryKey the primary key of this shopping order item
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingOrderItem.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the shopping order item ID of this shopping order item.
    *
    * @return the shopping order item ID of this shopping order item
    */
    @Override
    public long getShoppingOrderItemId() {
        return _shoppingOrderItem.getShoppingOrderItemId();
    }

    /**
    * Sets the shopping order item ID of this shopping order item.
    *
    * @param shoppingOrderItemId the shopping order item ID of this shopping order item
    */
    @Override
    public void setShoppingOrderItemId(long shoppingOrderItemId) {
        _shoppingOrderItem.setShoppingOrderItemId(shoppingOrderItemId);
    }

    /**
    * Returns the shopping order ID of this shopping order item.
    *
    * @return the shopping order ID of this shopping order item
    */
    @Override
    public long getShoppingOrderId() {
        return _shoppingOrderItem.getShoppingOrderId();
    }

    /**
    * Sets the shopping order ID of this shopping order item.
    *
    * @param shoppingOrderId the shopping order ID of this shopping order item
    */
    @Override
    public void setShoppingOrderId(long shoppingOrderId) {
        _shoppingOrderItem.setShoppingOrderId(shoppingOrderId);
    }

    /**
    * Returns the article ID of this shopping order item.
    *
    * @return the article ID of this shopping order item
    */
    @Override
    public java.lang.String getArticleId() {
        return _shoppingOrderItem.getArticleId();
    }

    /**
    * Sets the article ID of this shopping order item.
    *
    * @param articleId the article ID of this shopping order item
    */
    @Override
    public void setArticleId(java.lang.String articleId) {
        _shoppingOrderItem.setArticleId(articleId);
    }

    /**
    * Returns the sku of this shopping order item.
    *
    * @return the sku of this shopping order item
    */
    @Override
    public java.lang.String getSku() {
        return _shoppingOrderItem.getSku();
    }

    /**
    * Sets the sku of this shopping order item.
    *
    * @param sku the sku of this shopping order item
    */
    @Override
    public void setSku(java.lang.String sku) {
        _shoppingOrderItem.setSku(sku);
    }

    /**
    * Returns the name of this shopping order item.
    *
    * @return the name of this shopping order item
    */
    @Override
    public java.lang.String getName() {
        return _shoppingOrderItem.getName();
    }

    /**
    * Sets the name of this shopping order item.
    *
    * @param name the name of this shopping order item
    */
    @Override
    public void setName(java.lang.String name) {
        _shoppingOrderItem.setName(name);
    }

    /**
    * Returns the description of this shopping order item.
    *
    * @return the description of this shopping order item
    */
    @Override
    public java.lang.String getDescription() {
        return _shoppingOrderItem.getDescription();
    }

    /**
    * Sets the description of this shopping order item.
    *
    * @param description the description of this shopping order item
    */
    @Override
    public void setDescription(java.lang.String description) {
        _shoppingOrderItem.setDescription(description);
    }

    /**
    * Returns the properties of this shopping order item.
    *
    * @return the properties of this shopping order item
    */
    @Override
    public java.lang.String getProperties() {
        return _shoppingOrderItem.getProperties();
    }

    /**
    * Sets the properties of this shopping order item.
    *
    * @param properties the properties of this shopping order item
    */
    @Override
    public void setProperties(java.lang.String properties) {
        _shoppingOrderItem.setProperties(properties);
    }

    /**
    * Returns the price of this shopping order item.
    *
    * @return the price of this shopping order item
    */
    @Override
    public double getPrice() {
        return _shoppingOrderItem.getPrice();
    }

    /**
    * Sets the price of this shopping order item.
    *
    * @param price the price of this shopping order item
    */
    @Override
    public void setPrice(double price) {
        _shoppingOrderItem.setPrice(price);
    }

    /**
    * Returns the quantity of this shopping order item.
    *
    * @return the quantity of this shopping order item
    */
    @Override
    public int getQuantity() {
        return _shoppingOrderItem.getQuantity();
    }

    /**
    * Sets the quantity of this shopping order item.
    *
    * @param quantity the quantity of this shopping order item
    */
    @Override
    public void setQuantity(int quantity) {
        _shoppingOrderItem.setQuantity(quantity);
    }

    /**
    * Returns the shipped date of this shopping order item.
    *
    * @return the shipped date of this shopping order item
    */
    @Override
    public java.util.Date getShippedDate() {
        return _shoppingOrderItem.getShippedDate();
    }

    /**
    * Sets the shipped date of this shopping order item.
    *
    * @param shippedDate the shipped date of this shopping order item
    */
    @Override
    public void setShippedDate(java.util.Date shippedDate) {
        _shoppingOrderItem.setShippedDate(shippedDate);
    }

    @Override
    public boolean isNew() {
        return _shoppingOrderItem.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingOrderItem.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingOrderItem.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingOrderItem.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingOrderItem.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingOrderItem.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingOrderItem.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingOrderItem.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingOrderItem.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingOrderItem.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingOrderItem.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingOrderItemWrapper((ShoppingOrderItem) _shoppingOrderItem.clone());
    }

    @Override
    public int compareTo(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem) {
        return _shoppingOrderItem.compareTo(shoppingOrderItem);
    }

    @Override
    public int hashCode() {
        return _shoppingOrderItem.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingOrderItem> toCacheModel() {
        return _shoppingOrderItem.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem toEscapedModel() {
        return new ShoppingOrderItemWrapper(_shoppingOrderItem.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingOrderItem toUnescapedModel() {
        return new ShoppingOrderItemWrapper(_shoppingOrderItem.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingOrderItem.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingOrderItem.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingOrderItem.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingOrderItemWrapper)) {
            return false;
        }

        ShoppingOrderItemWrapper shoppingOrderItemWrapper = (ShoppingOrderItemWrapper) obj;

        if (Validator.equals(_shoppingOrderItem,
                    shoppingOrderItemWrapper._shoppingOrderItem)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingOrderItem getWrappedShoppingOrderItem() {
        return _shoppingOrderItem;
    }

    @Override
    public ShoppingOrderItem getWrappedModel() {
        return _shoppingOrderItem;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingOrderItem.resetOriginalValues();
    }
}
