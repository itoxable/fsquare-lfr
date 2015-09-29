package com.fsquare.action;

import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

public class StructureDisplayPageAction extends BaseStrutsPortletAction{
	private static final Log _log = LogFactoryUtil.getLog(StructureDisplayPageAction.class);

	@Override
	public void serveResource( PortletConfig portletConfig, ResourceRequest resourceRequest, ResourceResponse resourceResponse)throws Exception {
		
		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        
        ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Locale locale = themeDisplay.getLocale();
        
        jsonObject.put("success", false);
        jsonObject.put("message", LanguageUtil.get(locale, "structure-display-page-set-error"));
        
        Long structureId = ParamUtil.getLong(resourceRequest, "structureId");
        String displayPageUuid = ParamUtil.get(resourceRequest, "displayPageUuid", StringPool.BLANK);

        ExpandoTable expandoTable = null;
        String databaseTableName = "DDMStructure_displayPage";

        try {
        	expandoTable = ExpandoTableLocalServiceUtil.getTable(themeDisplay.getCompanyId(), DDMStructure.class.getName(), databaseTableName);
        }
        catch (NoSuchTableException ne) {
        	expandoTable = ExpandoTableLocalServiceUtil.addTable(themeDisplay.getCompanyId(), DDMStructure.class.getName(), databaseTableName);	
        	try {
        		ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), "DisplayPage", ExpandoColumnConstants.STRING);
        	}catch (Exception e) {
            	_log.error("Error adding column", e);
            }
        }
      
        if (structureId != null) {
        	try {
        		ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.addValue(themeDisplay.getCompanyId(), DDMStructure.class.getName(), databaseTableName, "DisplayPage", structureId, displayPageUuid);
                jsonObject.put("message", LanguageUtil.get(locale, "structure-display-page-set-success"));
                jsonObject.put("success", true);
            }
            catch (Exception e) {
            	_log.error("Error setting the value", e);
            }
        	
    	}
        
        writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
		
	}
}
