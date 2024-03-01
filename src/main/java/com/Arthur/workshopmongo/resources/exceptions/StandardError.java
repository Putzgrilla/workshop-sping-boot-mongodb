package com.Arthur.workshopmongo.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long timesstamp;
	private Integer Status;
	private String error;
	private String mensage;
	private String path;

	public StandardError() {
	}

	public StandardError(Long timesstamp, Integer status, String error, String mensage, String path) {
		super();
		this.timesstamp = timesstamp;
		Status = status;
		this.error = error;
		this.mensage = mensage;
		this.path = path;
	}

	public Long getTimesstamp() {
		return timesstamp;
	}

	public void setTimesstamp(Long timesstamp) {
		this.timesstamp = timesstamp;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}
