package com.cognizant.accountMS.service;

import com.cognizant.accountMS.exceptionhandling.WrongDateFormatException;
import com.cognizant.accountMS.exceptionhandling.WrongDateProvidedException;
import com.cognizant.accountMS.model.Account;
import com.cognizant.accountMS.model.AccountCreationStatus;
import com.cognizant.accountMS.model.AccountInput;
import com.cognizant.accountMS.model.AuthenticationResponse;

import java.text.ParseException;
import java.util.List;


public interface AccountService {
	
	/**
	 * @param customerId
	 * @param account
	 * @return AccountCreationStatus
	 */
	public AccountCreationStatus createAccount(String customerId, Account account);

	/**
	 * @param token
	 * @param customerId
	 * @return List<Account>
	 */
	public List<Account> getCustomerAccount(String token, String customerId);

	/**
	 * @param accountId
	 * @return Account
	 */
	public Account getAccount(long accountId);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasPermission(String token);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasEmployeePermission(String token);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasCustomerPermission(String token);

	/**
	 * @param accountInput
	 * @return Account
	 */
	public Account updateDepositBalance(AccountInput accountInput);

	/**
	 * @param accountInput
	 * @return Account
	 */
	public Account updateBalance(AccountInput accountInput);
	
	/**
	 * @return List<Account>
	 */
	public List<Account> getAllAccounts();

	/**
	 * @param from
	 * @param to
	 * @return List<String>
	 * @throws WrongDateFormatException
	 * @throws WrongDateProvidedException
	 * @throws ParseException
	 */
	public List<String> getAccountStatement(String from, String to)throws WrongDateFormatException, WrongDateProvidedException, ParseException;
	
	/**
	 * @return List<String>
	 * @throws WrongDateFormatException
	 * @throws WrongDateProvidedException
	 * @throws ParseException
	 */
	public List<String> getAccountStatement() throws WrongDateFormatException, WrongDateProvidedException, ParseException;

}
