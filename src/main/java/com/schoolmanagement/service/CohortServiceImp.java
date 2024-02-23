package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.CohortResponse;
import com.schoolmanagement.data.dto.reponse.LoginCohortResponse;
import com.schoolmanagement.data.dto.request.CohortRequest;
import com.schoolmanagement.data.dto.request.LoginCohortRequest;
import com.schoolmanagement.data.models.Cohort;
import com.schoolmanagement.data.models.Program;
import com.schoolmanagement.data.repository.CohortRepository;
import com.schoolmanagement.data.repository.ProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CohortServiceImp {

    private final CohortRepository cohortRepository;
    private final ProgramRepository programRepository;
    private final CloudService cloudService;

    private CohortResponse createCohortResponse(Cohort cohort) {
        CohortResponse cohortResponse = new CohortResponse();
        cohortResponse.setId(cohort.getId());
        cohortResponse.setCohort(cohort.getCohortName());
        cohortResponse.setDescription(cohort.getDescription());
        cohortResponse.setStartDate(cohort.getStartDate());
        cohortResponse.setEndDate(cohort.getEndDate());
        cohortResponse.setNumberOfLearners(cohort.getNumberOfLearners());
        return cohortResponse;
    }

    public CohortResponse createCohort(CohortRequest createCohortRequest) {
        if (cohortRepository.findByCohortName(createCohortRequest.getCohortName()) != null) {
            throw new RuntimeException("Username already exists");
        }
        Cohort cohort = new Cohort();
        cohort.setCohortName(createCohortRequest.getCohortName());
        cohort.setDescription(createCohortRequest.getDescription());
        cohort.setNumberOfLearners(createCohortRequest.getNumberOfLearners());
        cohort.setStartDate(LocalDateTime.now());
        cohort.setEndDate(LocalDateTime.now().plusYears(1));
        Cohort saveCohort = cohortRepository.save(cohort);
        return createCohortResponse(saveCohort);
    }

    private LoginCohortResponse createLoginCohortResponse(Cohort cohort) {
        LoginCohortResponse loginResponse = new LoginCohortResponse();
        loginResponse.setId(cohort.getId());
        return loginResponse;
    }

    public LoginCohortResponse loginCohort(LoginCohortRequest loginCohortRequest) {
        Cohort cohort = cohortRepository.findByCohortName(loginCohortRequest.getCohortName());
        if (cohort == null) {
            throw new RuntimeException("User not found");
        }
        return createLoginCohortResponse(cohort);
    }

    public List<Cohort> viewAllCohorts() {
        return cohortRepository.findAll();
    }

    public String uploadProfileImage(MultipartFile file, Long cohortId) {
        cohortRepository.findById(cohortId).get().setCohortAvatar(cloudService.uploadFile(file));
        return "Successful";
    }

    private void createProgram(Cohort cohort) {
        Program program = new Program();
        program.setName(cohort);
        programRepository.save(program);
    }
}
