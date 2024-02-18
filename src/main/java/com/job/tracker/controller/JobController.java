package com.job.tracker.controller;

import com.job.tracker.dtos.request.JobRequest;
import com.job.tracker.dtos.response.JobResponse;
import com.job.tracker.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("job")
public class JobController {

    private final JobService jobService;
    @PostMapping("register")
    public JobResponse jobRegister (@RequestBody JobRequest jobRequest){
        return jobService.jobRegister(jobRequest);
    }
}
