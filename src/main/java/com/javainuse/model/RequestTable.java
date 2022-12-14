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
		private String RequestPayload;
		@Column
		private String Status;
		@Column
		private String Request_Date_Time;
		
		private String divocCertificateid;
		@Column
		private String Is_Revoked;
		@Column
		private String Is_Suspended;
		@Column
		private String Suspended_Till;
		@Column
		private String Revoked_On;
		@Column
		private String Suspended_On;
		
		private String transactionId;
		
		@Column (name = "Schemaname")
		private String schemaname;
		
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

		public String getRequestPayload() {
			return RequestPayload;
		}

		public void setRequestPayload(String requestPayload) {
			this.RequestPayload = requestPayload;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			this.Status = status;
		}

		public String getRequest_Date_Time() {
			return Request_Date_Time;
		}

		public void setRequest_Date_Time(String request_Date_Time) {
			this.Request_Date_Time = request_Date_Time;
		}

		public String getDivocCertificateid() {
			return divocCertificateid;
		}

		public void setDivocCertificateid(String divocCertificateid) {
			this.divocCertificateid = divocCertificateid;
		}

		public String getIs_Revoked() {
			return Is_Revoked;
		}

		public void setIs_Revoked(String is_Revoked) {
			this.Is_Revoked = is_Revoked;
		}

		public String getIs_Suspended() {
			return Is_Suspended;
		}

		public void setIs_Suspended(String is_Suspended) {
			this.Is_Suspended = is_Suspended;
		}

		public String getSuspended_Till() {
			return Suspended_Till;
		}

		public void setSuspended_Till(String suspended_Till) {
			this.Suspended_Till = suspended_Till;
		}

		public String getRevoked_On() {
			return Revoked_On;
		}

		public void setRevoked_On(String revoked_On) {
			this.Revoked_On = revoked_On;
		}

		public String getSuspended_On() {
			return Suspended_On;
		}

		public void setSuspended_On(String suspended_On) {
			this.Suspended_On = suspended_On;
		}

		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public String getSchemaname() {
			return schemaname;
		}

		public void setSchemaname(String schemaname) {
			this.schemaname = schemaname;
		}

	
}
