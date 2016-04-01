<%@page import="com.fsquare.shopping.model.ShoppingStorageLocation"%>
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

ShoppingStorageLocation shoppingStorageLocation = (ShoppingStorageLocation)request.getAttribute(ShoppingPortletUtil.ATTR_STORAGE_LOCATION);

%>
		
<div class="modal" id="<portlet:namespace />storage_location_form" >
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />storage_location_form').remove();">×</button>
		<h3><%= LanguageUtil.get(locale, "storage-location") %></h3>
	</div>
	<div class="modal-body">
		<aui:form name='storage-location-form'>
			<div class="">	
				<aui:input name="itemTypeId" type="text" value="<%= shoppingStorageLocation.getStorageLocationId()  %>" disabled="true"/>
				<aui:input name="name" type="text" value="<%= shoppingStorageLocation.getName() %>" placeholder="Name"/>
				<aui:input name="location" type="textarea" inlineField="<%=true %>" cssClass="text-area" value="<%= shoppingStorageLocation.getLocation() %>" placeholder="Description" />
				<aui:input name="description" type="textarea" inlineField="<%=true %>" cssClass="text-area" value="<%= shoppingStorageLocation.getDescription() %>" placeholder="Description" />
				
				<div class="clearfix"></div>
			</div>
			<div id="<portlet:namespace />storage-location-form-error" class="error-message storage-location-form-error">
				
			</div>
		</aui:form>
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />storage_location_form').remove();" >Close</button>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace />saveStorageLocation()">Save</button>
	</div>
	
</div>