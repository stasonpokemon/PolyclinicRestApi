package com.rest.api.polyclinic.controller.impl;

import com.rest.api.polyclinic.controller.TicketController;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateTicketRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
import com.rest.api.polyclinic.entity.dto.response.TicketResponseDTO;
import com.rest.api.polyclinic.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Implementation class for TicketController.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class TicketControllerImpl implements TicketController {

    private final TicketService ticketService;

    @Override
    public ResponseEntity<TicketResponseDTO> findTicketById(UUID id) {

        log.info("Trying to get ticket with id: {}", id);

        ResponseEntity<TicketResponseDTO> ticketResponseDTOResponseEntity =
                ticketService.findTicketById(id);

        log.info("Successful get ticket: {}", ticketResponseDTOResponseEntity.getBody());

        return ticketResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<List<TicketResponseDTO>> findAllTicketsByPatientId(UUID patientId) {

        log.info("Trying to get all tickets by patient id: {}", patientId);

        ResponseEntity<List<TicketResponseDTO>> ticketsResponseDTOResponseEntity =
                ticketService.findAllTicketsByPatientId(patientId);

        log.info("Successful get tickets: {} by patient id: {}", ticketsResponseDTOResponseEntity, patientId);

        return ticketsResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<List<TicketResponseDTO>> findAllTicketsByDoctorId(UUID doctorId) {

        log.info("Trying to get all tickets by doctor id: {}", doctorId);

        ResponseEntity<List<TicketResponseDTO>> ticketsResponseDTOResponseEntity =
                ticketService.findAllTicketsByDoctorId(doctorId);

        log.info("Successful get tickets: {} by doctor id: {}", ticketsResponseDTOResponseEntity, doctorId);

        return ticketsResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<List<TicketResponseDTO>> findAllTickets() {

        log.info("Trying to get all tickets");

        ResponseEntity<List<TicketResponseDTO>> ticketsResponseDTOResponseEntity =
                ticketService.findAllTickets();

        log.info("Successful get tickets: {}", ticketsResponseDTOResponseEntity);

        return ticketsResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<TicketResponseDTO> createTicket(CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO) {

        log.info("Trying to create ticket: {}", createOrUpdateTicketRequestDTO);

        ResponseEntity<TicketResponseDTO> createdTicketResponseDTOResponseEntity =
                ticketService.createTicket(createOrUpdateTicketRequestDTO);

        log.info("Successful create new ticket: {}", createdTicketResponseDTOResponseEntity.getBody());

        return createdTicketResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<TicketResponseDTO> updateTicket(UUID id,
                                                          CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO) {

        log.info("Trying to update ticket: {} with id: {}", createOrUpdateTicketRequestDTO, id);

        ResponseEntity<TicketResponseDTO> updatedTicketResponseDTOResponseEntity =
                ticketService.updateTicket(id, createOrUpdateTicketRequestDTO);

        log.info("Successful update ticket: {}", updatedTicketResponseDTOResponseEntity.getBody());

        return updatedTicketResponseDTOResponseEntity;
    }

    @Override
    public ResponseEntity<TicketResponseDTO> deleteTicket(UUID id) {

        log.info("Trying to delete ticket with id: {}", id);

        ResponseEntity<TicketResponseDTO> deletedTicketResponseDTOResponseEntity =
                ticketService.deleteTicket(id);

        log.info("Successful delete ticket: {}", deletedTicketResponseDTOResponseEntity.getBody());

        return deletedTicketResponseDTOResponseEntity;
    }
}
