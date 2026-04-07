package com.example.webapp.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ContactInquiryValidatorTest {

    static Stream<Arguments> validSamples() {
        return Stream.of(
                Arguments.of("Ada", "ada@example.com", "Hello"),
                Arguments.of("  Bob  ", "bob@test.org", "  Message  "));
    }

    @ParameterizedTest
    @MethodSource("validSamples")
    void validate_acceptsValidInput(String name, String email, String message) {
        assertThat(ContactInquiryValidator.validate(name, email, message)).isEmpty();
    }

    @Test
    void validate_reportsAllIssuesWhenEverythingMissing() {
        List<String> errors = ContactInquiryValidator.validate(null, "", null);
        assertThat(errors)
                .containsExactlyInAnyOrder("name is required", "email is required", "message is required");
    }

    @Test
    void validate_rejectsInvalidEmail() {
        assertThat(ContactInquiryValidator.validate("Sue", "not-an-email", "Hi"))
                .containsExactly("email format is invalid");
    }

    @Test
    void validate_rejectsOversizedName() {
        String longName = "x".repeat(201);
        assertThat(ContactInquiryValidator.validate(longName, "a@b.co", "m"))
                .containsExactly("name is too long");
    }

    @Test
    void validate_rejectsOversizedMessage() {
        String msg = "z".repeat(10_001);
        assertThat(ContactInquiryValidator.validate("N", "n@n.co", msg)).containsExactly("message is too long");
    }

    @Test
    void validate_trimsNotAppliedButValidEmailStillPasses() {
        assertThat(ContactInquiryValidator.validate("Name", "user@domain.com", "text")).isEmpty();
    }
}
