create unique index IX_903D52DA on FsquareShopping_ShoppingCoupon (code_);
create index IX_611A1742 on FsquareShopping_ShoppingCoupon (groupId);

create index IX_E4C93792 on FsquareShopping_ShoppingOrder (groupId);
create index IX_BFF8FA5C on FsquareShopping_ShoppingOrder (groupId, userId, ppPaymentStatus);
create unique index IX_9F8ACACE on FsquareShopping_ShoppingOrder (number_);
create index IX_BC28DFDD on FsquareShopping_ShoppingOrder (ppTxnId);
create index IX_E827EFE on FsquareShopping_ShoppingOrder (status);

create index IX_DC4F13F2 on FsquareShopping_ShoppingOrderItem (entryId);
create index IX_E18AC4CE on FsquareShopping_ShoppingOrderItem (orderId);