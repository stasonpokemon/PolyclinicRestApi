package com.rest.api.polyclinic.service.impl;

import com.rest.api.polyclinic.entity.Doctor;
import com.rest.api.polyclinic.entity.Patient;
import com.rest.api.polyclinic.entity.Ticket;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateTicketRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.TicketResponseDTO;
import com.rest.api.polyclinic.entity.mapper.TicketMapper;
import com.rest.api.polyclinic.exception.NotFoundException;
import com.rest.api.polyclinic.repository.DoctorRepository;
import com.rest.api.polyclinic.repository.PatientRepository;
import com.rest.api.polyclinic.repository.TicketRepository;
import com.rest.api.polyclinic.service.DoctorService;
import com.rest.api.polyclinic.service.PatientService;
import com.rest.api.polyclinic.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Implementation class for TicketService.
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final PatientService patientService;

    private final DoctorService doctorService;

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;


    private final TicketMapper ticketMapper = Mappers.getMapper(TicketMapper.class);

    @Override
    public ResponseEntity<TicketResponseDTO> findTicketById(UUID id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Ticket.class, id));

        log.info("Get ticket from DB: {}", ticket);

        return new ResponseEntity<>(ticketMapper.ticketToTicketResponseDTO(ticket), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketResponseDTO>> findAllTickets() {

        List<Ticket> tickets = ticketRepository.findAll();

        log.info("Get tickets from DB: {}", tickets);

        return new ResponseEntity<>(tickets.stream().map(ticketMapper::ticketToTicketResponseDTO).toList(),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketResponseDTO>> findAllTicketsByPatientId(UUID patientId) {

        patientService.findPatientById(patientId);

        log.info("Patient with id: {} is exists", patientId);

        List<Ticket> ticketsByPatientId = ticketRepository.findAllByPatientId(patientId);

        log.info("Get tickets: {} by patient id: {} from DB", ticketsByPatientId, patientId);

        return new ResponseEntity<>(ticketsByPatientId.stream().map(ticketMapper::ticketToTicketResponseDTO).toList(),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketResponseDTO>> findAllTicketsByDoctorId(UUID doctorId) {

        doctorService.findDoctorById(doctorId);

        log.info("Doctor with id: {} is exists", doctorId);

        List<Ticket> ticketsByDoctorId = ticketRepository.findAllByDoctorId(doctorId);

        log.info("Get tickets: {} by doctor id: {} from DB", ticketsByDoctorId, doctorId);

        return new ResponseEntity<>(ticketsByDoctorId.stream().map(ticketMapper::ticketToTicketResponseDTO).toList(),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketResponseDTO> createTicket(CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO) {

        Ticket ticket = ticketMapper.createOrUpdateTicketRequestDTOToTicket(createOrUpdateTicketRequestDTO);

        UUID patientId = UUID.fromString(createOrUpdateTicketRequestDTO.getPatientId());
        UUID doctorId = UUID.fromString(createOrUpdateTicketRequestDTO.getDoctorId());

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new NotFoundException(Patient.class, patientId));

        log.info("Patient with id: {} is exists", patientId);

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(Doctor.class, doctorId));

        log.info("Doctor with id: {} is exists", doctorId);

        ticket.setPatient(patient);
        ticket.setDoctor(doctor);

        ticket = ticketRepository.save(ticket);

        log.info("Created ticket: {}", ticket);

        return new ResponseEntity<>(ticketMapper.ticketToTicketResponseDTO(ticket), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TicketResponseDTO> updateTicket(UUID id,
                                                          CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Ticket.class, id));

        log.info("Get ticket from DB: {}", ticket);

        UUID patientId = UUID.fromString(createOrUpdateTicketRequestDTO.getPatientId());
        UUID doctorId = UUID.fromString(createOrUpdateTicketRequestDTO.getDoctorId());

        if (!ticket.getPatient().getId().equals(patientId)) {
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new NotFoundException(Patient.class, patientId));

            log.info("Patient with id: {} is exists", patientId);

            ticket.setPatient(patient);
        }
        if (!ticket.getDoctor().getId().equals(doctorId)) {
            Doctor doctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new NotFoundException(Doctor.class, doctorId));

            log.info("Doctor with id: {} is exists", doctorId);

            ticket.setDoctor(doctor);
        }

        fillTicketFieldsForUpdate(createOrUpdateTicketRequestDTO, ticket);

        ticket = ticketRepository.save(ticket);

        log.info("Updated ticket: {}", ticket);

        return new ResponseEntity<>(ticketMapper.ticketToTicketResponseDTO(ticket), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketResponseDTO> deleteTicket(UUID id) {

        Ticket ticketForDeleting = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Ticket.class, id));

        log.info("Get ticket from DB: {}", ticketForDeleting);

        ticketRepository.delete(ticketForDeleting);

        log.info("Deleted ticket: {}", ticketForDeleting);

        return new ResponseEntity<>(ticketMapper.ticketToTicketResponseDTO(ticketForDeleting), HttpStatus.OK);
    }

    private void fillTicketFieldsForUpdate(CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO,
                                           Ticket ticketForUpdating) {
        ticketForUpdating.setTicketNumber(createOrUpdateTicketRequestDTO.getTicketNumber());
        ticketForUpdating.setDateOfReceipt(createOrUpdateTicketRequestDTO.getDateOfReceipt());
    }
}
