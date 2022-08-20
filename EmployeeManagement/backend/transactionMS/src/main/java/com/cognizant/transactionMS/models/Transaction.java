package com.cognizant.transactionMS.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long sourceAccountId;
	
	private String sourceOwnerName;

	private long targetAccountId;

	private String targetOwnerName;

	private double amount;

	private LocalDateTime initiationDate;

	private String reference;

}