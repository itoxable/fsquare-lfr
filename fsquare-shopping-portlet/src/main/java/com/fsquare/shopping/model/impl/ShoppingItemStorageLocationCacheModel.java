package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingItemStorageLocation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingItemStorageLocation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocation
 * @generated
 */
public class ShoppingItemStorageLocationCacheModel implements CacheModel<ShoppingItemStorageLocation>,
    Externalizable {
    public long itemStorageLocationId;
    public long itemId;
    public long storageLocationId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public int quantity;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{itemStorageLocationId=");
        sb.append(itemStorageLocationId);
        sb.append(", itemId=");
        sb.append(itemId);
        sb.append(", storageLocationId=");
        sb.append(storageLocationId);
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
        sb.append(", quantity=");
        sb.append(quantity);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingItemStorageLocation toEntityModel() {
        ShoppingItemStorageLocationImpl shoppingItemStorageLocationImpl = new ShoppingItemStorageLocationImpl();

        shoppingItemStorageLocationImpl.setItemStorageLocationId(itemStorageLocationId);
        shoppingItemStorageLocationImpl.setItemId(itemId);
        shoppingItemStorageLocationImpl.setStorageLocationId(storageLocationId);
        shoppingItemStorageLocationImpl.setCompanyId(companyId);
        shoppingItemStorageLocationImpl.setUserId(userId);

        if (userName == null) {
            shoppingItemStorageLocationImpl.setUserName(StringPool.BLANK);
        } else {
            shoppingItemStorageLocationImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            shoppingItemStorageLocationImpl.setCreateDate(null);
        } else {
            shoppingItemStorageLocationImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            shoppingItemStorageLocationImpl.setModifiedDate(null);
        } else {
            shoppingItemStorageLocationImpl.setModifiedDate(new Date(
                    modifiedDate));
        }

        if (name == null) {
            shoppingItemStorageLocationImpl.setName(StringPool.BLANK);
        } else {
            shoppingItemStorageLocationImpl.setName(name);
        }

        shoppingItemStorageLocationImpl.setQuantity(quantity);

        shoppingItemStorageLocationImpl.resetOriginalValues();

        return shoppingItemStorageLocationImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        itemStorageLocationId = objectInput.readLong();
        itemId = objectInput.readLong();
        storageLocationId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        quantity = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(itemStorageLocationId);
        objectOutput.writeLong(itemId);
        objectOutput.writeLong(storageLocationId);
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

        objectOutput.writeInt(quantity);
    }
}
