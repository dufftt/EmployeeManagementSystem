package com.cognizant.customerMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

	@Transient
	private List<Transaction> transactions = new ArrayList<>();


}