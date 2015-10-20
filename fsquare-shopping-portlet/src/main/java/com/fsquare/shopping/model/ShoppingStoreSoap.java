package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingStoreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingStoreServiceSoap
 * @generated
 */
public class ShoppingStoreSoap implements Serializable {
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _cartPageUuid;
    private String _checkoutPageUuid;
    private String _onAddToCart;
    private String _currency;

    public ShoppingStoreSoap() {
    }

    public static ShoppingStoreSoap toSoapModel(ShoppingStore model) {
        ShoppingStoreSoap soapModel = new ShoppingStoreSoap();

        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setCartPageUuid(model.getCartPageUuid());
        soapModel.setCheckoutPageUuid(model.getCheckoutPageUuid());
        soapModel.setOnAddToCart(model.getOnAddToCart());
        soapModel.setCurrency(model.getCurrency());

        return soapModel;
    }

    public static ShoppingStoreSoap[] toSoapModels(ShoppingStore[] models) {
        ShoppingStoreSoap[] soapModels = new ShoppingStoreSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingStoreSoap[][] toSoapModels(ShoppingStore[][] models) {
        ShoppingStoreSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingStoreSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingStoreSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingStoreSoap[] toSoapModels(List<ShoppingStore> models) {
        List<ShoppingStoreSoap> soapModels = new ArrayList<ShoppingStoreSoap>(models.size());

        for (ShoppingStore model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingStoreSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _groupId;
    }

    public void setPrimaryKey(long pk) {
        setGroupId(pk);
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getCartPageUuid() {
        return _cartPageUuid;
    }

    public void setCartPageUuid(String cartPageUuid) {
        _cartPageUuid = cartPageUuid;
    }

    public String getCheckoutPageUuid() {
        return _checkoutPageUuid;
    }

    public void setCheckoutPageUuid(String checkoutPageUuid) {
        _checkoutPageUuid = checkoutPageUuid;
    }

    public String getOnAddToCart() {
        return _onAddToCart;
    }

    public void setOnAddToCart(String onAddToCart) {
        _onAddToCart = onAddToCart;
    }

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String currency) {
        _currency = currency;
    }
}
