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

package com.liferay.webform.action;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.webform.util.WebFormUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Jorge Ferrer
 * @author Alberto Montero
 * @author Julio Camarero
 * @author Brian Wing Shun Chan
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	
	public final static String PREFERENCES_STORED = "preferences.storeD";
	
	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		validateFields(actionRequest);

		if (!SessionErrors.isEmpty(actionRequest)) {
			return;
		}

		Locale defaultLocale = LocaleUtil.getDefault();
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		boolean updateFields = ParamUtil.getBoolean(actionRequest, "updateFields");

		String portletResource = ParamUtil.getString(actionRequest, "portletResource");

		PortletPreferences preferences = actionRequest.getPreferences();
		//System.out.println("-successURL: "+preferences.getValue("successURL", StringPool.BLANK));
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "successMessage");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "submitButtonLabel");
		
		if (updateFields) {
			int i = 1;
			String databaseTableName = WebFormUtil.getNewDatabaseTableName(portletResource);
			preferences.setValue("databaseTableName", databaseTableName);
			
			
			LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
			LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");
		
		
			int[] formFieldsIndexes = StringUtil.split(ParamUtil.getString(actionRequest, "formFieldsIndexes"), 0);

			for (int formFieldsIndex : formFieldsIndexes) {
				Map<Locale, String> fieldLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel" + formFieldsIndex);

				if (Validator.isNull(fieldLabelMap.get(defaultLocale))) {
					continue;
				}

				String fieldType = ParamUtil.getString(actionRequest, "fieldType" + formFieldsIndex);
				
				boolean fieldOptional = ParamUtil.getBoolean(actionRequest, "fieldOptional" + formFieldsIndex);
				boolean isAckEmail = ParamUtil.getBoolean(actionRequest, "isAckEmail" + formFieldsIndex);
				
				if(fieldType.equals("paragraph") || fieldType.equals("hidden")){
					fieldOptional = true;
				}
				
				String fieldValidationScript = ParamUtil.getString(actionRequest, "fieldValidationScript" + formFieldsIndex);
				
				Map<Locale, String> fieldOptionsMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldOptions" + formFieldsIndex);
				Map<Locale, String> fieldBlankOptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldBlankOption" + formFieldsIndex);
				Map<Locale, String> fieldPlaceHolderMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldPlaceHolder" + formFieldsIndex);
				
				String fieldOnSelectScript = ParamUtil.getString(actionRequest, "fieldOnSelectScript" + formFieldsIndex);
				String fieldValue = ParamUtil.getString(actionRequest, "fieldValue" + formFieldsIndex);
				String fieldName = ParamUtil.getString(actionRequest, "fieldName" + formFieldsIndex);				
				String fieldValidationErrorMessage = ParamUtil.getString(actionRequest, "fieldValidationErrorMessage" + formFieldsIndex);
				boolean fieldReadOnly = ParamUtil.getBoolean(actionRequest, "fieldReadOnly" + formFieldsIndex);
				String fieldStyle = ParamUtil.getString(actionRequest, "fieldStyle" + formFieldsIndex);
				String fieldStyleClass = ParamUtil.getString(actionRequest, "fieldStyleClass" + formFieldsIndex);
				String fieldWrapperStyle = ParamUtil.getString(actionRequest, "fieldWrapperStyle" + formFieldsIndex);
				String fieldWrapperStyleClass = ParamUtil.getString(actionRequest, "fieldWrapperStyleClass" + formFieldsIndex);
				String fieldDataHelper = ParamUtil.getString(actionRequest, "fieldDataHelper" + formFieldsIndex);
				String onAddressSelect = ParamUtil.getString(actionRequest, "onAddressSelect" + formFieldsIndex);
				
				if (Validator.isNotNull(fieldValidationScript) ^ Validator.isNotNull(fieldValidationErrorMessage)) {
					SessionErrors.add(actionRequest, "validationDefinitionInvalid" + i);
				}

				boolean countrySelect = ParamUtil.getBoolean(actionRequest, "countrySelect" + formFieldsIndex);
				
				updateModifiedLocales("fieldLabel" + i, fieldLabelMap, preferences);
				updateModifiedLocales("fieldOptions" + i, fieldOptionsMap, preferences);
				updateModifiedLocales("fieldBlankOption" + i, fieldBlankOptionMap, preferences);
				updateModifiedLocales("fieldPlaceHolder" + i, fieldPlaceHolderMap, preferences);
				
				preferences.setValue("fieldType" + i, fieldType);
				preferences.setValue("fieldOptional" + i, String.valueOf(fieldOptional));
				preferences.setValue("isAckEmail" + i, String.valueOf(isAckEmail));
				
				preferences.setValue("fieldValidationScript" + i, fieldValidationScript);
				preferences.setValue("fieldOnSelectScript" + i, fieldOnSelectScript);
				preferences.setValue("fieldValue" + i, fieldValue);
				preferences.setValue("fieldName" + i, fieldName);
				preferences.setValue("fieldValidationErrorMessage" + i, fieldValidationErrorMessage);
				preferences.setValue("fieldReadOnly" + i, String.valueOf(fieldReadOnly));
				preferences.setValue("fieldStyle" + i, fieldStyle);
				preferences.setValue("fieldStyleClass" + i, fieldStyleClass);
				preferences.setValue("fieldWrapperStyle" + i, fieldWrapperStyle);
				preferences.setValue("fieldWrapperStyleClass" + i, fieldWrapperStyleClass);					
				preferences.setValue("fieldDataHelper" + i, fieldDataHelper);
				preferences.setValue("onAddressSelect" + i, onAddressSelect);
									
				preferences.setValue("countrySelect" + i, String.valueOf(countrySelect));
								
				i++;

			}
			
			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

			// Clear previous preferences that are now blank

			String fieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, defaultLanguageId);

			while (Validator.isNotNull(fieldLabel)) {
				Map<Locale, String> fieldLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel" + i);

				for (Locale locale : fieldLabelMap.keySet()) {
					String languageId = LocaleUtil.toLanguageId(locale);
					LocalizationUtil.setPreferencesValue(preferences, "fieldLabel" + i, languageId, StringPool.BLANK);
					LocalizationUtil.setPreferencesValue(preferences, "fieldOptions" + i, languageId, StringPool.BLANK);
					LocalizationUtil.setPreferencesValue(preferences, "fieldBlankOption" + i, languageId, StringPool.BLANK);
					LocalizationUtil.setPreferencesValue(preferences, "fieldPlaceHolder" + i, languageId, StringPool.BLANK);
				}
								
				preferences.setValue("fieldType" + i, StringPool.BLANK);
				preferences.setValue("fieldOptional" + i, StringPool.BLANK);
				preferences.setValue("isAckEmail" + i, StringPool.BLANK);
				preferences.setValue("fieldValue" + i, StringPool.BLANK);
				preferences.setValue("fieldName" + i, StringPool.BLANK);
				preferences.setValue("fieldValidationScript" + i, StringPool.BLANK);
				preferences.setValue("fieldOnSelectScript" + i, StringPool.BLANK);
				preferences.setValue("fieldValidationErrorMessage" + i, StringPool.BLANK);

				preferences.setValue("fieldReadOnly" + i, StringPool.BLANK);
				preferences.setValue("fieldStyle" + i, StringPool.BLANK);
				preferences.setValue("fieldStyleClass" + i, StringPool.BLANK);
				preferences.setValue("fieldWrapperStyleClass" + i, StringPool.BLANK);
				preferences.setValue("fieldWrapperStyle" + i, StringPool.BLANK);
				preferences.setValue("fieldDataHelper" + i, StringPool.BLANK);
				preferences.setValue("onAddressSelect" + i, StringPool.BLANK);
				
				preferences.setValue("countrySelect" + i, StringPool.BLANK);
				
				i++;

				fieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, defaultLanguageId);
			}
			
		}else{
			
			LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
			LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");
			int[] formFieldsIndexes = StringUtil.split(ParamUtil.getString(actionRequest, "formFieldsIndexes"), 0);

			
			for (int formFieldsIndex : formFieldsIndexes) {

				Map<Locale, String> fieldPlaceHolderMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldPlaceHolder" + formFieldsIndex);
				String fieldType = ParamUtil.getString(actionRequest, "fieldType" + formFieldsIndex);
				boolean fieldOptional = ParamUtil.getBoolean(actionRequest, "fieldOptional" + formFieldsIndex);
				boolean isAckEmail = ParamUtil.getBoolean(actionRequest, "isAckEmail" + formFieldsIndex);
				
				if(fieldType.equals("paragraph") || fieldType.equals("hidden")){
					fieldOptional = true;
				}
				
				String fieldValidationScript = ParamUtil.getString(actionRequest, "fieldValidationScript" + formFieldsIndex);
				String fieldOnSelectScript = ParamUtil.getString(actionRequest, "fieldOnSelectScript" + formFieldsIndex);
				String fieldValue = ParamUtil.getString(actionRequest, "fieldValue" + formFieldsIndex);
				String fieldName = ParamUtil.getString(actionRequest, "fieldName" + formFieldsIndex);
				String fieldValidationErrorMessage = ParamUtil.getString(actionRequest, "fieldValidationErrorMessage" + formFieldsIndex);
				boolean fieldReadOnly = ParamUtil.getBoolean(actionRequest, "fieldReadOnly" + formFieldsIndex);
				String fieldStyle = ParamUtil.getString(actionRequest, "fieldStyle" + formFieldsIndex);
				String fieldStyleClass = ParamUtil.getString(actionRequest, "fieldStyleClass" + formFieldsIndex);
				String fieldWrapperStyle = ParamUtil.getString(actionRequest, "fieldWrapperStyle" + formFieldsIndex);
				String fieldWrapperStyleClass = ParamUtil.getString(actionRequest, "fieldWrapperStyleClass" + formFieldsIndex);
				String fieldDataHelper = ParamUtil.getString(actionRequest, "fieldDataHelper" + formFieldsIndex);
				String onAddressSelect = ParamUtil.getString(actionRequest, "onAddressSelect" + formFieldsIndex);
				
				if (Validator.isNotNull(fieldValidationScript) ^ Validator.isNotNull(fieldValidationErrorMessage)) {

					SessionErrors.add(actionRequest, "validationDefinitionInvalid" + formFieldsIndex);
				}
				
				boolean countrySelect = ParamUtil.getBoolean(actionRequest, "countrySelect" + formFieldsIndex);

				preferences.setValue("fieldOptional" + formFieldsIndex, String.valueOf(fieldOptional));
				preferences.setValue("isAckEmail" + formFieldsIndex, String.valueOf(isAckEmail));
				preferences.setValue("fieldValidationScript" + formFieldsIndex, fieldValidationScript);
				preferences.setValue("fieldOnSelectScript" + formFieldsIndex, fieldOnSelectScript);
				preferences.setValue("fieldValue" + formFieldsIndex, fieldValue);
				preferences.setValue("fieldName" + formFieldsIndex, fieldName);
				preferences.setValue("fieldValidationErrorMessage" + formFieldsIndex, fieldValidationErrorMessage);
				preferences.setValue("fieldReadOnly" + formFieldsIndex, String.valueOf(fieldReadOnly));
				preferences.setValue("fieldStyle" + formFieldsIndex, String.valueOf(fieldStyle));
				preferences.setValue("fieldStyleClass" + formFieldsIndex, String.valueOf(fieldStyleClass));
				preferences.setValue("fieldDataHelper" + formFieldsIndex, String.valueOf(fieldDataHelper));
				preferences.setValue("onAddressSelect" + formFieldsIndex, String.valueOf(onAddressSelect));
				preferences.setValue("fieldWrapperStyle" + formFieldsIndex, String.valueOf(fieldWrapperStyle));
				preferences.setValue("fieldWrapperStyleClass" + formFieldsIndex, String.valueOf(fieldWrapperStyleClass));
				preferences.setValue("countrySelect" + formFieldsIndex, String.valueOf(countrySelect));

				updateModifiedLocales("fieldPlaceHolder" + formFieldsIndex, fieldPlaceHolderMap, preferences);
				
			}

		}
			

		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.setValue(ConfigurationActionImpl.PREFERENCES_STORED, ConfigurationActionImpl.PREFERENCES_STORED);
			preferences.store();
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

		if (cmd.equals(Constants.ADD)) {
			return "/edit_field.jsp";
		}
		else {
			return "/configuration.jsp";
		}
	}

	protected void updateModifiedLocales(
			String parameter, Map<Locale, String> newLocalizationMap,
			PortletPreferences preferences)
		throws Exception {

		Map<Locale, String> oldLocalizationMap =
			LocalizationUtil.getLocalizationMap(preferences, parameter);

		List<Locale> modifiedLocales = LocalizationUtil.getModifiedLocales(
			oldLocalizationMap, newLocalizationMap);

		for (Locale locale : modifiedLocales) {
			String languageId = LocaleUtil.toLanguageId(locale);
			String value = newLocalizationMap.get(locale);

			LocalizationUtil.setPreferencesValue(
				preferences, parameter, languageId, value);
		}
	}

	protected void validateFields(ActionRequest actionRequest)
		throws Exception {

		Locale defaultLocale = LocaleUtil.getDefault();
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		boolean sendAsEmail = GetterUtil.getBoolean(
			getParameter(actionRequest, "sendAsEmail"));
		String subject = getParameter(actionRequest, "subject");

		boolean saveToDatabase = GetterUtil.getBoolean(
			getParameter(actionRequest, "saveToDatabase"));

		boolean saveToFile = GetterUtil.getBoolean(
			getParameter(actionRequest, "saveToFile"));

		if (!sendAsEmail && !saveToDatabase && !saveToFile) {
			SessionErrors.add(actionRequest, "handlingRequired");
		}

		if (sendAsEmail) {
			if (Validator.isNull(subject)) {
				SessionErrors.add(actionRequest, "subjectRequired");
			}

			String[] emailAdresses = WebFormUtil.split(
				getParameter(actionRequest, "emailAddress"));

			if (emailAdresses.length == 0) {
				SessionErrors.add(actionRequest, "emailAddressRequired");
			}

			for (String emailAdress : emailAdresses) {
				emailAdress = emailAdress.trim();

				if (!Validator.isEmailAddress(emailAdress)) {
					SessionErrors.add(actionRequest, "emailAddressInvalid");
				}
			}
		}

		if (saveToFile) {
			String fileName = getParameter(actionRequest, "fileName");

			// Check if server can create a file as specified

			try {
				FileOutputStream fileOutputStream = new FileOutputStream(
					fileName, true);

				fileOutputStream.close();
			}
			catch (SecurityException se) {
				SessionErrors.add(actionRequest, "fileNameInvalid");
			}
			catch (FileNotFoundException fnfe) {
				SessionErrors.add(actionRequest, "fileNameInvalid");
			}
		}

		if (saveToDatabase) {
			int i = 1;

			String languageId = LocaleUtil.toLanguageId(
				actionRequest.getLocale());

			String fieldLabel = ParamUtil.getString(
				actionRequest, "fieldLabel" + i + "_" + languageId);

			while ((i == 1) || Validator.isNotNull(fieldLabel)) {
				if (fieldLabel.length() > 75 ) {
					SessionErrors.add(actionRequest, "fieldSizeInvalid" + i);
				}

				i++;

				fieldLabel = ParamUtil.getString(
					actionRequest, "fieldLabel" + i + "_" + languageId);
			}
		}

		if (!validateUniqueFieldNames(actionRequest)) {
			SessionErrors.add(
				actionRequest, DuplicateColumnNameException.class.getName());
		}
	}

	protected boolean validateUniqueFieldNames(ActionRequest actionRequest) {
		Locale defaultLocale = LocaleUtil.getDefault();

		Set<String> localizedUniqueFieldNames = new HashSet<String>();
		PortletPreferences preferences = actionRequest.getPreferences();
//		String wizardNrSteps = preferences.getValue("wizardNrSteps", StringPool.BLANK);
//		int nrSteps = 1;
//		if(wizardNrSteps != null && wizardNrSteps!= ""){
//			nrSteps = Integer.parseInt(wizardNrSteps);
//		}
//		for(int stepIndex = 0; stepIndex < nrSteps; stepIndex++) {
			int[] formFieldsIndexes = StringUtil.split(ParamUtil.getString(actionRequest, "formFieldsIndexes"), 0);

			for (int formFieldsIndex : formFieldsIndexes) {
				Map<Locale, String> fieldLabelMap =
					LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel" + formFieldsIndex);

				if (Validator.isNull(fieldLabelMap.get(defaultLocale))) {
					continue;
				}

				for (Locale locale : fieldLabelMap.keySet()) {
					String fieldLabelValue = fieldLabelMap.get(locale);

					if (Validator.isNull(fieldLabelValue)) {
						continue;
					}

					String languageId = LocaleUtil.toLanguageId(locale);

					if (!localizedUniqueFieldNames.add(languageId + "_" + fieldLabelValue)) {
						System.out.println("Duplicated Name: "+languageId + "_" + fieldLabelValue);
						return false;
					}
				}
			}
//		}
		
		return true;
	}
	

}
