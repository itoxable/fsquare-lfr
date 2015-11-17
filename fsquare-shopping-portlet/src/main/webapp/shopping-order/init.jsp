<%@page import="com.fsquare.shopping.portlet.ShoppingOrderProcessWrapper"%>
<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="com.fsquare.shopping.model.ShoppingCoupon"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrder"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@ include file="../init.jsp" %>

<%

List<Country> countries = CountryServiceUtil.getCountries();

ShoppingOrderProcessWrapper shoppingOrderProcessWrapper = ShoppingPortletUtil.getSessionShoppingOrderProcessWrapper(session);

Map<String, ShoppingOrderItem> shoppingOrderItemMap = shoppingOrderProcessWrapper.getShoppingOrderItemMap();
ShoppingOrder shoppingOrder = shoppingOrderProcessWrapper.getShoppingOrder();
ShoppingCoupon shoppingCoupon = shoppingOrderProcessWrapper.getShoppingCoupon();//ShoppingPortletUtil.getSessionCoupon(session);
List<ShoppingShippingMethod> availableShoppingShippingMethodList = shoppingOrderProcessWrapper.getAvailableShoppingShippingMethodList();
ShoppingShippingMethod shoppingShippingMethod = shoppingOrderProcessWrapper.getShoppingShippingMethod();

boolean isCartEmpty = (shoppingOrderItemMap == null || shoppingOrderItemMap.isEmpty());
// System.out.println("isCartEmpty: "+isCartEmpty);
// System.out.println("shoppingOrderItemMap == null: "+shoppingOrderItemMap == null);
// System.out.println("shoppingOrderItemMap.isEmpty(): "+shoppingOrderItemMap.isEmpty());
%>