package com.iii.linkedin.model;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("address")
public class Address {
	

	private String country;
	

	private String company;
	
	
	private String location;
	
	
	public Address( String company, String location,String country) {
		super();
		this.country = country;
		this.company = company;
		this.location = location;
	}

	

	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
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
