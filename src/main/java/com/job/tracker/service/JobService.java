package com.job.tracker.service;

import com.job.tracker.dtos.request.JobRequest;
import com.job.tracker.dtos.response.JobResponse;
import com.job.tracker.model.Job;

import java.util.List;

public interface JobService {
    JobResponse jobRegister (JobRequest jobRequest);

    JobResponse deleteJob(String companyName);

    List<Job> findAll();

    JobResponse findByCompanyName(String companyName);
}
