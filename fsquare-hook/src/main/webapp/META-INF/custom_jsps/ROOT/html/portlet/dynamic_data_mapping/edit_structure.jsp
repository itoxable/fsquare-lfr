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

<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portlet.expando.NoSuchTableException"%>
<%@page import="com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil"%>
<%@page import="com.liferay.portlet.expando.model.ExpandoValue"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.expando.model.ExpandoRow"%>
<%@page import="com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil"%>
<%@page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.liferay.portlet.expando.model.ExpandoTable"%>
<%@page import="com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil"%>
<%@page import="com.liferay.portlet.expando.model.ExpandoColumnConstants"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@ include file="/html/portlet/dynamic_data_mapping/init.jsp" %>


<%
String redirect = ParamUtil.getString(request, "redirect");
String closeRedirect = ParamUtil.getString(request, "closeRedirect");
boolean showBackURL = ParamUtil.getBoolean(request, "showBackURL", true);

String portletResourceNamespace = ParamUtil.getString(request, "portletResourceNamespace");

DDMStructure structure = (DDMStructure)request.getAttribute(WebKeys.DYNAMIC_DATA_MAPPING_STRUCTURE);

long groupId = BeanParamUtil.getLong(structure, request, "groupId", scopeGroupId);

long parentStructureId = BeanParamUtil.getLong(structure, request, "parentStructureId", DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID);

String parentStructureName = StringPool.BLANK;

try {
	DDMStructure parentStructure = DDMStructureServiceUtil.getStructure(parentStructureId);

	parentStructureName = parentStructure.getName(locale);
}
catch (NoSuchStructureException nsee) {
}

long classNameId = PortalUtil.getClassNameId(DDMStructure.class);
long classPK = BeanParamUtil.getLong(structure, request, "structureId");
String structureKey = BeanParamUtil.getString(structure, request, "structureKey");

String script = BeanParamUtil.getString(structure, request, "xsd");

JSONArray scriptJSONArray = null;

if (Validator.isNotNull(script)) {
	if (structure != null) {
		try {
			scriptJSONArray = DDMXSDUtil.getJSONArray(structure, script);
		}
		catch (Exception e) {
			scriptJSONArray = DDMXSDUtil.getJSONArray(structure.getDocument());
		}
	}
	else {
		scriptJSONArray = DDMXSDUtil.getJSONArray(script);
	}
}

ExpandoTable expandoTable = null;
String databaseTableName = "DDMStructure_displayPage";
String structureLayoutUuid = null;

try {
	expandoTable = ExpandoTableLocalServiceUtil.getTable(themeDisplay.getCompanyId(), DDMStructure.class.getName(), databaseTableName);
	if (structure != null) {
		Object object = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), DDMStructure.class.getName(), databaseTableName, "DisplayPage", structure.getStructureId(), StringPool.BLANK);
		if(object != null){
			structureLayoutUuid = (String)object;
		}
	}
}
catch (NoSuchTableException e) {}

List<KeyValuePair> layoutsKeyValuePair = new ArrayList<KeyValuePair>();
try {
	List<Layout> layoutsTemp = LayoutLocalServiceUtil.getLayouts(themeDisplay.getDoAsGroupId(), false);
	for(Layout lay : layoutsTemp){
		if(lay.isContentDisplayPage()){
			layoutsKeyValuePair.add(new KeyValuePair(lay.getUuid(), getLayoutBreadcrumb(lay, locale)));
		}
	}
} catch (SystemException e) {
	e.printStackTrace();
} catch (Exception e) {
	e.printStackTrace();
}

%>

<portlet:actionURL var="editStructureURL">
	<portlet:param name="struts_action" value="/dynamic_data_mapping/edit_structure" />
</portlet:actionURL>

<%
String requestEditStructureURL = ParamUtil.getString(request, "editStructureURL");

if (Validator.isNotNull(requestEditStructureURL)) {
	editStructureURL = requestEditStructureURL;
}
%>

