package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;


@WebServlet("/Uploadurl")
public class UploadServlet extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds;
	private final static String UPLOAD_FILE="INSERT INTO UPLOAD_FILE VALUES(SEQ_NO.NEXTVAL,?,?,?)";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int count=0;
		//get Print Writer Object
		pw=res.getWriter();
		//set responce type
		res.setContentType("text/html");
		//GET Special request
		MultipartFormDataRequest mreq=null;
		//create Upload bean object for load binary data
		UploadBean ubean=null;
		//get Connection Object
		Connection con=null;
		//Get parameter Value
		String name=null,frame1=null,frame2=null;
		//create Prepaired Statement
	  PreparedStatement ps=null;
		Hashtable map=null;
		Enumeration<UploadFile> e=null;
		
		try {
		mreq=new MultipartFormDataRequest(req);
		ubean=new UploadBean();
		name=mreq.getParameter("cname");
		ubean.setFolderstore("c:/store");
		ubean.setOverwrite(false);
		ubean.store(mreq, "cphoto");
		ubean.store(mreq, "cresume");
		map=mreq.getFiles();
		frame1=((UploadFile)map.get("cphoto")).getFileName();
		frame2=((UploadFile)map.get("cresume")).getFileName();
		con=ds.getConnection();
		ps=con.prepareStatement(UPLOAD_FILE);
		ps.setString(1, name);
		ps.setString(2,getServletContext().getInitParameter("location")+frame1);
		ps.setString(3,getServletContext().getInitParameter("location")+frame2);
		count=ps.executeUpdate();
		if(count==0) {
			pw.println("<h1 style='color:red;text-align:center'>Invalid Format</h1>");
		}else {
			pw.println("<h1 style='color:red;text-align:center'>SucessFully submited</h1>");
			e=map.elements();
			while(e.hasMoreElements()) {
				UploadFile file=e.nextElement();
				pw.println("FIle Names"+file.getFileName()+"<br>File Size"+file.getFileSize()+"<br>File Type"+file.getContentType());
				
			}
			
		}
		
		
		}//try
		catch(Exception ec) {
			pw.println("<h1 style='color:red;Text-align:center'>File TYpe,size,content Invalid</h1>");
			ec.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
				
			}catch(Exception se) {
				se.printStackTrace();
			}
			pw.println("<a href='index.html'>Home</a>");
			pw.close();
		}
		
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
