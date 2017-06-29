package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingItemTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingItemTypeServiceSoap
 * @generated
 */
public class ShoppingItemTypeSoap implements Serializable {
    private long _itemTypeId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;

    public ShoppingItemTypeSoap() {
    }

    public static ShoppingItemTypeSoap toSoapModel(ShoppingItemType model) {
        ShoppingItemTypeSoap soapModel = new ShoppingItemTypeSoap();

        soapModel.setItemTypeId(model.getItemTypeId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static ShoppingItemTypeSoap[] toSoapModels(ShoppingItemType[] models) {
        ShoppingItemTypeSoap[] soapModels = new ShoppingItemTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemTypeSoap[][] toSoapModels(
        ShoppingItemType[][] models) {
        ShoppingItemTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingItemTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingItemTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemTypeSoap[] toSoapModels(
        List<ShoppingItemType> models) {
        List<ShoppingItemTypeSoap> soapModels = new ArrayList<ShoppingItemTypeSoap>(models.size());

        for (ShoppingItemType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingItemTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _itemTypeId;
    }

    public void setPrimaryKey(long pk) {
        setItemTypeId(pk);
    }

    public long getItemTypeId() {
        return _itemTypeId;
    }

    public void setItemTypeId(long itemTypeId) {
        _itemTypeId = itemTypeId;
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
}
