package com.schoolmanagement.data.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Setter
@Getter
public class CohortRequest {
    private String cohortName;
    private String description;
    private String startDate;
    private String endDate;
    private String programName;
    //private MultipartFile cohortAvatar;
}
