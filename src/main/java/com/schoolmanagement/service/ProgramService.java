package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.ProgramResponse;
import com.schoolmanagement.data.dto.request.ProgramRequest;
import com.schoolmanagement.data.models.Program;

import java.util.List;

public interface ProgramService {
    ProgramResponse createProgram (ProgramRequest programRequest);
    List<Program> viewAllPrograms();

    List<String> viewAllEnumPrograms();

    List<String> viewAllProgramList();
}
