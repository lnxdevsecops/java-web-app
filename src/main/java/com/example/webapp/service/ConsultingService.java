package com.example.webapp.service;

import com.example.webapp.catalog.CourseCatalog;
import com.example.webapp.validation.ContactInquiryValidator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Core domain operations for the GANGA Training &amp; Consulting site.
 */
public class ConsultingService {

    private static final Logger log = LogManager.getLogger(ConsultingService.class);

    public String getCompanyTitle() {
        return "GANGA Training & Consulting";
    }

    public String getTagline() {
        return "Empowering Professionals for a Brighter Future";
    }

    public List<String> getUpcomingCourseTitles() {
        return CourseCatalog.upcomingCourseTitles();
    }

    /**
     * Validates input and logs the outcome at INFO (accepted) or WARN (rejected).
     */
    public ContactResult submitContactInquiry(String name, String email, String message) {
        List<String> errors = ContactInquiryValidator.validate(name, email, message);
        if (!errors.isEmpty()) {
            log.warn("Contact inquiry rejected: {}", errors);
            return ContactResult.failure(errors);
        }
        log.info("Contact inquiry received from {} <{}>", name.trim(), email.trim());
        return ContactResult.success();
    }
}
