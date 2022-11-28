package com.javainuse.model;

public class RevokeDTO {

	private String certificateId;
	private String entityName;
	private String endDate;
	
	public RevokeDTO() {
		
	}

	public RevokeDTO(String certificateId, String entityName, String endDate) {
		this.certificateId = certificateId;
		this.entityName = entityName;
		this.endDate = endDate;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "RevokeDTO [certificateId=" + certificateId + ", entityName=" + entityName + ", endDate=" + endDate
				+ "]";
	}

}
