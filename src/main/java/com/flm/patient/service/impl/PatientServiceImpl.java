package com.flm.patient.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flm.patient.builder.PatientBuilder;
import com.flm.patient.builder.PatientDTOBuilder;
import com.flm.patient.clients.AppointmentsClient;
import com.flm.patient.dao.PatientRepository;
import com.flm.patient.dto.RegisterPatientRequestDTO;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.exception.PatientNotFoundException;
import com.flm.patient.model.Patient;
import com.flm.patient.service.PatientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{
	private final PatientRepository patientRepository;
	private final AppointmentsClient appointmentsClient;
	
	@Override
	public RegisterPatientResponseDTO registerPatient(RegisterPatientRequestDTO registerPatientRequestDTO) {
		Patient patient = PatientBuilder.buildPatient(registerPatientRequestDTO);
		Patient savedPatient = patientRepository.save(patient);
		
		return PatientDTOBuilder.buildPatientResponseDTO(savedPatient);
	}

	@Override
	public RegisterPatientResponseDTO updatePatient(String patientId,
			RegisterPatientRequestDTO registerPatientRequestDTO) {
		long id = Long.parseLong(patientId);
		findPatientByPatientId(id);
		
		Patient updatedPatient = PatientBuilder.buildPatient(registerPatientRequestDTO);
		Patient updatedPatientObj = patientRepository.save(updatedPatient);
		
		return PatientDTOBuilder.buildPatientResponseDTO(updatedPatientObj);
	}
	
	private Patient findPatientByPatientId(Long patientId) {
		Optional<Patient> optional = patientRepository.findById(patientId);
		return optional.orElseThrow(() -> new PatientNotFoundException("Patient with Id: "+patientId+" not found."));
	}

	@Override
	public RegisterPatientResponseDTO getPatientByPatientId(String patientId) {
		long id = Long.parseLong(patientId);
		Patient patient = findPatientByPatientId(id);
		return PatientDTOBuilder.buildPatientResponseDTO(patient);
	}

	@Override
	public List<RegisterPatientResponseDTO> getPatientByName(String name) {
		List<Patient> patientList = patientRepository.searchPatientsUsingName(name);
		return patientList
				.stream()
				.map(PatientDTOBuilder::buildPatientResponseDTO)
				.toList();
	}

	@Override
	public List<RegisterPatientResponseDTO> getDoctorPatients(String staffId, LocalDate startDate, LocalDate endDate) {
		List<String> patientsId = appointmentsClient.getDoctorPatients(staffId, startDate, endDate).getBody();
		return patientsId
				.stream().map(Long::parseLong).map((id) -> findPatientByPatientId(id))
				.map(PatientDTOBuilder::buildPatientResponseDTO).toList();
	}

}
