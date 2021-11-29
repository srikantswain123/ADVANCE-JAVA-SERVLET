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
@WebServlet("/stateurl")
public class StateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sc=null;
		ServletContext fc=null;
		RequestDispatcher rd=null;
		
		float billAmt=0.0f;
		billAmt=Float.parseFloat(req.getParameter("billAmt"));
		if(billAmt>50000)
			pw.println("<br>State Gst(8%)::"+billAmt*.1);
		else if(billAmt>30000)
			pw.println("<br>State (6%)::"+billAmt*.08);
		else if(billAmt>15000)
			pw.println("<br>State Gst(2%)::"+billAmt*.06);
		else
			pw.println("<br>State Gst(1%)::"+billAmt*.03);
		sc=getServletContext();
		fc=sc.getContext("/CentralGstApp");
		rd=fc.getRequestDispatcher("/centralurl");
		rd.include(req, res);
		pw.println("<a href='index.html'>Home</a>");
		pw.close();
		
			
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
