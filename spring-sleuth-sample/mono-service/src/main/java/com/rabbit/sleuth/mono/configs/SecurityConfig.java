package com.rabbit.sleuth.mono.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Slf4j
@Configuration
@EnableWebSecurity
@Order(10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * PLEASE NOTE: For sake of simplicity we are omitting specific security configurations
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		log.warn("Loading INSECURE security config...");

		http
				.authorizeRequests()
				.anyRequest().permitAll()

				.and()
				.httpBasic()

				.and()
				.cors()

				.and()
				.csrf().disable();
	}

}
