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


<%@page import="com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.fsquare.shopping.NoSuchShoppingStoreException"%>
<%@ include file="init.jsp" %>

<%
// ShoppingShippingMethod shoppingShippingMethod = ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shippingMethodId);
List<ShoppingShippingMethod> shoppingShippingMethodList = ShoppingShippingMethodLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());

%>

<liferay-portlet:resourceURL var="deleteShippingURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_SHIPPING_METHOD %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openShippingFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_SHIPPING_METHOD %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveShippingURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_SHIPPING_METHOD %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="setDefaultShippingMethodURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SET_DEFAULT_SHIPPING_METHOD %>" />
</liferay-portlet:resourceURL>


<div>
	<h3>Shipping Methods</h3>
	<div class="shippings-table-wrapper" >
		<table class="settings-table shippings-table table table-bordered table-striped" id="<portlet:namespace />shippings-table" >
			<thead>
				<tr>
					<td>Name</td>
					<td>Description</td>
					<td>price</td>
					<td>freeQuantity</td>
					<td>freeTotal</td>
					<td>weight</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				
			<%
			  	for(ShoppingShippingMethod shoppingShippingMethod: shoppingShippingMethodList){
			  		long shippingMethodId = shoppingShippingMethod.getShippingMethodId();
		  	%>
				
				<tr id="<portlet:namespace />shipping-row-<%= shippingMethodId %>">
					<td id="<%= "shipping-name-"+shippingMethodId %>"> <%= shoppingShippingMethod.getName() %></td>
					<td id="<%= "shipping-description-"+shippingMethodId %>"><%= shoppingShippingMethod.getDescription() %></td>
					<td id="<%= "shipping-price-"+shippingMethodId %>"><%= shoppingShippingMethod.getPrice()%></td>
					<td id="<%= "shipping-free-quantity-"+shippingMethodId %>"><%= shoppingShippingMethod.getFreeQuantity() %></td>
					<td id="<%= "shipping-free-total-"+shippingMethodId %>"><%= shoppingShippingMethod.getFreeTotal() %></td>
					<td id="<%= "shipping-weight-"+shippingMethodId %>"><%= shoppingShippingMethod.getWeight()%></td>
					
					<td class="settings-actions">
					
						<% if(shoppingShippingMethod.getDefaultShipping()){ %>
							<a id='default-shipping<%= shippingMethodId %>' title="default shipping" href="javascript:;" class='fa fa-star'></a>	
							<a id='set-default-shipping<%= shippingMethodId %>' data-shipping-id="<%= shippingMethodId %>" title="set as default shipping" href="javascript:;" class="fa fa-star-o set-default-shipping hide"></a>
							
						<%
			  			}else{		  	
			 			%>
			 				<a id='default-shipping<%= shippingMethodId %>' title="set as default shipping" href="javascript:;" class='fa fa-star hide'></a>	
			 				<a id='set-default-shipping<%= shippingMethodId %>' data-shipping-id="<%= shippingMethodId %>" title="set as default shipping" href="javascript:;" class="fa fa-star-o set-default-shipping"></a>
			 			<%
			  			}
						%>
						<a class="open-shipping-btn fa fa-pencil-square" data-shipping-id="<%= shippingMethodId %>" title="edit" href="javascript:;"></a>
						<a class="fa fa-times-circle delete-shipping-btn" data-shipping-id="<%= shippingMethodId %>" title="delete" href="javascript:;"></a>
						
						<i class='fa fa-plane <%= shoppingShippingMethod.isInternational()?"":"hide" %>' id='international-shipping<%= shippingMethodId %>'></i>
					</td>
				</tr>
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
	</div>
	<div id="<portlet:namespace />shipping-table-error" class="error-message shipping-table-error"></div>
	<a class="btn open-new-shipping-btn" data-shipping-id="" href="javascript:;"><span class="fa fa-pencil-square"></span><span>New shipping method</span></a>
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker">
	
	Liferay.provide(window, '<portlet:namespace />showLoading',
		function(wrapper) {
		if(!wrapper){
			wrapper = '#p_p_id<portlet:namespace />';
		}
		$(wrapper).append('<div class="store-loading"><div class="spinner"><div class="rect1"></div><div class="rect2"></div><div class="rect3"></div><div class="rect4"></div><div class="rect5"></div></div></div>')	
	},['aui-base,selector-css3']);
	
	Liferay.provide(window, '<portlet:namespace />hideLoading',
		function(wrapper) {
		if(!wrapper){
			wrapper = '#p_p_id<portlet:namespace />'
		}
		$(wrapper).find(".store-loading").remove()
	},['aui-base,selector-css3']);
	
	
	Liferay.provide(window, '<portlet:namespace />saveShipping',
		function() {
			A.one("#<portlet:namespace />shipping-form-error").text('');
			A.io.request('<%= saveShippingURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  
	            	  <portlet:namespace />shippingMethodId : A.one('#<portlet:namespace />shippingMethodId').val(),
	            	  <portlet:namespace />name : A.one('#<portlet:namespace />name').val(),
	            	  <portlet:namespace />description : A.one('#<portlet:namespace />description').val(),
	            	  <portlet:namespace />price : A.one('#<portlet:namespace />price').val(),
	            	  <portlet:namespace />freeQuantity : A.one('#<portlet:namespace />freeQuantity').val(),
	            	  <portlet:namespace />freeTotal : A.one('#<portlet:namespace />freeTotal').val(),
	            	  <portlet:namespace />weight : A.one('#<portlet:namespace />weight').val(),
	            	  <portlet:namespace />defaultShipping : A.one('#<portlet:namespace />defaultShipping').val(),
	            	  <portlet:namespace />internationalShipping : A.one('#<portlet:namespace />internationalShipping').val()	            	  
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	if(response.success){
	                  		A.one('#<portlet:namespace />shipping_form').remove(true);
	                  		var shoppingShippingMethodJson = JSON.parse(response.shoppingShippingMethodJson);
	                  		var shippingMethodId = shoppingShippingMethodJson.shippingMethodId;

	                  		if(response.isNew){
	                  			var newRow = "<tr id='<portlet:namespace />shipping-row-"+shippingMethodId+"'>";
                				newRow += "<td id='shipping-name-"+shippingMethodId+"'>"+shoppingShippingMethodJson.name+"</td>";
	                  			newRow += "<td id='shipping-description-"+shippingMethodId+"'>"+shoppingShippingMethodJson.description+"</td>";
	                  			newRow += "<td id='shipping-price-"+shippingMethodId+"'>"+shoppingShippingMethodJson.price+"</td>";
                  				newRow += "<td id='shipping-free-quantity-"+shippingMethodId+"'>"+shoppingShippingMethodJson.freeQuantity+"</td>";
                				newRow += "<td id='shipping-free-total-"+shippingMethodId+"'>"+shoppingShippingMethodJson.freeTotal+"</td>";
                				newRow += "<td id='shipping-weight-"+shippingMethodId+"'>"+shoppingShippingMethodJson.weight+"</td>";
	                  			newRow += "<td class='shipping-actions'>";
	                  			
	                  			if(shoppingShippingMethodJson.defaultShipping){
	                  				newRow += "<a id='default-shipping"+shippingMethodId+"' title='default shipping' href='javascript:;' class='fa fa-star'></a>";
	                  				newRow += "<a id='set-default-shipping"+shippingMethodId+"' data-shipping-id='"+shippingMethodId+"' title='set as default shipping' href='javascript:;' class='fa fa-star-o set-default-shipping hide'></a>";

	                  			}else{
	                  				newRow += "<a id='default-shipping"+shippingMethodId+"' title='default shipping' href='javascript:;' class='fa fa-star hide'></a>";
	                  				newRow += "<a id='set-default-shipping"+shippingMethodId+"' data-shipping-id='"+shippingMethodId+"' title='set as default shipping' href='javascript:;' class='fa fa-star-o set-default-shipping'></a>";
	                  			}
	                  			
	                  			newRow += "<a class='open-shipping-btn fa fa-pencil-square' data-shipping-id='"+shippingMethodId+"' title='edit' href='javascript:;'></a>";
	                  			newRow += "<a class='fa fa-times-circle delete-shipping-btn' data-shipping-id='"+shippingMethodId+"' title='delete' href='javascript:;'></a>";
	                  			
	                  			newRow += "<i class='fa fa-plane "+ (shoppingShippingMethodJson.international?"":"hide") +"' id='international-shipping"+shippingMethodId+"'></i>";

	                  			
	                  			newRow += "</td>";
	                  			newRow = newRow+"</tr>";
	                  			A.one("#<portlet:namespace />shippings-table > tbody").append(newRow);
	                  		
	                  		}else{

	                  			A.one('#shipping-name-'+shippingMethodId).text(shoppingShippingMethodJson.name);
	                  			A.one('#shipping-price-'+shippingMethodId).text(shoppingShippingMethodJson.price);
	                  			A.one('#shipping-description-'+shippingMethodId).text(shoppingShippingMethodJson.description);
	                  			A.one('#shipping-free-quantity-'+shippingMethodId).text(shoppingShippingMethodJson.freeQuantity);
	                  			A.one('#shipping-free-total-'+shippingMethodId).text(shoppingShippingMethodJson.freeTotal);
	                  			A.one('#shipping-weight-'+shippingMethodId).text(shoppingShippingMethodJson.weight);
	                  			if(shoppingShippingMethodJson.defaultShipping){
									A.one('#set-default-shipping'+shippingMethodId).addClass('hide');
									A.one('#default-shipping'+shippingMethodId).removeClass('hide');
								}else{
									A.one('#set-default-shipping'+shippingMethodId).removeClass('hide');
									A.one('#default-shipping'+shippingMethodId).addClass('hide');
								}
	                  			
	                  			if(shoppingShippingMethodJson.international){
	                  				A.one('#international-shipping'+shippingMethodId).removeClass('hide');
	                  			}else{
	                  				A.one('#international-shipping'+shippingMethodId).addClass('hide');
	                  			}
	                  		}
	                  		if(response.oldDefaultId && response.oldDefaultId > 0){
								A.one('#set-default-shipping'+response.oldDefaultId).removeClass('hide');
								A.one('#default-shipping'+response.oldDefaultId).addClass('hide');
							}
	                  	}else{
	                  		A.one("#<portlet:namespace />shipping-form-error").text(response.errorMessage);
	                  	}
	                  	
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3']);

	A.on('click', function(event) {
		<portlet:namespace />setDefaultShippingMethod(this.getAttribute('data-shipping-id'));
	}, '.set-default-shipping');
	
	Liferay.provide(window, '<portlet:namespace />setDefaultShippingMethod',
			function(shippingMethodId) {
				
				A.io.request('<%= setDefaultShippingMethodURL %>',{
		              dataType: 'json',
		              method: 'POST',
		              data: {
		            	  <portlet:namespace />shippingMethodId : shippingMethodId
		              },
		              on: {
	                  	success: function() {
							var response = this.get('responseData');
							console.log("response.success: "+response.success);
							if(response.success){
								var shoppingShippingMethodJson = JSON.parse(response.shoppingShippingMethod);
								var shippingMethodId = shoppingShippingMethodJson.shippingMethodId;
								
								if(response.oldDefaultId && response.oldDefaultId > 0){
									A.one('#set-default-shipping'+response.oldDefaultId).removeClass('hide');
									A.one('#default-shipping'+response.oldDefaultId).addClass('hide');
								}
								
								if(shoppingShippingMethodJson.defaultShipping){
									A.one('#set-default-shipping'+shippingMethodId).addClass('hide');
									A.one('#default-shipping'+shippingMethodId).removeClass('hide');
								}else{
									A.one('#set-default-shipping'+shippingMethodId).removeClass('hide');
									A.one('#default-shipping'+shippingMethodId).addClass('hide');
								}
								
							}else{
								A.one("#<portlet:namespace />shipping-table-error").text(response.errorMessage);
							}
	                  	}
		              }
		        });
				
		    },
			['aui-base,selector-css3']);
	
	A.on('click', function(event) {
		<portlet:namespace />deleteShipping(this.getAttribute('data-shipping-id'));
	}, '.delete-shipping-btn');
	
	Liferay.provide(window, '<portlet:namespace />deleteShipping',
		function(shippingMethodId) {
			
			A.io.request('<%= deleteShippingURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />shippingMethodId : shippingMethodId
	              },
	              on: {
                  	success: function() {
						var response = this.get('responseData');
						if(response.success){
							A.one('#<portlet:namespace />shipping-row-'+shippingMethodId).remove(true);
						}else{
	                  		A.one("#<portlet:namespace />shipping-table-error").text(response.errorMessage);
						}
                  	}
	              }
	        });
			
	    },
		['aui-base,selector-css3']);
	
	A.on('click', function(event) {
		<portlet:namespace />openShippingForm(0);
	}, '.open-new-shipping-btn');

	A.on('click', function(event) {
		debug(this,event);
		<portlet:namespace />openShippingForm(this.getAttribute('data-shipping-id'));
	}, '.open-shipping-btn');
	
	Liferay.provide(window, '<portlet:namespace />openShippingForm',
		function(shippingMethodId) {
			console.log("shippingMethodId: "+shippingMethodId);
			A.io.request('<%= openShippingFormURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />shippingMethodId : shippingMethodId
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one('.shopping-shipping-management'));

	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);


</aui:script>
