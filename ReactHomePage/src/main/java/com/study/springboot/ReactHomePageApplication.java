package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReactHomePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactHomePageApplication.class, args);
	}

}
