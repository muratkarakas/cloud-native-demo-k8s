package com.eteration.cloud.demo.ratingservice.dto;

import java.io.Serializable;
import java.util.Date;

public class RatingEventDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String operationType;
	private String customerId;
	private String productId;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

}
