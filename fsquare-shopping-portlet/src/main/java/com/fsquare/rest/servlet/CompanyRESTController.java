package com.fsquare.rest.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;

@Controller
@RequestMapping("/company")
public class CompanyRESTController extends BaseRESTController{
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String getCompanies(HttpServletResponse response, HttpServletRequest request) throws SystemException, PortalException {
		response.addHeader("Content-Type", "application/json");
		User user = getUser(request);
		
		long[] companies = getUserCompaniesIds(request);
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Company.class, PortalClassLoaderUtil.getClassLoader());
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.in("companyId", ListUtil.toList(companies));
		dynamicQuery.add(criterion);
		
		List<Company> list = CompanyLocalServiceUtil.dynamicQuery(dynamicQuery);

		return JSONFactoryUtil.looseSerialize(list);
	}
	
	
	@RequestMapping(value = "/{companyId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody()
	public String getCompanyById(@PathVariable("companyId") long companyId, HttpServletResponse response,  HttpServletRequest request) throws SystemException, PortalException {
		response.addHeader("Content-Type", "application/json");
		Company company = CompanyLocalServiceUtil.getCompanyById(companyId);
		String ret = JSONFactoryUtil.looseSerialize(company);
		return ret;
	}
	
	@RequestMapping(value = "/{newCompanyString}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody()
	public String addCompany(@PathVariable("newCompanyString") String newCompanyString, HttpServletResponse response,  HttpServletRequest request) throws SystemException, PortalException {
		response.addHeader("Content-Type", "application/json");
		JSONObject json = JSONFactoryUtil.createJSONObject(newCompanyString);
		
		Company company = CompanyLocalServiceUtil.addCompany(json.getString("webId"), json.getString("virtualHostname"), json.getString("mx"), json.getString("shardName"), 
				json.getBoolean("system"), json.getInt("maxUsers"), json.getBoolean("active"));
		
		String ret = JSONFactoryUtil.looseSerialize(company);
		return ret;
	}
	
	
	@RequestMapping(value = "/update-logo/{company}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody()
	public String updateLogo(@PathVariable("company") String companyString, HttpServletRequest request) throws SystemException, PortalException {
		//Company company = CompanyLocalServiceUtil.updateLogo(companyId, file)
		return "";
	}
	
	@RequestMapping(value = "/update/{company}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody()
	public String updateCompany(@PathVariable("company") String companyString, HttpServletResponse response, HttpServletRequest request) throws SystemException, PortalException {
		response.addHeader("Content-Type", "application/json");
		
		Company company = transformJson(CompanyLocalServiceUtil.createCompany(0), companyString);
		
		
		
		
	
//		Company company = CompanyLocalServiceUtil.addCompany(webId, virtualHostname, mx, shardName, system, maxUsers, active);
//		//Company company = CompanyLocalServiceUtil.getCompanyById(companyId);
//		User user = getUser(request);
//		List<Long> companies = (List<Long>)user.getExpandoBridge().getAttribute("companies");
		
		
		String ret = JSONFactoryUtil.looseSerialize(company);
		return ret;
	}
	
	
	@RequestMapping(value = "update-complete/{virtualHostname}/{mx}/{homeURL}/{name}/{legalName}/{legalId}/{legalType}/{sicCode}/{tickerSymbol}/{industry}/{type}/{size}", method=RequestMethod.POST)
	public String updateCompany(
			long companyId, 
			String virtualHostname, 
			String mx, 
			String homeURL,
			String name, 
			String legalName, 
			String legalId, 
			String legalType,
			String sicCode, 
			String tickerSymbol, 
			String industry, 
			String type,
			String size){
		String ret = "";
		try {
			Company company = CompanyLocalServiceUtil.updateCompany(companyId, virtualHostname, mx, homeURL, name, legalName, legalId, legalType, sicCode, tickerSymbol, industry, type, size);
			ret = JSONFactoryUtil.looseSerialize(company);
		} catch (PortalException e) {
			e.printStackTrace();
//			ret
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
	

	@ResponseStatus(HttpStatus.CONFLICT)  
	@ExceptionHandler(SystemException.class)
	public void handleConflict(SystemException se) {
	    if(se.getCause() instanceof ORMException){
	    	throw (ORMException) se.getCause();
	    }
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler(ORMException.class)
	public void handleBadRequest(SystemException se) {
	    
	}
}
