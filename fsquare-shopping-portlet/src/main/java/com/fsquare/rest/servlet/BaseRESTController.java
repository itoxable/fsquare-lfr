package com.fsquare.rest.servlet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsquare.rest.servlet.interceptor.SecureRequestHandlerInterceptor;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.PermissionServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.util.Encryptor;
import com.liferay.util.EncryptorException;

public class BaseRESTController {
	private static Log _log = LogFactoryUtil.getLog(SecureRequestHandlerInterceptor.class);

	protected User getUser(HttpServletRequest request) throws PortalException, SystemException{
		User user = (User)request.getSession().getAttribute(WebKeys.USER);
		if(user==null){
			user = PortalUtil.getUser(request);
			if(user==null){
				user = getUserFromCookies(request);
			}
		}
		return user;
	}
	private User getUserFromCookies(HttpServletRequest request) {
		// Getting the cookies from the servlet request
		Cookie[] cookies = request.getCookies();
		String userId = null;
		String uuid = CookieKeys.getCookie(request, CookieKeys.USER_UUID);
		String companyId = CookieKeys.getCookie(request, CookieKeys.COMPANY_ID);
		
		if (uuid != null && companyId != null) {
			try {
				Company company = CompanyLocalServiceUtil.getCompany(Long.parseLong(companyId));
				String _userid = Encryptor.decrypt(company.getKeyObj(), uuid);
				userId = _userid.substring(0,_userid.indexOf(StringPool.PERIOD));
				
				return UserLocalServiceUtil.getUser(Long.parseLong(userId));
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncryptorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
				
	}
	
	public Object getExpandoAttribute(BaseModel model, String attributeName){
		ExpandoBridge expandoBridge =  model.getExpandoBridge();
		Object object = null;
//		if(expandoBridge != null){
//			object = expandoBridge.getAttribute(attributeName);
//		}else{
//			expandoBridge =  new ExpandoBridgeFactoryUtil().getExpandoBridge(model.get, className)
//		}
		return object;
	}
	
	public long[] getUserCompaniesIds(HttpServletRequest request) throws PortalException, SystemException{
		User user = getUser(request);
		
		long[] companies = new long[0];
		ExpandoBridge expandoBridge = null;
		Object companiesObject = null;
		try{
			
			expandoBridge = user.getExpandoBridge();
			if(expandoBridge == null){
				System.out.println("expandoBridge == null");
				
				expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(user.getCompanyId(), User.class.getName());
				expandoBridge.addAttribute("companies", ExpandoColumnConstants.LONG_ARRAY);
				user.setExpandoBridgeAttributes(expandoBridge);
				user = UserLocalServiceUtil.updateUser(user);
				expandoBridge =  user.getExpandoBridge();
			}
		
			companiesObject = expandoBridge.getAttribute("companies");
			if(Validator.isNotNull(companiesObject)){
				companies = (long[])companiesObject;
			}
		}catch(NullPointerException e){
			
			expandoBridge.addAttribute("companies", ExpandoColumnConstants.LONG_ARRAY);
			user = UserLocalServiceUtil.updateUser(user);
			expandoBridge =  user.getExpandoBridge();
			companiesObject = expandoBridge.getAttribute("companies");
			if(Validator.isNotNull(companiesObject)){
				companies = (long[])companiesObject;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return companies;
	}
	
	public boolean canUpdate(Company company, HttpServletRequest request) throws PortalException, SystemException{
		long[] companies = getUserCompaniesIds(request);
		
		return ArrayUtil.contains(companies, company.getCompanyId());
	}
	
	public boolean canUpdate(Group group, HttpServletRequest request) throws PortalException, SystemException{
		long[] companies = getUserCompaniesIds(request);
		
		return ArrayUtil.contains(companies, group.getCompanyId());
	}
	
	public boolean canUpdate(User user, HttpServletRequest request) throws PortalException, SystemException{
		User loggeduser = getUser(request);
		
		return user.getUserId() == loggeduser.getUserId();
	}
	
	
	public <T> T transformJson(T element, String jsonString) throws JSONException{
		return transformJson(element, jsonString, new String[0]);
	}
	
	public <T> T transformJson(T element, String jsonString, String[] ignoreFields) throws JSONException{

		JSONObject json = JSONFactoryUtil.createJSONObject(jsonString);
		Method[] methods = element.getClass().getMethods();
		for(Method method: methods){
			String methodName = method.getName();
			if(ArrayUtil.contains(ignoreFields, methodName)){
				continue;
			}
			try{				
				if(methodName.startsWith("set")){
					String varName = methodName.split("set")[1];
					String parameterType = method.getParameterTypes()[0].getName();
					varName = StringUtil.lowerCaseFirstLetter(varName);
					//System.out.println(varName+": "+parameterType);
					if("boolean".equals(parameterType)){
						method.invoke(element, json.getBoolean(varName));
					}else if("long".equals(parameterType)){
						method.invoke(element, json.getLong(varName));
					}else if("double".equals(parameterType)){
						method.invoke(element, json.getDouble(varName));
					}else if("int".equals(parameterType)){
						method.invoke(element, json.getInt(varName));
					}else if("java.lang.String".equals(parameterType)){
						method.invoke(element, json.getString(varName));
					}
				}
			}catch(IllegalAccessException e){
				e.printStackTrace();
			}catch(IllegalArgumentException e){
				e.printStackTrace();
			}catch(InvocationTargetException e){
				e.printStackTrace();
			}
			
		}

		return element;
	}
	
//	public <T> T callService(T serviceUtil, String serviceMethod, String jsonString, Set<String> fields) throws JSONException{
//		Method[] methods = serviceUtil.getClass().getMethods();
//		Method method = null;
//		for(Method tempMethod: methods){
//			if(serviceMethod.equals(tempMethod.getName())){
//				method = tempMethod;
//				break;
//			}
//		}
//		if(method == null){
//			return null;
//		}
//		
//		method.invoke(serviceUtil, "","");
//		
//		
//	}
//	
//	
//	Company company = CompanyLocalServiceUtil.addCompany(json.getString("webId"), json.getString("virtualHostname"), json.getString("mx"), json.getString("shardName"), 
//			json.getBoolean("system"), json.getInt("maxUsers"), json.getBoolean("active"));
//	

}
