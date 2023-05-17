package com.rest.api.polyclinic.service;

import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateDoctorRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

/**
 * The DoctorService interface, which stores the business logic for working with a doctor.
 */
public interface DoctorService  {
    ResponseEntity<DoctorResponseDTO> findDoctorById(UUID id);

    ResponseEntity<List<DoctorResponseDTO>> findAllDoctors();

    ResponseEntity<DoctorResponseDTO> createDoctor(CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO);

    ResponseEntity<DoctorResponseDTO> updateDoctor(UUID id,
                                                   CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO);

    ResponseEntity<DoctorResponseDTO> deleteDoctor(UUID id);
}
