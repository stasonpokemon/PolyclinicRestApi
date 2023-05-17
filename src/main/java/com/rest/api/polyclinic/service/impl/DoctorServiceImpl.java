package com.rest.api.polyclinic.service.impl;

import com.rest.api.polyclinic.entity.Doctor;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateDoctorRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
import com.rest.api.polyclinic.entity.mapper.DoctorMapper;
import com.rest.api.polyclinic.exception.NotFoundException;
import com.rest.api.polyclinic.repository.DoctorRepository;
import com.rest.api.polyclinic.service.DoctorService;
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
 * Implementation class for DoctorService.
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper = Mappers.getMapper(DoctorMapper.class);

    @Override
    public ResponseEntity<DoctorResponseDTO> findDoctorById(UUID id) {

        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new NotFoundException(Doctor.class, id));

        log.info("Get doctor from DB: {}", doctor);

        return new ResponseEntity<>(doctorMapper.doctorToDoctorResponseDTO(doctor), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> findAllDoctors() {

        List<Doctor> doctors = doctorRepository.findAll();

        log.info("Get doctors from DB: {}", doctors);

        List<DoctorResponseDTO> doctorsDTO = doctors.stream().map(doctorMapper::doctorToDoctorResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> createDoctor(CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO) {

        Doctor doctor = doctorMapper.createOrUpdateDoctorRequestDTOToDoctor(createOrUpdateDoctorRequestDTO);

        log.info("Get doctor from DB: {}", doctor);

        Doctor createdDoctor = doctorRepository.save(doctor);

        log.info("Created doctor: {}", createdDoctor);

        return new ResponseEntity<>(doctorMapper.doctorToDoctorResponseDTO(createdDoctor), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> updateDoctor(UUID id,
                                                          CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO) {

        Doctor doctorForUpdating = doctorRepository.findById(id).orElseThrow(() -> new NotFoundException(Doctor.class, id));

        log.info("Get doctor from DB: {}", doctorForUpdating);

        fillDoctorFieldsForUpdate(createOrUpdateDoctorRequestDTO, doctorForUpdating);

        Doctor updatedDoctor = doctorRepository.save(doctorForUpdating);

        log.info("Updated doctor: {}", updatedDoctor);

        return new ResponseEntity<>(doctorMapper.doctorToDoctorResponseDTO(updatedDoctor), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<DoctorResponseDTO> deleteDoctor(UUID id) {

        Doctor doctorForDeleting = doctorRepository.findById(id).orElseThrow(() -> new NotFoundException(Doctor.class, id));

        log.info("Get doctor from DB: {}", doctorForDeleting);

        doctorRepository.delete(doctorForDeleting);

        log.info("Deleted doctor: {}", doctorForDeleting);

        return new ResponseEntity<>(doctorMapper.doctorToDoctorResponseDTO(doctorForDeleting), HttpStatus.OK);
    }

    private static void fillDoctorFieldsForUpdate(CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO, Doctor doctorForUpdating) {
        doctorForUpdating.setFirstName(createOrUpdateDoctorRequestDTO.getFirstName());
        doctorForUpdating.setPatronymic(createOrUpdateDoctorRequestDTO.getPatronymic());
        doctorForUpdating.setLastName(createOrUpdateDoctorRequestDTO.getLastName());
        doctorForUpdating.setGender(createOrUpdateDoctorRequestDTO.getGender());
        doctorForUpdating.setPosition(createOrUpdateDoctorRequestDTO.getPosition());
        doctorForUpdating.setPhoneNumber(createOrUpdateDoctorRequestDTO.getPhoneNumber());
    }
}
