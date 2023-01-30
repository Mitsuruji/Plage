package fr.orsys.projet.plage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PlageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlageApplication.class, args);
	}
	
	@Bean
	@Scope("singleton")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
