package com.iii.linkedin.swagger.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configureation
//EnameSwagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("SankaraNarayanan",
			"https://github.com/sankar053/linkedin-Micoservices", "sankaraasn@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Microservices Api Documentation",
			"Microservices Api Description", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	private static final Set<String> DEFAULT_PRODUCE_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCE_CONSUMES)
				.consumes(DEFAULT_PRODUCE_CONSUMES);
	}
}
