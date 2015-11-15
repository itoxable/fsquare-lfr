<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

%>

<liferay-portlet:resourceURL var="saveAddressURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_CHECKOUT_SHIPPING_ADDRESS %>" />
</liferay-portlet:resourceURL>

<div>
	<aui:form id='shipping-address-form' name='shipping-address-form'>
		<aui:fieldset>
			<aui:input name="email" type="email" value="" placeholder="Name"/>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="firstName" type="text" value="" placeholder="First Name" />
			<aui:input name="lastName" type="text" value="" placeholder="Last Name" />
			
			<aui:input name="streetAddress1" type="text" value="" placeholder="Street Address 1"/>
			<aui:input name="streetAddress2" type="text" value="" placeholder="Street Address 2"/>
			
			<aui:input name="city" type="text" value="" placeholder="City"/>
			<aui:input name="postCode" type="text" value="" placeholder="Post Code"/>
			<aui:select name="country" label="country" >
				<% for(Country country: countries) {%>
					<aui:option selected="<%= country.getA2().equalsIgnoreCase(locale.getCountry()) %>" value="<%= country.getA2() %>" label="<%= country.getName(locale) %>"></aui:option>
				<% } %>
			</aui:select>
			<aui:input name="phoneNumber" type="phone" value="" placeholder="Phone Number"/>
			
			<div id="<portlet:namespace />shipping-address-form-error" class="error-message shipping-address-form-error">
			</div>
			<button class="btn btn-primary" type="button" id="<portlet:namespace />save_shipping_address">Continue</button>
			
		</aui:fieldset>
	</aui:form>
</div>
<aui:script use="aui-base,selector-css3,aui-io-request,liferay-dynamic-select">
	
	A.on('click', function(event) {
		<portlet:namespace />saveShippingAddress();
	},'#<portlet:namespace />save_shipping_address');

	Liferay.provide(window, '<portlet:namespace />saveShippingAddress',
		function() {
			var form = $('#<portlet:namespace />shipping-address-form');
			
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
			
			A.io.request('<%= saveAddressURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: data,
                  on: {
                      success: function() {
                      	var response = this.get('responseData');
                      	A.one('#<portlet:namespace />shipping-address-form-error').text("");
//                   		if(response.success){
							form.fadeOut(200, function(){
								$('#<portlet:namespace />shipping-method-wrapper').append(response);
							});
                  			
//                   		}
//                   		else{
//                   			A.one('#<portlet:namespace />shipping-address-form-error').text(response.errorMessage);
//   	                  	}
                      }
                  }
            });
        },
    	['aui-base,selector-css3']);
</aui:script>