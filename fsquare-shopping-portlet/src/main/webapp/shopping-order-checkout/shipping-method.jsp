<%@page import="com.fsquare.shopping.model.ShoppingShippingMethod"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%


%>

<liferay-portlet:resourceURL var="setShippingMethodURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_CHECKOUT_SHIPPING_METHOD %>" />
</liferay-portlet:resourceURL>
<div>
	<aui:form id='shipping-method-form' name='shipping-method-form'>
		<%
			for(ShoppingShippingMethod shippingMethod : availableShoppingShippingMethodList){
		%>
		<aui:input name="shippingMethodId" value="<%= shippingMethod.getShippingMethodId()%>" type="radio" label='<%= shippingMethod.getName() + StringPool.BLANK + "(" + shoppingStore.getCurrency() + shippingMethod.getPrice() + ")" %>'></aui:input>
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
  		<portlet:namespace />showLoading('#<portlet:namespace />checkout-panel-shipping');
  		<portlet:namespace />showLoading('#<portlet:namespace />checkout-order-summary');
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
			form.find("input[type=radio]:checked").each(function() {
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
                  	  	<portlet:namespace />hideLoading('#<portlet:namespace />checkout-panel-shipping');
                  	  	
                  	  	var response = this.get('responseData');
                  	  	A.one('#<portlet:namespace />shipping-method-form-error').text("");
                  		if(response.success){
	                  	  	var shoppingShippingMethodJson = JSON.parse(response.shoppingShippingMethod);
							var savedFieldSet = '<div class="saved-order-fields">';
							
							savedFieldSet += '<div>';
							savedFieldSet += shoppingShippingMethodJson.name + " - " + shoppingShippingMethodJson.description + " (<%= shoppingStore.getCurrency()%>" +shoppingShippingMethodJson.price+")";
							savedFieldSet += '</div>';
							savedFieldSet += '<br>';
							savedFieldSet += '</div>';
							
							
							$('.order-summary-shipping-description').text(shoppingShippingMethodJson.description);
							$('.order-summary-shipping-price').text('<%= shoppingStore.getCurrency()%>'+shoppingShippingMethodJson.price);
							$('#<portlet:namespace />order-summary-total-price').text(response.total);
                      		A.one('.shipping-method-row').removeClass("hide");

							<portlet:namespace />hideLoading('#<portlet:namespace />checkout-order-summary');
                  	  	
							form.fadeOut(200, function(){
								var wrapper = form.closest('.checkout-panel');
								wrapper.find('.checkout-edit-button').fadeIn(0);
								wrapper.find('.checkout-item-wrapper').append(savedFieldSet);
								form.remove();
								//<portlet:namespace />calculateShippingPrice();
								<portlet:namespace />loadStep(<%= ShoppingPortletUtil.CHECKOUT_STEP_PAYMENT_NR %>);
							});
						}
						else{
							A.one('#<portlet:namespace />shipping-method-form-error').text(response.errorMessage);
						}
                      
                      }
                  }
            });
        },
    	['aui-base,selector-css3']);
</aui:script>