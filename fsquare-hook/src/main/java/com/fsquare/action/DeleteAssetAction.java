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
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
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
        
        Long assetEntryId = ParamUtil.getLong(resourceRequest, "assetEntryId");
        
        ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Locale locale = themeDisplay.getLocale();
        ServiceContext serviceContext = new ServiceContext();
        String articleURL = "";
        String articleId = "";
        Long fileEntryId = 0L;
        JournalArticleServiceUtil.deleteArticle(themeDisplay.getScopeGroupId(), articleId, articleURL, serviceContext);
        DLAppServiceUtil.deleteFileEntry(fileEntryId);
        
//        Double priority = ParamUtil.getDouble(resourceRequest, "priority", 0);
//
//        Long id = ParamUtil.getLong(resourceRequest, "id");
//        
//        ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        Locale locale = themeDisplay.getLocale();
//
//        if(Validator.isNull(assetEntryId) || assetEntryId.equals(0L)){
//        	jsonObject.put("message", LanguageUtil.get(locale, "asset-not-found"));
//        }else{
//        	
//	        try{
//		        AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(assetEntryId);
//		        if(!assetEntry.isNew()){
//		            assetEntry.setPriority(priority);
//			        assetEntry = AssetEntryLocalServiceUtil.updateAssetEntry(assetEntry);
//			        
//			        if(DLFileEntry.class.getName().equals(assetEntry.getClassName())){
//			        	DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(id);
//			        	DLFileEntryLocalServiceUtil.updateDLFileEntry(dlFileEntry);			        
//			        
//			        }else if(JournalArticle.class.getName().equals(assetEntry.getClassName())){
//			        	JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(id);
//			        	JournalArticleLocalServiceUtil.updateJournalArticle(journalArticle);
//			        }
//			       
//			        jsonObject.put("success", true);
//			        jsonObject.put("message", LanguageUtil.get(locale, "asset-priority-updated"));
//		        }else{
//		        	jsonObject.put("message", LanguageUtil.get(locale, "asset-not-found"));
//		        }
//	        }catch(Exception e){
//	        	e.printStackTrace();
//	        	jsonObject.put("message", LanguageUtil.get(locale, "asset-priority-set-error"));
//	        }
//        }
        
        writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
		
	}
	
}
