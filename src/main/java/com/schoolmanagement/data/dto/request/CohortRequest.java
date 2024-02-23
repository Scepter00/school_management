package com.schoolmanagement.data.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CohortRequest {
    private String cohortName;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int numberOfLearners;
}
