package com.rest.api.polyclinic.repository;

import com.rest.api.polyclinic.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * JpaRepository, which works with Doctor entity.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
