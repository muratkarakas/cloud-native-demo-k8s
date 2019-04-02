package com.eteration.cloud.demo.orderservice.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private double price;
	
	
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
