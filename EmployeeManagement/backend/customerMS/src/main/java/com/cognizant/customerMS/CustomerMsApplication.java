package com.cognizant.customerMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class CustomerMsApplication {

	/**
	 * @param args
	 * Main Method
	 */
	public static void main(String[] args) {
		SpringApplication.run(CustomerMsApplication.class, args);
	}

	/**
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("Customer Service", "Retail Banking Project", "API", "Terms of service",
				new Contact("ABC", "", "abc@email.com"), "License of API", "", Collections.emptyList());
	}
}
