package com.safecard.jpa.service;

import com.safecard.jpa.model.TrackRecord;
import com.safecard.jpa.repo.TrackRecordPaginationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface TrackRecordService {
    Page<TrackRecord> listAllByPage(Pageable pageable);
    Iterable<TrackRecord> listAllByPage(Sort sort);
}
