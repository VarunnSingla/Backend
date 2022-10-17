package com.javainuse.model;

	import com.fasterxml.jackson.annotation.JsonIgnore;
	import com.fasterxml.jackson.annotation.JsonProperty;

	import javax.persistence.*;

	@Entity
	@Table(name = "CertifyResponse")
	public class DAOUser1 {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column @JsonProperty("transactionId")
		private String transactionId;
		
		
		@Column
		@JsonProperty("Server")
		private String Server;
		
		@Column
		@JsonProperty("Date")
		private String Date;
		@Column
		@JsonProperty("Content-Type")
		private String ContentType;
		@Column
		@JsonProperty("Content-Type")
		private String ContentLength;
		@Column
		@JsonProperty("Connection")
		private String Connection;
		@Column
		@JsonProperty("X-Powered-By")
		private String XPoweredBy;
		@Column
		@JsonProperty("ETag")
		private String ETag;
		@Column
		@JsonProperty("Access-Control-Allow-Origin")
		private String AccessControlAllowOrigin;
		@Column
		@JsonProperty("Access-Control-Allow-Methods")
		private String AccessControlAllowMethods;
		@Column
		@JsonProperty("Access-Control-Allow-Headers")
		private String AccessControlAllowHeaders;
		
		public DAOUser1() {
			
		}
		
		public DAOUser1(int id, String transactionId, String server, String date, String contentType, String contentLength,
				String connection, String xPoweredBy, String eTag, String accessControlAllowOrigin,
				String accessControlAllowMethods, String accessControlAllowHeaders) {
			this.id = id;
			this.transactionId = transactionId;
			this.Server = server;
			this.Date = date;
			this.ContentType = contentType;
			this.ContentLength = contentLength;
			this.Connection = connection;
			this.XPoweredBy = xPoweredBy;
			this.ETag = eTag;
			this.AccessControlAllowOrigin = accessControlAllowOrigin;
			this.AccessControlAllowMethods = accessControlAllowMethods;
			this.AccessControlAllowHeaders = accessControlAllowHeaders;
		}
		
		
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public String getServer() {
			return Server;
		}
		public void setServer(String server) {
			Server = server;
		}
		public String getDate() {
			return Date;
		}
		public void setDate(String date) {
			Date = date;
		}
		public String getContentType() {
			return ContentType;
		}
		public void setContentType(String contentType) {
			ContentType = contentType;
		}
		public String getContentLength() {
			return ContentLength;
		}
		public void setContentLength(String contentLength) {
			ContentLength = contentLength;
		}
		public String getConnection() {
			return Connection;
		}
		public void setConnection(String connection) {
			Connection = connection;
		}
		public String getXPoweredBy() {
			return XPoweredBy;
		}
		public void setXPoweredBy(String xPoweredBy) {
			XPoweredBy = xPoweredBy;
		}
		public String getETag() {
			return ETag;
		}
		public void setETag(String eTag) {
			ETag = eTag;
		}
		public String getAccessControlAllowOrigin() {
			return AccessControlAllowOrigin;
		}
		public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
			AccessControlAllowOrigin = accessControlAllowOrigin;
		}
		public String getAccessControlAllowMethods() {
			return AccessControlAllowMethods;
		}
		public void setAccessControlAllowMethods(String accessControlAllowMethods) {
			AccessControlAllowMethods = accessControlAllowMethods;
		}
		public String getAccessControlAllowHeaders() {
			return AccessControlAllowHeaders;
		}
		public void setAccessControlAllowHeaders(String accessControlAllowHeaders) {
			AccessControlAllowHeaders = accessControlAllowHeaders;
		}
		
	}
		

