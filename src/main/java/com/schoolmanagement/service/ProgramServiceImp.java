package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.ProgramResponse;
import com.schoolmanagement.data.dto.request.ProgramRequest;
import com.schoolmanagement.data.models.EnumProgram;
import com.schoolmanagement.data.models.Program;
import com.schoolmanagement.data.repository.ProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProgramServiceImp implements ProgramService{
    private ProgramRepository programRepository;


    private ProgramResponse createProgramResponse(Program program) {
        ProgramResponse programResponse = new ProgramResponse();
        programResponse.setId(program.getId());
        programResponse.setProgramName(program.getProgramName());
        return programResponse;
    }

    @Override
    public ProgramResponse createProgram(ProgramRequest programRequest) {
        Program program = new Program();
        program.setProgramName(programRequest.getProgramName());
        Program saveProgram = programRepository.save(program);
        return createProgramResponse(saveProgram);
    }

    @Override
    public List<Program> viewAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public List<String> viewAllEnumPrograms() {
       return Arrays.stream(EnumProgram.values())
                .map(Enum::toString)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> viewAllProgramList() {
        return programRepository.findAll()
                .stream()
                .map(Program::getProgramName)
                .collect(Collectors.toList());
    }
}
