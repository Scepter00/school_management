package com.schoolmanagement.controller;

import com.schoolmanagement.data.dto.reponse.ProgramResponse;
import com.schoolmanagement.data.dto.request.ProgramRequest;
import com.schoolmanagement.service.ProgramServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/school")
public class ProgramController {

    private ProgramServiceImp programServiceImp;

    @PostMapping("/createProgram")
    public ResponseEntity<ProgramResponse> createProgram(@RequestBody ProgramRequest programRequest) {
        ProgramResponse createdResponse = programServiceImp.createProgram(programRequest);
        return ResponseEntity.ok(createdResponse);
    }


}
