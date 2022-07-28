package com.cognizant.customerMS.model;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
	
	private long accountId;

	private String customerId;


	private double currentBalance;

	private String accountType;
	
	private Date openingDate;


	private String ownerName;


}
