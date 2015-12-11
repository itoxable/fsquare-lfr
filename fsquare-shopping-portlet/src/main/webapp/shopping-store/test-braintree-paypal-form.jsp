<%@page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.fsquare.shopping.model.ShoppingOrderItem"%>
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
List<Country> countries = CountryServiceUtil.getCountries();

ShoppingOrderItem shoppingOrderItem = null;
Object shoppingOrderItemObj = request.getAttribute(ShoppingPortletUtil.ATTR_ORDER_ITEM);
if(shoppingOrderItemObj != null){
	shoppingOrderItem = (ShoppingOrderItem)shoppingOrderItemObj;
}

%>

<liferay-portlet:resourceURL var="getBraintreeClientTokenURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_GET_BRAINTREE_CLIENT_TOKEN %>" />
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="testBraintreePaypalURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_TEST_BRAINTREE_PAYPAL %>" />
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="braintreeTransactionURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_BRAINTREE_TRANSACTION %>" />
</liferay-portlet:resourceURL>



<script type="text/javascript">
  
</script>
<div class="modal" id="<portlet:namespace />braintree_paypal_form" style="width: 900px">
	<div class="modal-header">
		<button type="button" class="close" onclick="jQuery('#<portlet:namespace />braintree_paypal_form').remove();">×</button>
		<h3>Payment Test</h3>
	</div>
	<div class="modal-body">
		
			<%
			if(shoppingOrderItem != null){
			%>
			<div style="border: 1px solid #CCC">
				<table class="cart-table">
					<tbody>
						<tr class="table-header">
						    <td></td>
						    <td>PRODUCT</td>
						    <td align="center">QTY</td>
						    <td align="right">PRICE</td>
					  	</tr>
					  	
					  	<%
					  	JournalArticle journalArticle = JournalArticleServiceUtil.getArticle(themeDisplay.getScopeGroupId(), shoppingOrderItem.getArticleId());	
					  	%>
					    <tr class="product-row product-row-<%= shoppingOrderItem.getArticleId() %>">
						    <td>      
						    	<img width="100" src="<%= ShoppingPortletUtil.getMainImageURL(journalArticle) %>" alt="" class="cart-item-img">
						    </td>
						    
						    <td>
						      	<strong><%= journalArticle.getTitle(themeDisplay.getSiteDefaultLocale()) %></strong>
						    </td>
						    
						    <td align="center">
						    	<input value="<%=shoppingOrderItem.getQuantity() %>" id="<portlet:namespace />quantity_<%= shoppingOrderItem.getArticleId() %>" type="number"/>
						    	<a data-article-id='<%= shoppingOrderItem.getArticleId() %>' class="update-quantity">
							    	<span class="fa fa-refresh"></span>
							    	<span>update</span>
						    	</a>
						    	
						    </td>          
					    	<td align="right">
					    		£<span class="cart-item-price" id="<portlet:namespace />cart_item_price_<%= shoppingOrderItem.getArticleId() %>"><%=shoppingOrderItem.getPrice() %></span>
					    	</td>
					  	</tr>
				    					
						
						<tr class="cart-summary-row">
							<td colspan="4" align="right">
								<strong>Total</strong>
							</td>
							<td class="cart-price-cell" align="right">
								<strong><%= shoppingStore.getCurrency()%><span id="<portlet:namespace />order-summary-total-price"><%= shoppingOrderItem.getPrice() %></span></strong>
							</td>
						</tr>
				  
				  	</tbody>
				</table>
			</div>

			<div class="clearfix"></div>
			<%
			}
			%>
			<aui:form id='braintree-billing-address-form'  name="braintree-billing-address-form">
			
				<aui:fieldset cssClass="payment-test-fields-wrap" label="billing-address">
					<aui:input name="billingCardHolderName" type="text" placeholder="Card Holder Name"/>
					<aui:input name="billingStreet" type="text"  placeholder="Street"/>
					<aui:input name="billingStreet2" type="text"  placeholder="Street (line 2)"/>
					<aui:input name="billingCity" type="text" placeholder=""/>
					<aui:input id="postcode"  name="billingPostCode" type="text" placeholder=""/>
					<aui:input name="billingStateProvince" type="text" value="" placeholder=""/>
					<aui:select name="billingCountry" label="country">
						<% for(Country country: countries) {%>
							<aui:option selected="<%= country.getA2().equalsIgnoreCase(locale.getCountry()) %>" value="<%= country.getA2() %>" label="<%= country.getName(locale) %>"></aui:option>
						<% } %>
					</aui:select>
					<aui:input name="billingEmailReceipe" type="email" value="" placeholder=""/>
				</aui:fieldset>
			</aui:form>
			<div class="payment-test-fields-wrap">
				<div id="paypal-container-wrapper">
					<div id="paypal-container">
						
					</div>
					<button class="btn btn-primary" type="button" id="<portlet:namespace />braintree_paypal_pay">Pay</button>
				</div>
				<div id="credit-card-form-container">
					<form id='credit-card-form'  name="credit-card-form">
						<div>
							<div>
								<input id="card-holder-name" data-braintree-name="card_holder_name" value="Rui">
							</div>
							<div>
								<input id="card-number" data-braintree-name="number" value="4111111111111111">
							</div>
							<div>
								<select id="card-expiration-month" data-braintree-name="expiration_month">
									<% for(int i = 1; i < 13; i++) {%>
									<option selected="<%= i == cal.get(Calendar.MONTH) %>" value="<%= i %>" label="<%= i %>"></option>
									<% } %>
								</select>
							</div>
							<div>
								<select id="card-expiration-year" data-braintree-name="expiration_year">
									<% for(int i = thisYear; i < (thisYear+20); i++) {%>
									<option value="<%= i %>" label="<%= i %>"></option>
									<% } %>
								</select>
							</div>
							<div>
								<input id="card-cvv" data-braintree-name="cvv" value="100">
							</div>
							<div>
								<button class="btn btn-primary" type="button" id="<portlet:namespace />braintree_credit_card_pay" >Credit Card Pay</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			<div id="<portlet:namespace />braintree_paypal_form_error" class="error-message braintree-paypal-form-error">
			</div>
			<div id="<portlet:namespace />braintree_paypal_form_success" class="error-message braintree-paypal-form-success">
			</div>
			
		
		
	</div>
	<div class="modal-footer">
		<button class="btn" type="button" onclick="jQuery('#<portlet:namespace />braintree_paypal_form').remove();" >Close</button>
	</div>
	
	
