<%@page import="com.fsquare.shopping.model.ShoppingCoupon"%>
<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

ShoppingCoupon shoppingCoupon = (ShoppingCoupon)request.getAttribute(ShoppingPortletUtil.ATTR_COUPON);

// System.out.println(" -- Coupon Form -- "+shoppingCoupon);
// System.out.println("shoppingCoupon.getCouponId(): "+shoppingCoupon.getCouponId());

%>

<div class="modal" id="<portlet:namespace />coupon_form">
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />coupon_form').remove();">×</button>
		<h3>Modal Heading</h3>
	</div>
	<div class="modal-body">
		<aui:form id='coupon-form'>
			<div class="form-inline">			
				<aui:input name="code" type="text" value="<%= shoppingCoupon.getCode() %>" placeholder="Code"/>
				<aui:input name="name" type="text" value="<%= shoppingCoupon.getName() %>" placeholder="Name"/>
				<aui:input name="description" type="text" value="<%= shoppingCoupon.getDescription() %>" placeholder="Description" />
				<aui:input name="discount" type="text" value="<%= shoppingCoupon.getDiscount() %>" placeholder="Discount"/>
				<aui:select label="discount-type" name="discountType">
					<aui:option selected="<%= shoppingCoupon.getDiscountType().equals(ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE) %>" value="<%= ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE %>">percentage</aui:option>
					<aui:option selected="<%= shoppingCoupon.getDiscountType().equals(ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE) %>" value="<%= ShoppingPortletUtil.DISCOUNT_TYPE_VALUE %>">value</aui:option>
				</aui:select>
				<aui:input name="startDate" type="text" value='<%= Validator.isNotNull(shoppingCoupon.getStartDate())?dateFormat.format(shoppingCoupon.getStartDate()):"" %>' placeholder="Start Date"/>
				<aui:input name="endDate" type="text" value='<%= Validator.isNotNull(shoppingCoupon.getEndDate())?dateFormat.format(shoppingCoupon.getEndDate()):"" %>' placeholder="End Date"/>
				
				<aui:input name="limitCategories" type="text" value="<%= shoppingCoupon.getLimitCategories() %>" placeholder="Limit Categories"/>
				<aui:input name="limitSkus" type="text" value="<%= shoppingCoupon.getLimitSkus() %>" placeholder="Limit Skus"/>
				<aui:input name="minOrder" type="number" value="<%= shoppingCoupon.getMinOrder() %>" placeholder="Min Order"/>
				<aui:input name="active" type="checkbox" value="<%= shoppingCoupon.getActive() %>"/>
				
			</div>
			<div id="<portlet:namespace />coupon-form-error" class="error-message coupon-form-error">
				
			</div>
		</aui:form>
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />coupon_form').remove();" >Close</button>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace />saveCoupon()">Save</button>
	</div>
	
</div>