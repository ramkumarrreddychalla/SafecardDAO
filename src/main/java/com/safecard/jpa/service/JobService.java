package com.safecard.jpa.service;

import com.safecard.jpa.model.Job;
import com.safecard.jpa.model.TrackRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;

public interface JobService {
    Page<Job> listAllByPage(Pageable pageable);
    Iterable<Job> listAllByPage(Sort sort);
    Job save(Job job);
    List<Job> save(List<Job> jobs);
    List<Job> findByFileName(String fileName);
    List<Job> findByJobName(String jobName);
    Job findById(long id);
    Collection<Job> findAll();
}
