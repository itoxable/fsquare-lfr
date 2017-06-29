package com.fsquare.action;

import java.io.PrintWriter;
import java.util.Properties;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class PortletStyleAction extends BaseStrutsAction {
	private static final Log s_log = LogFactoryUtil.getLog(PortletStyleAction.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
		String portletId = request.getParameter("portletId");
		String data = request.getParameter("data");
		s_log.info(data);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();
		System.out.println(layout.getName());
		//PortletPreferences portletSetup = PortletPreferencesFactoryUtil.getStrictLayoutPortletSetup(layout, portletId);
		//http://localhost:8080/c/portlet_configuration/update_look_and_feel
		//css
//
//		Properties freeformStyleProps = PropertiesUtil.load(portletSetup.getValue("portlet-freeform-styles", StringPool.BLANK));
//		String dataAction =request.getParameter("data_action");
//		if(dataAction != null && dataAction.equals("find")){
//			String findBy = request.getParameter("findBy");
//			String query = request.getParameter("q");
//			if(findBy != null && query != null && findBy.equals("uprn")){
//				searchResult = findByUPRN(query);
//				System.out.println("uprn: "+query);
//			}else if (findBy != null && query != null && findBy.equals("postcode")) {
//				searchResult = findByPostcode(query);
//				System.out.println("postcode: "+query);
//			}
//		}
		s_log.info("-- PortletStyleAction --");
		response.setContentType("text/json");
        PrintWriter writer = response.getWriter();
        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject("");
        jsonObject.put("message", "OKAY");
        writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
		
		return null;
	} 
}
