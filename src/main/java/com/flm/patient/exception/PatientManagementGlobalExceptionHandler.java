package com.flm.patient.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PatientManagementGlobalExceptionHandler {
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatusCode.valueOf(404));
	}
}
