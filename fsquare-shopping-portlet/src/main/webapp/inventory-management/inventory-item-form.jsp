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

List<ShoppingItemType> shoppingItemTypeList = ShoppingItemTypeLocalServiceUtil.getShoppingItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
List<ShoppingItemImage> shoppingItemImageList = new ArrayList<ShoppingItemImage>();
List<ShoppingItemStorageLocation> shoppingItemStorageLocationList = new ArrayList<ShoppingItemStorageLocation>();
List<ShoppingItemStorageLocation> allShoppingItemStorageLocationList = ShoppingItemStorageLocationLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());

if(!shoppingItem.isNew()){
	shoppingItemImageList = ShoppingItemImageLocalServiceUtil.findByGroupIdAndItemId(themeDisplay.getScopeGroupId(), shoppingItem.getItemId()); 
	shoppingItemStorageLocationList = ShoppingItemStorageLocationLocalServiceUtil.findByItemId(shoppingItem.getItemId());
}
%>
		
<div class="modal" id="<portlet:namespace />shopping_item_form" >
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />shopping_item_form').remove();">×</button>
		<h3><%= LanguageUtil.get(locale, "shopping-item") %></h3>
	</div>
	<div class="modal-body">
		<aui:form name='shopping_item_fm' enctype="multipart/form-data">
			<div class="">	
				<aui:input name="itemId" type="text" value="<%= shoppingItem.getItemId()  %>" disabled="true"/>
				<aui:input name="title" type="text" value="<%= shoppingItem.getTitle() %>" placeholder="Title"/>
				<aui:input name="description" type="textarea" inlineField="<%=true %>" cssClass="text-area" value="<%= shoppingItem.getDescription() %>" placeholder="Description" />
				<aui:input name="price" type="text" value="<%= shoppingItem.getPrice() %>" placeholder="Price"/>
				<aui:input name="discountPrice" type="text" value="<%= shoppingItem.getDiscountPrice() %>" placeholder="discountPrice"/>
				<aui:input name="sku" type="text" value="<%= shoppingItem.getSku() %>" placeholder="SKU"/>
				
				<aui:select name="itemTypeId" >
				    <aui:option value="" label="select"></aui:option>
				    <%
				    for(ShoppingItemType shoppingItemType : shoppingItemTypeList){
					%>
						<aui:option value="<%= shoppingItemType.getItemTypeId() %>" label="<%= shoppingItemType.getName() %>"></aui:option>
					<%
				    }
					%>	
				</aui:select>
				
				<div>
					<h4>Images</h4>
					<div class="item-image-wrap item-image-wrap-1">
						<aui:input type="file" name="image1" label="image1"></aui:input>
						<aui:input name="imageURL1" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-2">
						<aui:input type="file" name="image2" label="image2"></aui:input>
						<aui:input name="imageURL2" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-3">
						<aui:input type="file" name="image3" label="image3"></aui:input>
						<aui:input name="imageURL3" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-4">
						<aui:input type="file" name="image4" label="image4"></aui:input>
						<aui:input name="imageURL4" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-5">
						<aui:input type="file" name="image5" label="image5"></aui:input>
						<aui:input name="imageURL5" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-6">
						<aui:input type="file" name="image6" label="image6"></aui:input>
						<aui:input name="imageURL6" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-7">
						<aui:input type="file" name="image7" label="image7"></aui:input>
						<aui:input name="imageURL7" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-8">
						<aui:input type="file" name="image8" label="image8"></aui:input>
						<aui:input name="imageURL8" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-9">
						<aui:input type="file" name="image9" label="image9"></aui:input>
						<aui:input name="imageURL9" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-wrap item-image-wrap-10">
						<aui:input type="file" name="image10" label="image10"></aui:input>
						<aui:input name="imageURL10" type="text" value="" placeholder="Image URL"/>
					</div>
					<div class="item-image-controls">
						<a href="javascript:;" class="fa fa-plus-circle" id="<portlet:namespace />add-item-image"></a>
						<a href="javascript:;" class="fa fa-minus-circle" id="<portlet:namespace />remove-item-image"></a>
					</div>
				</div>
				
				
				<c:if test="<%= !shoppingItem.isNew() %>">
					<div class="item-table-wrapper" >
						<table class="settings-table item-table table table-bordered table-striped" id="<portlet:namespace />item-table" >	
							<thead>
							
								<tr>
									<td>Name</td>
									<td>Quantity</td>
									<td></td>
								</tr>
							</thead>
							<tbody>
							<%
							  	for(ShoppingItemStorageLocation shoppingItemStorageLocation: shoppingItemStorageLocationList){
							  		long shoppingItemStorageLocationId = shoppingItemStorageLocation.getItemStorageLocationId();
						  	%>
								<tr id="<portlet:namespace />item-storage-location-row-<%= shoppingItemStorageLocationId %>">
								
									<td id="<%= "item-storage-location-name-"+shoppingItemStorageLocationId %>"> <%= shoppingItemStorageLocation.getName() %></td>
									<td id="<%= "item-storage-location-quantity-"+shoppingItemStorageLocationId %>"><%= shoppingItemStorageLocation.getQuantity() %></td>
									<td class="settings-actions">
										<a class="save-item-storage-location-btn fa fa-pencil-square" data-item-storage-location-id="<%= shoppingItemStorageLocationId %>" title="edit" href="javascript:;"></a>
									</td>
								</tr>
							<%
							  	}		  	
							 %>
							</tbody>
						
						</table>
					</div>
				</c:if>	
				
				
				<div class="clearfix"></div>
			</div>
			<div id="<portlet:namespace />shipping-form-error" class="error-message shipping-form-error">
				
			</div>
		</aui:form>
		
		
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />shopping_item_form').remove();" >Close</button>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace />saveShoppingItem()">Save</button>
	</div>
	
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker,liferay-dynamic-select">
	
		
</aui:script>