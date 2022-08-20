package com.cognizant.rulesMS.controller;

import com.cognizant.rulesMS.exception.MinimumBalanceException;
import com.cognizant.rulesMS.feign.AccountFeign;
import com.cognizant.rulesMS.model.Account;
import com.cognizant.rulesMS.model.AccountInput;
import com.cognizant.rulesMS.model.RulesInput;
import com.cognizant.rulesMS.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RulesController {

	private static final String INVALID = "Send Valid Details.";
	@Autowired
	public RulesService rulesService;
	@Autowired
	AccountFeign accountFeign;

	// Check the minimum balance 
	/**
	 * @param account
	 * @return ResponseEntity<?>
	 * @throws MinimumBalanceException
	 */
	@PostMapping("/evaluateMinBal") 
	public ResponseEntity<?> evaluate(@RequestBody RulesInput account)
			throws MinimumBalanceException {
		// Jwt token is checked
		// check the accountId is Not null
		if (account.getCurrentBalance()== 0) {
			throw new MinimumBalanceException(INVALID);
		} else {
			boolean status = rulesService.evaluate(account);

			return new ResponseEntity<Boolean>(status,HttpStatus.OK);
		}
	}

	// Service charges calculation
	/**
	 * @param token
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/serviceCharges")
	public ResponseEntity<?> serviceCharges(@RequestHeader("Authorization") String token) {
		// Jwt token is checked
		rulesService.hasPermission(token);
		
//		accountFeign.servicecharge(token, new AccountInput(account.getAccountId(), detected));
		try {
			List<Account> body = accountFeign.getAllacc(token).getBody();
			for(Account acc:body) {
				double detected=acc.getCurrentBalance()/10;
				if(acc.getCurrentBalance()<2000 && (acc.getCurrentBalance()-detected)>0)
					accountFeign.servicecharge(token, new AccountInput(acc.getAccountId(),detected));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}


		return ResponseEntity.ok(accountFeign.getAllacc(token).getBody());
	}



}
