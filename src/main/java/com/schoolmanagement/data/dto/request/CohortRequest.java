package com.schoolmanagement.data.dto.request;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.schoolmanagement.data.models.EnumProgram;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CohortRequest {
    private String cohortName;
    private String description;
    private String startDate;
    private String endDate;
    private EnumProgram enumProgram;
}
