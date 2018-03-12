package com.safecard.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safecard.jpa.model.Customer;
import com.safecard.jpa.model.TrackRecord;
import com.safecard.jpa.repo.CustomerRepository;
import com.safecard.jpa.repo.TrackRecordPaginationRepository;
import com.safecard.jpa.repo.TrackRecordRepository;
import com.safecard.jpa.service.TrackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.sound.midi.Track;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/trackrecord")
public class TrackRecordController {

	@Autowired
	TrackRecordService trackRecordService;

	@RequestMapping(method = RequestMethod.POST, value = "/save1")
	public TrackRecord save(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			//Object to JSON in String
			String jsonInString = mapper.writeValueAsString((new TrackRecord("10", "11")));
			System.out.println("jsonInString " + jsonInString);
		}catch(Exception  exp){
			exp.printStackTrace();
		}
		TrackRecord result = trackRecordService.save(new TrackRecord("10", "11" ));
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ResponseEntity<?> save(@RequestBody TrackRecord trackRecord, UriComponentsBuilder ucBuilder){
		ObjectMapper mapper = new ObjectMapper();

		try {
			//Object to JSON in String
			String jsonInString = mapper.writeValueAsString(trackRecord);
			System.out.println("jsonInString " + jsonInString);
		}catch(Exception  exp){
			exp.printStackTrace();
		}

		//TrackRecord result = repository.save(new TrackRecord(trackRecord.getLotNumber(), trackRecord.getCardNumber()));
		TrackRecord result = trackRecordService.save(trackRecord);
		URI location = ServletUriComponentsBuilder //.path("/findbyid").buildAndExpand(result.getId()).toUri();
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/trackrecord/findbylotnumber/{id}").buildAndExpand(result.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

		//return ResponseEntity.created(location).build();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveall")
	public ResponseEntity<?> saveAll(@RequestBody List<TrackRecord> trackRecords){
		List<TrackRecord> trackRecordList = trackRecordService.save(trackRecords);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(trackRecordList, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findall")
	public Collection<TrackRecord> findAll(){
		Collection<TrackRecord> trackRecords = new ArrayList<>();
		trackRecordService.findAll().forEach(trackRecords::add);
		return trackRecords;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findbyid")
	public TrackRecord findById(@RequestParam("id") long id){
		return trackRecordService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbylotnumber")
	public Collection<TrackRecord> fetchDataByLotNumber(@RequestParam("lotNumber") String lotNumber){
		return trackRecordService.fetchDataByLotNumber(lotNumber);
	}


	@RequestMapping(method=RequestMethod.GET, value="/findany")
	Page<TrackRecord> list(Pageable pageable){
		Page<TrackRecord> trackRecords = trackRecordService.listAllByPage(pageable);
		return trackRecords;
	}
}

