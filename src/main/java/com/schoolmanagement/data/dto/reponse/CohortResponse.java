package com.schoolmanagement.data.dto.reponse;

import com.schoolmanagement.data.models.Program;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class CohortResponse {
    private Long id;
    private String cohort;
    private String description;
    private String startDate;
    private String endDate;
}
