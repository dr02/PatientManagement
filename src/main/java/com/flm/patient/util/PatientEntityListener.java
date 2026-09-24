package com.flm.patient.util;

import org.springframework.stereotype.Component;

import com.flm.patient.model.Patient;

import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PatientEntityListener {
	private final PatientIdGenerator patientIdGenerator;
	
	@PrePersist
	public void generateNewPatientId(Patient patient) {
		if (patient != null) {
			Long newPatientId = patientIdGenerator.generateNewPatientId();
			if (patient.getId() == null) patient.setId(newPatientId);
		}
	}
}
