package com.rest.api.polyclinic.controller;

import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdatePatientRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
import com.rest.api.polyclinic.entity.dto.response.PatientResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

/**
 * Interface that presents basic endpoints for working with Patient entity.
 */
@RequestMapping("/patients")
@Tag(name = "Patient Controller", description = "Patient management controller")
public interface PatientController {

    @Operation(
            summary = "Find patient by id",
            description = "This endpoint allows you to get patient by id from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following patient",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientResponseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bed request",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping("/{id}")
    ResponseEntity<PatientResponseDTO> findPatientById(@PathVariable("id") UUID id);

    @Operation(
            summary = "Find all patients",
            description = "This endpoint allows you to get all patients from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following patients",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PatientResponseDTO.class)))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping
    ResponseEntity<List<PatientResponseDTO>> findAllPatients();

    @Operation(
            summary = "Create new patient",
            description = "This endpoint allows you to create a new patient in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "Patient successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientResponseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @PostMapping
    ResponseEntity<PatientResponseDTO> createPatient(@RequestBody
                                                   @Valid CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO);

    @Operation(
            summary = "Update patient",
            description = "This endpoint allows you to update an already existing patient in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Patient successfully updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientResponseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @PutMapping("/{id}")
    ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable("id") UUID id,
                                                   @RequestBody
                                                   @Valid CreateOrUpdatePatientRequestDTO createOrUpdatePatientRequestDTO);

    @Operation(
            summary = "Delete patient",
            description = "This endpoint allows you to delete patient that already exist in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Patient successfully deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientResponseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<PatientResponseDTO> deletePatient(@PathVariable("id") UUID id);
}
