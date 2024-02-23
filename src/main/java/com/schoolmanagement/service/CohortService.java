package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.CohortResponse;
import com.schoolmanagement.data.dto.request.CohortRequest;

public interface CohortService {

    CohortResponse createCohort(CohortRequest createCohortRequest);

}
