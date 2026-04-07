package com.example.webapp.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CourseCatalogTest {

    @Test
    void upcomingCourseTitles_containsExpectedEntriesInOrder() {
        assertThat(CourseCatalog.upcomingCourseTitles())
                .containsExactly(
                        "DevOps/SRE - Coming Soon",
                        "Advanced Kubernetes Administrator (CKA/CKAD) - Coming Soon",
                        "Certified Kubernetes Security Specialist (CKS) - Coming Soon");
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
