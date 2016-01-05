package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingShippingMethod;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingShippingMethod in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethod
 * @generated
 */
public class ShoppingShippingMethodCacheModel implements CacheModel<ShoppingShippingMethod>,
    Externalizable {
    public long shippingMethodId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public double price;
    public String name;
    public String description;
    public long freeQuantity;
    public double freeTotal;
    public double weight;
    public boolean defaultShipping;
    public boolean international;
    public boolean disabled;
    public String shippingType;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{shippingMethodId=");
        sb.append(shippingMethodId);
        sb.append(", groupId=");
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
        sb.append(", price=");
        sb.append(price);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", freeQuantity=");
        sb.append(freeQuantity);
        sb.append(", freeTotal=");
        sb.append(freeTotal);
        sb.append(", weight=");
        sb.append(weight);
        sb.append(", defaultShipping=");
        sb.append(defaultShipping);
        sb.append(", international=");
        sb.append(international);
        sb.append(", disabled=");
        sb.append(disabled);
        sb.append(", shippingType=");
        sb.append(shippingType);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingShippingMethod toEntityModel() {
        ShoppingShippingMethodImpl shoppingShippingMethodImpl = new ShoppingShippingMethodImpl();

        shoppingShippingMethodImpl.setShippingMethodId(shippingMethodId);
        shoppingShippingMethodImpl.setGroupId(groupId);
        shoppingShippingMethodImpl.setCompanyId(companyId);
        shoppingShippingMethodImpl.setUserId(userId);

        if (userName == null) {
            shoppingShippingMethodImpl.setUserName(StringPool.BLANK);
        } else {
            shoppingShippingMethodImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            shoppingShippingMethodImpl.setCreateDate(null);
        } else {
            shoppingShippingMethodImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            shoppingShippingMethodImpl.setModifiedDate(null);
        } else {
            shoppingShippingMethodImpl.setModifiedDate(new Date(modifiedDate));
        }

        shoppingShippingMethodImpl.setPrice(price);

        if (name == null) {
            shoppingShippingMethodImpl.setName(StringPool.BLANK);
        } else {
            shoppingShippingMethodImpl.setName(name);
        }

        if (description == null) {
            shoppingShippingMethodImpl.setDescription(StringPool.BLANK);
        } else {
            shoppingShippingMethodImpl.setDescription(description);
        }

        shoppingShippingMethodImpl.setFreeQuantity(freeQuantity);
        shoppingShippingMethodImpl.setFreeTotal(freeTotal);
        shoppingShippingMethodImpl.setWeight(weight);
        shoppingShippingMethodImpl.setDefaultShipping(defaultShipping);
        shoppingShippingMethodImpl.setInternational(international);
        shoppingShippingMethodImpl.setDisabled(disabled);

        if (shippingType == null) {
            shoppingShippingMethodImpl.setShippingType(StringPool.BLANK);
        } else {
            shoppingShippingMethodImpl.setShippingType(shippingType);
        }

        shoppingShippingMethodImpl.resetOriginalValues();

        return shoppingShippingMethodImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        shippingMethodId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        price = objectInput.readDouble();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        freeQuantity = objectInput.readLong();
        freeTotal = objectInput.readDouble();
        weight = objectInput.readDouble();
        defaultShipping = objectInput.readBoolean();
        international = objectInput.readBoolean();
        disabled = objectInput.readBoolean();
        shippingType = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(shippingMethodId);
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
        objectOutput.writeDouble(price);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(freeQuantity);
        objectOutput.writeDouble(freeTotal);
        objectOutput.writeDouble(weight);
        objectOutput.writeBoolean(defaultShipping);
        objectOutput.writeBoolean(international);
        objectOutput.writeBoolean(disabled);

        if (shippingType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingType);
        }
    }
}
