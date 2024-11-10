package com.schoolmanagement.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter

@Getter
@Entity
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cohortName;
    private String description;
    private String startDate;
    private String endDate;
    private String cohortAvatar;
    @ManyToOne
    private Program program;
    private EnumProgram enumProgram;
}
