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

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=null;
		ServletContext sc=null;
		req.setAttribute("attr1", "val1");
		RequestDispatcher rd=null;
		ses=req.getSession();
		ses.setAttribute("attr2", "val2");
		sc=getServletContext();
		sc.setAttribute("attr3","val3");
		
		rd=req.getRequestDispatcher("/s2url");
		PrintWriter pw=null;
		pw=res.getWriter();
		
		pw.println("<h1 style='color:red;text-align:center'>Request Attribute from servlet1::"+req.getAttribute("attr1")+"</h1>");
		pw.println("<h1 style='color:red;text-align:center'>Session Attribute from servlet1::"+ses.getAttribute("attr2")+"</h1>");
		pw.println("<h1 style='color:red;text-align:center'>Application Scope Attribute from servlet1::"+sc.getAttribute("attr3")+"</h1>");
		//rd.forward(req, res);
	 
		
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
