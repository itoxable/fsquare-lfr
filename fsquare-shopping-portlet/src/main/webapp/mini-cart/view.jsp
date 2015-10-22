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


<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portlet.shopping.model.ShoppingCart" %>
<%@page import="com.liferay.portlet.shopping.model.ShoppingCartItem" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/mini-cart/init.jsp" %>

<%


Map<Long,ShoppingOrderItem> shoppingOrderItemMap = (Map<Long,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
int quantity = 0;
if(shoppingOrderItemMap != null){
	for(Map.Entry<Long, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
		quantity = quantity + entry.getValue().getQuantity();
	}
}


Layout cartPageLayout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(shoppingStore.getCartPageUuid(), themeDisplay.getScopeGroupId(), false);
NavItem cartPageNavItem = new NavItem(request, cartPageLayout, null);

Layout checkoutPageLayout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(shoppingStore.getCheckoutPageUuid(), themeDisplay.getScopeGroupId(), false);
NavItem checkoutPageNavItem = new NavItem(request, checkoutPageLayout, null);

%>


<liferay-portlet:resourceURL var="addToCartURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_ADD_TO_CART %>" />
</liferay-portlet:resourceURL>

<a href="<%= cartPageNavItem.getURL() %>" id="<portlet:namespace />shopping-cart-link" class="shopping-cart-link" style='<%= quantity==0?"display:none":""%>'>
	<span class="fa fa-shopping-cart cart-icon"></span>
	<span>Cart</span>
	<span id="<portlet:namespace />cart-size">(<%=quantity %>)</span>
</a>

<aui:script use="aui-base,selector-css3,aui-io-request">

	Liferay.provide(window, 'addToShoppingCart',
		function(articleId) {
			console.log("adding to cart: "+articleId);
        	A.io.request('<%= addToCartURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: {
                	  <portlet:namespace />articleId: articleId
                  },
                  on: {
                      success: function() {
                      	var response = this.get('responseData');
                      	if(response.success){
                          	A.one('#<portlet:namespace />cart-size').set('text', '('+response.size+')');
							if(response.redirect){
								window.location.href = '<%= cartPageNavItem.getRegularURL() %>';
							}else{
								A.one('#<portlet:namespace />shopping-cart-link').setStyle('display', 'block');
							}
                      	}
                      		
                      }
                  }
            });
			
        },
    	['aui-base,selector-css3']);
  
</aui:script>

