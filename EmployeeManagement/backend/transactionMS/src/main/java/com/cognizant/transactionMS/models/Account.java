package com.cognizant.transactionMS.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	private long accountId;

	private String customerId;

	private double currentBalance;

	private String accountType;
	
	private Date openingDate;

	private String ownerName;

	@Transient
	private transient List<Transaction> transactions;

}