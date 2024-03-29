package com.cognizant.customerMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomErrorResponse {

	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private String message;

}
