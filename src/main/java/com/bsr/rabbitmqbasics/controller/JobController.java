package com.bsr.rabbitmqbasics.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bsr.rabbitmqbasics.publisher.JobPublisher;

@RestController
public class JobController {
	
	@Autowired
	private JobPublisher publisher;
	
	@PostMapping("/job")
	ResponseEntity<?> publishNewJob(@RequestBody Map<String,Object> jobDetails){
		return ResponseEntity.ok(publisher.publishJob(jobDetails));
	}

}