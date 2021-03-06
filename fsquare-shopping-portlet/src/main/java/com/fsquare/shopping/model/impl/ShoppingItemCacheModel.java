package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItem
 * @generated
 */
public class ShoppingItemCacheModel implements CacheModel<ShoppingItem>,
    Externalizable {
    public String uuid;
    public long itemId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public long classNameId;
    public long classPK;
    public String title;
    public String description;
    public double price;
    public double discountPrice;
    public String sku;
    public long itemTypeId;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(41);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", itemId=");
        sb.append(itemId);
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
        sb.append(", classNameId=");
        sb.append(classNameId);
        sb.append(", classPK=");
        sb.append(classPK);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", price=");
        sb.append(price);
        sb.append(", discountPrice=");
        sb.append(discountPrice);
        sb.append(", sku=");
        sb.append(sku);
        sb.append(", itemTypeId=");
        sb.append(itemTypeId);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingItem toEntityModel() {
        ShoppingItemImpl shoppingItemImpl = new ShoppingItemImpl();

        if (uuid == null) {
            shoppingItemImpl.setUuid(StringPool.BLANK);
        } else {
            shoppingItemImpl.setUuid(uuid);
        }

        shoppingItemImpl.setItemId(itemId);
        shoppingItemImpl.setGroupId(groupId);
        shoppingItemImpl.setCompanyId(companyId);
        shoppingItemImpl.setUserId(userId);

        if (userName == null) {
            shoppingItemImpl.setUserName(StringPool.BLANK);
        } else {
            shoppingItemImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            shoppingItemImpl.setCreateDate(null);
        } else {
            shoppingItemImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            shoppingItemImpl.setModifiedDate(null);
        } else {
            shoppingItemImpl.setModifiedDate(new Date(modifiedDate));
        }

        shoppingItemImpl.setClassNameId(classNameId);
        shoppingItemImpl.setClassPK(classPK);

        if (title == null) {
            shoppingItemImpl.setTitle(StringPool.BLANK);
        } else {
            shoppingItemImpl.setTitle(title);
        }

        if (description == null) {
            shoppingItemImpl.setDescription(StringPool.BLANK);
        } else {
            shoppingItemImpl.setDescription(description);
        }

        shoppingItemImpl.setPrice(price);
        shoppingItemImpl.setDiscountPrice(discountPrice);

        if (sku == null) {
            shoppingItemImpl.setSku(StringPool.BLANK);
        } else {
            shoppingItemImpl.setSku(sku);
        }

        shoppingItemImpl.setItemTypeId(itemTypeId);
        shoppingItemImpl.setStatus(status);
        shoppingItemImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            shoppingItemImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            shoppingItemImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            shoppingItemImpl.setStatusDate(null);
        } else {
            shoppingItemImpl.setStatusDate(new Date(statusDate));
        }

        shoppingItemImpl.resetOriginalValues();

        return shoppingItemImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        itemId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        classNameId = objectInput.readLong();
        classPK = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        price = objectInput.readDouble();
        discountPrice = objectInput.readDouble();
        sku = objectInput.readUTF();
        itemTypeId = objectInput.readLong();
        status = objectInput.readInt();
        statusByUserId = objectInput.readLong();
        statusByUserName = objectInput.readUTF();
        statusDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(itemId);
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
        objectOutput.writeLong(classNameId);
        objectOutput.writeLong(classPK);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeDouble(price);
        objectOutput.writeDouble(discountPrice);

        if (sku == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sku);
        }

        objectOutput.writeLong(itemTypeId);
        objectOutput.writeInt(status);
        objectOutput.writeLong(statusByUserId);

        if (statusByUserName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusByUserName);
        }

        objectOutput.writeLong(statusDate);
    }
}
