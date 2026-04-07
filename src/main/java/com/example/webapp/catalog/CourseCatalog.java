package com.example.webapp.catalog;

import java.util.Collections;
import java.util.List;

/**
 * Upcoming courses advertised on the site (kept in sync with {@code index.jsp}).
 */
public final class CourseCatalog {

    private static final List<String> UPCOMING = List.of(
            "DevOps/SRE - Coming Soon",
            "Advanced Kubernetes (CKA/CKAD) - Coming Soon",
            "Cerfified Kubernetes Security Specialist (CKS) - Coming Soon");

    private CourseCatalog() {
    }

    public static List<String> upcomingCourseTitles() {
        return Collections.unmodifiableList(UPCOMING);
    }

    public static int courseCount() {
        return UPCOMING.size();
    }
}
