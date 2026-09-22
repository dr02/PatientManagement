package com.flm.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAddressRequestDTO {
	private String doorNumber;
	private String landmark;
	private String city;
	private String country;
	private String state;
	private String pincode;
}
