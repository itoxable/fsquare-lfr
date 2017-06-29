package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingItemType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemType
 * @generated
 */
public class ShoppingItemTypeWrapper implements ShoppingItemType,
    ModelWrapper<ShoppingItemType> {
    private ShoppingItemType _shoppingItemType;

    public ShoppingItemTypeWrapper(ShoppingItemType shoppingItemType) {
        _shoppingItemType = shoppingItemType;
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingItemType.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingItemType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("itemTypeId", getItemTypeId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long itemTypeId = (Long) attributes.get("itemTypeId");

        if (itemTypeId != null) {
            setItemTypeId(itemTypeId);
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
    }

    /**
    * Returns the primary key of this shopping item type.
    *
    * @return the primary key of this shopping item type
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingItemType.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping item type.
    *
    * @param primaryKey the primary key of this shopping item type
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingItemType.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the item type ID of this shopping item type.
    *
    * @return the item type ID of this shopping item type
    */
    @Override
    public long getItemTypeId() {
        return _shoppingItemType.getItemTypeId();
    }

    /**
    * Sets the item type ID of this shopping item type.
    *
    * @param itemTypeId the item type ID of this shopping item type
    */
    @Override
    public void setItemTypeId(long itemTypeId) {
        _shoppingItemType.setItemTypeId(itemTypeId);
    }

    /**
    * Returns the company ID of this shopping item type.
    *
    * @return the company ID of this shopping item type
    */
    @Override
    public long getCompanyId() {
        return _shoppingItemType.getCompanyId();
    }

    /**
    * Sets the company ID of this shopping item type.
    *
    * @param companyId the company ID of this shopping item type
    */
    @Override
    public void setCompanyId(long companyId) {
        _shoppingItemType.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this shopping item type.
    *
    * @return the user ID of this shopping item type
    */
    @Override
    public long getUserId() {
        return _shoppingItemType.getUserId();
    }

    /**
    * Sets the user ID of this shopping item type.
    *
    * @param userId the user ID of this shopping item type
    */
    @Override
    public void setUserId(long userId) {
        _shoppingItemType.setUserId(userId);
    }

    /**
    * Returns the user uuid of this shopping item type.
    *
    * @return the user uuid of this shopping item type
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItemType.getUserUuid();
    }

    /**
    * Sets the user uuid of this shopping item type.
    *
    * @param userUuid the user uuid of this shopping item type
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _shoppingItemType.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this shopping item type.
    *
    * @return the user name of this shopping item type
    */
    @Override
    public java.lang.String getUserName() {
        return _shoppingItemType.getUserName();
    }

    /**
    * Sets the user name of this shopping item type.
    *
    * @param userName the user name of this shopping item type
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _shoppingItemType.setUserName(userName);
    }

    /**
    * Returns the create date of this shopping item type.
    *
    * @return the create date of this shopping item type
    */
    @Override
    public java.util.Date getCreateDate() {
        return _shoppingItemType.getCreateDate();
    }

    /**
    * Sets the create date of this shopping item type.
    *
    * @param createDate the create date of this shopping item type
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _shoppingItemType.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this shopping item type.
    *
    * @return the modified date of this shopping item type
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _shoppingItemType.getModifiedDate();
    }

    /**
    * Sets the modified date of this shopping item type.
    *
    * @param modifiedDate the modified date of this shopping item type
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _shoppingItemType.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this shopping item type.
    *
    * @return the name of this shopping item type
    */
    @Override
    public java.lang.String getName() {
        return _shoppingItemType.getName();
    }

    /**
    * Sets the name of this shopping item type.
    *
    * @param name the name of this shopping item type
    */
    @Override
    public void setName(java.lang.String name) {
        _shoppingItemType.setName(name);
    }

    /**
    * Returns the description of this shopping item type.
    *
    * @return the description of this shopping item type
    */
    @Override
    public java.lang.String getDescription() {
        return _shoppingItemType.getDescription();
    }

    /**
    * Sets the description of this shopping item type.
    *
    * @param description the description of this shopping item type
    */
    @Override
    public void setDescription(java.lang.String description) {
        _shoppingItemType.setDescription(description);
    }

    @Override
    public boolean isNew() {
        return _shoppingItemType.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingItemType.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingItemType.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingItemType.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingItemType.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingItemType.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingItemType.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingItemType.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingItemType.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingItemType.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingItemType.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingItemTypeWrapper((ShoppingItemType) _shoppingItemType.clone());
    }

    @Override
    public int compareTo(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType) {
        return _shoppingItemType.compareTo(shoppingItemType);
    }

    @Override
    public int hashCode() {
        return _shoppingItemType.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingItemType> toCacheModel() {
        return _shoppingItemType.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemType toEscapedModel() {
        return new ShoppingItemTypeWrapper(_shoppingItemType.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItemType toUnescapedModel() {
        return new ShoppingItemTypeWrapper(_shoppingItemType.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingItemType.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingItemType.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingItemType.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingItemTypeWrapper)) {
            return false;
        }

        ShoppingItemTypeWrapper shoppingItemTypeWrapper = (ShoppingItemTypeWrapper) obj;

        if (Validator.equals(_shoppingItemType,
                    shoppingItemTypeWrapper._shoppingItemType)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingItemType getWrappedShoppingItemType() {
        return _shoppingItemType;
    }

    @Override
    public ShoppingItemType getWrappedModel() {
        return _shoppingItemType;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingItemType.resetOriginalValues();
    }
}
