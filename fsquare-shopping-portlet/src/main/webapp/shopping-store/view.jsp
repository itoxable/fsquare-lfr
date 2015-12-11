<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>


<%@page import="com.liferay.portal.kernel.editor.EditorUtil"%>
<%@page import="com.fsquare.shopping.ShoppingUtil"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.fsquare.shopping.model.ShoppingCoupon"%>
<%@page import="com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.fsquare.shopping.NoSuchShoppingStoreException"%>
<%@ include file="init.jsp" %>

<%

List<Country> countries = CountryServiceUtil.getCountries();


String onAddToCart = shoppingStore.getOnAddToCart();
String checkoutPageUuid = shoppingStore.getCheckoutPageUuid();
String cartPageUuid = shoppingStore.getCartPageUuid();
String productsMainPageUuid = shoppingStore.getProductsMainPageUuid();

String currency = shoppingStore.getCurrency();
String name = shoppingStore.getName();


String stripeLiveSecretKey = shoppingStore.getStripeLiveSecretKey();
String stripeLivePublishableKey = shoppingStore.getStripeLivePublishableKey();
String stripeTestSecretKey = shoppingStore.getStripeTestSecretKey();
String stripeTestPublishableKey = shoppingStore.getStripeTestPublishableKey();
String stripeApiVersion = shoppingStore.getStripeApiVersion();
String usersType = shoppingStore.getUserTypes();

String orderCreatedEmailTemplate = shoppingStore.getOrderCreatedEmailTemplate();
String orderShippedEmailTemplate = shoppingStore.getOrderShippedEmailTemplate();
String orderCreatedEmailSubject = shoppingStore.getOrderCreatedEmailSubject();
String orderCreatedEmailFromAddress = shoppingStore.getOrderCreatedEmailFromAddress();

boolean checkoutPageFullscreen = shoppingStore.getCheckoutPageFullscreen();
String checkoutCompletePageTemplate = shoppingStore.getCheckoutCompletePageTemplate();

boolean stripeTesting = shoppingStore.getStripeTesting();
boolean integrateWithStripe = shoppingStore.getIntegrateWithStripe();

boolean integrateWithBraintree = shoppingStore.getIntegrateWithBraintree();
String braintreePublicKey = shoppingStore.getBraintreePublicKey();
String braintreePrivateKey = shoppingStore.getBraintreePrivateKey();
String braintreeMerchantId = shoppingStore.getBraintreeMerchantId(); 

String defaultEmailAddress = shoppingStore.getDefaultEmailAddress();

boolean useBraintreeSandbox = shoppingStore.isUseBraintreeSandbox();
String braintreeSandboxPublicKey = shoppingStore.getBraintreeSandboxPublicKey();
String braintreeSandboxPrivateKey = shoppingStore.getBraintreeSandboxPrivateKey();
String braintreeSandboxMerchantId = shoppingStore.getBraintreeSandboxMerchantId(); 

List<KeyValuePair> layoutsKeyValuePair = new ArrayList<KeyValuePair>();
try {
	List<Layout> layoutsTemp = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);
	for(Layout lay : layoutsTemp){
		layoutsKeyValuePair.add(new KeyValuePair(lay.getUuid(), getLayoutBreadcrumb(lay, locale)));
	}
} catch (SystemException e) {
	e.printStackTrace();
} catch (Exception e) {
	e.printStackTrace();
}


if(integrateWithStripe){
%>				
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<%
}
if(integrateWithBraintree){
%>	
<script src="https://js.braintreegateway.com/v2/braintree.js"></script>

<%
}
%>

<liferay-portlet:resourceURL var="saveStoreResourceURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_STORE %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openTestStripeFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_TEST_STRIPE_FORM %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openTestBraintreePaypalFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_TEST_BRAINTREE_PAYPAL %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="sendTestEmailURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SEND_TEST_EMAIL %>" />
</liferay-portlet:resourceURL>

<liferay-portlet:actionURL var="saveStoreURL" />

