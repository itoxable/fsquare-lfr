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


<%@page import="com.fsquare.shopping.ShoppingUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.fsquare.shopping.model.ShoppingCoupon"%>
<%@page import="com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.fsquare.shopping.NoSuchShoppingStoreException"%>
<%@ include file="init.jsp" %>

<%

List<ShoppingCoupon> shoppingCouponList = ShoppingCouponLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());

%>

<liferay-portlet:resourceURL var="deleteCouponURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_COUPON %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openCouponFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_COUPON_FORM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveCouponURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_COUPON %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="activateCouponURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_ACTIVATE_COUPON %>" />
</liferay-portlet:resourceURL>


<div>
	<h3>Coupons</h3>
	<div class="coupons-table-wrapper" >
		<table class="settings-table coupons-table table table-bordered table-striped" id="<portlet:namespace />coupons-table" >
			<thead>
				<tr>
					<td>Code</td>
					<td>Name</td>
					<td>Description</td>
<!-- 					<td>Start</td> -->
<!-- 					<td>End</td> -->
<!-- 					<td>Active</td> -->
					<td>Categories</td>
					<td>Skus</td>
					<td>Min Order</td>
					<td>Discount</td>
					<td>Discount Type</td>
					<td>Status</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				
			<%
			  	for(ShoppingCoupon shoppingCoupon: shoppingCouponList){
			  		String couponStatus = ShoppingCouponLocalServiceUtil.getCouponStatus(shoppingCoupon);
		  	%>
				
				<tr id="<portlet:namespace />coupon-row-<%= shoppingCoupon.getCouponId() %>">
					<td id="<%= "coupon-code-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getCode() %></td>
					<td id="<%= "coupon-name-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getName() %></td>
					<td id="<%= "coupon-description-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getDescription() %></td>
<%-- 					<td id="<%= "coupon-start-"+shoppingCoupon.getCouponId() %>"><%= Validator.isNotNull(shoppingCoupon.getStartDate())?dateFormat.format(shoppingCoupon.getStartDate()):"" %></td> --%>
<%-- 					<td id="<%= "coupon-end-"+shoppingCoupon.getCouponId() %>"><%= Validator.isNotNull(shoppingCoupon.getEndDate())?dateFormat.format(shoppingCoupon.getEndDate()):"" %></td> --%>
<%-- 					<td id="<%= "coupon-active-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getActive() %></td> --%>
					<td id="<%= "coupon-categories-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getLimitCategories() %></td>
					<td id="<%= "coupon-skus-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getLimitSkus() %></td>
					<td id="<%= "coupon-minorder-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getMinOrder() %></td>
					<td id="<%= "coupon-discount-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getDiscount() %></td>
					<td id="<%= "coupon-discount-type-"+shoppingCoupon.getCouponId() %>"><%= shoppingCoupon.getDiscountType() %></td>
					<td>
						<i id="<%= "coupon-status-"+shoppingCoupon.getCouponId() %>" class="fa fa-circle <%= couponStatus %>" title="<%= LanguageUtil.get(locale, couponStatus) %>"></i>
					</td>
					
					<td class="settings-actions">
						<a class="open-coupon-btn fa fa-pencil-square" data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="edit" href="javascript:;"></a>
						<a class='fa fa-toggle-on deactivate-coupon-btn deactivate-coupon-btn<%= shoppingCoupon.getCouponId() %> <%= !shoppingCoupon.getActive()?" hide":StringPool.BLANK %>' data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="deactivate" href="javascript:;"></a>
						<a class='fa fa-toggle-off activate-coupon-btn activate-coupon-btn<%= shoppingCoupon.getCouponId() %>  <%= shoppingCoupon.getActive()?" hide":StringPool.BLANK %>' data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="activate" href="javascript:;"></a>
						<a class="fa fa-times-circle delete-coupon-btn" data-coupon-id="<%= shoppingCoupon.getCouponId() %>" title="delete" href="javascript:;"></a>
					</td>
				</tr>
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
	</div>
	<div id="<portlet:namespace />coupon-table-error" class="error-message coupon-table-error"></div>
	<a class="btn open-new-coupon-btn" data-coupon-id="" href="javascript:;"><span class="fa fa-pencil-square"></span><span>New Coupon</span></a>
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
	
	Liferay.provide(window, '<portlet:namespace />saveCoupon',
		function() {
			A.one("#<portlet:namespace />coupon-form-error").text('');
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
	                  	if(response.success){
	                  		A.one('#<portlet:namespace />coupon_form').remove(true);
	                  		//debug(A,A.Date,A.DataType,themeDisplay);
	                  		var shoppingCouponJson = JSON.parse(response.shoppingCouponJson);
	                  		var couponId = shoppingCouponJson.couponId;

	                  		var date = new Date();
	                  		var time = date.getTime();

	                  		var startDate = shoppingCouponJson.startDate;
	                  		var endDate = shoppingCouponJson.endDate;

	                  		var startDateFormated = A.DataType.Date.format(new Date(startDate), {format:'%d/%m/%Y'});
	                  		var endDateFormated = A.DataType.Date.format(new Date(endDate), {format:'%d/%m/%Y'});

							var status = response.couponStatus;
							var statusDesc = response.statusDescription;
							
	                  		if(response.isNew){
								debug(A,A.Date);
	                  			var newRow = "<tr id='<portlet:namespace />coupon-row-"+couponId+"'>";
	                  			newRow += "<td id='coupon-code-"+couponId+"'>"+shoppingCouponJson.code+"</td>";
                				newRow += "<td id='coupon-name-"+couponId+"'>"+shoppingCouponJson.name+"</td>";
	                  			newRow += "<td id='coupon-description-"+couponId+"'>"+shoppingCouponJson.description+"</td>";
//                   				newRow += "<td id='coupon-start-"+couponId+"'>"+startDateFormated+"</td>";
//                					newRow += "<td id='coupon-end-"+couponId+"'>"+endDateFormated+"</td>";
//             					newRow += "<td id='coupon-active-"+couponId+"'>"+shoppingCouponJson.active+"</td>";
	                  			newRow += "<td id='coupon-categories-"+couponId+"'>"+shoppingCouponJson.limitCategories+"</td>";
                  				newRow += "<td id='coupon-skus-"+couponId+"'>"+shoppingCouponJson.limitSkus+"</td>";
                				newRow += "<td id='coupon-minorder-"+couponId+"'>"+shoppingCouponJson.minOrder+"</td>";
                				newRow += "<td id='coupon-discount-"+couponId+"'>"+shoppingCouponJson.discount+"</td>";
	                  			newRow += "<td id='coupon-discount-type-"+couponId+"'>"+shoppingCouponJson.discountType+"</td>";
	                  			newRow += "<td>";
	                  			
	                  			newRow += "<i id='coupon-status-"+couponId+"'class='fa fa-circle "+status+"' title='"+statusDesc+"'></i>";

	    						newRow += "</td>";
	                  			newRow += "<td class='coupon-actions'>";
	                  			newRow += "<a class='open-coupon-btn fa fa-pencil-square' data-coupon-id='"+couponId+"' title='edit' href='javascript:;'></a>";
	                  			newRow += "<a class='fa fa-times-circle delete-coupon-btn' data-coupon-id='"+couponId+"' title='delete' href='javascript:;'></a>";
	                  			newRow += "</td>";
	                  			newRow = newRow+"</tr>";
	                  			A.one("#<portlet:namespace />coupons-table > tbody").append(newRow);
	                  		
	                  		}else{

	                  			A.one('#coupon-code-'+couponId).text(shoppingCouponJson.code);
	                  			A.one('#coupon-name-'+couponId).text(shoppingCouponJson.name);
	                  			A.one('#coupon-discount-'+couponId).text(shoppingCouponJson.discount);
	                  			A.one('#coupon-description-'+couponId).text(shoppingCouponJson.description);
// 	                  			A.one('#coupon-start-'+couponId).text(startDateFormated);
// 	                  			A.one('#coupon-end-'+couponId).text(endDateFormated);
// 	                  			A.one('#coupon-active-'+couponId).text(shoppingCouponJson.active);
	                  			A.one('#coupon-categories-'+couponId).text(shoppingCouponJson.limitCategories);
	                  			A.one('#coupon-skus-'+couponId).text(shoppingCouponJson.limitSkus);
	                  			A.one('#coupon-minorder-'+couponId).text(shoppingCouponJson.minOrder);
	                  			A.one('#coupon-discount-type-'+couponId).text(shoppingCouponJson.discountType);
	                  			
	                  			A.one('#coupon-status-'+couponId).removeClass('<%= ShoppingUtil.COUNPON_STATE_RUNNING %>');
	                  			A.one('#coupon-status-'+couponId).removeClass('<%= ShoppingUtil.COUNPON_STATE_EXPIRED %>');
	                  			A.one('#coupon-status-'+couponId).removeClass('<%= ShoppingUtil.COUNPON_STATE_NOT_STARTED %>');
	                  			
	                  			A.one('#coupon-status-'+couponId).addClass(status);
	                  			
	                  			A.one('#coupon-status-'+couponId).set('title', statusDesc);
	                  			
	                  			if(shoppingCouponJson.active){
									A.one('.activate-coupon-btn'+shoppingCouponJson.couponId).addClass('hide');
									A.one('.deactivate-coupon-btn'+shoppingCouponJson.couponId).removeClass('hide');
								}else{
									A.one('.deactivate-coupon-btn'+shoppingCouponJson.couponId).addClass('hide');
									A.one('.activate-coupon-btn'+shoppingCouponJson.couponId).removeClass('hide');
								}
	                  		}
	                  		
	                  	}else{
	                  		A.one("#<portlet:namespace />coupon-form-error").text(response.errorMessage);
	                  	}
	                  	
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3']);

	
	A.on('click', function(event) {
		<portlet:namespace />activateCoupon(this.getAttribute('data-coupon-id'),false);
	}, '.deactivate-coupon-btn');
	A.on('click', function(event) {
		<portlet:namespace />activateCoupon(this.getAttribute('data-coupon-id'),true);
	}, '.activate-coupon-btn');
	
	Liferay.provide(window, '<portlet:namespace />activateCoupon',
			function(couponId, activate) {
				
				A.io.request('<%= activateCouponURL %>',{
		              dataType: 'json',
		              method: 'POST',
		              data: {
		            	  <portlet:namespace />couponId : couponId,
		            	  <portlet:namespace />activate : activate
		              },
		              on: {
	                  	success: function() {
							var response = this.get('responseData');
							if(response.success){
								var shoppingCouponJson = JSON.parse(response.shoppingCouponJson);
								A.one('#coupon-active-'+shoppingCouponJson.couponId).text(shoppingCouponJson.active);
								if(activate){
									A.one('.activate-coupon-btn'+shoppingCouponJson.couponId).addClass('hide');
									A.one('.deactivate-coupon-btn'+shoppingCouponJson.couponId).removeClass('hide');
								}else{
									A.one('.deactivate-coupon-btn'+shoppingCouponJson.couponId).addClass('hide');
									A.one('.activate-coupon-btn'+shoppingCouponJson.couponId).removeClass('hide');
								}								
							}else{
							}
	                  	}
		              }
		        });
				
		    },
			['aui-base,selector-css3']);
	
	A.on('click', function(event) {
		<portlet:namespace />deleteCoupon(this.getAttribute('data-coupon-id'));
	}, '.delete-coupon-btn');
	
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
						if(response.success){
							A.one('#<portlet:namespace />coupon-row-'+couponId).remove(true);
						}else{
	                  		A.one("#<portlet:namespace />coupon-table-error").text(response.errorMessage);
						}
                  	}
	              }
	        });
			
	    },
		['aui-base,selector-css3']);
	
	A.on('click', function(event) {
		<portlet:namespace />openCoupon(0);
	}, '.open-new-coupon-btn');

	A.on('click', function(event) {
		debug(this,event);
		<portlet:namespace />openCoupon(this.getAttribute('data-coupon-id'));
	}, '.open-coupon-btn');
	
	Liferay.provide(window, '<portlet:namespace />openCoupon',
		function(couponId) {
			console.log("couponId: "+couponId);
			A.io.request('<%= openCouponFormURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />couponId : couponId
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one('.shopping-coupon-management'));
	                  	//A.one('.store-settings').append();
// 	                  	jQuery("#<portlet:namespace />startDate").datepicker();
// 	            	    jQuery("#<portlet:namespace />endDate").datepicker();
// 	                  	AUI().use('aui-datepicker', function(A) {
// 	                		var startDatePicker = new A.DatePicker({
// 	                			trigger: '#<portlet:namespace />startDate'
// 	                		}).render('#<portlet:namespace />startDate-wrap');
// 	                	});
// 	                	AUI().use('aui-datepicker', function(A) {
// 	                		var endDatePicker = new A.DatePicker({
// 	                			trigger: '#<portlet:namespace />endDate_btn'
// 	                		}).render('#<portlet:namespace />/>endDate-wrap');
// 	                	});
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);


</aui:script>
