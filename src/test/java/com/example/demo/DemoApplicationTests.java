package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootTest
@SpringBootApplication
@EnableJpaAuditing
class DemoApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplicationTests.class, args);
	}

}