<aui:form action="<%= editStructureURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveStructure();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (structure != null) ? Constants.UPDATE : Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="closeRedirect" type="hidden" value="<%= closeRedirect %>" />
	<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
	<aui:input name="classNameId" type="hidden" value="<%= String.valueOf(classNameId) %>" />
	<aui:input name="classPK" type="hidden" value="<%= String.valueOf(classPK) %>" />
	<aui:input name="xsd" type="hidden" />
	<aui:input name="saveAndContinue" type="hidden" value="<%= false %>" />

	<liferay-ui:error exception="<%= LocaleException.class %>">

		<%
		LocaleException le = (LocaleException)errorException;
		%>

		<c:if test="<%= le.getType() == LocaleException.TYPE_CONTENT %>">
			<liferay-ui:message arguments="<%= new String[] {StringUtil.merge(le.getSourceAvailableLocales(), StringPool.COMMA_AND_SPACE), StringUtil.merge(le.getTargetAvailableLocales(), StringPool.COMMA_AND_SPACE)} %>" key="the-default-language-x-does-not-match-the-portal's-available-languages-x" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= StructureDuplicateElementException.class %>" message="please-enter-unique-structure-field-names-(including-field-names-inherited-from-the-parent-structure)" />
	<liferay-ui:error exception="<%= StructureNameException.class %>" message="please-enter-a-valid-name" />
	<liferay-ui:error exception="<%= StructureXsdException.class %>" message="please-enter-a-valid-xsd" />

	<%
	boolean localizeTitle = true;
	String title = "new-structure";

	if (structure != null) {
		localizeTitle = false;
		title = structure.getName(locale);
	}
	else {
		title = LanguageUtil.format(pageContext, "new-x", ddmDisplay.getStructureName(locale));
	}
	%>

	<liferay-ui:header
		backURL="<%= redirect %>"
		localizeTitle="<%= localizeTitle %>"
		showBackURL="<%= showBackURL %>"
		title="<%= title %>"
	/>

	<aui:model-context bean="<%= structure %>" model="<%= DDMStructure.class %>" />

	<aui:fieldset>
		<aui:field-wrapper>
			<c:if test="<%= (structure != null) && ((DDMStorageLinkLocalServiceUtil.getStructureStorageLinksCount(classPK) > 0) || (JournalArticleLocalServiceUtil.getStructureArticlesCount(groupId, structureKey) > 0)) %>">
				<div class="alert alert-warning">
					<liferay-ui:message key="there-are-content-references-to-this-structure.-you-may-lose-data-if-a-field-name-is-renamed-or-removed" />
				</div>
			</c:if>
			<c:if test="<%= (classPK > 0) && (DDMTemplateLocalServiceUtil.getTemplatesCount(groupId, classNameId, classPK) > 0) %>">
				<div class="alert alert-info">
					<liferay-ui:message key="there-are-template-references-to-this-structure.-please-update-them-if-a-field-name-is-renamed-or-removed" />
				</div>
			</c:if>
		</aui:field-wrapper>

		<aui:input name="name" />

		<liferay-ui:panel-container cssClass="lfr-structure-entry-details-container" extended="<%= false %>" id="structureDetailsPanelContainer" persistState="<%= true %>">
			<liferay-ui:panel collapsible="<%= true %>" defaultState="closed" extended="<%= false %>" id="structureDetailsSectionPanel" persistState="<%= true %>" title='<%= LanguageUtil.get(pageContext, "details") %>'>
				<aui:row cssClass="lfr-ddm-types-form-column">
					<c:choose>
						<c:when test="<%= scopeClassNameId == 0 %>">
							<aui:col width="<%= 50 %>">
								<aui:field-wrapper>
									<aui:select disabled="<%= structure != null %>" label="type" name="scopeClassNameId">
										<aui:option label="<%= ResourceActionsUtil.getModelResource(locale, DDLRecordSet.class.getName()) %>" value="<%= PortalUtil.getClassNameId(DDLRecordSet.class.getName()) %>" />
										<aui:option label="<%= ResourceActionsUtil.getModelResource(locale, DLFileEntryMetadata.class.getName()) %>" value="<%= PortalUtil.getClassNameId(DLFileEntryMetadata.class.getName()) %>" />
									</aui:select>
								</aui:field-wrapper>
							</aui:col>
						</c:when>
						<c:otherwise>
							<aui:input name="scopeClassNameId" type="hidden" value="<%= scopeClassNameId %>" />
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="<%= Validator.isNull(storageTypeValue) %>">
							<aui:col width="<%= 50 %>">
								<aui:field-wrapper>
									<aui:select disabled="<%= structure != null %>" name="storageType">

									<%
									for (StorageType storageType : StorageType.values()) {
									%>

										<aui:option label="<%= storageType %>" value="<%= storageType %>" />

									<%
									}
									%>

									</aui:select>
								</aui:field-wrapper>
							</aui:col>
						</c:when>
						<c:otherwise>
							<aui:input name="storageType" type="hidden" value="<%= storageTypeValue %>" />
						</c:otherwise>
					</c:choose>
				</aui:row>

				<c:if test="<%= !PropsValues.DYNAMIC_DATA_MAPPING_STRUCTURE_FORCE_AUTOGENERATE_KEY %>">
					<aui:input disabled="<%= (structure != null) ? true : false %>" label='<%= LanguageUtil.format(pageContext, "x-key", ddmDisplay.getStructureName(locale), false) %>' name="structureKey" />
				</c:if>

				<aui:input name="description" />

				<aui:field-wrapper label='<%= LanguageUtil.format(pageContext, "parent-x", ddmDisplay.getStructureName(locale)) %>'>
					<aui:input name="parentStructureId" type="hidden" value="<%= parentStructureId %>" />

					<div class="input-append">
						<c:choose>
							<c:when test="<%= (structure == null) || Validator.isNotNull(parentStructureId) %>">
								<portlet:renderURL var="parentStructureURL">
									<portlet:param name="struts_action" value="/dynamic_data_mapping/edit_structure" />
									<portlet:param name="redirect" value="<%= currentURL %>" />
									<portlet:param name="groupId" value="<%= String.valueOf(scopeGroupId) %>" />
									<portlet:param name="classNameId" value="<%= String.valueOf(classNameId) %>" />
									<portlet:param name="classPK" value="<%= String.valueOf(parentStructureId) %>" />
								</portlet:renderURL>

								<liferay-ui:input-resource id="parentStructureName" url="<%= HtmlUtil.escape(parentStructureName) %>" />
							</c:when>
							<c:otherwise>
								<liferay-ui:input-resource id="parentStructureName" url="" />
							</c:otherwise>
						</c:choose>

						<aui:button onClick='<%= renderResponse.getNamespace() + "openParentStructureSelector();" %>' value="select" />

						<aui:button name="removeParentStructureButton" onClick='<%= renderResponse.getNamespace() + "removeParentStructure();" %>' value="remove" />
					</div>
				</aui:field-wrapper>
				
				<aui:field-wrapper label='default-display-page' >
				
					<fieldset <%= structure == null?"disabled":StringPool.BLANK %> >
						<div class="form-inline priority-set-wrapper">
							
							<aui:select label="" name="displayPage" >
								<aui:option value='' >Select...</aui:option>
								<%
								for (KeyValuePair keyValuePair : layoutsKeyValuePair) {
								%>
									<aui:option selected='<%= keyValuePair.getKey().equals(structureLayoutUuid) %>' value='<%= keyValuePair.getKey()%>' >
										<%= keyValuePair.getValue() %>
									</aui:option>
								<%
								}
								%>
							</aui:select>
							
							<button <%= structure == null?"disabled":StringPool.BLANK %> type="button" class="btn btn-primary" id="<portlet:namespace />display_page_button">Set Display Page</button>
							<div class="priority-result-message" style="margin-left: 0;">
								<span class="alert"></span>
							</div>
						</div>
					</fieldset>	
				
				</aui:field-wrapper>
				

				<c:if test="<%= structure != null %>">
					<aui:field-wrapper label="url">
						<liferay-ui:input-resource url='<%= themeDisplay.getPortalURL() + themeDisplay.getPathMain() + "/dynamic_data_mapping/get_structure?structureId=" + classPK %>' />
					</aui:field-wrapper>

					<c:if test="<%= Validator.isNotNull(refererWebDAVToken) %>">
						<aui:field-wrapper label="webdav-url">
							<liferay-ui:input-resource url="<%= structure.getWebDavURL(themeDisplay, refererWebDAVToken) %>" />
						</aui:field-wrapper>
					</c:if>
				</c:if>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</aui:fieldset>
