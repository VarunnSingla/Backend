package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {
	@JsonProperty("transactionId")
	private String transactionId;
	
	@JsonProperty("certificateId")
	private String certificateId;
	
	@JsonProperty("entityType")
	private String entityType;
	
	@JsonProperty("status")
	private String status;
	
	public TransactionDTO() {
		
	}
	
	public TransactionDTO(String transactionId, String certificateId, String entityType, String status) {
		this.transactionId = transactionId;
		this.certificateId = certificateId;
		this.entityType = entityType;
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", certificateId=" + certificateId + ", entityType="
				+ entityType + ", status=" + status + "]";
	}
	
}