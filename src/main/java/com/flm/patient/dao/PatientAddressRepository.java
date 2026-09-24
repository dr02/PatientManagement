package com.flm.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flm.patient.model.PatientAddress;

public interface PatientAddressRepository extends JpaRepository<PatientAddress, Long>{

}
