import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/indurl")
public class IndianSallary extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String inSallary=req.getParameter("ins");
		int sallary=Integer.parseInt(inSallary)+50000;
		pw.println("<h1 style='color:red;text-align:center'>Indian Sallary"+sallary+"</h1>");
		//get source application context
	       ServletContext sc=getServletContext();
	       //get destination ServletContext
	       ServletContext fc=sc.getContext("/AmericanSallary");
	       RequestDispatcher rd=null;
	       
	       rd=fc.getRequestDispatcher("/usaurl");
	       rd.include(req, res);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

}
