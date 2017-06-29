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
     * Returns the name of this shopping store.
     *
     * @return the name of this shopping store
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this shopping store.
     *
     * @param name the name of this shopping store
     */
    public void setName(String name);

    /**
     * Returns the default email address of this shopping store.
     *
     * @return the default email address of this shopping store
     */
    @AutoEscape
    public String getDefaultEmailAddress();

    /**
     * Sets the default email address of this shopping store.
     *
     * @param defaultEmailAddress the default email address of this shopping store
     */
    public void setDefaultEmailAddress(String defaultEmailAddress);

    /**
     * Returns the products main page uuid of this shopping store.
     *
     * @return the products main page uuid of this shopping store
     */
    @AutoEscape
    public String getProductsMainPageUuid();

    /**
     * Sets the products main page uuid of this shopping store.
     *
     * @param productsMainPageUuid the products main page uuid of this shopping store
     */
    public void setProductsMainPageUuid(String productsMainPageUuid);

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
     * Returns the checkout page fullscreen of this shopping store.
     *
     * @return the checkout page fullscreen of this shopping store
     */
    public boolean getCheckoutPageFullscreen();

    /**
     * Returns <code>true</code> if this shopping store is checkout page fullscreen.
     *
     * @return <code>true</code> if this shopping store is checkout page fullscreen; <code>false</code> otherwise
     */
    public boolean isCheckoutPageFullscreen();

    /**
     * Sets whether this shopping store is checkout page fullscreen.
     *
     * @param checkoutPageFullscreen the checkout page fullscreen of this shopping store
     */
    public void setCheckoutPageFullscreen(boolean checkoutPageFullscreen);

    /**
     * Returns the checkout complete page template of this shopping store.
     *
     * @return the checkout complete page template of this shopping store
     */
    @AutoEscape
    public String getCheckoutCompletePageTemplate();

    /**
     * Sets the checkout complete page template of this shopping store.
     *
     * @param checkoutCompletePageTemplate the checkout complete page template of this shopping store
     */
    public void setCheckoutCompletePageTemplate(
        String checkoutCompletePageTemplate);

    /**
     * Returns the order created email template of this shopping store.
     *
     * @return the order created email template of this shopping store
     */
    @AutoEscape
    public String getOrderCreatedEmailTemplate();

    /**
     * Sets the order created email template of this shopping store.
     *
     * @param orderCreatedEmailTemplate the order created email template of this shopping store
     */
    public void setOrderCreatedEmailTemplate(String orderCreatedEmailTemplate);

    /**
     * Returns the order shipped email template of this shopping store.
     *
     * @return the order shipped email template of this shopping store
     */
    @AutoEscape
    public String getOrderShippedEmailTemplate();

    /**
     * Sets the order shipped email template of this shopping store.
     *
     * @param orderShippedEmailTemplate the order shipped email template of this shopping store
     */
    public void setOrderShippedEmailTemplate(String orderShippedEmailTemplate);

    /**
     * Returns the order created email subject of this shopping store.
     *
     * @return the order created email subject of this shopping store
     */
    @AutoEscape
    public String getOrderCreatedEmailSubject();

    /**
     * Sets the order created email subject of this shopping store.
     *
     * @param orderCreatedEmailSubject the order created email subject of this shopping store
     */
    public void setOrderCreatedEmailSubject(String orderCreatedEmailSubject);

    /**
     * Returns the order created email from address of this shopping store.
     *
     * @return the order created email from address of this shopping store
     */
    @AutoEscape
    public String getOrderCreatedEmailFromAddress();

    /**
     * Sets the order created email from address of this shopping store.
     *
     * @param orderCreatedEmailFromAddress the order created email from address of this shopping store
     */
    public void setOrderCreatedEmailFromAddress(
        String orderCreatedEmailFromAddress);

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

    /**
     * Returns the integrate with braintree of this shopping store.
     *
     * @return the integrate with braintree of this shopping store
     */
    public boolean getIntegrateWithBraintree();

    /**
     * Returns <code>true</code> if this shopping store is integrate with braintree.
     *
     * @return <code>true</code> if this shopping store is integrate with braintree; <code>false</code> otherwise
     */
    public boolean isIntegrateWithBraintree();

    /**
     * Sets whether this shopping store is integrate with braintree.
     *
     * @param integrateWithBraintree the integrate with braintree of this shopping store
     */
    public void setIntegrateWithBraintree(boolean integrateWithBraintree);

    /**
     * Returns the braintree private key of this shopping store.
     *
     * @return the braintree private key of this shopping store
     */
    @AutoEscape
    public String getBraintreePrivateKey();

    /**
     * Sets the braintree private key of this shopping store.
     *
     * @param braintreePrivateKey the braintree private key of this shopping store
     */
    public void setBraintreePrivateKey(String braintreePrivateKey);

    /**
     * Returns the braintree public key of this shopping store.
     *
     * @return the braintree public key of this shopping store
     */
    @AutoEscape
    public String getBraintreePublicKey();

    /**
     * Sets the braintree public key of this shopping store.
     *
     * @param braintreePublicKey the braintree public key of this shopping store
     */
    public void setBraintreePublicKey(String braintreePublicKey);

    /**
     * Returns the braintree merchant ID of this shopping store.
     *
     * @return the braintree merchant ID of this shopping store
     */
    @AutoEscape
    public String getBraintreeMerchantId();

    /**
     * Sets the braintree merchant ID of this shopping store.
     *
     * @param braintreeMerchantId the braintree merchant ID of this shopping store
     */
    public void setBraintreeMerchantId(String braintreeMerchantId);

    /**
     * Returns the use braintree sandbox of this shopping store.
     *
     * @return the use braintree sandbox of this shopping store
     */
    public boolean getUseBraintreeSandbox();

    /**
     * Returns <code>true</code> if this shopping store is use braintree sandbox.
     *
     * @return <code>true</code> if this shopping store is use braintree sandbox; <code>false</code> otherwise
     */
    public boolean isUseBraintreeSandbox();

    /**
     * Sets whether this shopping store is use braintree sandbox.
     *
     * @param useBraintreeSandbox the use braintree sandbox of this shopping store
     */
    public void setUseBraintreeSandbox(boolean useBraintreeSandbox);

    /**
     * Returns the braintree sandbox merchant ID of this shopping store.
     *
     * @return the braintree sandbox merchant ID of this shopping store
     */
    @AutoEscape
    public String getBraintreeSandboxMerchantId();

    /**
     * Sets the braintree sandbox merchant ID of this shopping store.
     *
     * @param braintreeSandboxMerchantId the braintree sandbox merchant ID of this shopping store
     */
    public void setBraintreeSandboxMerchantId(String braintreeSandboxMerchantId);

    /**
     * Returns the braintree sandbox private key of this shopping store.
     *
     * @return the braintree sandbox private key of this shopping store
     */
    @AutoEscape
    public String getBraintreeSandboxPrivateKey();

    /**
     * Sets the braintree sandbox private key of this shopping store.
     *
     * @param braintreeSandboxPrivateKey the braintree sandbox private key of this shopping store
     */
    public void setBraintreeSandboxPrivateKey(String braintreeSandboxPrivateKey);

    /**
     * Returns the braintree sandbox public key of this shopping store.
     *
     * @return the braintree sandbox public key of this shopping store
     */
    @AutoEscape
    public String getBraintreeSandboxPublicKey();

    /**
     * Sets the braintree sandbox public key of this shopping store.
     *
     * @param braintreeSandboxPublicKey the braintree sandbox public key of this shopping store
     */
    public void setBraintreeSandboxPublicKey(String braintreeSandboxPublicKey);

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
