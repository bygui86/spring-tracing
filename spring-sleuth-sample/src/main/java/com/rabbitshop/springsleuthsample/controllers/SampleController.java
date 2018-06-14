package com.rabbitshop.springsleuthsample.controllers;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@RestController
public class SampleController {

	static final String HELLO_URL = "http://localhost:10002/hello";

	static final String CHAINING_URL = "http://localhost:10002/chaining";

	static final String ANOTHER_URL = "http://localhost:10002/another";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hello")
	public String hello() {

		log.debug("hello ...");

		return "Hello from Spring Tracing Sample!";
	}

	@GetMapping("/chaining")
	public String chaining() {

		log.debug("chaining ...");

		final ResponseEntity<String> response = getRestTemplate().getForEntity(HELLO_URL, String.class);
		return "Chaining ... " + response.getBody();
	}

	@GetMapping("/another")
	public String another() {

		log.debug("another chaining ...");

		final ResponseEntity<String> response = getRestTemplate().getForEntity(CHAINING_URL, String.class);
		return "Another chaining ... " + response.getBody();
	}

	@GetMapping("/again")
	public String again() {

		log.debug("again chaining ...");

		final ResponseEntity<String> response = getRestTemplate().getForEntity(ANOTHER_URL, String.class);
		return "Again chaining ... " + response.getBody();
	}

}
