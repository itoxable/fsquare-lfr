package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingStore;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingStore in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStore
 * @generated
 */
public class ShoppingStoreCacheModel implements CacheModel<ShoppingStore>,
    Externalizable {
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String defaultEmailAddress;
    public String productsMainPageUuid;
    public String cartPageUuid;
    public String checkoutPageUuid;
    public String onAddToCart;
    public String currency;
    public String country;
    public String userTypes;
    public boolean checkoutPageFullscreen;
    public String checkoutCompletePageTemplate;
    public String orderCreatedEmailTemplate;
    public String orderShippedEmailTemplate;
    public String orderCreatedEmailSubject;
    public String orderCreatedEmailFromAddress;
    public boolean integrateWithStripe;
    public String stripeTestSecretKey;
    public String stripeTestPublishableKey;
    public boolean stripeTesting;
    public String stripeLiveSecretKey;
    public String stripeLivePublishableKey;
    public String stripeApiVersion;
    public boolean integrateWithBraintree;
    public String braintreePrivateKey;
    public String braintreePublicKey;
    public String braintreeMerchantId;
    public boolean useBraintreeSandbox;
    public String braintreeSandboxMerchantId;
    public String braintreeSandboxPrivateKey;
    public String braintreeSandboxPublicKey;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(73);

        sb.append("{groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", defaultEmailAddress=");
        sb.append(defaultEmailAddress);
        sb.append(", productsMainPageUuid=");
        sb.append(productsMainPageUuid);
        sb.append(", cartPageUuid=");
        sb.append(cartPageUuid);
        sb.append(", checkoutPageUuid=");
        sb.append(checkoutPageUuid);
        sb.append(", onAddToCart=");
        sb.append(onAddToCart);
        sb.append(", currency=");
        sb.append(currency);
        sb.append(", country=");
        sb.append(country);
        sb.append(", userTypes=");
        sb.append(userTypes);
        sb.append(", checkoutPageFullscreen=");
        sb.append(checkoutPageFullscreen);
        sb.append(", checkoutCompletePageTemplate=");
        sb.append(checkoutCompletePageTemplate);
        sb.append(", orderCreatedEmailTemplate=");
        sb.append(orderCreatedEmailTemplate);
        sb.append(", orderShippedEmailTemplate=");
        sb.append(orderShippedEmailTemplate);
        sb.append(", orderCreatedEmailSubject=");
        sb.append(orderCreatedEmailSubject);
        sb.append(", orderCreatedEmailFromAddress=");
        sb.append(orderCreatedEmailFromAddress);
        sb.append(", integrateWithStripe=");
        sb.append(integrateWithStripe);
        sb.append(", stripeTestSecretKey=");
        sb.append(stripeTestSecretKey);
        sb.append(", stripeTestPublishableKey=");
        sb.append(stripeTestPublishableKey);
        sb.append(", stripeTesting=");
        sb.append(stripeTesting);
        sb.append(", stripeLiveSecretKey=");
        sb.append(stripeLiveSecretKey);
        sb.append(", stripeLivePublishableKey=");
        sb.append(stripeLivePublishableKey);
        sb.append(", stripeApiVersion=");
        sb.append(stripeApiVersion);
        sb.append(", integrateWithBraintree=");
        sb.append(integrateWithBraintree);
        sb.append(", braintreePrivateKey=");
        sb.append(braintreePrivateKey);
        sb.append(", braintreePublicKey=");
        sb.append(braintreePublicKey);
        sb.append(", braintreeMerchantId=");
        sb.append(braintreeMerchantId);
        sb.append(", useBraintreeSandbox=");
        sb.append(useBraintreeSandbox);
        sb.append(", braintreeSandboxMerchantId=");
        sb.append(braintreeSandboxMerchantId);
        sb.append(", braintreeSandboxPrivateKey=");
        sb.append(braintreeSandboxPrivateKey);
        sb.append(", braintreeSandboxPublicKey=");
        sb.append(braintreeSandboxPublicKey);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingStore toEntityModel() {
        ShoppingStoreImpl shoppingStoreImpl = new ShoppingStoreImpl();

        shoppingStoreImpl.setGroupId(groupId);
        shoppingStoreImpl.setCompanyId(companyId);
        shoppingStoreImpl.setUserId(userId);

        if (userName == null) {
            shoppingStoreImpl.setUserName(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            shoppingStoreImpl.setCreateDate(null);
        } else {
            shoppingStoreImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            shoppingStoreImpl.setModifiedDate(null);
        } else {
            shoppingStoreImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            shoppingStoreImpl.setName(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setName(name);
        }

        if (defaultEmailAddress == null) {
            shoppingStoreImpl.setDefaultEmailAddress(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setDefaultEmailAddress(defaultEmailAddress);
        }

        if (productsMainPageUuid == null) {
            shoppingStoreImpl.setProductsMainPageUuid(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setProductsMainPageUuid(productsMainPageUuid);
        }

        if (cartPageUuid == null) {
            shoppingStoreImpl.setCartPageUuid(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setCartPageUuid(cartPageUuid);
        }

        if (checkoutPageUuid == null) {
            shoppingStoreImpl.setCheckoutPageUuid(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setCheckoutPageUuid(checkoutPageUuid);
        }

        if (onAddToCart == null) {
            shoppingStoreImpl.setOnAddToCart(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setOnAddToCart(onAddToCart);
        }

        if (currency == null) {
            shoppingStoreImpl.setCurrency(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setCurrency(currency);
        }

        if (country == null) {
            shoppingStoreImpl.setCountry(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setCountry(country);
        }

        if (userTypes == null) {
            shoppingStoreImpl.setUserTypes(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setUserTypes(userTypes);
        }

        shoppingStoreImpl.setCheckoutPageFullscreen(checkoutPageFullscreen);

        if (checkoutCompletePageTemplate == null) {
            shoppingStoreImpl.setCheckoutCompletePageTemplate(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setCheckoutCompletePageTemplate(checkoutCompletePageTemplate);
        }

        if (orderCreatedEmailTemplate == null) {
            shoppingStoreImpl.setOrderCreatedEmailTemplate(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setOrderCreatedEmailTemplate(orderCreatedEmailTemplate);
        }

        if (orderShippedEmailTemplate == null) {
            shoppingStoreImpl.setOrderShippedEmailTemplate(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setOrderShippedEmailTemplate(orderShippedEmailTemplate);
        }

        if (orderCreatedEmailSubject == null) {
            shoppingStoreImpl.setOrderCreatedEmailSubject(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setOrderCreatedEmailSubject(orderCreatedEmailSubject);
        }

        if (orderCreatedEmailFromAddress == null) {
            shoppingStoreImpl.setOrderCreatedEmailFromAddress(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setOrderCreatedEmailFromAddress(orderCreatedEmailFromAddress);
        }

        shoppingStoreImpl.setIntegrateWithStripe(integrateWithStripe);

        if (stripeTestSecretKey == null) {
            shoppingStoreImpl.setStripeTestSecretKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setStripeTestSecretKey(stripeTestSecretKey);
        }

        if (stripeTestPublishableKey == null) {
            shoppingStoreImpl.setStripeTestPublishableKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setStripeTestPublishableKey(stripeTestPublishableKey);
        }

        shoppingStoreImpl.setStripeTesting(stripeTesting);

        if (stripeLiveSecretKey == null) {
            shoppingStoreImpl.setStripeLiveSecretKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setStripeLiveSecretKey(stripeLiveSecretKey);
        }

        if (stripeLivePublishableKey == null) {
            shoppingStoreImpl.setStripeLivePublishableKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setStripeLivePublishableKey(stripeLivePublishableKey);
        }

        if (stripeApiVersion == null) {
            shoppingStoreImpl.setStripeApiVersion(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setStripeApiVersion(stripeApiVersion);
        }

        shoppingStoreImpl.setIntegrateWithBraintree(integrateWithBraintree);

        if (braintreePrivateKey == null) {
            shoppingStoreImpl.setBraintreePrivateKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setBraintreePrivateKey(braintreePrivateKey);
        }

        if (braintreePublicKey == null) {
            shoppingStoreImpl.setBraintreePublicKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setBraintreePublicKey(braintreePublicKey);
        }

        if (braintreeMerchantId == null) {
            shoppingStoreImpl.setBraintreeMerchantId(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setBraintreeMerchantId(braintreeMerchantId);
        }

        shoppingStoreImpl.setUseBraintreeSandbox(useBraintreeSandbox);

        if (braintreeSandboxMerchantId == null) {
            shoppingStoreImpl.setBraintreeSandboxMerchantId(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setBraintreeSandboxMerchantId(braintreeSandboxMerchantId);
        }

        if (braintreeSandboxPrivateKey == null) {
            shoppingStoreImpl.setBraintreeSandboxPrivateKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setBraintreeSandboxPrivateKey(braintreeSandboxPrivateKey);
        }

        if (braintreeSandboxPublicKey == null) {
            shoppingStoreImpl.setBraintreeSandboxPublicKey(StringPool.BLANK);
        } else {
            shoppingStoreImpl.setBraintreeSandboxPublicKey(braintreeSandboxPublicKey);
        }

        shoppingStoreImpl.resetOriginalValues();

        return shoppingStoreImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        defaultEmailAddress = objectInput.readUTF();
        productsMainPageUuid = objectInput.readUTF();
        cartPageUuid = objectInput.readUTF();
        checkoutPageUuid = objectInput.readUTF();
        onAddToCart = objectInput.readUTF();
        currency = objectInput.readUTF();
        country = objectInput.readUTF();
        userTypes = objectInput.readUTF();
        checkoutPageFullscreen = objectInput.readBoolean();
        checkoutCompletePageTemplate = objectInput.readUTF();
        orderCreatedEmailTemplate = objectInput.readUTF();
        orderShippedEmailTemplate = objectInput.readUTF();
        orderCreatedEmailSubject = objectInput.readUTF();
        orderCreatedEmailFromAddress = objectInput.readUTF();
        integrateWithStripe = objectInput.readBoolean();
        stripeTestSecretKey = objectInput.readUTF();
        stripeTestPublishableKey = objectInput.readUTF();
        stripeTesting = objectInput.readBoolean();
        stripeLiveSecretKey = objectInput.readUTF();
        stripeLivePublishableKey = objectInput.readUTF();
        stripeApiVersion = objectInput.readUTF();
        integrateWithBraintree = objectInput.readBoolean();
        braintreePrivateKey = objectInput.readUTF();
        braintreePublicKey = objectInput.readUTF();
        braintreeMerchantId = objectInput.readUTF();
        useBraintreeSandbox = objectInput.readBoolean();
        braintreeSandboxMerchantId = objectInput.readUTF();
        braintreeSandboxPrivateKey = objectInput.readUTF();
        braintreeSandboxPublicKey = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (defaultEmailAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(defaultEmailAddress);
        }

        if (productsMainPageUuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(productsMainPageUuid);
        }

        if (cartPageUuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(cartPageUuid);
        }

        if (checkoutPageUuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(checkoutPageUuid);
        }

        if (onAddToCart == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(onAddToCart);
        }

        if (currency == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(currency);
        }

        if (country == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(country);
        }

        if (userTypes == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userTypes);
        }

        objectOutput.writeBoolean(checkoutPageFullscreen);

        if (checkoutCompletePageTemplate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(checkoutCompletePageTemplate);
        }

        if (orderCreatedEmailTemplate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(orderCreatedEmailTemplate);
        }

        if (orderShippedEmailTemplate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(orderShippedEmailTemplate);
        }

        if (orderCreatedEmailSubject == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(orderCreatedEmailSubject);
        }

        if (orderCreatedEmailFromAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(orderCreatedEmailFromAddress);
        }

        objectOutput.writeBoolean(integrateWithStripe);

        if (stripeTestSecretKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stripeTestSecretKey);
        }

        if (stripeTestPublishableKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stripeTestPublishableKey);
        }

        objectOutput.writeBoolean(stripeTesting);

        if (stripeLiveSecretKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stripeLiveSecretKey);
        }

        if (stripeLivePublishableKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stripeLivePublishableKey);
        }

        if (stripeApiVersion == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stripeApiVersion);
        }

        objectOutput.writeBoolean(integrateWithBraintree);

        if (braintreePrivateKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(braintreePrivateKey);
        }

        if (braintreePublicKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(braintreePublicKey);
        }

        if (braintreeMerchantId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(braintreeMerchantId);
        }

        objectOutput.writeBoolean(useBraintreeSandbox);

        if (braintreeSandboxMerchantId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(braintreeSandboxMerchantId);
        }

        if (braintreeSandboxPrivateKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(braintreeSandboxPrivateKey);
        }

        if (braintreeSandboxPublicKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(braintreeSandboxPublicKey);
        }
    }
}
