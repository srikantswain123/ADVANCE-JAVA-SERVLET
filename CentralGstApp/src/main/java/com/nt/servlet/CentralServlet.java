package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/centralurl")
public class CentralServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		float billAmt=0.0f;
		billAmt=Float.parseFloat(req.getParameter("billAmt"));
		if(billAmt>50000)
			pw.println("<br>Central (8%)Gst::"+billAmt*.08);
		else if(billAmt>30000)
			pw.println("<br>Central(6%) Gst::"+billAmt*.06);
		else if(billAmt>15000)
			pw.println("<br>Central(2%) Gst::"+billAmt*.02);
		else
			pw.println("<br>Central(1%) Gst::"+billAmt*.01);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
