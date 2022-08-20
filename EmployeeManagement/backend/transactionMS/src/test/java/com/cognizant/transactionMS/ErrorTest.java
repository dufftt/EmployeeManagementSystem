package com.cognizant.transactionMS;

import com.cognizant.transactionMS.models.ErrorDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ErrorTest {

	ErrorDetails accInp = new ErrorDetails();
	ErrorDetails accInp2 = new ErrorDetails("hi", "hi");

	@Test
	void setAccountIdTest() {
		accInp.setDetails("abc");
		assertEquals("abc", accInp.getDetails());
	}

	@Test
	void setAmountTest() {
		accInp.setMessage("abc");
		assertEquals("abc", accInp.getMessage());
	}

	@Test
	void getAccountIdTest() {
		accInp.setDetails("abc");
		assertTrue(accInp.getDetails() == "abc");
	}

	@Test
	void getAmountTest() {
		accInp.setMessage("abc");
		assertTrue(accInp.getMessage() == "abc");
	}

}