</aui:form>

<%@ include file="/html/portlet/dynamic_data_mapping/form_builder.jspf" %>

<aui:button-row>
	<aui:button onClick='<%= renderResponse.getNamespace() + "saveStructure();" %>' primary="<%= true %>" value='<%= LanguageUtil.get(pageContext, "save") %>' />

	<aui:button href="<%= redirect %>" type="cancel" />
</aui:button-row>

<aui:script>
	function <portlet:namespace />openParentStructureSelector() {
		Liferay.Util.openDDMPortlet(
			{
				basePortletURL: '<%= PortletURLFactoryUtil.create(request, PortletKeys.DYNAMIC_DATA_MAPPING, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>',
				classPK: <%= (structure != null) ? structure.getPrimaryKey() : 0 %>,
				dialog: {
					destroyOnHide: true
				},
				eventName: '<portlet:namespace />selectParentStructure',
				showGlobalScope: true,
				showManageTemplates: false,
				struts_action: '/dynamic_data_mapping/select_structure',
				title: '<%= HtmlUtil.escapeJS(scopeTitle) %>'
			},
			function(event) {
				var A = AUI();

				document.<portlet:namespace />fm.<portlet:namespace />parentStructureId.value = event.ddmstructureid;

				var nameEl = document.getElementById('<portlet:namespace />parentStructureName');

				nameEl.href = '<portlet:renderURL><portlet:param name="struts_action" value="/dynamic_data_mapping/edit_structure" /><portlet:param name="redirect" value="<%= currentURL %>" /><portlet:param name="groupId" value="<%= String.valueOf(scopeGroupId) %>" /><portlet:param name="classNameId" value="<%= String.valueOf(classNameId) %>" /></portlet:renderURL>&<portlet:namespace />classPK=' + event.ddmstructureid;

				nameEl.value = A.Lang.String.unescapeEntities(event.name);

				document.getElementById('<portlet:namespace />removeParentStructureButton').disabled = false;
			}
		);
	}

	function <portlet:namespace />removeParentStructure() {
		document.<portlet:namespace />fm.<portlet:namespace />parentStructureId.value = '';

		var nameEl = document.getElementById('<portlet:namespace />parentStructureName');

		nameEl.href = '#';
		nameEl.value = '';

		document.getElementById('<portlet:namespace />removeParentStructureButton').disabled = true;
	}
