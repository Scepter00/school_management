package com.schoolmanagement.data.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CohortRequest {
    private String cohortName;
    private String description;
    private String startDate;
    private String endDate;
}
