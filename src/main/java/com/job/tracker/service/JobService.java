package com.job.tracker.service;

import com.job.tracker.dtos.request.JobRequest;
import com.job.tracker.dtos.response.JobResponse;

public interface JobService {
    JobResponse jobRegister (JobRequest jobRequest);
}
