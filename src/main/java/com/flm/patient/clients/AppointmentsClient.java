package com.flm.patient.clients;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "AppointmentManagement")
public interface AppointmentsClient {
	@GetMapping("/appointments/{doctorId}")
	public ResponseEntity<List<String>> getDoctorPatients(@PathVariable String doctorId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate);
}
