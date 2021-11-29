package com.nt.initailizer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;

public class MyWeAppInitializer implements ServletContainerInitializer {
	static {
		System.out.println("MyInitializer::static block");
	}
	public MyWeAppInitializer() {
		System.out.println("MyInitializer::using zero param constructor");
	}

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		 
		System.out.println("MyInitializer.onStartup()");
		
		MarriageServlet servlet=null;
		servlet=new MarriageServlet();
		//create Dynamic Registratin
		ServletRegistration.Dynamic dyna=null;
		dyna=sc.addServlet("ms", servlet);
		dyna.addMapping("/marriageurl");
		dyna.setLoadOnStartup(1);

	}

}
