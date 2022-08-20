package com.cognizant.rulesMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	/**
	 *  Class used for inputing transaction entity
	 */
	private long id;
	private long sourceAccountId;
	private String sourceOwnerName;
	private long targetAccountId;
	private String targetOwnerName;
	private double amount;
	private LocalDateTime initiationDate;
	private String reference;

}