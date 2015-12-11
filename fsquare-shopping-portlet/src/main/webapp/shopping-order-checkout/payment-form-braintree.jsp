<%@page import="com.fsquare.shopping.portlet.BraintreePayment"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

Calendar cal = Calendar.getInstance();
int thisYear = cal.get(Calendar.YEAR);

%>

<liferay-portlet:resourceURL var="checkoutPaymentURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_CHECKOUT_PAYMENT %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="getOrderTotalURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_GET_ORDER_TOTAL %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="getBraintreeClientTokenURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_GET_BRAINTREE_CLIENT_TOKEN %>" />
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="testBraintreePaypalURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_TEST_BRAINTREE_PAYPAL %>" />
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="braintreeTransactionURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_BRAINTREE_TRANSACTION %>" />
</liferay-portlet:resourceURL>

		
<aui:form id='checkout-payment-form'  name="checkout-payment-form">

	<div class="payment-test-fields-wrap" >
		<h4 class="checkout-panel-subtitle"><%= LanguageUtil.get(locale, "billing-address") %></h4>
		<aui:input inlineLabel="left" name="billingCardHolderName" type="text" data-braintree-name="name" placeholder="Card Holder Name"/>
		<aui:input inlineLabel="left" name="billingStreet" type="text" data-stripe="address_line1" placeholder="Street"/>
		<aui:input inlineLabel="left" name="billingStreet2" type="text" data-stripe="address_line2" placeholder="Street (line 2)"/>
		<aui:input inlineLabel="left" name="billingCity" type="text" data-stripe="address_city" placeholder=""/>
		<aui:input inlineLabel="left" name="billingPostCode" type="text" data-stripe="address_zip" placeholder=""/>
		<aui:input inlineLabel="left" name="billingStateProvince" type="text" value="" placeholder=""/>
		<aui:select inlineLabel="left" name="billingCountry" label="country" data-stripe="address_country">
			<% for(Country country: countries) {%>
				<aui:option selected="<%= country.getA2().equalsIgnoreCase(locale.getCountry()) %>" value="<%= country.getA2() %>" label="<%= country.getName(locale) %>"></aui:option>
			<% } %>
		</aui:select>
		<aui:input inlineLabel="left" name="billingEmailReceipe" type="email" value="" placeholder=""/>
	</div>


	<div class="payment-methods-wrap" >	
	
		<h4 class="checkout-panel-subtitle"><%= LanguageUtil.get(locale, "payment-method") %></h4>
		
		<ul class="accepted-cards-list">
			<li>
				<img alt="paypal" src='<%= resourceResponse.encodeURL(resourceRequest.getContextPath() + "/images/payment-methods/paypal.png") %>'>
			</li>
			<li>
				<img alt="discover" src='<%=resourceResponse.encodeURL(resourceRequest.getContextPath() + "/images/payment-methods/discover.png") %>'>
			</li>
			<li>
				<img alt="maestro" src='<%=resourceResponse.encodeURL(resourceRequest.getContextPath() + "/images/payment-methods/maestro.png") %>'>
			</li>
			<li>
				<img alt="mastercard" src='<%=resourceResponse.encodeURL(resourceRequest.getContextPath() + "/images/payment-methods/mastercard.png") %>'>
			</li>
			<li>
				<img alt="uk_maestro" src='<%=resourceResponse.encodeURL(resourceRequest.getContextPath() + "/images/payment-methods/uk_maestro.png") %>'>
			</li>
			<li>
				<img alt="visa" src='<%=resourceResponse.encodeURL(resourceRequest.getContextPath() + "/images/payment-methods/visa.png") %>'>
			</li>
		</ul>
		<div class="clearfix"></div>
		
		<div class="payment-method-select">
			<aui:input inlineField="<%=true %>" checked="<%=true %>" name="payment_method" value="<%= BraintreePayment.PAYMENT_METHOD_PAYPAL %>" type="radio" label='paypal'></aui:input>
			<aui:input inlineField="<%=true %>" name="payment_method" value="<%= BraintreePayment.PAYMENT_METHOD_CREDIT_CARD %>" type="radio" label='credit-card'></aui:input>
		</div>
		
		<div class="payment-method-credit-card hide">
		
		 	<c:if test="<%= shoppingStore.isUseBraintreeSandbox() %>">
				<aui:select inlineLabel="left" name="test_card" >
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
			</c:if>
	 		
	 		<div class="control-group form-inline">
				<label class="control-label" for="<portlet:namespace/>cardNumber">
					<%=LanguageUtil.get(locale, "card-number") %> 
				</label>
	 			<input type="text" placeholder='<%=LanguageUtil.get(locale, "card-number") %>' id="<portlet:namespace/>cardNumber" data-braintree-name="number"/>
			</div>
	 		
			<div class="control-group form-inline">
				<label class="control-label" for="<portlet:namespace/>expMonth">
					<%=LanguageUtil.get(locale, "exp-month") %>
				</label>
				<select id="<portlet:namespace/>expMonth" data-braintree-name="expiration_month">
					<% for(int i = 1; i < 13; i++) {%>
					<option selected="<%= i == cal.get(Calendar.MONTH) %>" value="<%= i+1 %>"><%= i+1 %></option>
					<% } %>
				</select>
			</div>
			
			<div class="control-group form-inline">
				<label class="control-label" for="<portlet:namespace/>expYear">
					<%=LanguageUtil.get(locale, "exp-year") %>
				</label>
				<select data-braintree-name="expiration_year" id="<portlet:namespace/>expYear">
					<% for(int i = thisYear; i < (thisYear+20); i++) {%>
					<option value="<%=i%>"><%=i%></option>
					<% } %>
				</select>
			</div>
			
			<div class="control-group form-inline">
				<label class="control-label" for="<portlet:namespace/>cvc">
					<%=LanguageUtil.get(locale, "cvc") %>
				</label>
				<input type="text" value=""  id="<portlet:namespace/>cvc" placeholder="CVC" data-braintree-name="cvv"/>
			</div>	
		
			<div id="<portlet:namespace />checkout-payment-credit-card-error" class="error-message checkout-payment-form-error">
			</div>
			
			<button class="btn btn-primary checkout-button" type="button" id="<portlet:namespace/>braintree_credit_card_pay"><%=LanguageUtil.get(locale, "pay-with-credit-card") %></button>
	
		</div>
		
		<div class="payment-method-paypal">
			<div id="paypal-container">
			</div>
			
			<div id="<portlet:namespace />checkout-payment-paypal-error" class="error-message checkout-payment-form-error">
			</div>
			<button class="btn btn-primary checkout-button" type="button" id="<portlet:namespace/>braintree_paypal_pay"><%=LanguageUtil.get(locale, "pay-with-paypal") %></button>
		</div>
		
		<div style="clear: both;"></div>
	</div>
