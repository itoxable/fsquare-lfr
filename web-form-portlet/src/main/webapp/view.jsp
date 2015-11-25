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
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="javax.portlet.ResourceRequest"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.webform.action.ConfigurationActionImpl"%>
<%@ include file="/init.jsp" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>

<%

Portlet portlet = (Portlet)request.getAttribute(WebKeys.RENDER_PORTLET);

String portletId = portlet.getPortletId();
String rootPortletId = portlet.getRootPortletId();
String instanceId = portlet.getInstanceId();


boolean showPortletActions = portletDisplay.isShowConfigurationIcon();


String formValidationScript = portletPreferences.getValue("formValidationScript", StringPool.BLANK);
String onFormLoadScript = portletPreferences.getValue("onFormLoadScript", StringPool.BLANK);

String title = ParamUtil.getString(request, "title", StringPool.BLANK);
if(Validator.isNull(title)){
	title = LocalizationUtil.getPreferencesValue(portletPreferences, "title", themeDisplay.getLanguageId());
}

String description = LocalizationUtil.getPreferencesValue(portletPreferences, "description", themeDisplay.getLanguageId());
boolean requireCaptcha = GetterUtil.getBoolean(portletPreferences.getValue("requireCaptcha", StringPool.BLANK));
String successURL = portletPreferences.getValue("successURL", StringPool.BLANK);

String submitButtonLabel = LocalizationUtil.getPreferencesValue(portletPreferences, "submitButtonLabel", themeDisplay.getLanguageId());
if(submitButtonLabel == null || submitButtonLabel.equals("")){
	submitButtonLabel = "send";
}
String saveButtonLabel = LocalizationUtil.getPreferencesValue(portletPreferences, "saveButtonLabel", themeDisplay.getLanguageId());
if(saveButtonLabel == null || saveButtonLabel.equals("")){
	saveButtonLabel = LanguageUtil.get(locale, "save-button-label");
}

// boolean isWizard = GetterUtil.getBoolean(portletPreferences.getValue("isWizard", StringPool.BLANK));
// String wizardNrSteps = portletPreferences.getValue("wizardNrSteps", StringPool.BLANK);
// int nrSteps = 1;
// if(wizardNrSteps != null && wizardNrSteps!= ""){
// 	nrSteps = Integer.parseInt(wizardNrSteps);
// }

// boolean isReallyWizard = nrSteps > 1;

String successMessage = LocalizationUtil.getPreferencesValue(portletPreferences, "successMessage", themeDisplay.getLanguageId());
if(successMessage == null || successMessage.equals("")){
	successMessage = LanguageUtil.get(locale, "form-sent-successfully");
}

HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
String userEmail = null;
if(themeDisplay.isSignedIn()) {
	userEmail =themeDisplay.getUser().getDisplayEmailAddress();
}

Calendar today = CalendarFactoryUtil.getCalendar(timeZone, locale);
List<String> countrySelectionFields = new ArrayList<String>();

WindowState windowState = liferayPortletRequest.getWindowState();
String currentWindowState = windowState.toString();

Boolean databaseTableExists = false;
String databaseTableName = portletPreferences.getValue("databaseTableName", StringPool.BLANK);
if (WebFormUtil.getTableRowsCount(company.getCompanyId(), databaseTableName) > 0) {
	databaseTableExists = true;
}

boolean isFindUPRN = false;
boolean isFindPostcode = false;

boolean saveToDatabase = GetterUtil.getBoolean(portletPreferences.getValue("saveToDatabase", StringPool.BLANK));

boolean saveTempEnable = GetterUtil.getBoolean(portletPreferences.getValue("saveTempEnable", StringPool.BLANK)) && saveToDatabase;

Object obj = request.getAttribute("savedValuesMap");
Map<String, String> valuesMap = new HashMap<String, String>();
if(obj != null){
	valuesMap = (Map<String, String>)obj;
}
request.removeAttribute("savedValuesMap");

String rowId = (String)request.getAttribute("EDITING_ROW");

String saveTempSuccessText = portletPreferences.getValue("saveTempSuccessText", StringPool.BLANK);
if(saveTempSuccessText == null || saveTempSuccessText.equals("")){
	saveTempSuccessText = LanguageUtil.get(locale, "success-saving-temp");
}

String saveButtonStyle = portletPreferences.getValue("saveButtonStyle", StringPool.BLANK);
String saveButtonStyleClass = portletPreferences.getValue("saveButtonStyleClass", StringPool.BLANK);

%>

<c:if test="<%= LiferayWindowState.POP_UP.equals(windowState) %>">
	<link type="text/css" rel="stylesheet" href="//fast.fonts.net/cssapi/0d8751b3-7bd8-42b9-8348-3964a17f55ab.css"/>
	<link href='//fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
