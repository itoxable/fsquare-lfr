<%@page import="com.fsquare.shopping.model.ShoppingStorageLocation"%>
<%@page import="com.fsquare.shopping.service.ShoppingStorageLocationLocalServiceUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.fsquare.shopping.service.ShoppingItemImageLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItemImage"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.fsquare.shopping.service.ShoppingItemTypeLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItemType"%>
<%@page import="com.fsquare.shopping.service.ShoppingItemLocalServiceUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItem"%>
<%@page import="com.fsquare.shopping.ShoppingUtil"%>
<%@ include file="init.jsp" %>

<%

List<ShoppingItem> shoppingItemList = ShoppingItemLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
List<ShoppingItemType> shoppingItemTypeList = ShoppingItemTypeLocalServiceUtil.getShoppingItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
List<ShoppingStorageLocation> shoppingStorageLocationList = ShoppingStoreLocalServiceUtil.getShoppingStorageLocationsByGroup(themeDisplay.getScopeGroupId());

%>
<liferay-portlet:resourceURL var="openShoppingItemFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_SHOPPING_ITEM_FORM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openShoppingItemTypeFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_SHOPPING_ITEM_TYPE_FORM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveShoppingItemURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_SHOPPING_ITEM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveShoppingItemTypeURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_SHOPPING_ITEM_TYPE %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="deleteShoppingItemTypeURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_SHOPPING_ITEM_TYPE %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="deleteShoppingItemURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_SHOPPING_ITEM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openStorageLocationURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_STORAGE_LOCATION %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveStorageLocationURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_STORAGE_LOCATION %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="deleteStorageLocationURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_STORAGE_LOCATION %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveItemStorageLocationURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_ITEM_STORAGE_LOCATION %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openItemStorageLocationURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_ITEM_STORAGE_LOCATION %>" />
</liferay-portlet:resourceURL>

