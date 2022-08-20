package com.cognizant.accountMS.repository;

import com.cognizant.accountMS.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	/**
	 *  Class used Account Repository
	 */
	
	/*
	 *  method to get account from database
	 */
	/**
	 * @param accountId
	 * @return Account
	 */
	@Query(nativeQuery = true, value = "SELECT * from account a WHERE a.account_Id = :accountId")
	Account findByAccountId(@Param(value = "accountId") long accountId);

	
	/*
	 *  method to find customer from database
	 */
	/**
	 * @param customerId
	 * @return List<Account>
	 */
	List<Account> findByCustomerId(String customerId);

}
