package com.rest.api.polyclinic.repository;

import com.rest.api.polyclinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * JpaRepository, which works with Patient entity.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
