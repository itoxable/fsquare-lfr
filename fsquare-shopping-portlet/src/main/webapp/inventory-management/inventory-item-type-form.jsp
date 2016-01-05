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

ShoppingItemType shoppingItemType = (ShoppingItemType)request.getAttribute(ShoppingPortletUtil.ATTR_SHOPPING_ITEM_TYPE);

%>
		
<div class="modal" id="<portlet:namespace />shopping_item_type_form" >
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />shopping_item_type_form').remove();">×</button>
		<h3><%= LanguageUtil.get(locale, "shopping-item-item") %></h3>
	</div>
	<div class="modal-body">
		<aui:form id='shopping-item-type-form'>
			<div class="">	
				<aui:input name="itemTypeId" type="text" value="<%= shoppingItemType.getItemTypeId()  %>" disabled="true"/>
				<aui:input name="name" type="text" value="<%= shoppingItemType.getName() %>" placeholder="Name"/>
				<aui:input name="description" type="textarea" inlineField="<%=true %>" cssClass="text-area" value="<%= shoppingItemType.getDescription() %>" placeholder="Description" />
				
				<div class="clearfix"></div>
			</div>
			<div id="<portlet:namespace />shopping-item-type-form-error" class="error-message shopping-item-type-form-error">
				
			</div>
		</aui:form>
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />shopping_item_type_form').remove();" >Close</button>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace />saveShoppingItemType()">Save</button>
	</div>
	
</div>