package com.fsquare.shopping.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the orderShippedEmailTemplate column in ShoppingStore.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStore
 * @generated
 */
public class ShoppingStoreOrderShippedEmailTemplateBlobModel {
    private long _groupId;
    private Blob _orderShippedEmailTemplateBlob;

    public ShoppingStoreOrderShippedEmailTemplateBlobModel() {
    }

    public ShoppingStoreOrderShippedEmailTemplateBlobModel(long groupId) {
        _groupId = groupId;
    }

    public ShoppingStoreOrderShippedEmailTemplateBlobModel(long groupId,
        Blob orderShippedEmailTemplateBlob) {
        _groupId = groupId;
        _orderShippedEmailTemplateBlob = orderShippedEmailTemplateBlob;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public Blob getOrderShippedEmailTemplateBlob() {
        return _orderShippedEmailTemplateBlob;
    }

    public void setOrderShippedEmailTemplateBlob(
        Blob orderShippedEmailTemplateBlob) {
        _orderShippedEmailTemplateBlob = orderShippedEmailTemplateBlob;
    }
}
