package com.cognizant.transactionMS.models;

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
public class TransactionErrorResponse {
	
	
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private String message;
}
