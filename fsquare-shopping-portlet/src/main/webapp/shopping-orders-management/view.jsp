<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrder"%>
<%@page import="com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil"%>
<%@ include file="/shopping-order/init.jsp" %>

<%

List<ShoppingOrder> shoppingOrderList = ShoppingOrderLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());


%>
<liferay-portlet:resourceURL var="updatOrderStatusURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_UPDATE_ORDER_STATUS %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openShippingAddressURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_SHIPPING_ADDRESS %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openOrderItemsURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_ORDER_ITEMS %>" />
</liferay-portlet:resourceURL>
<div>
	<h3>Orders</h3>
	<div class="orders-table-wrapper" >
		<table class="orders-table table table-bordered table-striped" id="<portlet:namespace />orders-table" >
			<thead>
				<tr>
					<td>Number</td>
					<td>Shipping</td>
					<td>Price</td>
					<td>Status</td>
					
					<td></td>
				</tr>
			</thead>
			<tbody>
				
			<%
			  	for(ShoppingOrder shoppingOrder: shoppingOrderList){
			  		long shoppingOrderId = shoppingOrder.getShoppingOrderId();
			  		ShoppingShippingMethod shoppingShippingMethod =  ShoppingShippingMethodLocalServiceUtil.getShoppingShippingMethod(shoppingOrder.getShippingMethodId());
			  		double total = 0.0;//ShoppingShippingMethodLocalServiceUtil.getTotalPrice(shoppingOrder);
		  	%>
				<tr id="<portlet:namespace />order-row-<%= shoppingOrderId %>">
				
					<td id="<%= "order-number-"+shoppingOrderId %>"><%= shoppingOrder.getNumber() %></td>
					<td id="<%= "order-shipping-"+shoppingOrderId %>"><%= shoppingShippingMethod.getName() %> (<%= shoppingOrder.getShipping()%>)
						<a href class="icon-external-link-sign" data-order-id="<%= shoppingOrderId %>" title="View shipping address" href="javascript:;"></a>
					</td>
					
					<td id="<%= "order-price-"+shoppingOrderId %>"><%= shoppingOrder.getNumber() %></td>
					
					<td id="<%= "order-status-"+shoppingOrderId %>">
						<select class="order-status" data-order-id="<%= shoppingOrderId %>">
							<option selected="<%= ShoppingPortletUtil.ORDER_STATUS_SHIPPED.equals(shoppingOrder.getStatus()) %>" value="<%= ShoppingPortletUtil.ORDER_STATUS_SHIPPED %>">shipped</option>
							<option selected="<%= ShoppingPortletUtil.ORDER_STATUS_PENDING.equals(shoppingOrder.getStatus()) %>" value="<%= ShoppingPortletUtil.ORDER_STATUS_PENDING %>">pending</option>
							<option selected="<%= ShoppingPortletUtil.ORDER_STATUS_CANCELED.equals(shoppingOrder.getStatus()) %>" value="<%= ShoppingPortletUtil.ORDER_STATUS_CANCELED %>">canceled</option>
							<option selected="<%= ShoppingPortletUtil.ORDER_STATUS_RETURNED.equals(shoppingOrder.getStatus()) %>" value="<%= ShoppingPortletUtil.ORDER_STATUS_RETURNED %>">returned</option>
						</select>
					</td>
					
					<td></td>
				</tr>
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
	</div>
	<div id="<portlet:namespace />orders-table-error" class="error-message orders-table-error"></div>
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker">
	
	A.on('change', function(event) {
		<portlet:namespace />openOrderItems(this.getAttribute('data-order-id'));
	}, '.order-items');
	Liferay.provide(window, '<portlet:namespace />openOrderItems',
		function(shoppingOrderId) {
			A.io.request('<%= openOrderItemsURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />shoppingOrderId : shoppingOrderId
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one('.shopping-orders-management'));
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);
	
	A.on('change', function(event) {
		<portlet:namespace />openShippingAddress(this.getAttribute('data-order-id'));
	}, '.order-shipping-address');
	
	Liferay.provide(window, '<portlet:namespace />openShippingAddress',
		function(shoppingOrderId) {
			console.log("shoppingOrderId: "+shoppingOrderId);
			A.io.request('<%= openShippingAddressURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />shoppingOrderId : shoppingOrderId
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one('.shopping-orders-management'));
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);
	
	
	A.on('change', function(event) {
		<portlet:namespace />deleteCoupon(this.getAttribute('data-order-id'), this.val());
	}, '.order-status');
	
	Liferay.provide(window, '<portlet:namespace />updatOrderStatus',
		function(shoppingOrderId, orderStatus) {
			A.io.request('<%= updatOrderStatusURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />shoppingOrderId : shoppingOrderId,
	            	  <portlet:namespace />orderStatus : orderStatus
	              },
	              on: {
                  	success: function() {
						var response = this.get('responseData');
						if(response.success){
														
						}else{
						}
                  	}
	              }
	        });
			
	    },
		['aui-base,selector-css3']);
</aui:script>