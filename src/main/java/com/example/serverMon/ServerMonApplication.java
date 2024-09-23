package com.example.serverMon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerMonApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerMonApplication.class, args);
	}
}