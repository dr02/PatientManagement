package com.flm.patient.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String landmark;
	
	private String state;
	
	private String city;
	
	private String country;
	
	private String pincode;

	public PatientAddress(String landmark, String state, String city, String country, String pincode) {
		super();
		this.landmark = landmark;
		this.state = state;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}
}
