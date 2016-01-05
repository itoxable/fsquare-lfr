<%@page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrder"%>
<%@page import="com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%

List<ShoppingOrderItem> shoppingOrderItemList = (List<ShoppingOrderItem>)request.getAttribute(ShoppingPortletUtil.ATTR_ORDER_ITEMS);

%>

<div class="modal" id="<portlet:namespace />order_items">
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />order_items').remove();">×</button>
		<h3>Order Items</h3>
	</div>
	<div class="modal-body">
		<table class="cart-table">
			<tbody>
				<tr class="table-header">
				    <td></td>
				    <td>PRODUCT</td>
				    <td align="center">QTY</td>
				    <td align="right">PRICE</td>
			  	</tr>
			  	
			  	<%
			  	for(ShoppingOrderItem orderItem: shoppingOrderItemList){
			  		JournalArticle journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getScopeGroupId(), orderItem.getArticleId());
			  		
			  	%>
			    <tr class="product-row product-row-<%= orderItem.getArticleId() %>">
				    
				    <td style="width: 70px">      
				    	<img src="<%= ShoppingPortletUtil.getMainImageURL(journalArticle) %>" alt="" class="cart-item-img">
				    </td>
				    
				    <td>
				      	<strong><%= journalArticle.getTitle(themeDisplay.getSiteDefaultLocale()) %></strong>
				    </td>
				    
				    <td align="center">
				    	<strong><%=orderItem.getQuantity() %></strong>
				    </td>          
			    	<td align="right">
			    		<%= shoppingStore.getCurrency() %><span class="cart-item-price" id="<portlet:namespace />cart_item_price_<%= orderItem.getArticleId() %>"><%= orderItem.getPrice() %></span>
			    	</td>
			  	</tr>
			  	<%
			  	}
			  	%>
			  </tbody>
		</table>
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />order_items').remove();" >Close</button>
	</div>
	
</div>