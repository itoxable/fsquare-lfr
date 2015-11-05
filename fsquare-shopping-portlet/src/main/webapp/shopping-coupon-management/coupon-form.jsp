<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.fsquare.shopping.model.ShoppingCoupon"%>
<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

ShoppingCoupon shoppingCoupon = (ShoppingCoupon)request.getAttribute(ShoppingPortletUtil.ATTR_COUPON);

// System.out.println(" -- Coupon Form -- "+shoppingCoupon);
// System.out.println("shoppingCoupon.getCouponId(): "+shoppingCoupon.getCouponId());

Date endDate = shoppingCoupon.getEndDate();
Date startDate = shoppingCoupon.getStartDate();

//System.out.println("endDate")

Calendar endCalendar = CalendarFactoryUtil.getCalendar(timeZone, locale);

if (endDate != null) {
	endCalendar.setTime(endDate);
}

Calendar startCalendar = CalendarFactoryUtil.getCalendar(timeZone, locale);

if (startDate != null) {
	startCalendar.setTime(startDate);
}
// else {
// 	startCalendar.add(Calendar.DATE, -1);
// }
%>

<div class="modal" id="<portlet:namespace />coupon_form">
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />coupon_form').remove();">×</button>
		<h3>Modal Heading</h3>
	</div>
	<div class="modal-body">
		<aui:form id='coupon-form'>
			<div class="">	
				<aui:input name="couponId" type="hidden" value="<%= shoppingCoupon.getCouponId() %>" />
				<aui:input name="code" type="text" value="<%= shoppingCoupon.getCode() %>" placeholder="Code"/>
				<aui:input name="name" type="text" value="<%= shoppingCoupon.getName() %>" placeholder="Name"/>
				<aui:input name="description" type="text" value="<%= shoppingCoupon.getDescription() %>" placeholder="Description" />
				<aui:input name="discount" type="text" value="<%= shoppingCoupon.getDiscount() %>" placeholder="Discount"/>
				<aui:select label="discount-type" name="discountType">
					<aui:option selected="<%= ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE.equals(shoppingCoupon.getDiscountType()) %>" value="<%= ShoppingPortletUtil.DISCOUNT_TYPE_PERCENTAGE %>">percentage</aui:option>
					<aui:option selected="<%= ShoppingPortletUtil.DISCOUNT_TYPE_VALUE.equals(shoppingCoupon.getDiscountType()) %>" value="<%= ShoppingPortletUtil.DISCOUNT_TYPE_VALUE %>">value</aui:option>
				</aui:select>
				
				<c:choose>
					<c:when test="<%= Validator.isNotNull(startDate) %>">
						<div class="control-group">
							<label class="control-label" for="<portlet:namespace/>startDate"><%=LanguageUtil.get(locale, "start-date") %><label>
							<liferay-ui:input-date dayParam="startDateDay" dayValue="<%= startCalendar.get(Calendar.DATE) %>" firstDayOfWeek="<%= startCalendar.getFirstDayOfWeek() %>" monthParam="startDateMonth" monthValue="<%= startCalendar.get(Calendar.MONTH) %>" name="startDate" yearParam="startDateYear" yearValue="<%= startCalendar.get(Calendar.YEAR) %>"></liferay-ui:input-date>
						</div>
					</c:when>
					<c:otherwise>
						<div class="control-group">
							<label class="control-label" for="<portlet:namespace/>startDate"><%=LanguageUtil.get(locale, "start-date") %><label>
							<liferay-ui:input-date dayParam="startDateDay" disabled="<%= false %>" monthParam="startDateMonth" name="startDate" yearParam="startDateYear"></liferay-ui:input-date>
						</div>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="<%= Validator.isNotNull(endDate) %>">
						<div class="control-group">
							<label class="control-label" for="<portlet:namespace/>endDate"><%=LanguageUtil.get(locale, "end-date") %><label>
							<liferay-ui:input-date dayParam="endDateDay" dayValue="<%= endCalendar.get(Calendar.DATE) %>" firstDayOfWeek="<%= endCalendar.getFirstDayOfWeek() %>" monthParam="endDateMonth" monthValue="<%= endCalendar.get(Calendar.MONTH) %>" name="endDate" yearParam="endDateYear" yearValue="<%= endCalendar.get(Calendar.YEAR) %>"></liferay-ui:input-date>
						</div>
					</c:when>
					<c:otherwise>
						<div class="control-group">
							<label class="control-label" for="<portlet:namespace/>endDate"><%=LanguageUtil.get(locale, "end-date") %><label>
						<liferay-ui:input-date dayParam="endDateDay" disabled="<%= false %>" monthParam="endDateMonth" name="endDate" yearParam="startDateYear"></liferay-ui:input-date>
						</div>
					</c:otherwise>
				</c:choose>
				
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