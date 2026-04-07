package com.example.webapp.service;

import java.util.Collections;
import java.util.List;

/**
 * Outcome of attempting to record a contact inquiry.
 */
public final class ContactResult {

    private final boolean success;
    private final List<String> validationErrors;

    private ContactResult(boolean success, List<String> validationErrors) {
        this.success = success;
        this.validationErrors = validationErrors;
    }

    public static ContactResult success() {
        return new ContactResult(true, Collections.emptyList());
    }

    public static ContactResult failure(List<String> validationErrors) {
        return new ContactResult(false, List.copyOf(validationErrors));
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }
}
