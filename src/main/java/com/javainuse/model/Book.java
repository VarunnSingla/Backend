package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class Book {
	@JsonProperty("name")
	private String name;
	@JsonProperty("dob")
	private String dob;
	@JsonProperty("registrationId")
	private String registrationId;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("registrationCouncil")
	private String registrationCouncil;
	@JsonProperty("latestQualification")
	private String latestQualification;
	@JsonProperty("university")
	private String university;
	@JsonProperty("degreeYear")
	private String degreeYear;
	
	private String systemOfMedicine;
	private String registrationDate;
	private String registrationExpiry;
	private String issuer;
	private String issuanceDate;
	
	public Book() {
		
	}
	public Book(String name, String dob, String registrationId, String gender, String registrationCouncil,
			String latestQualification, String university, String degreeYear, String systemOfMedicine,
			String registrationDate, String registrationExpiry, String issuer, String issuanceDate) {
		this.name = name;
		this.dob = dob;
		this.registrationId = registrationId;
		this.gender = gender;
		this.registrationCouncil = registrationCouncil;
		this.latestQualification = latestQualification;
		this.university = university;
		this.degreeYear = degreeYear;
		this.systemOfMedicine = systemOfMedicine;
		this.registrationDate = registrationDate;
		this.registrationExpiry = registrationExpiry;
		this.issuer = issuer;
		this.issuanceDate = issuanceDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegistrationCouncil() {
		return registrationCouncil;
	}
	public void setRegistrationCouncil(String registrationCouncil) {
		this.registrationCouncil = registrationCouncil;
	}
	public String getLatestQualification() {
		return latestQualification;
	}
	public void setLatestQualification(String latestQualification) {
		this.latestQualification = latestQualification;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getDegreeYear() {
		return degreeYear;
	}
	public void setDegreeYear(String degreeYear) {
		this.degreeYear = degreeYear;
	}
	public String getSystemOfMedicine() {
		return systemOfMedicine;
	}
	public void setSystemOfMedicine(String systemOfMedicine) {
		this.systemOfMedicine = systemOfMedicine;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getRegistrationExpiry() {
		return registrationExpiry;
	}
	public void setRegistrationExpiry(String registrationExpiry) {
		this.registrationExpiry = registrationExpiry;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getIssuanceDate() {
		return issuanceDate;
	}
	public void setIssuanceDate(String issuanceDate) {
		this.issuanceDate = issuanceDate;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", dob=" + dob + ", registrationId=" + registrationId + ", gender=" + gender
				+ ", registrationCouncil=" + registrationCouncil + ", latestQualification=" + latestQualification
				+ ", university=" + university + ", degreeYear=" + degreeYear + ", systemOfMedicine=" + systemOfMedicine
				+ ", registrationDate=" + registrationDate + ", registrationExpiry=" + registrationExpiry + ", issuer="
				+ issuer + ", issuanceDate=" + issuanceDate;
	}
	
}