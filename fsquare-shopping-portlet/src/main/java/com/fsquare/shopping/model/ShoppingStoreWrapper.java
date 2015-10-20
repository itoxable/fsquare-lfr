package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingStore}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStore
 * @generated
 */
public class ShoppingStoreWrapper implements ShoppingStore,
    ModelWrapper<ShoppingStore> {
    private ShoppingStore _shoppingStore;

    public ShoppingStoreWrapper(ShoppingStore shoppingStore) {
        _shoppingStore = shoppingStore;
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingStore.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingStore.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("cartPageUuid", getCartPageUuid());
        attributes.put("checkoutPageUuid", getCheckoutPageUuid());
        attributes.put("onAddToCart", getOnAddToCart());
        attributes.put("currency", getCurrency());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
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

        String cartPageUuid = (String) attributes.get("cartPageUuid");

        if (cartPageUuid != null) {
            setCartPageUuid(cartPageUuid);
        }

        String checkoutPageUuid = (String) attributes.get("checkoutPageUuid");

        if (checkoutPageUuid != null) {
            setCheckoutPageUuid(checkoutPageUuid);
        }

        String onAddToCart = (String) attributes.get("onAddToCart");

        if (onAddToCart != null) {
            setOnAddToCart(onAddToCart);
        }

        String currency = (String) attributes.get("currency");

        if (currency != null) {
            setCurrency(currency);
        }
    }

    /**
    * Returns the primary key of this shopping store.
    *
    * @return the primary key of this shopping store
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingStore.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping store.
    *
    * @param primaryKey the primary key of this shopping store
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingStore.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the group ID of this shopping store.
    *
    * @return the group ID of this shopping store
    */
    @Override
    public long getGroupId() {
        return _shoppingStore.getGroupId();
    }

    /**
    * Sets the group ID of this shopping store.
    *
    * @param groupId the group ID of this shopping store
    */
    @Override
    public void setGroupId(long groupId) {
        _shoppingStore.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this shopping store.
    *
    * @return the company ID of this shopping store
    */
    @Override
    public long getCompanyId() {
        return _shoppingStore.getCompanyId();
    }

    /**
    * Sets the company ID of this shopping store.
    *
    * @param companyId the company ID of this shopping store
    */
    @Override
    public void setCompanyId(long companyId) {
        _shoppingStore.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this shopping store.
    *
    * @return the user ID of this shopping store
    */
    @Override
    public long getUserId() {
        return _shoppingStore.getUserId();
    }

    /**
    * Sets the user ID of this shopping store.
    *
    * @param userId the user ID of this shopping store
    */
    @Override
    public void setUserId(long userId) {
        _shoppingStore.setUserId(userId);
    }

    /**
    * Returns the user uuid of this shopping store.
    *
    * @return the user uuid of this shopping store
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingStore.getUserUuid();
    }

    /**
    * Sets the user uuid of this shopping store.
    *
    * @param userUuid the user uuid of this shopping store
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _shoppingStore.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this shopping store.
    *
    * @return the user name of this shopping store
    */
    @Override
    public java.lang.String getUserName() {
        return _shoppingStore.getUserName();
    }

    /**
    * Sets the user name of this shopping store.
    *
    * @param userName the user name of this shopping store
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _shoppingStore.setUserName(userName);
    }

    /**
    * Returns the create date of this shopping store.
    *
    * @return the create date of this shopping store
    */
    @Override
    public java.util.Date getCreateDate() {
        return _shoppingStore.getCreateDate();
    }

    /**
    * Sets the create date of this shopping store.
    *
    * @param createDate the create date of this shopping store
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _shoppingStore.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this shopping store.
    *
    * @return the modified date of this shopping store
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _shoppingStore.getModifiedDate();
    }

    /**
    * Sets the modified date of this shopping store.
    *
    * @param modifiedDate the modified date of this shopping store
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _shoppingStore.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the cart page uuid of this shopping store.
    *
    * @return the cart page uuid of this shopping store
    */
    @Override
    public java.lang.String getCartPageUuid() {
        return _shoppingStore.getCartPageUuid();
    }

    /**
    * Sets the cart page uuid of this shopping store.
    *
    * @param cartPageUuid the cart page uuid of this shopping store
    */
    @Override
    public void setCartPageUuid(java.lang.String cartPageUuid) {
        _shoppingStore.setCartPageUuid(cartPageUuid);
    }

    /**
    * Returns the checkout page uuid of this shopping store.
    *
    * @return the checkout page uuid of this shopping store
    */
    @Override
    public java.lang.String getCheckoutPageUuid() {
        return _shoppingStore.getCheckoutPageUuid();
    }

    /**
    * Sets the checkout page uuid of this shopping store.
    *
    * @param checkoutPageUuid the checkout page uuid of this shopping store
    */
    @Override
    public void setCheckoutPageUuid(java.lang.String checkoutPageUuid) {
        _shoppingStore.setCheckoutPageUuid(checkoutPageUuid);
    }

    /**
    * Returns the on add to cart of this shopping store.
    *
    * @return the on add to cart of this shopping store
    */
    @Override
    public java.lang.String getOnAddToCart() {
        return _shoppingStore.getOnAddToCart();
    }

    /**
    * Sets the on add to cart of this shopping store.
    *
    * @param onAddToCart the on add to cart of this shopping store
    */
    @Override
    public void setOnAddToCart(java.lang.String onAddToCart) {
        _shoppingStore.setOnAddToCart(onAddToCart);
    }

    /**
    * Returns the currency of this shopping store.
    *
    * @return the currency of this shopping store
    */
    @Override
    public java.lang.String getCurrency() {
        return _shoppingStore.getCurrency();
    }

    /**
    * Sets the currency of this shopping store.
    *
    * @param currency the currency of this shopping store
    */
    @Override
    public void setCurrency(java.lang.String currency) {
        _shoppingStore.setCurrency(currency);
    }

    @Override
    public boolean isNew() {
        return _shoppingStore.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingStore.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingStore.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingStore.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingStore.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingStore.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingStore.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingStore.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingStore.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingStore.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingStore.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingStoreWrapper((ShoppingStore) _shoppingStore.clone());
    }

    @Override
    public int compareTo(com.fsquare.shopping.model.ShoppingStore shoppingStore) {
        return _shoppingStore.compareTo(shoppingStore);
    }

    @Override
    public int hashCode() {
        return _shoppingStore.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingStore> toCacheModel() {
        return _shoppingStore.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStore toEscapedModel() {
        return new ShoppingStoreWrapper(_shoppingStore.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingStore toUnescapedModel() {
        return new ShoppingStoreWrapper(_shoppingStore.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingStore.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingStore.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingStore.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingStoreWrapper)) {
            return false;
        }

        ShoppingStoreWrapper shoppingStoreWrapper = (ShoppingStoreWrapper) obj;

        if (Validator.equals(_shoppingStore, shoppingStoreWrapper._shoppingStore)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingStore getWrappedShoppingStore() {
        return _shoppingStore;
    }

    @Override
    public ShoppingStore getWrappedModel() {
        return _shoppingStore;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingStore.resetOriginalValues();
    }
}