</div>
<%
			
			%>
<aui:script use="aui-base,selector-css3,aui-io-request,array-extras,querystring-stringify,aui-datatype,aui-datepicker,liferay-dynamic-select">


	A.on('click', function(event) {
// 		this.setAttribute('disabled',true);
		<portlet:namespace />getBraintreeClientToken(function(response){
			console.log("CLIENT_TOKEN: "+response.braintreeClientToken);
		    
			braintree.setup(response.braintreeClientToken, "custom", {
			  paypal: {
			    container: "paypal-container",
			    singleUse: true,
			    amount: '<%= shoppingOrderItem.getPrice() %>',
			    currency: '<%= shoppingStore.getCurrency() %>',
			    locale: '<%= themeDisplay.getLocale().toString() %>',
			    enableShippingAddress: 'false'
			  },
			  onPaymentMethodReceived: function (obj) {
				console.log("-- onPaymentMethodReceived --");
				debug(obj);
// 			    <portlet:namespace />showLoading('#<portlet:namespace />braintree_paypal_form');
			    <portlet:namespace />braintreeTransaction(obj.nonce, '<%= shoppingStore.getCurrency() %>', '<%= shoppingOrderItem.getPrice() %>', function(result){
			    	if(result.success){
			    		var successDiv = "<div><h2>Paypal Payment Success</h2></div>"
						$('#payment-test-fields-wrap').empty();
						$('#payment-test-fields-wrap').append(successDiv);
					}
					else{
						A.one('#<portlet:namespace />braintree_paypal_form_success').text(result.errorMessage);
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
// 		this.setAttribute('disabled',true);
		<portlet:namespace />getBraintreeClientToken(function(response){
			var client = new braintree.api.Client({clientToken: response.braintreeClientToken});
			client.tokenizeCard({
			  number: $("#card-number").val(),
			  cardholderName: $("#card-holder-name").val(),
			  expirationMonth: $("#card-expiration-month").val(),
			  expirationYear: $("#card-expiration-year").val(),
			  cvv: $("#card-cvv").val(),
			  billingAddress: {
			    postalCode: $("#postcode").val()
			  }
			}, function (err, nonce) {
				<portlet:namespace />braintreeTransaction(nonce, '<%= shoppingOrderItem.getPrice() %>', function(result){
			    	
// 					A.one('#<portlet:namespace />braintree_credit_card_pay').removeAttribute('disabled');
			    	if(result.success){
			    		var successDiv = "<div><h2>Credit Card Payment Success</h2></div>"
						$('#payment-test-fields-wrap').empty();
						$('#payment-test-fields-wrap').append(successDiv);
					}
					else{
						A.one('#<portlet:namespace />braintree_paypal_form_success').text(result.errorMessage);
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
		function(nonce, amount, callback) {
	    
		A.io.request('<%= braintreeTransactionURL %>',{
	        dataType: 'json',
	        method: 'POST',
	        data: {
	        	<portlet:namespace />nonce: nonce,
	        	<portlet:namespace />amount: amount
	        },
	        on: {
				success: function() {
					
					var responseData = this.get('responseData');
					var braintreeResultJson = JSON.parse(responseData.braintreeResult);
					<portlet:namespace />hideLoading('#<portlet:namespace />braintree_paypal_form');
					if(braintreeResultJson.success){
						callback(braintreeResultJson);
						
					}
					debug(braintreeResultJson);
				}
	        }
        });
		
    },['aui-base,selector-css3']);
	
</aui:script>
