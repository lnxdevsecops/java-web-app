package com.example.webapp.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CourseCatalogTest {

    @Test
    void upcomingCourseTitles_containsExpectedEntriesInOrder() {
        assertThat(CourseCatalog.upcomingCourseTitles())
                .containsExactly(
                        "Leadership Development - Jan 2025",
                        "Advanced Python Programming - Feb 2025",
                        "Effective Communication Skills - Mar 2025");
    }

    @Test
    void courseCount_matchesListSize() {
        assertThat(CourseCatalog.courseCount()).isEqualTo(3);
        assertThat(CourseCatalog.upcomingCourseTitles()).hasSize(CourseCatalog.courseCount());
    }

    @Test
    void upcomingCourseTitles_isUnmodifiable() {
        assertThat(CourseCatalog.upcomingCourseTitles()).isUnmodifiable();
    }
}
