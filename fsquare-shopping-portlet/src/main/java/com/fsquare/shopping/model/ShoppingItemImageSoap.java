package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShoppingItemImageSoap implements Serializable {
    private long _shoppingItemImageId;
    private long _companyId;
    private long _itemId;
    private long _imageId;
    private boolean _mainImage;
    private int _order;

    public ShoppingItemImageSoap() {
    }

    public static ShoppingItemImageSoap toSoapModel(ShoppingItemImage model) {
        ShoppingItemImageSoap soapModel = new ShoppingItemImageSoap();

        soapModel.setShoppingItemImageId(model.getShoppingItemImageId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setItemId(model.getItemId());
        soapModel.setImageId(model.getImageId());
        soapModel.setMainImage(model.getMainImage());
        soapModel.setOrder(model.getOrder());

        return soapModel;
    }

    public static ShoppingItemImageSoap[] toSoapModels(
        ShoppingItemImage[] models) {
        ShoppingItemImageSoap[] soapModels = new ShoppingItemImageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemImageSoap[][] toSoapModels(
        ShoppingItemImage[][] models) {
        ShoppingItemImageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingItemImageSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingItemImageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemImageSoap[] toSoapModels(
        List<ShoppingItemImage> models) {
        List<ShoppingItemImageSoap> soapModels = new ArrayList<ShoppingItemImageSoap>(models.size());

        for (ShoppingItemImage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingItemImageSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _shoppingItemImageId;
    }

    public void setPrimaryKey(long pk) {
        setShoppingItemImageId(pk);
    }

    public long getShoppingItemImageId() {
        return _shoppingItemImageId;
    }

    public void setShoppingItemImageId(long shoppingItemImageId) {
        _shoppingItemImageId = shoppingItemImageId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getItemId() {
        return _itemId;
    }

    public void setItemId(long itemId) {
        _itemId = itemId;
    }

    public long getImageId() {
        return _imageId;
    }

    public void setImageId(long imageId) {
        _imageId = imageId;
    }

    public boolean getMainImage() {
        return _mainImage;
    }

    public boolean isMainImage() {
        return _mainImage;
    }

    public void setMainImage(boolean mainImage) {
        _mainImage = mainImage;
    }

    public int getOrder() {
        return _order;
    }

    public void setOrder(int order) {
        _order = order;
    }
}