<aui:form action="<%= saveStoreURL %>" method="post" name="store_settings_form" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveSettings();" %>'>
	<div class="store-settings">
		
		<aui:input inlineLabel="left"  type="text" value="<%= name %>" name="name" />

		<aui:input inlineLabel="left"  type="text" value="<%= defaultEmailAddress %>" name="defaultEmailAddress" />

		<aui:select inlineLabel="left" name="storeCountry" label="country" >
			<% for(Country country: countries) {%>
				<aui:option selected="<%= country.getA2().equalsIgnoreCase(shoppingStore.getCountry()) %>" value="<%= country.getA2() %>" label="<%= country.getName(locale) %>"></aui:option>
			<% } %>
		</aui:select>


		<aui:select inlineLabel="left" name="productsMainPage">
			<aui:option value='' >Select...</aui:option>
			<%
			for (KeyValuePair keyValuePair : layoutsKeyValuePair) {
			%>
				<aui:option selected='<%= keyValuePair.getKey().equals(productsMainPageUuid) %>' value='<%= keyValuePair.getKey()%>' >
					<%= keyValuePair.getValue() %>
				</aui:option>
			<%
			}
			%>
		</aui:select>


	
		<aui:select inlineLabel="left" name="cartDisplayPage">
			<aui:option value='' >Select...</aui:option>
			<%
			for (KeyValuePair keyValuePair : layoutsKeyValuePair) {
			%>
				<aui:option selected='<%= keyValuePair.getKey().equals(cartPageUuid) %>' value='<%= keyValuePair.getKey()%>' >
					<%= keyValuePair.getValue() %>
				</aui:option>
			<%
			}
			%>
		</aui:select>

		<aui:select inlineLabel="left" name="checkoutDisplayPage" >
			<aui:option value='' >Select...</aui:option>
			<%
			for (KeyValuePair keyValuePair : layoutsKeyValuePair) {
			%>
				<aui:option selected='<%= keyValuePair.getKey().equals(checkoutPageUuid) %>' value='<%= keyValuePair.getKey()%>' >
					<%= keyValuePair.getValue() %>
				</aui:option>
			<%
			}
			%>
		</aui:select>
		
		<aui:input type="checkbox" value="<%= checkoutPageFullscreen %>" name="checkoutPageFullscreen" />
		
		<div class="settings-section-wrapper">
			<a class="settings-section-title" href="javascrip:;">
				<span class="icon-caret-right"></span>
				<span><%= LanguageUtil.get(locale, "checkout-complete-page-template") %></span>
			</a>
			<div class="settings-section hide">
				<div class="checkout-page-template">
			    	<div class="checkout-page-template-editor-wrapper">
				    	<div id="<portlet:namespace />checkout-complete-page-template"><%= checkoutCompletePageTemplate %></div>
			    	</div>
			    	<aui:input name="checkoutCompletePageTemplate" type="hidden" value="<%= checkoutCompletePageTemplate %>" />			    	
			    </div>
			</div>	
		</div>
		
		<aui:select inlineLabel="left" name="onAddToCart" >
			<aui:option value='' >Select...</aui:option>
			<aui:option selected='<%= ShoppingUtil.ON_ADD_TO_CART_JUMP_TO_CART.equals(onAddToCart) %>' value='<%= ShoppingUtil.ON_ADD_TO_CART_JUMP_TO_CART %>' >
				<%= ShoppingUtil.ON_ADD_TO_CART_JUMP_TO_CART %>
			</aui:option>
		</aui:select>
	
		<aui:select inlineLabel="left" name="currency" >
			<aui:option  value='' >Select...</aui:option>
			<aui:option selected='<%= "GBP".equals(currency) %>' value='GBP' label="GBP"></aui:option>
			<aui:option selected='<%= "USD".equals(currency) %>' value='USD' label="USD"></aui:option>
			<aui:option selected='<%= "EUR".equals(currency) %>' value='EUR' label="EUR"></aui:option>						
		</aui:select>
	
		<aui:select inlineLabel="left"  name="usersType" >
			<aui:option selected='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY.equals(usersType) %>' value='<%= ShoppingUtil.USER_TYPES_ALL %>' label="<%= ShoppingUtil.USER_TYPES_ALL %>" />
			<aui:option selected='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY.equals(usersType) %>' value='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>' label="<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>" />
			<aui:option selected='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY.equals(usersType) %>' value='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>' label="<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>" />			
		</aui:select>
		
		<div class="settings-section-wrapper">
			<a class="settings-section-title" href="javascrip:;">
				<span class="icon-caret-right"></span>
				<span><%= LanguageUtil.get(locale, "order-created-email-settings") %></span>
			</a>
			<div class="settings-section hide">
				<div class="email-settings">
			    	<aui:input inlineLabel="left" type="email" value="<%= orderCreatedEmailFromAddress %>" name="orderCreatedEmailFromAddress" />
			    	<aui:input inlineLabel="left" type="text" value="<%= orderCreatedEmailSubject %>" name="orderCreatedEmailSubject" />
			    	<div class="email-editor-wrapper">
				    	<div id="<portlet:namespace />order_success_email_editor"><%= orderCreatedEmailTemplate %></div>
			    	</div>
			    	<aui:input name="orderCreatedEmailTemplate" type="hidden" value="<%= orderCreatedEmailTemplate %>" />
			    	<button type="button" class="btn send-test-email" >Test Email</button>
			    	
			    </div>
			</div>	
		</div>
		
		<div class="settings-section-wrapper">
			<aui:input type="checkbox" value="<%= integrateWithStripe %>" name="integrateWithStripe" />
			<a class="settings-section-title" href="javascrip:;">
				<span class="icon-caret-right"></span>
				<span><%= LanguageUtil.get(locale, "stripe-payment-method") %></span>
			</a>
			
			<div class="settings-section hide">
				<aui:input inlineLabel="left" type="text" value="<%= stripeApiVersion %>" name="stripeApiVersion" />
				<aui:input inlineLabel="left" type="text" value="<%= stripeLiveSecretKey %>" name="stripeLiveSecretKey" />
				<aui:input inlineLabel="left" type="text" value="<%= stripeLivePublishableKey %>" name="stripeLivePublishableKey" />
				
				<aui:input inlineLabel="left" type="checkbox" value="<%= stripeTesting %>" name="stripeTesting" ></aui:input>
				<div class="settings-sub-section">
					<aui:input inlineLabel="left" type="text" value="<%= stripeTestSecretKey %>" name="stripeTestSecretKey" />
					<aui:input inlineLabel="left" type="text" value="<%= stripeTestPublishableKey %>" name="stripeTestPublishableKey" />
				</div>
				<div style="margin-top: 10px">
					<button type="button" id="<portlet:namespace />test-payment-btn" class="btn test-payment-btn" >Test Payment</button>
				</div>
			</div>	
		</div>
		
		<div class="settings-section-wrapper">
			<aui:input type="checkbox" value="<%= integrateWithBraintree %>" name="integrateWithBraintree" />
			<a class="settings-section-title" href="javascrip:;">
				<span class="icon-caret-right"></span>
				<span><%= LanguageUtil.get(locale, "braintree-paypal-method") %></span>
			</a>
			<div class="settings-section hide">
				<div class="settings-section">
					<aui:input inlineLabel="left"  type="text" value="<%= braintreeMerchantId %>" name="braintreeMerchantId" />
					<aui:input inlineLabel="left" type="text" value="<%= braintreePublicKey %>" name="braintreePublicKey" />
					<aui:input inlineLabel="left"  type="text" value="<%= braintreePrivateKey %>" name="braintreePrivateKey" />
					
					<aui:input type="checkbox" value="<%= useBraintreeSandbox %>" name="useBraintreeSandbox" />
					<div class="settings-sub-section">
						<aui:input inlineLabel="left"  type="text" value="<%= braintreeSandboxMerchantId %>" name="braintreeSandboxMerchantId" />
						<aui:input inlineLabel="left"  type="text" value="<%= braintreeSandboxPublicKey %>" name="braintreeSandboxPublicKey" />
						<aui:input inlineLabel="left"  type="text" value="<%= braintreeSandboxPrivateKey %>" name="braintreeSandboxPrivateKey" />
					</div>
					<div style="margin-top: 10px">
						<button type="button" id="<portlet:namespace />test-paypal-payment-btn" class="btn test-paypal-payment-btn" >Test Payment</button>
					</div>
				</div>
			</div>	
		</div>
		
		<div id="<portlet:namespace />store_form_error" class="error-message store-form-error">
		</div>
		<div id="<portlet:namespace />store_form_success" class="error-message store-form-success">
		</div>
		
		<div style="margin-top: 20px">
			<button type="button" id="<portlet:namespace />save_store_btn" class="btn save-store-btn" >Save</button>
		</div>
	</div>
