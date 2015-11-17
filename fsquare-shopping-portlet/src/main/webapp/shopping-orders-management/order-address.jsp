<%@page import="com.fsquare.shopping.model.ShoppingOrder"%>
<%@page import="com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%

List<ShoppingOrder> shoppingOrderList = ShoppingOrderLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());


%>
<liferay-portlet:resourceURL var="setDefaultShippingMethodURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SET_DEFAULT_SHIPPING_METHOD %>" />
</liferay-portlet:resourceURL>


<div>
	<h3>Orders</h3>
	<div class="orders-table-wrapper" >
		<table class="orders-table table table-bordered table-striped" id="<portlet:namespace />orders-table" >
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
			  	for(ShoppingOrder shoppingOrder: shoppingOrderList){
		  	%>
				
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
	</div>
	<div id="<portlet:namespace />orders-table-error" class="error-message orders-table-error"></div>
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker">
</aui:script>