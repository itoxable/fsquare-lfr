<%@page import="com.fsquare.shopping.ShoppingUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingItem"%>
<%@ include file="init.jsp" %>

<%


ShoppingItem shoppingItem = (ShoppingItem)request.getAttribute(ShoppingUtil.SHOPPING_ITEM_RECORD);


%>

<h1><%= shoppingItem.getTitle() %></h1>
<h2><%= shoppingItem.getDescription() %></h2>
<h3><%= shoppingItem.getPrice() %></h3>