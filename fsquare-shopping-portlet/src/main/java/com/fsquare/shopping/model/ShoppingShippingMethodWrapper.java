package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingShippingMethod}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethod
 * @generated
 */
public class ShoppingShippingMethodWrapper implements ShoppingShippingMethod,
    ModelWrapper<ShoppingShippingMethod> {
    private ShoppingShippingMethod _shoppingShippingMethod;

    public ShoppingShippingMethodWrapper(
        ShoppingShippingMethod shoppingShippingMethod) {
        _shoppingShippingMethod = shoppingShippingMethod;
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingShippingMethod.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingShippingMethod.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("shippingMethodId", getShippingMethodId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("price", getPrice());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("freeQuantity", getFreeQuantity());
        attributes.put("freeTotal", getFreeTotal());
        attributes.put("weight", getWeight());
        attributes.put("defaultShipping", getDefaultShipping());
        attributes.put("international", getInternational());
        attributes.put("disabled", getDisabled());
        attributes.put("shippingType", getShippingType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long shippingMethodId = (Long) attributes.get("shippingMethodId");

        if (shippingMethodId != null) {
            setShippingMethodId(shippingMethodId);
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

        Double price = (Double) attributes.get("price");

        if (price != null) {
            setPrice(price);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long freeQuantity = (Long) attributes.get("freeQuantity");

        if (freeQuantity != null) {
            setFreeQuantity(freeQuantity);
        }

        Double freeTotal = (Double) attributes.get("freeTotal");

        if (freeTotal != null) {
            setFreeTotal(freeTotal);
        }

        Double weight = (Double) attributes.get("weight");

        if (weight != null) {
            setWeight(weight);
        }

        Boolean defaultShipping = (Boolean) attributes.get("defaultShipping");

        if (defaultShipping != null) {
            setDefaultShipping(defaultShipping);
        }

        Boolean international = (Boolean) attributes.get("international");

        if (international != null) {
            setInternational(international);
        }

        Boolean disabled = (Boolean) attributes.get("disabled");

        if (disabled != null) {
            setDisabled(disabled);
        }

        String shippingType = (String) attributes.get("shippingType");

        if (shippingType != null) {
            setShippingType(shippingType);
        }
    }

    /**
    * Returns the primary key of this shopping shipping method.
    *
    * @return the primary key of this shopping shipping method
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingShippingMethod.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping shipping method.
    *
    * @param primaryKey the primary key of this shopping shipping method
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingShippingMethod.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the shipping method ID of this shopping shipping method.
    *
    * @return the shipping method ID of this shopping shipping method
    */
    @Override
    public long getShippingMethodId() {
        return _shoppingShippingMethod.getShippingMethodId();
    }

    /**
    * Sets the shipping method ID of this shopping shipping method.
    *
    * @param shippingMethodId the shipping method ID of this shopping shipping method
    */
    @Override
    public void setShippingMethodId(long shippingMethodId) {
        _shoppingShippingMethod.setShippingMethodId(shippingMethodId);
    }

    /**
    * Returns the company ID of this shopping shipping method.
    *
    * @return the company ID of this shopping shipping method
    */
    @Override
    public long getCompanyId() {
        return _shoppingShippingMethod.getCompanyId();
    }

    /**
    * Sets the company ID of this shopping shipping method.
    *
    * @param companyId the company ID of this shopping shipping method
    */
    @Override
    public void setCompanyId(long companyId) {
        _shoppingShippingMethod.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this shopping shipping method.
    *
    * @return the user ID of this shopping shipping method
    */
    @Override
    public long getUserId() {
        return _shoppingShippingMethod.getUserId();
    }

    /**
    * Sets the user ID of this shopping shipping method.
    *
    * @param userId the user ID of this shopping shipping method
    */
    @Override
    public void setUserId(long userId) {
        _shoppingShippingMethod.setUserId(userId);
    }

    /**
    * Returns the user uuid of this shopping shipping method.
    *
    * @return the user uuid of this shopping shipping method
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingShippingMethod.getUserUuid();
    }

    /**
    * Sets the user uuid of this shopping shipping method.
    *
    * @param userUuid the user uuid of this shopping shipping method
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _shoppingShippingMethod.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this shopping shipping method.
    *
    * @return the user name of this shopping shipping method
    */
    @Override
    public java.lang.String getUserName() {
        return _shoppingShippingMethod.getUserName();
    }

    /**
    * Sets the user name of this shopping shipping method.
    *
    * @param userName the user name of this shopping shipping method
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _shoppingShippingMethod.setUserName(userName);
    }

    /**
    * Returns the create date of this shopping shipping method.
    *
    * @return the create date of this shopping shipping method
    */
    @Override
    public java.util.Date getCreateDate() {
        return _shoppingShippingMethod.getCreateDate();
    }

    /**
    * Sets the create date of this shopping shipping method.
    *
    * @param createDate the create date of this shopping shipping method
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _shoppingShippingMethod.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this shopping shipping method.
    *
    * @return the modified date of this shopping shipping method
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _shoppingShippingMethod.getModifiedDate();
    }

    /**
    * Sets the modified date of this shopping shipping method.
    *
    * @param modifiedDate the modified date of this shopping shipping method
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _shoppingShippingMethod.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the price of this shopping shipping method.
    *
    * @return the price of this shopping shipping method
    */
    @Override
    public double getPrice() {
        return _shoppingShippingMethod.getPrice();
    }

    /**
    * Sets the price of this shopping shipping method.
    *
    * @param price the price of this shopping shipping method
    */
    @Override
    public void setPrice(double price) {
        _shoppingShippingMethod.setPrice(price);
    }

    /**
    * Returns the name of this shopping shipping method.
    *
    * @return the name of this shopping shipping method
    */
    @Override
    public java.lang.String getName() {
        return _shoppingShippingMethod.getName();
    }

    /**
    * Sets the name of this shopping shipping method.
    *
    * @param name the name of this shopping shipping method
    */
    @Override
    public void setName(java.lang.String name) {
        _shoppingShippingMethod.setName(name);
    }

    /**
    * Returns the description of this shopping shipping method.
    *
    * @return the description of this shopping shipping method
    */
    @Override
    public java.lang.String getDescription() {
        return _shoppingShippingMethod.getDescription();
    }

    /**
    * Sets the description of this shopping shipping method.
    *
    * @param description the description of this shopping shipping method
    */
    @Override
    public void setDescription(java.lang.String description) {
        _shoppingShippingMethod.setDescription(description);
    }

    /**
    * Returns the free quantity of this shopping shipping method.
    *
    * @return the free quantity of this shopping shipping method
    */
    @Override
    public long getFreeQuantity() {
        return _shoppingShippingMethod.getFreeQuantity();
    }

    /**
    * Sets the free quantity of this shopping shipping method.
    *
    * @param freeQuantity the free quantity of this shopping shipping method
    */
    @Override
    public void setFreeQuantity(long freeQuantity) {
        _shoppingShippingMethod.setFreeQuantity(freeQuantity);
    }

    /**
    * Returns the free total of this shopping shipping method.
    *
    * @return the free total of this shopping shipping method
    */
    @Override
    public double getFreeTotal() {
        return _shoppingShippingMethod.getFreeTotal();
    }

    /**
    * Sets the free total of this shopping shipping method.
    *
    * @param freeTotal the free total of this shopping shipping method
    */
    @Override
    public void setFreeTotal(double freeTotal) {
        _shoppingShippingMethod.setFreeTotal(freeTotal);
    }

    /**
    * Returns the weight of this shopping shipping method.
    *
    * @return the weight of this shopping shipping method
    */
    @Override
    public double getWeight() {
        return _shoppingShippingMethod.getWeight();
    }

    /**
    * Sets the weight of this shopping shipping method.
    *
    * @param weight the weight of this shopping shipping method
    */
    @Override
    public void setWeight(double weight) {
        _shoppingShippingMethod.setWeight(weight);
    }

    /**
    * Returns the default shipping of this shopping shipping method.
    *
    * @return the default shipping of this shopping shipping method
    */
    @Override
    public boolean getDefaultShipping() {
        return _shoppingShippingMethod.getDefaultShipping();
    }

    /**
    * Returns <code>true</code> if this shopping shipping method is default shipping.
    *
    * @return <code>true</code> if this shopping shipping method is default shipping; <code>false</code> otherwise
    */
    @Override
    public boolean isDefaultShipping() {
        return _shoppingShippingMethod.isDefaultShipping();
    }

    /**
    * Sets whether this shopping shipping method is default shipping.
    *
    * @param defaultShipping the default shipping of this shopping shipping method
    */
    @Override
    public void setDefaultShipping(boolean defaultShipping) {
        _shoppingShippingMethod.setDefaultShipping(defaultShipping);
    }

    /**
    * Returns the international of this shopping shipping method.
    *
    * @return the international of this shopping shipping method
    */
    @Override
    public boolean getInternational() {
        return _shoppingShippingMethod.getInternational();
    }

    /**
    * Returns <code>true</code> if this shopping shipping method is international.
    *
    * @return <code>true</code> if this shopping shipping method is international; <code>false</code> otherwise
    */
    @Override
    public boolean isInternational() {
        return _shoppingShippingMethod.isInternational();
    }

    /**
    * Sets whether this shopping shipping method is international.
    *
    * @param international the international of this shopping shipping method
    */
    @Override
    public void setInternational(boolean international) {
        _shoppingShippingMethod.setInternational(international);
    }

    /**
    * Returns the disabled of this shopping shipping method.
    *
    * @return the disabled of this shopping shipping method
    */
    @Override
    public boolean getDisabled() {
        return _shoppingShippingMethod.getDisabled();
    }

    /**
    * Returns <code>true</code> if this shopping shipping method is disabled.
    *
    * @return <code>true</code> if this shopping shipping method is disabled; <code>false</code> otherwise
    */
    @Override
    public boolean isDisabled() {
        return _shoppingShippingMethod.isDisabled();
    }

    /**
    * Sets whether this shopping shipping method is disabled.
    *
    * @param disabled the disabled of this shopping shipping method
    */
    @Override
    public void setDisabled(boolean disabled) {
        _shoppingShippingMethod.setDisabled(disabled);
    }

    /**
    * Returns the shipping type of this shopping shipping method.
    *
    * @return the shipping type of this shopping shipping method
    */
    @Override
    public java.lang.String getShippingType() {
        return _shoppingShippingMethod.getShippingType();
    }

    /**
    * Sets the shipping type of this shopping shipping method.
    *
    * @param shippingType the shipping type of this shopping shipping method
    */
    @Override
    public void setShippingType(java.lang.String shippingType) {
        _shoppingShippingMethod.setShippingType(shippingType);
    }

    @Override
    public boolean isNew() {
        return _shoppingShippingMethod.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingShippingMethod.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingShippingMethod.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingShippingMethod.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingShippingMethod.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingShippingMethod.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingShippingMethod.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingShippingMethod.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingShippingMethod.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingShippingMethod.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingShippingMethod.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingShippingMethodWrapper((ShoppingShippingMethod) _shoppingShippingMethod.clone());
    }

    @Override
    public int compareTo(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod) {
        return _shoppingShippingMethod.compareTo(shoppingShippingMethod);
    }

    @Override
    public int hashCode() {
        return _shoppingShippingMethod.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingShippingMethod> toCacheModel() {
        return _shoppingShippingMethod.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod toEscapedModel() {
        return new ShoppingShippingMethodWrapper(_shoppingShippingMethod.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod toUnescapedModel() {
        return new ShoppingShippingMethodWrapper(_shoppingShippingMethod.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingShippingMethod.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingShippingMethod.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingShippingMethod.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingShippingMethodWrapper)) {
            return false;
        }

        ShoppingShippingMethodWrapper shoppingShippingMethodWrapper = (ShoppingShippingMethodWrapper) obj;

        if (Validator.equals(_shoppingShippingMethod,
                    shoppingShippingMethodWrapper._shoppingShippingMethod)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingShippingMethod getWrappedShoppingShippingMethod() {
        return _shoppingShippingMethod;
    }

    @Override
    public ShoppingShippingMethod getWrappedModel() {
        return _shoppingShippingMethod;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingShippingMethod.resetOriginalValues();
    }
}
