package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/furl")
public class FirstServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();
		// set Response ContentType
		res.setContentType("text/html");
		String name = null, addr = null, ms = null;
		HttpSession ses = null;
		// getSession Object
		ses = req.getSession(true);
		// read request parametre value
		name = req.getParameter("pname");
		addr = req.getParameter("paddr");
		ms = req.getParameter("ms");

		ses.setAttribute("name", name);
		ses.setAttribute("addr", addr);
		ses.setAttribute("ms", ms);
		ses.setMaxInactiveInterval(60);
		long stime=ses.getCreationTime();
		Date d=null;
		d=new Date(stime);
		pw.println("<h1 style='color:red'>Session Start Time::"+d);
	
		
		pw.println("<b>" + ses.getId() + "</b>");

		if (ms == null)
			ms = "single";

		if (ms.equalsIgnoreCase("married")) {
			pw.println("<form action="+res.encodeUrl("surl")+" method='get'>");
			pw.println("<table bgcolor='cyan' align='center' border='1'>");
			pw.println("<tr><td>Spouse Name</td><td><input type='text' name='spn'></td></tr>");
			pw.println("<tr><td>Enter Child</td><td><input type='text' name='cn'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");

		} else {
			pw.println("<form action="+res.encodeUrl("surl")+" method='get'>");
			pw.println("<table bgcolor='cyan' align='center' border='1'>");
			pw.println("<tr><td>When to marry</td><td><input type='text' name='spn'></td></tr>");
			pw.println("<tr><td>why u awant tomarry</td><td><input type='text' name='cn'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");

		}
		

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
