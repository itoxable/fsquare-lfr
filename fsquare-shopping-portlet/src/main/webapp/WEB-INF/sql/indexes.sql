create unique index IX_903D52DA on FsquareShopping_ShoppingCoupon (code_);
create unique index IX_295C450E on FsquareShopping_ShoppingCoupon (code_, companyId);
create unique index IX_93AEB710 on FsquareShopping_ShoppingCoupon (code_, groupId);
create index IX_497060C0 on FsquareShopping_ShoppingCoupon (companyId);
create index IX_611A1742 on FsquareShopping_ShoppingCoupon (groupId);

create index IX_26A377F3 on FsquareShopping_ShoppingItem (companyId);
create index IX_27F5F35 on FsquareShopping_ShoppingItem (groupId);
create index IX_BCDD3AFF on FsquareShopping_ShoppingItem (uuid_);
create index IX_4DE843C9 on FsquareShopping_ShoppingItem (uuid_, companyId);
create unique index IX_711288B on FsquareShopping_ShoppingItem (uuid_, groupId);

create index IX_46FCE296 on FsquareShopping_ShoppingItemImage (companyId);
create index IX_54E2F018 on FsquareShopping_ShoppingItemImage (companyId, itemId);
create unique index IX_A690573A on FsquareShopping_ShoppingItemImage (companyId, itemId, mainImage);
create index IX_76691698 on FsquareShopping_ShoppingItemImage (groupId);
create index IX_6764021A on FsquareShopping_ShoppingItemImage (groupId, itemId);
create unique index IX_36734FF8 on FsquareShopping_ShoppingItemImage (groupId, itemId, mainImage);

create index IX_89804801 on FsquareShopping_ShoppingItemStorageLocation (companyId);
create index IX_42CCDAC3 on FsquareShopping_ShoppingItemStorageLocation (groupId);
create index IX_3265F649 on FsquareShopping_ShoppingItemStorageLocation (itemId);
create unique index IX_58F7CE92 on FsquareShopping_ShoppingItemStorageLocation (itemId, storageLocationId);
create index IX_836CBE54 on FsquareShopping_ShoppingItemStorageLocation (storageLocationId);

create index IX_27F72659 on FsquareShopping_ShoppingItemType (companyId);
create index IX_69976F1B on FsquareShopping_ShoppingItemType (groupId);
create unique index IX_70DFB07A on FsquareShopping_ShoppingItemType (name, companyId);
create unique index IX_5DAE0D7C on FsquareShopping_ShoppingItemType (name, groupId);

create index IX_9DD8AD10 on FsquareShopping_ShoppingOrder (companyId);
create index IX_4B1EBD0A on FsquareShopping_ShoppingOrder (companyId, shippingEmailAddress);
create index IX_F2DFF54A on FsquareShopping_ShoppingOrder (companyId, userId);
create index IX_C41774E on FsquareShopping_ShoppingOrder (externalPaymentId);
create index IX_E4C93792 on FsquareShopping_ShoppingOrder (groupId);
create index IX_27DB9A0C on FsquareShopping_ShoppingOrder (groupId, shippingEmailAddress);
create index IX_7866DDCC on FsquareShopping_ShoppingOrder (groupId, userId);
create index IX_BFF8FA5C on FsquareShopping_ShoppingOrder (groupId, userId, ppPaymentStatus);
create unique index IX_9F8ACACE on FsquareShopping_ShoppingOrder (number_);
create index IX_B5CEB978 on FsquareShopping_ShoppingOrder (paymentType);
create index IX_BC28DFDD on FsquareShopping_ShoppingOrder (ppTxnId);
create index IX_B7835236 on FsquareShopping_ShoppingOrder (shippingMethodId);
create index IX_E827EFE on FsquareShopping_ShoppingOrder (status);

create index IX_8B900DB6 on FsquareShopping_ShoppingOrderItem (articleId);
create index IX_B7B98546 on FsquareShopping_ShoppingOrderItem (shoppingOrderId);
create index IX_40F32E79 on FsquareShopping_ShoppingOrderItem (shoppingOrderItemId);

create index IX_F5B36B57 on FsquareShopping_ShoppingShippingMethod (companyId);
create index IX_E4DA1107 on FsquareShopping_ShoppingShippingMethod (companyId, disabled);
create index IX_DFCF186E on FsquareShopping_ShoppingShippingMethod (defaultShipping);
create index IX_FAFCDB99 on FsquareShopping_ShoppingShippingMethod (groupId);
create index IX_140D96C9 on FsquareShopping_ShoppingShippingMethod (groupId, disabled);

create index IX_27E9A14E on FsquareShopping_ShoppingStorageLocation (companyId);
create index IX_62662350 on FsquareShopping_ShoppingStorageLocation (groupId);

create index IX_8BF11C1F on FsquareShopping_ShoppingStore (groupId);