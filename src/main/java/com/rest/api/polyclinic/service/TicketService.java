package com.rest.api.polyclinic.service;

import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateTicketRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.TicketResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

/**
 * The TicketService interface, which stores the business logic for working with a ticket.
 */
public interface TicketService {
    ResponseEntity<TicketResponseDTO> findTicketById(UUID id);

    ResponseEntity<List<TicketResponseDTO>> findAllTickets();

    ResponseEntity<List<TicketResponseDTO>> findAllTicketsByPatientId(UUID patientId);

    ResponseEntity<List<TicketResponseDTO>> findAllTicketsByDoctorId(UUID doctorId);

    ResponseEntity<TicketResponseDTO> createTicket(CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO);

    ResponseEntity<TicketResponseDTO> updateTicket(UUID id,
                                                   CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO);

    ResponseEntity<TicketResponseDTO> deleteTicket(UUID id);
}
