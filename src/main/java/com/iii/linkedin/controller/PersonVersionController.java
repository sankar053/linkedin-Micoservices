package com.iii.linkedin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.linkedin.versioning.Name;
import com.iii.linkedin.versioning.PersonV1;
import com.iii.linkedin.versioning.PersonV2;

@RestController
@RequestMapping("/Version")
public class PersonVersionController {
	
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Sankar");
	}
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Sankar","Narayanan"));
	}
	//Param Versioning
	@GetMapping(value="/person/param",params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Sankar");
	}
	@GetMapping(value="/person/param",params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Sankar","Narayanan"));
	}
//Header Versioning
	
	@GetMapping(value="/person/header",headers =  "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Sankar");
	}
	@GetMapping(value="/person/header",headers = "X-API-VERSION=1")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Sankar","Narayanan"));
	}

}