</aui:form>

		
	
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker,liferay-dynamic-select">


	A.on('change', function(event) {
		if(this.val() == '<%= BraintreePayment.PAYMENT_METHOD_PAYPAL %>'){
			A.one('.payment-method-paypal').removeClass('hide');
			if(!A.one('.payment-method-credit-card').hasClass('hide')){
				A.one('.payment-method-credit-card').addClass('hide');
			}
		}else{
			A.one('.payment-method-credit-card').removeClass('hide');
			if(!A.one('.payment-method-paypal').hasClass('hide')){
				A.one('.payment-method-paypal').addClass('hide');
			}
		}
	},'input[name^=<portlet:namespace />payment_method]');
	
	A.on('change', function(event) {
		A.one('#<portlet:namespace />cardNumber').val(this.val());
  	  	A.one('#<portlet:namespace />cvc').val('123');
	},'#<portlet:namespace />test_card');

	Liferay.provide(window, '<portlet:namespace />getOrderCheckout',
		function(step, wrapper) {
		
			A.io.request('<%= getOrderTotalURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: {},
                  on: {
                	  success: function() {
	  	                  	var responseData = this.get('responseData');
							if(responseData.success){
								Stripe.card.createToken($('#<portlet:namespace />checkout-payment-form'), <portlet:namespace />checkoutPayment);
							}
							else{
								A.one('#<portlet:namespace />checkout-payment-form-error').text(responseData.errorMessage);
							}
  	                  }
                  }
            });
    },['aui-base,selector-css3']);
	

	A.on('click', function(event) {
		<portlet:namespace />showLoading(undefined, '<%= LanguageUtil.get(locale, "dont-reload-page") %>');
		<portlet:namespace />getBraintreeClientToken(function(response){
			braintree.setup(response.braintreeClientToken, "custom", {
			  	paypal: {
				    container: "paypal-container",
				    singleUse: true,
				    amount: response.amount,
				    currency: '<%= shoppingStore.getCurrency() %>',
				    locale: '<%= themeDisplay.getLocale().toString() %>',
				    enableShippingAddress: false,
				    headless: true
			  	},
			  	onReady: function (integration) {
			  		integration.paypal.initAuthFlow();
				},
			  	onPaymentMethodReceived: function (obj) {
				    console.log("-- onPaymentMethodReceived --");
				    <portlet:namespace />braintreeTransaction(obj.nonce, function(result){
				    	<portlet:namespace />hideLoading();
				    	if(result.hasOwnProperty('braintreeResult')){
							var braintreeResultJson = JSON.parse(result.braintreeResult);
	        		  		//debug(braintreeResultJson);
	        		  		var errorMessage = '<%= LanguageUtil.get(locale, "unknown-payment-error") %>';
	        		  		if(braintreeResultJson.hasOwnProperty('errors')){
	        		  			errorMessage = braintreeResultJson.message;
	        		  		}
							A.one('#<portlet:namespace />checkout-payment-paypal-error').text(errorMessage);
							
						}else{
				    		$('#<portlet:namespace />checkout-wrapper').empty();
							$('#<portlet:namespace />checkout-wrapper').append(result);
						}
				    });
				    console.log('--- onPaymentMethodReceived ---');
			  	},
			  	onUnsupported: function () {
				    debug(arguments);
				    console.log('--- onUnsupported ---');
			  	},
			  	onCancelled: function () {
					debug(arguments);
				    console.log('--- onCancelled ---');
			  	}
			});
		});
	},'#<portlet:namespace />braintree_paypal_pay');
	
	
	A.on('click', function(event) {
		<portlet:namespace />showLoading(undefined, '<%= LanguageUtil.get(locale, "dont-reload-page") %>');
		<portlet:namespace />getBraintreeClientToken(function(response){
			
			//console.log('braintreeClientToken: '+response.braintreeClientToken);
			
			var client = new braintree.api.Client({clientToken: response.braintreeClientToken});
			client.tokenizeCard({
			  number: $("#<portlet:namespace/>cardNumber").val(),  
			  cardholderName: $("#<portlet:namespace/>").val(),
			  expirationMonth: $("#<portlet:namespace/>expMonth").val(),
			  expirationYear: $("#<portlet:namespace/>expYear").val(),
			  cvv: $("#<portlet:namespace/>cvc").val(),
			  billingAddress: {
			    postalCode: $("#<portlet:namespace/>").val()
			  }
			}, function (err, nonce) {
				<portlet:namespace />braintreeTransaction(nonce, function(result){
					<portlet:namespace />hideLoading();
					
			    	if(result.hasOwnProperty('braintreeResult')){
        		  		var braintreeResultJson = JSON.parse(result.braintreeResult);
        		  		//debug(braintreeResultJson);
        		  		var errorMessage = '<%= LanguageUtil.get(locale, "unknown-payment-error") %>';
        		  		if(braintreeResultJson.hasOwnProperty('errors')){
        		  			errorMessage = braintreeResultJson.message;
        		  		}
						A.one('#<portlet:namespace />checkout-payment-credit-card-error').text(errorMessage);
					}else{
			    		$('#<portlet:namespace />checkout-wrapper').empty();
						$('#<portlet:namespace />checkout-wrapper').append(result);
					}
					
			    });
			});
		});
	},'#<portlet:namespace />braintree_credit_card_pay');
	
	
	Liferay.provide(window, '<portlet:namespace />getBraintreeClientToken',
			function(callback) {
			A.io.request('<%= getBraintreeClientTokenURL %>',{
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
	
	Liferay.provide(window, '<portlet:namespace />braintreeTransaction',
			function(nonce, callback) {
		    
			A.io.request('<%= braintreeTransactionURL %>',{
		        dataType: 'json',
		        method: 'POST',
		        data: {
		        	<portlet:namespace />nonce: nonce
		        },
		        on: {
					success: function() {
						var responseData = this.get('responseData');
						callback(responseData);
					}
		        }
	        });
			
	    },['aui-base,selector-css3']);
	
	
</aui:script>
