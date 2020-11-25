package com.iii.linkedin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"location","company"})
public class Person {
	

	private String name;
	

	private String company;
	
	@JsonIgnore
	private String location;
	
	
	public Person(String name, String company, String location) {
		super();
		this.name = name;
		this.company = company;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
