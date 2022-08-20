package com.cognizant.transactionMS.controller;

import com.cognizant.transactionMS.feign.AccountFeign;
import com.cognizant.transactionMS.feign.RulesFeign;
import com.cognizant.transactionMS.models.Transaction;
import com.cognizant.transactionMS.repository.TransactionRepository;
import com.cognizant.transactionMS.service.TransactionServiceInterface;
import com.cognizant.transactionMS.util.AccountInput;
import com.cognizant.transactionMS.util.TransactionInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
public class TransactionRestController {

	public static final String METHOD_FOR_MAKETRANSFER = "AccountFallbackForTransfer";
	public static final String METHOD_FOR_MAKEWITHDRAW = "AccountFallbackForWithdraw";
	public static final String METHOD_FOR_MAKEDEPOSIT = "AccountFallbackForDeposit";

	@Autowired
	AccountFeign accountFeign;

	@Autowired
	RulesFeign rulesFeign;

	@Autowired
	TransactionRepository transRepo;

	@Autowired
	TransactionServiceInterface transactionService;

	
	/**
	 * @param token
	 * @param transactionInput
	 * @return boolean
	 */
	@PostMapping(value = "/transactions")
	public boolean makeTransfer(@RequestHeader("Authorization") String token,
			@Valid @RequestBody TransactionInput transactionInput) {
		log.info("inside transaction method");
		if (transactionInput != null) {
			boolean isComplete = transactionService.makeTransfer(token, transactionInput);
			
			return isComplete;
		} else {
			return false;
		}
	}

	
	/**
	 * @return boolean
	 */
	public boolean AccountFallbackForTransfer() {
		log.error("Account Microservice is DOWN!");
		return false;
	}


	/**
	 * @param token
	 * @param accId
	 * @return List<Transaction>
	 */
	@GetMapping(value = "/getAllTransByAccId/{id}")
	public List<Transaction> getTransactionsByAccId(@RequestHeader("Authorization") String token,
			@PathVariable("id") long accId) {
		List<Transaction> slist = transRepo.findBySourceAccountIdOrTargetAccountIdOrderByInitiationDate(accId, accId);
		return slist;
	}


	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	
	//Rest end point which implements the withdraw service
	@PostMapping(value = "/withdraw")
	public boolean makeWithdraw(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInput accountInput){
		transactionService.makeWithdraw(token, accountInput);
		return true;
	}
	
	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	
	//function to apply service charges 
	@PostMapping(value = "/servicecharge")
	public boolean makeServiceCharges(@RequestHeader("Authorization") String token,@Valid @RequestBody AccountInput accountInput) {
		transactionService.makeServiceCharges(token, accountInput);
		return true;
	}

	
	/**
	 * @return boolean
	 */
	public boolean AccountFallbackForWithdraw() {
		log.error("Withdraw Microservice is DOWN!");
		return false;
	}

	
	/**
	 * @param token
	 * @param accountInput
	 * @return ResponseEntity<?>
	 */
	@PostMapping(value = "/deposit")
	public ResponseEntity<?> makeDeposit(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInput accountInput) {
		transactionService.makeDeposit(token, accountInput);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	

}
