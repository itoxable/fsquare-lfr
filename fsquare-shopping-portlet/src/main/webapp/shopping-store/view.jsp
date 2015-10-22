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
<%@page import="com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.fsquare.shopping.NoSuchShoppingStoreException"%>
<%@ include file="/shopping-store/init.jsp" %>

<%

String onAddToCart = shoppingStore.getOnAddToCart();
String checkoutPageUuid = shoppingStore.getCheckoutPageUuid();
String cartPageUuid = shoppingStore.getCartPageUuid();
String currency = shoppingStore.getCurrency();

List<KeyValuePair> layoutsKeyValuePair = new ArrayList<KeyValuePair>();
try {
	List<Layout> layoutsTemp = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);
	for(Layout lay : layoutsTemp){
		layoutsKeyValuePair.add(new KeyValuePair(lay.getUuid(), getLayoutBreadcrumb(lay, locale)));
	}
} catch (SystemException e) {
	e.printStackTrace();
} catch (Exception e) {
	e.printStackTrace();
}

List<ShoppingCoupon> shoppingCouponList = ShoppingCouponLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());

%>

<liferay-portlet:resourceURL var="saveStoreResourceURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_STORE %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="deleteCouponURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_COUPON %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openCouponFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_COUPON_FORM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveCouponURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_COUPON %>" />
</liferay-portlet:resourceURL>


<liferay-portlet:actionURL var="saveStoreURL" />


