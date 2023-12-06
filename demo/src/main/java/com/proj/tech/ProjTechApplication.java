package com.proj.tech;

import com.proj.tech.controller.MonControleur;
import com.proj.tech.dto.Session;
import com.proj.tech.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.logging.Logger;

// Ce qu'il faut RUN car c'est l'application
@SpringBootApplication
@EntityScan(basePackages = {"com.proj.tech"})
public class ProjTechApplication {
	public static void main(String[] args) {
		/* Logger.getLogger(User.class.getName()).info("Nous créons un utilisateur");
		Logger.getLogger(Session.class.getName()).info("Nous créons une nouvelle session");

		Logger.getLogger(MonControleur.class.getName()).warning("Demande de requete Form");
		Logger.getLogger(Session.class.getName()).severe("Rien pour l'instant"); */
		SpringApplication.run(ProjTechApplication.class, args
		);
	}

}
