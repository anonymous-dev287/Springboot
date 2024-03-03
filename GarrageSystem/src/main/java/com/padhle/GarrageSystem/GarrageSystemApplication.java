package com.padhle.GarrageSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.padhle.GarrageSystem")
@EnableScheduling
public class GarrageSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarrageSystemApplication.class, args);
		System.out.println("Welcome to Pawase Garrage");
	}

}
