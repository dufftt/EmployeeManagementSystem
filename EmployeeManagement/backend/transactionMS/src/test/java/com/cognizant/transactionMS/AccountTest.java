package com.cognizant.transactionMS;

import com.cognizant.transactionMS.models.Account;
import com.cognizant.transactionMS.models.Transaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

	Transaction t = new Transaction();
	List<Transaction> list = new ArrayList<Transaction>();
	Account account = new Account();

	@Test
	void setAccountIdTest() {
		account.setAccountId(1);
		assertEquals(1, account.getAccountId());
	}

	@Test
	void setCustomerIdTest() {
		account.setCustomerId("Cust101");
		assertEquals("Cust101", account.getCustomerId());
	}

	@Test
	void setCurrentBalanceTest() {
		account.setCurrentBalance(5000);
		assertEquals(5000, account.getCurrentBalance());
	}

	@Test
	void setAccountTypeTest() {
		account.setAccountType("Savings");
		assertEquals("Savings", account.getAccountType());
	}

	@Test
	void setOwnerNameTest() {
		account.setOwnerName("James");
		assertEquals("James", account.getOwnerName());
	}

	@Test
	void setTransactionsTest() {
		account.setTransactions(null);
		assertEquals(null, account.getTransactions());
	}

	@Test
	void getAccTest() {
		account.setAccountId(1);
		assertTrue(account.getAccountId() == 1);
	}

	@Test
	void getCustomerTest() {
		account.setCustomerId("1");
		assertTrue(account.getCustomerId() == "1");
	}

	@Test
	void getAcctypeTest() {
		account.setAccountType("Savings");
		assertTrue(account.getAccountType() == "Savings");
	}

	@Test
	void getTokenTest() {
		account.setCurrentBalance(10);
		assertTrue(account.getCurrentBalance() == 10);
	}

	@Test
	void getOwnerTest() {
		account.setOwnerName("James");
		assertTrue(account.getOwnerName() == "James");
	}
}
