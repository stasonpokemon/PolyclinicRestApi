package com.rest.api.polyclinic.entity.mapper;

import com.rest.api.polyclinic.entity.Patient;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdatePatientRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.PatientResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * This interface presents the basic contract for converting Patient to PatientDTO and vice versa.
 */
@Mapper
public interface PatientMapper {

     Patient createOrUpdatePatientRequestDTOToPatient(CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO);

     @Mapping(source = "id", target = "id")
     @Mapping(source = "age", target = "age")
     @Mapping(source = "address", target = "address")
     PatientResponseDTO patientToPatientResponseDTO(Patient patient);
}
