package com.schoolmanagement.data.dto.reponse;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class CohortResponse {
    private Long id;
    private String cohort;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfLearners;
    //private Long programId;
}
