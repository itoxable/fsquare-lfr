<%@page import="com.liferay.portal.model.Address"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.fsquare.shopping.ShoppingUtil"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%@ include file="init.jsp" %>

<%
boolean showLogin = ShoppingUtil.USER_TYPES_ALL.equals(shoppingStore.getUserTypes()) && !themeDisplay.isSignedIn();
System.out.println("user: "+user);
String email = shoppingOrder.getShippingEmailAddress();
String firstName = shoppingOrder.getShippingFirstName();
String lastName = shoppingOrder.getShippingLastName();
String streetAddress1 = shoppingOrder.getShippingStreet();
String streetAddress2 = shoppingOrder.getShippingStreet2();
String postCode = shoppingOrder.getShippingPostCode();
String city = shoppingOrder.getShippingCity();
String shippingCountry = shoppingOrder.getShippingCountry();
String phoneNumber = shoppingOrder.getShippingPhone();
//User user = themeDisplay.getUser();
if(themeDisplay.isSignedIn()){
	if(Validator.isNull(email))
		email = user.getEmailAddress();
	if(Validator.isNull(firstName))
		firstName = user.getFirstName();
	if(Validator.isNull(lastName))
		lastName = user.getLastName();
	
	if(user.getAddresses() != null && !user.getAddresses().isEmpty()){
		Address address = user.getAddresses().get(0);
		if(Validator.isNull(streetAddress1))
			streetAddress1 = address.getStreet1();
		if(Validator.isNull(streetAddress2))
			streetAddress2 = address.getStreet2();
		if(Validator.isNull(postCode))
			postCode = address.getZip();
		if(Validator.isNull(city))
			city = address.getCity();
		if(Validator.isNull(shippingCountry))
			shippingCountry = address.getCountry().getA2();
	}
	
	if(user.getPhones() != null && !user.getPhones().isEmpty()){
		if(Validator.isNull(phoneNumber))
			phoneNumber = user.getPhones().get(0).getNumber();
	}

}
System.out.println("shippingCountry: "+shippingCountry);
%>

<liferay-portlet:resourceURL var="saveAddressURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_CHECKOUT_SHIPPING_ADDRESS %>" />
</liferay-portlet:resourceURL>

	<aui:form id='shipping-address-form' name='shipping-address-form'>
		<aui:fieldset>
			<aui:input disabled="<%= themeDisplay.isSignedIn() %>" name="email" label='<%=showLogin?"email-as-guest":"email" %>' showRequiredLabel="<%= false %>" required="<%= true %>"  type="email" inlineLabel="left" value="<%= email %>" placeholder="email"/>
			
			<c:if test='<%= showLogin %>'>
				<span><%= LanguageUtil.get(locale, "or") %></span>
				<a href='<%= themeDisplay.getURLSignIn() %>' class='btn'><%= LanguageUtil.get(locale, "login") %></a>
			</c:if>
		</aui:fieldset>
		<aui:fieldset style="margin-top: 20px">
			<aui:input  autoSize="<%= true %>" showRequiredLabel="<%= false %>" required="<%= true %>" inlineLabel="left" name="firstName" type="text" value="<%= firstName %>" placeholder="First Name" />
			<aui:input showRequiredLabel="<%= false %>" required="<%= true %>" inlineLabel="left" name="lastName" type="text" value="<%= lastName %>" placeholder="Last Name" />
			
			<aui:input showRequiredLabel="<%= false %>" required="<%= true %>" inlineLabel="left" name="streetAddress1" type="text" value="<%=streetAddress1 %>" placeholder="Street Address 1"/>
			<aui:input inlineLabel="left" name="streetAddress2" type="text" value="<%=streetAddress2%>" placeholder="Street Address 2"/>
			
			<aui:input showRequiredLabel="<%= false %>" required="<%= true %>" inlineLabel="left" name="city" type="text" value="<%= city %>" placeholder="City"/>
			<aui:input showRequiredLabel="<%= false %>" required="<%= true %>" inlineLabel="left" name="postCode" type="text" value="<%= postCode %>" placeholder="Post Code"/>
			<aui:select showRequiredLabel="<%= false %>" required="<%= true %>" inlineLabel="left" name="country" label="country" >
				<% for(Country country: countries) {%>
					<aui:option selected="<%= country.getA2().equalsIgnoreCase(shoppingOrder.getShippingCountry()!=null?shoppingOrder.getShippingCountry():shoppingStore.getCountry()) %>" value="<%= country.getA2() %>" label="<%= country.getName(locale) %>"></aui:option>
				<% } %>
			</aui:select>
			
			<aui:input showRequiredLabel="<%= false %>" required="<%= true %>" inlineLabel="left" name="phoneNumber" type="phone" value="<%=phoneNumber %>" placeholder="Phone Number"/>
			
			<div id="<portlet:namespace />shipping-address-form-error" class="error-message shipping-address-form-error">
			</div>
			<button class="btn btn-primary checkout-button" style="margin-top: 30px;" type="submit" id="<portlet:namespace />save_shipping_address">Continue</button>
			
		</aui:fieldset>
	</aui:form>
