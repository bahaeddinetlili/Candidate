package com.microservices.candidate;

import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaServer
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