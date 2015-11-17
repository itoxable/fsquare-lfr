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
<%@page import="com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.ShoppingUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ include file="/shopping-order/init.jsp" %>

<%


double absoluteTotal = shoppingOrderProcessWrapper.getAbsoluteTotal();
double totalSimple = shoppingOrderProcessWrapper.getTotalSimple();
%>
	
<div class="order-summary-table-wrapper">
	
			
	<liferay-portlet:resourceURL var="removeFromCartURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_REMOVE_FROM_CART %>" />
	</liferay-portlet:resourceURL>
	
	<liferay-portlet:resourceURL var="updateCartURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_UPDATE_CART %>" />
	</liferay-portlet:resourceURL>
	
	<liferay-portlet:resourceURL var="applyCouponURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_APPLY_COUPON %>" />
	</liferay-portlet:resourceURL>
	
		<table class="cart-table">
			<tbody>
				<tr class="table-header">
				    <td></td>
				    <td></td>
				    <td>PRODUCT</td>
				    <td align="center">QTY</td>
				    <td align="right">PRICE</td>
			  	</tr>
			  	
			  	<%
			  	for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
			  		ShoppingOrderItem orderItem = entry.getValue();
			  		JournalArticle journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getScopeGroupId(), orderItem.getArticleId());
			  		
			  	%>
			    <tr class="product-row product-row-<%= orderItem.getArticleId() %>">
				    <td>
				      	<a href="javascript:;" data-article-id="<%= orderItem.getArticleId() %>" class='fa fa-times-circle remove-from-shopping-cart-button' title="remove"></a>
				    </td>
				    <td>      
				    	<img src="<%= ShoppingPortletUtil.getMainImageURL(journalArticle) %>" alt="" class="cart-item-img">
				    </td>
				    
				    <td>
				      	<strong><%= journalArticle.getTitle(themeDisplay.getSiteDefaultLocale()) %></strong>
				    </td>
				    
				    <td align="center">
				    	<input value="<%=orderItem.getQuantity() %>" id="<portlet:namespace />quantity_<%= orderItem.getArticleId() %>" type="number"/>
				    	<a data-article-id='<%= orderItem.getArticleId() %>' class="update-quantity">
					    	<span class="fa fa-refresh"></span>
					    	<span>update</span>
				    	</a>
				    	
				    </td>          
			    	<td align="right">
			    		£<span class="cart-item-price" id="<portlet:namespace />cart_item_price_<%= orderItem.getArticleId() %>"><%=orderItem.getPrice() %></span>
			    	</td>
			  	</tr>
		    	<%
		    	}
			  	%>
				
				
				<tr class='shipping-method-row <%= (shoppingShippingMethod != null)?"":"hide" %>'>
					<td colspan="4" align="right">
						<strong><span class="order-summary-shipping-description"><%= (shoppingShippingMethod != null)?(Validator.isNotNull(shoppingShippingMethod.getDescription())?shoppingShippingMethod.getDescription():shoppingShippingMethod.getName() ):"" %></span></strong>
				  	</td>
				  	<td align="right">
						<strong><span class="order-summary-shipping-price">-<%= (shoppingShippingMethod != null)?ShoppingShippingMethodLocalServiceUtil.getShippingPrice(shoppingShippingMethod, shoppingOrderItemMap.values(), totalSimple):"" %></span></strong>
				  	</td>
				</tr>
				
			  	<tr class='discount-row <%= (shoppingCoupon != null)?"":"hide" %>'>
					<td colspan="4" align="right">
						<strong><span class="cart-discount-description"><%= (shoppingCoupon != null)?shoppingCoupon.getCode() +": "+ shoppingCoupon.getDescription():"" %></span></strong>
				  	</td>
				  	<td align="right">
						<strong><span class="cart-discount">-<%= (shoppingCoupon != null)?shoppingCoupon.getDiscount():"" %><%= (shoppingCoupon != null)?(shoppingCoupon.getDiscountType().equals(ShoppingUtil.DISCOUNT_TYPE_PERCENTAGE)?"%":"£"):"" %></span></strong>
				  	</td>
				</tr>
			
		    	<tr class="coupon-row">
					<td colspan="5" align="right">
						<input placeholder="coupon.code" type="text" id="<portlet:namespace />coupon_code" class="coupon-apply-input" value='<%= shoppingCoupon==null?StringPool.BLANK:shoppingCoupon.getCode() %>'>
				  		<a href="javascript:;" id="<portlet:namespace />coupon_apply_btn" class="btn coupon-apply-btn" >Apply</a> &nbsp;
				  	</td>
				</tr>
				
				<tr class="cart-summary-row">
					<td colspan="4" align="right">
						<strong>Total</strong>
					</td>
					<td class="cart-price-cell" align="right">
						<strong><%= shoppingStore.getCurrency()%><span id="<portlet:namespace />order-summary-total-price"><%= absoluteTotal %></span></strong>
					</td>
				</tr>
		  
		  	</tbody>
		</table>
		<div class="order-summary-error-messages">
		</div>
		
		<aui:script use="aui-base,selector-css3,aui-io-request">
		
			
			A.on('click', function(event) {
				<portlet:namespace />showLoading('#<portlet:namespace />checkout-order-summary');
				<portlet:namespace />applyCoupon();
			},'#<portlet:namespace />coupon_apply_btn');
		
			Liferay.provide(window, '<portlet:namespace />applyCoupon',
				function() {
					A.one(".order-summary-error-messages").set('text', '');
					var couponCode = A.one('#<portlet:namespace />coupon_code').val();
		        	A.io.request('<%= applyCouponURL %>',{
		                  dataType: 'json',
		                  method: 'POST',
		                  data: {
		                	  <portlet:namespace />couponCode: couponCode
		                  },
		                  on: {
		                      success: function() {
		                      	var response = this.get('responseData');
		                      	<portlet:namespace />hideLoading('#<portlet:namespace />checkout-order-summary');
		                      	if(response.success){
		                      		A.one('#<portlet:namespace />order-summary-total-price').set('text', response.total);
		                      		
		                      		var shoppingCouponJson = JSON.parse(response.shoppingCouponJson);
		                      		A.one('.cart-discount-description').set('text', response.shoppingCouponJson.description);
		                      		
		                      		var discountType = shoppingCouponJson.discountType == "percentage"?"%":"£";
		                      		A.one('.cart-discount').set('text', "-"+shoppingCouponJson.discount +" "+ discountType);
		                      		A.one('.discount-row').removeClass("hide");
		                      		
		                      	}else{
		                      		alert('Invalid coupon code');
		                      	}
		                      }
		                  }
		            });
		        },
		    	['aui-base,selector-css3']);
			
			A.on('click', function(event) {
				<portlet:namespace />showLoading('#<portlet:namespace />checkout-order-summary');
				var articleId = this.getAttribute('data-article-id');
				removeFromShoppingCart(articleId);
			},'.remove-from-shopping-cart-button');
		
			Liferay.provide(window, 'removeFromShoppingCart',
				function(articleId) {
					A.one(".order-summary-error-messages").set('text', '');
		        	A.io.request('<%= removeFromCartURL %>',{
		                  dataType: 'json',
		                  method: 'POST',
		                  data: {
		                	  <portlet:namespace />articleId: articleId
		                  },
		                  on: {
		                      success: function() {
		                    	  <portlet:namespace />hideLoading('#<portlet:namespace />checkout-order-summary');
		                      	var response = this.get('responseData');
		                      	
		                      	debug(response.redraw, response.success);
		                      	if(response.success){
		                      		A.one(".cart-table-wrapper").empty();
		                      		A.one(".cart-table-wrapper").append(response.redraw);
		                      	}
		                      	
		                      }
		                  }
		            });
					
		        },
		    	['aui-base,selector-css3']);
			
			
			A.on('click', function(event) {
				<portlet:namespace />showLoading('#<portlet:namespace />checkout-order-summary');
				var articleId = this.getAttribute('data-article-id');
				var quantity = A.one('#<portlet:namespace />quantity_'+articleId).val();
				updateQuantity(articleId, quantity);
			}, '.update-quantity');
		
			Liferay.provide(window, 'updateQuantity',
				function(articleId, quantity) {
					A.one(".order-summary-error-messages").set('text', '');
		        	A.io.request('<%= updateCartURL %>',{
		                  dataType: 'json',
		                  method: 'POST',
		                  data: {
		                	  <portlet:namespace />articleId: articleId,
		                	  <portlet:namespace />quantity: quantity
		                  },
		                  on: {
		                      success: function() {
		                    	  <portlet:namespace />hideLoading('#<portlet:namespace />checkout-order-summary');
		                      	var response = this.get('responseData');
		                      	if(response.success){
		                      		A.one("#<portlet:namespace />cart_item_price_"+articleId).set('value', response.price);
		                      		A.one("#<portlet:namespace />cart-total-price").set('text', response.total);
		                      	}else{
		                      		A.one(".order-summary-error-messages").set('text', response.errorMessage);
		                      	}
		                      	
		                      }
		                  }
		            });
					
		        },
		    	['aui-base,selector-css3']);
		  
		</aui:script>

</div>

