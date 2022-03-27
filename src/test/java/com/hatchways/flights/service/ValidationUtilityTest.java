package com.hatchways.flights.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilityTest {

    private String nullDate = null;
    private String emptyDate = "";
    private String validDate = "2021-11-01";

    @Test
    void isEmptyDate() {
        assertTrue(ValidationUtility.isEmptyDate(nullDate), "is null date");
        assertTrue(ValidationUtility.isEmptyDate(emptyDate), "is empty date");
    }

    @Test
    void isNotEmptyDate() {
        assertFalse(ValidationUtility.isEmptyDate(validDate), "is not empty date");
    }

    @Test
    void isValidDate() {
        assertTrue(ValidationUtility.isValidDate(validDate), "is a valid date");
    }

    @Test
    void isNotValidDate() {
        assertFalse(ValidationUtility.isValidDate(nullDate), "is not a valid date");
        assertFalse(ValidationUtility.isValidDate(emptyDate), "is not a valid date");
    }
}