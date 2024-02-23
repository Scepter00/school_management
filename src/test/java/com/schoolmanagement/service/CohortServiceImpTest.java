package com.schoolmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.schoolmanagement.data.dto.reponse.CohortResponse;
import com.schoolmanagement.data.dto.request.CohortRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
class CohortServiceImpTest {

    @Autowired
    private CohortService cohortService;

    @Test
    void createCohortResponseTest() {
        // Mock a Cohort object
        CohortRequest cohort = new CohortRequest();
        cohort.setCohortName("Test Cohort");
        cohort.setDescription("Test Description");
        cohort.setStartDate(LocalDate.of(2024, 2, 23)); // Example start date
        cohort.setEndDate(LocalDate.of(2025, 2, 23)); // Example end date
        cohort.setNumberOfLearners(10);

        // Call the method under test
        CohortResponse cohortResponse = cohortService.createCohort(cohort);

        // Verify the expected values in the CohortResponse object
        assertEquals(1L, cohortResponse.getId());
        assertEquals("Test Cohort", cohortResponse.getCohort());
        assertEquals("Test Description", cohortResponse.getDescription());
        assertEquals(LocalDate.of(2024, 2, 23), cohortResponse.getStartDate()); // Example start date
        assertEquals(LocalDate.of(2025, 2, 23), cohortResponse.getEndDate()); // Example end date
        assertEquals(10, cohortResponse.getNumberOfLearners());
    }

    @Test
    void loginCohort() {
    }

    @Test
    void viewAllCohorts() {
    }
}
