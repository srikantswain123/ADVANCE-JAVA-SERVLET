package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/surl")
public class ReciveCookies extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//create printWriter Object
		pw=res.getWriter();
		//set response Content Type
		res.setContentType("text/html");
		//read cookies
		Cookie cks[]=req.getCookies();
	if(cks!=null) {
		pw.println("<table bgcolor='cyan' border='1'>");
		for(Cookie ck:cks) {
			pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		}
		pw.println("</table>");
		
		
	}
		

	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				doGet(req, res);
	}


}
