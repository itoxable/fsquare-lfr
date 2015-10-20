package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingOrderItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingOrderItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItem
 * @generated
 */
public class ShoppingOrderItemCacheModel implements CacheModel<ShoppingOrderItem>,
    Externalizable {
    public long shoppingOrderItemId;
    public long shoppingOrderId;
    public String articleId;
    public String sku;
    public String name;
    public String description;
    public String properties;
    public double price;
    public int quantity;
    public long shippedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{shoppingOrderItemId=");
        sb.append(shoppingOrderItemId);
        sb.append(", shoppingOrderId=");
        sb.append(shoppingOrderId);
        sb.append(", articleId=");
        sb.append(articleId);
        sb.append(", sku=");
        sb.append(sku);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", properties=");
        sb.append(properties);
        sb.append(", price=");
        sb.append(price);
        sb.append(", quantity=");
        sb.append(quantity);
        sb.append(", shippedDate=");
        sb.append(shippedDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingOrderItem toEntityModel() {
        ShoppingOrderItemImpl shoppingOrderItemImpl = new ShoppingOrderItemImpl();

        shoppingOrderItemImpl.setShoppingOrderItemId(shoppingOrderItemId);
        shoppingOrderItemImpl.setShoppingOrderId(shoppingOrderId);

        if (articleId == null) {
            shoppingOrderItemImpl.setArticleId(StringPool.BLANK);
        } else {
            shoppingOrderItemImpl.setArticleId(articleId);
        }

        if (sku == null) {
            shoppingOrderItemImpl.setSku(StringPool.BLANK);
        } else {
            shoppingOrderItemImpl.setSku(sku);
        }

        if (name == null) {
            shoppingOrderItemImpl.setName(StringPool.BLANK);
        } else {
            shoppingOrderItemImpl.setName(name);
        }

        if (description == null) {
            shoppingOrderItemImpl.setDescription(StringPool.BLANK);
        } else {
            shoppingOrderItemImpl.setDescription(description);
        }

        if (properties == null) {
            shoppingOrderItemImpl.setProperties(StringPool.BLANK);
        } else {
            shoppingOrderItemImpl.setProperties(properties);
        }

        shoppingOrderItemImpl.setPrice(price);
        shoppingOrderItemImpl.setQuantity(quantity);

        if (shippedDate == Long.MIN_VALUE) {
            shoppingOrderItemImpl.setShippedDate(null);
        } else {
            shoppingOrderItemImpl.setShippedDate(new Date(shippedDate));
        }

        shoppingOrderItemImpl.resetOriginalValues();

        return shoppingOrderItemImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        shoppingOrderItemId = objectInput.readLong();
        shoppingOrderId = objectInput.readLong();
        articleId = objectInput.readUTF();
        sku = objectInput.readUTF();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        properties = objectInput.readUTF();
        price = objectInput.readDouble();
        quantity = objectInput.readInt();
        shippedDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(shoppingOrderItemId);
        objectOutput.writeLong(shoppingOrderId);

        if (articleId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(articleId);
        }

        if (sku == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sku);
        }

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

        if (properties == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(properties);
        }

        objectOutput.writeDouble(price);
        objectOutput.writeInt(quantity);
        objectOutput.writeLong(shippedDate);
    }
}
