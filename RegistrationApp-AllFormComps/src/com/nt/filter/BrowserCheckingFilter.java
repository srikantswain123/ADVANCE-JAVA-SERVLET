package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebFilter("/registerurl")
public class BrowserCheckingFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		pw=res.getWriter();
		String browser=null;
		browser=req.getHeader("user-agent");
		if(browser.indexOf("Chrome")==-1) {
			pw.println("<h1 style='color:red;text-align:center'>Plz use Only Chrome</h1>");
			return;
		}else {
				chain.doFilter(req, res);
			}
		}
		
	

}
