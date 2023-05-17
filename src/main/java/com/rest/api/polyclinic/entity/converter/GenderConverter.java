package com.rest.api.polyclinic.entity.converter;

import com.rest.api.polyclinic.entity.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * GenderConverter class for convert Gender enum to integer for database.
 */
@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender orderStatus) {
        return orderStatus == null ? -1 : orderStatus.getNumber();
    }

    @Override
    public Gender convertToEntityAttribute(Integer integer) {
        return Gender.of(integer);
    }
}