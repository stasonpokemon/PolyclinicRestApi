package com.rest.api.polyclinic.service;

import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdatePatientRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.PatientResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

/**
 * The PatientService interface, which stores the business logic for working with a patient.
 */
public interface PatientService {
    ResponseEntity<PatientResponseDTO> findPatientById(UUID id);

    ResponseEntity<List<PatientResponseDTO>> findAllPatients();

    ResponseEntity<PatientResponseDTO> createPatient(CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO);

    ResponseEntity<PatientResponseDTO> updatePatient(UUID id,
                                                     CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO);

    ResponseEntity<PatientResponseDTO> deletePatient(UUID id);
}
