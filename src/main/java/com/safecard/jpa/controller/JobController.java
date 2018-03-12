package com.safecard.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safecard.jpa.model.Job;
import com.safecard.jpa.repo.JobRepository;
import com.safecard.jpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	JobRepository repository;

	@Autowired
	JobService JobService;

	@RequestMapping(method = RequestMethod.POST, value = "/save1")
	public Job save(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			//Object to JSON in String
			String jsonInString = mapper.writeValueAsString((new Job("10", "11", new java.util.Date())));
			System.out.println("jsonInString " + jsonInString);
		}catch(Exception  exp){
			exp.printStackTrace();
		}
		return  repository.save(new Job("10", "11", new java.util.Date()));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ResponseEntity<?> save(@RequestBody Job Job, UriComponentsBuilder ucBuilder){
		ObjectMapper mapper = new ObjectMapper();

		try {
			//Object to JSON in String
			String jsonInString = mapper.writeValueAsString(Job);
			System.out.println("jsonInString " + jsonInString);
		}catch(Exception  exp){
			exp.printStackTrace();
		}

		//Job result = repository.save(new Job(Job.getLotNumber(), Job.getCardNumber()));
		Job result = repository.save(Job);
		URI location = ServletUriComponentsBuilder //.path("/findbyid").buildAndExpand(result.getId()).toUri();
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Job/findbyId/{id}").buildAndExpand(result.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

		//return ResponseEntity.created(location).build();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveall")
	public ResponseEntity<?> saveAll(@RequestBody List<Job> Jobs){
		Iterable<Job> IterableJobs = repository.save(Jobs);
		//  URI location = new URI("");
		//	 ServletUriComponentsBuilder
		//	  .fromCurrentRequest().path("/{id}")
		//	  .buildAndExpand(result.getId()).toUri();

		return null; //ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findall")
	public Collection<Job> findAll(){
		Collection<Job> Jobs = new ArrayList<>();
		this.repository.findAll().forEach(Jobs::add);
		return Jobs;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findbyid")
	public Job findById(@RequestParam("id") long id){
		return this.repository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbyFileName")
	public Collection<Job> fetchDataByLotNumber(@RequestParam("fileName") String fileName){
		return this.repository.findByFileName(fileName);
	}


	@RequestMapping(method=RequestMethod.GET, value="/findany")
	Page<Job> list(Pageable pageable){
		Page<Job> Jobs = JobService.listAllByPage(pageable);
		return Jobs;
	}
}

