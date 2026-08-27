package com.sio2.garazy.exception;

public class ResourceNotFoundException extends RuntimeException {
	private String entity;
	private String message;
	public ResourceNotFoundException(String entity, String message) {
		super(entity + message);
		this.entity = entity;
		this.message = message;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
}
