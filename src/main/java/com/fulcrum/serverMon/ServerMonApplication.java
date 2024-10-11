package com.fulcrum.serverMon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan("com.fulcrum.serverMon.model")
@EnableJpaRepositories("com.fulcrum.serverMon.repository")
@EnableScheduling
public class ServerMonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerMonApplication.class, args);
	}

}
