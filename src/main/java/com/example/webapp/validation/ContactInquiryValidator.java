package com.example.webapp.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Validates the marketing-site contact form fields.
 */
public final class ContactInquiryValidator {

    private static final Pattern EMAIL = Pattern.compile(
            "^[\\w.!#$%&'*+/=?^`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");

    private ContactInquiryValidator() {
    }

    /**
     * @return empty if valid; otherwise human-readable issues (never null)
     */
    public static List<String> validate(String name, String email, String message) {
        List<String> errors = new ArrayList<>(3);
        if (name == null || name.isBlank()) {
            errors.add("name is required");
        } else if (name.length() > 200) {
            errors.add("name is too long");
        }
        if (email == null || email.isBlank()) {
            errors.add("email is required");
        } else if (!EMAIL.matcher(email.trim()).matches()) {
            errors.add("email format is invalid");
        }
        if (message == null || message.isBlank()) {
            errors.add("message is required");
        } else if (message.length() > 10_000) {
            errors.add("message is too long");
        }
        return errors.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(errors);
    }
}
