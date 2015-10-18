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

<%@ include file="/mini-cart/init.jsp" %>

<%

//sess
//HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
//HttpSession session = request.getSession();
List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
int quantity = 0;
if(shoppingOrderItemList != null){
	for(ShoppingOrderItem orderItem: shoppingOrderItemList){
		quantity = quantity + orderItem.getQuantity();
	}
}

%>

<liferay-portlet:resourceURL var="addToCartURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_ADD_TO_CART %>" />
</liferay-portlet:resourceURL>


<a href="#cart" class="icon-cart cart-button" style=""> 
	<span>Cart</span>
	<span id="<portlet:namespace />cart-size"><%=quantity %></span>
</a>


<aui:script use="aui-base,selector-css3,aui-io-request">

	Liferay.provide(window, 'addToShoppingCart',
		function(assetId) {
			console.log("adding to cart: "+assetId);
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

