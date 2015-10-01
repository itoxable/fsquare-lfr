<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more®
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(renderRequest, "redirect");

String titleXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "title");
String descriptionXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "description");
boolean requireCaptcha = GetterUtil.getBoolean(portletPreferences.getValue("requireCaptcha", StringPool.BLANK));
String successURL = portletPreferences.getValue("successURL", StringPool.BLANK);
//System.out.println("-2successURL: "+successURL);

boolean sendAsEmail = GetterUtil.getBoolean(portletPreferences.getValue("sendAsEmail", StringPool.BLANK));
String emailFromName = WebFormUtil.getEmailFromName(portletPreferences, company.getCompanyId());
String emailFromAddress = WebFormUtil.getEmailFromAddress(portletPreferences, company.getCompanyId());
String emailAddress = portletPreferences.getValue("emailAddress", StringPool.BLANK);
String subject = portletPreferences.getValue("subject", StringPool.BLANK);
String formValidationScript = portletPreferences.getValue("formValidationScript", StringPool.BLANK);
String onFormLoadScript = portletPreferences.getValue("onFormLoadScript", StringPool.BLANK);


boolean saveToDatabase = GetterUtil.getBoolean(portletPreferences.getValue("saveToDatabase", StringPool.BLANK));
String databaseTableName = portletPreferences.getValue("databaseTableName", StringPool.BLANK);

boolean saveToFile = GetterUtil.getBoolean(portletPreferences.getValue("saveToFile", StringPool.BLANK));
String fileName = portletPreferences.getValue("fileName", StringPool.BLANK);

boolean fieldsEditingDisabled = false;

if (WebFormUtil.getTableRowsCount(company.getCompanyId(), databaseTableName) > 0) {
	fieldsEditingDisabled = true;
}
boolean sendAckEmail = GetterUtil.getBoolean(portletPreferences.getValue("sendAck", StringPool.BLANK));
String ackEmailSubject = portletPreferences.getValue("ackEmailSubject", StringPool.BLANK);
String ackEmailText = portletPreferences.getValue("ackEmailText", StringPool.BLANK);

String successMessageXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "successMessage");
String successMessage = LocalizationUtil.getLocalization(successMessageXml, themeDisplay.getLanguageId());

String submitButtonLabelXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "submitButtonLabel");
String submitButtonLabel = LocalizationUtil.getLocalization(submitButtonLabelXml, themeDisplay.getLanguageId());

String saveButtonLabelXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "saveButtonLabelXml");
String saveButtonLabel = LocalizationUtil.getLocalization(saveButtonLabelXml, themeDisplay.getLanguageId());

boolean isWizard = GetterUtil.getBoolean(portletPreferences.getValue("isWizard", StringPool.BLANK));
String wizardNrSteps = portletPreferences.getValue("wizardNrSteps", StringPool.BLANK);
int nrSteps = 1;

if(wizardNrSteps != null && wizardNrSteps!= ""){
	nrSteps = Integer.parseInt(wizardNrSteps);
}

// boolean showSuccessTextOnly = GetterUtil.getBoolean(portletPreferences.getValue("showSuccessTextOnly", StringPool.BLANK));
// boolean showSuccessTextReadonlyFields = GetterUtil.getBoolean(portletPreferences.getValue("showSuccessTextReadonlyFields", StringPool.BLANK));
boolean saveTempEnable = GetterUtil.getBoolean(portletPreferences.getValue("saveTempEnable", StringPool.BLANK));

String saveTempSuccessText = portletPreferences.getValue("saveTempSuccessText", StringPool.BLANK);

String saveButtonStyle = portletPreferences.getValue("saveButtonStyle", StringPool.BLANK);
String saveButtonStyleClass = portletPreferences.getValue("saveButtonStyleClass", StringPool.BLANK);

String postToURL = portletPreferences.getValue("postToURL", StringPool.BLANK);
boolean isPostToURL = GetterUtil.getBoolean(portletPreferences.getValue("isPostToURL", StringPool.BLANK));

%>

