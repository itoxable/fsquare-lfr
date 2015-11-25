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

<%@ include file="/init.jsp" %>

<%
int index = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-index")));
if(index == 0){
	Random randomGenerator = new Random();
	index = randomGenerator.nextInt(1000) + 1000;
}		 

int formFieldsIndex = GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-formFieldsIndex"));
if(formFieldsIndex == 0){
	formFieldsIndex = index;
}

boolean fieldsEditingDisabled = GetterUtil.getBoolean((String)request.getAttribute("configuration.jsp-fieldsEditingDisabled"));
String fieldLabelXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "fieldLabel" + formFieldsIndex);
String fieldLabel = LocalizationUtil.getLocalization(fieldLabelXml, themeDisplay.getLanguageId());
String fieldType = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldType" + formFieldsIndex);
if(Validator.isNull(fieldType)){
	fieldType = "text";
}
String fieldPlaceHolderXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "fieldPlaceHolder" + formFieldsIndex);
String fieldPlaceHolder = LocalizationUtil.getLocalization(fieldPlaceHolderXml, themeDisplay.getLanguageId());

boolean fieldOptional = PrefsParamUtil.getBoolean(portletPreferences, renderRequest, "fieldOptional" + formFieldsIndex);
boolean isAckEmail = PrefsParamUtil.getBoolean(portletPreferences, renderRequest, "isAckEmail" + formFieldsIndex);

String fieldValue = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldValue" + formFieldsIndex);

boolean fieldReadOnly = PrefsParamUtil.getBoolean(portletPreferences, renderRequest, "fieldReadOnly" + formFieldsIndex);
String fieldOptionsXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "fieldOptions" + formFieldsIndex);

String fieldBlankOptionXml = LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "fieldBlankOption" + formFieldsIndex);

String fieldOptions = LocalizationUtil.getLocalization(fieldOptionsXml, themeDisplay.getLanguageId());
String fieldBlankOption = LocalizationUtil.getLocalization(fieldBlankOptionXml, themeDisplay.getLanguageId());

String fieldValidationScript = PrefsParamUtil.getString(portletPreferences, request, "fieldValidationScript" + formFieldsIndex);
String fieldOnSelectScript = PrefsParamUtil.getString(portletPreferences, request, "fieldOnSelectScript" + formFieldsIndex);

String fieldValidationErrorMessage = PrefsParamUtil.getString(portletPreferences, request, "fieldValidationErrorMessage" + formFieldsIndex);

boolean ignoreRequestValue = (index != formFieldsIndex);

String fieldStyle = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldStyle" + formFieldsIndex);
String fieldStyleClass = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldStyleClass" + formFieldsIndex);
String fieldWrapperStyle = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldWrapperStyle" + formFieldsIndex);
String fieldWrapperStyleClass = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldWrapperStyleClass" + formFieldsIndex);


boolean countrySelect = PrefsParamUtil.getBoolean(portletPreferences, renderRequest, "countrySelect" + formFieldsIndex);

String onAddressSelect = PrefsParamUtil.getString(portletPreferences, renderRequest, "onAddressSelect" + formFieldsIndex);
String fieldDataHelper = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldDataHelper" + formFieldsIndex);

String fieldName = PrefsParamUtil.getString(portletPreferences, renderRequest, "fieldName" + formFieldsIndex);

%>

<liferay-ui:error key='<%= "fieldSizeInvalid" + formFieldsIndex %>' message="please-enter-no-more-than-75-characters" />

<c:if test="<%= !fieldsEditingDisabled %>">
	<aui:input name='<%= "_field" + index %>' type="hidden" />
</c:if>

