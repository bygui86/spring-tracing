package com.rabbit.sleuth.caller.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Configuration
@Order(20)
public class RestConfig {

	@Bean
	public RestTemplate restTemplate() {

		log.debug("Creating RestTemplate...");

		return new RestTemplate();
	}

}
