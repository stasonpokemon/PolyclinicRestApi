package com.rest.api.polyclinic.entity.dto.request;

import com.rest.api.polyclinic.entity.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_FIRST_NAME;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_FIRST_NAME_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_GENDER;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_GENDER_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_LAST_NAME;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_LAST_NAME_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_PATRONYMIC;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_PATRONYMIC_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_PHONE_NUMBER;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_PHONE_NUMBER_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_ADDRESS;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_ADDRESS_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_AGE;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_AGE_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_FIRST_NAME;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_FIRST_NAME_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_GENDER;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_GENDER_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_LAST_NAME;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_LAST_NAME_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_PATRONYMIC;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_PATRONYMIC_DESCRIPTION;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_PHONE_NUMBER;
import static com.rest.api.polyclinic.util.OpenApiConstants.PATIENT_PHONE_NUMBER_DESCRIPTION;

/**
 * This class presents a DTO, which is available via PatientController endpoints.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdatePatientRequestDTO {

    @NotBlank(message = "Please fill the firstName")
    @Length(max = 255, message = "FirstName too long. Max length is 255")
    @Schema(example = PATIENT_FIRST_NAME, description = PATIENT_FIRST_NAME_DESCRIPTION)
    private String firstName;

    @NotBlank(message = "Please fill the patronymic")
    @Length(max = 255, message = "Patronymic too long. Max length is 255")
    @Schema(example = PATIENT_PATRONYMIC, description = PATIENT_PATRONYMIC_DESCRIPTION)
    private String patronymic;

    @NotBlank(message = "Please fill the lastName")
    @Length(max = 255, message = "LastName too long. Max length is 255")
    @Schema(example = PATIENT_LAST_NAME, description = PATIENT_LAST_NAME_DESCRIPTION)
    private String lastName;

    @NotBlank(message = "Please fill the age")
    @Schema(example = PATIENT_AGE, description = PATIENT_AGE_DESCRIPTION)
    private Integer age;

    @NotNull(message = "Please fill the gender")
    @Schema(example = PATIENT_GENDER, description = PATIENT_GENDER_DESCRIPTION)
    private Gender gender;

    @NotBlank(message = "Please fill the address")
    @Length(max = 255, message = "LastName too long. Max length is 255")
    @Schema(example = PATIENT_ADDRESS, description = PATIENT_ADDRESS_DESCRIPTION)
    private String address;

    @NotBlank(message = "Please fill the phone number")
    @Length(max = 255, message = "Phone number too long. Max length is 255")
    @Schema(example = PATIENT_PHONE_NUMBER, description = PATIENT_PHONE_NUMBER_DESCRIPTION)
    private String phoneNumber;
}
