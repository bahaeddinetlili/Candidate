package com.microservices.candidate;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class CandidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CandidatRepository repository) {
		return args -> {
			Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
				repository.save(new Candidat(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}