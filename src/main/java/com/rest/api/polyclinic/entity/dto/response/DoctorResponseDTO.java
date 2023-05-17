package com.rest.api.polyclinic.entity.dto.response;

import com.rest.api.polyclinic.entity.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_UUID;
import static com.rest.api.polyclinic.util.OpenApiConstants.DOCTOR_UUID_DESCRIPTION;

/**
 * This class presents a DTO, which is available via DoctorController endpoints.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDTO {

    @Schema(example = DOCTOR_UUID, description = DOCTOR_UUID_DESCRIPTION)
    private String id;

    @Schema(example = DOCTOR_FIRST_NAME, description = DOCTOR_FIRST_NAME_DESCRIPTION)
    private String firstName;

    @Schema(example = DOCTOR_PATRONYMIC, description = DOCTOR_PATRONYMIC_DESCRIPTION)
    private String patronymic;

    @Schema(example = DOCTOR_LAST_NAME, description = DOCTOR_LAST_NAME_DESCRIPTION)
    private String lastName;

    @Schema(example = DOCTOR_GENDER, description = DOCTOR_GENDER_DESCRIPTION)
    private Gender gender;

    @Schema(example = DOCTOR_POSITION, description = DOCTOR_POSITION_DESCRIPTION)
    private String position;

    @Schema(example = DOCTOR_PHONE_NUMBER, description = DOCTOR_PHONE_NUMBER_DESCRIPTION)
    private String phoneNumber;
}
