package com.schoolmanagement.data.dto.reponse;

import com.schoolmanagement.data.models.EnumProgram;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CohortResponse {
    private Long id;
    private String cohort;
    private String description;
    private String startDate;
    private String endDate;
    private EnumProgram enumProgram;
    private String cohortAvatar;
}
