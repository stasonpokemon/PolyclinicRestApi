package com.rest.api.polyclinic.entity.dto.request;

import com.rest.api.polyclinic.entity.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
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
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_POSITION;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_POSITION_DESCRIPTION;


/**
 * This class presents a DTO, which is available via DoctorController endpoints.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateDoctorRequestDTO {

    @NotBlank(message = "Please fill the firstName")
    @Length(max = 255, message = "FirstName too long. Max length is 255")
    @Schema(example = DOCTOR_FIRST_NAME, description = DOCTOR_FIRST_NAME_DESCRIPTION)
    private String firstName;

    @NotBlank(message = "Please fill the patronymic")
    @Length(max = 255, message = "Patronymic too long. Max length is 255")
    @Schema(example = DOCTOR_PATRONYMIC, description = DOCTOR_PATRONYMIC_DESCRIPTION)
    private String patronymic;

    @NotBlank(message = "Please fill the lastName")
    @Length(max = 255, message = "LastName too long. Max length is 255")
    @Schema(example = DOCTOR_LAST_NAME, description = DOCTOR_LAST_NAME_DESCRIPTION)
    private String lastName;

    @NotNull(message = "Please fill the gender")
    @Schema(example = DOCTOR_GENDER, description = DOCTOR_GENDER_DESCRIPTION)
    private Gender gender;

    @NotBlank(message = "Please fill the position")
    @Length(max = 255, message = "Position too long. Max length is 255")
    @Schema(example = DOCTOR_POSITION, description = DOCTOR_POSITION_DESCRIPTION)
    private String position;

    @NotBlank(message = "Please fill the phone number")
    @Length(max = 255, message = "Phone number too long. Max length is 255")
    @Schema(example = DOCTOR_PHONE_NUMBER, description = DOCTOR_PHONE_NUMBER_DESCRIPTION)
    private String phoneNumber;
}
