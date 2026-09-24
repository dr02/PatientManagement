package com.flm.patient.dto;

import java.time.LocalDate;

import com.flm.patient.constant.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPatientRequestDTO {
	private String patientName;
	private Gender gender;
	private String patientEmail;
	private String patientPhoneNumber;
	private LocalDate dateOfBirth;
	private PatientAddressRequestDTO patientAddress;
}
