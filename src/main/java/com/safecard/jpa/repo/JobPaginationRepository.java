package com.safecard.jpa.repo;

import com.safecard.jpa.model.Job;
import com.safecard.jpa.model.TrackRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobPaginationRepository extends PagingAndSortingRepository<Job, Long> {

}