<liferay-ui:tabs
	names="form-config,form-data"
	param="tabs2"
	refresh="<%= false %>"
>
		<liferay-ui:section>
		<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
		
		<aui:form action="<%= configurationURL %>" method="post" name="fm">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		
			<liferay-ui:error exception="<%= DuplicateColumnNameException.class %>" message="please-enter-unique-field-names" />
		
			<liferay-ui:panel-container extended="<%= Boolean.TRUE %>" id="webFormConfiguration" persistState="<%= true %>">
				<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="webFormGeneral" persistState="<%= true %>" title="form-information">
					<aui:fieldset>
						<aui:field-wrapper cssClass="lfr-input-text-container" label="title">
							<liferay-ui:input-localized name="title" xml="<%= titleXml %>" />
						</aui:field-wrapper>
		
						<aui:field-wrapper cssClass="lfr-textarea-container" label="description">
							<liferay-ui:input-localized name="description" type="textarea" xml="<%= descriptionXml %>" />
						</aui:field-wrapper>
		
						<aui:input name="preferences--requireCaptcha--" type="checkbox" value="<%= requireCaptcha %>" />
		
						<aui:input cssClass="lfr-input-text-container" label="redirect-url-on-success" name="preferences--successURL--" value="<%= HtmlUtil.toInputSafe(successURL) %>" />
					</aui:fieldset>
					
					<aui:fieldset cssClass="handle-data" label="isWizard">
						<aui:input name="preferences--isWizard--" type="checkbox" value="<%= isWizard %>" />
						<aui:fieldset id="wizard_details" cssClass='<%=isWizard?StringPool.BLANK:"hide" %>'>
							<aui:input cssClass="lfr-input-text-container" label="wizard-steps" name="preferences--wizardNrSteps--" value="<%= wizardNrSteps %>"  />
						</aui:fieldset>
					</aui:fieldset>
					
				</liferay-ui:panel>
		
				<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="webFormData" persistState="<%= true %>" title="handling-of-form-data">
				
					<aui:field-wrapper cssClass="lfr-input-text-container" label="success-message">
						<liferay-ui:input-localized style="width: 600px; height: 200px" type="textarea" name="successMessage" xml="<%= successMessageXml %>" />
						<div class="definition-of-terms">
							<h4>Definition of Terms</h4> 
							<dl> 
								<dt> [$FORM_DATA$] </dt> 
								<dd> All form fields </dd>
								<dt> [$FIELD NAME$] </dt> 
								<dd> Name of a field you want to display (eg.: [$First name$])</dd> 
								<dt> [$BACK_URL$] </dt> 
								<dd> Back URL </dd>
								<dt> [$EDIT_URL$] </dt> 
								<dd> URL to use if record changing is wanted  </dd>
								<dt> [$POST_RESPONSE$] </dt> 
								<dd> Post response. <b>to be used if 'Post to URL' is enable</b></dd> 
							</dl> 
						</div>
					</aui:field-wrapper>
					
					<aui:input name="preferences--saveTempEnable--" type="checkbox" value="<%= saveTempEnable %>" />
					<aui:fieldset id="save-temp-success-details" cssClass='<%=saveTempEnable?StringPool.BLANK:"hide" %>' >
						<aui:input style="width: 600px; height: 200px" cssClass="lfr-textarea-container" name="preferences--saveTempSuccessText--" type="textarea" value="<%= saveTempSuccessText %>" wrap="soft" />
						<div class="definition-of-terms"> 
							<h4>Definition of Terms</h4> 
							<dl> 
								<dt>[$FORM_URL$]</dt> 
								<dd>Form URL</dd>
								<dt> [$BACK_URL$] </dt> 
								<dd> Back URL </dd>
							</dl> 
						</div>
						<aui:field-wrapper cssClass="lfr-input-text-container" label="save-button-label">
							<liferay-ui:input-localized name="saveButtonLabel" xml="<%= saveButtonLabelXml %>" />
						</aui:field-wrapper>
						<aui:input cssClass="lfr-input-text-container" label="save-button-style" name="preferences--saveButtonStyle--" value="<%= HtmlUtil.toInputSafe(saveButtonStyle) %>" />
						<aui:input cssClass="lfr-input-text-container" label="save-button-style-class" name="preferences--saveButtonStyleClass--" value="<%= HtmlUtil.toInputSafe(saveButtonStyleClass) %>" />
					</aui:fieldset>
					
					
					
		<%-- 			<aui:input name="preferences--showSuccessTextOnly--" type="checkbox" value="<%= showSuccessTextOnly %>" /> --%>
					
		<%-- 			<aui:input name="preferences--showSuccessTextReadonlyFields--" type="checkbox" value="<%= showSuccessTextReadonlyFields %>" /> --%>
					
					<aui:field-wrapper cssClass="lfr-input-text-container" label="submit-button-label">
						<liferay-ui:input-localized name="submitButtonLabel" xml="<%= submitButtonLabelXml %>" />
					</aui:field-wrapper>
		
					<aui:fieldset cssClass="handle-data" label="email">
						<liferay-ui:error key="emailAddressInvalid" message="please-enter-a-valid-email-address" />
						<liferay-ui:error key="emailAddressRequired" message="please-enter-an-email-address" />
						<liferay-ui:error key="fileNameInvalid" message="please-enter-a-valid-path-and-file-name" />
						<liferay-ui:error key="handlingRequired" message="please-select-an-action-for-the-handling-of-form-data" />
						<liferay-ui:error key="subjectRequired" message="please-enter-a-subject" />
		
						<aui:input label="send-as-email" name="preferences--sendAsEmail--" type="checkbox" value="<%= sendAsEmail %>" />
						<aui:fieldset id="send_as_email_details" cssClass='<%=sendAsEmail?StringPool.BLANK:"hide" %>' >
							<aui:fieldset>
								<aui:input cssClass="lfr-input-text-container" label="name-from" name="preferences--emailFromName--" value="<%= emailFromName %>" />
								<aui:input cssClass="lfr-input-text-container" label="address-from" name="preferences--emailFromAddress--" value="<%= emailFromAddress %>" />
							</aui:fieldset>
			
							<aui:input cssClass="lfr-input-text-container" helpMessage="add-email-addresses-separated-by-commas" label="addresses-to" name="preferences--emailAddress--" value="<%= emailAddress %>" />
			
							<aui:input cssClass="lfr-input-text-container" name="preferences--subject--" value="<%= subject %>" />
						</aui:fieldset>
						
						<aui:fieldset cssClass="handle-data" label="ack-email">
							<aui:input label="Send Acknowledgement Email" name="preferences--sendAck--" type="checkbox" value="<%= sendAckEmail %>" />
							<aui:fieldset id="send_ack_details" cssClass='<%= sendAckEmail?StringPool.BLANK:"hide" %>' >
								<aui:input cssClass="lfr-input-text-container" name="preferences--ackEmailSubject--" value="<%= ackEmailSubject %>" />
								<aui:input style="width: 600px; height: 200px" cssClass="lfr-textarea-container" name="preferences--ackEmailText--" type="textarea" value="<%= ackEmailText %>" wrap="soft" />
								<div class="definition-of-terms"> 
									<h4>Definition of Terms</h4> 
									<dl> 
										<dt> [$FORM_DATA$] </dt> 
										<dd> All form fields </dd>
										
										<dt> [$FIELD NAME$] </dt> 
										<dd> Name of a field you want to display (eg.: [$First name$])</dd> 
										
										<dt> [$EDIT_URL$] </dt> 
										<dd> URL to use if record changing is wanted  </dd>
										
									</dl> 
								</div>
								
							</aui:fieldset>
						</aui:fieldset>
					</aui:fieldset>
		
					<aui:fieldset cssClass="handle-data" label="database" style="margin-bottom: 20px">
						<aui:input name="preferences--saveToDatabase--" type="checkbox" value="<%= saveToDatabase %>" />
						<span style="color: #CCC"> (Table name: <%= databaseTableName %>) </span>
					</aui:fieldset>

					<aui:input label="is-post-to-url" name="preferences--isPostToURL--" type="checkbox" value="<%= isPostToURL %>" />
					<aui:fieldset id="post-to-url-details" label="post-to-url" style="margin-bottom: 20px" cssClass='<%=isPostToURL?StringPool.BLANK:"hide" %>'>
						<aui:input label="post-to-url" cssClass="lfr-input-text-container" name="preferences--postToURL--" value="<%= postToURL %>" type="url" style="width: 600px;"/>
					</aui:fieldset>
					
					<aui:fieldset cssClass="handle-data" label="file">
						<aui:input name="preferences--saveToFile--" type="checkbox" value="<%= saveToFile %>" />
						<aui:fieldset id="save_to_file_details" cssClass='<%=saveToFile?StringPool.BLANK:"hide" %>' >
							<aui:input cssClass='lfr-input-text-container' label="path-and-file-name" name="preferences--fileName--" value="<%= fileName %>" />
						</aui:fieldset>
					</aui:fieldset>
					
					<aui:input cssClass="lfr-textarea-container" style="width: 600px; height: 200px" name="preferences--onFormLoadScript--" type="textarea" value="<%= onFormLoadScript %>" wrap="soft" />
					
					<aui:input cssClass="lfr-textarea-container" style="width: 600px; height: 200px" name="preferences--formValidationScript--" type="textarea" value="<%= formValidationScript %>" wrap="soft" />
								
					<aui:input name="updateFields" type="hidden" value="<%= !fieldsEditingDisabled %>" />
					
					<c:if test="<%= fieldsEditingDisabled %>">
						<div class="alert">
							<liferay-ui:message key="there-is-existing-form-data-please-export-and-delete-it-before-making-changes-to-the-fields" />
						</div>
		
						<c:if test="<%= layoutTypePortlet.hasPortletId(portletResource) %>">
							<liferay-portlet:resourceURL portletName="<%= portletResource %>" var="exportURL">
								<portlet:param name="<%= Constants.CMD %>" value="export" />
							</liferay-portlet:resourceURL>
		
							<%
							String taglibExport = "submitForm(document.hrefFm, '" + exportURL + "', false);";
							%>
		
							<aui:button onClick="<%= taglibExport %>" value="export-data" />
		
							<liferay-portlet:actionURL portletName="<%= portletResource %>" var="deleteURL">
								<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="deleteData" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
							</liferay-portlet:actionURL>
		
							<%
							String taglibDelete = "submitForm(document." + renderResponse.getNamespace() + "fm, '" + deleteURL + "');";
							%>
		
							<aui:button onClick="<%= taglibDelete %>" value="delete-data" />
						</c:if>
					</c:if>
				</liferay-ui:panel>
				
					
					<% 
					int index = 1;
					for(int stepIndex = 0; stepIndex < nrSteps; stepIndex++) {
						if(nrSteps > 1){
							titleXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "title" + stepIndex);
							descriptionXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "description" + stepIndex);
						}
					
					%>
						<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id='<%= "webFormFields"+stepIndex %>' persistState="<%= true %>" title='<%= nrSteps<2?"form-fields":"form-fields-step-" + (stepIndex+1) %>'>
							
							<c:if test="<%= nrSteps > 1 %>">
								<aui:field-wrapper cssClass="lfr-input-text-container" label="title">
									<liferay-ui:input-localized name='<%= "title" + stepIndex %>' xml="<%= titleXml %>" />
								</aui:field-wrapper>
								<aui:field-wrapper cssClass="lfr-textarea-container" label="description">
									<liferay-ui:input-localized name='<%= "description" + stepIndex %>' type="textarea" xml="<%= descriptionXml %>" />
								</aui:field-wrapper>
							</c:if>
							
							
							<div class='<%= "webFields"+stepIndex %>'>
							
								<aui:fieldset cssClass='rows-container webFields'>
									<%
									String formFieldsIndexesParam = ParamUtil.getString(renderRequest, "formFieldsIndexes"+stepIndex) ;
									
									int[] formFieldsIndexes = null;
		
									if (Validator.isNotNull(formFieldsIndexesParam)) {
										formFieldsIndexes = StringUtil.split(formFieldsIndexesParam, 0);
									}
									else {
										
										formFieldsIndexesParam = portletPreferences.getValue("wizardStepFields"+stepIndex, StringPool.BLANK);
		
										if(formFieldsIndexesParam == null || formFieldsIndexesParam.equals("")){
											formFieldsIndexesParam = ""+index;
										}
										formFieldsIndexes = StringUtil.split(formFieldsIndexesParam, 0);
										
									}
									%>
									<c:if test="<%= fieldsEditingDisabled %>">
										<aui:input name='<%= "formFieldsIndexes"+stepIndex %>' type="hidden" value="<%= formFieldsIndexesParam %>" />
									</c:if>
									<%
									
									for (int formFieldsIndex : formFieldsIndexes) {
										
										request.setAttribute("configuration.jsp-index", String.valueOf(index));
										request.setAttribute("configuration.jsp-formFieldsIndex", String.valueOf(formFieldsIndex));
										request.setAttribute("configuration.jsp-fieldsEditingDisabled", String.valueOf(fieldsEditingDisabled));
										request.setAttribute("configuration.jsp-wizardStep", String.valueOf(stepIndex));
									%>	
									
										<div class="lfr-form-row" id="<portlet:namespace/>fieldset<%= formFieldsIndex %>">
											<div class="row-fields">
												<liferay-util:include page="/edit_field.jsp" servletContext="<%= application %>" />
											</div>
										</div>
									
									<%
										index++;
									}
									
									%>
									
								</div>
							</aui:fieldset>
						</liferay-ui:panel>
						
					<% } %>
				
				</liferay-ui:panel-container>
		
			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
		
		<%
		String modules = "aui-base";
		
		if (!fieldsEditingDisabled) {
			modules += ",liferay-auto-fields";
		}
		%>
		
		<aui:script use="<%= modules %>">
			var toggleOptions = function(event) {
				var select = this;
		
				var formRow = select.ancestor('.lfr-form-row');
				var value = select.val();
		
				var optionsDiv = formRow.one('.options');
				
				var onselectScriptDiv = formRow.one('.field-onselect-script');
				var placeholderDiv = formRow.one('.field-placeholder');
				var isAckEmailDiv = formRow.one('.is-ack-email');
				var fieldStyleDiv = formRow.one('.field-style-input');
				var optionalDiv = formRow.one('.optional');
				var availableLists = formRow.one('.available-lists');
				var onAddressSelectScriptDiv = formRow.one('.on-address-select-script');
				var fieldValueDiv = formRow.one('.field-value');
				var nameDiv = formRow.one('.name-div');
				
				if(value != 'paragraph'){
					optionalDiv.show();
					nameDiv.show();
				}
		
				if ((value == 'options') || (value == 'radio') || (value == 'checkbox') || (value == 'multiple-checkbox') || (value == 'paragraph')) {
					onselectScriptDiv.all('label').show();
					onselectScriptDiv.show();
				}else{
					onselectScriptDiv.all('label').hide();
					onselectScriptDiv.hide();
				}
				
				if (value == 'hidden') {
					fieldValueDiv.all('label').show();
					fieldValueDiv.show();
				}else{
					fieldValueDiv.all('label').hide();
					fieldValueDiv.hide();
				}
				
				if ((value == 'postcode') || (value == 'uprn')) {
					onAddressSelectScriptDiv.all('label').show();
					onAddressSelectScriptDiv.show();
				}else{
					onAddressSelectScriptDiv.all('label').hide();
					onAddressSelectScriptDiv.hide();
				}
				
				if ((value == 'text') || (value == 'textarea') || (value == 'email') || (value == 'tel') || (value == 'postcode') || (value == 'uprn')) {
					placeholderDiv.all('label').show();
					placeholderDiv.show();
				}else{
					placeholderDiv.all('label').hide();
					placeholderDiv.hide();
				}
		
				if ((value == 'options') || (value == 'radio') || (value == 'multiple-checkbox') || (value == 'paragraph')) {
					optionsDiv.all('label').show();
					optionsDiv.show();
					if(value == 'paragraph'){
						nameDiv.hide();
						optionalDiv.hide();
						availableLists.hide();
					}else{
						availableLists.show();
					}
				}
				/*else if (value == 'paragraph') {
		
					// Show just the text field and not the labels since there
					// are multiple choice inputs
		
					optionsDiv.all('label').hide();
					optionsDiv.show();
				}*/
				else {
					optionsDiv.hide();
				}
				
				if (value == 'email') {
					isAckEmailDiv.all('label').show();
					isAckEmailDiv.show();
				}else{
					isAckEmailDiv.val(false);
					isAckEmailDiv.all('label').hide();
					isAckEmailDiv.hide();
				}
				
				var optionalControl = formRow.one('.optional-control').ancestor();
				//debug(formRow.one('.optional-control'), optionalControl);
				var labelName = formRow.one('.label-name');
		
				if (value == 'paragraph') {
					var inputName = labelName.one('input.field');
		
					var formFieldsIndex = select.attr('id').match(/\d+$/);
		
					inputName.val('<liferay-ui:message key="paragraph" />' + formFieldsIndex);
					inputName.fire('change');
		
					labelName.hide();
					optionalControl.hide();
		
					optionalControl.all('input[type="checkbox"]').attr('checked', 'true');
					optionalControl.all('input[type="hidden"]').attr('value', 'true');
				}
				else {
					optionalControl.show();
					if(labelName){
						labelName.show();
					}
				}
			};
		
			var toggleValidationOptions = function(event) {
				this.next().toggle();
			};
			
			var toggleAdvancedSettingsBox = function(event) {
				this.next().toggle();
			};
			
			var toggleCountrySelect = function(event) {
				var fieldIndex = this.attr('data-helper');
				var select = A.one('#<portlet:namespace />fieldOptions'+fieldIndex);
				var disable = this.previous().val() == "true";
				select.set("disabled", disable);
			};
			
			var toggleSaveToFile = function(event) {
				var checkbox = A.one(this);
				if (checkbox) {
					if(checkbox.previous().val() == 'true'){
						A.one('#<portlet:namespace />save_to_file_details').show();
					}else{
						A.one('#<portlet:namespace />save_to_file_details').hide();
					}
				}
			};
			var toggleSendAckEmail = function(event) {
				var checkbox = A.one(this);
				if (checkbox) {
					if(checkbox.previous().val() == 'true'){
						A.one('#<portlet:namespace />send_ack_details').show();
					}else{
						A.one('#<portlet:namespace />send_ack_details').hide();
					}
				}
			};
			var toggleWizardSteps = function(event) {
				var checkbox = A.one(this);
				if (checkbox) {
					if(checkbox.previous().val() == 'true'){
						A.one('#<portlet:namespace />wizard_details').show();
					}else{
						A.one('#<portlet:namespace />wizard_details').hide();
					}
				}
			};
			
			var toggleSendAsEmail = function(event) {
				var checkbox = A.one(this);
				if (checkbox) {
					if(checkbox.previous().val() == 'true'){
						A.one('#<portlet:namespace />send_as_email_details').show();
					}else{
						A.one('#<portlet:namespace />send_as_email_details').hide();
					}
				}
			};
			var toggleSaveTemp = function(event) {
				var checkbox = A.one(this);
				if (checkbox) {
					if(checkbox.previous().val() == 'true'){
						A.one('#<portlet:namespace />save-temp-success-details').show();
					}else{
						A.one('#<portlet:namespace />save-temp-success-details').hide();
					}
				}
			};
			
			var togglePostToURL = function(event) {
				var checkbox = A.one(this);
				if (checkbox) {
					if(checkbox.previous().val() == 'true'){
						A.one('#<portlet:namespace />post-to-url-details').show();
					}else{
						A.one('#<portlet:namespace />post-to-url-details').hide();
					}
				}
			};
			
			A.one('#<portlet:namespace />sendAckCheckbox').on('click', toggleSendAckEmail);
			A.one('#<portlet:namespace />saveToFileCheckbox').on('click', toggleSaveToFile);
			A.one('#<portlet:namespace />isWizardCheckbox').on('click', toggleWizardSteps);
			A.one('#<portlet:namespace />sendAsEmailCheckbox').on('click', toggleSendAsEmail);
			A.one('#<portlet:namespace />saveTempEnableCheckbox').on('click', toggleSaveTemp);
			A.one('#<portlet:namespace />isPostToURLCheckbox').on('click', togglePostToURL);
			
			<liferay-portlet:renderURL portletConfiguration="true" var="editFieldURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
			</liferay-portlet:renderURL>
			
			
			<% for(int stepIndex = 0; stepIndex < nrSteps; stepIndex++) { %>
				var stepIndex = '<%= stepIndex %>';
				
				var webFields = A.one('<%= ".webFields"+stepIndex %> .webFields');
		
				webFields.all('select').each(toggleOptions);
				webFields.delegate('click', toggleAdvancedSettingsBox, '.advanced-settings-link');
				webFields.delegate('click', toggleCountrySelect, '.country-select');
				webFields.delegate('click', toggleCountrySelect, '.nsg-organisation-select');
				
				<c:if test="<%= !fieldsEditingDisabled %>">
					webFields.delegate(['change', 'click', 'keydown'], toggleOptions, 'select');
					
					webFields.delegate(
						'change',
						function(event) {
							var input = event.currentTarget;
							var row = input.ancestor('.field-row');
							var label = row.one('.field-title');
			
							if (label) {
								label.html(input.get('value'));
							}
						},
						'.label-name input'
					);
			
					new Liferay.AutoFields(
						{
							contentBox: webFields,
							fieldIndexes: '<portlet:namespace />formFieldsIndexes'+stepIndex,
							sortable: true,
							sortableHandle: '.field-label',
							url: '<%= editFieldURL %>'
						}
					).render();
				</c:if>	
			<% } %>
			
		</aui:script>
	</liferay-ui:section>
	<liferay-ui:section>

		<liferay-portlet:resourceURL portletName="<%= portletResource %>" var="getFormDataURL">
			<portlet:param name="<%= Constants.CMD %>" value="get_data" />
		</liferay-portlet:resourceURL>
		
		<c:choose>
			<c:when test="<%= fieldsEditingDisabled %>">
				<button type="button" style="margin-bottom: 10px" class="btn btn-primary" id="<portlet:namespace />refresh_data_button">Refresh data<i class="icon-refresh"></i></button>
			</c:when>
			<c:otherwise>
				<h4><%= LanguageUtil.get(locale, "no-data") %></h4>
			</c:otherwise>
		</c:choose>
		
		
		
		<div id="<portlet:namespace />form_data"></div>
		
		<aui:script use="aui-base,selector-css3,aui-io-request">
	
			var button = A.one('#<portlet:namespace />refresh_data_button');
			button.on('click', function(event) {
				<portlet:namespace />RefreshData();
			});
		
			Liferay.provide(window, '<portlet:namespace />RefreshData',
				function() {
					
		        	A.io.request('<%= getFormDataURL %>',{
		                  dataType: 'json',
		                  method: 'POST',
		                  data: {},
		                  on: {
		                      success: function() {
		                    	  
		                    	var tableWrapper = A.one('#<portlet:namespace />form_data');
		                      	var response = this.get('responseData');
		                      	if(response.success){
		                      		console.log(response.success);
		                      		tableWrapper.empty();
		                      		tableWrapper.append(response.data);
		                      	}else{
		                      		console.log(response.success);
		                      		prioritySetWrapper.addClass('error');                      		
		                      	}
		                      }
		                  }
		            });
					
		        },
        	['aui-base,selector-css3']
    	);
    
		</aui:script>
	</liferay-ui:section>
</liferay-ui:tabs>