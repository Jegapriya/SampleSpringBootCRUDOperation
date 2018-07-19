package com.spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.spring.model.Domain;
import com.spring.model.DomainRepo;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({ "com.spring.controller" })
public class Application {
	public static class DemoApplication {

		private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

		public void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
		}

		@Bean
		public CommandLineRunner setup(DomainRepo toDoRepository) {
			return (args) -> {
				toDoRepository.save(new Domain("Remove unused imports", true));
				toDoRepository.save(new Domain("Clean the code", true));
				toDoRepository.save(new Domain("Build the artifacts", false));
				toDoRepository.save(new Domain("Deploy the jar file", true));
				logger.info("The Domain data has been generated");
			};
		}
	}
}