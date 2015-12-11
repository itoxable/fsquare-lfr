
<%@ include file="init.jsp" %>



<liferay-portlet:resourceURL var="getOrderTotalURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_GET_ORDER_TOTAL %>" />
</liferay-portlet:resourceURL>
		
<c:choose>
	<c:when test='<%= shoppingStore.isIntegrateWithStripe() %>'>
		<jsp:include page="payment-form-stripe.jsp" />
	</c:when>
	<c:when test='<%= shoppingStore.isIntegrateWithBraintree() %>'>
		<jsp:include page="payment-form-braintree.jsp" />
	</c:when>
	<c:otherwise>
		<div>
			<h1>No payment method defined</h1>
		</div>
	</c:otherwise>
</c:choose>
	
	
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker,liferay-dynamic-select">

	Liferay.provide(window, '<portlet:namespace />getOrderTotal',
			function(callback) {
				A.io.request('<%= getOrderTotalURL %>',{
	                  dataType: 'json',
	                  method: 'POST',
	                  data: {},
	                  on: {
	                	  success: function() {
	  	                  	var responseData = this.get('responseData');
	  	                  	callback(responseData);
	  	                  }
	                  }
	            });
			
		  	
	    },['aui-base,selector-css3']);
	
	
</aui:script>
