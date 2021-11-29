package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bao.PatientBO;
import com.nt.dao.PatientDAO;
import com.nt.dto.PatientDTO;
import com.nt.service.PatientMgMtService;
import com.nt.service.PatientMgMtServiceImpl;

@WebServlet("/patient")
public class MainControler extends HttpServlet {
	private PatientMgMtService service=null;
	
	@Override
	public void init() throws ServletException {
		service= new PatientMgMtServiceImpl();
	}
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PatientDTO dto=null;
		PatientBO bo=null;
		PrintWriter pw=null;
		//get PrintWriter Object
		pw=res.getWriter();
		//read param value
		res.setContentType("text/html");
		String name=null,age=null,addr=null,phone=null,reference=null,result=null;
		name=req.getParameter("pname");
		age=req.getParameter("page");
		addr=req.getParameter("paddr");
		phone=req.getParameter("phone");
		reference=req.getParameter("preference");
		dto=new PatientDTO();
		bo=new PatientBO();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setAge(Integer.parseInt(age));
		dto.setPhone(Long.parseLong(phone));
		dto.setReferene(reference);
		
		bo.setName(dto.getName());
		bo.setAge(dto.getAge());
		bo.setAddr(dto.getAddr());
		bo.setPhone(dto.getPhone());
		bo.setReference(dto.getReferene());
		
		try {
		result=service.register(bo);
		pw.println("<h1 style='color:green;text-align:center'>"+result+"</h1>");
		}catch(Exception e) {
			pw.println("<h1 style='color:red;text-align:center'>Internal Problem Try Again</h1>");
		}
		pw.println("<a href='patient_register.html'>home</a>");
		
		
		
		
			
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
