<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

List<ShoppingShippingMethod>  availableShoppingShippingMethodList = (List<ShoppingShippingMethod> )request.getAttribute(ShoppingPortletUtil.ATTR_AVAILABLE_SHOPPING_SHIPPING_METHOD_LIST);

%>

<liferay-portlet:resourceURL var="setShippingMethodURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_CHECKOUT_SHIPPING_METHOD %>" />
</liferay-portlet:resourceURL>
<div>
	<aui:form id='shipping-method-form' name='shipping-method-form'>
		<%
			for(ShoppingShippingMethod shoppingShippingMethod : availableShoppingShippingMethodList){
		%>
		<aui:input name="shippingMethodId" value="<%= shoppingShippingMethod.getShippingMethodId()%>" type="radio" label='<%= shoppingShippingMethod.getName() + StringPool.BLANK + "(" + shoppingStore.getCurrency() + shoppingShippingMethod.getPrice() + ")" %>'></aui:input>
		<br>
		<%
			}
		%>
		<div id="<portlet:namespace />shipping-method-form-error" class="error-message shipping-method-form-error">
		</div>
		<button class="btn btn-primary" type="button" id="<portlet:namespace />set_shipping_method">Continue</button>
		
	</aui:form>
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,liferay-dynamic-select">
A.on('click', function(event) {
		<portlet:namespace />setShippingMethod();
	},'#<portlet:namespace />set_shipping_method');

	Liferay.provide(window, '<portlet:namespace />setShippingMethod',
		function() {
      	A.one('#<portlet:namespace />shipping-method-form-error').text("");

			var form = $('#<portlet:namespace />shipping-method-form');
			
			var data = {};
			form.find('input').each(function() {
				data[$(this).attr('name')]=$(this).val();
			});
			form.find('select').each(function() {
				data[$(this).attr('name')]=$(this).val();
			});
			form.find('textarea').each(function() {
				data[$(this).attr('name')]=$(this).text();
			});
			
			A.io.request('<%= setShippingMethodURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: data,
                  on: {
                      success: function() {
                      	var response = this.get('responseData');
//                   		if(response.success){
//                   			debug(response);
                  			
                  			
							form.fadeOut(200, function(){
								$('#<portlet:namespace />payment-form-wrapper').append(response);
							});
                  			
                  			
//                   		}
//                   		else{
//                   			A.one('#<portlet:namespace />shipping-method-form-error').text(response.errorMessage);
//   	                  	}
                      }
                  }
            });
        },
    	['aui-base,selector-css3']);
</aui:script>