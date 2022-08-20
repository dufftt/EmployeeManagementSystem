package com.cognizant.customerMS.feign;

import com.cognizant.customerMS.model.Account;
import com.cognizant.customerMS.model.AccountCreationStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "account-ms", url = "${feign.url-account-service}")
public interface AccountFeign {

	/**
	 * @param token
	 * @param customerId
	 * @param account
	 * @return AccountCreationStatus
	 */
	@PostMapping("/createAccount/{customerId}")
	public AccountCreationStatus createAccount(@RequestHeader("Authorization") String token,
			@PathVariable String customerId, @RequestBody Account account);

	/**
	 * @param token
	 * @param customerId
	 * @return List<Account>
	 */
	@GetMapping("/getAccounts/{customerId}")
	public List<Account> getCustomerAccount(@RequestHeader("Authorization") String token,
			@PathVariable String customerId);

}
