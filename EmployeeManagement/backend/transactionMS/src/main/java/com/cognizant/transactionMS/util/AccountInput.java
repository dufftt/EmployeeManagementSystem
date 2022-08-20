package com.cognizant.transactionMS.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInput {

	@NotNull(message = "Account number is mandatory")
	private long accountId;
	@NotNull(message = "Amount is mandatory")
	private double amount;

	
} 