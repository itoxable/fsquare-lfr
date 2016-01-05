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


%>
<liferay-portlet:resourceURL var="openShoppingItemFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_SHOPPING_ITEM_FORM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openShoppingItemTypeFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_SHOPPING_ITEM_TYPE_FORM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveShoppingItemURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_SHOPPING_ITEM_TYPE %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveShoppingItemTypeURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_SHOPPING_ITEM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="deleteShoppingItemTypeURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_SHOPPING_ITEM_TYPE %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="deleteShoppingItemURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_DELETE_SHOPPING_ITEM %>" />
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
					<td id="<%= "shopping-item-name-"+shoppingItemId %>"> <%= shoppingItem.getName() %></td>
					<td id="<%= "shopping-item-description-"+shoppingItemId %>"><%= shoppingItem.getDescription() %></td>
					<td id="<%= "shopping-item-price-"+shoppingItemId %>"><%= shoppingItem.getPrice()%></td>
					<td id="<%= "shopping-item-discount-price-"+shoppingItemId %>"><%= shoppingItem.getDiscountPrice() %></td>
					<td id="<%= "shopping-item-sku-"+shoppingItemId %>"><%= shoppingItem.getSku() %></td>
					<td id="<%= "shopping-item-weight-"+shoppingItemId %>"><%= shoppingItem.getItemTypeId() %></td>
					
					<td class="settings-actions">
						<a class="open-shopping-item-btn fa fa-pencil-square" data-shopping-item-id="<%= shoppingItemId %>" title="edit" href="javascript:;"></a>
						<a class="delete-shopping-item-btn fa fa-trash" data-shopping-item-id="<%= shoppingItemId %>" title="delete" href="javascript:;"></a>
						
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
						/*if(response.success){
							A.one('#<portlet:namespace />shipping-row-'+shippingMethodId).remove(true);
						}else{
	                  		A.one("#<portlet:namespace />shipping-table-error").text(response.errorMessage);
						}*/
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
			//A.one("#<portlet:namespace />shipping-form-error").text('');
			
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
                        alert("File Upload Complete!");
                    },
                    success: function() {
                    	alert("File Upload Success!");
	                }
                }
			});
			
			
			/*
			A.io.request('<%= saveShoppingItemURL %>',{
	              dataType: 'json',
	              method: 'POST',
	              data: {
	            	  <portlet:namespace />itemId : A.one('#<portlet:namespace />itemId').val(),
	            	  <portlet:namespace />name : A.one('#<portlet:namespace />name').val(),
	            	  <portlet:namespace />description : A.one('#<portlet:namespace />description').val(),
	            	  <portlet:namespace />price : A.one('#<portlet:namespace />price').val(),
	            	  <portlet:namespace />discountPrice : A.one('#<portlet:namespace />discountPrice').val(),
	            	  <portlet:namespace />sku : A.one('#<portlet:namespace />sku').val(),
	            	  <portlet:namespace />itemTypeId : A.one('#<portlet:namespace />itemTypeId').val()
	              },
	              on: {
	                  success: function() {
	                  	var response = this.get('responseData');
	                  	if(response.success){
	                  		
	                  	}else{
	                  		A.one("#<portlet:namespace />shipping-form-error").text(response.errorMessage);
	                  	}
	                  	
	                  }
	              }
	        });*/
			
	    },
		['aui-base,selector-css3']);
	
		
	Liferay.provide(window, '<portlet:namespace />saveShoppingItemType',
			function() {
				//A.one("#<portlet:namespace />shipping-form-error").text('');
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
		                  		
		                  	}else{
		                  		A.one("#<portlet:namespace />shipping-form-error").text(response.errorMessage);
		                  	}
		                  	
		                  }
		              }
		        });
				
		    },
			['aui-base,selector-css3']);
</aui:script>