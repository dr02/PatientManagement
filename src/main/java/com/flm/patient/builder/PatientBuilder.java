package com.flm.patient.builder;

import org.springframework.beans.BeanUtils;

import com.flm.patient.dto.PatientAddressRequestDTO;
import com.flm.patient.dto.RegisterPatientRequestDTO;
import com.flm.patient.model.Patient;
import com.flm.patient.model.PatientAddress;

public class PatientBuilder {

	public static Patient buildPatient(RegisterPatientRequestDTO registerPatientRequestDTO) {
		return Patient.builder()
				.name(registerPatientRequestDTO.getPatientName())
				.gender(registerPatientRequestDTO.getGender().toString())
				.email(registerPatientRequestDTO.getPatientEmail())
				.phoneNumber(registerPatientRequestDTO.getPatientPhoneNumber())
				.dateOfBirth(registerPatientRequestDTO.getDateOfBirth())
				.patientAddress(buildPatientAddress(registerPatientRequestDTO.getPatientAddress()))
				.build();
	}
	
	private static PatientAddress buildPatientAddress(PatientAddressRequestDTO patientAddressRequestDTO) {
		PatientAddress patientAddress = new PatientAddress();
		BeanUtils.copyProperties(patientAddressRequestDTO, patientAddress);
		return patientAddress;
	}
}
