package com.fsquare.shopping.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ShoppingStore service. Represents a row in the &quot;FsquareShopping_ShoppingStore&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsquare.shopping.model.impl.ShoppingStoreImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStore
 * @see com.fsquare.shopping.model.impl.ShoppingStoreImpl
 * @see com.fsquare.shopping.model.impl.ShoppingStoreModelImpl
 * @generated
 */
public interface ShoppingStoreModel extends AuditedModel,
    BaseModel<ShoppingStore> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a shopping store model instance should use the {@link ShoppingStore} interface instead.
     */

    /**
     * Returns the primary key of this shopping store.
     *
     * @return the primary key of this shopping store
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this shopping store.
     *
     * @param primaryKey the primary key of this shopping store
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the group ID of this shopping store.
     *
     * @return the group ID of this shopping store
     */
    public long getGroupId();

    /**
     * Sets the group ID of this shopping store.
     *
     * @param groupId the group ID of this shopping store
     */
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this shopping store.
     *
     * @return the company ID of this shopping store
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this shopping store.
     *
     * @param companyId the company ID of this shopping store
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this shopping store.
     *
     * @return the user ID of this shopping store
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this shopping store.
     *
     * @param userId the user ID of this shopping store
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this shopping store.
     *
     * @return the user uuid of this shopping store
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this shopping store.
     *
     * @param userUuid the user uuid of this shopping store
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this shopping store.
     *
     * @return the user name of this shopping store
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this shopping store.
     *
     * @param userName the user name of this shopping store
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this shopping store.
     *
     * @return the create date of this shopping store
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this shopping store.
     *
     * @param createDate the create date of this shopping store
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this shopping store.
     *
     * @return the modified date of this shopping store
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this shopping store.
     *
     * @param modifiedDate the modified date of this shopping store
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the cart page uuid of this shopping store.
     *
     * @return the cart page uuid of this shopping store
     */
    @AutoEscape
    public String getCartPageUuid();

    /**
     * Sets the cart page uuid of this shopping store.
     *
     * @param cartPageUuid the cart page uuid of this shopping store
     */
    public void setCartPageUuid(String cartPageUuid);

    /**
     * Returns the checkout page uuid of this shopping store.
     *
     * @return the checkout page uuid of this shopping store
     */
    @AutoEscape
    public String getCheckoutPageUuid();

    /**
     * Sets the checkout page uuid of this shopping store.
     *
     * @param checkoutPageUuid the checkout page uuid of this shopping store
     */
    public void setCheckoutPageUuid(String checkoutPageUuid);

    /**
     * Returns the on add to cart of this shopping store.
     *
     * @return the on add to cart of this shopping store
     */
    @AutoEscape
    public String getOnAddToCart();

    /**
     * Sets the on add to cart of this shopping store.
     *
     * @param onAddToCart the on add to cart of this shopping store
     */
    public void setOnAddToCart(String onAddToCart);

    /**
     * Returns the currency of this shopping store.
     *
     * @return the currency of this shopping store
     */
    @AutoEscape
    public String getCurrency();

    /**
     * Sets the currency of this shopping store.
     *
     * @param currency the currency of this shopping store
     */
    public void setCurrency(String currency);

    /**
     * Returns the country of this shopping store.
     *
     * @return the country of this shopping store
     */
    @AutoEscape
    public String getCountry();

    /**
     * Sets the country of this shopping store.
     *
     * @param country the country of this shopping store
     */
    public void setCountry(String country);

    /**
     * Returns the user types of this shopping store.
     *
     * @return the user types of this shopping store
     */
    @AutoEscape
    public String getUserTypes();

    /**
     * Sets the user types of this shopping store.
     *
     * @param userTypes the user types of this shopping store
     */
    public void setUserTypes(String userTypes);

    /**
     * Returns the integrate with stripe of this shopping store.
     *
     * @return the integrate with stripe of this shopping store
     */
    public boolean getIntegrateWithStripe();

    /**
     * Returns <code>true</code> if this shopping store is integrate with stripe.
     *
     * @return <code>true</code> if this shopping store is integrate with stripe; <code>false</code> otherwise
     */
    public boolean isIntegrateWithStripe();

    /**
     * Sets whether this shopping store is integrate with stripe.
     *
     * @param integrateWithStripe the integrate with stripe of this shopping store
     */
    public void setIntegrateWithStripe(boolean integrateWithStripe);

    /**
     * Returns the stripe test secret key of this shopping store.
     *
     * @return the stripe test secret key of this shopping store
     */
    @AutoEscape
    public String getStripeTestSecretKey();

    /**
     * Sets the stripe test secret key of this shopping store.
     *
     * @param stripeTestSecretKey the stripe test secret key of this shopping store
     */
    public void setStripeTestSecretKey(String stripeTestSecretKey);

    /**
     * Returns the stripe test publishable key of this shopping store.
     *
     * @return the stripe test publishable key of this shopping store
     */
    @AutoEscape
    public String getStripeTestPublishableKey();

    /**
     * Sets the stripe test publishable key of this shopping store.
     *
     * @param stripeTestPublishableKey the stripe test publishable key of this shopping store
     */
    public void setStripeTestPublishableKey(String stripeTestPublishableKey);

    /**
     * Returns the stripe testing of this shopping store.
     *
     * @return the stripe testing of this shopping store
     */
    public boolean getStripeTesting();

    /**
     * Returns <code>true</code> if this shopping store is stripe testing.
     *
     * @return <code>true</code> if this shopping store is stripe testing; <code>false</code> otherwise
     */
    public boolean isStripeTesting();

    /**
     * Sets whether this shopping store is stripe testing.
     *
     * @param stripeTesting the stripe testing of this shopping store
     */
    public void setStripeTesting(boolean stripeTesting);

    /**
     * Returns the stripe live secret key of this shopping store.
     *
     * @return the stripe live secret key of this shopping store
     */
    @AutoEscape
    public String getStripeLiveSecretKey();

    /**
     * Sets the stripe live secret key of this shopping store.
     *
     * @param stripeLiveSecretKey the stripe live secret key of this shopping store
     */
    public void setStripeLiveSecretKey(String stripeLiveSecretKey);

    /**
     * Returns the stripe live publishable key of this shopping store.
     *
     * @return the stripe live publishable key of this shopping store
     */
    @AutoEscape
    public String getStripeLivePublishableKey();

    /**
     * Sets the stripe live publishable key of this shopping store.
     *
     * @param stripeLivePublishableKey the stripe live publishable key of this shopping store
     */
    public void setStripeLivePublishableKey(String stripeLivePublishableKey);

    /**
     * Returns the stripe api version of this shopping store.
     *
     * @return the stripe api version of this shopping store
     */
    @AutoEscape
    public String getStripeApiVersion();

    /**
     * Sets the stripe api version of this shopping store.
     *
     * @param stripeApiVersion the stripe api version of this shopping store
     */
    public void setStripeApiVersion(String stripeApiVersion);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.fsquare.shopping.model.ShoppingStore shoppingStore);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.fsquare.shopping.model.ShoppingStore> toCacheModel();

    @Override
    public com.fsquare.shopping.model.ShoppingStore toEscapedModel();

    @Override
    public com.fsquare.shopping.model.ShoppingStore toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
