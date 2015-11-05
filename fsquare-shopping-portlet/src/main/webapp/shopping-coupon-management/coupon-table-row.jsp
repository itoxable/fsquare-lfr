
		
<tr id="<portlet:namespace />coupon-row-<%= shoppingCoupon.getCouponId() %>">
	<td id="<%= "coupon-code-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getCode() %></td>
	<td id="<%= "coupon-name-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getName() %></td>
	<td id="<%= "coupon-description-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getDescription() %></td>
	<td id="<%= "coupon-start-"+shoppingCoupon.getCouponId() %>"><%= Validator.isNotNull(shoppingCoupon.getStartDate())?dateFormat.format(shoppingCoupon.getStartDate()):"" %></td>
	<td id="<%= "coupon-end-"+shoppingCoupon.getCouponId() %>"><%= Validator.isNotNull(shoppingCoupon.getEndDate())?dateFormat.format(shoppingCoupon.getEndDate()):"" %></td>
	<td id="<%= "coupon-active-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getActive() %></td>
	<td id="<%= "coupon-categories-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getLimitCategories() %></td>
	<td id="<%= "coupon-skus-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getLimitSkus() %></td>
	<td id="<%= "coupon-minorder-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getMinOrder() %></td>
	<td id="<%= "coupon-discount-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getDiscount() %></td>
	<td id="<%= "coupon-discount-type-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getDiscountType() %></td>
	<td class="coupon-actions">
		<a class="open-coupon-btn fa fa-pencil-square" data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="edit" href="javascript:;"></a>
		<a class="fa fa-times-circle delete-coupon-btn" data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="delete" href="javascript:;"></a>
	</td>
</tr>
