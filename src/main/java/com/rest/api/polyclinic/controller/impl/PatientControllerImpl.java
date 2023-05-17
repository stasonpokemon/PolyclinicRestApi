package com.rest.api.polyclinic.controller.impl;

import com.rest.api.polyclinic.controller.PatientController;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdatePatientRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.PatientResponseDTO;
import com.rest.api.polyclinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Implementation class for PatientController.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class PatientControllerImpl implements PatientController {

    private final PatientService patientService;

    @Override
    public ResponseEntity<PatientResponseDTO> findPatientById(UUID id) {

        log.info("Trying to get patient with id: {}", id);

        ResponseEntity<PatientResponseDTO> patientResponseDTOResponseEntity =
                patientService.findPatientById(id);

        log.info("Successful get patient: {}", patientResponseDTOResponseEntity.getBody());

        return patientResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<List<PatientResponseDTO>> findAllPatients() {

        log.info("Trying to get all patients");

        ResponseEntity<List<PatientResponseDTO>> patientsResponseDTOResponseEntity =
                patientService.findAllPatients();

        log.info("Successful get patients: {}", patientsResponseDTOResponseEntity);

        return patientsResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<PatientResponseDTO> createPatient(CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO) {

        log.info("Trying to create patient: {}", createOrUpdatePatientRequestDTO);

        ResponseEntity<PatientResponseDTO> createdPatientResponseDTOResponseEntity =
                patientService.createPatient(createOrUpdatePatientRequestDTO);

        log.info("Successful create new patient: {}", createdPatientResponseDTOResponseEntity.getBody());

        return createdPatientResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<PatientResponseDTO> updatePatient(UUID id,
                                                            CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO) {

        log.info("Trying to update patient: {} with id: {}", createOrUpdatePatientRequestDTO, id);

        ResponseEntity<PatientResponseDTO> updatedPatientResponseDTOResponseEntity =
                patientService.updatePatient(id, createOrUpdatePatientRequestDTO);

        log.info("Successful update patient: {}", updatedPatientResponseDTOResponseEntity.getBody());

        return updatedPatientResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<PatientResponseDTO> deletePatient(UUID id) {

        log.info("Trying to delete patient with id: {}", id);

        ResponseEntity<PatientResponseDTO> deletedPatientResponseDTOResponseEntity =
                patientService.deletePatient(id);

        log.info("Successful delete patient: {}", deletedPatientResponseDTOResponseEntity.getBody());

        return deletedPatientResponseDTOResponseEntity;
    }
}
