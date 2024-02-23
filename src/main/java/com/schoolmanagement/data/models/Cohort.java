package com.schoolmanagement.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int numberOfLearners;
    private String cohortAvatar;
    @OneToOne
    private Program program;
}
