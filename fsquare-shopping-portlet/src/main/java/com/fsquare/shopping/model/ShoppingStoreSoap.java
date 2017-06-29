package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingStoreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingStoreServiceSoap
 * @generated
 */
public class ShoppingStoreSoap implements Serializable {
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _defaultEmailAddress;
    private String _productsMainPageUuid;
    private String _cartPageUuid;
    private String _checkoutPageUuid;
    private String _onAddToCart;
    private String _currency;
    private String _country;
    private String _userTypes;
    private boolean _checkoutPageFullscreen;
    private String _checkoutCompletePageTemplate;
    private String _orderCreatedEmailTemplate;
    private String _orderShippedEmailTemplate;
    private String _orderCreatedEmailSubject;
    private String _orderCreatedEmailFromAddress;
    private boolean _integrateWithStripe;
    private String _stripeTestSecretKey;
    private String _stripeTestPublishableKey;
    private boolean _stripeTesting;
    private String _stripeLiveSecretKey;
    private String _stripeLivePublishableKey;
    private String _stripeApiVersion;
    private boolean _integrateWithBraintree;
    private String _braintreePrivateKey;
    private String _braintreePublicKey;
    private String _braintreeMerchantId;
    private boolean _useBraintreeSandbox;
    private String _braintreeSandboxMerchantId;
    private String _braintreeSandboxPrivateKey;
    private String _braintreeSandboxPublicKey;

    public ShoppingStoreSoap() {
    }

    public static ShoppingStoreSoap toSoapModel(ShoppingStore model) {
        ShoppingStoreSoap soapModel = new ShoppingStoreSoap();

        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDefaultEmailAddress(model.getDefaultEmailAddress());
        soapModel.setProductsMainPageUuid(model.getProductsMainPageUuid());
        soapModel.setCartPageUuid(model.getCartPageUuid());
        soapModel.setCheckoutPageUuid(model.getCheckoutPageUuid());
        soapModel.setOnAddToCart(model.getOnAddToCart());
        soapModel.setCurrency(model.getCurrency());
        soapModel.setCountry(model.getCountry());
        soapModel.setUserTypes(model.getUserTypes());
        soapModel.setCheckoutPageFullscreen(model.getCheckoutPageFullscreen());
        soapModel.setCheckoutCompletePageTemplate(model.getCheckoutCompletePageTemplate());
        soapModel.setOrderCreatedEmailTemplate(model.getOrderCreatedEmailTemplate());
        soapModel.setOrderShippedEmailTemplate(model.getOrderShippedEmailTemplate());
        soapModel.setOrderCreatedEmailSubject(model.getOrderCreatedEmailSubject());
        soapModel.setOrderCreatedEmailFromAddress(model.getOrderCreatedEmailFromAddress());
        soapModel.setIntegrateWithStripe(model.getIntegrateWithStripe());
        soapModel.setStripeTestSecretKey(model.getStripeTestSecretKey());
        soapModel.setStripeTestPublishableKey(model.getStripeTestPublishableKey());
        soapModel.setStripeTesting(model.getStripeTesting());
        soapModel.setStripeLiveSecretKey(model.getStripeLiveSecretKey());
        soapModel.setStripeLivePublishableKey(model.getStripeLivePublishableKey());
        soapModel.setStripeApiVersion(model.getStripeApiVersion());
        soapModel.setIntegrateWithBraintree(model.getIntegrateWithBraintree());
        soapModel.setBraintreePrivateKey(model.getBraintreePrivateKey());
        soapModel.setBraintreePublicKey(model.getBraintreePublicKey());
        soapModel.setBraintreeMerchantId(model.getBraintreeMerchantId());
        soapModel.setUseBraintreeSandbox(model.getUseBraintreeSandbox());
        soapModel.setBraintreeSandboxMerchantId(model.getBraintreeSandboxMerchantId());
        soapModel.setBraintreeSandboxPrivateKey(model.getBraintreeSandboxPrivateKey());
        soapModel.setBraintreeSandboxPublicKey(model.getBraintreeSandboxPublicKey());

        return soapModel;
    }

