package com.asnsignment.project.bookauthor.model;

import org.springframework.http.HttpStatus;

public class Response {

	private String msg;
	private HttpStatus status;

	public Response(String msg, HttpStatus status) {
		super();
		this.msg = msg;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
