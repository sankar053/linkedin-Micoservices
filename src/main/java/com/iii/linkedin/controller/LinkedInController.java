package com.iii.linkedin.controller;

import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LinkedIn")
public class LinkedInController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hellow/{name}")
	public String hellowWorld(@PathVariable String name) {
		return ("Hellow "+name);
	}

	@GetMapping("/hellowinternational")
	public String hellowWorld(@RequestHeader(name="Accept-language",required = false) Locale locale) {
		return (messageSource.getMessage("good.morning.message",null,locale));
	}
	
	@GetMapping("/hellowinternational-Noheader")
	public String hellowWorldWithoutHeader(Locale locale) {
		return (messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale()));
	}

}