<div class="field-row field-row">
	<div class="field-title">
		<c:choose>
			<c:when test='<%= fieldType.equals("paragraph") %>'>
				<span class="field-label">fieldOptions</span>
			</c:when>
			<c:when test="<%= Validator.isNotNull(fieldLabel) %>">
				<span class="field-label"><%= fieldLabel %></span>
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="new-item" />
			</c:otherwise>
		</c:choose>
	</div>


	<div class='name-div <%= fieldType.equals("paragraph")?"hide":StringPool.BLANK %>' >
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="name" />
			</dt>
			<dd>
				<c:choose>
					<c:when test="<%= !fieldsEditingDisabled %>">
						<aui:field-wrapper cssClass="label-name" label="">
							<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldLabel" + index %>' xml="<%= fieldLabelXml %>" />
						</aui:field-wrapper>	
					</c:when>
					<c:otherwise>
			
						<%= fieldLabel %>
					</c:otherwise>
				</c:choose>
			</dd>
		</dl>
	</div>	
	
	<div>
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="type" />
			</dt>
			<dd>
				<c:choose>
					<c:when test="<%= !fieldsEditingDisabled %>">
						<aui:select ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldType" + index %>'>
							<aui:option selected='<%= fieldType.equals("text") %>' value="text"><liferay-ui:message key="text" /></aui:option>
							<aui:option selected='<%= fieldType.equals("tel") %>' value="tel"><liferay-ui:message key="telephone" /></aui:option>
							<aui:option selected='<%= fieldType.equals("textarea") %>' value="textarea"><liferay-ui:message key="text-box" /></aui:option>
							<aui:option selected='<%= fieldType.equals("options") %>' value="options"><liferay-ui:message key="options" /></aui:option>
							<aui:option selected='<%= fieldType.equals("radio") %>' value="radio"><liferay-ui:message key="radio-buttons" /></aui:option>
							<aui:option selected='<%= fieldType.equals("paragraph") %>' value="paragraph"><liferay-ui:message key="paragraph" /></aui:option>
							<aui:option selected='<%= fieldType.equals("checkbox") %>' value="checkbox"><liferay-ui:message key="check-box" /></aui:option>
							<aui:option selected='<%= fieldType.equals("multiple-checkbox") %>' value="multiple-checkbox"><liferay-ui:message key="multiple-checkbox" /></aui:option>
							<aui:option selected='<%= fieldType.equals("uprn") %>' value="uprn"><liferay-ui:message key="uprn" /></aui:option>
							<aui:option selected='<%= fieldType.equals("postcode") %>' value="postcode"><liferay-ui:message key="postcode" /></aui:option>
							<aui:option selected='<%= fieldType.equals("fileupload") %>' value="fileupload" label="File Upload"></aui:option>
							<aui:option selected='<%= fieldType.equals("date") %>' value="date"><liferay-ui:message key="date" /></aui:option>
							<aui:option selected='<%= fieldType.equals("email") %>' value="email"><liferay-ui:message key="email" /></aui:option>
							<aui:option selected='<%= fieldType.equals("dateTime") %>' value="dateTime"><liferay-ui:message key="Date and Time" /></aui:option>
							<aui:option selected='<%= fieldType.equals("richText") %>' value="richText"><liferay-ui:message key="Rich Text" /></aui:option>
							<aui:option selected='<%= fieldType.equals("hidden") %>' value="hidden"><liferay-ui:message key="Hidden" /></aui:option>
							
						</aui:select>
					</c:when>
					<c:otherwise>
						
						<c:choose>
							<c:when test='<%=  fieldType.equals("text") || fieldType.equals("tel") || fieldType.equals("textarea") || fieldType.equals("options") || fieldType.equals("radio") || fieldType.equals("checkbox") || fieldType.equals("multiple-checkbox") || fieldType.equals("uprn") || fieldType.equals("postcode") || fieldType.equals("email") %>'>
								<aui:select ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldType" + index %>'>
									<aui:option selected='<%= fieldType.equals("text") %>' value="text"><liferay-ui:message key="text" /></aui:option>
									<aui:option selected='<%= fieldType.equals("tel") %>' value="tel"><liferay-ui:message key="telephone" /></aui:option>
									<aui:option selected='<%= fieldType.equals("textarea") %>' value="textarea"><liferay-ui:message key="text-box" /></aui:option>
									<aui:option selected='<%= fieldType.equals("options") %>' value="options"><liferay-ui:message key="options" /></aui:option>
									<aui:option selected='<%= fieldType.equals("radio") %>' value="radio"><liferay-ui:message key="radio-buttons" /></aui:option>
									<aui:option selected='<%= fieldType.equals("checkbox") %>' value="checkbox"><liferay-ui:message key="check-box" /></aui:option>
									<aui:option selected='<%= fieldType.equals("multiple-checkbox") %>' value="multiple-checkbox"><liferay-ui:message key="multiple-checkbox" /></aui:option>
									<aui:option selected='<%= fieldType.equals("uprn") %>' value="uprn"><liferay-ui:message key="uprn" /></aui:option>
									<aui:option selected='<%= fieldType.equals("postcode") %>' value="postcode"><liferay-ui:message key="postcode" /></aui:option>
									<aui:option selected='<%= fieldType.equals("email") %>' value="email"><liferay-ui:message key="email" /></aui:option>
								</aui:select>
							</c:when>
							<c:otherwise>
								<liferay-ui:message key="<%= fieldType %>" />
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				
				</c:choose>
			</dd>
		</dl>
	</div>
	
	<div class='<%= "is-ack-email " + (!fieldType.equals("email") ? " hide" : StringPool.BLANK) %>'>
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="is-ack-email" />
			</dt>
			<dd>
				<aui:input cssClass="is-ack-email-control" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "isAckEmail" + index %>' type="checkbox" value="<%= isAckEmail %>" />
			</dd>
		</dl>
	</div>
	
	<div class=' optional <%= (fieldType.equals("paragraph") || fieldType.equals("hidden"))?"hide":StringPool.BLANK %>' >
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="optional" />
			</dt>
			<dd>
				<aui:input cssClass="optional-control" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldOptional" + index %>' type="checkbox" value="<%= fieldOptional %>" />
			</dd>
		</dl>
	</div>
	
	<div class='field-value <%= !fieldType.equals("hidden")?"hide":StringPool.BLANK %>' >
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="field-value" />
			</dt>
			<dd>
				<aui:input cssClass="optional-control" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldValue" + index %>' value="<%= fieldValue %>" />
			</dd>
		</dl>
	</div>
	
	<div class='<%= "field-placeholder " + ((Validator.isNull(fieldType) || (!fieldType.equals("text") || !fieldType.equals("uprn") || !fieldType.equals("postcode")  || !fieldType.equals("tel")  && !fieldType.equals("textarea") && !fieldType.equals("email"))) ? " hide" : StringPool.BLANK) %>'>
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="Placeholder" />
			</dt>
			<dd>
				<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldPlaceHolder" + index %>' xml="<%= fieldPlaceHolderXml %>" />
			</dd>
		</dl>
	</div>
	
	
	<div class='<%= "on-address-select-script " + ((Validator.isNull(fieldType) || !fieldType.equals("uprn") || !fieldType.equals("postcode")) ? " hide" : StringPool.BLANK) %>'>
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="on-address-select-script" />
			</dt>
			<dd>
				<aui:input cssClass="on-address-select-script" style="width: 70%; height: 130px" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "onAddressSelect" + index %>' type="textarea" value="<%= onAddressSelect %>" />
			</dd>
		</dl>
	</div>
	
	
	<div class='<%= "options" + ((Validator.isNull(fieldType) || (!fieldType.equals("options") && !fieldType.equals("paragraph") && !fieldType.equals("radio") && !fieldType.equals("multiple-checkbox"))) ? " hide" : StringPool.BLANK) %>'>
		<dl class="editing-disabled">
			<dt>
				<liferay-ui:message key="options" />
			</dt>
			<dd>
				<liferay-ui:input-localized  style="width: 70%" ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldOptions" + index %>' xml="<%= fieldOptionsXml %>" />

				<c:if test='<%= fieldType.equals("options") %>'>
					<dl class="editing-disabled">
						<dt>
							<liferay-ui:message key="blank-option" />
						</dt>
						<dd>
							<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldBlankOption" + index %>' xml="<%= fieldBlankOptionXml %>" />
						</dd>
					</dl>
				</c:if>
				
				<div class='available-lists <%= fieldType.equals("paragraph")? " hide" : StringPool.BLANK %>' style="margin-top: 10px;">
					<aui:input style="line-height: 10px;" cssClass="country-select" label="country-select" name='<%= "countrySelect" + index %>' type="checkbox" value="<%= countrySelect %>" data-helper="<%= index %>"/>
				</divf>
			</dd>
		</dl>
	</div>
	
	<div class="advanced-settings">
		<aui:a cssClass="advanced-settings-link" href="javascript:;"><liferay-ui:message key="advanced-settings" /> &raquo;</aui:a>
		
		<div class='advanced-settings-wrapper hide'>
		
			<div class='<%= ((Validator.isNull(fieldType) || (fieldType.equals("paragraph") )) ? " hide" : StringPool.BLANK) %>'>
				<dl class="editing-disabled">
					<dt>
						<liferay-ui:message key="field-data-helper" />
					</dt>
					<dd>
						<aui:input cssClass="field-data-helper" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldDataHelper" + index %>' value="<%= fieldDataHelper %>" wrap="off" />
					</dd>
				</dl>
			</div>
			
			
			
			<div class='<%= ((Validator.isNull(fieldType) || (fieldType.equals("paragraph") )) ? " hide" : StringPool.BLANK) %>'>
				<dl class="editing-disabled">
					<dt>
						<liferay-ui:message key="field-name" />
					</dt>
					<dd>
						<aui:input cssClass="field-name" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldName" + index %>' value="<%= fieldName %>" wrap="off" />
					</dd>
				</dl>
			</div>
			
			
		
			<div class='<%= "field-onselect-script" + ((Validator.isNull(fieldType) || (!fieldType.equals("options") && !fieldType.equals("uprn") && !fieldType.equals("postcode") && !fieldType.equals("radio") && !fieldType.equals("checkbox") && !fieldType.equals("multiple-checkbox"))) ? " hide" : StringPool.BLANK) %>'>
				<dl class="editing-disabled">
					<dt>
						<liferay-ui:message key="field-onselect-script"  />
					</dt>
					<dd>
						<aui:input cols="80" cssClass="onselect-script" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldOnSelectScript" + index %>' style="width: 70%; height: 130px" type="textarea" value="<%= fieldOnSelectScript %>" wrap="off" />
					</dd>
				</dl>
			</div>
			
			<div class='field-style-input'>
				<span class="advanced-settings-label"> <liferay-ui:message key="field-style" />:</span>
				 
				<div style="margin-left: 50px">
					<dl class="editing-disabled">
						<dt>
							<liferay-ui:message key="field-wrapper-style" />
						</dt>
						<dd>
							<aui:input cols="80" cssClass="field-wrapper-style" label="" name='<%= "fieldWrapperStyle" + index %>' style="width: 50%" type="text" value="<%= fieldWrapperStyle %>" />
						</dd>
						
						<dt>
							<liferay-ui:message key="field-wrapper-style-class" />
						</dt>
						<dd>
							<aui:input cols="80" cssClass="field-wrapper-style-class" label="" name='<%= "fieldWrapperStyleClass" + index %>' style="width: 50%" type="text" value="<%= fieldWrapperStyleClass %>" />
						</dd>
						
						<dt>
							<liferay-ui:message key="field-style" />
						</dt>
						<dd>
							<aui:input cols="80" cssClass="field-style" label="" name='<%= "fieldStyle" + index %>' style="width: 50%" type="text" value="<%= fieldStyle %>"  />
						</dd>
						
						<dt>
							<liferay-ui:message key="field-style-class" />
						</dt>
						<dd>
							<aui:input cols="80" cssClass="field-style-class" label="" name='<%= "fieldStyleClass" + index %>' style="width: 50%" type="text" value="<%= fieldStyleClass %>"  />
						</dd>
					</dl>
				</div>
			</div>
			
			
			<div class="validation">
				<liferay-ui:error key='<%= "validationDefinitionInvalid" + index %>' message="please-enter-both-the-validation-code-and-the-error-message" />
		
				<span class="advanced-settings-label"> <liferay-ui:message key="validation" />:</span>
		
				<div class='validation-input' style="margin-left: 50px">
					<div>
						<dl class="editing-disabled">
							<dt>
								<liferay-ui:message key="validation-script" />
							</dt>
							<dd>								
								<aui:column columnWidth="50">
									<aui:input cols="80" cssClass="validation-script" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldValidationScript" + index %>' style="width: 100%; height: 130px" type="textarea" value="<%= fieldValidationScript %>" wrap="off" />
								</aui:column>
								<aui:column columnWidth="40">
									<div class="syntax-help" style="margin-left: 10px">
										<liferay-util:include page="/script_help.jsp" servletContext="<%= application %>" />
									</div>
								</aui:column>
								<div style="clear: both;"></div>
							</dd>
						
							<dt>
								<liferay-ui:message key="validation-error-message" />
							</dt>
							<dd>								
								<aui:input cols="80" cssClass="lfr-input-text-container" ignoreRequestValue="<%= ignoreRequestValue %>" label="" name='<%= "fieldValidationErrorMessage" + index %>' size="80" value="<%= fieldValidationErrorMessage %>" />
							</dd>
						</dl>
					</div>
				</div>
			</div>
			
		</div>
	
	</div>
	

</div>