<div>
	<h3>Inventory Management</h3>
	
	<div class="item-table-wrapper" >
		<table class="settings-table item-table table table-bordered table-striped" id="<portlet:namespace />item-table" >	
			<thead>
			
			<column name="itemTypeId" type="long" primary="true" />

				<tr>
					<td>itemTypeId</td>
					<td>Name</td>
					<td>Description</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				
			<%
			  	for(ShoppingItemType shoppingItemType: shoppingItemTypeList){
			  		long shoppingItemTypeId = shoppingItemType.getItemTypeId();
		  	%>
				<tr id="<portlet:namespace />item-row-<%= shoppingItemTypeId %>">
					<td id="<%= "shopping-item-id-"+shoppingItemTypeId %>"> <%= shoppingItemTypeId %></td>
					<td id="<%= "shopping-item-name-"+shoppingItemTypeId %>"> <%= shoppingItemType.getName() %></td>
					<td id="<%= "shopping-item-description-"+shoppingItemTypeId %>"><%= shoppingItemType.getDescription() %></td>
				
					<td class="settings-actions">
						<a class="open-shopping-item-type-btn fa fa-pencil-square" data-shopping-type-item-id="<%= shoppingItemTypeId %>" title="edit" href="javascript:;"></a>
					</td>
				</tr>
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
		
		<a class="btn open-new-shopping-item-type-btn" data-shopping-item-id="" href="javascript:;">
			<span class="fa fa-pencil-square"></span><span>New shopping item type</span>
		</a>
		
	</div>
	
	<div class="item-table-wrapper" style="margin-top: 30px">
		<table class="settings-table item-table table table-bordered table-striped" id="<portlet:namespace />item-table" >	
			<thead>
				<tr>
					<td></td>
					<td>itemId</td>
					<td>Name</td>
					<td>Description</td>
					<td>price</td>
					<td>Discount Price</td>
					<td>SKU</td>
					<td>itemTypeId</td>
					<td>Quantity</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				
			<%
			  	for(ShoppingItem shoppingItem: shoppingItemList){
			  		long shoppingItemId = shoppingItem.getItemId();
			  		ShoppingItemImage mainImage = ShoppingItemImageLocalServiceUtil.getItemMainImage(shoppingItem.getGroupId(), shoppingItem.getItemId());
		  	%>
				<tr id="<portlet:namespace />item-row-<%= shoppingItemId %>">
					<td style="width: 80px">
						<img alt="<liferay-ui:message key="image" />" src='<%= Validator.isNotNull(mainImage) ? themeDisplay.getPathImage()+ "/item?img_id=" + mainImage.getImageId()+ "&t=" + WebServerServletTokenUtil.getToken(mainImage.getImageId()) : "" %>' vspace="0" />
					</td>
					<td id="<%= "shopping-item-id-"+shoppingItemId %>"> <%= shoppingItem.getItemId() %></td>
					<td id="<%= "shopping-item-title-"+shoppingItemId %>"> <%= shoppingItem.getTitle() %></td>
					<td id="<%= "shopping-item-description-"+shoppingItemId %>"><%= shoppingItem.getDescription() %></td>
					<td id="<%= "shopping-item-price-"+shoppingItemId %>"><%= shoppingItem.getPrice()%></td>
					<td id="<%= "shopping-item-discount-price-"+shoppingItemId %>"><%= shoppingItem.getDiscountPrice() %></td>
					<td id="<%= "shopping-item-sku-"+shoppingItemId %>"><%= shoppingItem.getSku() %></td>
					<td id="<%= "shopping-item-weight-"+shoppingItemId %>"><%= shoppingItem.getItemTypeId() %></td>
					<td id="<%= "shopping-item-quantity-"+shoppingItemId %>"><%= ShoppingItemLocalServiceUtil.availableQuantity(shoppingItemId) %></td>
					<td class="settings-actions" style="width: 100px">
						<a class="open-shopping-item-btn fa fa-pencil-square" data-shopping-item-id="<%= shoppingItemId %>" title="edit" href="javascript:;"></a>
						<a class="delete-shopping-item-btn fa fa-trash" data-shopping-item-id="<%= shoppingItemId %>" title="delete" href="javascript:;"></a>
						
						<a class="add-shopping-item-btn fa fa-plus" data-shopping-item-id="<%= shoppingItemId %>" title="add" href="javascript:;"></a>
						<a class="remove-shopping-item-btn fa fa-minus" data-shopping-item-id="<%= shoppingItemId %>" title="remove" href="javascript:;"></a>
						<a class="move-shopping-item-btn fa fa-arrows-h" data-shopping-item-id="<%= shoppingItemId %>" title="move" href="javascript:;"></a>
					</td>
				</tr>
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
		
		<a class="btn open-new-shopping-item-btn" data-shopping-item-id="" href="javascript:;">
			<span class="fa fa-pencil-square"></span><span>New shopping item</span>
		</a>
	</div>	
	
	<div class="item-table-wrapper" style="margin-top: 30px">
		<table class="settings-table item-table table table-bordered table-striped" id="<portlet:namespace />item-table" >	
			<thead>
			
				<tr>
					<td>storageLocationId</td>
					<td>Name</td>
					<td>Location</td>
					<td>description</td>
					
					<td></td>
				</tr>
			</thead>
			<tbody>
			<%
			  	for(ShoppingStorageLocation storageLocation: shoppingStorageLocationList){
			  		long storageLocationId = storageLocation.getStorageLocationId();
		  	%>
				<tr id="<portlet:namespace />storage-location-row-<%= storageLocationId %>">
				
					<td id="<%= "storage-location-id-"+storageLocationId %>"> <%= storageLocationId %></td>
					<td id="<%= "storage-location-name-"+storageLocationId %>"> <%= storageLocation.getName() %></td>
					<td id="<%= "storage-location-location-"+storageLocationId %>"><%= storageLocation.getLocation() %></td>
					<td id="<%= "storage-location-description-"+storageLocationId %>"><%= storageLocation.getDescription() %></td>
					<td class="settings-actions">
						<a class="open-storage-location-btn fa fa-pencil-square" data-storage-location-id="<%= storageLocationId %>" title="edit" href="javascript:;"></a>
					</td>
				</tr>
			<%
			  	}		  	
			 %>
			</tbody>
		
		</table>
		
		<a class="btn open-new-storage-location-btn" data-shopping-item-id="" href="javascript:;">
			<span class="fa fa-pencil-square"></span><span>New storage location</span>
		</a>
		
	</div>
		
	<div id="<portlet:namespace />items-table-error" class="error-message items-table-error"></div>
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker">
	
	var itemImageindex = 2;

	A.on('click', function(event) {
		console.log(itemImageindex);
		if(itemImageindex < 11){
			$('.item-image-wrap-'+itemImageindex).fadeIn();
		}if(itemImageindex < 10){
			itemImageindex++;
		}
	},'#<portlet:namespace />add-item-image');
	
	
	A.on('click', function(event) {
		console.log(itemImageindex);
		if(itemImageindex > 2){
			$('.item-image-wrap-'+itemImageindex).fadeOut();
			itemImageindex--;
		}
	},'#<portlet:namespace />remove-item-image');
	
	
	
	A.on('click', function(event) {
		<portlet:namespace />deleteShoppingItem(this.getAttribute('data-shopping-item-id'));
	}, '.delete-shopping-item-btn');
	
	Liferay.provide(window, '<portlet:namespace />deleteShoppingItem',
		function(itemId) {
			
			A.io.request('<%= deleteShoppingItemURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />itemId : itemId
	              },
	              on: {
	              	success: function() {
						var response = this.get('responseData');
						if(response.success){
							A.one('#<portlet:namespace />item-row-'+itemId).remove(true);
						}else{
	                  		A.one("#<portlet:namespace />items-table-error").text(response.errorMessage);
						}
	              	}
	              }
	        });
			
	    },
		['aui-base,selector-css3']);
	
	A.on('click', function(event) {
		<portlet:namespace />openShoppingItemForm(0);
	}, '.open-new-shopping-item-btn');

	A.on('click', function(event) {
		debug(this,event);
		<portlet:namespace />openShoppingItemForm(this.getAttribute('data-shopping-item-id'));
	}, '.open-shopping-item-btn');
	
	Liferay.provide(window, '<portlet:namespace />openShoppingItemForm',
		function(itemId) {
			console.log("shoppingItemId: "+itemId);
			A.io.request('<%= openShoppingItemFormURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />itemId : itemId
	              },
	              on: {
	                  success: function() {
	                	itemImageindex = 2;
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one('.inventory-management'));

	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);
	
	
	A.on('click', function(event) {
		<portlet:namespace />openShoppingItemTypeForm(0);
	}, '.open-new-shopping-item-type-btn');

	A.on('click', function(event) {
		debug(this,event);
		<portlet:namespace />openShoppingItemTypeForm(this.getAttribute('data-shopping-item-id'));
	}, '.open-shopping-item-type-btn');
	
	Liferay.provide(window, '<portlet:namespace />openShoppingItemTypeForm',
		function(itemTypeId) {
			console.log("shoppingItemTypeId: "+itemTypeId);
			A.io.request('<%= openShoppingItemTypeFormURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />itemTypeId : itemTypeId
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one('.inventory-management'));

	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);
	
	Liferay.provide(window, '<portlet:namespace />saveShoppingItem',
		function() {
			
			var shopping_item_fm = A.one("#<portlet:namespace />shopping_item_fm");
			
			A.io.request('<%= saveShoppingItemURL %>',{
				dataType: 'json',
                method: 'POST',
                form: {
                    id: shopping_item_fm,
                    upload: true
                },
                sync: true,
                on: {
                    complete: function(){
                        //var response = this.get('responseData');
                        debug(this.get('responseData'));
                        jQuery('#<portlet:namespace />shopping_item_form').remove();
                    },
                    success: function() {
                    	alert("File Upload Success!");
	                }
                }
			});
			
	    },
		['aui-base,selector-css3']);
	
	A.on('click', function(event) {
		<portlet:namespace />openItemStorageLocationForm(0,this.getAttribute('data-shopping-item-id'),'<%= ShoppingUtil.SHOPPING_ITEM_MOVEMENT_ADD %>');
	}, '.add-shopping-item-btn');
	A.on('click', function(event) {
		<portlet:namespace />openItemStorageLocationForm(0,this.getAttribute('data-shopping-item-id'),'<%= ShoppingUtil.SHOPPING_ITEM_MOVEMENT_REMOVE %>');
	}, '.remove-shopping-item-btn');
	A.on('click', function(event) {
		<portlet:namespace />openItemStorageLocationForm(0,this.getAttribute('data-shopping-item-id'),'<%= ShoppingUtil.SHOPPING_ITEM_MOVEMENT_MOVE %>');
	}, '.move-shopping-item-btn');

	Liferay.provide(window, '<portlet:namespace />openItemStorageLocationForm',
		function(itemStorageLocationId, itemId, movement, wrapper) {
			if(!wrapper){
				wrapper = '.inventory-management';
			}
			console.log("itemStorageLocationId: "+itemStorageLocationId);
			A.io.request('<%= openItemStorageLocationURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />itemStorageLocationId : itemStorageLocationId,
	            	  <portlet:namespace />itemId : itemId,
	            	  <portlet:namespace />movement : movement
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one(wrapper));

	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);
	
	
	Liferay.provide(window, '<portlet:namespace />saveShoppingItemType',
		function() {
			A.io.request('<%= saveShoppingItemTypeURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />itemId : A.one('#<portlet:namespace />itemTypeId').val(),
	            	  <portlet:namespace />name : A.one('#<portlet:namespace />name').val(),
	            	  <portlet:namespace />description : A.one('#<portlet:namespace />description').val(),
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	if(response.success){
	                  		jQuery('#<portlet:namespace />shopping_item_type_form').remove();
	                  	}else{
	                  		A.one("#<portlet:namespace />item-type-form-error").text(response.errorMessage);
	                  	}
	                  	
	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3']);
		
	A.on('click', function(event) {
		<portlet:namespace />openStorageLocationForm(0);
	}, '.open-new-storage-location-btn');

	A.on('click', function(event) {
		<portlet:namespace />openStorageLocationForm(this.getAttribute('data-storage-location-id'));
	}, '.open-storage-location-btn');
	
	Liferay.provide(window, '<portlet:namespace />openStorageLocationForm',
		function(storageLocationId) {
		
			A.io.request('<%= openStorageLocationURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />storageLocationId : storageLocationId
	              },
	              on: {
	                  success: function() {
	                	itemImageindex = 2;
	                  	var response = this.get('responseData');
	                  	var form = A.Node.create(response);
	                  	form.delegate();
	                  	form.appendTo(A.one('.inventory-management'));

	                  }
	              }
	        });
			
	    },
		['aui-base,selector-css3,aui-datepicker']);
	
	
	A.on('click', function(event) {
		<portlet:namespace />saveItemStorageLocation();
	}, '.save-item-storage-location-btn');
	
	Liferay.provide(window, '<portlet:namespace />saveItemStorageLocation',
			function() {
				
		
				var shoppingItemLocationFm = A.one("#<portlet:namespace />shopping_item_location_fm");
				A.io.request('<%= saveItemStorageLocationURL %>',{
		              dataType: 'json',
		              method: 'POST',
		              data: {
		            	  <portlet:namespace />itemId : A.one('#<portlet:namespace />itemId').val(),
		            	  <portlet:namespace />movement : A.one('#<portlet:namespace />movement').val(),
		            	  <portlet:namespace />storageLocationId : A.one('#<portlet:namespace />storageLocationId').val(),
		            	  <portlet:namespace />quantity : A.one('#<portlet:namespace />quantity').val(),
		              },
		              on: {
		                  success: function() {
		                  	var response = this.get('responseData');
		                  	if(response.success){
		                  		jQuery('#<portlet:namespace />shopping_item_location_form').remove();
		                  	}else{
		                  	}
		                  	
		                  }
		              }
		        });
				
		    },
			['aui-base,selector-css3']);
	
	Liferay.provide(window, '<portlet:namespace />saveStorageLocation',
			function() {
				A.io.request('<%= saveStorageLocationURL %>',{
		              dataType: 'json',
		              method: 'POST',
		              data: {
		            	  <portlet:namespace />itemId : A.one('#<portlet:namespace />itemTypeId').val(),
		            	  <portlet:namespace />name : A.one('#<portlet:namespace />name').val(),
		            	  <portlet:namespace />description : A.one('#<portlet:namespace />description').val(),
		              },
		              on: {
		                  success: function() {
		                  	var response = this.get('responseData');
		                  	if(response.success){
		                  		jQuery('#<portlet:namespace />storage_location_form').remove();

		                  	}else{
		                  		A.one("#<portlet:namespace />storage-location-form-error").text(response.errorMessage);
		                  	}
		                  	
		                  }
		              }
		        });
				
		    },
			['aui-base,selector-css3']);
	
</aui:script>