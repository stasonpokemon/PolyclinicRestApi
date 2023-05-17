package com.rest.api.polyclinic.entity.mapper;

import com.rest.api.polyclinic.entity.Doctor;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateDoctorRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * This interface presents the basic contract for converting Doctor to DoctorDTO and vice versa.
 */
@Mapper
public interface DoctorMapper {

     Doctor createOrUpdateDoctorRequestDTOToDoctor(CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO);

     @Mapping(target = "firstName", source = "firstName")
     DoctorResponseDTO doctorToDoctorResponseDTO(Doctor doctor);
}
