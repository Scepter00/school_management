package com.schoolmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.schoolmanagement.data.dto.reponse.CohortResponse;
import com.schoolmanagement.data.dto.request.CohortRequest;
import com.schoolmanagement.data.models.Program;
import com.schoolmanagement.data.repository.CohortRepository;
import com.schoolmanagement.data.repository.ProgramRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class CohortServiceImpTest {

    @Autowired
    private CohortService cohortService;

    @MockBean
    private CohortRepository cohortRepository;

    @MockBean
    private ProgramRepository programRepository;

    @Test
    void createCohortResponseTest() {
        when(cohortRepository.findByCohortName(anyString())).thenReturn(null);
        when(programRepository.findById(anyLong())).thenReturn(Optional.of(new Program()));


        // Mock a Cohort object
        CohortRequest cohort = new CohortRequest();
        cohort.setProgramId(1L);
        cohort.setCohortName("Test Cohort");
        cohort.setDescription("Test Description");
        cohort.setStartDate(LocalDate.of(2024, 2, 23)); // Example start date
        cohort.setEndDate(LocalDate.of(2025, 2, 23)); // Example end date
        cohort.setNumberOfLearners(10);

        CohortResponse cohortResponse = cohortService.createCohort(cohort);

        assertNotNull(cohortResponse);
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
