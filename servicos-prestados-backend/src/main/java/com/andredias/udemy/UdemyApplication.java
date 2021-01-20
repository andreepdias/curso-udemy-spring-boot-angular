package com.andredias.udemy;

import com.andredias.udemy.model.entity.Client;
import com.andredias.udemy.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UdemyApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("PUT", "DELETE", "GET", "POST", "PATCH")
				;
			}
		};
	}

	@Bean
	public CommandLineRunner run(@Autowired ClientRepository clientRepository){
		return args -> {
			Client client  = Client.builder().name("Andressa").cpf("07345965708").build();
			clientRepository.save(client);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
	}

}
