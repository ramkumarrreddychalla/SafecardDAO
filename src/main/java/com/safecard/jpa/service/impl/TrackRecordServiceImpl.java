package com.safecard.jpa.service.impl;

import com.safecard.jpa.model.TrackRecord;
import com.safecard.jpa.repo.TrackRecordPaginationRepository;
import com.safecard.jpa.service.TrackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrackRecordServiceImpl implements TrackRecordService{

    @Autowired
    TrackRecordPaginationRepository trackRecordPaginationRepository;

    @Override
    public Page<TrackRecord> listAllByPage(Pageable pageable) {
        return trackRecordPaginationRepository.findAll(pageable);
    }

    @Override
    public Iterable<TrackRecord> listAllByPage(Sort sort) {
        return trackRecordPaginationRepository.findAll(sort);
    }
}
