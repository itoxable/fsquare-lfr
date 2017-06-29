package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingItemStorageLocation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocation
 * @generated
 */
public class ShoppingItemStorageLocationWrapper
    implements ShoppingItemStorageLocation,
        ModelWrapper<ShoppingItemStorageLocation> {
    private ShoppingItemStorageLocation _shoppingItemStorageLocation;

    public ShoppingItemStorageLocationWrapper(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        _shoppingItemStorageLocation = shoppingItemStorageLocation;
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
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("itemStorageLocationId", getItemStorageLocationId());
        attributes.put("itemId", getItemId());
        attributes.put("storageLocationId", getStorageLocationId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("quantity", getQuantity());

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
    }

    /**
    * Returns the primary key of this shopping item storage location.
    *
    * @return the primary key of this shopping item storage location
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingItemStorageLocation.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping item storage location.
    *
    * @param primaryKey the primary key of this shopping item storage location
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingItemStorageLocation.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the item storage location ID of this shopping item storage location.
    *
    * @return the item storage location ID of this shopping item storage location
    */
    @Override
    public long getItemStorageLocationId() {
        return _shoppingItemStorageLocation.getItemStorageLocationId();
    }

    /**
    * Sets the item storage location ID of this shopping item storage location.
    *
    * @param itemStorageLocationId the item storage location ID of this shopping item storage location
    */
    @Override
    public void setItemStorageLocationId(long itemStorageLocationId) {
        _shoppingItemStorageLocation.setItemStorageLocationId(itemStorageLocationId);
    }

    /**
    * Returns the item ID of this shopping item storage location.
    *
    * @return the item ID of this shopping item storage location
    */
    @Override
    public long getItemId() {
        return _shoppingItemStorageLocation.getItemId();
    }

    /**
    * Sets the item ID of this shopping item storage location.
    *
    * @param itemId the item ID of this shopping item storage location
    */
    @Override
    public void setItemId(long itemId) {
        _shoppingItemStorageLocation.setItemId(itemId);
    }

    /**
    * Returns the storage location ID of this shopping item storage location.
    *
    * @return the storage location ID of this shopping item storage location
    */
    @Override
    public long getStorageLocationId() {
        return _shoppingItemStorageLocation.getStorageLocationId();
    }

    /**
    * Sets the storage location ID of this shopping item storage location.
    *
    * @param storageLocationId the storage location ID of this shopping item storage location
    */
    @Override
    public void setStorageLocationId(long storageLocationId) {
        _shoppingItemStorageLocation.setStorageLocationId(storageLocationId);
    }

    /**
    * Returns the company ID of this shopping item storage location.
    *
    * @return the company ID of this shopping item storage location
    */
    @Override
    public long getCompanyId() {
        return _shoppingItemStorageLocation.getCompanyId();
    }

    /**
    * Sets the company ID of this shopping item storage location.
    *
    * @param companyId the company ID of this shopping item storage location
    */
    @Override
    public void setCompanyId(long companyId) {
        _shoppingItemStorageLocation.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this shopping item storage location.
    *
    * @return the user ID of this shopping item storage location
    */
    @Override
    public long getUserId() {
        return _shoppingItemStorageLocation.getUserId();
    }

    /**
    * Sets the user ID of this shopping item storage location.
    *
    * @param userId the user ID of this shopping item storage location
    */
    @Override
    public void setUserId(long userId) {
        _shoppingItemStorageLocation.setUserId(userId);
    }

    /**
    * Returns the user uuid of this shopping item storage location.
    *
    * @return the user uuid of this shopping item storage location
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemStorageLocation.getUserUuid();
    }

    /**
    * Sets the user uuid of this shopping item storage location.
    *
    * @param userUuid the user uuid of this shopping item storage location
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _shoppingItemStorageLocation.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this shopping item storage location.
    *
    * @return the user name of this shopping item storage location
    */
    @Override
    public java.lang.String getUserName() {
        return _shoppingItemStorageLocation.getUserName();
    }

    /**
    * Sets the user name of this shopping item storage location.
    *
    * @param userName the user name of this shopping item storage location
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _shoppingItemStorageLocation.setUserName(userName);
    }

    /**
    * Returns the create date of this shopping item storage location.
    *
    * @return the create date of this shopping item storage location
    */
    @Override
    public java.util.Date getCreateDate() {
        return _shoppingItemStorageLocation.getCreateDate();
    }

    /**
    * Sets the create date of this shopping item storage location.
    *
    * @param createDate the create date of this shopping item storage location
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _shoppingItemStorageLocation.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this shopping item storage location.
    *
    * @return the modified date of this shopping item storage location
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _shoppingItemStorageLocation.getModifiedDate();
    }

    /**
    * Sets the modified date of this shopping item storage location.
    *
    * @param modifiedDate the modified date of this shopping item storage location
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _shoppingItemStorageLocation.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this shopping item storage location.
    *
    * @return the name of this shopping item storage location
    */
    @Override
    public java.lang.String getName() {
        return _shoppingItemStorageLocation.getName();
    }

    /**
    * Sets the name of this shopping item storage location.
    *
    * @param name the name of this shopping item storage location
    */
    @Override
    public void setName(java.lang.String name) {
        _shoppingItemStorageLocation.setName(name);
    }

    /**
    * Returns the quantity of this shopping item storage location.
    *
    * @return the quantity of this shopping item storage location
    */
    @Override
    public int getQuantity() {
        return _shoppingItemStorageLocation.getQuantity();
    }

    /**
    * Sets the quantity of this shopping item storage location.
    *
    * @param quantity the quantity of this shopping item storage location
    */
    @Override
    public void setQuantity(int quantity) {
        _shoppingItemStorageLocation.setQuantity(quantity);
    }

    @Override
    public boolean isNew() {
        return _shoppingItemStorageLocation.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingItemStorageLocation.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingItemStorageLocation.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingItemStorageLocation.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingItemStorageLocation.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingItemStorageLocation.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingItemStorageLocation.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingItemStorageLocation.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingItemStorageLocation.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingItemStorageLocation.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingItemStorageLocation.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingItemStorageLocationWrapper((ShoppingItemStorageLocation) _shoppingItemStorageLocation.clone());
    }

    @Override
    public int compareTo(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation) {
        return _shoppingItemStorageLocation.compareTo(shoppingItemStorageLocation);
    }

    @Override
    public int hashCode() {
        return _shoppingItemStorageLocation.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingItemStorageLocation> toCacheModel() {
        return _shoppingItemStorageLocation.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation toEscapedModel() {
        return new ShoppingItemStorageLocationWrapper(_shoppingItemStorageLocation.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemStorageLocation toUnescapedModel() {
        return new ShoppingItemStorageLocationWrapper(_shoppingItemStorageLocation.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingItemStorageLocation.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingItemStorageLocation.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingItemStorageLocation.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingItemStorageLocationWrapper)) {
            return false;
        }

        ShoppingItemStorageLocationWrapper shoppingItemStorageLocationWrapper = (ShoppingItemStorageLocationWrapper) obj;

        if (Validator.equals(_shoppingItemStorageLocation,
                    shoppingItemStorageLocationWrapper._shoppingItemStorageLocation)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingItemStorageLocation getWrappedShoppingItemStorageLocation() {
        return _shoppingItemStorageLocation;
    }

    @Override
    public ShoppingItemStorageLocation getWrappedModel() {
        return _shoppingItemStorageLocation;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingItemStorageLocation.resetOriginalValues();
    }
}
