package com.proj.tech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// Ce qu'il faut RUN car c'est l'application
@SpringBootApplication
@EntityScan(basePackages = {"com.proj.tech"})
public class ProjTechApplication {
	public static final Logger logger = LogManager.getLogger(ProjTechApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProjTechApplication.class, args);
	}

}
