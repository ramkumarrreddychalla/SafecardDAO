package com.safecard.jpa.service;

import com.safecard.jpa.model.TrackRecord;
import com.safecard.jpa.repo.TrackRecordPaginationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface TrackRecordService {
    Page<TrackRecord> listAllByPage(Pageable pageable);
    Iterable<TrackRecord> listAllByPage(Sort sort);

    public TrackRecord save(TrackRecord trackRecord);
    List<TrackRecord> save(List<TrackRecord> trackRecords);

    Collection<TrackRecord> findAll();
    TrackRecord findById(long id);
    Collection<TrackRecord> fetchDataByLotNumber(String lotNumber);
    Collection<TrackRecord> findByLotNumber(String lotNumber);
}
