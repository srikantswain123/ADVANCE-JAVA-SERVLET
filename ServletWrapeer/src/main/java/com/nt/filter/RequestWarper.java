package com.nt.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWarper extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	
	public RequestWarper(HttpServletRequest request) {
		super(request);
		this.request=request;
	}

	@Override
	public String getParameter(String name) {
		String value=request.getParameter(name);
		if(name.equals("uname")) {
			if(!value.endsWith("@gmail.com")) {
				return value+"@gmail.com";
			}	
		}//if
		return value;
	}
	

}