</aui:form>

<aui:script use="aui-base,selector-css3,aui-io-request,aui-datatype,aui-datepicker,liferay-dynamic-select,">

	A.on('click', function(event) {
		var section = this.get('parentNode').one('.settings-section');
		section.toggleClass('hide');
	},'.settings-section-title');


	Liferay.provide(window, '<portlet:namespace />showLoading',
		function(wrapper) {
		if(!wrapper){
			wrapper = '#p_p_id<portlet:namespace />';
		}
		$(wrapper).append('<div class="store-loading"><div class="spinner"><div class="rect1"></div><div class="rect2"></div><div class="rect3"></div><div class="rect4"></div><div class="rect5"></div></div></div>')	
	},['aui-base,selector-css3']);
	
	Liferay.provide(window, '<portlet:namespace />hideLoading',
		function(wrapper) {
		if(!wrapper){
			wrapper = '#p_p_id<portlet:namespace />'
		}
		$(wrapper).find(".store-loading").remove()
	},['aui-base,selector-css3']);


	A.on('click', function(event) {
		<portlet:namespace />sendTestEmail();
	},'.send-test-email');
	Liferay.provide(window, '<portlet:namespace />sendTestEmail',
			function() {
				
				A.io.request('<%= sendTestEmailURL %>',{
	                  dataType: 'json',
	                  method: 'POST',
	                  data: { 
	                  },
	                  on: {
	                	  success: function() {
	  	                  	var response = this.get('responseData');
	  	                  if(response.success){
	                  			A.one('#<portlet:namespace />store_form_success').text("Message sent");
	                  		}
	                  		else{
	                  			A.one('#<portlet:namespace />store_form_error').text("Error sending message");
	  	                  	}
	  	                  }
	                  }
	            });
	        },
	    	['aui-base,selector-css3']);
	


	A.on('click', function(event) {
		<portlet:namespace />showLoading();
		<portlet:namespace />saveStore();
	},'#<portlet:namespace />save_store_btn');

	Liferay.provide(window, '<portlet:namespace />saveStore',
		function() {
			
			var form = $('#<portlet:namespace />store_settings_form');
			
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
			
			A.io.request('<%= saveStoreResourceURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: data,
                  on: {
                      success: function() {
                    	<portlet:namespace />hideLoading();
                      	var response = this.get('responseData');
                      	A.one('#<portlet:namespace />store_form_success').text("");
                      	A.one('#<portlet:namespace />store_form_error').text("");
                  		if(response.success){
                  			A.one('#<portlet:namespace />store_form_success').text(response.successMessage);
                  		}
                  		else{
                  			A.one('#<portlet:namespace />store_form_error').text(response.errorMessage);
  	                  	}
                      }
                  }
            });
        },
    	['aui-base,selector-css3']);

	A.on('click', function(event) {
		<portlet:namespace />openTestStripe();
	},'#<portlet:namespace />test-payment-btn');
	
	Liferay.provide(window, '<portlet:namespace />openTestStripe',
			function() {
				
				A.io.request('<%= openTestStripeFormURL %>',{
	                  dataType: 'json',
	                  method: 'POST',
	                  data: { 
	                  },
	                  on: {
	                	  success: function() {
	  	                  	var response = this.get('responseData');
							$('.shopping-store-settings').append(response);
	  	                  }
	                  }
	            });
	        },
	    	['aui-base,selector-css3']);
	
	A.on('click', function(event) {
		<portlet:namespace />openTestBraintreePaypalForm();
	},'#<portlet:namespace />test-paypal-payment-btn');
	
	Liferay.provide(window, '<portlet:namespace />openTestBraintreePaypalForm',
			function() {
				
				A.io.request('<%= openTestBraintreePaypalFormURL %>',{
	                  dataType: 'json',
	                  method: 'POST',
	                  data: { 
	                  },
	                  on: {
	                	  success: function() {
	  	                  	var response = this.get('responseData');
							$('.shopping-store-settings').append(response);
	  	                  }
	                  }
	            });
	        },
	    	['aui-base,selector-css3']);
