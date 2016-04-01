package com.fsquare.rest.portlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class FsquareSpringMVCRESTFulPortlet {
	
	@RequestMapping
	public String initRESTFulApp(){
		return "defaultView";
	}
		
		
	@RenderMapping(params="render=requestRESTFulData")
	public String requestRESTFulData()
	{
		return "RESTFulData";
	}

	@RenderMapping(params="render=requestFormDashboard")
	public String requestFormDashboard()
	{
		return "FormDashboard";
	}
}
