package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;
@WebServlet("/furl")
public class UploadServlet extends HttpServlet {
	
	private final static  String QUERY="INSERT INTO UPLOAD NAME,PHOTO,RESUME VALUES(?,?,?)";
	//get underlying jndi
	
	@Resource(name="DsJndi")
	
	private DataSource ds;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//create Special Request
		MultipartFormDataRequest request=null;
		 //Create Upload BeanObject
		 UploadBean ubean=null;
		 String name=null,photo=null,resume=null,frame1=null,frame2=null;
		 Hashtable map=null;
		 Connection con=null;
		 PreparedStatement ps=null;
		 RequestDispatcher rd=null;
		
		 		
		try {
		
		 //Create Object for special request and pass Servlet Request
		 request=new MultipartFormDataRequest(req);
		 ubean=new UploadBean();
		 ubean.setFolderstore("D:/upload");
		 ubean.setOverwrite(false);
		 //read request param value by special request
		name= request.getParameter("pname");
		map=request.getFiles();
		ubean.store(request,"cphoto");
		ubean.store(request,"cresume");
		frame1=((UploadFile)map.get("cphoto")).getFileName();
		frame2=((UploadFile)map.get("cresume")).getFileName();
		//creatae connection object
		con=ds.getConnection();
		if(con!=null) 
			ps=con.prepareStatement(QUERY);
		if(ps!=null)
			ps.setString(1,name); ps.setString(2, frame1); ps.setString(3, frame2);
		pw.println("<h1 style='color:red;text-align:center>File uploaded Succesfully");
		 
		 
		}catch(SQLException se) {
			se.printStackTrace();
			rd=req.getRequestDispatcher("/errurl");
			rd.forward(req, res);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
