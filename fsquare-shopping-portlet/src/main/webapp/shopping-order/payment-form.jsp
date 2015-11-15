<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

Calendar cal = Calendar.getInstance();
int thisYear = cal.get(Calendar.YEAR);
List<Country> countries = CountryServiceUtil.getCountries();

%>

<liferay-portlet:resourceURL var="checkoutPaymentURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_CHECKOUT_PAYMENT %>" />
</liferay-portlet:resourceURL>

		
<aui:form id='checkout-payment-form'  name="checkout-payment-form">

	<aui:fieldset cssClass="payment-test-fields-wrap" label="billing-address">
		<aui:input name="billingCardHolderName" type="text" value="" placeholder="Card Holder Name"/>
		<aui:input name="billingStreet" type="text" value="" placeholder="Street"/>
		<aui:input name="billingStreet2" type="text" value="" placeholder="Street (line 2)"/>
		<aui:input name="billingCity" type="text" value="" placeholder=""/>
		<aui:input name="billingPostCode" type="text" value="" placeholder=""/>
		<aui:input name="billingStateProvince" type="text" value="" placeholder=""/>
		<aui:select name="billingCountry" label="country" >
			<% for(Country country: countries) {%>
				<aui:option selected="<%= country.getA2().equalsIgnoreCase(locale.getCountry()) %>" value="<%= country.getA2() %>" label="<%= country.getName(locale) %>"></aui:option>
			<% } %>
		</aui:select>
		<aui:input name="billingEmailReceipe" type="email" value="" placeholder=""/>
	</aui:fieldset>


	<aui:fieldset cssClass="payment-test-fields-wrap" label="card-details">	
	
		<aui:select name="test_card" >
		    <aui:option value="4242424242424242" label="4242 4242 4242 4242 Visa"></aui:option>
		    <aui:option value="4012888888881881" label="4012 8888 8888 1881 Visa"></aui:option>
		    <aui:option value="4000056655665556" label="4000 0566 5566 5556 Visa (debit)"></aui:option>
		    <aui:option value="5555555555554444" label="5555 5555 5555 4444 MasterCard"></aui:option>
		    <aui:option value="5200828282828210" label="5200 8282 8282 8210 MasterCard (debit)"></aui:option>
		    <aui:option value="5105105105105100" label="5105 1051 0510 5100 MasterCard (prepaid)"></aui:option>
		    <aui:option value="378282246310005" label="3782 822463 10005 American Express"></aui:option>
		    <aui:option value="371449635398431" label="3714 496353 98431 American Express"></aui:option>
		    <aui:option value="6011111111111117" label="6011 1111 1111 1117 Discover"></aui:option>
		    <aui:option value="6011000990139424" label="6011 0009 9013 9424 Discover"></aui:option>
		    <aui:option value="30569309025904" label="3056 9309 0259 04 Diners Club"></aui:option>
		    <aui:option value="38520000023237" label="3852 0000 0232 37 Diners Club"></aui:option>
		    <aui:option value="3530111333300000" label="3530 1113 3330 0000 JCB"></aui:option>
		    <aui:option value="3566002020360505" label="3566 0020 2036 0505 JCB"></aui:option>
		</aui:select>
	
		<aui:input name="amount" type="text" value="1" placeholder="Amount"/>
		<aui:input name="cardNumber" type="text" value="" placeholder="Card Number"  data-stripe="number"/>
		<aui:input name="cvc" type="text" value="" placeholder="CVC" data-stripe="cvc"/>
		<aui:select name="expMonth" data-stripe="exp-month">
			<% for(int i = 1; i < 13; i++) {%>
			<aui:option selected="<%= i == cal.get(Calendar.MONTH) %>" value="<%= i+1 %>" label="<%= i+1 %>"></aui:option>
			<% } %>
		</aui:select>
		<aui:select name="expYear" data-stripe="exp-year">
			<% for(int i = thisYear; i < (thisYear+20); i++) {%>
			<aui:option value="<%= i %>" label="<%= i %>"></aui:option>
			<% } %>
		</aui:select>
		<aui:input name="description" type="text" value="" placeholder="Description"/>
		<aui:input name="statementDescription" type="text" value="" placeholder="Statement Description"/>
		
	</aui:fieldset>
	
	
	<div style="clear: both;"></div>
	
	<div id="<portlet:namespace />checkout-payment-form-error" class="error-message checkout-payment-form-error">
	</div>
	<button class="btn btn-primary" type="button" id="<portlet:namespace/>checkout-payment">Pay</button>
	
</aui:form>

		
	
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker,liferay-dynamic-select">


	A.on('change', function(event) {
		A.one('#<portlet:namespace />cardNumber').val(this.val());
  	  	A.one('#<portlet:namespace />cvc').val('123');
  	  	A.one('#<portlet:namespace />description').val('test');
  	  	A.one('#<portlet:namespace />statementDescription').val('test');
	},'#<portlet:namespace />test_card');


	A.on('click', function(event) {
		this.setAttribute('disabled',true);
	    Stripe.card.createToken($('#<portlet:namespace />checkout-payment-form'), <portlet:namespace />checkoutPayment);		
	},'#<portlet:namespace />checkout-payment');
	
	Liferay.provide(window, '<portlet:namespace />checkoutPayment',
			function(status, response) {
			A.one('#<portlet:namespace />checkout-payment-form-error').text("");
		
			if (response.error) {
				A.one('#<portlet:namespace />checkout-payment').removeAttribute('disabled');
			    A.one('#<portlet:namespace />checkout-payment-form-error').text(response.error.message);
		  	}else{
		    
		  		var form = $('#<portlet:namespace />checkout-payment-form');
				
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
				data['<portlet:namespace />stripeToken']=response.id;

				A.io.request('<%= checkoutPaymentURL %>',{
	                  dataType: 'json',
	                  method: 'POST',
	                  data: data,
	                  on: {
	                	  success: function() {
	                		  var responseData = this.get('responseData');
	                		  form.fadeOut(200, function(){
	                			  $('#<portlet:namespace />checkout-wrapper').empty();
									$('#<portlet:namespace />checkout-wrapper').append(responseData);
								});
// 	                		  	A.one('#<portlet:namespace />test_stripe_payment').removeAttribute('disabled');
// 		  	                  	var responseData = this.get('responseData');
// 								if(responseData.success){
// 									A.one('#<portlet:namespace />test_stripe_form_success').text(responseData.successMessage);
// 								}
// 								else{
// 									A.one('#<portlet:namespace />test_stripe_form_error').text(responseData.errorMessage);
// 								}
	  	                  }
	                  }
	            });
			}
		  	
	    },['aui-base,selector-css3']);
</aui:script>
<script type="text/javascript">
  // This identifies your website in the createToken call below
	Stripe.setPublishableKey('<%= shoppingStore.getStripeTesting()?shoppingStore.getStripeTestPublishableKey():shoppingStore.getStripeLivePublishableKey() %>');
  // ...
</script>