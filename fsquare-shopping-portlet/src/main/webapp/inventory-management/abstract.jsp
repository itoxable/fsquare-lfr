<%@page import="com.fsquare.shopping.ShoppingUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItem"%>
<%@ include file="init.jsp" %>

<%


ShoppingItem shoppingItem = (ShoppingItem)request.getAttribute(ShoppingUtil.SHOPPING_ITEM_RECORD);


%>

<span><%= shoppingItem.getTitle() %></span>
<span><%= shoppingItem.getDescription() %></span>
<span><%= shoppingItem.getPrice() %></span>