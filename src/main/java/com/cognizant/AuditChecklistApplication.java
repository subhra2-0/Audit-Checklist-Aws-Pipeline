package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
@EnableFeignClients
public class AuditChecklistApplication {
	/**
	 * main Method- SpringBoot main method to launch an application. 
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuditChecklistApplication.class, args);
	}

}
