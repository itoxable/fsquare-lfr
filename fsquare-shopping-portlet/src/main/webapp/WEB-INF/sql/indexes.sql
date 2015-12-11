create unique index IX_903D52DA on FsquareShopping_ShoppingCoupon (code_);
create index IX_611A1742 on FsquareShopping_ShoppingCoupon (groupId);

create index IX_C41774E on FsquareShopping_ShoppingOrder (externalPaymentId);
create index IX_E4C93792 on FsquareShopping_ShoppingOrder (groupId);
create index IX_BFF8FA5C on FsquareShopping_ShoppingOrder (groupId, userId, ppPaymentStatus);
create unique index IX_9F8ACACE on FsquareShopping_ShoppingOrder (number_);
create index IX_B5CEB978 on FsquareShopping_ShoppingOrder (paymentType);
create index IX_BC28DFDD on FsquareShopping_ShoppingOrder (ppTxnId);
create index IX_B7835236 on FsquareShopping_ShoppingOrder (shippingMethodId);
create index IX_E827EFE on FsquareShopping_ShoppingOrder (status);

create index IX_8B900DB6 on FsquareShopping_ShoppingOrderItem (articleId);
create index IX_B7B98546 on FsquareShopping_ShoppingOrderItem (shoppingOrderId);
create index IX_40F32E79 on FsquareShopping_ShoppingOrderItem (shoppingOrderItemId);

create index IX_DFCF186E on FsquareShopping_ShoppingShippingMethod (defaultShipping);
create index IX_FAFCDB99 on FsquareShopping_ShoppingShippingMethod (groupId);

create index IX_8BF11C1F on FsquareShopping_ShoppingStore (groupId);