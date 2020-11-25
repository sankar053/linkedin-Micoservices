package com.iii.linkedin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.iii.linkedin.model.Address;
import com.iii.linkedin.model.Person;

@RestController
@RequestMapping("/filtering")
public class FilteringController {
	
	
	@GetMapping
	public Person retriveSomeBeans() {
		
		return new Person("Sankar","FIS","Chennai");
		
	}
	
	@GetMapping("/dynamic1")
	public MappingJacksonValue retriveSomeBeanswothDynamicFilter() {
		 
		Address address=new Address("FIS","Chennai","India");
		
		SimpleBeanPropertyFilter pptyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("company","location");
		FilterProvider filter =  new SimpleFilterProvider().addFilter("address", pptyFilter);
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(address);
		jacksonValue.setFilters(filter);
		
		return jacksonValue;
		
	}

	@GetMapping("/dynamic2")
	public MappingJacksonValue retriveSomeBeanswothDynamicFilter1 	() {
		
		List<Address> addresslist= Arrays.asList(new Address("FIS","Chennai","India"),
				new Address("CTS","Chennai","India"));
		SimpleBeanPropertyFilter pptyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("company","country");
		FilterProvider filter =  new SimpleFilterProvider().addFilter("address", pptyFilter);
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(addresslist);
		jacksonValue.setFilters(filter);
		
		return jacksonValue;
		
	}
	@GetMapping("/list")
	public List<Person> retrivelistBeans() {
		
		return Arrays.asList(new Person("Sankar","FIS","Chennai"),new Person("Perumal","FIS","Chennai"));
		
	}

}
