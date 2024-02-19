package com.job.tracker.dtos.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobRequest {

    private String companyName;
    private String country;
    private String jobType;
    private String jobName;
    private String requirement;
    private String experience;

}
