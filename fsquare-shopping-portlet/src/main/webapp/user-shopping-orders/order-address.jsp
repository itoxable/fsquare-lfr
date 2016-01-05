<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrder"%>
<%@page import="com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%

ShoppingShippingMethod shoppingShippingMethod = (ShoppingShippingMethod)request.getAttribute(ShoppingPortletUtil.ATTR_SHIPPING);
ShoppingOrder shoppingOrder = (ShoppingOrder)request.getAttribute(ShoppingPortletUtil.ATTR_SHOPPING_ORDER);

Country country = CountryServiceUtil.fetchCountryByA2(shoppingOrder.getShippingCountry());
%>

<div class="modal" id="<portlet:namespace />shipping_address">
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />shipping_address').remove();">×</button>
		<h3>Shipping</h3>
	</div>
	<div class="modal-body">
		<div class="shipping-method">
			<span><%=shoppingShippingMethod.getName()+" - "+ shoppingShippingMethod.getDescription() %></span>
		</div>
		<h4>To:</h4>
		<div class="address-fields">
			<h5 class="subtitle">Your Email Address</h5>
			<div><%=shoppingOrder.getShippingEmailAddress() %></div>
			<br>
			<h5 class="subtitle">Shipping Address</h5>
			<div><%=shoppingOrder.getShippingFirstName() +" "+ shoppingOrder.getShippingLastName()  %> </div>
			<div><%=shoppingOrder.getShippingStreet() %></div>
			<div><%=shoppingOrder.getShippingStreet2() %></div>
			<div><%=shoppingOrder.getShippingCity() +" "+ shoppingOrder.getShippingPostCode() %></div>
			<div><%=country.getName(themeDisplay.getLocale()) %></div>
			<div><%=shoppingOrder.getShippingPhone() %></div>
		</div>
		
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />shipping_address').remove();" >Close</button>
	</div>
	
</div>