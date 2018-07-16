package com.rabbit.opentracing.caller.controllers;


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

	static final String HELLO_URL = "http://localhost:10003/hello";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/caller")
	public String chaining() {

		log.debug("caller ...");

		final ResponseEntity<String> response = getRestTemplate().getForEntity(HELLO_URL, String.class);
		return "Greetings from hello-service: " + response.getBody();
	}

}
