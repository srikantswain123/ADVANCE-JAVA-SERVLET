package com.nt.dto;

import java.io.Serializable;

public class PatientDTO implements Serializable {
	private String name;
	private int age;
	private String addr;
	private long phone;
	private String referene;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getReferene() {
		return referene;
	}
	public void setReferene(String referene) {
		this.referene = referene;
	}
	
	

}
