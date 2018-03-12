package com.safecard.jpa.service;

import com.safecard.jpa.model.Job;
import com.safecard.jpa.model.TrackRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface JobService {
    Page<Job> listAllByPage(Pageable pageable);
    Iterable<Job> listAllByPage(Sort sort);
}
