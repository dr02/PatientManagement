package com.flm.patient.service;

import java.time.LocalDate;
import java.util.List;

import com.flm.patient.dto.RegisterPatientRequestDTO;
import com.flm.patient.dto.RegisterPatientResponseDTO;

public interface PatientService {
	RegisterPatientResponseDTO registerPatient(RegisterPatientRequestDTO registerPatientRequestDTO);
	RegisterPatientResponseDTO updatePatient(String patientId, RegisterPatientRequestDTO registerPatientRequestDTO);
	RegisterPatientResponseDTO getPatientByPatientId(String patietId);
	List<RegisterPatientResponseDTO> getPatientByName(String name);
	List<RegisterPatientResponseDTO> getDoctorPatients(String staffId, LocalDate startDate, LocalDate endDate);
}
