package com.eteration.cloud.demo.orderservice.dto;

import java.io.Serializable;
import java.util.Date;

public class RatingEventDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String operationType;
	private long customerId;
	private long productId;
	private Date operationDate;

	@Override
	public String toString() {
		return "RatingEventDTO [operationType=" + operationType + ", customerId=" + customerId + ", productId="
				+ productId + ", operationDate=" + operationDate + "]";
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

}
