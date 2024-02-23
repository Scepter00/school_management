package com.schoolmanagement.data.repository;

import com.schoolmanagement.data.models.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CohortRepository extends JpaRepository<Cohort, Long> {
    Cohort findByCohortName (String cohortName);
}
