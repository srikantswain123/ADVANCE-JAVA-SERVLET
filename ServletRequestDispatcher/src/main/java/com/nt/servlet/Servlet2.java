package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<h1 style='color:red;text-align:center'>Request Attribute value form Servlet2"+req.getAttribute("attr1"));
		HttpSession ses=null;
		ses=req.getSession();
		pw.println("<h1 style='color:red;text-align:center'>Session Attribute value form Servlet2"+ses.getAttribute("attr2"));
		ServletContext sc=getServletContext();
		pw.println("<h1 style='color:red;text-align:center'>Application Scope Attribute value form Servlet2"+sc.getAttribute("attr3"));
		
		
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/s3url");
		//rd.forward(req, res);
		
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
