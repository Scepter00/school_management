package com.schoolmanagement.data.repository;

import com.schoolmanagement.data.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
