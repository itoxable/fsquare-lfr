package com.fsquare.shopping.portlet.inventorymanagement.action;

import java.io.File;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class ConfigurationActionImpl extends DefaultConfigurationAction {
	private ThemeDisplay themeDisplay;
//	@Override
//	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//
//		if (!SessionErrors.isEmpty(actionRequest)) {
//			return;
//		}
//		
//		themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		
//		PortletPreferences preferences = actionRequest.getPreferences();
//		
//		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
//
//		if (cmd.equals("delete")) {
//			String filePath = ParamUtil.getString(actionRequest, "deletePath");//preferences.getValue("deletePath", "");
//			System.out.println("--Delete File Path: "+filePath);
//			deleteFile(filePath);
//			
//			preferences.setValue("deletePath", "");
//		}else{
//		
//			
//			
//			System.out.println("--Path: "+preferences.getValue("path", ""));
//			
//			
//			if (SessionErrors.isEmpty(actionRequest)) {
//				preferences.store();
//			}
//	
//			super.processAction(portletConfig, actionRequest, actionResponse);
//		}
//	}
//	
	

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		
		if (!SessionErrors.isEmpty(actionRequest)) {
			return;
		}
		
		PortletPreferences preferences = actionRequest.getPreferences();
		
		
		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	
	}
}
