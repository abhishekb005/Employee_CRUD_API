package com.example.Application17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Application17Application {

	public static void main(String[] args) {
		SpringApplication.run(Application17Application.class, args);
	}

}
