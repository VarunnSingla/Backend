package com.javainuse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name ="certifyrequest")
public class RequestTable {		
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column
		private String name;
		@Column
		private String dob;
		@Column
		private String registrationId;
		@Column 
		private String gender;
		@Column 
		private String registrationCouncil;
		@Column 
		private String latestQualification;
		@Column 
		private String university;
		@Column 
		private String degreeYear;
		@Column
		private String systemOfMedicine;
		
		@Column
		private String registrationDate;
		
		@Column
		private String registrationExpiry;
		
		@Column
		private String issuer;
		@Column
		private String issuanceDate;
		@Column 
		private String transactionId;
		
		public RequestTable() {
			
		}
		
		public RequestTable(int id, String name, String dob, String registrationId, String gender,
				String registrationCouncil, String latestQualification, String university, String degreeYear,
				String systemOfMedicine, String registrationDate, String registrationExpiry, String issuer,
				String issuanceDate, String transactionId) {
			this.id = id;
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
			this.transactionId = transactionId;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
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
		
		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		
	
}
