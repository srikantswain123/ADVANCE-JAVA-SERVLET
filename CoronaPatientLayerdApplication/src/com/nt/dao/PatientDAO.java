package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bao.PatientBO;

public class PatientDAO {



	private static final String QUERY="INSERT INTO CORONA_TABLE VALUES(SEQ_NO.NEXTVAL,?,?,?,?,?)";
	private static final String DS_JNDI_NAME="java:/comp/env/DsJndi";
	
	
	public  String submit(PatientBO bo) throws Exception{
		int count=0;
		Connection con=null;
		//statement object for storing data
		PreparedStatement ps=null;
		//get Connection throw conection Object
		con=getPooledConnection(DS_JNDI_NAME);
		ps=con.prepareStatement(QUERY);
		ps.setString(1,bo.getName());
		ps.setInt(2, bo.getAge());
		ps.setString(3, bo.getAddr());
		ps.setLong(4, bo.getPhone());
		ps.setString(5, bo.getReference());
		count=ps.executeUpdate();
		
		return count==0?"Registration Failed":"Registration Succeded";
		
		
		
		
	
	}
	  
	private Connection getPooledConnection(String jndi)throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create connection initial context for jndi
		ic=new InitialContext();
		//get Data Source Object
		ds=(DataSource)ic.lookup(jndi);
		//get Connection from Data Source
		con=ds.getConnection();
		return con;
	}
	
	
	

}
