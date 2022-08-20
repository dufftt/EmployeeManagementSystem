package com.cognizant.rulesMS.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Input needed for serviceCherges and minbalance Evaluation
public class RulesInput {	
	@NotNull
	private long accountId;
	@NotNull
	private double currentBalance;
	@NotNull
	private double amount;

}
