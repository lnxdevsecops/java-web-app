package com.example.webapp.catalog;

import java.util.Collections;
import java.util.List;

/**
 * Upcoming courses advertised on the site (kept in sync with {@code index.jsp}).
 */
public final class CourseCatalog {

    private static final List<String> UPCOMING = List.of(
            "Leadership Development - Jan 2025",
            "Advanced Python Programming - Feb 2025",
            "Effective Communication Skills - Mar 2025");

    private CourseCatalog() {
    }

    public static List<String> upcomingCourseTitles() {
        return Collections.unmodifiableList(UPCOMING);
    }

    public static int courseCount() {
        return UPCOMING.size();
    }
}
