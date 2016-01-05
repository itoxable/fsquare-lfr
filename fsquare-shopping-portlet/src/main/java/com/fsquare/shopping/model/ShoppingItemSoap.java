package com.fsquare.shopping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsquare.shopping.service.http.ShoppingItemServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.http.ShoppingItemServiceSoap
 * @generated
 */
public class ShoppingItemSoap implements Serializable {
    private String _uuid;
    private long _itemId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _classNameId;
    private long _classPK;
    private String _name;
    private String _description;
    private double _price;
    private double _discountPrice;
    private String _sku;
    private long _itemTypeId;

    public ShoppingItemSoap() {
    }

    public static ShoppingItemSoap toSoapModel(ShoppingItem model) {
        ShoppingItemSoap soapModel = new ShoppingItemSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setItemId(model.getItemId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setClassNameId(model.getClassNameId());
        soapModel.setClassPK(model.getClassPK());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setPrice(model.getPrice());
        soapModel.setDiscountPrice(model.getDiscountPrice());
        soapModel.setSku(model.getSku());
        soapModel.setItemTypeId(model.getItemTypeId());

        return soapModel;
    }

    public static ShoppingItemSoap[] toSoapModels(ShoppingItem[] models) {
        ShoppingItemSoap[] soapModels = new ShoppingItemSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemSoap[][] toSoapModels(ShoppingItem[][] models) {
        ShoppingItemSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ShoppingItemSoap[models.length][models[0].length];
        } else {
            soapModels = new ShoppingItemSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ShoppingItemSoap[] toSoapModels(List<ShoppingItem> models) {
        List<ShoppingItemSoap> soapModels = new ArrayList<ShoppingItemSoap>(models.size());

        for (ShoppingItem model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ShoppingItemSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _itemId;
    }

    public void setPrimaryKey(long pk) {
        setItemId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getItemId() {
        return _itemId;
    }

    public void setItemId(long itemId) {
        _itemId = itemId;
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

    public long getClassNameId() {
        return _classNameId;
    }

    public void setClassNameId(long classNameId) {
        _classNameId = classNameId;
    }

    public long getClassPK() {
        return _classPK;
    }

    public void setClassPK(long classPK) {
        _classPK = classPK;
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

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        _price = price;
    }

    public double getDiscountPrice() {
        return _discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        _discountPrice = discountPrice;
    }

    public String getSku() {
        return _sku;
    }

    public void setSku(String sku) {
        _sku = sku;
    }

    public long getItemTypeId() {
        return _itemTypeId;
    }

    public void setItemTypeId(long itemTypeId) {
        _itemTypeId = itemTypeId;
    }
}
