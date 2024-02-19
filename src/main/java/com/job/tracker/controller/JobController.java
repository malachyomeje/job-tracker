package com.job.tracker.controller;

import com.job.tracker.dtos.request.JobRequest;
import com.job.tracker.dtos.response.JobResponse;
import com.job.tracker.model.Job;
import com.job.tracker.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("job")
public class JobController {

    private final JobService jobService;
    @PostMapping("register")
    public JobResponse jobRegister (@RequestBody JobRequest jobRequest){
        return jobService.jobRegister(jobRequest);
    }

@DeleteMapping("deleteJob/{companyName}")
    public JobResponse deleteJob(@PathVariable String companyName) {
    return jobService.deleteJob(companyName);
}

@GetMapping("findAll")
    public List<Job> findAll (){
        return jobService.findAll();
    }

    @GetMapping("findByCompanyName/{companyName}")
    public JobResponse findByCompanyName (@PathVariable String companyName){
        return jobService.findByCompanyName(companyName);


    }
}
