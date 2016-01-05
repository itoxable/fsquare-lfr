package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingItemStorageLocationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingItemStorageLocationServiceSoap
 * @generated
 */
public class ShoppingItemStorageLocationSoap implements Serializable {
    private long _itemStorageLocationId;
    private long _itemId;
    private long _storageLocationId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private int _quantity;
    private String _movementType;

    public ShoppingItemStorageLocationSoap() {
    }

    public static ShoppingItemStorageLocationSoap toSoapModel(
        ShoppingItemStorageLocation model) {
        ShoppingItemStorageLocationSoap soapModel = new ShoppingItemStorageLocationSoap();

        soapModel.setItemStorageLocationId(model.getItemStorageLocationId());
        soapModel.setItemId(model.getItemId());
        soapModel.setStorageLocationId(model.getStorageLocationId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setQuantity(model.getQuantity());
        soapModel.setMovementType(model.getMovementType());

        return soapModel;
    }

    public static ShoppingItemStorageLocationSoap[] toSoapModels(
        ShoppingItemStorageLocation[] models) {
        ShoppingItemStorageLocationSoap[] soapModels = new ShoppingItemStorageLocationSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemStorageLocationSoap[][] toSoapModels(
        ShoppingItemStorageLocation[][] models) {
        ShoppingItemStorageLocationSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingItemStorageLocationSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingItemStorageLocationSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemStorageLocationSoap[] toSoapModels(
        List<ShoppingItemStorageLocation> models) {
        List<ShoppingItemStorageLocationSoap> soapModels = new ArrayList<ShoppingItemStorageLocationSoap>(models.size());

        for (ShoppingItemStorageLocation model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingItemStorageLocationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _itemStorageLocationId;
    }

    public void setPrimaryKey(long pk) {
        setItemStorageLocationId(pk);
    }

    public long getItemStorageLocationId() {
        return _itemStorageLocationId;
    }

    public void setItemStorageLocationId(long itemStorageLocationId) {
        _itemStorageLocationId = itemStorageLocationId;
    }

    public long getItemId() {
        return _itemId;
    }

    public void setItemId(long itemId) {
        _itemId = itemId;
    }

    public long getStorageLocationId() {
        return _storageLocationId;
    }

    public void setStorageLocationId(long storageLocationId) {
        _storageLocationId = storageLocationId;
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

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        _quantity = quantity;
    }

    public String getMovementType() {
        return _movementType;
    }

    public void setMovementType(String movementType) {
        _movementType = movementType;
    }
}
