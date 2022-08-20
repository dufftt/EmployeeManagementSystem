package com.cognizant.customerMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountCreationStatus {

	@Id
	long accountId;
	String message;
	

	
}
