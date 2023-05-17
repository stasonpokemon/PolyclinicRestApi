package com.rest.api.polyclinic.controller.impl;

import com.rest.api.polyclinic.controller.DoctorController;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateDoctorRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
import com.rest.api.polyclinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


/**
 * Implementation class for DoctorController.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class DoctorControllerImpl implements DoctorController {

    private final DoctorService doctorService;

    @Override
    public ResponseEntity<DoctorResponseDTO> findDoctorById(UUID id) {

        log.info("Trying to get doctor with id: {}", id);

        ResponseEntity<DoctorResponseDTO> doctorResponseDTOResponseEntity =
                doctorService.findDoctorById(id);

        log.info("Successful get doctor: {}", doctorResponseDTOResponseEntity.getBody());

        return doctorResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> findAllDoctors() {

        log.info("Trying to get all doctors");

        ResponseEntity<List<DoctorResponseDTO>> doctorsResponseDTOResponseEntity =
                doctorService.findAllDoctors();

        log.info("Successful get doctors: {}", doctorsResponseDTOResponseEntity);

        return doctorsResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> createDoctor(CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO) {

        log.info("Trying to create doctor: {}", createOrUpdateDoctorRequestDTO);

        ResponseEntity<DoctorResponseDTO> createdDoctorResponseDTOResponseEntity =
                doctorService.createDoctor(createOrUpdateDoctorRequestDTO);

        log.info("Successful create new doctor: {}", createdDoctorResponseDTOResponseEntity.getBody());

        return createdDoctorResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> updateDoctor(UUID id,
                                                          CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO) {

        log.info("Trying to update doctor: {} with id: {}", createOrUpdateDoctorRequestDTO, id);

        ResponseEntity<DoctorResponseDTO> updatedDoctorResponseDTOResponseEntity =
                doctorService.updateDoctor(id, createOrUpdateDoctorRequestDTO);

        log.info("Successful update doctor: {}", updatedDoctorResponseDTOResponseEntity.getBody());

        return updatedDoctorResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> deleteDoctor(UUID id) {
        log.info("Trying to delete doctor with id: {}", id);

        ResponseEntity<DoctorResponseDTO> deletedDoctorResponseDTOResponseEntity =
                doctorService.deleteDoctor(id);

        log.info("Successful delete doctor: {}", deletedDoctorResponseDTOResponseEntity.getBody());

        return deletedDoctorResponseDTOResponseEntity;
    }
}
