package com.proj.tech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Main class for running the ProjTech application.
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.proj.tech"})
public class ProjTechApplication {

	/**
	 * The logger instance for logging purposes.
	 */
	public static final Logger logger = LogManager.getLogger(ProjTechApplication.class);

	/**
	 * The main method to start the Spring Boot application.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjTechApplication.class, args);
	}
}
