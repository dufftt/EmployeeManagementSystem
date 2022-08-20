package com.cognizant.customerMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import java.time.LocalDateTime;



@Table(name = "TRANSACTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	private long id;

	private long sourceAccountId;
	
	private String sourceOwnerName;

	private long targetAccountId;

	private String targetOwnerName;

	private double amount;

	private LocalDateTime initiationDate;

	private String reference;

}