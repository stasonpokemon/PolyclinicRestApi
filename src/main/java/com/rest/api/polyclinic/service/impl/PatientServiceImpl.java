package com.rest.api.polyclinic.service.impl;

import com.rest.api.polyclinic.entity.Patient;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdatePatientRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.PatientResponseDTO;
import com.rest.api.polyclinic.entity.mapper.PatientMapper;
import com.rest.api.polyclinic.exception.NotFoundException;
import com.rest.api.polyclinic.repository.PatientRepository;
import com.rest.api.polyclinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation class for PatientService.
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);

    @Override
    public ResponseEntity<PatientResponseDTO> findPatientById(UUID id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Patient.class, id));

        log.info("Get patient from DB: {}", patient);

        return new ResponseEntity<>(patientMapper.patientToPatientResponseDTO(patient), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PatientResponseDTO>> findAllPatients() {

        List<Patient> patients = patientRepository.findAll();

        log.info("Get patients from DB: {}", patients);

        List<PatientResponseDTO> patientsDTO = patients.stream().map(patientMapper::patientToPatientResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientResponseDTO> createPatient(CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO) {

        Patient patient = patientMapper.createOrUpdatePatientRequestDTOToPatient(createOrUpdatePatientRequestDTO);

        log.info("Get doctor from DB: {}", patient);

        Patient createdDoctor = patientRepository.save(patient);

        log.info("Created patient: {}", createdDoctor);

        return new ResponseEntity<>(patientMapper.patientToPatientResponseDTO(createdDoctor), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PatientResponseDTO> updatePatient(UUID id,
                                                            CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO) {

        Patient patientForUpdating = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Patient.class, id));

        log.info("Get patient from DB: {}", patientForUpdating);

        fillPatientFieldsForUpdate(createOrUpdatePatientRequestDTO, patientForUpdating);

        Patient updatedPatient = patientRepository.save(patientForUpdating);

        log.info("Updated patient: {}", updatedPatient);

        return new ResponseEntity<>(patientMapper.patientToPatientResponseDTO(updatedPatient), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<PatientResponseDTO> deletePatient(UUID id) {

        Patient patientForDeleting = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Patient.class, id));

        log.info("Get patient from DB: {}", patientForDeleting);

        patientRepository.delete(patientForDeleting);

        log.info("Deleted patient: {}", patientForDeleting);

        return new ResponseEntity<>(patientMapper.patientToPatientResponseDTO(patientForDeleting), HttpStatus.OK);

    }

    private void fillPatientFieldsForUpdate(CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO,
                                            Patient patientForUpdating) {
        patientForUpdating.setFirstName(createOrUpdatePatientRequestDTO.getFirstName());
        patientForUpdating.setPatronymic(createOrUpdatePatientRequestDTO.getPatronymic());
        patientForUpdating.setLastName(createOrUpdatePatientRequestDTO.getLastName());
        patientForUpdating.setAge(createOrUpdatePatientRequestDTO.getAge());
        patientForUpdating.setGender(createOrUpdatePatientRequestDTO.getGender());
        patientForUpdating.setAddress(createOrUpdatePatientRequestDTO.getAddress());
        patientForUpdating.setPhoneNumber(createOrUpdatePatientRequestDTO.getPhoneNumber());
    }
}
