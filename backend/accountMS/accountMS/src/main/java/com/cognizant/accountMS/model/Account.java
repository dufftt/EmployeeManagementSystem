package com.cognizant.accountMS.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor 
public class Account {

	// Account model
	@Id
	@Getter
	@Setter 
	@Column(length=10)
	@SequenceGenerator(name="seq", initialValue = 1000000001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private long accountId;
	

	@Getter
	@Setter
	private String customerId;


	@Getter
	@Setter
	private double currentBalance;

	@Getter
	@Setter
	private String accountType;

	@Getter
	@Setter
	private Date openingDate;

	
	@Getter
	@Setter
	@Column(length = 20)
	private String ownerName;


	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;
	
	
	@ManyToOne
	private CustomerEntity customer;
	
	@Override
	public String toString() {
		return "Account information : [accountId=" + accountId + ", openingDate=" + openingDate + ", currentBalance=" + currentBalance
				+ ", accountType=" + accountType + "]";
	}

}