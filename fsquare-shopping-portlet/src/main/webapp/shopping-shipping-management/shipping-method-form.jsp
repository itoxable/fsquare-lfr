<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

ShoppingShippingMethod shoppingShippingMethod = (ShoppingShippingMethod)request.getAttribute(ShoppingPortletUtil.ATTR_SHIPPING);

%>
		
<div class="modal" id="<portlet:namespace />shipping_form">
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />shipping_form').remove();">×</button>
		<h3>Modal Heading</h3>
	</div>
	<div class="modal-body">
		<aui:form id='shipping-form'>
			<div class="">	
				<aui:input name="shippingMethodId" type="hidden" value="<%= shoppingShippingMethod.getShippingMethodId()%>" />
				<aui:input name="name" type="text" value="<%= shoppingShippingMethod.getName() %>" placeholder="Name"/>
				<aui:input name="description" type="text" value="<%= shoppingShippingMethod.getDescription() %>" placeholder="Description" />
				<aui:input name="price" type="text" value="<%= shoppingShippingMethod.getPrice() %>" placeholder="Price"/>
				<aui:input name="freeQuantity" type="text" value="<%= shoppingShippingMethod.getFreeQuantity() %>" placeholder="freeQuantity"/>
				<aui:input name="freeTotal" type="text" value="<%= shoppingShippingMethod.getFreeTotal() %>" placeholder="freeTotal"/>
				<aui:input name="weight" type="number" value="<%= shoppingShippingMethod.getWeight() %>" placeholder="weight"/>
				<aui:input name="defaultShipping" type="checkbox" value="<%= shoppingShippingMethod.getDefaultShipping() %>"/>
				<aui:input name="internationalShipping" type="checkbox" value="<%= shoppingShippingMethod.isInternational() %>"/>
			</div>
			<div id="<portlet:namespace />shipping-form-error" class="error-message shipping-form-error">
				
			</div>
		</aui:form>
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />shipping_form').remove();" >Close</button>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace />saveShipping()">Save</button>
	</div>
	
</div>