package com.schoolmanagement.data.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCohortRequest {
    private Long id;
    private String cohortName;

}
