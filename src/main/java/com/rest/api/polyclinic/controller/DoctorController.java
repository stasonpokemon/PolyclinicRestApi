package com.rest.api.polyclinic.controller;

import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateDoctorRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
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
 * Interface that presents basic endpoints for working with Doctor entity.
 */
@RequestMapping("/doctors")
@Tag(name = "Doctor Controller", description = "Doctor management controller")
public interface DoctorController {


    @Operation(
            summary = "Find doctor by id",
            description = "This endpoint allows you to get doctor by id from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following doctor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorResponseDTO.class))}),
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
    ResponseEntity<DoctorResponseDTO> findDoctorById(@PathVariable("id") UUID id);

    @Operation(
            summary = "Find all doctors",
            description = "This endpoint allows you to get all doctors from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following doctors",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = DoctorResponseDTO.class)))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping
    ResponseEntity<List<DoctorResponseDTO>> findAllDoctors();

    @Operation(
            summary = "Create new doctor",
            description = "This endpoint allows you to create a new doctor in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "Doctor successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorResponseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @PostMapping
    ResponseEntity<DoctorResponseDTO> createDoctor(@RequestBody
                                                   @Valid CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO);

    @Operation(
            summary = "Update doctor",
            description = "This endpoint allows you to update an already existing doctor in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Doctor successfully updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorResponseDTO.class))}),
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
    ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable("id") UUID id,
                                                   @RequestBody
                                                   @Valid CreateOrUpdateDoctorRequestDTO createOrUpdateDoctorRequestDTO);

    @Operation(
            summary = "Delete doctor",
            description = "This endpoint allows you to delete doctor that already exist in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Doctor successfully deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorResponseDTO.class))}),
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
    ResponseEntity<DoctorResponseDTO> deleteDoctor(@PathVariable("id") UUID id);


}
