package com.oracle.notebookServer.model;

import java.util.Date;

public class CustomisedErrorResponse {

	private String message;

	private long timeStamp;

	private int httpCode;

	public CustomisedErrorResponse() {

	}

	public CustomisedErrorResponse(String message, long timeStamp, int httpCode) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.httpCode = httpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

}
