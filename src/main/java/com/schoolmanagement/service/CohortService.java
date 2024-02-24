package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.CohortResponse;
import com.schoolmanagement.data.dto.reponse.LoginCohortResponse;
import com.schoolmanagement.data.dto.request.CohortRequest;
import com.schoolmanagement.data.dto.request.LoginCohortRequest;
import com.schoolmanagement.data.models.Cohort;

import java.util.List;

public interface CohortService {

    CohortResponse createCohort(CohortRequest createCohortRequest);
    LoginCohortResponse loginCohort(LoginCohortRequest loginCohortRequest);
    List<Cohort> viewAllCohorts();
}
