package com.flm.patient.model;

import java.time.LocalDate;

import com.flm.patient.util.PatientEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(PatientEntityListener.class)
public class Patient {
	@Id
	@Column(name = "patient_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String gender;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_address_id")
	private PatientAddress patientAddress;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	public Patient(String name, String gender, String email, String phoneNumber, PatientAddress patientAddress,
			LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.patientAddress = patientAddress;
		this.dateOfBirth = dateOfBirth;
	}
	
}
