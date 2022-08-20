package com.cognizant.transactionMS.service;

import com.cognizant.transactionMS.util.AccountInput;
import com.cognizant.transactionMS.util.TransactionInput;


public interface TransactionServiceInterface {

	/**
	 * @param token
	 * @param transactionInput
	 * @return boolean
	 */
	public boolean makeTransfer(String token, TransactionInput transactionInput);

	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	public boolean makeWithdraw(String token, AccountInput accountInput);

	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	public boolean makeDeposit(String token, AccountInput accountInput);
	
	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	public boolean makeServiceCharges(String token, AccountInput accountInput);
}
