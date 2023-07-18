package com.employwise.employwisebe.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long fieldVlue;

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldVlue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldVlue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldVlue = Long.parseLong(fieldVlue);
	}

}
