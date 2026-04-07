package com.example.webapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsultingServiceTest {

    private ConsultingService service;

    @BeforeEach
    void setUp() {
        service = new ConsultingService();
    }

    @Test
    void getCompanyTitle_matchesBranding() {
        assertThat(service.getCompanyTitle()).isEqualTo("GANGA Training & Consulting");
    }

    @Test
    void getTagline_matchesMarketingCopy() {
        assertThat(service.getTagline()).isEqualTo("Empowering Professionals for a Brighter Future");
    }

    @Test
    void getUpcomingCourseTitles_delegatesToCatalog() {
        assertThat(service.getUpcomingCourseTitles()).hasSize(3);
        assertThat(service.getUpcomingCourseTitles().get(0)).contains("Leadership");
    }

    @Test
    void submitContactInquiry_succeedsForValidInput() {
        ContactResult r = service.submitContactInquiry("Pat", "pat@example.com", "Question");
        assertThat(r.isSuccess()).isTrue();
        assertThat(r.getValidationErrors()).isEmpty();
    }

    @Test
    void submitContactInquiry_failsWhenValidationFails() {
        ContactResult r = service.submitContactInquiry("", "bad", "");
        assertThat(r.isSuccess()).isFalse();
        assertThat(r.getValidationErrors()).isNotEmpty();
    }
}
