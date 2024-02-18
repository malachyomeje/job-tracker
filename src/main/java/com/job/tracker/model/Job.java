package com.job.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String companyName;
    private String country;
    private String jobType;
    private String jobName;
    private String requirement;
    private String experience;


}
