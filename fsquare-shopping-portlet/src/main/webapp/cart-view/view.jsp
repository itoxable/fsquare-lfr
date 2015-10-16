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


<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
<%@ include file="/cart-view/init.jsp" %>

<%

List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
int quantity = 0;
System.out.println("portletSession: "+portletSession);
if(shoppingOrderItemList == null){
	shoppingOrderItemList = new ArrayList<ShoppingOrderItem>();
}

%>
<liferay-portlet:resourceURL var="removeFromCartURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_REMOVE_FROM_CART %>" />
</liferay-portlet:resourceURL>
<table class="account-table cart-table">
	<tbody>
		<tr class="table-header">
		    <td></td>
		    <td></td>
		    <td>PRODUCT</td>
		    <td align="center">QTY</td>
		    <td align="right">PRICE</td>
	  	</tr>
	  	
	  	<%
	  	for(ShoppingOrderItem orderItem: shoppingOrderItemList){
	  		AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(Long.parseLong(orderItem.getEntryId()));
	  	%>
	    <tr>
		    <td>
		      	<a href="javascript:;" data-asset-id="<%= orderItem.getEntryId() %>" class='remove-from-shopping-cart-button' title="remove">x</a>
		    </td>
		    <td>      
		    	<img src="<%=orderItem.getQuantity() %>" alt="" class="cart-item-img">
		    </td>
		    
		    <td>
		      	<strong><%=assetEntry.getTitle(themeDisplay.getSiteDefaultLocale()) %></strong>
		    </td>
		    
		    <td align="center">
		    	<%=orderItem.getQuantity() %>
		    </td>          
	    	<td>
	    		£<span class="cart-item-price">XX</span>
	    	</td>
	  	</tr>
    	<%
    	}
	  	%>
    
  
  	</tbody>
</table>

<aui:script use="aui-base,selector-css3,aui-io-request">

	var removeFromShoppingCartButton = A.all('.remove-from-shopping-cart-button');
	removeFromShoppingCartButton.on('click', function(event) {
		debug(this, A.one(this));
		var assetId = A.one(this).getAttribute('data-asset-id');
		removeFromShoppingCart(assetId);
	});

	Liferay.provide(window, 'removeFromShoppingCart',
		function(assetId) {
			console.log("adding to cart: "+assetId);
        	A.io.request('<%= removeFromCartURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: {
                	  <portlet:namespace />entryId: assetId
                  },
                  on: {
                      success: function() {
                      	var response = this.get('responseData');
                      	//A.one('#<portlet:namespace />cart-size').set('text', response.size);
                      }
                  }
            });
			
        },
    	['aui-base,selector-css3']);
  
</aui:script>