package com.cognizant.customerMS.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AccountStatusTest {
	AccountCreationStatus account = new AccountCreationStatus();
	AccountCreationStatus account2 = new AccountCreationStatus(111,"Successfully created");
	

	@Test
	void setAccTest() {
		account.setAccountId(1);
		assertEquals(1, account.getAccountId());
	}

	@Test
	void setMsgTest() {
		account.setMessage("msg");
		assertEquals("msg", account.getMessage());
	}

	@Test
	void getMessageTest() {
		account.setMessage("msg");
		assertEquals("msg", account.getMessage());
	}

	@Test
	void getAccTest() {
		account.setAccountId(1);
		assertEquals(1, account.getAccountId());
	}
	
	

}
