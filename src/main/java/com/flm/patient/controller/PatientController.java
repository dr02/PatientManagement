package com.flm.patient.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flm.patient.dto.RegisterPatientRequestDTO;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
	private final PatientService patientService;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterPatientResponseDTO> registerPatient(@RequestBody RegisterPatientRequestDTO registerPatientRequestDTO) {
		RegisterPatientResponseDTO registerPatientResponseDTO = patientService.registerPatient(registerPatientRequestDTO);
		return new ResponseEntity<RegisterPatientResponseDTO>(registerPatientResponseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<RegisterPatientResponseDTO> updatePatient(@PathVariable("id") String patientId, @RequestBody RegisterPatientRequestDTO registerPatientRequestDTO) {
		RegisterPatientResponseDTO updatePatientResponse = patientService.updatePatient(patientId, registerPatientRequestDTO);
		return ResponseEntity.ok(updatePatientResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RegisterPatientResponseDTO> getPatientByPatientId(@PathVariable("id") String patientId) {
		RegisterPatientResponseDTO responseDTO = patientService.getPatientByPatientId(patientId);
		return ResponseEntity.ok(responseDTO);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<RegisterPatientResponseDTO>> getPatientByName(@RequestParam("name") String name) {
		List<RegisterPatientResponseDTO> list = patientService.getPatientByName(name);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getDoctorPatients/{staffId}")
	public ResponseEntity<List<RegisterPatientResponseDTO>> getDoctorPatientsList(@PathVariable("staffId") String staffId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
		 List<RegisterPatientResponseDTO> doctorPatients = patientService.getDoctorPatients(staffId, startDate, endDate);
		 return ResponseEntity.ok(doctorPatients);
	}
}
