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


<%@page import="com.fsquare.shopping.model.ShoppingCoupon"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Node"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Document"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
<%@ include file="/cart-view/init.jsp" %>

<%


Map<String,ShoppingOrderItem> shoppingOrderItemMap = (Map<String,ShoppingOrderItem>)session.getAttribute(ShoppingPortletUtil.SESSION_CART_OBJECT);
if(shoppingOrderItemMap == null){
	shoppingOrderItemMap = new HashMap<String,ShoppingOrderItem>();
}

double total = 0;
for(Map.Entry<String, ShoppingOrderItem> entry: shoppingOrderItemMap.entrySet()){
	ShoppingOrderItem orderItem = entry.getValue();
	total = total + orderItem.getQuantity() * orderItem.getPrice();
}

ShoppingCoupon shoppingCoupon = null;
Object shoppingCouponObj = session.getAttribute(ShoppingPortletUtil.SESSION_CART_COUPON_CODE);
if(shoppingCouponObj != null){
	shoppingCoupon = (ShoppingCoupon)shoppingCouponObj;
	total = ShoppingPortletUtil.applyCoupon(shoppingCoupon, total);
}
%>

	
<div class="cart-table-wrapper">
	<c:choose>
		<c:when test="<%= shoppingOrderItemMap == null || shoppingOrderItemMap.isEmpty() %>">
			<h2>Empty Cart</h2>
		</c:when>
		<c:otherwise>
			<portlet:actionURL var="checkoutActionURL">
				<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="checkout" />
			</portlet:actionURL>
			
			<liferay-portlet:resourceURL var="removeFromCartURL">
				<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_REMOVE_FROM_CART %>" />
			</liferay-portlet:resourceURL>
			
			<liferay-portlet:resourceURL var="updateCartURL">
				<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_UPDATE_CART %>" />
			</liferay-portlet:resourceURL>
			
			<liferay-portlet:resourceURL var="applyCouponURL">
				<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_APPLY_COUPON %>" />
			</liferay-portlet:resourceURL>
			
			<liferay-portlet:resourceURL var="checkoutURL">
				<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_CHECKOUT %>" />
			</liferay-portlet:resourceURL>
			
			<aui:form action="<%= checkoutActionURL %>" method="post" name="fm" enctype="multipart/form-data">		
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
				    	<tr class="coupon-row">
							<td colspan="5" align="right">
								Coupon code (optional) &nbsp;
								<a href="javascript:;" id="<portlet:namespace />coupon_apply_btn" class="btn coupon-apply-btn" >Apply</a> &nbsp;
								<input type="text" id="<portlet:namespace />coupon_code" class="coupon-apply-input" value='<%= shoppingCoupon==null?StringPool.BLANK:shoppingCoupon.getCode() %>'>
								<div id="coupon-tip" style="display:none;">Click "apply" when done</div>
						  	</td>
						</tr>
						<tr class="cart-summary-row">
							<td colspan="4" align="right">
								<strong>Total</strong>
							</td>
							<td class="cart-price-cell"><strong>GBP£<span id="<portlet:namespace />cart-total-price"><%= total %></span></strong></td>
						</tr>
				  
				  	</tbody>
				</table>
				<div class="cart-error-messages">
				</div>
				<div class="checkout-btn-wrapper">
					<button type="submit" id="<portlet:namespace />checkout-btn" class="btn btn-large checkout-btn">Checkout</button>
					<div style="clear:both;"></div>
				</div>
				<aui:script use="aui-base,selector-css3,aui-io-request">
				
					A.on('click', function(event) {
						//<portlet:namespace />checkout();
					},'#<portlet:namespace />checkout-btn');
					
					Liferay.provide(window, '<portlet:namespace />checkout',
						function() {
							A.one(".cart-error-messages").set('text', '');
				        	A.io.request('<%= checkoutURL %>',{
				                  dataType: 'json',
				                  method: 'POST',
				                  data: {},
				                  on: {
				                      success: function() {
				                      	var response = this.get('responseData');
				                      	
				                      	if(response.success){
				                      		var x;
				                      	
				                      	}
				                      	
				                      }
				                  }
				            });
							
				        },
				    	['aui-base,selector-css3']);
					
				
					A.on('click', function(event) {
						<portlet:namespace />applyCoupon();
					},'#<portlet:namespace />coupon_apply_btn');
				
					Liferay.provide(window, '<portlet:namespace />applyCoupon',
						function() {
							A.one(".cart-error-messages").set('text', '');
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
				                      	
				                      	if(response.success){
				                      		A.one('#<portlet:namespace />cart-total-price').set('text', response.total);
				                      	}else{
				                      		alert('Invalid coupon code');
				                      	}
				                      	//cart-row-
				                      	//A.one('#<portlet:namespace />cart-size').set('text', response.size);
				                      }
				                  }
				            });
							
				        },
				    	['aui-base,selector-css3']);
					
					A.on('click', function(event) {
						debug(this, A.one(this));
						var articleId = this.getAttribute('data-article-id');
						removeFromShoppingCart(articleId);
					},'.remove-from-shopping-cart-button');
				
					Liferay.provide(window, 'removeFromShoppingCart',
						function(articleId) {
							A.one(".cart-error-messages").set('text', '');
				        	A.io.request('<%= removeFromCartURL %>',{
				                  dataType: 'json',
				                  method: 'POST',
				                  data: {
				                	  <portlet:namespace />articleId: articleId
				                  },
				                  on: {
				                      success: function() {
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
						debug(this, A.one(this));
						var articleId = this.getAttribute('data-article-id');
						var quantity = A.one('#<portlet:namespace />quantity_'+articleId).val();
						updateQuantity(articleId, quantity);
					}, '.update-quantity');
				
					Liferay.provide(window, 'updateQuantity',
						function(articleId, quantity) {
							A.one(".cart-error-messages").set('text', '');
				        	A.io.request('<%= updateCartURL %>',{
				                  dataType: 'json',
				                  method: 'POST',
				                  data: {
				                	  <portlet:namespace />articleId: articleId,
				                	  <portlet:namespace />quantity: quantity
				                  },
				                  on: {
				                      success: function() {
				                      	var response = this.get('responseData');
				                      	if(response.success){
				                      		A.one("#<portlet:namespace />cart_item_price_"+articleId).set('value', response.price);
				                      		A.one("#<portlet:namespace />cart-total-price").set('text', response.total);
				                      	}else{
				                      		A.one(".cart-error-messages").set('text', response.errorMessage);
				                      	}
				                      	
				                      }
				                  }
				            });
							
				        },
				    	['aui-base,selector-css3']);
				  
				</aui:script>
			</aui:form>
		</c:otherwise>
	</c:choose>
</div>

<%!

private String getMainImage(JournalArticle journalArticle) {
	String imagePath = StringPool.BLANK;
	Document document = null;
	try {
		document = SAXReaderUtil.read(journalArticle.getContent());
	
		if (Validator.isNotNull(document)) {
			Node fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Main_Image']/dynamic-content");
			if (fieldContent != null) {
				imagePath = fieldContent.getText();
			}
		}
	} catch (Exception de) {
		de.printStackTrace();
	}
	return imagePath;
}

%>
