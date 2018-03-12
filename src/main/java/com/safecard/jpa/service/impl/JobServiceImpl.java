package com.safecard.jpa.service.impl;

import com.safecard.jpa.model.Job;
import com.safecard.jpa.repo.JobPaginationRepository;
import com.safecard.jpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobServiceImpl implements JobService {

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
}
