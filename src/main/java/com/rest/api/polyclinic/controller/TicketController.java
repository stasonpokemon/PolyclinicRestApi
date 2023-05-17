package com.rest.api.polyclinic.controller;

import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdatePatientRequestDTO;
import com.rest.api.polyclinic.entity.dto.request.CreateOrUpdateTicketRequestDTO;
import com.rest.api.polyclinic.entity.dto.response.DoctorResponseDTO;
import com.rest.api.polyclinic.entity.dto.response.PatientResponseDTO;
import com.rest.api.polyclinic.entity.dto.response.TicketResponseDTO;
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
 * Interface that presents basic endpoints for working with Ticket entity.
 */
@RequestMapping("/tickets")
@Tag(name = "Ticket Controller", description = "Ticket management controller")
public interface TicketController {

    @Operation(
            summary = "Find ticket by id",
            description = "This endpoint allows you to get ticket by id from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following ticket",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketResponseDTO.class))}),
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
    ResponseEntity<TicketResponseDTO> findTicketById(@PathVariable("id") UUID id);

    @Operation(
            summary = "Find all tickets by patient id ",
            description = "This endpoint allows you to get all tickets by patient id from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following tickets",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = TicketResponseDTO.class)))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping("/patient/{id}")
    ResponseEntity<List<TicketResponseDTO>> findAllTicketsByPatientId(@PathVariable("id") UUID patientId);

    @Operation(
            summary = "Find all tickets by doctor id ",
            description = "This endpoint allows you to get all tickets by doctor id from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following tickets",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = TicketResponseDTO.class)))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping("/doctor/{id}")
    ResponseEntity<List<TicketResponseDTO>> findAllTicketsByDoctorId(@PathVariable("id") UUID doctorId);

    @Operation(
            summary = "Find all tickets",
            description = "This endpoint allows you to get all tickets from database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the following tickets",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = TicketResponseDTO.class)))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping
    ResponseEntity<List<TicketResponseDTO>> findAllTickets();

    @Operation(
            summary = "Create new ticket",
            description = "This endpoint allows you to create a new ticket in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "Ticket successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketResponseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @PostMapping
    ResponseEntity<TicketResponseDTO> createTicket(@RequestBody
                                                     @Valid CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO);

    @Operation(
            summary = "Update ticket",
            description = "This endpoint allows you to update an already existing ticket in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Ticket successfully updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketResponseDTO.class))}),
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
    ResponseEntity<TicketResponseDTO> updateTicket(@PathVariable("id") UUID id,
                                                     @RequestBody
                                                     @Valid CreateOrUpdateTicketRequestDTO createOrUpdateTicketRequestDTO);

    @Operation(
            summary = "Delete ticket",
            description = "This endpoint allows you to delete ticket that already exist in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Ticket successfully deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketResponseDTO.class))}),
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
    ResponseEntity<TicketResponseDTO> deleteTicket(@PathVariable("id") UUID id);
}
