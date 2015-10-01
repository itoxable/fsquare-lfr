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

package com.liferay.webform.portlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.mail.internet.InternetAddress;
import javax.net.ssl.HttpsURLConnection;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.geoplace.content.manager.CMSContentManager;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
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
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.webform.util.PortletPropsValues;
import com.liferay.webform.util.WebFormCache;
import com.liferay.webform.util.WebFormUtil;

/**
 * @author Daniel Weisser
 * @author Jorge Ferrer
 * @author Alberto Montero
 * @author Julio Camarero
 * @author Brian Wing Shun Chan
 */
public class WebFormPortlet extends MVCPortlet {

	public static WebFormCache<String, Object> CACHE = WebFormCache.getInstance();
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		String portletId = PortalUtil.getPortletId(renderRequest);
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletId);

			for (int i = 1; true; i++) {
				String fieldLabel = preferences.getValue("fieldLabel" + i, StringPool.BLANK);
				String fieldType = preferences.getValue("fieldType" + i, StringPool.BLANK);
				if (Validator.isNull(fieldLabel)) {
					break; 
				}
				if(fieldType.equals("options")){
					boolean nsgOrganisation = PrefsParamUtil.getBoolean(preferences, renderRequest, "nsgOrganisation" + i);
					if(nsgOrganisation){
						String cacheKey = "web_form_nsgOrganisation";
						String options = (String)CACHE.get(cacheKey);
						
						if(options == null){					
							StringBuilder sb = new StringBuilder();
							
							String optionTemplate = "<option value=\"SECURITY_GROUP_ID\">[SECURITY_GROUP_EXTERNAL_ID] SECURITY_GROUP_NAME</option>";
							
							HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
							ServletContext servletContext = request.getSession().getServletContext();
							XmlWebApplicationContext xmlWebApplicationContext = (XmlWebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
							CMSContentManager cmsManager = (CMSContentManager)xmlWebApplicationContext.getBean("cmsManager");
							String whereClause = "AND sgr_sgt_id in (2,3,4,5,6,7,9,15,19,20,21,22,25) ORDER BY sgr_name ASC";
							
							List<Map<String, Object>> result = cmsManager.getSGRMap(whereClause);
							if(result == null){
								System.out.println("Result: null");
								break;
							}
							System.out.println("result.size():"+result.size());
							for(Map<String, Object> map: result){
								
								String sgrExternalId = (String)map.get("sgr_external_id");
								Integer sgrId = (Integer)map.get("sgr_id");
								if(Validator.isNotNull( sgrId) && Validator.isNotNull(sgrExternalId)){
									
									
									String option = optionTemplate.replaceAll("SECURITY_GROUP_ID", WebFormUtil.leftHandPad(sgrId.toString().trim(),'0',4))
											.replaceAll("SECURITY_GROUP_EXTERNAL_ID",  WebFormUtil.leftHandPad(sgrExternalId, '0', 4))
												.replaceAll("SECURITY_GROUP_NAME",  (String)map.get("sgr_name"));
	
									sb.append(option);
								
								}
							}
							options = sb.toString();
							CACHE.put(cacheKey, options, 60*24*30);
						}
						renderRequest.setAttribute("nsgOrganisation"+i, options);
					}
				}
			}
		
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	
	private String inputFileName = null;
	private String ackEmailAddress = null;
	public void deleteData(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(actionRequest);

		PortletPermissionUtil.check(
			themeDisplay.getPermissionChecker(), themeDisplay.getPlid(),
			portletId, ActionKeys.CONFIGURATION);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

		String databaseTableName = preferences.getValue(
			"databaseTableName", StringPool.BLANK);

		if (Validator.isNotNull(databaseTableName)) {
			ExpandoTableLocalServiceUtil.deleteTable(
				themeDisplay.getCompanyId(), WebFormUtil.class.getName(),
				databaseTableName);
		}
	}

	public void saveData( ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String portletId = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);

		inputFileName = actionRequest.getParameter("inputFileName");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletId);

		boolean requireCaptcha = GetterUtil.getBoolean(
			preferences.getValue("requireCaptcha", StringPool.BLANK));
		String successURL = GetterUtil.getString(preferences.getValue("successURL", StringPool.BLANK));
		boolean sendAsEmail = GetterUtil.getBoolean(
			preferences.getValue("sendAsEmail", StringPool.BLANK));
		boolean sendAckEmail = GetterUtil.getBoolean(
				preferences.getValue("sendAck", StringPool.BLANK));
		boolean saveToDatabase = GetterUtil.getBoolean(
			preferences.getValue("saveToDatabase", StringPool.BLANK));
		String databaseTableName = GetterUtil.getString(
			preferences.getValue("databaseTableName", StringPool.BLANK));
		boolean saveToFile = GetterUtil.getBoolean(
			preferences.getValue("saveToFile", StringPool.BLANK));
		String fileName = GetterUtil.getString(
			preferences.getValue("fileName", StringPool.BLANK));
		
		String postToURL = preferences.getValue("postToURL", StringPool.BLANK);
		boolean isPostToURL = GetterUtil.getBoolean(preferences.getValue("isPostToURL", StringPool.BLANK));
		
		 UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		 File file = uploadRequest.getFile("fileupload");
		 
		 File outputFile = null;
		 if(file != null){
			 //InputStream attachmentStream = new BufferedInputStream(uploadRequest.getFileAsStream("fileupload"));
			 //String attachmentName = uploadRequest.getFileName("fileupload");
			 String attachmentName = uploadRequest.getFullFileName("fileupload");
			 if(attachmentName != null && !attachmentName.equals("")){
				 long requestId = CounterLocalServiceUtil.increment(WebFormUtil.class.getName());
				 String dir = System.getProperty("java.io.tmpdir")+"/"+portletId+"/"+requestId;
				 File tempFormDir = new File(dir);
				 if (!tempFormDir.exists()) {
					tempFormDir.mkdir();
				 }
				 
				 outputFile = new File(dir+"/"+attachmentName);

				 FileInputStream fileInputStream = new FileInputStream(file);
				 FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

				 byte[] bytes_ = FileUtil.getBytes(file);
				 int index = fileInputStream.read(bytes_);
		
				 while (index != -1) {
					 fileOutputStream.write(bytes_, 0, index);
					 index = fileInputStream.read(bytes_);
				 }
				 fileOutputStream.close();
				 fileInputStream.close();
				 
				 if(file != null) {
					 System.out.println("Uploaded file name " + file.getAbsolutePath() + " saved as  " + outputFile.getAbsolutePath()) ;
				 }
			 }
		 }
		 
		if (requireCaptcha) {
			try {
				CaptchaUtil.check(actionRequest);
			}
			catch (CaptchaTextException cte) {
				SessionErrors.add(actionRequest, CaptchaTextException.class.getName());
				return;
			}
		}

		Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue(
				"fieldLabel" + i, StringPool.BLANK);
			
			String fieldType = preferences.getValue(
					"fieldType" + i, StringPool.BLANK);
			
			if (Validator.isNull(fieldLabel)) {
				break; 
			}
			
			if(fieldType.equals("email")) {				
				boolean isAckEmail = GetterUtil.getBoolean( preferences.getValue( "isAckEmail" + i, StringPool.BLANK));
				if(isAckEmail){
					ackEmailAddress = actionRequest.getParameter("field" + i);
				}
			}
			
			if (StringUtil.equalsIgnoreCase(fieldType, "paragraph") || StringUtil.equalsIgnoreCase(fieldType, "fileupload")) {
				continue;
			}
			
			if(fieldType.equals("multiple-checkbox")) {
				String fieldName = "field" + i;
				String fieldOptionsXml = LocalizationUtil.getLocalizationXmlFromPreferences(preferences, actionRequest, "fieldOptions" + i);
				String fieldOptions = LocalizationUtil.getLocalization(fieldOptionsXml, themeDisplay.getLanguageId());
				String fieldOptionsArr[] = fieldOptions.split(",");
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < fieldOptionsArr.length; j++){
					String checkboxValue = actionRequest.getParameter( fieldName +"_"+ j + "");
					if(checkboxValue !=null && !checkboxValue.equals("") && !checkboxValue.equals("false")){
						sb.append(fieldOptionsArr[j]).append(", ");
					}
				}
				fieldsMap.put(fieldLabel, sb.toString());
				continue;
				
			}
			
			if(StringUtil.equalsIgnoreCase(fieldType, "dateTime") ){
				fieldsMap.put(fieldLabel, actionRequest.getParameter("field" + i) + " " +actionRequest.getParameter("field" + i + "_time"));
			}else{
				fieldsMap.put(fieldLabel, actionRequest.getParameter("field" + i));
			}
			
		}

		Set<String> validationErrors = null;

		try {
			validationErrors = validate(fieldsMap, preferences, outputFile);
		}
		catch (Exception e) {
			SessionErrors.add(
				actionRequest, "validationScriptError", e.getMessage().trim());

			return;
		}

		if (validationErrors.isEmpty()) {
			boolean emailSuccess = true;
			boolean databaseSuccess = true;
			boolean fileSuccess = true;
			boolean postToURLSuccess = true;
			
			Long databaseRowId = 0L;
			

			if (isPostToURL) {
				postToURLSuccess = postToURL(fieldsMap, preferences, fileName, postToURL);
			}
			
			if (saveToDatabase) {
				if (Validator.isNull(databaseTableName)) {
					databaseTableName = WebFormUtil.getNewDatabaseTableName(portletId);
					preferences.setValue("databaseTableName", databaseTableName);
					preferences.store();
				}
				String recordState = WebFormUtil.RECORD_STATE_FINAL;
				String rowId = actionRequest.getParameter("EDITING_ROW");
				if(Validator.isNull(rowId)){
					rowId = "0";
				}else{
					recordState = WebFormUtil.RECORD_STATE_UPDATED;
				}
				
				databaseRowId = saveDatabase(themeDisplay.getCompanyId(), fieldsMap, preferences, databaseTableName, recordState, Long.parseLong(rowId));
				databaseSuccess = databaseRowId != null;
			}
			if (sendAsEmail) {
				emailSuccess = sendEmail(themeDisplay.getCompanyId(), fieldsMap, preferences, outputFile);
			}
			if (saveToFile) {
				fileSuccess = saveFile(fieldsMap, fileName);
			}
			
			if (emailSuccess && databaseSuccess && fileSuccess && postToURLSuccess) {
				
				String url = themeDisplay.getURLPortal()+themeDisplay.getLayout().getFriendlyURL(themeDisplay.getLocale())+Portal.FRIENDLY_URL_SEPARATOR+"web-form/"+portletId.split("_INSTANCE_")[1]+"/modify/"+databaseRowId;
				fieldsMap.put("DATABASE_ROW_ID", databaseRowId.toString());
				fieldsMap.put("EDIT_URL", url);
				
				if(sendAckEmail && ackEmailAddress !=null) {
					sendAckEmail(themeDisplay.getCompanyId(), preferences, fieldsMap);
				}
				
				SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_SUCCESS, fieldsMap);
				
			}
			else {
				SessionErrors.add(actionRequest, WebFormUtil.FORM_MESSAGE_ERROR);
			}
		}
		else {
			for (String badField : validationErrors) {
				SessionErrors.add(actionRequest, WebFormUtil.FORM_MESSAGE_ERROR + badField);
			}
		}

		if (SessionErrors.isEmpty(actionRequest) &&
			Validator.isNotNull(successURL)) {

			actionResponse.sendRedirect(successURL);
		}
	}
	
	private boolean postToURL(Map<String, String> fieldsMap, PortletPreferences preferences, String fileName, String postToURL) {

		try{
			System.out.println("-------------------------------");
			StringBuilder postParams = new StringBuilder();
			for (int i = 1; true; i++) {
				String fieldLabel = preferences.getValue("fieldLabel" + i, StringPool.BLANK);
				String fieldName = preferences.getValue("fieldName" + i, StringPool.BLANK);
				if (Validator.isNull(fieldLabel)) {
					break; 
				}
				String fieldValue = fieldsMap.get(fieldLabel);

				if(Validator.isNull(fieldName)){
					fieldName = fieldLabel.toLowerCase().replace(' ', '_');
				}
				postParams.append(fieldName).append('=').append(fieldValue).append('&');
			}
		
			System.out.println("URL: "+postToURL);
			System.out.println("PARAMETERS: "+postParams.toString());
			
			URL url = new URL(postToURL);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
//			connection.setRequestProperty("User-Agent", USER_AGENT);
			
			connection.setDoOutput(true);
	        OutputStream outputStream = connection.getOutputStream();
	        outputStream.write(postParams.toString().getBytes());
	        outputStream.flush();
	        outputStream.close();
			
			int responseCode = connection.getResponseCode();
			System.out.println("POST Response Code :: " + responseCode);
			
			if (responseCode == HttpsURLConnection.HTTP_OK) { //success
	            BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	 
	            while ((inputLine = inputBufferedReader.readLine()) != null) {
	                response.append(inputLine);
	            }
	            inputBufferedReader.close();
	 
	            System.out.println("RESPONSE: "+response.toString());
	            fieldsMap.put(WebFormUtil.POST_RESPONSE, response.toString());
	            return true;
	            
	        }

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	public void saveTempData(ActionRequest actionRequest, ActionResponse actionResponse)throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String portletId = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		
		System.out.println("portletId: "+portletId);

		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletId);
		boolean requireCaptcha = GetterUtil.getBoolean(preferences.getValue("requireCaptcha", StringPool.BLANK));
		if (requireCaptcha) {
			try {
				CaptchaUtil.check(actionRequest);
			}
			catch (CaptchaTextException cte) {
				SessionErrors.add(actionRequest, CaptchaTextException.class.getName());
				return;
			}
		}
		
		Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue("fieldLabel" + i, StringPool.BLANK);
			String fieldType = preferences.getValue("fieldType" + i, StringPool.BLANK);
			
			if (Validator.isNull(fieldLabel)) {
				break; 
			}
		
			if (StringUtil.equalsIgnoreCase(fieldType, "paragraph") || StringUtil.equalsIgnoreCase(fieldType, "fileupload")) {
				continue;
			}
			
			if(fieldType.equals("multiple-checkbox")) {
				String fieldName = "field" + i;
				String fieldOptionsXml = LocalizationUtil.getLocalizationXmlFromPreferences(preferences, actionRequest, "fieldOptions" + i);
				String fieldOptions = LocalizationUtil.getLocalization(fieldOptionsXml, themeDisplay.getLanguageId());
				String fieldOptionsArr[] = fieldOptions.split(",");
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < fieldOptionsArr.length; j++){
					String checkboxValue = actionRequest.getParameter( fieldName +"_"+ j + "");
					if(checkboxValue !=null && !checkboxValue.equals("") && !checkboxValue.equals("false")){
						sb.append(fieldOptionsArr[j]).append(", ");
					}
				}
				fieldsMap.put(fieldLabel, sb.toString());
				continue;
				
			}
			
			if(StringUtil.equalsIgnoreCase(fieldType, "dateTime") ){
				fieldsMap.put(fieldLabel, actionRequest.getParameter("field" + i) + " " +actionRequest.getParameter("field" + i + "_time"));
			}else{
				fieldsMap.put(fieldLabel, actionRequest.getParameter("field" + i));
			}
			
		}
		String pId = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		System.out.println("pId: "+pId);

		String databaseTableName = GetterUtil.getString(preferences.getValue("databaseTableName", StringPool.BLANK));
		if (Validator.isNull(databaseTableName)) {
			databaseTableName = WebFormUtil.getNewDatabaseTableName(portletId);
			preferences.setValue("databaseTableName", databaseTableName);
			preferences.store();
		}
		
		Long rowId = saveDatabase(themeDisplay.getCompanyId(), fieldsMap, preferences, databaseTableName, WebFormUtil.RECORD_STATE_TEMP, 0L);
		boolean databaseSuccess =  rowId != null;
		if (databaseSuccess) {
			String url = themeDisplay.getURLPortal()+themeDisplay.getLayout().getFriendlyURL(themeDisplay.getLocale())+Portal.FRIENDLY_URL_SEPARATOR+"web-form/"+portletId.split("_INSTANCE_")[1]+"/saved/"+rowId;
			SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_SUCCES_SAVING_TEMP, url);
		}
		else {
			SessionErrors.add(actionRequest, WebFormUtil.FORM_MESSAGE_ERROR_SAVING_TEMP);
		}
	}
	
	public void modifyData(ActionRequest actionRequest, ActionResponse actionResponse)throws Exception {
		getTempData(actionRequest, actionResponse);
		//actionRequest.setAttribute("modifying", true);
		String rowId = actionRequest.getParameter("uniqueId");
		actionRequest.setAttribute("EDITING_ROW", rowId);
		//actionRequest.setAttribute("rowId", rowId);
	}
	
	public void getTempData(ActionRequest actionRequest, ActionResponse actionResponse)throws Exception {
		
		String uniqueId = actionRequest.getParameter("uniqueId");
		if (Validator.isNull(uniqueId)) {
			SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_ERROR);
			return;
		}
		Long rowId = 0L;
		try{
			rowId = Long.parseLong(uniqueId.trim());
		}catch(NumberFormatException e){
			SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_ERROR_INVALID_ROW_ID);
			return;
		}
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String portletId = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletId);
		
		String databaseTableName = GetterUtil.getString(preferences.getValue("databaseTableName", StringPool.BLANK));
		if (Validator.isNull(databaseTableName)) {
			SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_ERROR_NO_TABLE);
			return;
		}
		

		try {
			ExpandoRow expandoRow = ExpandoRowLocalServiceUtil.getRow(rowId);
			if (expandoRow == null) {
				SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_ERROR_NO_ROW);
				return;
			}
			Map<String, String> valuesMap = new HashMap<String, String>();
			for (int i = 1; true; i++) {
				String fieldLabel = preferences.getValue("fieldLabel" + i, StringPool.BLANK);

				if (Validator.isNull(fieldLabel)) {
					break;
				}
				
				String data = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),WebFormUtil.class.getName(), databaseTableName, fieldLabel, expandoRow.getClassPK(), StringPool.BLANK);
				
				String fieldType = preferences.getValue("fieldType" + (i), StringPool.BLANK);
				
				if(fieldType.equals("multiple-checkbox")) {
					
					String temp[] = data.split(",");
					
					String fieldName = "field" + i;
					String fieldOptionsXml = LocalizationUtil.getLocalizationXmlFromPreferences(preferences, actionRequest, "fieldOptions" + i);
					String fieldOptions = LocalizationUtil.getLocalization(fieldOptionsXml, themeDisplay.getLanguageId());
					String fieldOptionsArr[] = fieldOptions.split(",");
					
					int quant = 0;
					for(int j = 0; j < fieldOptionsArr.length; j++){
						
						if(quant >= temp.length){
							break;
						}
						String originValue = fieldOptionsArr[j].trim();
						for(int k = 0; k < temp.length; k++){
							if(temp[k].trim().equals(originValue)){
								quant++;
								valuesMap.put(fieldName +"_"+ j, "true");
								break;
							}
						}
						
					}
					continue;
				}
								
				valuesMap.put("field"+i, data);
			
			}
			actionRequest.setAttribute("savedValuesMap", valuesMap);
			
			SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_SUCCESS, expandoRow.getModifiedDate());
		}catch(Exception e){
			SessionMessages.add(actionRequest, WebFormUtil.FORM_MESSAGE_TEMPORARY_DATA_ERROR);
		}
		
		
		
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals("captcha")) {
				serveCaptcha(resourceRequest, resourceResponse);
			}
			else if (cmd.equals("export")) {
				exportData(resourceRequest, resourceResponse);
			}
			else if (cmd.equals("get_data")) {
				getData(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}
	
	
	public void getData(ResourceRequest resourceRequest,	ResourceResponse resourceResponse)throws Exception {
		
		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        jsonObject.put("success", false);
        
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(resourceRequest);

		
		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(), themeDisplay.getPlid(), portletId, ActionKeys.CONFIGURATION);

		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(resourceRequest);

		String databaseTableName = preferences.getValue("databaseTableName", StringPool.BLANK);

		StringBuilder sb = new StringBuilder("<table class='table table-bordered table-hover table-striped'><thead class='table-columns'><tr>");

		List<String> fieldLabels = new ArrayList<String>();
		sb.append("<th>");
		sb.append("Row Id");
		sb.append("</th>");
		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue("fieldLabel" + i, StringPool.BLANK);

			String localizedfieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, themeDisplay.getLanguageId());

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			fieldLabels.add(fieldLabel);

			sb.append("<th>");
			sb.append(localizedfieldLabel.replaceAll("\"", "\\\""));
			sb.append("</th>");
		}
		
		sb.append("<th>");
		sb.append(WebFormUtil.RECORD_STATE.replaceAll("\"", "\\\""));
		sb.append("</th>");
		sb.append("<th>");
		sb.append("Modified Date");
		sb.append("</th>");
		sb.append("</tr></thead><tbody class='table-data'>");
		
		if (Validator.isNotNull(databaseTableName)) {
			List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(themeDisplay.getCompanyId(), WebFormUtil.class.getName(), databaseTableName, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (ExpandoRow row : rows) {
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(row.getRowId());
				sb.append("</td>");
				for (String fieldName : fieldLabels) {
					String data = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),WebFormUtil.class.getName(), databaseTableName,fieldName, row.getClassPK(), StringPool.BLANK);
					data = data.replaceAll("\"", "\\\"");
					sb.append("<td>");
					sb.append(data);
					sb.append("</td>");
				}
				
				String recordState = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),WebFormUtil.class.getName(), databaseTableName, WebFormUtil.RECORD_STATE, row.getClassPK(), StringPool.BLANK);
				recordState = recordState.replaceAll("\"", "\\\"");
				sb.append("<td>");
				sb.append(recordState);
				sb.append("</td>");					
				//sb.deleteCharAt(sb.length() - 1);
				
				sb.append("<td>");
				sb.append(row.getModifiedDate());
				sb.append("</td>");
				
				sb.append("</tr>");
			}
		}
		
		sb.append("</tbody></table>");
		jsonObject.put("data", sb.toString());
		jsonObject.put("success", true);
		
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();

	}

	protected void exportData(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(resourceRequest);

		char valueDelimiter = ',';
		
		PortletPermissionUtil.check(
			themeDisplay.getPermissionChecker(), themeDisplay.getPlid(),
			portletId, ActionKeys.CONFIGURATION);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(resourceRequest);

		String databaseTableName = preferences.getValue(
			"databaseTableName", StringPool.BLANK);
		String title = preferences.getValue("title", "no-title");

		StringBuilder sb = new StringBuilder();

		List<String> fieldLabels = new ArrayList<String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue("fieldLabel" + i, StringPool.BLANK);

			String localizedfieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, themeDisplay.getLanguageId());

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			fieldLabels.add(fieldLabel);

			sb.append("\"");
			sb.append(localizedfieldLabel.replaceAll("\"", "\\\""));
			sb.append("\"");
			sb.append(valueDelimiter);
		}
		
		sb.append("\"");
		sb.append(WebFormUtil.RECORD_STATE.replaceAll("\"", "\\\""));
		sb.append("\"");
		sb.append(valueDelimiter);

		sb.deleteCharAt(sb.length() - 1);
		sb.append("\n");

		if (Validator.isNotNull(databaseTableName)) {
			List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(themeDisplay.getCompanyId(), WebFormUtil.class.getName(), databaseTableName, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (ExpandoRow row : rows) {
				for (String fieldName : fieldLabels) {
					String data = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),WebFormUtil.class.getName(), databaseTableName,fieldName, row.getClassPK(), StringPool.BLANK);

					data = data.replaceAll("\"", "\\\"");

					sb.append("\"");
					sb.append(data);
					sb.append("\"");
					sb.append(valueDelimiter);
				}
				
				String recordState = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),WebFormUtil.class.getName(), databaseTableName, WebFormUtil.RECORD_STATE, row.getClassPK(), StringPool.BLANK);
				recordState = recordState.replaceAll("\"", "\\\"");
				sb.append("\"");
				sb.append(recordState);
				sb.append("\"");
				sb.append(valueDelimiter);
				

				sb.deleteCharAt(sb.length() - 1);
				sb.append("\n");
			}
		}

		String fileName = title + ".csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;

		PortletResponseUtil.sendFile(
			resourceRequest, resourceResponse, fileName, bytes, contentType);
	}

	
	protected Long saveDatabase(long companyId, Map<String, String> fieldsMap, PortletPreferences preferences, String databaseTableName)throws Exception {
		return saveDatabase(companyId, fieldsMap, preferences, databaseTableName, WebFormUtil.RECORD_STATE_FINAL, 0L);
	}
	
	protected Long saveDatabase(long companyId, Map<String, String> fieldsMap, PortletPreferences preferences, String databaseTableName, String record_state, Long rowId)
		throws Exception {

		WebFormUtil.checkTable(companyId, databaseTableName, preferences);

		try {
			if(rowId != null && rowId != 0L){
				List<ExpandoValue> expandoValues = ExpandoValueLocalServiceUtil.getRowValues(rowId);
				for(ExpandoValue expandoValue: expandoValues){
					String columnName = expandoValue.getColumn().getName();
					String newValue = fieldsMap.get(columnName);
					if(columnName.equals(WebFormUtil.RECORD_STATE)){
						expandoValue.setData(WebFormUtil.RECORD_STATE_UPDATED);
						ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValue);
						continue;
					}
					if(newValue != null && newValue.equals(expandoValue.getData())){
						continue;
					}
					expandoValue.setData(newValue);
					ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValue);
				}
				return rowId;
			}else{
			
				long classPK = CounterLocalServiceUtil.increment(WebFormUtil.class.getName());
				for (String fieldLabel : fieldsMap.keySet()) {
					String fieldValue = fieldsMap.get(fieldLabel);
					if(fieldLabel.equals(WebFormUtil.POST_RESPONSE))
						continue;
					ExpandoValueLocalServiceUtil.addValue(companyId, WebFormUtil.class.getName(), databaseTableName,fieldLabel, classPK, fieldValue);
				}
				
				ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.addValue(companyId, WebFormUtil.class.getName(), databaseTableName, WebFormUtil.RECORD_STATE, classPK, record_state);
		
				return expandoValue.getRowId();
			}
		}
		catch (Exception e) {
			_log.error("The web form data could not be saved to the database", e);
			return null;
		}
	}

	protected boolean saveFile(Map<String, String> fieldsMap, String fileName) {

		// Save the file as a standard Excel CSV format. Use ; as a delimiter,
		// quote each entry with double quotes, and escape double quotes in
		// values a two double quotes.

		StringBuilder sb = new StringBuilder();

		for (String fieldLabel : fieldsMap.keySet()) {
			String fieldValue = fieldsMap.get(fieldLabel);

			sb.append("\"");
			sb.append(StringUtil.replace(fieldValue, "\"", "\"\""));
			sb.append("\";");
		}

		String s = sb.substring(0, sb.length() - 1) + "\n";

		try {
			FileUtil.write(fileName, s, false, true);

			return true;
		}
		catch (Exception e) {
			_log.error("The web form data could not be saved to a file", e);

			return false;
		}
	}
	
	protected boolean sendAckEmail(long companyId, PortletPreferences preferences, Map<String, String> fieldsMap) {
		try {
			String subject = GetterUtil.getString(preferences.getValue("ackEmailSubject", StringPool.BLANK));
			String bodyText = GetterUtil.getString(preferences.getValue("ackEmailText", StringPool.BLANK));
						
			String formData = WebFormUtil.getMailBody(fieldsMap);
			
			bodyText = bodyText.replaceAll("\\[\\$FORM_DATA\\$\\]", formData);
			
			for(Map.Entry<String, String> entry : fieldsMap.entrySet()){
				bodyText = bodyText.replaceAll("\\[\\$"+entry.getKey()+"\\$\\]", entry.getValue());
			}
			
			InternetAddress fromAddress = new InternetAddress(WebFormUtil.getEmailFromAddress(preferences, companyId), WebFormUtil.getEmailFromName(preferences, companyId));
			
			MailMessage mailMessage = new MailMessage(fromAddress, subject, bodyText, true);
			InternetAddress[] toAddresses = InternetAddress.parse(ackEmailAddress);
			mailMessage.setTo(toAddresses);

			
			MailServiceUtil.sendEmail(mailMessage);		
			
			return true;
		} 	catch (Exception e) {
			_log.error("The web form email could not be sent", e);

			return false;
		}
	}

	protected boolean sendEmail(
		long companyId, Map<String, String> fieldsMap,
		PortletPreferences preferences, File attachment) {

		try {
			String emailAddresses = preferences.getValue(
				"emailAddress", StringPool.BLANK);

			if (Validator.isNull(emailAddresses)) {
				_log.error(
					"The web form email cannot be sent because no email " +
						"address is configured");

				return false;
			}

			InternetAddress fromAddress = new InternetAddress(
				WebFormUtil.getEmailFromAddress(preferences, companyId),
				WebFormUtil.getEmailFromName(preferences, companyId));
			String subject = preferences.getValue("subject", StringPool.BLANK);
			if(inputFileName != null && !inputFileName.isEmpty())
				subject = subject + " for " + inputFileName;
			String body = WebFormUtil.getMailBody(fieldsMap);
			
			MailMessage mailMessage = new MailMessage(
				fromAddress, subject, body, true);
			
			if(attachment != null)
				mailMessage.addFileAttachment(attachment);

			//System.out.println("Email addresses " + emailAddresses);
			
			
			ArrayList<String> recipientsArray=new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(emailAddresses,",");
			while (st.hasMoreTokens()) {
				recipientsArray.add(st.nextToken());
			}


			
			int sizeTo=recipientsArray.size();
			InternetAddress[] toAddresses = new InternetAddress[sizeTo];
			for (int i = 0; i < sizeTo; i++)
			{
				toAddresses[i] = new InternetAddress(recipientsArray.get(i).toString()) ;
			}
			

			mailMessage.setTo(toAddresses);

			MailServiceUtil.sendEmail(mailMessage);

			return true;
		}
		catch (Exception e) {
			_log.error("The web form email could not be sent", e);

			return false;
		}
	}

	protected void serveCaptcha(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		CaptchaUtil.serveImage(resourceRequest, resourceResponse);
	}

	protected Set<String> validate(
			Map<String, String> fieldsMap, PortletPreferences preferences, File outputFile)
		throws Exception {

		Set<String> validationErrors = new HashSet<String>();

		for (int i = 0; i < fieldsMap.size(); i++) {
			String fieldType = preferences.getValue(
				"fieldType" + (i + 1), StringPool.BLANK);
			String fieldLabel = preferences.getValue(
				"fieldLabel" + (i + 1), StringPool.BLANK);
			String fieldValue = fieldsMap.get(fieldLabel);

			boolean fieldOptional = GetterUtil.getBoolean(
				preferences.getValue(
					"fieldOptional" + (i + 1), StringPool.BLANK)) || fieldType.equals("hidden");

			if (Validator.equals(fieldType, "paragraph")) {
				continue;
			}
			
			if (Validator.equals(fieldType, "fileupload")) {
				if (!fieldOptional && outputFile == null) {
					validationErrors.add(fieldLabel);
				}
				continue;
			}

			if (!fieldOptional && Validator.isNotNull(fieldLabel) && Validator.isNull(fieldValue)) {

				validationErrors.add(fieldLabel);

				continue;
			}

			if (!PortletPropsValues.VALIDATION_SCRIPT_ENABLED) {
				continue;
			}

//			String validationScript = GetterUtil.getString(
//				preferences.getValue(
//					"fieldValidationScript" + (i + 1), StringPool.BLANK));
//
//			if (Validator.isNotNull(validationScript) &&
//				!WebFormUtil.validate(fieldValue, fieldsMap, validationScript)) {
//
//				validationErrors.add(fieldLabel);
//
//				continue;
//			}
		}

		return validationErrors;
	}
	
	private static Log _log = LogFactoryUtil.getLog(WebFormPortlet.class);

}