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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;


public class DeleteAssetAction extends BaseStrutsPortletAction {
	
	private static final Log s_log = LogFactoryUtil.getLog(DeleteAssetAction.class);

	@Override
	public void serveResource( PortletConfig portletConfig, ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {
		
        resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
        
        jsonObject.put("success", false);

        ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Locale locale = themeDisplay.getLocale();
        ServiceContext serviceContext = new ServiceContext();

        Long id = ParamUtil.getLong(resourceRequest, "id");
        System.out.println("id: "+id);
        if(Validator.isNull(id) || id.equals(0L)){
        	jsonObject.put("message", LanguageUtil.get(locale, "asset-not-found"));
        }else{
	        try{
		       
	        	JournalArticle journalArticle = JournalArticleServiceUtil.getArticle(id);
	        	JournalArticleServiceUtil.deleteArticle(themeDisplay.getScopeGroupId(), journalArticle.getArticleId(), journalArticle.getUrlTitle(), serviceContext);

		        jsonObject.put("success", true);
		        jsonObject.put("message", LanguageUtil.get(locale, "asset-deleted"));
		        
	        }catch(Exception e){
	        	e.printStackTrace();
	        	jsonObject.put("message", LanguageUtil.get(locale, "asset-priority-set-error"));
	        }
        }
        
        writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
		
	}
	
}
