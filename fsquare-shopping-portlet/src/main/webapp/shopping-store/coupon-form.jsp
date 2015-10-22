<%@page import="com.fsquare.shopping.model.ShoppingCoupon"%>
<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

ShoppingCoupon shoppingCoupon = (ShoppingCoupon)request.getAttribute(ShoppingPortletUtil.ATTR_COUPON);
System.out.println(" -- Coupon Form -- "+shoppingCoupon);
%>

<div class="modal" >
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3>Modal Heading</h3>
	</div>
	<div class="modal-body">
		<aui:form id='coupon-form'>
			<div class="form-inline">
				<aui:input name="couponId" type="text" value="<%= shoppingCoupon.getCouponId() %>" disabled="true"  />
				<aui:input name="code" type="text" value="<%= shoppingCoupon.getCode() %>" placeholder="Code"/>
				<aui:input name="name" type="text" value="<%= shoppingCoupon.getName() %>" placeholder="Name"/>
				<aui:input name="description" type="text" value="<%= shoppingCoupon.getDescription() %>" placeholder="Description"/>
				<aui:input name="discount" type="text" value="<%= shoppingCoupon.getDiscount() %>" placeholder="Discount"/>
				<aui:select label="discount-type" name="discountType">
					<aui:option selected="<%= shoppingCoupon.getDiscountType().equals(ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE) %>" value="<%= ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE %>">percentage</aui:option>
					<aui:option selected="<%= shoppingCoupon.getDiscountType().equals(ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE) %>" value="<%= ShoppingPortletUtil.DISCOUNT_TYPE_VALUE %>">value</aui:option>
				</aui:select>
				<aui:input name="startDate" type="text" value="<%= shoppingCoupon.getStartDate() %>" placeholder="Start Date"/>
				<aui:input name="endDate" type="text" value="<%= shoppingCoupon.getEndDate() %>" placeholder="End Date"/>
				<aui:input name="limitCategories" type="text" value="<%= shoppingCoupon.getLimitCategories() %>" placeholder="Limit Categories"/>
				<aui:input name="limitSkus" type="text" value="<%= shoppingCoupon.getLimitSkus() %>" placeholder="Limit Skus"/>
				<aui:input name="minOrder" type="number" value="<%= shoppingCoupon.getMinOrder() %>" placeholder="Min Order"/>
				<aui:input name="active" type="checkbox" value="<%= shoppingCoupon.getActive() %>"/>
				
			</div>
		</aui:form>
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" >Close</button>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace />saveCoupon()">Save</button>
	</div>
	<script>
	
	    $("#<portlet:namespace />startDate").datepicker();
	    $("#<portlet:namespace />endDate").datepicker();
	  
	</script>
	
</div>