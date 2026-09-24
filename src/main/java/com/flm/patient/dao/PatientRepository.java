package com.flm.patient.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	@Query(value = "SELECT patient_id FROM patient_details WHERE patient_id LIKE CONCAT(?1,'%') ORDER BY patient_id DESC LIMIT 1", nativeQuery = true)
	String lastPatientIdUsed(String currentDate);
	
	@Query("SELECT p FROM Patient p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<Patient> searchPatientsUsingName(@Param("name") String name);
}
