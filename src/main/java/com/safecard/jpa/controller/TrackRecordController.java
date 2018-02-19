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
	TrackRecordRepository repository;

	@Autowired
	TrackRecordService trackRecordService;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<?> add(@RequestBody TrackRecord trackRecord){
		ObjectMapper mapper = new ObjectMapper();

		try {
			//Object to JSON in String
			String jsonInString = mapper.writeValueAsString(trackRecord);
			System.out.println("jsonInString " + jsonInString);
		}catch(Exception  exp){
			exp.printStackTrace();
		}

		TrackRecord result = repository.save(trackRecord);
		return new ResponseEntity<>(result, HttpStatus.CREATED);

		//UriComponentsBuilder ucBuilder
		// URI location = ServletUriComponentsBuilder //.path("/findbyid").buildAndExpand(result.getId()).toUri();
		//.fromCurrentRequest().path("/{id}")
		//.buildAndExpand(result.getId()).toUri();
		//HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("/trackrecord/findbylotnumber/{id}").buildAndExpand(result.getId()).toUri());
		//return ResponseEntity.created(location).build();
	}
	


	@RequestMapping(method = RequestMethod.POST, value = "/saveall")
	public ResponseEntity<?> saveAll(@RequestBody List<TrackRecord> trackRecords){
		Iterable<TrackRecord> IterableTrackRecords = repository.save(trackRecords);
		return new ResponseEntity<>(IterableTrackRecords, HttpStatus.CREATED);

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findall")
	public ResponseEntity<?> findAll(){
		Collection<TrackRecord> trackRecords = new ArrayList<>();
		this.repository.findAll().forEach(trackRecords::add);
		if(trackRecords != null && !trackRecords.isEmpty()) {
			return new ResponseEntity<>(trackRecords, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findbyid")
	public ResponseEntity<?> findById(@RequestParam("id") long id){
		TrackRecord trackRecord = this.repository.findOne(id);
		if(trackRecord != null) {
			return new ResponseEntity<>(trackRecord, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbylotnumber")
	public ResponseEntity<?> fetchDataByLotNumber(@RequestParam("lotNumber") String lotNumber){

		List<TrackRecord> trackRecords = this.repository.findBylotNumber(lotNumber);
		if(trackRecords != null) {
			return new ResponseEntity<>(trackRecords, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/findallpage")
	public ResponseEntity<?> listByPage(Pageable pageable){
		Page<TrackRecord> trackRecords = trackRecordService.listAllByPage(pageable);
		if(trackRecords != null) {
			return new ResponseEntity<>(trackRecords, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTrackRecord(@PathVariable long id) {
		this.repository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

