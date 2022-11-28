
package com.javainuse.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
public class BookTable {
	
	@JsonProperty("transactionId")
	private String transactionId;
	
	
	
	public BookTable() {
		
	}
	
	public BookTable(String transactionId)
		{
	
		this.transactionId = transactionId;
		
	}	
	
	
	public String getTransactionId() {
		return transactionId;
		
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	
	@Override
	public String toString() {
		return "BookTable [transactionId=" + transactionId + "]";
	}

	
	
}
