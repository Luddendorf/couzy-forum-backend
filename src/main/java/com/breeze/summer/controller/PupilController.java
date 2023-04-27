package com.breeze.summer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.breeze.summer.service.PupilService;

import dto.Pupil;

@RestController
public class PupilController {
	
	@Autowired
	private final PupilService pupilService;

	@Autowired
	public PupilController(PupilService pupilsService) {
		this.pupilService = pupilsService;
		// this.pupilService = new PupilService();	
	}
	
    @GetMapping("/pupil/{pupilId}")
    public Pupil getPupilById(@PathVariable Long pupilId) {
        
    	return pupilService.getPupilById(pupilId);
    }
    
    @PostMapping(value="/pupil/update", consumes="application/json", produces="application/json")
    public Pupil updatePupilById(
    		@RequestHeader(value="Custom-Header", required=false) String customHeader, 
    		@RequestBody Pupil pupil) {
    	System.out.println("My Custom-Header " + customHeader);
    	return pupilService.updatePupilById(pupil);
    }

}
