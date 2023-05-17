package com.rest.api.polyclinic.repository;

import com.rest.api.polyclinic.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * JpaRepository, which works with Ticket entity.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    List<Ticket> findAllByPatientId(UUID patientId);

    List<Ticket> findAllByDoctorId(UUID doctorId);


}
