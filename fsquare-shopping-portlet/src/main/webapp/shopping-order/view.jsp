<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>


<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrder"%>
<%@ include file="/shopping-order/init.jsp" %>

<%
Calendar cal = Calendar.getInstance();
int thisYear = cal.get(Calendar.YEAR);
List<Country> countries = CountryServiceUtil.getCountries();

ShoppingOrder shoppingOrder = (ShoppingOrder)session.getAttribute(ShoppingPortletUtil.SESSION_ORDER_OBJECT);
Map<String,ShoppingOrderItem> shoppingOrderItemMap = (Map<String,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);


if(shoppingStore.getIntegrateWithStripe()){
%>				
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<%
}
%>
<div class="row" id='<portlet:namespace />checkout-wrapper'>
	<div class="span8" >
		<div class="checkout-panel">
			<div class="checkout-panel-title"><h3>Shipping address</h3><a class="edit-button">edit</a></div>
			<div id='<portlet:namespace />shipping-address-wrapper'>
				<%@ include file="/shopping-order/address-form.jsp" %>
			</div>
		</div>
		
		<div class="checkout-panel">
			<div class="checkout-panel-title"><h3>Delivery Options</h3><a class="edit-button">edit</a></div>
			<div id='<portlet:namespace />shipping-method-wrapper'></div>
		</div>
		
		<div class="checkout-panel">
			<div class="checkout-panel-title"><h3>Billing</h3><a class="edit-button">edit</a></div>
			<div id='<portlet:namespace />payment-form-wrapper'>
			</div>
		</div>
	
	</div>
	<div class="span4">
		<liferay-portlet:runtime portletName="cartview_WAR_fsquareshoppingportlet" />
	</div>
</div>
