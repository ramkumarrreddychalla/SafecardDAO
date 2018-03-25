package com.safecard.jpa.repo;

import com.safecard.jpa.model.TrackRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackRecordRepository extends CrudRepository<TrackRecord, Long>{
	List<TrackRecord> findByPan(String pan);
}