</aui:script>

<aui:script use="aui-ace-autocomplete-freemarker,aui-ace-autocomplete-plugin,aui-ace-autocomplete-velocity,aui-toggler,aui-popover,resize,transition,aui-io-request">

	Liferay.provide(window, '<portlet:namespace />openEditor',
		function() {
		
	},['aui-base,selector-css3']);

	var richOderSuccessEmailEditor;
	var orderSuccessEmailEditor = A.one('#<portlet:namespace />order_success_email_editor');
	var orderCreatedEmailTemplate = A.one('#<portlet:namespace />orderCreatedEmailTemplate');

	

	var richCheckoutCompletePage;
	var checkoutCompletePageEditor = A.one('#<portlet:namespace />checkout-complete-page-template');
	var checkoutCompletePageTemplate = A.one('#<portlet:namespace />checkoutCompletePageTemplate');
	
	
	A.on('domready', function(event) {
		
		richOderSuccessEmailEditor = new A.AceEditor(
			{
				boundingBox: orderSuccessEmailEditor,
				height: 400,
				mode: '<%= EditorUtil.getEditorMode("xml") %>',
				width: '100%'
			}
		).render();
		richOderSuccessEmailEditor.getEditor().setValue(orderCreatedEmailTemplate.val());
		richOderSuccessEmailEditor.getEditor().on('change', function() {
			orderCreatedEmailTemplate.val(richOderSuccessEmailEditor.getSession().getValue());
        });
		
		
		richCheckoutCompletePage = new A.AceEditor(
			{
				boundingBox: checkoutCompletePageEditor,
				height: 400,
				mode: '<%= EditorUtil.getEditorMode("xml") %>',
				width: '100%'
			}
		).render();
		richCheckoutCompletePage.getEditor().setValue(checkoutCompletePageTemplate.val());
		richCheckoutCompletePage.getEditor().on('change', function() {
			checkoutCompletePageTemplate.val(richCheckoutCompletePage.getSession().getValue());
        });
	});
	
	
	function getEditorContent(editor) {
		var content = editor.getSession().getValue();
		return content;
	}


</aui:script>


<%!

private String getLayoutBreadcrumb(Layout layout, Locale locale) throws Exception {
	StringBundler sb = new StringBundler();

	layout = layout.toEscapedModel();

	if (layout.isPrivateLayout()) {
		sb.append(LanguageUtil.get(locale, "private-pages"));
	}
	else {
		sb.append(LanguageUtil.get(locale, "public-pages"));
	}

	sb.append(StringPool.SPACE);
	sb.append(StringPool.GREATER_THAN);
	sb.append(StringPool.SPACE);

	List<Layout> ancestors = layout.getAncestors();

	Collections.reverse(ancestors);

	for (Layout ancestor : ancestors) {
		ancestor = ancestor.toEscapedModel();

		sb.append(ancestor.getName(locale));
		sb.append(StringPool.SPACE);
		sb.append(StringPool.GREATER_THAN);
		sb.append(StringPool.SPACE);
	}

	sb.append(layout.getName(locale));

	return sb.toString();
}
%>