    public static ShoppingStoreSoap[] toSoapModels(ShoppingStore[] models) {
        ShoppingStoreSoap[] soapModels = new ShoppingStoreSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingStoreSoap[][] toSoapModels(ShoppingStore[][] models) {
        ShoppingStoreSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingStoreSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingStoreSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingStoreSoap[] toSoapModels(List<ShoppingStore> models) {
        List<ShoppingStoreSoap> soapModels = new ArrayList<ShoppingStoreSoap>(models.size());

        for (ShoppingStore model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingStoreSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _companyId;
    }

    public void setPrimaryKey(long pk) {
        setCompanyId(pk);
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDefaultEmailAddress() {
        return _defaultEmailAddress;
    }

    public void setDefaultEmailAddress(String defaultEmailAddress) {
        _defaultEmailAddress = defaultEmailAddress;
    }

    public String getProductsMainPageUuid() {
        return _productsMainPageUuid;
    }

    public void setProductsMainPageUuid(String productsMainPageUuid) {
        _productsMainPageUuid = productsMainPageUuid;
    }

    public String getCartPageUuid() {
        return _cartPageUuid;
    }

    public void setCartPageUuid(String cartPageUuid) {
        _cartPageUuid = cartPageUuid;
    }

    public String getCheckoutPageUuid() {
        return _checkoutPageUuid;
    }

    public void setCheckoutPageUuid(String checkoutPageUuid) {
        _checkoutPageUuid = checkoutPageUuid;
    }

    public String getOnAddToCart() {
        return _onAddToCart;
    }

    public void setOnAddToCart(String onAddToCart) {
        _onAddToCart = onAddToCart;
    }

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String currency) {
        _currency = currency;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

    public String getUserTypes() {
        return _userTypes;
    }

    public void setUserTypes(String userTypes) {
        _userTypes = userTypes;
    }

    public boolean getCheckoutPageFullscreen() {
        return _checkoutPageFullscreen;
    }

    public boolean isCheckoutPageFullscreen() {
        return _checkoutPageFullscreen;
    }

    public void setCheckoutPageFullscreen(boolean checkoutPageFullscreen) {
        _checkoutPageFullscreen = checkoutPageFullscreen;
    }

    public String getCheckoutCompletePageTemplate() {
        return _checkoutCompletePageTemplate;
    }

    public void setCheckoutCompletePageTemplate(
        String checkoutCompletePageTemplate) {
        _checkoutCompletePageTemplate = checkoutCompletePageTemplate;
    }

    public String getOrderCreatedEmailTemplate() {
        return _orderCreatedEmailTemplate;
    }

    public void setOrderCreatedEmailTemplate(String orderCreatedEmailTemplate) {
        _orderCreatedEmailTemplate = orderCreatedEmailTemplate;
    }

    public String getOrderShippedEmailTemplate() {
        return _orderShippedEmailTemplate;
    }

    public void setOrderShippedEmailTemplate(String orderShippedEmailTemplate) {
        _orderShippedEmailTemplate = orderShippedEmailTemplate;
    }

    public String getOrderCreatedEmailSubject() {
        return _orderCreatedEmailSubject;
    }

    public void setOrderCreatedEmailSubject(String orderCreatedEmailSubject) {
        _orderCreatedEmailSubject = orderCreatedEmailSubject;
    }

    public String getOrderCreatedEmailFromAddress() {
        return _orderCreatedEmailFromAddress;
    }

    public void setOrderCreatedEmailFromAddress(
        String orderCreatedEmailFromAddress) {
        _orderCreatedEmailFromAddress = orderCreatedEmailFromAddress;
    }

    public boolean getIntegrateWithStripe() {
        return _integrateWithStripe;
    }

    public boolean isIntegrateWithStripe() {
        return _integrateWithStripe;
    }

    public void setIntegrateWithStripe(boolean integrateWithStripe) {
        _integrateWithStripe = integrateWithStripe;
    }

    public String getStripeTestSecretKey() {
        return _stripeTestSecretKey;
    }

    public void setStripeTestSecretKey(String stripeTestSecretKey) {
        _stripeTestSecretKey = stripeTestSecretKey;
    }

    public String getStripeTestPublishableKey() {
        return _stripeTestPublishableKey;
    }

    public void setStripeTestPublishableKey(String stripeTestPublishableKey) {
        _stripeTestPublishableKey = stripeTestPublishableKey;
    }

    public boolean getStripeTesting() {
        return _stripeTesting;
    }

    public boolean isStripeTesting() {
        return _stripeTesting;
    }

    public void setStripeTesting(boolean stripeTesting) {
        _stripeTesting = stripeTesting;
    }

    public String getStripeLiveSecretKey() {
        return _stripeLiveSecretKey;
    }

    public void setStripeLiveSecretKey(String stripeLiveSecretKey) {
        _stripeLiveSecretKey = stripeLiveSecretKey;
    }

    public String getStripeLivePublishableKey() {
        return _stripeLivePublishableKey;
    }

    public void setStripeLivePublishableKey(String stripeLivePublishableKey) {
        _stripeLivePublishableKey = stripeLivePublishableKey;
    }

    public String getStripeApiVersion() {
        return _stripeApiVersion;
    }

    public void setStripeApiVersion(String stripeApiVersion) {
        _stripeApiVersion = stripeApiVersion;
    }

    public boolean getIntegrateWithBraintree() {
        return _integrateWithBraintree;
    }

    public boolean isIntegrateWithBraintree() {
        return _integrateWithBraintree;
    }

    public void setIntegrateWithBraintree(boolean integrateWithBraintree) {
        _integrateWithBraintree = integrateWithBraintree;
    }

    public String getBraintreePrivateKey() {
        return _braintreePrivateKey;
    }

    public void setBraintreePrivateKey(String braintreePrivateKey) {
        _braintreePrivateKey = braintreePrivateKey;
    }

    public String getBraintreePublicKey() {
        return _braintreePublicKey;
    }

    public void setBraintreePublicKey(String braintreePublicKey) {
        _braintreePublicKey = braintreePublicKey;
    }

    public String getBraintreeMerchantId() {
        return _braintreeMerchantId;
    }

    public void setBraintreeMerchantId(String braintreeMerchantId) {
        _braintreeMerchantId = braintreeMerchantId;
    }

    public boolean getUseBraintreeSandbox() {
        return _useBraintreeSandbox;
    }

    public boolean isUseBraintreeSandbox() {
        return _useBraintreeSandbox;
    }

    public void setUseBraintreeSandbox(boolean useBraintreeSandbox) {
        _useBraintreeSandbox = useBraintreeSandbox;
    }

    public String getBraintreeSandboxMerchantId() {
        return _braintreeSandboxMerchantId;
    }

    public void setBraintreeSandboxMerchantId(String braintreeSandboxMerchantId) {
        _braintreeSandboxMerchantId = braintreeSandboxMerchantId;
    }

    public String getBraintreeSandboxPrivateKey() {
        return _braintreeSandboxPrivateKey;
    }

    public void setBraintreeSandboxPrivateKey(String braintreeSandboxPrivateKey) {
        _braintreeSandboxPrivateKey = braintreeSandboxPrivateKey;
    }

    public String getBraintreeSandboxPublicKey() {
        return _braintreeSandboxPublicKey;
    }

    public void setBraintreeSandboxPublicKey(String braintreeSandboxPublicKey) {
        _braintreeSandboxPublicKey = braintreeSandboxPublicKey;
    }
}
