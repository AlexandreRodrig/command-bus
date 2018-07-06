package com.commandbus.commandbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CommandBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandBusApplication.class, args);
	}
}
