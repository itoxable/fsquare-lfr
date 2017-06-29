package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingShippingMethodServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingShippingMethodServiceSoap
 * @generated
 */
public class ShoppingShippingMethodSoap implements Serializable {
    private long _shippingMethodId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private double _price;
    private String _name;
    private String _description;
    private long _freeQuantity;
    private double _freeTotal;
    private double _weight;
    private boolean _defaultShipping;
    private boolean _international;
    private boolean _disabled;
    private String _shippingType;

    public ShoppingShippingMethodSoap() {
    }

    public static ShoppingShippingMethodSoap toSoapModel(
        ShoppingShippingMethod model) {
        ShoppingShippingMethodSoap soapModel = new ShoppingShippingMethodSoap();

        soapModel.setShippingMethodId(model.getShippingMethodId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setPrice(model.getPrice());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setFreeQuantity(model.getFreeQuantity());
        soapModel.setFreeTotal(model.getFreeTotal());
        soapModel.setWeight(model.getWeight());
        soapModel.setDefaultShipping(model.getDefaultShipping());
        soapModel.setInternational(model.getInternational());
        soapModel.setDisabled(model.getDisabled());
        soapModel.setShippingType(model.getShippingType());

        return soapModel;
    }

    public static ShoppingShippingMethodSoap[] toSoapModels(
        ShoppingShippingMethod[] models) {
        ShoppingShippingMethodSoap[] soapModels = new ShoppingShippingMethodSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingShippingMethodSoap[][] toSoapModels(
        ShoppingShippingMethod[][] models) {
        ShoppingShippingMethodSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingShippingMethodSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingShippingMethodSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingShippingMethodSoap[] toSoapModels(
        List<ShoppingShippingMethod> models) {
        List<ShoppingShippingMethodSoap> soapModels = new ArrayList<ShoppingShippingMethodSoap>(models.size());

        for (ShoppingShippingMethod model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingShippingMethodSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _shippingMethodId;
    }

    public void setPrimaryKey(long pk) {
        setShippingMethodId(pk);
    }

    public long getShippingMethodId() {
        return _shippingMethodId;
    }

    public void setShippingMethodId(long shippingMethodId) {
        _shippingMethodId = shippingMethodId;
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

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        _price = price;
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

    public long getFreeQuantity() {
        return _freeQuantity;
    }

    public void setFreeQuantity(long freeQuantity) {
        _freeQuantity = freeQuantity;
    }

    public double getFreeTotal() {
        return _freeTotal;
    }

    public void setFreeTotal(double freeTotal) {
        _freeTotal = freeTotal;
    }

    public double getWeight() {
        return _weight;
    }

    public void setWeight(double weight) {
        _weight = weight;
    }

    public boolean getDefaultShipping() {
        return _defaultShipping;
    }

    public boolean isDefaultShipping() {
        return _defaultShipping;
    }

    public void setDefaultShipping(boolean defaultShipping) {
        _defaultShipping = defaultShipping;
    }

    public boolean getInternational() {
        return _international;
    }

    public boolean isInternational() {
        return _international;
    }

    public void setInternational(boolean international) {
        _international = international;
    }

    public boolean getDisabled() {
        return _disabled;
    }

    public boolean isDisabled() {
        return _disabled;
    }

    public void setDisabled(boolean disabled) {
        _disabled = disabled;
    }

    public String getShippingType() {
        return _shippingType;
    }

    public void setShippingType(String shippingType) {
        _shippingType = shippingType;
    }
}
