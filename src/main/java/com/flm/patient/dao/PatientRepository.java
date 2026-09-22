package com.flm.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flm.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	@Query(value = "SELECT patient_id FROM patient_details WHERE patient_id LIKE CONCAT(?1,'%') ORDER BY patient_id DESC LIMIT 1", nativeQuery = true)
	String lastPatientIdUsed(String currentDate);
}
