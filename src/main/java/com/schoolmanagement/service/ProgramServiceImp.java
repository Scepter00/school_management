package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.ProgramResponse;
import com.schoolmanagement.data.dto.request.ProgramRequest;
import com.schoolmanagement.data.models.Program;
import com.schoolmanagement.data.repository.ProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProgramServiceImp {
    private ProgramRepository programRepository;

    private ProgramResponse createProgramResponse(Program program) {
        ProgramResponse programResponse = new ProgramResponse();
        programResponse.setId(program.getId());
        programResponse.setProgramName(program.getProgramName());
        programResponse.setDescription(program.getDescription());
        return programResponse;
    }

    public ProgramResponse createProgram(ProgramRequest programRequest) {
        Program program = new Program();
        program.setProgramName(programRequest.getProgramName());
        program.setDescription(programRequest.getDescription());
        Program saveProgram = programRepository.save(program);
        return createProgramResponse(saveProgram);
    }
}
