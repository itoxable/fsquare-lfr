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
	//JournalArticle journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getScopeGroupId(), orderItem.getArticleId());
}

%>

<div class="cart-table-wrapper">
	<c:choose>
		<c:when test="<%= shoppingOrderItemMap == null || shoppingOrderItemMap.isEmpty() %>">
			<h2>Empty Cart</h2>
		</c:when>
		<c:otherwise>
		
			<liferay-portlet:resourceURL var="removeFromCartURL">
				<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_REMOVE_FROM_CART %>" />
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
					      	<strong><%=journalArticle.getTitle(themeDisplay.getSiteDefaultLocale()) %></strong>
					    </td>
					    
					    <td align="center">
					    	<input value="<%=orderItem.getQuantity() %>" type="number"/>
					    </td>          
				    	<td align="right">
				    		£<span class="cart-item-price"><%=orderItem.getPrice() %></span>
				    	</td>
				  	</tr>
			    	<%
			    	}
				  	%>
			    	<tr class="coupon-row">
						<td colspan="5" align="right">
							Coupon code (optional) &nbsp;
							<a href="javascript:;" id="<portlet:namespace />coupon_apply_btn" class="btn coupon-apply-btn" >Apply</a> &nbsp;
							<input type="text" id="<portlet:namespace />coupon_code" class="coupon-apply-input" value="">
							<div id="coupon-tip" style="display:none;">Click "apply" when done</div>
					  	</td>
					</tr>
					<tr class="cart-summary-row">
						<td colspan="4" align="right">
							<strong>Total</strong>
						</td>
						<td class="cart-price-cell"><strong>GBP£<span id="cart-total-price"><%= total %></span></strong></td>
					</tr>
			  
			  	</tbody>
			</table>
			
			<aui:script use="aui-base,selector-css3,aui-io-request">
			
				var couponApplyBtn = A.one('#<portlet:namespace />coupon_apply_btn');
				couponApplyBtn.on('click', function(event) {
					<portlet:namespace />applyCoupon();
				});
			
				Liferay.provide(window, '<portlet:namespace />applyCoupon',
					function() {
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
			                      		var x;
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
				
				var removeFromShoppingCartButton = A.all('.remove-from-shopping-cart-button');
				removeFromShoppingCartButton.on('click', function(event) {
					debug(this, A.one(this));
					var articleId = this.getAttribute('data-article-id');
					removeFromShoppingCart(articleId);
				});
			
				Liferay.provide(window, 'removeFromShoppingCart',
					function(articleId) {
						console.log("adding to cart: "+articleId);
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
			                      	
			                      	//cart-row-
			                      	//A.one('#<portlet:namespace />cart-size').set('text', response.size);
			                      }
			                  }
			            });
						
			        },
			    	['aui-base,selector-css3']);
			  
			</aui:script>
			
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
