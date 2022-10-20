
package com.javainuse.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
public class BookTable {
	
	@JsonProperty("transactionId")
	private String transactionId;
	
	@JsonProperty("Server")
	private String Server;
	
	@JsonProperty("Date")
	private String Date;
	
	@JsonProperty("Content-Type")
	private String ContentType;
	
	@JsonProperty("Content-Length")
	private String ContentLength;
	
	@JsonProperty("Connection")
	private String Connection;
	
	@JsonProperty("X-Powered-By")
	private String XPoweredBy;
	
	@JsonProperty("ETag")
	private String ETag;
	
	@JsonProperty("Access-Control-Allow-Origin")
	private String AccessControlAllowOrigin;
	
	@JsonProperty("Access-Control-Allow-Methods")
	private String AccessControlAllowMethods;
	
	@JsonProperty("Access-Control-Allow-Headers")
	private String AccessControlAllowHeaders;
	
	
	public BookTable() {
		
	}
	
	public BookTable(String transactionId, String server, String date, String contentType, String contentLength,
			String connection, String xPoweredBy, String eTag, String accessControlAllowOrigin,
			String accessControlAllowMethods, String accessControlAllowHeaders)
		{
	
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
		this.Server = server;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		this.ContentType = contentType;
	}

	public String getContentLength() {
		return ContentLength;
	}

	public void setContentLength(String contentLength) {
		this.ContentLength = contentLength;
	}

	public String getConnection() {
		return Connection;
	}

	public void setConnection(String connection) {
		this.Connection = connection;
	}

	public String getXPoweredBy() {
		return XPoweredBy;
	}

	public void setXPoweredBy(String xPoweredBy) {
		this.XPoweredBy = xPoweredBy;
	}

	public String getETag() {
		return ETag;
	}

	public void setETag(String eTag) {
		this.ETag = eTag;
	}

	public String getAccessControlAllowOrigin() {
		return AccessControlAllowOrigin;
	}

	public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
		this.AccessControlAllowOrigin = accessControlAllowOrigin;
	}

	public String getAccessControlAllowMethods() {
		return AccessControlAllowMethods;
	}

	public void setAccessControlAllowMethods(String accessControlAllowMethods) {
		this.AccessControlAllowMethods = accessControlAllowMethods;
	}

	public String getAccessControlAllowHeaders() {
		return AccessControlAllowHeaders;
	}

	public void setAccessControlAllowHeaders(String accessControlAllowHeaders) {
		this.AccessControlAllowHeaders = accessControlAllowHeaders;
	}

	@Override
	public String toString() {
		return "BookTable [transactionId=" + transactionId + ", Server=" + Server + ", Date=" + Date + ", ContentType="
				+ ContentType + ", ContentLength=" + ContentLength + ", Connection=" + Connection + ", XPoweredBy="
				+ XPoweredBy + ", ETag=" + ETag + ", AccessControlAllowOrigin=" + AccessControlAllowOrigin
				+ ", AccessControlAllowMethods=" + AccessControlAllowMethods + ", AccessControlAllowHeaders="
				+ AccessControlAllowHeaders + "]";
	}

	
	
}
