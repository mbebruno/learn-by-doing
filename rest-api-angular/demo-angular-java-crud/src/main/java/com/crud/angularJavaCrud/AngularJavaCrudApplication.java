package com.crud.angularJavaCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AngularJavaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularJavaCrudApplication.class, args);
	}
//Cross Origin Global configuration
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/*").allowedOrigins("http://localhost:4200/");
			}
		};
	}

}
