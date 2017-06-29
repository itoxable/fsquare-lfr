package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingStorageLocationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingStorageLocationServiceSoap
 * @generated
 */
public class ShoppingStorageLocationSoap implements Serializable {
    private long _storageLocationId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private String _location;

    public ShoppingStorageLocationSoap() {
    }

    public static ShoppingStorageLocationSoap toSoapModel(
        ShoppingStorageLocation model) {
        ShoppingStorageLocationSoap soapModel = new ShoppingStorageLocationSoap();

        soapModel.setStorageLocationId(model.getStorageLocationId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setLocation(model.getLocation());

        return soapModel;
    }

    public static ShoppingStorageLocationSoap[] toSoapModels(
        ShoppingStorageLocation[] models) {
        ShoppingStorageLocationSoap[] soapModels = new ShoppingStorageLocationSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingStorageLocationSoap[][] toSoapModels(
        ShoppingStorageLocation[][] models) {
        ShoppingStorageLocationSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingStorageLocationSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingStorageLocationSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingStorageLocationSoap[] toSoapModels(
        List<ShoppingStorageLocation> models) {
        List<ShoppingStorageLocationSoap> soapModels = new ArrayList<ShoppingStorageLocationSoap>(models.size());

        for (ShoppingStorageLocation model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingStorageLocationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _storageLocationId;
    }

    public void setPrimaryKey(long pk) {
        setStorageLocationId(pk);
    }

    public long getStorageLocationId() {
        return _storageLocationId;
    }

    public void setStorageLocationId(long storageLocationId) {
        _storageLocationId = storageLocationId;
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

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }
}
