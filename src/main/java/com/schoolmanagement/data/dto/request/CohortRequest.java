package com.schoolmanagement.data.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class CohortRequest {
    private String cohortName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfLearners;
    private Long programId;
}
