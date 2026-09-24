package com.flm.patient.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.flm.patient.dao.PatientRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PatientIdGenerator {
	private final PatientRepository patientRepository;
	
	public Long generateNewPatientId() {
		LocalDate current = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String currentDate = current.format(formatter);
		
		String lastPatientIdUsed = patientRepository.lastPatientIdUsed(currentDate);
		String newPatientIdStr = "";
		if(lastPatientIdUsed != null && lastPatientIdUsed.length() >= 14) {
			String lastIdDatePrefix = lastPatientIdUsed.substring(0, 8);
			if(currentDate.equals(lastIdDatePrefix)) {
				String lastIdSufixSequenceStr = lastPatientIdUsed.substring(8);
				int lastIdSuffixSequence = Integer.parseInt(lastIdSufixSequenceStr);
				lastIdSuffixSequence++;
				newPatientIdStr = currentDate+String.format("%06d", lastIdSuffixSequence);
				return Long.parseLong(newPatientIdStr);
			}
		}
		newPatientIdStr = currentDate+String.format("%06d", 1);
		return Long.parseLong(newPatientIdStr);
	}
}
