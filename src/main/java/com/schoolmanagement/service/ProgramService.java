package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.ProgramResponse;
import com.schoolmanagement.data.dto.request.ProgramRequest;

public interface ProgramService {
    ProgramResponse createProgram (ProgramRequest programRequest);
}
