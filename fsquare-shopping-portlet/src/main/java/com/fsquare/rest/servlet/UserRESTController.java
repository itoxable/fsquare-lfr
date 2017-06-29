package com.fsquare.rest.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

@Controller
@RequestMapping("/user")
public class UserRESTController extends BaseRESTController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String getLoggedInUser(HttpServletRequest request) throws SystemException, PortalException {
		User user = getUser(request);
		return JSONFactoryUtil.looseSerialize(user);
	}
	
	@RequestMapping(value = "/by-company/{companyId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String geCompanyUsers(@PathVariable("companyId") long companyId, HttpServletRequest request) throws SystemException, PortalException {
		List<User> users = UserLocalServiceUtil.getCompanyUsers(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return JSONFactoryUtil.looseSerialize(users);
	}
	
	@RequestMapping(value = "/by-company/{companyId}/{start}/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String geCompanyUsers(@PathVariable("companyId") long companyId, @PathVariable("start") int start, @PathVariable("end") int end, HttpServletRequest request) throws SystemException, PortalException {
		List<User> users = UserLocalServiceUtil.getCompanyUsers(companyId, start, end);
		return JSONFactoryUtil.looseSerialize(users);
	}
	
	@RequestMapping(value = "/update-agreed-to-terms-of-use", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String updateAgreedToTermsOfUse(@PathVariable("user") String userString,HttpServletRequest request) throws SystemException, PortalException {
		User user = getUser(request);
		user = UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), true);
		return JSONFactoryUtil.looseSerialize(user);
	}
	
	@RequestMapping(value = "/update-portrait/{file}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String updatePortrait(@PathVariable("file") File file,HttpServletRequest request) throws SystemException, PortalException, IOException {
		User user = getUser(request);
		UserLocalServiceUtil.updatePortrait(user.getUserId(), FileUtil.getBytes(file));
		return JSONFactoryUtil.looseSerialize(user);
	}
	
	@RequestMapping(value = "/{user}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String updateEmailAddress(@PathVariable("password") String password, @PathVariable("emailAddress1") String emailAddress1, @PathVariable("emailAddress2") String emailAddress2,HttpServletRequest request) throws SystemException, PortalException {
		User user = getUser(request);
		user = UserLocalServiceUtil.updateEmailAddress(user.getUserId(), password, emailAddress1, emailAddress2);
		return JSONFactoryUtil.looseSerialize(user);
	}
	
	@RequestMapping(value = "/update-password/{password1}/{password2}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String updatePassword(@PathVariable("password1") String password1, @PathVariable("password2") String password2, HttpServletRequest request) throws SystemException, PortalException {
		User user = getUser(request);
		user = UserLocalServiceUtil.updatePassword(user.getUserId(), password1, password2, false);
		return JSONFactoryUtil.looseSerialize(user);
	}
	
	
	
	@RequestMapping(value = "/{user}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String updateLoggedInUser(@PathVariable("user") String userString,HttpServletRequest request) throws SystemException, PortalException {
		User user = getUser(request);
		
		
		
		
		
		JSONObject userJson = JSONFactoryUtil.createJSONObject(userString);
//		userJson.getLong("userId");
//		userJson.getString("emailAddress");
//		userJson.getString("screenName");
//		userJson.getString("firstName");
//		userJson.getString("middleName");
//		userJson.getString("lastName");
//		userJson.get("prefixId");
//		userJson.get("suffixId");
//		userJson.get("male");
//		userJson.get("");
//		userJson.get("");
//		userJson.get("");
//		userJson.get("");
//		UserLocalServiceUtil.updateUser(userId, oldPassword, newPassword1, 
//				newPassword2, passwordReset, reminderQueryQuestion, 
//				reminderQueryAnswer, screenName, emailAddress, 
//				facebookId, openId, languageId, timeZoneId, 
//				greeting, comments, firstName, middleName, lastName, 
//				prefixId, suffixId, male, birthdayMonth, birthdayDay, 
//				birthdayYear, smsSn, aimSn, facebookSn, icqSn, jabberSn, msnSn, mySpaceSn, 
//				skypeSn, twitterSn, ymSn, jobTitle, groupIds, organizationIds, roleIds, userGroupRoles, 
//				userGroupIds, serviceContext)
		return JSONFactoryUtil.looseSerialize(user);
	}
}
