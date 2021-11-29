package com.nt.service;

import com.nt.bao.PatientBO;
import com.nt.dao.PatientDAO;

public class PatientMgMtServiceImpl implements PatientMgMtService {
	private PatientDAO dao;
	

	


	public PatientMgMtServiceImpl() {
		dao= new PatientDAO();
	}





	@Override
	public String register(PatientBO bo)throws Exception {
		String result= dao.submit(bo);
		
		return result;
	}

}
