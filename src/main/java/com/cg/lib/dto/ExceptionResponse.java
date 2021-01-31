package com.cg.lib.dto;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + "]";
	}
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionResponse(Date timestamp, int status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	
}
