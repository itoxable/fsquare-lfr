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
    public String cartPageUuid;
    public String checkoutPageUuid;
    public String onAddToCart;
    public String currency;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

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
        sb.append(", cartPageUuid=");
        sb.append(cartPageUuid);
        sb.append(", checkoutPageUuid=");
        sb.append(checkoutPageUuid);
        sb.append(", onAddToCart=");
        sb.append(onAddToCart);
        sb.append(", currency=");
        sb.append(currency);
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
        cartPageUuid = objectInput.readUTF();
        checkoutPageUuid = objectInput.readUTF();
        onAddToCart = objectInput.readUTF();
        currency = objectInput.readUTF();
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
    }
}
