package com.fsquare.rest.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;

@Controller
public class PagesRESTController {
	@RequestMapping(value = "/layout/list/{groupId}", method=RequestMethod.GET)
	public @ResponseBody String getSiteLayouts(@PathVariable("groupId") Long groupId, HttpServletRequest request) throws SystemException {
		List<Layout> layouts= LayoutLocalServiceUtil.getLayouts(groupId, false);
		String ret = JSONFactoryUtil.looseSerialize(layouts);
		return ret;
	}
	
	@RequestMapping(value = "/layout/{plid}", method=RequestMethod.GET)
	public @ResponseBody String getLayoutById(@PathVariable("plid") Long plid, HttpServletRequest request) throws SystemException, PortalException {
		Layout layout = LayoutLocalServiceUtil.getLayout(plid);
		String ret = JSONFactoryUtil.looseSerialize(layout);
		return ret;
	}
	
//	@RequestMapping(value = "/layout/groupId/{groupId}", method=RequestMethod.POST)
//	public @ResponseBody String updateLayout(@PathVariable("groupId") Long groupId, HttpServletRequest request) throws SystemException {
//		Layout layout = LayoutLocalServiceUtil.updateLayout(layout)
//		String ret = JSONFactoryUtil.looseSerialize(layout);
//		return ret;
//	}
	
	
	@RequestMapping(value = "/layout/update-priority/{plid}/{priority}", method=RequestMethod.POST)
	public @ResponseBody String updatePriority(@PathVariable("plid") Long plid, @PathVariable("priority") int priority, HttpServletRequest request) throws SystemException, PortalException {
		Layout layout = LayoutLocalServiceUtil.updatePriority(plid, priority);
		String ret = JSONFactoryUtil.looseSerialize(layout);
		return ret;
	}
	
	
	@RequestMapping(value = "/layout/update-name/{plid}/{name}/{languageId}", method=RequestMethod.POST)
	public @ResponseBody String updateName(@PathVariable("plid") Long plid, @PathVariable("name") String name, @PathVariable("languageId") String languageId, HttpServletRequest request) throws SystemException, PortalException {
		Layout layout = LayoutLocalServiceUtil.updateName(plid, name, languageId);
		String ret = JSONFactoryUtil.looseSerialize(layout);
		return ret;
	}
	
	
	
	
	
}
