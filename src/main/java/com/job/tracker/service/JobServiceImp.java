package com.job.tracker.service;

import com.job.tracker.dtos.request.JobRequest;
import com.job.tracker.dtos.response.JobResponse;
import com.job.tracker.model.Job;
import com.job.tracker.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public JobResponse deleteJob(String companyName){
        Optional<Job> deleteJob = jobRepository.findByCompanyName(companyName);
        if (deleteJob.isEmpty()){
            return  new JobResponse<>("JOB NOT FOUND ",  companyName);
        }
        Job foundJob= deleteJob.get();
        jobRepository.delete(foundJob);
        return  new JobResponse<>("JOB DELETED SUCCESSFULLY  ",  foundJob);
    }

    @Override
public List<Job> findAll(){
     return jobRepository.findAll();
}

    @Override
    public JobResponse findByCompanyName (String companyName) {
        Optional<Job> findByCompanyName = jobRepository.findByCompanyName(companyName);
        if (findByCompanyName.isEmpty()) {
            return new JobResponse<>("JOB NOT IN DATABASE",companyName);
        }
        Job job = findByCompanyName.get();
        return new JobResponse<>("SUCCESSFULLY",job);
    }



    }
