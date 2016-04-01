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
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("price", getPrice());
        attributes.put("discountPrice", getDiscountPrice());
        attributes.put("sku", getSku());
        attributes.put("itemTypeId", getItemTypeId());
        attributes.put("status", getStatus());
        attributes.put("statusByUserId", getStatusByUserId());
        attributes.put("statusByUserName", getStatusByUserName());
        attributes.put("statusDate", getStatusDate());

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

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
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

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long statusByUserId = (Long) attributes.get("statusByUserId");

        if (statusByUserId != null) {
            setStatusByUserId(statusByUserId);
        }

        String statusByUserName = (String) attributes.get("statusByUserName");

        if (statusByUserName != null) {
            setStatusByUserName(statusByUserName);
        }

        Date statusDate = (Date) attributes.get("statusDate");

        if (statusDate != null) {
            setStatusDate(statusDate);
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
    * Returns the title of this shopping item.
    *
    * @return the title of this shopping item
    */
    @Override
    public java.lang.String getTitle() {
        return _shoppingItem.getTitle();
    }

    /**
    * Sets the title of this shopping item.
    *
    * @param title the title of this shopping item
    */
    @Override
    public void setTitle(java.lang.String title) {
        _shoppingItem.setTitle(title);
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

    /**
    * Returns the status of this shopping item.
    *
    * @return the status of this shopping item
    */
    @Override
    public int getStatus() {
        return _shoppingItem.getStatus();
    }

    /**
    * Sets the status of this shopping item.
    *
    * @param status the status of this shopping item
    */
    @Override
    public void setStatus(int status) {
        _shoppingItem.setStatus(status);
    }

    /**
    * Returns the status by user ID of this shopping item.
    *
    * @return the status by user ID of this shopping item
    */
    @Override
    public long getStatusByUserId() {
        return _shoppingItem.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this shopping item.
    *
    * @param statusByUserId the status by user ID of this shopping item
    */
    @Override
    public void setStatusByUserId(long statusByUserId) {
        _shoppingItem.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this shopping item.
    *
    * @return the status by user uuid of this shopping item
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingItem.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this shopping item.
    *
    * @param statusByUserUuid the status by user uuid of this shopping item
    */
    @Override
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _shoppingItem.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this shopping item.
    *
    * @return the status by user name of this shopping item
    */
    @Override
    public java.lang.String getStatusByUserName() {
        return _shoppingItem.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this shopping item.
    *
    * @param statusByUserName the status by user name of this shopping item
    */
    @Override
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _shoppingItem.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this shopping item.
    *
    * @return the status date of this shopping item
    */
    @Override
    public java.util.Date getStatusDate() {
        return _shoppingItem.getStatusDate();
    }

    /**
    * Sets the status date of this shopping item.
    *
    * @param statusDate the status date of this shopping item
    */
    @Override
    public void setStatusDate(java.util.Date statusDate) {
        _shoppingItem.setStatusDate(statusDate);
    }

    /**
    * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
    */
    @Override
    public boolean getApproved() {
        return _shoppingItem.getApproved();
    }

    /**
    * Returns <code>true</code> if this shopping item is approved.
    *
    * @return <code>true</code> if this shopping item is approved; <code>false</code> otherwise
    */
    @Override
    public boolean isApproved() {
        return _shoppingItem.isApproved();
    }

    /**
    * Returns <code>true</code> if this shopping item is denied.
    *
    * @return <code>true</code> if this shopping item is denied; <code>false</code> otherwise
    */
    @Override
    public boolean isDenied() {
        return _shoppingItem.isDenied();
    }

    /**
    * Returns <code>true</code> if this shopping item is a draft.
    *
    * @return <code>true</code> if this shopping item is a draft; <code>false</code> otherwise
    */
    @Override
    public boolean isDraft() {
        return _shoppingItem.isDraft();
    }

    /**
    * Returns <code>true</code> if this shopping item is expired.
    *
    * @return <code>true</code> if this shopping item is expired; <code>false</code> otherwise
    */
    @Override
    public boolean isExpired() {
        return _shoppingItem.isExpired();
    }

    /**
    * Returns <code>true</code> if this shopping item is inactive.
    *
    * @return <code>true</code> if this shopping item is inactive; <code>false</code> otherwise
    */
    @Override
    public boolean isInactive() {
        return _shoppingItem.isInactive();
    }

    /**
    * Returns <code>true</code> if this shopping item is incomplete.
    *
    * @return <code>true</code> if this shopping item is incomplete; <code>false</code> otherwise
    */
    @Override
    public boolean isIncomplete() {
        return _shoppingItem.isIncomplete();
    }

    /**
    * Returns <code>true</code> if this shopping item is pending.
    *
    * @return <code>true</code> if this shopping item is pending; <code>false</code> otherwise
    */
    @Override
    public boolean isPending() {
        return _shoppingItem.isPending();
    }

    /**
    * Returns <code>true</code> if this shopping item is scheduled.
    *
    * @return <code>true</code> if this shopping item is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isScheduled() {
        return _shoppingItem.isScheduled();
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
