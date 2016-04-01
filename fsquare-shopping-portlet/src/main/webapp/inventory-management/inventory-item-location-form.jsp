<%@page import="com.fsquare.shopping.service.ShoppingStorageLocationLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingStorageLocation"%>
<%@page import="com.fsquare.shopping.service.ShoppingItemStorageLocationLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItemStorageLocation"%>
<%@page import="com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItemImage"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.fsquare.shopping.service.ShoppingItemTypeLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItemType"%>
<%@page import="com.fsquare.shopping.model.ShoppingItem"%>
<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

ShoppingItem shoppingItem = (ShoppingItem)request.getAttribute(ShoppingPortletUtil.ATTR_SHOPPING_ITEM);
ShoppingItemStorageLocation shoppingItemStorageLocation = (ShoppingItemStorageLocation)request.getAttribute(ShoppingPortletUtil.ATTR_ITEM_STORAGE_LOCATION);

String movement = (String)request.getAttribute(ShoppingPortletUtil.ATTR_ITEM_MOVEMENT);

List<ShoppingStorageLocation> shoppingStorageLocationList = ShoppingStoreLocalServiceUtil.getShoppingStorageLocationsByGroup(themeDisplay.getScopeGroupId());

%>
		
<div class="modal" id="<portlet:namespace />shopping_item_location_form" >
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />shopping_item_location_form').remove();">×</button>
		<h3><%= LanguageUtil.get(locale, "shopping_item_location") %></h3>
	</div>
	<div class="modal-body">
		<aui:form name='shopping_item_location_fm' enctype="multipart/form-data">
			<div class="">	
				<aui:input name="itemId" type="hidden" value="<%= shoppingItem.getItemId()  %>" disabled="true"/>
				<aui:input name="movement" type="hidden" value="<%= movement  %>" disabled="true"/>
				
				<aui:select name="storageLocationId" >
				    <aui:option value="" label="select"></aui:option>
				    <%
				    for(ShoppingStorageLocation shoppingStorageLocation : shoppingStorageLocationList){
					%>
						<aui:option value="<%= shoppingStorageLocation.getStorageLocationId() %>" label="<%= shoppingStorageLocation.getName() %>"></aui:option>
					<%
				    }
					%>	
				</aui:select>
				<aui:input name="quantity" type="number" value="" />
				<div class="clearfix"></div>
			</div>
			<div id="<portlet:namespace />shipping-form-error" class="error-message shipping-form-error">
				
			</div>
		</aui:form>
		
		
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />shopping_item_location_form').remove();" >Close</button>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace />saveItemStorageLocation()">Save</button>
	</div>
	
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker,liferay-dynamic-select">
	
		
</aui:script>