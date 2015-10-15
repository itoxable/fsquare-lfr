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
    public String methodName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

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
        sb.append(", methodName=");
        sb.append(methodName);
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

        if (methodName == null) {
            shoppingShippingMethodImpl.setMethodName(StringPool.BLANK);
        } else {
            shoppingShippingMethodImpl.setMethodName(methodName);
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
        methodName = objectInput.readUTF();
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

        if (methodName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(methodName);
        }
    }
}
