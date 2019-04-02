package com.eteration.cloud.demo.orderservice.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private long productId;
	private long customerId;
	private int count;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "OrderDTO [productId=" + productId + ", customerId=" + customerId + ", count=" + count + "]";
	}
	

}
