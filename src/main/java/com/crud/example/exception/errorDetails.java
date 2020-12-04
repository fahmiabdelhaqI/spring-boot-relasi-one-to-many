package com.crud.example.exception;

import java.util.Date;

public class errorDetails {

	private Date timestamp;
	private String pesan;
	private String details;
	
	public errorDetails(String details, String pesan, Date timestamp ) {
	super();
	this.timestamp = timestamp;
	this.pesan = pesan;
	this.details = details;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getpesan() {
		return pesan;
	}
	
	public String getDetails() {
		return details;
	}
}
