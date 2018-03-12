package com.safecard.jpa.service.impl;

import com.safecard.jpa.model.Job;
import com.safecard.jpa.repo.JobPaginationRepository;
import com.safecard.jpa.repo.JobRepository;
import com.safecard.jpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    @Autowired
    JobPaginationRepository jobPaginationRepository;

    @Override
    public Page<Job> listAllByPage(Pageable pageable) {
        return jobPaginationRepository.findAll(pageable);
    }

    @Override
    public Iterable<Job> listAllByPage(Sort sort) {
        return jobPaginationRepository.findAll(sort);
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> save(List<Job> jobs) {
        Iterable<Job> iterableJobs = jobRepository.save(jobs);
        List<Job> targetJobList = new ArrayList<>();
        iterableJobs.forEach(targetJobList::add);
        return targetJobList;
    }


    @Override
    public List<Job> findByFileName(String fileName){
        return jobRepository.findByFileName(fileName);
    }

    @Override
    public List<Job> findByJobName(String jobName){
        return jobRepository.findByJobName(jobName);
    }

    @Override
    public Job findById(long id){
        return jobRepository.findOne(id);
    }

    @Override
    public Collection<Job> findAll(){
        Collection<Job> Jobs = new ArrayList<>();
        jobRepository.findAll().forEach(Jobs::add);
        return Jobs;
    }

}