package com.safecard.jpa.repo;

import com.safecard.jpa.model.Job;
import com.safecard.jpa.model.TrackRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long>{
	List<Job> findByFileName(String fileName);
	List<Job> findByJobName(String jobName);

}