</c:if>			


<c:choose>

	<c:when test='<%= SessionMessages.contains(liferayPortletRequest, WebFormUtil.FORM_MESSAGE_SUCCESS)%>' >
		<div class="form-only-notices-wrapper">
			<div class="form-only-notices">
				<div class="form-head">
					<c:if test="<%= Validator.isNotNull(title) %>">
						<h2 id="form-title"><%= HtmlUtil.escape(title) %></h2>
					</c:if>
					<c:if test="<%= Validator.isNotNull(description) %>">
						<p class="description"><%= HtmlUtil.escape(description) %></p>
					</c:if>
				</div>
				<%

				successMessage = successMessage.replaceAll("\\[\\$BACK_URL\\$\\]", themeDisplay.getURLPortal()+themeDisplay.getLayout().getFriendlyURL(locale));
				Map<String, String> fieldsMap = (Map<String, String>)SessionMessages.get(liferayPortletRequest, WebFormUtil.FORM_MESSAGE_SUCCESS);
				if(fieldsMap != null){
					successMessage = successMessage.replaceAll("\\[\\$FORM_DATA\\$\\]", WebFormUtil.getMailBody(fieldsMap));
		 			for(Map.Entry<String, String> entry : fieldsMap.entrySet()){
		 				successMessage = successMessage.replaceAll("\\[\\$"+entry.getKey()+"\\$\\]", entry.getValue());
					}
				}
				 %>
				<div class="success-message"><%= successMessage %></div>
			</div>
		</div>
	</c:when>
	
	<c:when test='<%= SessionMessages.contains(liferayPortletRequest, WebFormUtil.FORM_MESSAGE_SUCCES_SAVING_TEMP)%>' >
		<div class="form-only-notices-wrapper">
			<div class="form-only-notices">
				<div class="form-head">
					<c:if test="<%= Validator.isNotNull(title) %>">
						<h2 id="form-title"><%= HtmlUtil.escape(title) %></h2>
					</c:if>
					<c:if test="<%= Validator.isNotNull(description) %>">
						<p class="description"><%= HtmlUtil.escape(description) %></p>
					</c:if>
				</div>
				<%
					saveTempSuccessText = saveTempSuccessText.replaceAll("\\[\\$BACK_URL\\$\\]", themeDisplay.getURLPortal()+themeDisplay.getLayout().getFriendlyURL(locale));
					String formURL = (String)SessionMessages.get(liferayPortletRequest, WebFormUtil.FORM_MESSAGE_SUCCES_SAVING_TEMP);
					if( Validator.isNotNull(formURL)){
						saveTempSuccessText = saveTempSuccessText.replaceAll("\\[\\$FORM_URL\\$\\]", formURL);
					}
				 %>
				<div class="success-message"><%= saveTempSuccessText %></div>
			</div>
		</div>
	</c:when>
	
	<c:otherwise>
				
		<portlet:actionURL var="saveDataURL">
			<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="saveData" />
		</portlet:actionURL>
		
		<portlet:actionURL var="saveTempDataURL">
			<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="saveTempData" />
		</portlet:actionURL>
		
		
		<aui:form action="<%= saveDataURL %>" method="post" name="fm" enctype="multipart/form-data">
			<div class="form-wrapper">
				
				<c:if test="<%= Validator.isNotNull(rowId) %>">
					<aui:input name="EDITING_ROW" type="hidden" value="<%= rowId %>" />
				</c:if>
				
				<c:if test="<%= Validator.isNull(successURL) %>">
					<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
				</c:if>
			
				<aui:input name="inputFileName" type="hidden"></aui:input>
		
				<aui:fieldset>
					
					<div class="form-notices">
						<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
						<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
						
						<liferay-ui:error key="<%= WebFormUtil.FORM_MESSAGE_ERROR %>" message="an-error-occurred-while-sending-the-form-information" />
						
						<liferay-ui:error key="<%= WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_ERROR %>" message="temporary-data-error" />
						<liferay-ui:error key="<%= WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_ERROR_NO_ROW %>" message="temporary-data-error-no-row" />
						<liferay-ui:error key="<%= WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_ERROR_NO_TABLE %>" message="temporary-data-error-no-table" />
						<liferay-ui:error key="<%= WebFormUtil.FORM_MESSAGE_ERROR_INVALID_ROW_ID%>" message="temporary-data-error-no-table" />
						
						
						
						<c:if test='<%= SessionMessages.contains(liferayPortletRequest, WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_SUCCESS)%>' >
						
							<%
								Date formDate = (Date)SessionMessages.get(liferayPortletRequest, WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_SUCCESS);
							 %>
												
							<div class="alert alert-success"><%= LanguageUtil.format(locale, "temporary-data-success", new Object[]{formDate}) %></div>
						</c:if>
					</div>
			
					<div class="form-body">
						<c:if test='<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED && SessionErrors.contains(renderRequest, "validationScriptError") %>'>
							<liferay-util:include page="/script_error.jsp" />
						</c:if>
			
						<%
						int i = 1;
						String fieldName = "field" + i;
						String fieldLabel = LocalizationUtil.getPreferencesValue(portletPreferences, "fieldLabel" + i, themeDisplay.getLanguageId());
							
						while ((i == 1) || Validator.isNotNull(fieldLabel)) {
							
							
							boolean fieldOptional = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldOptional" + i, false);
							boolean fieldReadOnly = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldReadOnly" + i, false);
							String tempVal = valuesMap.get(fieldName);
			
							HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(request);
							String valFromOriginalRequest = originalRequest.getParameter(fieldName);
							String fieldValue = ParamUtil.getString(request, fieldName,  tempVal==null?(valFromOriginalRequest==null?StringPool.BLANK:valFromOriginalRequest):tempVal);
							String value = portletPreferences.getValue("fieldValue" + i, StringPool.BLANK);
							if(Validator.isNull(fieldValue)){
								fieldValue = value;
							}
							String fieldPlaceHolder = LocalizationUtil.getPreferencesValue(portletPreferences, "fieldPlaceHolder" + i, themeDisplay.getLanguageId());
							String fieldType = portletPreferences.getValue("fieldType" + i, "text");
							String fieldOptions = LocalizationUtil.getPreferencesValue(portletPreferences, "fieldOptions" + i, themeDisplay.getLanguageId());
							String fieldBlankOption = LocalizationUtil.getPreferencesValue(portletPreferences, "fieldBlankOption" + i, themeDisplay.getLanguageId());
	
							String fieldValidationScript = portletPreferences.getValue("fieldValidationScript" + i, StringPool.BLANK);
							String fieldValidationErrorMessage = portletPreferences.getValue("fieldValidationErrorMessage" + i, StringPool.BLANK);
							
							String fieldOnSelectScript = portletPreferences.getValue("fieldOnSelectScript" + i, StringPool.BLANK);
							String onAddressSelect = portletPreferences.getValue("onAddressSelect" + i, StringPool.BLANK);
							String fieldStyle = portletPreferences.getValue("fieldStyle" + i, StringPool.BLANK);
							String fieldStyleClass = " "+portletPreferences.getValue("fieldStyleClass" + i, StringPool.BLANK);
							String fieldWrapperStyle = portletPreferences.getValue("fieldWrapperStyle" + i, StringPool.BLANK);
							String fieldWrapperStyleClass = " "+portletPreferences.getValue("fieldWrapperStyleClass" + i, StringPool.BLANK);
							
							String fieldDataHelper = " "+portletPreferences.getValue("fieldDataHelper" + i, StringPool.BLANK);
							
							boolean countrySelect = PrefsParamUtil.getBoolean(portletPreferences, request, "countrySelect" + i, false);
	
						%>
							<c:if test='<%= fieldType.equals("hidden") %>'>
								<aui:input data-helper='<%= fieldDataHelper %>'  cssClass='<%= fieldStyleClass %>' type="<%= fieldType %>" name="<%= fieldName %>" value="<%= HtmlUtil.escape(fieldValue) %>" />
								
							</c:if>
								<%
								if(fieldType.equals("hidden")){
									continue;
								}
								%>
							<div class="field-wrapper field-wrapper-<%= i %>  field-type-<%= fieldType + fieldWrapperStyleClass %>" style="<%= fieldWrapperStyle %>">
			
								<c:choose>
									
									<c:when test='<%= fieldType.equals("paragraph") %>'>
										<p style="<%= fieldStyle %>" class="lfr-webform" id="<portlet:namespace /><%= fieldName %>"><%= fieldOptions %></p>
									</c:when>
									<c:when test='<%= fieldType.equals("text") %>'>
										<aui:input data-helper='<%= fieldDataHelper %>' style="<%= fieldStyle %>" placeholder="<%= HtmlUtil.escape(fieldPlaceHolder) %>" cssClass='<%= (fieldOptional ? "optional" : StringPool.BLANK) + fieldStyleClass %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" value="<%= HtmlUtil.escape(fieldValue) %>" />
									</c:when>
									<c:when test='<%= fieldType.equals("tel")  %>'>
										<aui:input data-helper='<%= fieldDataHelper %>' style="<%= fieldStyle %>" placeholder="<%= HtmlUtil.escape(fieldPlaceHolder) %>" type="tel" cssClass='<%= (fieldOptional ? "optional" : StringPool.BLANK) + fieldStyleClass %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" value="<%= HtmlUtil.escape(fieldValue) %>" />
									</c:when>
									<c:when test='<%= fieldType.equals("postcode")  %>'>
										
										<div class="control-group"> 
											<div class="postcode-search">
												<label class="control-label"  for="<portlet:namespace/><%= fieldName %>"> 
													<%= HtmlUtil.escape(fieldLabel) %> 
												</label> 

												<input data-helper='<%= fieldDataHelper %>' style="<%= fieldStyle %>" placeholder="<%= HtmlUtil.escape(fieldPlaceHolder) %>" type="text" id="<portlet:namespace/><%= fieldName %>"
												class='<%= (fieldOptional ? "optional" : StringPool.BLANK) + fieldStyleClass %>' name="<portlet:namespace/><%= fieldName %>" value="<%= HtmlUtil.escape(fieldValue) %>" />
												<a href="javascript:;" onclick="<portlet:namespace />findPostcode('<%= fieldName %>'); return false" class="btn btn-primary" >find address</a>
											</div>
										
											<div class="postcode-search-result-wrapper hide" id="<%= fieldName %>selectDropdownDiv">
						                        <label class="control-label" for="<%= fieldName %>addressListSelect">Select an Address:</label>
						                        <select id="<%= fieldName %>addressListSelect" onchange="<portlet:namespace />addressSelect(this,function(result){<%= onAddressSelect %>})"></select>
						                    </div>
					                    </div>
										
										<% 
											isFindPostcode = true; 
										%>

									</c:when>
									<c:when test='<%= fieldType.equals("uprn")  %>'>
										<aui:input data-helper='<%= fieldDataHelper %>' style="<%= fieldStyle %>" placeholder="<%= HtmlUtil.escape(fieldPlaceHolder) %>" type="text" cssClass='<%= (fieldOptional ? "optional" : StringPool.BLANK) + fieldStyleClass %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" value="<%= HtmlUtil.escape(fieldValue) %>" />
										<a href="javascript:;"  onclick="<portlet:namespace />findUPRN('<%= fieldName %>'); return false" class="btn btn-primary" type="submit">find address</a>
										
										<div id="<%= fieldName %>selectDropdownDiv">
					                        <label class="control-label" for="<%= fieldName %>addressListSelect">Select an Address:</label>
					                        <select id="<%= fieldName %>addressListSelect"></select>
					                    </div>
										
										<% isFindUPRN = true; %>
									</c:when>
									<c:when test='<%= fieldType.equals("email") %>'>
										<aui:input data-helper='<%= fieldDataHelper %>' style="<%= fieldStyle %>" placeholder="<%= HtmlUtil.escape(fieldPlaceHolder) %>" type="email" cssClass='<%= (fieldOptional ? "optional" : StringPool.BLANK) + fieldStyleClass %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" value="<%= HtmlUtil.escape(fieldValue) %>" >
											<aui:validator name="email"/>
										</aui:input>
									</c:when>
									<c:when test='<%= fieldType.equals("textarea") %>'>
										<aui:input data-helper='<%= fieldDataHelper %>' style="<%= fieldStyle %>" placeholder="<%= HtmlUtil.escape(fieldPlaceHolder) %>" cssClass='<%= "lfr-textarea-container" + (fieldOptional ? "optional" : StringPool.BLANK) + fieldStyleClass%>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" type="textarea" value="<%= HtmlUtil.escape(fieldValue) %>" wrap="soft" />
									</c:when>
									<c:when test='<%= fieldType.equals("checkbox") %>'>
										<aui:input style="<%= fieldStyle %>" data-helper='<%= fieldDataHelper %>' onChange='<%= fieldOnSelectScript%>' cssClass='<%= (fieldOptional ? "optional" : StringPool.BLANK) + fieldStyleClass  %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" type="checkbox" value='<%= GetterUtil.getBoolean(fieldValue) %>' />
									</c:when>
									
									<c:when test='<%= fieldType.equals("multiple-checkbox") %>'>
										
										<aui:field-wrapper  cssClass='<%= fieldOptional ? "optional" : StringPool.BLANK %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name='<%= fieldName + "_title" %>'>
										
											<%
											int checkBoxIndex = 0;
											for (String fieldOptionValue : WebFormUtil.split(fieldOptions)) {
												String checkboxfieldName = fieldName+"_"+checkBoxIndex;
												String checkboxfieldValue = ParamUtil.getString(request, checkboxfieldName, valuesMap.get(checkboxfieldName));
												fieldOptionValue = fieldOptionValue.trim();
												checkBoxIndex++;
											%>
												<aui:input wrapperCssClass="<%= fieldStyle %>"  cssClass='<%= fieldStyleClass %>' onChange='<%= fieldOnSelectScript%>' checked="<%= fieldValue.equals(fieldOptionValue) %>" label="<%= HtmlUtil.escape(fieldOptionValue) %>" name="<%= checkboxfieldName %>" type="checkbox" value="<%= GetterUtil.getBoolean(checkboxfieldValue)  %>" />
											<%
											}
											%>	
											<aui:input name='<%= fieldName %>' type="hidden" value="<%= checkBoxIndex %>" />
											
											<c:if test="<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED %>">
												<liferay-ui:error key='<%= "error" + fieldLabel %>' message="<%= fieldValidationErrorMessage %>" />
						
												<c:if test="<%= Validator.isNotNull(fieldValidationScript) %>">
													<div class="hide" id="<portlet:namespace/>validationError<%= fieldName %>">
														<span class="alert alert-error"><%= fieldValidationErrorMessage %></span>
													</div>
												</c:if>
											</c:if>	
										</aui:field-wrapper>
									</c:when>
									
									<c:when test='<%= fieldType.equals("radio") %>'>
										<aui:field-wrapper  cssClass='<%= fieldOptional ? "optional" : StringPool.BLANK %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name='<%= fieldName + "_title" %>'>
										
											<%
											for (String fieldOptionValue : WebFormUtil.split(fieldOptions)) {
												fieldOptionValue = fieldOptionValue.trim();
											%>
												<aui:input onChange='<%= fieldOnSelectScript%>' cssClass='<portlet:namespace /><%= fieldName %>' checked="<%= fieldValue.equals(fieldOptionValue) %>" label="<%= HtmlUtil.escape(fieldOptionValue) %>" name="<%= fieldName %>" type="radio" value="<%= HtmlUtil.escape(fieldOptionValue) %>" />
											<%
											}
											%>
											<c:if test="<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED %>">
												<liferay-ui:error key='<%= "error" + fieldLabel %>' message="<%= fieldValidationErrorMessage %>" />
						
												<c:if test="<%= Validator.isNotNull(fieldValidationScript) %>">
													<div class="hide" id="<portlet:namespace/>validationError<%= fieldName %>">
														<span class="alert alert-error"><%= fieldValidationErrorMessage %></span>
													</div>
												</c:if>
											</c:if>
										</aui:field-wrapper>
									</c:when>
									<c:when test='<%= fieldType.equals("options") %>'>
										<aui:select style="<%= fieldStyle %>" onChange='<%= "onSelectChange(this);"+ fieldOnSelectScript %>'  disabled="<%= fieldReadOnly %>" cssClass='<%= fieldOptional ? "optional field-blank-option" : StringPool.BLANK+" field-blank-option" %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>">
											<%
											if(Validator.isNotNull(fieldBlankOption)){
											%>
												<aui:option value=""><%= HtmlUtil.escape(fieldBlankOption) %></aui:option>
											<%
											}
											if(countrySelect){
												countrySelectionFields.add(fieldName);
											}else{
												for (String fieldOptionValue : WebFormUtil.split(fieldOptions)) {
													fieldOptionValue = fieldOptionValue.trim();
												%>
													<aui:option selected="<%= fieldValue.equals(fieldOptionValue) %>" value="<%= HtmlUtil.escape(fieldOptionValue) %>"><%= HtmlUtil.escape(fieldOptionValue) %></aui:option>
												<%
												}
											}
											%>
			
			
										</aui:select>
										
									</c:when>
									<c:when test='<%= fieldType.equals("fileupload") %>'>
										 <aui:input name="fileupload" type="file" label="<%= HtmlUtil.escape(fieldLabel) %>" />
									</c:when>
									
									<c:when test='<%= fieldType.equals("date") %>'>								   
										<div class="control-group"> 						
											<label class="control-label" for='<%= fieldName %>'> <%= HtmlUtil.escape(fieldLabel) %> </label>
											<liferay-ui:input-date 
												dayValue='<%= today.get(Calendar.DATE) %>' 
												monthValue='<%= today.get(Calendar.MONTH) %>' 
												yearValue='<%= today.get(Calendar.YEAR) %>'
												name='<%= fieldName %>'
												dayParam='<%= fieldName + "Day" %>'
												disabled='<%= false %>'
												monthParam='<%= fieldName + "Month" %>'
												yearParam='<%= fieldName + "Year" %>'
											/>
										</div>
										<div style="clear: both"></div>
									</c:when>
									
									<c:when test='<%= fieldType.equals("dateTime") %>'>								   
										<div class="control-group date-time-group"> 
											<label class="control-label" for='<%= fieldName %>'> <%= HtmlUtil.escape(fieldLabel) %> </label>
											<liferay-ui:input-date 
												dayValue='<%= today.get(Calendar.DATE) %>' 
												monthValue='<%= today.get(Calendar.MONTH) %>' 
												yearValue='<%= today.get(Calendar.YEAR) %>'
												name='<%= fieldName %>'
												dayParam='<%= fieldName + "Day"  %>'
												disabled='<%= false %>'
												monthParam='<%= fieldName + "Month"  %>'
												yearParam='<%= fieldName + "Year"  %>'
											/>
											<liferay-ui:input-time
				 								amPmParam='<%= fieldName + "AmPm"  %>' 
				 								amPmValue="<%= today.get(Calendar.AM_PM) %>" 
				 								disabled="<%= false %>" 
				 								name='<%= fieldName + "_time" %>'
				 								hourParam='<%= fieldName + "Hour"  %>' 
				 								hourValue="<%= today.get(Calendar.HOUR) %>" 
				 								minuteInterval="<%= 30 %>" 
				 								minuteParam='<%= fieldName + "Minute"  %>' 
				 								minuteValue="<%= today.get(Calendar.MINUTE) %>" 
				 							/> 
				 							<input id='<%= fieldName %>' name='<%= fieldName %>' type="hidden">
				 							
										</div>
									</c:when>
									
									<c:when test='<%= fieldType.equals("richText") %>'>	
										<div class="control-group"> 
											<label class="control-label" for='<%= fieldName   %>'> <%= HtmlUtil.escape(fieldLabel) %> </label>
											<liferay-ui:input-editor
												resizable="false"
												editorImpl="ckeditor"
												initMethod='<%= fieldName + \"InitEditor\" %>'
												name="<%= fieldName   %>"
												toolbarSet="simple"
											/> 
										</div>
										<aui:script>
											function <portlet:namespace /><%= fieldName   %>InitEditor() {}
										</aui:script>
									</c:when>
									
								</c:choose>
								<div class="alert-wrapper">
									<span class="alert alert-error hide field-optional-error" id="<portlet:namespace/>fieldOptionalError<%= fieldName %>">
										<liferay-ui:message key="this-field-is-mandatory" />
									</span>
								</div>
								
								<c:if test='<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED  && !fieldType.equals("multiple-checkbox")  %>'>
									<liferay-ui:error key='<%= "error" + fieldLabel %>' message="<%= fieldValidationErrorMessage %>" />
									<c:if test="<%= Validator.isNotNull(fieldValidationScript) %>">
										<div class="hide" id="<portlet:namespace/>validationError<%= fieldName %>">
											<span class="alert alert-error"><%= fieldValidationErrorMessage %></span>
										</div>
									</c:if>
								</c:if>
								
							</div>
			
						<%
							i++;
	
							fieldName = "field" + i;
							fieldLabel = LocalizationUtil.getPreferencesValue(portletPreferences, "fieldLabel" + i, themeDisplay.getLanguageId());
// 							fieldOptional = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldOptional" + i, false);
// 							fieldReadOnly = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldReadOnly" + i, false);
// 							fieldValue = ParamUtil.getString(request, fieldName);
						
						}
						%>
			
					</div>
			
				</aui:fieldset>
			
				<c:if test="<%= requireCaptcha %>">
					<portlet:resourceURL var="captchaURL">
						<portlet:param name="<%= Constants.CMD %>" value="captcha" />
					</portlet:resourceURL>
			
					<liferay-ui:captcha url="<%= captchaURL %>" />
				</c:if>
			
				<aui:button cssClass="wizard-button submit-button" onClick="" type="submit" value="<%= submitButtonLabel %>" />
				<c:if test="<%= saveTempEnable %>">						
					<a href="javascript:;" id="<portlet:namespace />save_for_later" style="<%= saveButtonStyle %>" class="btn wizard-button btn-primary <%= saveButtonStyleClass %>" onClick="" ><%= saveButtonLabel%> </a>
				</c:if>
						
				
			</div>
		</aui:form>
		
		<script>
			function onSelectChange(element) {
				var el = $(element);
				if(el.val().trim() == ""){
					el.addClass("field-blank-option");
				}else{
					el.removeClass("field-blank-option");
				}
			}
		</script>
		
		<aui:script use="aui-base,selector-css3,aui-io-request">
			
			<c:if test="<%= isFindUPRN %>">
			
				window.<portlet:namespace />uprnResults = {};
				Liferay.provide(window, '<portlet:namespace />findUPRN',
					function(field) {
						var input = A.one('#<portlet:namespace />'+field);
						var val = input.val();
			        	A.io.request('/c/portal/geoplace/data_services',{
			                  dataType: 'json',
			                  method: 'GET',
			                  data: { 
			                	  data_action: 'find',
			                	  findBy: 'uprn',
			                  	  q: val
			                   },
			                  on: {
			                      success: function() {
			                      	var response = this.get('responseData');
			                      	debug(this, response);
			                      	window.<portlet:namespace />uprnResults = response.results;
			                      	var option = "";
			                      	for(var i = 0; i < results.length; i++){
			                      		var result = results[i].DPA;
			                      	}
			                      }
			                  }
			            });
						
			        },
			        ['aui-base,selector-css3']
			    );
			</c:if>
		
			<c:if test="<%= isFindPostcode %>">
				window.<portlet:namespace />postcodeResults = {};
				Liferay.provide(window, '<portlet:namespace />findPostcode',
					function(field) {
						var input = A.one('#<portlet:namespace />'+field);
						var val = input.val();
			        	A.io.request('/c/portal/geoplace/data_services',{
			                  dataType: 'json',
			                  method: 'GET',
			                  data: { 
			                	  data_action: 'find',
			                	  findBy: 'postcode',
			                  	  q: val
			                   },
			                  on: {
			                      success: function() {
			                      	var response = this.get('responseData');
			                      	debug(this, response, response.results);
			                      	var options = [];
			                      	var option = "<option value='VALUE'>LABEL</option>";
			                      	for(var i = 0; i < response.results.length; i++){
			                      		var result = response.results[i].DPA;
			                      		window.<portlet:namespace />postcodeResults[result.UPRN] = result;
			                      		options.push(option.replace("VALUE", result.UPRN).replace("LABEL", result.ADDRESS))
			                      	}
			                      	A.one('#'+field+'addressListSelect').append(options.join(""));
			                      	
			                      	A.one('#'+field+'selectDropdownDiv').show();
			                      }
			                  }
			            });
			        },
			        ['aui-base,selector-css3']
			    );
				
				Liferay.provide(window, '<portlet:namespace />addressSelect',
					function(field, callback) {	
						callback(window.<portlet:namespace />postcodeResults[field.value]);
					}, 
					['aui-base,selector-css3']
				);
			</c:if>
		</aui:script>
		
		<aui:script use="liferay-auto-fields,liferay-dynamic-select">
			GeoPlaceWebForm = {};
			GeoPlaceWebForm.Address = {
				getCountries: function(callback) {
					Liferay.Service(
						'/country/get-countries',
						{
							active: true
						},
						callback
					);
				}
			};
			new Liferay.DynamicSelect(
				[
				<% for (int i = 0; i < countrySelectionFields.size(); i++) { 
					String fieldName = countrySelectionFields.get(i);
					if(i > 0){%>
					,
					<% } %>
					{
						select: '<portlet:namespace /><%= fieldName %>',
						selectData: GeoPlaceWebForm.Address.getCountries,
						selectDesc: 'nameCurrentValue',
						selectSort: '<%= true %>',
						selectId: 'name',
						selectVal: 'united-kingdom'
					}
				<% } %>
				]
			);	
			
		</aui:script>
		
		<aui:script use="aui-base,selector-css3,node-load">
			
			<c:if test="<%= saveTempEnable %>">
				var saveForLaterButton = A.one('#<portlet:namespace />save_for_later');
				saveForLaterButton.on('click', function(event) {
					var form = A.one('#<portlet:namespace />fm');
					debug(form);
					form.attr('no-validate', true);
					form.attr('action', "<%= saveTempDataURL %>");
					debug(form);
					form.submit();
					
				});
				
			</c:if>
		
			var form = A.one('#<portlet:namespace />fm');
		
			if (form) {
				
				<c:if test="<%= Validator.isNotNull(onFormLoadScript)  %>">			
					function <portlet:namespace />onFormLoadScriptFn(form){
						try{
							<%= onFormLoadScript %>(form);
						}catch(e){}
					}
					<portlet:namespace />onFormLoadScriptFn(form);			
				</c:if>
		
				form.on(
					'submit',
					function(event) {
						debug(event, this);
						var keys = [];
		
						var fieldTypes = {};
						var fieldLabels = {};
						var fieldOptional = {};
						var fieldValidationErrorMessages = {};
						var fieldValidationFunctions = {};
						var fieldsMap = {};
		
						<%
						int i = 1;
		
						String fieldName = "field" + i;
						String fieldLabel = portletPreferences.getValue("fieldLabel" + i, StringPool.BLANK);
		
						while ((i == 1) || Validator.isNotNull(fieldLabel)) {
							String fieldType = portletPreferences.getValue("fieldType" + i, "text");
							boolean fieldOptional = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldOptional" + i, false) || fieldType.equals("hidden");
							if(fieldType.equals("paragraph") || fieldType.equals("hidden")){
								fieldOptional = true;
							}
							String fieldValidationScript = portletPreferences.getValue("fieldValidationScript" + i, StringPool.BLANK);
							String fieldValidationErrorMessage = portletPreferences.getValue("fieldValidationErrorMessage" + i, StringPool.BLANK);
							
						%>
		
							var key = "<%= fieldName %>";
							
							keys[<%= i %>] = key;
		
							fieldLabels[key] = "<%= HtmlUtil.escape(fieldLabel) %>";
							fieldTypes[key] = "<%= fieldType %>";
							
							fieldValidationErrorMessages[key] = "<%= fieldValidationErrorMessage %>";
		
							function fieldValidationFunction<%= i %>(currentFieldValue, fieldsMap, portletNamespace) {
								<c:choose>
									<c:when test="<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED && Validator.isNotNull(fieldValidationScript) %>">
										<%= fieldValidationScript %>
									</c:when>
									<c:otherwise>
										return true;
									</c:otherwise>
								</c:choose>
							};
		
							fieldOptional[key] = <%= fieldOptional %>;
							fieldValidationFunctions[key] = fieldValidationFunction<%= i %>;
		
							<c:choose>
								<c:when test='<%= fieldType.equals("radio") %>'>
									
									var radioButton = A.one('input[name=<portlet:namespace />field<%= i %>]:checked');
									fieldsMap[key] = '';
									if (radioButton) {
										fieldsMap[key] = radioButton.val();
									}
									
								</c:when>
								<c:otherwise>
									var inputField = A.one('#<portlet:namespace />field<%= i %>');
		
									fieldsMap[key] = (inputField && inputField.val()) || '';
								</c:otherwise>
							</c:choose>
		
						<%
							i++;
							fieldName = "field" + i;
							fieldLabel = portletPreferences.getValue("fieldLabel" + i, "");
						}
						%>
		
						var validationErrors = false;
						for (var i = 1; i < keys.length; i++) {
							var key = keys [i];
							var currentFieldType = fieldTypes[key];
							var currentFieldValue = fieldsMap[key];
							var optionalFieldError = A.one('#<portlet:namespace />fieldOptionalError' + key);
							var validationError = A.one('#<portlet:namespace />validationError' + key);
							var field = A.one('#<portlet:namespace />' + key);
																					
							if((field && field != null) && field.attr("disabled") == "true"){
								continue;
							}
							
							if(currentFieldType == "multiple-checkbox"){
								var currentFieldValueAux = currentFieldValue;
								var currentFieldValue = '';
								for(var j = 0; j < currentFieldValueAux; j++){
									var val = A.one('#<portlet:namespace />'+key+'_'+j).val();
									if(val == 'true'){
										currentFieldValue = val;
										break;
									}			
								}	
							}
							
							if(field && field != null){
								field.removeClass('input-error');
							}
																		
							if (!fieldOptional[key] && currentFieldValue.match(/^\s*$/) || (!fieldOptional[key] && currentFieldType == 'checkbox' && currentFieldValue == 'false')) {
								validationErrors = true;
		
								A.all('.alert-success').hide();
		
								if (optionalFieldError) {
									optionalFieldError.show();
									if(field && field != null){
										field.addClass('input-error');
									}
								}
							}
							
							else if (!fieldValidationFunctions[key](currentFieldValue, fieldsMap)) {

								validationErrors = true;
		
								A.all('.alert-success').hide();
		
								if (optionalFieldError) {
									optionalFieldError.hide();
								}
		
								if (validationError) {
									validationError.show();
									if(field && field != null){
										field.addClass('input-error');
									}
								}
							}
							else {
								if (optionalFieldError) {
									optionalFieldError.hide();
								}
		
								if (validationError) {
									validationError.hide();
								}
							}
						}
					
						function formValidationFunction(fieldsMap) {
							<c:choose>
								<c:when test="<%= Validator.isNotNull(formValidationScript) %>">
									return <%= formValidationScript %>('<portlet:namespace />', fieldsMap);
								</c:when>
								<c:otherwise>
									return true;
								</c:otherwise>
							</c:choose>
						};
						
						if (validationErrors) {
							
							event.halt();
							event.stopImmediatePropagation();
						}
					}
				);
			}
		</aui:script>
	</c:otherwise>
</c:choose>

<%!

private String getSessionMessage(HttpServletRequest request, String message) {
	
	
	
	return "";
}

%>
