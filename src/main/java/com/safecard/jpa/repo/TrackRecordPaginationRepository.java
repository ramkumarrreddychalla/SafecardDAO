package com.safecard.jpa.repo;

import com.safecard.jpa.model.TrackRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TrackRecordPaginationRepository extends PagingAndSortingRepository<TrackRecord, Long> {

}
