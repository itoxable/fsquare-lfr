package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingStorageLocation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingStorageLocation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorageLocation
 * @generated
 */
public class ShoppingStorageLocationCacheModel implements CacheModel<ShoppingStorageLocation>,
    Externalizable {
    public long storageLocationId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public String location;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{storageLocationId=");
        sb.append(storageLocationId);
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
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", location=");
        sb.append(location);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingStorageLocation toEntityModel() {
        ShoppingStorageLocationImpl shoppingStorageLocationImpl = new ShoppingStorageLocationImpl();

        shoppingStorageLocationImpl.setStorageLocationId(storageLocationId);
        shoppingStorageLocationImpl.setGroupId(groupId);
        shoppingStorageLocationImpl.setCompanyId(companyId);
        shoppingStorageLocationImpl.setUserId(userId);

        if (userName == null) {
            shoppingStorageLocationImpl.setUserName(StringPool.BLANK);
        } else {
            shoppingStorageLocationImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            shoppingStorageLocationImpl.setCreateDate(null);
        } else {
            shoppingStorageLocationImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            shoppingStorageLocationImpl.setModifiedDate(null);
        } else {
            shoppingStorageLocationImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            shoppingStorageLocationImpl.setName(StringPool.BLANK);
        } else {
            shoppingStorageLocationImpl.setName(name);
        }

        if (description == null) {
            shoppingStorageLocationImpl.setDescription(StringPool.BLANK);
        } else {
            shoppingStorageLocationImpl.setDescription(description);
        }

        if (location == null) {
            shoppingStorageLocationImpl.setLocation(StringPool.BLANK);
        } else {
            shoppingStorageLocationImpl.setLocation(location);
        }

        shoppingStorageLocationImpl.resetOriginalValues();

        return shoppingStorageLocationImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        storageLocationId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        location = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(storageLocationId);
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

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (location == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(location);
        }
    }
}
