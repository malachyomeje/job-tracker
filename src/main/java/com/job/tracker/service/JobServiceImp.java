package com.job.tracker.service;

import com.job.tracker.dtos.request.JobRequest;
import com.job.tracker.dtos.response.JobResponse;
import com.job.tracker.model.Job;
import com.job.tracker.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class JobServiceImp implements JobService{
    private final JobRepository jobRepository;

    @Override
    public JobResponse jobRegister (JobRequest jobRequest){

        Optional<Job> job = jobRepository.findByCompanyName(jobRequest.getCompanyName());
        if (job.isPresent()){
            return new JobResponse<>("JOB ALREADY EXIST",jobRequest.getCompanyName());
        }
        Job job1 =Job.builder()
                .jobName(jobRequest.getJobName())
                .jobType(jobRequest.getJobType())
                .companyName(jobRequest.getCompanyName())
                .experience(jobRequest.getExperience())
                .country(jobRequest.getCountry())
                .requirement(jobRequest.getRequirement())
                .build();
           jobRepository.save(job1);
        return new JobResponse<>("REGISTRATION SUCCESSFULLY",job1);
    }
}
