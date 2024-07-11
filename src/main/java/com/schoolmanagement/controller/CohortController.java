package com.schoolmanagement.controller;

import com.schoolmanagement.data.dto.reponse.CohortResponse;
import com.schoolmanagement.data.dto.request.CohortRequest;
import com.schoolmanagement.data.models.Cohort;
import com.schoolmanagement.service.CohortServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")




@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/school")
public class CohortController {

    private CohortServiceImp cohortServiceImp;

    @PostMapping("/createCohort")
    public ResponseEntity<CohortResponse> createCohort(@RequestBody CohortRequest cohortRequest) {
        CohortResponse createdResponse = cohortServiceImp.createCohort(cohortRequest);
        return ResponseEntity.ok(createdResponse);
    }

    @GetMapping("/viewAllCohort")
    public ResponseEntity<List<Cohort>> viewAllCohort() {
        return ResponseEntity.ok(cohortServiceImp.viewAllCohorts());
    }

    @PostMapping(value = "/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadProfilePicture(@RequestParam(value = "file") MultipartFile file, @RequestParam  Long cohortId) {
        try {
            String response = cohortServiceImp.uploadProfileImage(file, cohortId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
