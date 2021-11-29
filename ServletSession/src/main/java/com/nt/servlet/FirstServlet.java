package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/furl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();

		Cookie ck1 = null, ck2 = null, ck3 = null;

		res.setContentType("text/html");
		String name = null, addr = null, ms = null;
		name = req.getParameter("pname");
		addr = req.getParameter("addr");
		ms = req.getParameter("ms");
		ck1 = new Cookie("name", name);
		ck2 = new Cookie("addr", addr);
		ck3 = new Cookie("ms", ms);
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		if (ms == null)
			ms = "single";
		if (ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color:red;text-align:center'>Married status</h1>");
			pw.println("<form action='surl' method='post'>");
			pw.println("<table bgcolor='cyan'align='center' boredr='1'>");
			pw.println("<tr><td>Enter Spouce</td><td><input type='text' name='f1s'></td></tr>");
			pw.println("<tr><td>Enter child</td><td><input type='text' name='f1c'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			/*pw.println("<tr><td colspan='2'><input type='hidden' name='hname' value='"+pname+"'>"
					+ "<input type='hidden' name='hadd' value='"+addr+"'><input type='hidden' name='hms' value='"+ms+"'></td></tr>");*/
			pw.println("</table>");
			pw.println("</form>");
		} else {
			pw.println("<h1 style='color:red;text-align:center'>Bachelor staus</h1>");
			pw.println("<form action='surl' method='post'>");
			pw.println("<table bgcolor='cyan'align='center' boredr='1'>");
			pw.println("<tr><td>When to marry</td><td><input type='text' name='f1s'></td></tr>");
			pw.println("<tr><td>why u want to marry</td><td><input type='text' name='f1c'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			/*pw.println("<tr><td colspan='2'><input type='hidden' name='hname' value='"+pname+"'>"
					+ "<input type='hidden' name='hadd' value='"+addr+"'><input type='hidden' name='hms' value='"+ms+"'></td></tr>");*/
			pw.println("</table>");
			pw.println("</form>");

		}
		pw.close();

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
