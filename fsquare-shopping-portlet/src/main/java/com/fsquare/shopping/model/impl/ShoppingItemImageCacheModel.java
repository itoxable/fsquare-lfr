package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingItemImage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ShoppingItemImage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemImage
 * @generated
 */
public class ShoppingItemImageCacheModel implements CacheModel<ShoppingItemImage>,
    Externalizable {
    public long shoppingItemImageId;
    public long companyId;
    public long itemId;
    public long imageId;
    public boolean mainImage;
    public int order;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{shoppingItemImageId=");
        sb.append(shoppingItemImageId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", itemId=");
        sb.append(itemId);
        sb.append(", imageId=");
        sb.append(imageId);
        sb.append(", mainImage=");
        sb.append(mainImage);
        sb.append(", order=");
        sb.append(order);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingItemImage toEntityModel() {
        ShoppingItemImageImpl shoppingItemImageImpl = new ShoppingItemImageImpl();

        shoppingItemImageImpl.setShoppingItemImageId(shoppingItemImageId);
        shoppingItemImageImpl.setCompanyId(companyId);
        shoppingItemImageImpl.setItemId(itemId);
        shoppingItemImageImpl.setImageId(imageId);
        shoppingItemImageImpl.setMainImage(mainImage);
        shoppingItemImageImpl.setOrder(order);

        shoppingItemImageImpl.resetOriginalValues();

        return shoppingItemImageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        shoppingItemImageId = objectInput.readLong();
        companyId = objectInput.readLong();
        itemId = objectInput.readLong();
        imageId = objectInput.readLong();
        mainImage = objectInput.readBoolean();
        order = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(shoppingItemImageId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(itemId);
        objectOutput.writeLong(imageId);
        objectOutput.writeBoolean(mainImage);
        objectOutput.writeInt(order);
    }
}