<aui:script use="aui-base,selector-css3,aui-io-request,liferay-dynamic-select">
	

	A.one('#<portlet:namespace />shipping-address-form').on(
		'submit',
		function(event) {
			event.halt();
			event.stopImmediatePropagation();
			var error = this.one('.error-field');
			if(!error || error == null){
				<portlet:namespace />showLoading('#<portlet:namespace />checkout-panel-address');
				<portlet:namespace />saveShippingAddress();
			}
		}
	);
	
	Liferay.provide(window, '<portlet:namespace />saveShippingAddress',
		function() {
			var form = $('#<portlet:namespace />shipping-address-form');
			
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
			
			A.io.request('<%= saveAddressURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: data,
                  on: {
                      success: function() {
                    	  	<portlet:namespace />hideLoading('#<portlet:namespace />checkout-panel-address');
							var response = this.get('responseData');
							A.one('#<portlet:namespace />shipping-address-form-error').text("");
							if(response.success){
								
								var shoppingOrderJson = JSON.parse(response.shoppingOrder);
								var savedFieldSet = '<div class="saved-order-fields">';
								
								savedFieldSet += '<h5 class="subtitle">Your Email Address</h5>';
								savedFieldSet += '<div>';
								savedFieldSet += shoppingOrderJson.shippingEmailAddress;
								savedFieldSet += '</div>';
								savedFieldSet += '<br>';
								savedFieldSet += '<h5 class="subtitle">Shipping Address</h5>';
								savedFieldSet += '<div>';
								savedFieldSet += shoppingOrderJson.shippingFirstName+" "+shoppingOrderJson.shippingLastName;
								savedFieldSet += '</div>';
								savedFieldSet += '<div>';
								savedFieldSet += shoppingOrderJson.shippingStreet;
								savedFieldSet += '</div>';
								savedFieldSet += '<div>';
								savedFieldSet += shoppingOrderJson.shippingStreet2;
								savedFieldSet += '</div>';
								savedFieldSet += '<div>';
								savedFieldSet += shoppingOrderJson.shippingCity+" "+shoppingOrderJson.shippingPostCode;
								savedFieldSet += '</div>';
								savedFieldSet += '<div>';
								savedFieldSet += response.countryName;
								savedFieldSet += '</div>';
								savedFieldSet += '<div>';
								savedFieldSet += shoppingOrderJson.shippingPhone;
								savedFieldSet += '</div>';
								savedFieldSet += '<br>';
								savedFieldSet += '</div>';
								
								
								form.fadeOut(200, function(){
									
									var wrapper = form.closest('.checkout-panel');
									wrapper.find('.checkout-edit-button').fadeIn(0);
									wrapper.find('.checkout-item-wrapper').append(savedFieldSet);
									form.remove();
									<portlet:namespace />loadStep(<%= ShoppingPortletUtil.CHECKOUT_STEP_SHIPPING_NR %>);
								});
							}
							else{
								if(response.failValidation){
									
								}
								A.one('#<portlet:namespace />shipping-address-form-error').text(response.errorMessage);
							}
                      }
                  }
            });
        },
    	['aui-base,selector-css3']);
</aui:script>