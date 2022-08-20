package com.cognizant.transactionMS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@Slf4j
public class TransactionMsApplication {


	/**
	 * @param args
	 * main method
	 */
	public static void main(String[] args) {
		log.info("TransactionserviceApplication is started");
		SpringApplication.run(TransactionMsApplication.class, args);
	}

	/**
	 * @return Docket
	 */
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.transactionservice.controller")).build().apiInfo(apiInfo());

	}

	/**
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("Transaction Service", "Retail Banking Project", "API", "Terms of service",
				new Contact("Peoples' Bank", "", "abc@email.com"), "License of API", "", Collections.emptyList());
	}

}
