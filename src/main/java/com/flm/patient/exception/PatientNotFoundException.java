package com.flm.patient.exception;

public class PatientNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6397072217986865744L;
	
	public PatientNotFoundException(String message) {
		super(message);
	}
}
