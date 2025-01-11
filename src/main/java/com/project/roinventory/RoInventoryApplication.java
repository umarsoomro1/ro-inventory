package com.project.roinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.project.roinventory")
public class RoInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoInventoryApplication.class, args);
	}
}
