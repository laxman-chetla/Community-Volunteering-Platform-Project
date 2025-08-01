package com.CommunityVolunteerPlatform.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CommunityVolunteeringPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityVolunteeringPlatformApplication.class, args);
	}

}
