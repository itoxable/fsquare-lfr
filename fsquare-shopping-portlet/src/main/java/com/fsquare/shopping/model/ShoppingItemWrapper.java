package com.fsquare.shopping.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItem
 * @generated
 */
public class ShoppingItemWrapper implements ShoppingItem,
    ModelWrapper<ShoppingItem> {
    private ShoppingItem _shoppingItem;

    public ShoppingItemWrapper(ShoppingItem shoppingItem) {
        _shoppingItem = shoppingItem;
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

    /**
    * Returns the primary key of this shopping item.
    *
    * @return the primary key of this shopping item
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingItem.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping item.
    *
    * @param primaryKey the primary key of this shopping item
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingItem.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this shopping item.
    *
    * @return the uuid of this shopping item
    */
    @Override
    public java.lang.String getUuid() {
        return _shoppingItem.getUuid();
    }

    /**
    * Sets the uuid of this shopping item.
    *
    * @param uuid the uuid of this shopping item
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _shoppingItem.setUuid(uuid);
    }

    /**
    * Returns the item ID of this shopping item.
    *
    * @return the item ID of this shopping item
    */
    @Override
    public long getItemId() {
        return _shoppingItem.getItemId();
    }

    /**
    * Sets the item ID of this shopping item.
    *
    * @param itemId the item ID of this shopping item
    */
    @Override
    public void setItemId(long itemId) {
        _shoppingItem.setItemId(itemId);
    }

    /**
    * Returns the group ID of this shopping item.
    *
    * @return the group ID of this shopping item
    */
    @Override
    public long getGroupId() {
        return _shoppingItem.getGroupId();
    }

    /**
    * Sets the group ID of this shopping item.
    *
    * @param groupId the group ID of this shopping item
    */
    @Override
    public void setGroupId(long groupId) {
        _shoppingItem.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this shopping item.
    *
    * @return the company ID of this shopping item
    */
    @Override
    public long getCompanyId() {
        return _shoppingItem.getCompanyId();
    }

    /**
    * Sets the company ID of this shopping item.
    *
    * @param companyId the company ID of this shopping item
    */
    @Override
    public void setCompanyId(long companyId) {
        _shoppingItem.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this shopping item.
    *
    * @return the user ID of this shopping item
    */
    @Override
    public long getUserId() {
        return _shoppingItem.getUserId();
    }

    /**
    * Sets the user ID of this shopping item.
    *
    * @param userId the user ID of this shopping item
    */
    @Override
    public void setUserId(long userId) {
        _shoppingItem.setUserId(userId);
    }

    /**
    * Returns the user uuid of this shopping item.
    *
    * @return the user uuid of this shopping item
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItem.getUserUuid();
    }

    /**
    * Sets the user uuid of this shopping item.
    *
    * @param userUuid the user uuid of this shopping item
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _shoppingItem.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this shopping item.
    *
    * @return the user name of this shopping item
    */
    @Override
    public java.lang.String getUserName() {
        return _shoppingItem.getUserName();
    }

    /**
    * Sets the user name of this shopping item.
    *
    * @param userName the user name of this shopping item
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _shoppingItem.setUserName(userName);
    }

    /**
    * Returns the create date of this shopping item.
    *
    * @return the create date of this shopping item
    */
    @Override
    public java.util.Date getCreateDate() {
        return _shoppingItem.getCreateDate();
    }

    /**
    * Sets the create date of this shopping item.
    *
    * @param createDate the create date of this shopping item
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _shoppingItem.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this shopping item.
    *
    * @return the modified date of this shopping item
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _shoppingItem.getModifiedDate();
    }

    /**
    * Sets the modified date of this shopping item.
    *
    * @param modifiedDate the modified date of this shopping item
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _shoppingItem.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the fully qualified class name of this shopping item.
    *
    * @return the fully qualified class name of this shopping item
    */
    @Override
    public java.lang.String getClassName() {
        return _shoppingItem.getClassName();
    }

    @Override
    public void setClassName(java.lang.String className) {
        _shoppingItem.setClassName(className);
    }

    /**
    * Returns the class name ID of this shopping item.
    *
    * @return the class name ID of this shopping item
    */
    @Override
    public long getClassNameId() {
        return _shoppingItem.getClassNameId();
    }

    /**
    * Sets the class name ID of this shopping item.
    *
    * @param classNameId the class name ID of this shopping item
    */
    @Override
    public void setClassNameId(long classNameId) {
        _shoppingItem.setClassNameId(classNameId);
    }

    /**
    * Returns the class p k of this shopping item.
    *
    * @return the class p k of this shopping item
    */
    @Override
    public long getClassPK() {
        return _shoppingItem.getClassPK();
    }

    /**
    * Sets the class p k of this shopping item.
    *
    * @param classPK the class p k of this shopping item
    */
    @Override
    public void setClassPK(long classPK) {
        _shoppingItem.setClassPK(classPK);
    }

    /**
    * Returns the name of this shopping item.
    *
    * @return the name of this shopping item
    */
    @Override
    public java.lang.String getName() {
        return _shoppingItem.getName();
    }

    /**
    * Sets the name of this shopping item.
    *
    * @param name the name of this shopping item
    */
    @Override
    public void setName(java.lang.String name) {
        _shoppingItem.setName(name);
    }

    /**
    * Returns the description of this shopping item.
    *
    * @return the description of this shopping item
    */
    @Override
    public java.lang.String getDescription() {
        return _shoppingItem.getDescription();
    }

    /**
    * Sets the description of this shopping item.
    *
    * @param description the description of this shopping item
    */
    @Override
    public void setDescription(java.lang.String description) {
        _shoppingItem.setDescription(description);
    }

    /**
    * Returns the price of this shopping item.
    *
    * @return the price of this shopping item
    */
    @Override
    public double getPrice() {
        return _shoppingItem.getPrice();
    }

    /**
    * Sets the price of this shopping item.
    *
    * @param price the price of this shopping item
    */
    @Override
    public void setPrice(double price) {
        _shoppingItem.setPrice(price);
    }

    /**
    * Returns the discount price of this shopping item.
    *
    * @return the discount price of this shopping item
    */
    @Override
    public double getDiscountPrice() {
        return _shoppingItem.getDiscountPrice();
    }

    /**
    * Sets the discount price of this shopping item.
    *
    * @param discountPrice the discount price of this shopping item
    */
    @Override
    public void setDiscountPrice(double discountPrice) {
        _shoppingItem.setDiscountPrice(discountPrice);
    }

    /**
    * Returns the sku of this shopping item.
    *
    * @return the sku of this shopping item
    */
    @Override
    public java.lang.String getSku() {
        return _shoppingItem.getSku();
    }

    /**
    * Sets the sku of this shopping item.
    *
    * @param sku the sku of this shopping item
    */
    @Override
    public void setSku(java.lang.String sku) {
        _shoppingItem.setSku(sku);
    }

    /**
    * Returns the item type ID of this shopping item.
    *
    * @return the item type ID of this shopping item
    */
    @Override
    public long getItemTypeId() {
        return _shoppingItem.getItemTypeId();
    }

    /**
    * Sets the item type ID of this shopping item.
    *
    * @param itemTypeId the item type ID of this shopping item
    */
    @Override
    public void setItemTypeId(long itemTypeId) {
        _shoppingItem.setItemTypeId(itemTypeId);
    }

    @Override
    public boolean isNew() {
        return _shoppingItem.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingItem.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingItem.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingItem.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingItem.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingItem.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingItem.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingItem.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingItem.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingItem.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingItem.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingItemWrapper((ShoppingItem) _shoppingItem.clone());
    }

    @Override
    public int compareTo(com.fsquare.shopping.model.ShoppingItem shoppingItem) {
        return _shoppingItem.compareTo(shoppingItem);
    }

    @Override
    public int hashCode() {
        return _shoppingItem.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingItem> toCacheModel() {
        return _shoppingItem.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItem toEscapedModel() {
        return new ShoppingItemWrapper(_shoppingItem.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingItem toUnescapedModel() {
        return new ShoppingItemWrapper(_shoppingItem.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingItem.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingItem.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingItem.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingItemWrapper)) {
            return false;
        }

        ShoppingItemWrapper shoppingItemWrapper = (ShoppingItemWrapper) obj;

        if (Validator.equals(_shoppingItem, shoppingItemWrapper._shoppingItem)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _shoppingItem.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingItem getWrappedShoppingItem() {
        return _shoppingItem;
    }

    @Override
    public ShoppingItem getWrappedModel() {
        return _shoppingItem;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingItem.resetOriginalValues();
    }
}
