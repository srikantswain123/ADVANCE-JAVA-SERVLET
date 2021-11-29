package com.nt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ss=null;
		String engine =null,url=null;
		ss=req.getParameter("ss");
		engine=req.getParameter("engine");
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("yahoo"))
          url="https://in.search.yahoo.com/search?p="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("duckduckgo"))
            url="https://duckduckgo.com/?q="+ss;
		res.sendRedirect(url);
		
			
	}
   @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req,res);
}
}
