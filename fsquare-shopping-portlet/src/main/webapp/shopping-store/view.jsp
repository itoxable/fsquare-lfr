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
<%@ include file="/shopping-store/init.jsp" %>

<%

List<Country> countries = CountryServiceUtil.getCountries();


String onAddToCart = shoppingStore.getOnAddToCart();
String checkoutPageUuid = shoppingStore.getCheckoutPageUuid();
String cartPageUuid = shoppingStore.getCartPageUuid();
String currency = shoppingStore.getCurrency();


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



boolean stripeTesting = shoppingStore.getStripeTesting();
boolean integrateWithStripe = shoppingStore.getIntegrateWithStripe();


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


if(shoppingStore.getIntegrateWithStripe()){
%>				
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<%
}
%>

<liferay-portlet:resourceURL var="saveStoreResourceURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_SAVE_STORE %>" />
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="openTestStripeFormURL" secure="false">
	<portlet:param name="<%= Constants.CMD %>" value="<%=ShoppingPortletUtil.CMD_OPEN_TEST_STRIPE_FORM %>" />
</liferay-portlet:resourceURL>

<liferay-portlet:actionURL var="saveStoreURL" />

<aui:form action="<%= saveStoreURL %>" method="post" name="store_settings_form" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveSettings();" %>'>
	<div class="store-settings">
		
		<aui:field-wrapper label='country' >
			<fieldset >
				<div class="form-inline priority-set-wrapper">
					<aui:select name="storeCountry" label="country" >
						<% for(Country country: countries) {%>
							<aui:option selected="<%= country.getA2().equalsIgnoreCase(shoppingStore.getCountry()) %>" value="<%= country.getA2() %>" label="<%= country.getName(locale) %>"></aui:option>
						<% } %>
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		<aui:field-wrapper label='cart-display-page' >
			<fieldset >
				<div class="form-inline priority-set-wrapper">
					<aui:select label="" name="cartDisplayPage" >
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
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		<aui:field-wrapper label='checkout-display-page' >
			<fieldset >
				<div>
					<aui:select label="" name="checkoutDisplayPage" >
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
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		<aui:field-wrapper label='on-add-to-cart' >
			<fieldset >
				<div>
					<aui:select label="" name="onAddToCart" >
						<aui:option value='' >Select...</aui:option>
						
							<aui:option selected='<%= ShoppingPortletUtil.ON_ADD_TO_CART_JUMP_TO_CART.equals(onAddToCart) %>' value='<%= ShoppingPortletUtil.ON_ADD_TO_CART_JUMP_TO_CART %>' >
								<%= ShoppingPortletUtil.ON_ADD_TO_CART_JUMP_TO_CART %>
							</aui:option>
						
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		<aui:field-wrapper label='currency' >
			<fieldset >
				<div>
					<aui:select label="" name="currency" >
						<aui:option value='' >Select...</aui:option>
							<aui:option selected='<%= "GBP".equals(currency) %>' value='GBP' label="GBP"></aui:option>
							<aui:option selected='<%= "USD".equals(currency) %>' value='USD' label="USD"></aui:option>
							<aui:option selected='<%= "EUR".equals(currency) %>' value='EUR' label="EUR"></aui:option>						
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
		<aui:field-wrapper label='Type of users' >
			<fieldset >
				<div class="form-inline priority-set-wrapper">
					<aui:select label="" name="usersType" >
						
						<aui:option selected='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY.equals(usersType) %>' value='<%= ShoppingUtil.USER_TYPES_ALL %>' label="<%= ShoppingUtil.USER_TYPES_ALL %>" >
						</aui:option>
						<aui:option selected='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY.equals(usersType) %>' value='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>' label="<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>" >
						</aui:option>
						<aui:option selected='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY.equals(usersType) %>' value='<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>' label="<%= ShoppingUtil.USER_TYPES_GUEST_ONLY %>" >
						</aui:option>
						
					</aui:select>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
<%-- 		<aui:field-wrapper label='XXX' > --%>
<!-- 			<fieldset > -->
<!-- 				<div class="XXX"> -->
<%-- 					<label for="<portlet:namespace />order_success_email_editor">Email Template</label> --%>
<%-- 			    	<div id="<portlet:namespace />order_success_email_editor"><%= orderCreatedMailTemplate %></div> --%>
<%-- 			    	<aui:input name="orderCreatedMailTemplate" type="hidden" value="<%= orderCreatedMailTemplate %>" /> --%>
			    	
<!-- 			    </div> -->
<!-- 			</fieldset>	 -->
<%-- 		</aui:field-wrapper> --%>
		
		<aui:field-wrapper label='stype-payment-method' >
			<fieldset >
				
				<aui:input type="checkbox" value="<%= integrateWithStripe %>" name="integrateWithStripe" />
				<aui:input type="text" value="<%= stripeTestSecretKey %>" name="stripeTestSecretKey" />
				<aui:input type="text" value="<%= stripeTestPublishableKey %>" name="stripeTestPublishableKey" />
				<aui:input type="text" value="<%= stripeLiveSecretKey %>" name="stripeLiveSecretKey" />
				<aui:input type="text" value="<%= stripeLivePublishableKey %>" name="stripeLivePublishableKey" />
				<aui:input type="text" value="<%= stripeApiVersion %>" name="stripeApiVersion" />
				<aui:input type="checkbox" value="<%= stripeTesting %>" name="stripeTesting" ></aui:input>
				<div style="margin-top: 10px">
					<button type="button" id="<portlet:namespace />test-payment-btn" class="btn test-payment-btn" >Test Payment</button>
				</div>
			</fieldset>	
		</aui:field-wrapper>
		
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
</aui:script>

<aui:script use="aui-ace-autocomplete-freemarker,aui-ace-autocomplete-plugin,aui-ace-autocomplete-velocity,aui-toggler,aui-popover,resize,transition,aui-io-request">

	Liferay.provide(window, '<portlet:namespace />openEditor',
		function() {
		
	},['aui-base,selector-css3']);

	var richrOderSuccessEmailEditor;
	var orderSuccessEmailEditor = A.one('#<portlet:namespace />order_success_email_editor');
	var orderCreatedMailTemplate = A.one('#<portlet:namespace />orderCreatedMailTemplate');
	A.on('domready', function(event) {
		richrOderSuccessEmailEditor = new A.AceEditor(
			{
				boundingBox: orderSuccessEmailEditor,
				height: 400,
				mode: '<%= EditorUtil.getEditorMode("xml") %>',
				width: '100%'
			}
		).render();
		richrOderSuccessEmailEditor.on('change', function() {
     	});
	})
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