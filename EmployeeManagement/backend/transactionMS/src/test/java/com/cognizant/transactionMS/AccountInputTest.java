package com.cognizant.transactionMS;

import com.cognizant.transactionMS.util.AccountInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountInputTest {

	AccountInput accInp = new AccountInput();
	AccountInput accInp1 = new AccountInput(1, 100);

	@Test
	void setAccountIdTest() {
		accInp.setAccountId(1);
		assertEquals(1, accInp.getAccountId());
	}

	@Test
	void setAmountTest() {
		accInp.setAmount(500);
		assertEquals(500, accInp.getAmount());
	}

	@Test
	void getAccountIdTest() {
		accInp.setAccountId(1);
		assertTrue(accInp.getAccountId() == 1);
	}

	@Test
	void getAmountTest() {
		accInp.setAmount(500);
		assertTrue(accInp.getAmount() == 500);
	}

}
