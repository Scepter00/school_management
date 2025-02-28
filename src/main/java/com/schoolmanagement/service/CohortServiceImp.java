package com.schoolmanagement.service;

import com.schoolmanagement.data.dto.reponse.CohortResponse;
import com.schoolmanagement.data.dto.reponse.LoginCohortResponse;
import com.schoolmanagement.data.dto.request.CohortRequest;
import com.schoolmanagement.data.dto.request.LoginCohortRequest;
import com.schoolmanagement.data.models.Cohort;
import com.schoolmanagement.data.models.EnumProgram;
import com.schoolmanagement.data.models.Program;
import com.schoolmanagement.data.repository.CohortRepository;
import com.schoolmanagement.data.repository.ProgramRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CohortServiceImp implements CohortService {

    private final CohortRepository cohortRepository;
    private final ProgramRepository programRepository;
    private final CloudService cloudService;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private CohortResponse createCohortResponse(Cohort cohort) {
        EnumProgram enumProgram;
        CohortResponse cohortResponse = new CohortResponse();
        cohortResponse.setId(cohort.getId());
        cohortResponse.setCohort(cohort.getCohortName());
        cohortResponse.setDescription(cohort.getDescription());
        LocalDate startDate = LocalDate.parse(cohort.getStartDate());
        String formattedStartDate = startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        cohortResponse.setStartDate(formattedStartDate);
        LocalDate endDate = LocalDate.parse(cohort.getEndDate());
        String formattedEndDate = endDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        cohortResponse.setEndDate(formattedEndDate);
        cohortResponse.setEnumProgram((cohort.getEnumProgram()));
        //cohortResponse.setCohortAvatar(cohort.getCohortAvatar());
        return cohortResponse;
    }
    @Override
    public CohortResponse createCohort(CohortRequest createCohortRequest) {
        if (cohortRepository.findByCohortName(createCohortRequest.getCohortName()) != null) {
            throw new RuntimeException("Cohort already exists");
        }
        Cohort cohort = new Cohort();

        cohort.setCohortName(createCohortRequest.getCohortName());
        cohort.setDescription(createCohortRequest.getDescription());
        LocalDate startDate = LocalDate.parse(createCohortRequest.getStartDate(), dateFormatter);
        cohort.setStartDate(startDate.toString());
        LocalDate endDate = LocalDate.parse(createCohortRequest.getEndDate(), dateFormatter);
        cohort.setEndDate(endDate.toString());
        cohort.setEnumProgram(createCohortRequest.getEnumProgram());

        String program  = String.valueOf(createCohortRequest.getEnumProgram());

        List <String> programNames = programRepository.findAll()
               .stream()
                .map(Program::getProgramName)
                .toList();
        for (String programName : programNames) {
            if (programName.equalsIgnoreCase(program)) {
                Program newProgram = new Program();
                newProgram.setProgramName(program.toUpperCase());

                cohort.setProgram(newProgram);
            }
        }

//        String image = cloudService.uploadFile(multipartFile);
//        log.info("image: {}, =======================", image);
//        cohort.setCohortAvatar(image);

//        String cohortAvatarUrl = null;
//        try {
//            cohortAvatarUrl = uploadProfileImage(
//                    //createCohortRequest.getCohortAvatar()
//                    null
//                    , 1L);
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        Cohort saveCohort = cohortRepository.save(cohort);
        return createCohortResponse(saveCohort);
    }

    private LoginCohortResponse createLoginCohortResponse(Cohort cohort) {
        LoginCohortResponse loginResponse = new LoginCohortResponse();
        loginResponse.setId(cohort.getId());
        return loginResponse;
    }

    @Override
    public LoginCohortResponse loginCohort(LoginCohortRequest loginCohortRequest) {
        Cohort cohort = cohortRepository.findByCohortName(loginCohortRequest.getCohortName());
        if (cohort == null) {
            throw new RuntimeException("Cohort not found");
        }
        return createLoginCohortResponse(cohort);
    }

    @Override
    public List<Cohort> viewAllCohorts() {
        return cohortRepository.findAll();
    }

    public String uploadProfileImage(MultipartFile file, Long cohortId) {
      //  cohortRepository.findById(cohortId).get().setCohortAvatar(
         return   cloudService.uploadFile(file);
        //return "";
    //);
       // return "Successful";
    }
}
