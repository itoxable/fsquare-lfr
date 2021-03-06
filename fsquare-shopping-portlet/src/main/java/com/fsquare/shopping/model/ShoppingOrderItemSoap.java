package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingOrderItemServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingOrderItemServiceSoap
 * @generated
 */
public class ShoppingOrderItemSoap implements Serializable {
    private long _shoppingOrderItemId;
    private long _shoppingOrderId;
    private String _articleId;
    private String _sku;
    private String _name;
    private String _description;
    private String _properties;
    private double _price;
    private int _quantity;
    private Date _shippedDate;

    public ShoppingOrderItemSoap() {
    }

    public static ShoppingOrderItemSoap toSoapModel(ShoppingOrderItem model) {
        ShoppingOrderItemSoap soapModel = new ShoppingOrderItemSoap();

        soapModel.setShoppingOrderItemId(model.getShoppingOrderItemId());
        soapModel.setShoppingOrderId(model.getShoppingOrderId());
        soapModel.setArticleId(model.getArticleId());
        soapModel.setSku(model.getSku());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setProperties(model.getProperties());
        soapModel.setPrice(model.getPrice());
        soapModel.setQuantity(model.getQuantity());
        soapModel.setShippedDate(model.getShippedDate());

        return soapModel;
    }

    public static ShoppingOrderItemSoap[] toSoapModels(
        ShoppingOrderItem[] models) {
        ShoppingOrderItemSoap[] soapModels = new ShoppingOrderItemSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingOrderItemSoap[][] toSoapModels(
        ShoppingOrderItem[][] models) {
        ShoppingOrderItemSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingOrderItemSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingOrderItemSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingOrderItemSoap[] toSoapModels(
        List<ShoppingOrderItem> models) {
        List<ShoppingOrderItemSoap> soapModels = new ArrayList<ShoppingOrderItemSoap>(models.size());

        for (ShoppingOrderItem model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingOrderItemSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _shoppingOrderItemId;
    }

    public void setPrimaryKey(long pk) {
        setShoppingOrderItemId(pk);
    }

    public long getShoppingOrderItemId() {
        return _shoppingOrderItemId;
    }

    public void setShoppingOrderItemId(long shoppingOrderItemId) {
        _shoppingOrderItemId = shoppingOrderItemId;
    }

    public long getShoppingOrderId() {
        return _shoppingOrderId;
    }

    public void setShoppingOrderId(long shoppingOrderId) {
        _shoppingOrderId = shoppingOrderId;
    }

    public String getArticleId() {
        return _articleId;
    }

    public void setArticleId(String articleId) {
        _articleId = articleId;
    }

    public String getSku() {
        return _sku;
    }

    public void setSku(String sku) {
        _sku = sku;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getProperties() {
        return _properties;
    }

    public void setProperties(String properties) {
        _properties = properties;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        _price = price;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        _quantity = quantity;
    }

    public Date getShippedDate() {
        return _shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        _shippedDate = shippedDate;
    }
}
