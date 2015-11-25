package com.fsquare.shopping.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the orderCreatedEmailTemplate column in ShoppingStore.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStore
 * @generated
 */
public class ShoppingStoreOrderCreatedEmailTemplateBlobModel {
    private long _groupId;
    private Blob _orderCreatedEmailTemplateBlob;

    public ShoppingStoreOrderCreatedEmailTemplateBlobModel() {
    }

    public ShoppingStoreOrderCreatedEmailTemplateBlobModel(long groupId) {
        _groupId = groupId;
    }

    public ShoppingStoreOrderCreatedEmailTemplateBlobModel(long groupId,
        Blob orderCreatedEmailTemplateBlob) {
        _groupId = groupId;
        _orderCreatedEmailTemplateBlob = orderCreatedEmailTemplateBlob;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public Blob getOrderCreatedEmailTemplateBlob() {
        return _orderCreatedEmailTemplateBlob;
    }

    public void setOrderCreatedEmailTemplateBlob(
        Blob orderCreatedEmailTemplateBlob) {
        _orderCreatedEmailTemplateBlob = orderCreatedEmailTemplateBlob;
    }
}
