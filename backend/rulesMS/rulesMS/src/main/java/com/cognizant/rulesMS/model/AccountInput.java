package com.cognizant.rulesMS.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInput {
	
	/**
	 *  Class used for inputing account info during rules checking
	 */
	

	private long accountId;

	private double amount;

}