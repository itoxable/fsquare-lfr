package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingStorageLocation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorageLocation
 * @generated
 */
public class ShoppingStorageLocationWrapper implements ShoppingStorageLocation,
    ModelWrapper<ShoppingStorageLocation> {
    private ShoppingStorageLocation _shoppingStorageLocation;

    public ShoppingStorageLocationWrapper(
        ShoppingStorageLocation shoppingStorageLocation) {
        _shoppingStorageLocation = shoppingStorageLocation;
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

    /**
    * Returns the primary key of this shopping storage location.
    *
    * @return the primary key of this shopping storage location
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingStorageLocation.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping storage location.
    *
    * @param primaryKey the primary key of this shopping storage location
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingStorageLocation.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the storage location ID of this shopping storage location.
    *
    * @return the storage location ID of this shopping storage location
    */
    @Override
    public long getStorageLocationId() {
        return _shoppingStorageLocation.getStorageLocationId();
    }

    /**
    * Sets the storage location ID of this shopping storage location.
    *
    * @param storageLocationId the storage location ID of this shopping storage location
    */
    @Override
    public void setStorageLocationId(long storageLocationId) {
        _shoppingStorageLocation.setStorageLocationId(storageLocationId);
    }

    /**
    * Returns the company ID of this shopping storage location.
    *
    * @return the company ID of this shopping storage location
    */
    @Override
    public long getCompanyId() {
        return _shoppingStorageLocation.getCompanyId();
    }

    /**
    * Sets the company ID of this shopping storage location.
    *
    * @param companyId the company ID of this shopping storage location
    */
    @Override
    public void setCompanyId(long companyId) {
        _shoppingStorageLocation.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this shopping storage location.
    *
    * @return the user ID of this shopping storage location
    */
    @Override
    public long getUserId() {
        return _shoppingStorageLocation.getUserId();
    }

    /**
    * Sets the user ID of this shopping storage location.
    *
    * @param userId the user ID of this shopping storage location
    */
    @Override
    public void setUserId(long userId) {
        _shoppingStorageLocation.setUserId(userId);
    }

    /**
    * Returns the user uuid of this shopping storage location.
    *
    * @return the user uuid of this shopping storage location
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStorageLocation.getUserUuid();
    }

    /**
    * Sets the user uuid of this shopping storage location.
    *
    * @param userUuid the user uuid of this shopping storage location
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _shoppingStorageLocation.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this shopping storage location.
    *
    * @return the user name of this shopping storage location
    */
    @Override
    public java.lang.String getUserName() {
        return _shoppingStorageLocation.getUserName();
    }

    /**
    * Sets the user name of this shopping storage location.
    *
    * @param userName the user name of this shopping storage location
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _shoppingStorageLocation.setUserName(userName);
    }

    /**
    * Returns the create date of this shopping storage location.
    *
    * @return the create date of this shopping storage location
    */
    @Override
    public java.util.Date getCreateDate() {
        return _shoppingStorageLocation.getCreateDate();
    }

    /**
    * Sets the create date of this shopping storage location.
    *
    * @param createDate the create date of this shopping storage location
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _shoppingStorageLocation.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this shopping storage location.
    *
    * @return the modified date of this shopping storage location
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _shoppingStorageLocation.getModifiedDate();
    }

    /**
    * Sets the modified date of this shopping storage location.
    *
    * @param modifiedDate the modified date of this shopping storage location
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _shoppingStorageLocation.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this shopping storage location.
    *
    * @return the name of this shopping storage location
    */
    @Override
    public java.lang.String getName() {
        return _shoppingStorageLocation.getName();
    }

    /**
    * Sets the name of this shopping storage location.
    *
    * @param name the name of this shopping storage location
    */
    @Override
    public void setName(java.lang.String name) {
        _shoppingStorageLocation.setName(name);
    }

    /**
    * Returns the description of this shopping storage location.
    *
    * @return the description of this shopping storage location
    */
    @Override
    public java.lang.String getDescription() {
        return _shoppingStorageLocation.getDescription();
    }

    /**
    * Sets the description of this shopping storage location.
    *
    * @param description the description of this shopping storage location
    */
    @Override
    public void setDescription(java.lang.String description) {
        _shoppingStorageLocation.setDescription(description);
    }

    /**
    * Returns the location of this shopping storage location.
    *
    * @return the location of this shopping storage location
    */
    @Override
    public java.lang.String getLocation() {
        return _shoppingStorageLocation.getLocation();
    }

    /**
    * Sets the location of this shopping storage location.
    *
    * @param location the location of this shopping storage location
    */
    @Override
    public void setLocation(java.lang.String location) {
        _shoppingStorageLocation.setLocation(location);
    }

    @Override
    public boolean isNew() {
        return _shoppingStorageLocation.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingStorageLocation.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingStorageLocation.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingStorageLocation.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingStorageLocation.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingStorageLocation.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingStorageLocation.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingStorageLocation.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingStorageLocation.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingStorageLocation.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingStorageLocation.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingStorageLocationWrapper((ShoppingStorageLocation) _shoppingStorageLocation.clone());
    }

    @Override
    public int compareTo(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation) {
        return _shoppingStorageLocation.compareTo(shoppingStorageLocation);
    }

    @Override
    public int hashCode() {
        return _shoppingStorageLocation.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingStorageLocation> toCacheModel() {
        return _shoppingStorageLocation.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation toEscapedModel() {
        return new ShoppingStorageLocationWrapper(_shoppingStorageLocation.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStorageLocation toUnescapedModel() {
        return new ShoppingStorageLocationWrapper(_shoppingStorageLocation.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingStorageLocation.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingStorageLocation.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingStorageLocation.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingStorageLocationWrapper)) {
            return false;
        }

        ShoppingStorageLocationWrapper shoppingStorageLocationWrapper = (ShoppingStorageLocationWrapper) obj;

        if (Validator.equals(_shoppingStorageLocation,
                    shoppingStorageLocationWrapper._shoppingStorageLocation)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingStorageLocation getWrappedShoppingStorageLocation() {
        return _shoppingStorageLocation;
    }

    @Override
    public ShoppingStorageLocation getWrappedModel() {
        return _shoppingStorageLocation;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingStorageLocation.resetOriginalValues();
    }
}
