package com.eteration.cloud.demo.orderservice.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String surname;
	private String address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

	
	
	
}
