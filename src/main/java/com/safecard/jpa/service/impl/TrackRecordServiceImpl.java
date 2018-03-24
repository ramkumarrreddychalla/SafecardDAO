package com.safecard.jpa.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safecard.jpa.model.Job;
import com.safecard.jpa.model.TrackRecord;
import com.safecard.jpa.repo.TrackRecordPaginationRepository;
import com.safecard.jpa.repo.TrackRecordRepository;
import com.safecard.jpa.service.TrackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class TrackRecordServiceImpl implements TrackRecordService {

    @Autowired
    TrackRecordRepository trackRecordRepository;

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

    @Override
    public TrackRecord save(TrackRecord trackRecord) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Object to JSON in String
            String jsonInString = mapper.writeValueAsString(trackRecord);
            System.out.println("jsonInString " + jsonInString);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        TrackRecord result = trackRecordRepository.save(trackRecord);
        return result;
    }

    @Override
    public List<TrackRecord> save(List<TrackRecord> trackRecords) {
        Iterable<TrackRecord> iterableJobs = trackRecordRepository.save(trackRecords);
        List<TrackRecord> targetJobList = new ArrayList<>();
        iterableJobs.forEach(targetJobList::add);
        return targetJobList;
    }


    @Override
    public Collection<TrackRecord> findAll() {
        Collection<TrackRecord> trackRecords = new ArrayList<>();
        trackRecordRepository.findAll().forEach(trackRecords::add);
        return trackRecords;
    }

    @Override
    public TrackRecord findById(long id) {
        return trackRecordRepository.findOne(id);
    }

    @Override
    public Collection<TrackRecord> fetchDataByLotNumber(String lotNumber) {
        return trackRecordRepository.findBylotNumber(lotNumber);
    }

    @Override
    public Collection<TrackRecord> findByLotNumber(String lotNumber){
        return trackRecordRepository.findBylotNumber(lotNumber);
    }
}
