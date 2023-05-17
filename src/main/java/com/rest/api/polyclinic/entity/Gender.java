package com.rest.api.polyclinic.entity;

import java.util.stream.Stream;

/**
 * Gender enum class.
 */
public enum Gender {

    MALE(0), FEMALE(1);


    final int number;

    Gender(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public static Gender of(int number) {
        return Stream.of(Gender.values())
                .filter(p -> p.getNumber() == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
