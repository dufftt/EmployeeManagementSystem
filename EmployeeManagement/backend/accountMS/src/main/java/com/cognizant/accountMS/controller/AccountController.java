package com.cognizant.accountMS.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.accountMS.exceptionhandling.MinimumBalanceException;
import com.cognizant.accountMS.exceptionhandling.WrongDateFormatException;
import com.cognizant.accountMS.exceptionhandling.WrongDateProvidedException;
import com.cognizant.accountMS.feignclient.TransactionFeign;
import com.cognizant.accountMS.model.Account;
import com.cognizant.accountMS.model.AccountCreationStatus;
import com.cognizant.accountMS.model.AccountInput;
import com.cognizant.accountMS.model.Transaction;
import com.cognizant.accountMS.model.TransactionInput;
import com.cognizant.accountMS.service.AccountServiceImpl;




@RestController
public class AccountController { 

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	@Autowired
	private TransactionFeign transactionFeign; 

	
	/**
	 * @param token
	 * @param accountId
	 * @return ResponseEntity<Account>
	 
	 */
	// Rest End point which Returns particular account details based on the ID
	@GetMapping("/getAccount/{accountId}")
	public ResponseEntity<Account> getAccount(@RequestHeader("Authorization") String token,@PathVariable long accountId) {
		
		//check if user has permission to get Account details
		accountServiceImpl.hasPermission(token);
		
		Account accountReturnObject = accountServiceImpl.getAccount(accountId);
		LOGGER.info("Account Details Returned Sucessfully");
		return new ResponseEntity<>(accountReturnObject, HttpStatus.OK);
	}


	/**
	 * @param token
	 * @param customerId
	 * @param account
	 * @return ResponseEntity<>
	
	 */
	//Rest End point to create account for a Customer by his/her ID
	@PostMapping("/createAccount/{customerId}")
	public ResponseEntity<?> createAccount(@RequestHeader("Authorization") String token,@PathVariable String customerId,@Valid @RequestBody Account account) {
		accountServiceImpl.hasEmployeePermission(token);
		AccountCreationStatus returnObjAccountCreationStatus = accountServiceImpl.createAccount(customerId, account);
		if (returnObjAccountCreationStatus == null) {
			LOGGER.error("Customer Creation Unsucessful");
			return new ResponseEntity<>("Customer Creation Unsucessful", HttpStatus.NOT_ACCEPTABLE);
		}
			
		LOGGER.info("Account Created Sucessfully");
		return new ResponseEntity<>(returnObjAccountCreationStatus, HttpStatus.CREATED);
	}

	
	/**
	 * @param token
	 * @param customerId
	 * @return ResponseEntity<List<Account>>
	 
	 */
	
	//Rest End point to get all the accounts details
	@GetMapping("/getAccounts/{customerId}")
	public ResponseEntity<List<Account>> getCustomerAccount(@RequestHeader("Authorization") String token,@PathVariable String customerId) {
		accountServiceImpl.hasPermission(token);
		LOGGER.info("Account List Returned");
		return new ResponseEntity<>(accountServiceImpl.getCustomerAccount(token, customerId), HttpStatus.OK);
	}

	//if no date is provided
	/**
	 * @param token
	 * @return ResponseEntity<List<String>>
	 * @throws ParseException
	 * @throws WrongDateFormatException
	 * @throws WrongDateProvidedException
	 
	 */
	
	// Rest end point to get Account statement of all accounts
	@GetMapping("/getAccountStatement")
	public ResponseEntity<List<String>> getAccountStatement(@RequestHeader("Authorization") String token) throws ParseException, WrongDateFormatException, WrongDateProvidedException{
		accountServiceImpl.hasPermission(token);
		LOGGER.info("Account Statement List Returned");
		return new ResponseEntity<>(accountServiceImpl.getAccountStatement(), HttpStatus.OK);
	}
		
	//if both of the dates are provided
	/**
	 * @param token
	 * @param from
	 * @param to
	 * @return ResponseEntity<List<String>>
	 * @throws com.cognizant.accountMS.exceptionhandling.WrongDateFormatException
	 * @throws com.cognizant.accountMS.exceptionhandling.WrongDateProvidedException
	 * @throws ParseException
	 */
	
	//Rest end point to get Account statement between two accounts
	@GetMapping("/getAccountStatement/{from}/{to}")
	public ResponseEntity<List<String>> getAccountStatement(@RequestHeader("Authorization") String token,@PathVariable String from, @PathVariable String to) throws com.cognizant.accountMS.exceptionhandling.WrongDateFormatException, com.cognizant.accountMS.exceptionhandling.WrongDateProvidedException, ParseException{
		accountServiceImpl.hasPermission(token);
		LOGGER.info("Account Statement List Returned");
		return new ResponseEntity<>(accountServiceImpl.getAccountStatement(from,to), HttpStatus.OK);
	}
	

	/**
	 * @param token
	 * @param accInput
	 * @return  ResponseEntity<Account>
	 */
	