</aui:script>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />saveStructure',
		function() {
			document.<portlet:namespace />fm.<portlet:namespace />xsd.value = window.<portlet:namespace />formBuilder.getContentXSD();

			submitForm(document.<portlet:namespace />fm);
		},
		['aui-base', 'liferay-portlet-dynamic-data-mapping']
	);
</aui:script>

<liferay-portlet:resourceURL var="changeDisplayPageURL" >
	<portlet:param name="struts_action" value="/dynamic_data_mapping/structure_display_page" />
</liferay-portlet:resourceURL>

<aui:script use="aui-base,selector-css3,aui-io-request">
	
	var button = A.one('#<portlet:namespace />display_page_button');
	button.on('click', function(event) {
		<portlet:namespace />changeDisplayPage();
	});

	Liferay.provide(window, '<portlet:namespace />changeDisplayPage',
		function() {
			var input = A.one('#<portlet:namespace />displayPage');
			
			var prioritySetWrapper = A.one('.priority-set-wrapper');
			prioritySetWrapper.removeClass('error');
			prioritySetWrapper.removeClass('success');
		
			var alert = prioritySetWrapper.one('.alert');
			alert.set('text', '');
			
        	A.io.request('<%= changeDisplayPageURL %>',{
                  dataType: 'json',
                  method: 'POST',
                  data: {
                  	<portlet:namespace />structureId: '<%= structure==null?"":structure.getStructureId() %>',
                  	<portlet:namespace />displayPageUuid: input.val()
                  },
                  on: {
                      success: function() {
                      	var response = this.get('responseData');
                      	alert.set('text', response.message)
                      	if(response.success){
                      		console.log(response.success);
                      		prioritySetWrapper.addClass('success');                      		
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

<%!

public String getLayoutBreadcrumb(Layout layout, Locale locale) throws Exception {
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