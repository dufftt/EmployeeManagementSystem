package com.cognizant.transactionMS.feign;

import com.cognizant.transactionMS.exception.MinimumBalanceException;
import com.cognizant.transactionMS.models.RulesInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "rules-ms", url = "${feign.url-rule-service}")
public interface RulesFeign {
	
	/**
	 * @param account
	 * @return ResponseEntity<?>
	 * @throws MinimumBalanceException
	 */
	@PostMapping("/evaluateMinBal")
	public ResponseEntity<?> evaluate(@RequestBody RulesInput account)throws MinimumBalanceException ;
	
	/**
	 * @param token
	 * @param account
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/serviceCharges")
	public ResponseEntity<?> serviceCharges(@RequestHeader("Authorization") String token,@RequestBody RulesInput account);
	

}
