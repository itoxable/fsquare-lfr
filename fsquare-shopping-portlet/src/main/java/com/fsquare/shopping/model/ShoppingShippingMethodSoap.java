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
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private double _price;
    private String _name;
    private String _methodName;

    public ShoppingShippingMethodSoap() {
    }

    public static ShoppingShippingMethodSoap toSoapModel(
        ShoppingShippingMethod model) {
        ShoppingShippingMethodSoap soapModel = new ShoppingShippingMethodSoap();

        soapModel.setShippingMethodId(model.getShippingMethodId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setPrice(model.getPrice());
        soapModel.setName(model.getName());
        soapModel.setMethodName(model.getMethodName());

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

    public String getMethodName() {
        return _methodName;
    }

    public void setMethodName(String methodName) {
        _methodName = methodName;
    }
}
