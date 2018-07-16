package com.rabbit.opentracing.hello.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class SampleController {

	@GetMapping("/hello")
	public String hello() {

		log.debug("hello ...");

		return "Hello from OpenTracing Sample!";
	}

}
