package com.cognizant.rulesMS.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

	/**
	 *  Account Entity used in Repository
	 */
	@Id
	private long accountId;
	

	private String customerId;

	private double currentBalance;


	private String accountType;
	

	private Date openingDate;

	@Column(length = 20)

	private String ownerName;

	@Transient
	private List<Transaction> transactions;

}