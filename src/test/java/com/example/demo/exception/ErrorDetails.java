package com.example.demo.exception;

import java.util.Date;

public class ErrorDetails {

	
	private String message;
	private String details;
	private Date timeStamp;
	
	
	public ErrorDetails(Date timeStamp, String details, String message) {
		super();
		this.message = message;
		this.details = details;
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
