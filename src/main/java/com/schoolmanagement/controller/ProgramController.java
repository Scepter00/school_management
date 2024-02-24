package com.schoolmanagement.controller;

import com.schoolmanagement.data.dto.reponse.ProgramResponse;
import com.schoolmanagement.data.dto.request.ProgramRequest;
import com.schoolmanagement.data.models.Program;
import com.schoolmanagement.service.ProgramServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("/viewAllProgram")
    public ResponseEntity<List<Program>> viewAllPrograms() {
        return ResponseEntity.ok(programServiceImp.viewAllPrograms());
    }

}
