package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingItemType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingItemType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemType
 * @generated
 */
public class ShoppingItemTypeCacheModel implements CacheModel<ShoppingItemType>,
    Externalizable {
    public long itemTypeId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{itemTypeId=");
        sb.append(itemTypeId);
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
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingItemType toEntityModel() {
        ShoppingItemTypeImpl shoppingItemTypeImpl = new ShoppingItemTypeImpl();

        shoppingItemTypeImpl.setItemTypeId(itemTypeId);
        shoppingItemTypeImpl.setGroupId(groupId);
        shoppingItemTypeImpl.setCompanyId(companyId);
        shoppingItemTypeImpl.setUserId(userId);

        if (userName == null) {
            shoppingItemTypeImpl.setUserName(StringPool.BLANK);
        } else {
            shoppingItemTypeImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            shoppingItemTypeImpl.setCreateDate(null);
        } else {
            shoppingItemTypeImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            shoppingItemTypeImpl.setModifiedDate(null);
        } else {
            shoppingItemTypeImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            shoppingItemTypeImpl.setName(StringPool.BLANK);
        } else {
            shoppingItemTypeImpl.setName(name);
        }

        if (description == null) {
            shoppingItemTypeImpl.setDescription(StringPool.BLANK);
        } else {
            shoppingItemTypeImpl.setDescription(description);
        }

        shoppingItemTypeImpl.resetOriginalValues();

        return shoppingItemTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        itemTypeId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(itemTypeId);
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
    }
}
