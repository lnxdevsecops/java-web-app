package com.example.webapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.webapp.testsupport.CapturingAppender;
import com.example.webapp.testsupport.Log4jTestSupport;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Log4j-focused tests: asserts that business paths emit the expected levels and messages.
 */
class ConsultingServiceLog4jTest {

    private final CapturingAppender capture = new CapturingAppender("consulting-capture");
    private ConsultingService service;

    @BeforeEach
    void setUp() {
        service = new ConsultingService();
        Log4jTestSupport.attachAppender(capture, ConsultingService.class, Level.DEBUG);
    }

    @AfterEach
    void tearDown() {
        Log4jTestSupport.detachAppender(capture, ConsultingService.class);
        capture.clear();
    }

    @Test
    void successfulInquiry_logsInfoWithContactDetails() {
        service.submitContactInquiry("Alex", "alex@example.com", "Hello");

        assertThat(capture.getEvents()).hasSize(1);
        assertThat(capture.getEvents().get(0).getLevel()).isEqualTo(Level.INFO);
        assertThat(capture.getFormattedMessages().get(0))
                .contains("Contact inquiry received")
                .contains("Alex")
                .contains("alex@example.com");
    }

    @Test
    void rejectedInquiry_logsWarnWithValidationSummary() {
        service.submitContactInquiry("", "x", "");

        assertThat(capture.getEvents()).hasSize(1);
        assertThat(capture.getEvents().get(0).getLevel()).isEqualTo(Level.WARN);
        assertThat(capture.getFormattedMessages().get(0))
                .contains("Contact inquiry rejected")
                .contains("email format is invalid");
    }

    @Test
    void loggerName_isConsultingServiceClass() {
        service.submitContactInquiry("R", "r@r.co", "m");
        assertThat(capture.getEvents().get(0).getLoggerName())
                .isEqualTo(ConsultingService.class.getName());
    }
}
