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
<%@ include file="init.jsp" %>

<%

if(shoppingStore.getIntegrateWithStripe() && !isCartEmpty){

%>				
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<%
}
%>
<c:choose>
	<c:when test="<%= isCartEmpty %>">
		<div class="checkout-panel" >
			<h2>Empty Cart</h2>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-portlet:resourceURL var="getCheckoutStepURL" secure="false">
			<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_GET_CHECKOUT_STEP %>" />
		</liferay-portlet:resourceURL>
		<liferay-portlet:resourceURL var="calculateShippingPriceURL" secure="false">
			<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_CALCULATE_SHIPPING_PRICE %>" />
		</liferay-portlet:resourceURL>
		
		

		<div class="row" id='<portlet:namespace />checkout-wrapper'>
			<div class="span7" >
				<div class="checkout-panel" id='<portlet:namespace />checkout-panel-address'>
					<div class="checkout-panel-title"><h3>Shipping address</h3><a class="checkout-edit-button" data-step="1" >edit</a></div>
					<div id='<portlet:namespace />shipping-address-wrapper' class="checkout-item-wrapper">
						<jsp:include page="address-form.jsp" />
					</div>
				</div>
				
				<div class="checkout-panel" id='<portlet:namespace />checkout-panel-shipping'>
					<div class="checkout-panel-title"><h3>Delivery Options</h3><a class="checkout-edit-button" data-step="2">edit</a></div>
					<div id='<portlet:namespace />shipping-method-wrapper' class="checkout-item-wrapper"></div>
				</div>
				
				<div class="checkout-panel" id='<portlet:namespace />checkout-panel-payment'>
					<div class="checkout-panel-title"><h3>Billing</h3><a class="checkout-edit-button" data-step="3">edit</a></div>
					<div id='<portlet:namespace />payment-form-wrapper' class="checkout-item-wrapper">
					</div>
				</div>
			
			</div>
			<div class="span5">
				<div class="checkout-panel" id='<portlet:namespace />checkout-order-summary'>
				<div class="checkout-panel-title"><h3>Summary</h3></div>
					<jsp:include page="order_summary.jsp" />
				</div>
			</div>
		</div>
		
		<aui:script use="aui-base,selector-css3,aui-io-request">
		
			A.on('click', function(event) {
				
				var step = this.getAttribute('data-step');
				<portlet:namespace />loadStep(step);
				
			},'.checkout-edit-button');
		
			Liferay.provide(window, '<portlet:namespace />showLoading',
					function(wrapper) {
				
				$(wrapper).append('<div class="checkout-loading"><div class="spinner"><div class="rect1"></div><div class="rect2"></div><div class="rect3"></div><div class="rect4"></div><div class="rect5"></div></div></div>')	
			},['aui-base,selector-css3']);
			
			Liferay.provide(window, '<portlet:namespace />hideLoading',
					function(wrapper) {
				$(wrapper).find(".checkout-loading").remove()
			},['aui-base,selector-css3']);
		
			
			Liferay.provide(window, '<portlet:namespace />loadStep',
					function(step) {
						var wrapper = "";
						if(step == 1){
							wrapper = "#<portlet:namespace />shipping-address-wrapper";
						}else if(step == 2){
							wrapper = "#<portlet:namespace />shipping-method-wrapper";
						}else if(step == 3){
							wrapper = "#<portlet:namespace />payment-form-wrapper";
						}
				
						A.io.request('<%= getCheckoutStepURL %>',{
			                  dataType: 'json',
			                  method: 'POST',
			                  data: {
			                	  <portlet:namespace />step:step
			                  },
			                  on: {
			                	  success: function() {
			                		  	var responseData = this.get('responseData');
			                		  	
			    						if(step == 1){
			    							$("#<portlet:namespace />shipping-method-wrapper").empty();
			    							$("#<portlet:namespace />payment-form-wrapper").empty();
			    						}else if(step == 2){
			    							$("#<portlet:namespace />payment-form-wrapper").empty();
			    						}
			                		  	
			                		  	$(wrapper).empty();
			                		  	console.log(wrapper);
										$(wrapper).append(responseData);
			  	                  }
			                  }
			            });		  	
			    },['aui-base,selector-css3']);
			
			
			Liferay.provide(window, '<portlet:namespace />calculateShippingPrice',
					function() {
						
						A.io.request('<%= calculateShippingPriceURL %>',{
			                  dataType: 'json',
			                  method: 'POST',
			                  data: {},
			                  on: {
			                	  success: function() {
			                		  	var responseData = this.get('responseData');
			                		  	
			                		  	if(response.success){
			                		  		var shoppingShippingMethodJson = JSON.parse(response.shoppingShippingMethod);
			    							
			    							$('.order-summary-shipping-description').text(shoppingShippingMethodJson.description);
			    							$('.order-summary-shipping-price').text('<%= shoppingStore.getCurrency()%>'+shoppingShippingMethodJson.price);
			    							$('#<portlet:namespace />order-summary-total-price').text(response.total);
			    							
			    							
			    							
				                      	}else{
				                      		alert('Weird Shit');
				                      	}
			  	                  }
			                  }
			            });		  	
			    },['aui-base,selector-css3']);
			
		</aui:script>
	</c:otherwise>
</c:choose>