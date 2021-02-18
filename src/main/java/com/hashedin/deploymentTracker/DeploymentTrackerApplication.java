package com.hashedin.deploymentTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hashedin.deploymentTracker")
public class DeploymentTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeploymentTrackerApplication.class, args);
	}

}
