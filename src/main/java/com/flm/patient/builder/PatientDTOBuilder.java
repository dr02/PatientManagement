package com.flm.patient.builder;

import com.flm.patient.constant.Gender;
import com.flm.patient.dto.PatientAddressResponseDTO;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.model.Patient;
import com.flm.patient.model.PatientAddress;

public class PatientDTOBuilder {

	public static RegisterPatientResponseDTO buildPatientResponseDTO(Patient patient) {
		return RegisterPatientResponseDTO.builder()
				.patientId(String.valueOf(patient.getId()))
				.patientName(patient.getName())
				.gender(Gender.valueOf(patient.getGender()))
				.patientEmail(patient.getEmail())
				.patientPhoneNumber(patient.getPhoneNumber())
				.dateOfBirth(patient.getDateOfBirth())
				.patientAddress(buildPatientAddressResponseDTO(patient.getPatientAddress()))
				.build();
	}
	
	private static PatientAddressResponseDTO buildPatientAddressResponseDTO(PatientAddress patientAddress) {
		return PatientAddressResponseDTO.builder()
				.patientAddressId(patientAddress.getId())
				.city(patientAddress.getCity())
				.state(patientAddress.getState())
				.country(patientAddress.getCountry())
				.landmark(patientAddress.getLandmark())
				.pincode(patientAddress.getPincode())
				.build();
	}
}
