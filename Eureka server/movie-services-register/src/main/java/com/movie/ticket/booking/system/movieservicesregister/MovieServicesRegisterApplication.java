package com.movie.ticket.booking.system.movieservicesregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MovieServicesRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServicesRegisterApplication.class, args);
	}

}
