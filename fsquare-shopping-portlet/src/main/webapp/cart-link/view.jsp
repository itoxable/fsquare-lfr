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

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portlet.shopping.model.ShoppingCart" %>
<%@page import="com.liferay.portlet.shopping.model.ShoppingCartItem" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/cart-link/init.jsp" %>

<%

List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)portletSession.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
int quantity = 0;
System.out.println("portletSession: "+portletSession);
if(shoppingOrderItemList != null){
	for(ShoppingOrderItem orderItem: shoppingOrderItemList){
		quantity = quantity + orderItem.getQuantity();
//	 	System.out.println("orderItem.getQuantity(): "+orderItem.getQuantity());
	}
}

%>

<liferay-portlet:resourceURL var="addToCartURL">
	<portlet:param name="<%= Constants.CMD %>" value="addToCart" />
</liferay-portlet:resourceURL>


<a href="#cart" class="icon-cart cart-button" style=""> 
<span>Cart</span>
<span id="<portlet:namespace />cart-size"><%=quantity %></span>
</a>

<a href="javascript:;" data-asset-id='22218' id="<portlet:namespace />addToCartButton" class="add-to-cart-button" style="display: block; padding: 10px; border: 1px solid black; margin: 10px">Add to cart</a>

<aui:script use="aui-base,selector-css3,aui-io-request">

	var addToCartButton = A.one('#<portlet:namespace />addToCartButton');
	addToCartButton.on('click', function(event) {
		debug(this, A.one(this));
		var assetId = A.one(this).getAttribute('data-asset-id');
		addToCart(assetId);
	});

	Liferay.provide(window, 'addToCart',
		function(assetId) {
			
        	A.io.request('<%= addToCartURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: {
                	  <portlet:namespace />entryId: assetId
                  },
                  on: {
                      success: function() {
                      	var response = this.get('responseData');
                      	A.one('#<portlet:namespace />cart-size').set('text', response.size);
                      }
                  }
            });
			
        },
    	['aui-base,selector-css3']);
  
</aui:script>

