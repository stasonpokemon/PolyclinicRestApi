package com.rest.api.polyclinic.entity.dto.request;

import com.rest.api.polyclinic.util.LocalDateValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_UUID;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_UUID_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_UUID;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_UUID_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_DATE_OF_RECEIPT;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_DATE_OF_RECEIPT_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_NUMBER;
import static com.rest.api.polyclinic.util.OpenApiConstants.TICKET_NUMBER_DESCRIPTION;

/**
 * This class presents a DTO, which is available via TicketController endpoints.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateTicketRequestDTO {


    @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}",
            message = "Invalid doctor id")
    @NotBlank(message = "Doctor id can't be null")
    @Schema(example = DOCTOR_UUID, description = DOCTOR_UUID_DESCRIPTION)
    private String doctorId;

    @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}",
            message = "Invalid patient id")
    @NotBlank(message = "Patient id can't be null")
    @Schema(example = PATIENT_UUID, description = PATIENT_UUID_DESCRIPTION)
    private String patientId;

    @NotNull(message = "Please fill the date of receipt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(example = TICKET_DATE_OF_RECEIPT, description = TICKET_DATE_OF_RECEIPT_DESCRIPTION)
    private LocalDate dateOfReceipt;

    @NotBlank(message = "Please fill the ticket number")
    @Length(max = 255, message = "Ticket number too long. Max length is 255")
    @Schema(example = TICKET_NUMBER, description = TICKET_NUMBER_DESCRIPTION)
    private String ticketNumber;
}
