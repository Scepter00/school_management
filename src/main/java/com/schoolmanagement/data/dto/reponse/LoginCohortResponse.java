package com.schoolmanagement.data.dto.reponse;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class LoginCohortResponse {
    private Long id;
    private String cohort;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
