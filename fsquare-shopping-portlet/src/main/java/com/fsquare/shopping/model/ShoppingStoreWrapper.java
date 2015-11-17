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
        attributes.put("country", getCountry());
        attributes.put("userTypes", getUserTypes());
        attributes.put("integrateWithStripe", getIntegrateWithStripe());
        attributes.put("stripeTestSecretKey", getStripeTestSecretKey());
        attributes.put("stripeTestPublishableKey", getStripeTestPublishableKey());
        attributes.put("stripeTesting", getStripeTesting());
        attributes.put("stripeLiveSecretKey", getStripeLiveSecretKey());
        attributes.put("stripeLivePublishableKey", getStripeLivePublishableKey());
        attributes.put("stripeApiVersion", getStripeApiVersion());

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

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }

        String userTypes = (String) attributes.get("userTypes");

        if (userTypes != null) {
            setUserTypes(userTypes);
        }

        Boolean integrateWithStripe = (Boolean) attributes.get(
                "integrateWithStripe");

        if (integrateWithStripe != null) {
            setIntegrateWithStripe(integrateWithStripe);
        }

        String stripeTestSecretKey = (String) attributes.get(
                "stripeTestSecretKey");

        if (stripeTestSecretKey != null) {
            setStripeTestSecretKey(stripeTestSecretKey);
        }

        String stripeTestPublishableKey = (String) attributes.get(
                "stripeTestPublishableKey");

        if (stripeTestPublishableKey != null) {
            setStripeTestPublishableKey(stripeTestPublishableKey);
        }

        Boolean stripeTesting = (Boolean) attributes.get("stripeTesting");

        if (stripeTesting != null) {
            setStripeTesting(stripeTesting);
        }

        String stripeLiveSecretKey = (String) attributes.get(
                "stripeLiveSecretKey");

        if (stripeLiveSecretKey != null) {
            setStripeLiveSecretKey(stripeLiveSecretKey);
        }

        String stripeLivePublishableKey = (String) attributes.get(
                "stripeLivePublishableKey");

        if (stripeLivePublishableKey != null) {
            setStripeLivePublishableKey(stripeLivePublishableKey);
        }

        String stripeApiVersion = (String) attributes.get("stripeApiVersion");

        if (stripeApiVersion != null) {
            setStripeApiVersion(stripeApiVersion);
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

    /**
    * Returns the country of this shopping store.
    *
    * @return the country of this shopping store
    */
    @Override
    public java.lang.String getCountry() {
        return _shoppingStore.getCountry();
    }

    /**
    * Sets the country of this shopping store.
    *
    * @param country the country of this shopping store
    */
    @Override
    public void setCountry(java.lang.String country) {
        _shoppingStore.setCountry(country);
    }

    /**
    * Returns the user types of this shopping store.
    *
    * @return the user types of this shopping store
    */
    @Override
    public java.lang.String getUserTypes() {
        return _shoppingStore.getUserTypes();
    }

    /**
    * Sets the user types of this shopping store.
    *
    * @param userTypes the user types of this shopping store
    */
    @Override
    public void setUserTypes(java.lang.String userTypes) {
        _shoppingStore.setUserTypes(userTypes);
    }

    /**
    * Returns the integrate with stripe of this shopping store.
    *
    * @return the integrate with stripe of this shopping store
    */
    @Override
    public boolean getIntegrateWithStripe() {
        return _shoppingStore.getIntegrateWithStripe();
    }

    /**
    * Returns <code>true</code> if this shopping store is integrate with stripe.
    *
    * @return <code>true</code> if this shopping store is integrate with stripe; <code>false</code> otherwise
    */
    @Override
    public boolean isIntegrateWithStripe() {
        return _shoppingStore.isIntegrateWithStripe();
    }

    /**
    * Sets whether this shopping store is integrate with stripe.
    *
    * @param integrateWithStripe the integrate with stripe of this shopping store
    */
    @Override
    public void setIntegrateWithStripe(boolean integrateWithStripe) {
        _shoppingStore.setIntegrateWithStripe(integrateWithStripe);
    }

    /**
    * Returns the stripe test secret key of this shopping store.
    *
    * @return the stripe test secret key of this shopping store
    */
    @Override
    public java.lang.String getStripeTestSecretKey() {
        return _shoppingStore.getStripeTestSecretKey();
    }

    /**
    * Sets the stripe test secret key of this shopping store.
    *
    * @param stripeTestSecretKey the stripe test secret key of this shopping store
    */
    @Override
    public void setStripeTestSecretKey(java.lang.String stripeTestSecretKey) {
        _shoppingStore.setStripeTestSecretKey(stripeTestSecretKey);
    }

    /**
    * Returns the stripe test publishable key of this shopping store.
    *
    * @return the stripe test publishable key of this shopping store
    */
    @Override
    public java.lang.String getStripeTestPublishableKey() {
        return _shoppingStore.getStripeTestPublishableKey();
    }

    /**
    * Sets the stripe test publishable key of this shopping store.
    *
    * @param stripeTestPublishableKey the stripe test publishable key of this shopping store
    */
    @Override
    public void setStripeTestPublishableKey(
        java.lang.String stripeTestPublishableKey) {
        _shoppingStore.setStripeTestPublishableKey(stripeTestPublishableKey);
    }

    /**
    * Returns the stripe testing of this shopping store.
    *
    * @return the stripe testing of this shopping store
    */
    @Override
    public boolean getStripeTesting() {
        return _shoppingStore.getStripeTesting();
    }

    /**
    * Returns <code>true</code> if this shopping store is stripe testing.
    *
    * @return <code>true</code> if this shopping store is stripe testing; <code>false</code> otherwise
    */
    @Override
    public boolean isStripeTesting() {
        return _shoppingStore.isStripeTesting();
    }

    /**
    * Sets whether this shopping store is stripe testing.
    *
    * @param stripeTesting the stripe testing of this shopping store
    */
    @Override
    public void setStripeTesting(boolean stripeTesting) {
        _shoppingStore.setStripeTesting(stripeTesting);
    }

    /**
    * Returns the stripe live secret key of this shopping store.
    *
    * @return the stripe live secret key of this shopping store
    */
    @Override
    public java.lang.String getStripeLiveSecretKey() {
        return _shoppingStore.getStripeLiveSecretKey();
    }

    /**
    * Sets the stripe live secret key of this shopping store.
    *
    * @param stripeLiveSecretKey the stripe live secret key of this shopping store
    */
    @Override
    public void setStripeLiveSecretKey(java.lang.String stripeLiveSecretKey) {
        _shoppingStore.setStripeLiveSecretKey(stripeLiveSecretKey);
    }

    /**
    * Returns the stripe live publishable key of this shopping store.
    *
    * @return the stripe live publishable key of this shopping store
    */
    @Override
    public java.lang.String getStripeLivePublishableKey() {
        return _shoppingStore.getStripeLivePublishableKey();
    }

    /**
    * Sets the stripe live publishable key of this shopping store.
    *
    * @param stripeLivePublishableKey the stripe live publishable key of this shopping store
    */
    @Override
    public void setStripeLivePublishableKey(
        java.lang.String stripeLivePublishableKey) {
        _shoppingStore.setStripeLivePublishableKey(stripeLivePublishableKey);
    }

    /**
    * Returns the stripe api version of this shopping store.
    *
    * @return the stripe api version of this shopping store
    */
    @Override
    public java.lang.String getStripeApiVersion() {
        return _shoppingStore.getStripeApiVersion();
    }

    /**
    * Sets the stripe api version of this shopping store.
    *
    * @param stripeApiVersion the stripe api version of this shopping store
    */
    @Override
    public void setStripeApiVersion(java.lang.String stripeApiVersion) {
        _shoppingStore.setStripeApiVersion(stripeApiVersion);
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