	//Rest end point to deposit amount into account
	@PostMapping("/deposit")
	public ResponseEntity<Account> deposit(@RequestHeader("Authorization") String token,@RequestBody AccountInput accInput) {
		accountServiceImpl.hasPermission(token);
		
		// Calling the makeDeposit API from Transaction microservice 
		transactionFeign.makeDeposit(token, accInput);
		Account newUpdateAccBal = accountServiceImpl.updateDepositBalance(accInput);
		List<Transaction> list = transactionFeign.getTransactionsByAccId(token, accInput.getAccountId());
		newUpdateAccBal.setTransactions(list);
		LOGGER.info("amount deposited");
		return new ResponseEntity<>(newUpdateAccBal, HttpStatus.OK);
	}

	

	/**
	 * @param token
	 * @param accInput
	 * @return ResponseEntity<Account> 
	 */
	
	// Rest end to withdraw amount from the account 
	@PostMapping("/withdraw")
	public ResponseEntity<Account> withdraw(@RequestHeader("Authorization") String token, @RequestBody AccountInput accInput) {
		accountServiceImpl.hasPermission(token);
		try {
			// Calling the makeWithdraw API from Transaction microservice 
			transactionFeign.makeWithdraw(token, accInput);

		} catch (Exception e) {
			
			//Account should contain a minimum balance of 1000.Rs
			LOGGER.error("Minimum Balance 1000 should be maintaind");
			throw new MinimumBalanceException("Minimum Balance 1000 should be maintained");
		}
		Account newUpdateAccBal = accountServiceImpl.updateBalance(accInput);
		List<Transaction> list = transactionFeign.getTransactionsByAccId(token, accInput.getAccountId());
		newUpdateAccBal.setTransactions(list);
		LOGGER.info("amount withdraw sucessful");
		return new ResponseEntity<>(newUpdateAccBal, HttpStatus.OK);
	}
	

	// to calculate service charge
	/**
	 * @param token
	 * @param accInput
	 * @return ResponseEntity<Account> 
	 */
	@PostMapping("/servicecharge")
	public ResponseEntity<Account> servicecharge(@RequestHeader("Authorization") String token,@RequestBody AccountInput accInput) {
		accountServiceImpl.hasPermission(token);
		try {
			transactionFeign.makeServiceCharges(token, accInput);

		} catch (Exception e) {
			LOGGER.error("Minimum Balance 1000 should be maintaind");
			throw new MinimumBalanceException("Minimum Balance 1000 should be maintaind");
		}
		Account newUpdateAccBal = accountServiceImpl.updateBalance(accInput);
		List<Transaction> list = transactionFeign.getTransactionsByAccId(token, accInput.getAccountId());
		newUpdateAccBal.setTransactions(list);
		LOGGER.info("amount service charged sucessful");
		return new ResponseEntity<>(newUpdateAccBal, HttpStatus.OK);
	}

	
	//make transaction from one account to another
	/**
	 * @param token
	 * @param transInput
	 * @return ResponseEntity<String>
	 */
	@PostMapping("/transaction")
	public ResponseEntity<String> transaction(@RequestHeader("Authorization") String token, @RequestBody TransactionInput transInput) {
		accountServiceImpl.hasPermission(token);
		boolean status = true;
		try {
			status = transactionFeign.makeTransfer(token, transInput);

		} catch (Exception e) {
			LOGGER.error("Minimum Balance 1000 should be maintaind");
			throw new MinimumBalanceException("Minimum Balance 1000 should be maintaind");
		}
		if (status == false) {
			return new ResponseEntity<>("Transaction Failed", HttpStatus.NOT_IMPLEMENTED);
		}
		Account updatedSourceAccBal = accountServiceImpl.updateBalance(transInput.getSourceAccount());
		List<Transaction> sourceAcc = transactionFeign.getTransactionsByAccId(token,transInput.getSourceAccount().getAccountId());
		updatedSourceAccBal.setTransactions(sourceAcc);

		Account updatedTargetAccBal = accountServiceImpl.updateDepositBalance(transInput.getTargetAccount());
		List<Transaction> targetAcc = transactionFeign.getTransactionsByAccId(token,transInput.getTargetAccount().getAccountId());
		updatedTargetAccBal.setTransactions(targetAcc);
		LOGGER.info("Transaction completed successfully from AccId" + transInput.getSourceAccount().getAccountId()+ " TO Target AccId " + transInput.getTargetAccount().getAccountId());
		return new ResponseEntity<>("Transaction is done successfully from AccId" + transInput.getSourceAccount().getAccountId()+ " TO Target AccId " + transInput.getTargetAccount().getAccountId() + " ",HttpStatus.OK);
	}

	

	/**
	 * @param token
	 * @param accountInput
	 * @return  ResponseEntity<Account>
	 */
	@PostMapping("/checkBalance")
	public ResponseEntity<Account> checkAccountBalance(@RequestHeader("Authorization") String token,@Valid @RequestBody AccountInput accountInput) {
		accountServiceImpl.hasPermission(token);
		Account account = accountServiceImpl.getAccount(accountInput.getAccountId());
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	

	//all accounts
	/**
	 * @param token
	 * @return ResponseEntity<List<Account>>
	 */
	@GetMapping("/find")
	public ResponseEntity<List<Account>> getAllAccount(@RequestHeader("Authorization") String token) {
		accountServiceImpl.hasPermission(token);
		List<Account> account = accountServiceImpl.getAllAccounts();
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

}
