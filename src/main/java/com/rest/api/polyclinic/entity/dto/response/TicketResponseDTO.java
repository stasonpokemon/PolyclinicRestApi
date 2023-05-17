package com.rest.api.polyclinic.entity.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_UUID;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_UUID_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_UUID;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_UUID_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_DATE_OF_RECEIPT;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_DATE_OF_RECEIPT_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_NUMBER;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_NUMBER_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_UUID;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_UUID_DESCRIPTION;

/**
 * This class presents a DTO, which is available via TicketController endpoints.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDTO {

    @Schema(example = TICKET_UUID, description = TICKET_UUID_DESCRIPTION)
    private UUID id;

    @Schema(example = DOCTOR_UUID, description = DOCTOR_UUID_DESCRIPTION)
    private UUID doctorId;

    @Schema(example = PATIENT_UUID, description = PATIENT_UUID_DESCRIPTION)
    private UUID patientId;

    @Schema(example = TICKET_DATE_OF_RECEIPT, description = TICKET_DATE_OF_RECEIPT_DESCRIPTION)
    private LocalDate dateOfReceipt;

    @Schema(example = TICKET_NUMBER, description = TICKET_NUMBER_DESCRIPTION)
    private String ticketNumber;
}
