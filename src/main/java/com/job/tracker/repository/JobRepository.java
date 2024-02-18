package com.job.tracker.repository;

import com.job.tracker.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findByCompanyName(String companyName);
}
