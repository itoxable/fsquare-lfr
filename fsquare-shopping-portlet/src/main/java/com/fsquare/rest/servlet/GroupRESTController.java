package com.fsquare.rest.servlet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.GroupServiceUtil;


@Controller
@RequestMapping("/group")
public class GroupRESTController extends BaseRESTController {

	@RequestMapping(value = "/list", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String getGroups(HttpServletRequest request) throws SystemException, PortalException {
		
		//GroupServiceUtil.getCompanyGroup(companyId)
		return "";
	}
	
	
}