<aui:form action="<%= saveStoreURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveSettings();" %>'>
	<div class="store-settings">
		<aui:field-wrapper label='cart-display-page' >
			<fieldset >
				<div class="form-inline priority-set-wrapper">
					<aui:select label="" name="cartDisplayPage" >
						<aui:option value='' >Select...</aui:option>
						<%
						for (KeyValuePair keyValuePair : layoutsKeyValuePair) {
						%>
							<aui:option selected='<%= keyValuePair.getKey().equals(cartPageUuid) %>' value='<%= keyValuePair.getKey()%>' >
								<%= keyValuePair.getValue() %>
							</aui:option>
						<%
						}
						%>
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		<aui:field-wrapper label='checkout-display-page' >
			<fieldset >
				<div>
					<aui:select label="" name="checkoutDisplayPage" >
						<aui:option value='' >Select...</aui:option>
						<%
						for (KeyValuePair keyValuePair : layoutsKeyValuePair) {
						%>
							<aui:option selected='<%= keyValuePair.getKey().equals(checkoutPageUuid) %>' value='<%= keyValuePair.getKey()%>' >
								<%= keyValuePair.getValue() %>
							</aui:option>
						<%
						}
						%>
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		<aui:field-wrapper label='on-add-to-cart' >
			<fieldset >
				<div>
					<aui:select label="" name="onAddToCart" >
						<aui:option value='' >Select...</aui:option>
						
							<aui:option selected='<%= ShoppingPortletUtil.ON_ADD_TO_CART_JUMP_TO_CART.equals(onAddToCart) %>' value='<%= ShoppingPortletUtil.ON_ADD_TO_CART_JUMP_TO_CART %>' >
								<%= ShoppingPortletUtil.ON_ADD_TO_CART_JUMP_TO_CART %>
							</aui:option>
						
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		<aui:field-wrapper label='currency' >
			<fieldset >
				<div>
					<aui:select label="" name="currency" >
						<aui:option value='' >Select...</aui:option>
						
							<aui:option selected='<%= "GBP".equals(currency) %>' value='GBP' >
								GBP
							</aui:option>
						
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		
		<table>
			<thead>
				<tr>
					<td>Id</td>
					<td>Code</td>
					<td>Name</td>
					<td>Discount</td>
					<td>Description</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Active</td>
					<td>Limit Categories</td>
					<td>Limit Skus</td>
					<td>Min Order</td>
					<td>Discount</td>
					<td>Discount Type</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				
			<%
			  	for(ShoppingCoupon shoppingCoupon: shoppingCouponList){
		  	%>
				
				<tr id="coupon-row-<%= shoppingCoupon.getCouponId() %>">
					<td><%= shoppingCoupon.getCouponId() %></td>
					<td><%= shoppingCoupon.getCode() %></td>
					<td><%= shoppingCoupon.getName() %></td>
					<td><%= shoppingCoupon.getDiscount() %></td>
					<td><%= shoppingCoupon.getDescription() %></td>
					<td><%= shoppingCoupon.getStartDate() %></td>
					<td><%= shoppingCoupon.getEndDate() %></td>
					<td><%= shoppingCoupon.getActive() %></td>
					<td><%= shoppingCoupon.getLimitCategories() %></td>
					<td><%= shoppingCoupon.getLimitSkus() %></td>
					<td><%= shoppingCoupon.getMinOrder() %></td>
					<td><%= shoppingCoupon.getDiscount() %></td>
					<td><%= shoppingCoupon.getDiscountType() %></td>
					<td>
						<a class="open-coupon-btn fa fa-pencil-square" data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="edit" href="javascrip:;"></a>
						<a class="fa fa-times-circle delete-coupon-btn" data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="delete" href="javascrip:;"></a>
					</td>
				</tr>
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
		<a class="btn open-coupon-btn" data-coupon-id="" href="javascrip:;"><span class="fa fa-pencil-square"></span><span>New Coupon</span></a>
		<div style="margin-top: 20px">
			<button type="button" id="<portlet:namespace />save_store_btn" class="btn save-store-btn" >Save Ajax</button>
		</div>
	</div>
</aui:form>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify">
	
	Liferay.provide(window, '<portlet:namespace />saveCoupon',
		function() {
			A.io.request('<%= saveCouponURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />couponId : A.one('#<portlet:namespace />couponId').val(),
	            	  <portlet:namespace />code : A.one('#<portlet:namespace />code').val(),
	            	  <portlet:namespace />name : A.one('#<portlet:namespace />name').val(),
	            	  <portlet:namespace />description : A.one('#<portlet:namespace />description').val(),
	            	  <portlet:namespace />startDate : A.one('#<portlet:namespace />startDate').val(),
	            	  <portlet:namespace />endDate : A.one('#<portlet:namespace />endDate').val(),
	            	  <portlet:namespace />active : A.one('#<portlet:namespace />active').val(),
	            	  <portlet:namespace />limitCategories : A.one('#<portlet:namespace />limitCategories').val(),
	            	  <portlet:namespace />limitSkus : A.one('#<portlet:namespace />limitSkus').val(),
	            	  <portlet:namespace />minOrder : A.one('#<portlet:namespace />minOrder').val(),
	            	  <portlet:namespace />discount : A.one('#<portlet:namespace />discount').val(),
	            	  <portlet:namespace />discountType : A.one('#<portlet:namespace />discountType').val()
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3']);

	
	
	var deleteCouponBtn = A.all('.delete-coupon-btn');
	deleteCouponBtn.on('click', function(event) {
		<portlet:namespace />openCoupon(this.getAttribute('data-coupon-id'));
	});
	
	Liferay.provide(window, '<portlet:namespace />deleteCoupon',
		function(couponId) {
			
			A.io.request('<%= deleteCouponURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />couponId : couponId
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	debug(this, response);
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3']);
	
	
	var openCouponBtn = A.all('.open-coupon-btn');
	openCouponBtn.on('click', function(event) {
		console.log("Clicked Open Coupon");
		<portlet:namespace />openCoupon(this.getAttribute('data-coupon-id'));
	});
	
	Liferay.provide(window, '<portlet:namespace />openCoupon',
		function(couponId) {
			console.log("Opening Coupon");
			A.io.request('<%= openCouponFormURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />couponId : couponId
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	A.one('.store-settings').append(response);
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3']);



	var saveStoreBtn = A.one('#<portlet:namespace />save_store_btn');
	saveStoreBtn.on('click', function(event) {
		<portlet:namespace />saveStore();
	});

	Liferay.provide(window, '<portlet:namespace />saveStore',
		function() {
			
			A.io.request('<%= saveStoreResourceURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: {
                	  <portlet:namespace />checkoutDisplayPage : A.one('#<portlet:namespace />checkoutDisplayPage').val(),
                	  <portlet:namespace />cartDisplayPage : A.one('#<portlet:namespace />cartDisplayPage').val(),
                	  <portlet:namespace />currency : A.one('#<portlet:namespace />currency').val(),
                	  <portlet:namespace />onAddToCart : A.one('#<portlet:namespace />onAddToCart').val(),
                	  <portlet:namespace />currency : A.one('#<portlet:namespace />currency').val()
                	  
                  },
                  on: {
                      success: function() {
                      	var response = this.get('responseData');
                      }
                  }
            });
			
        },
    	['aui-base,selector-css3,array-extras,querystring-stringify']);
	

</aui:script>


<%!
private String getLayoutBreadcrumb(Layout layout, Locale locale) throws Exception {
	StringBundler sb = new StringBundler();

	layout = layout.toEscapedModel();

	if (layout.isPrivateLayout()) {
		sb.append(LanguageUtil.get(locale, "private-pages"));
	}
	else {
		sb.append(LanguageUtil.get(locale, "public-pages"));
	}

	sb.append(StringPool.SPACE);
	sb.append(StringPool.GREATER_THAN);
	sb.append(StringPool.SPACE);

	List<Layout> ancestors = layout.getAncestors();

	Collections.reverse(ancestors);

	for (Layout ancestor : ancestors) {
		ancestor = ancestor.toEscapedModel();

		sb.append(ancestor.getName(locale));
		sb.append(StringPool.SPACE);
		sb.append(StringPool.GREATER_THAN);
		sb.append(StringPool.SPACE);
	}

	sb.append(layout.getName(locale));

	return sb.toString();
}
%>