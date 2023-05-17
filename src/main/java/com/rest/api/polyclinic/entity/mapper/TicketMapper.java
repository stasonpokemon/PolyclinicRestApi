package com.rest.api.polyclinic.entity.mapper;

import com.rest.api.polyclinic.entity.Ticket;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateTicketRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.TicketResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * This interface presents the basic contract for converting Ticket to TicketDTO and vice versa.
 */
@Mapper
public interface TicketMapper {

    @Mapping(target = "patient.id", expression = "java(UUID.fromString(createOrUpdateTicketRequestDTO.getPatientId()))")
    @Mapping(target = "doctor.id", source = "doctorId")
    Ticket createOrUpdateTicketRequestDTOToTicket(CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "doctorId", source = "doctor.id")
    TicketResponseDTO ticketToTicketResponseDTO(Ticket ticket);
}
