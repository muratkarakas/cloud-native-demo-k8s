package com.eteration.cloud.demo.orderservice.dto;

public class OrderResult {
	
	private String message;
	private double totalAmount;
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OrderResult [message=" + message + ", totalAmount=" + totalAmount + "]";
	}

}
