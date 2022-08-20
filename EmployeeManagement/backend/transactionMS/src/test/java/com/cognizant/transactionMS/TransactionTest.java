package com.cognizant.transactionMS;

import com.cognizant.transactionMS.models.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

	Transaction transaction = new Transaction();;

	@Test
	void setIdTest() {
		transaction.setId(1);
		assertEquals(1, transaction.getId());
	}

	@Test
	void setSourceAccountIdTest() {
		transaction.setSourceAccountId(1);
		assertEquals(1, transaction.getSourceAccountId());
	}

	@Test
	void setTargetOwnerNameTest() {
		transaction.setTargetOwnerName("Eldon");
		assertEquals("Eldon", transaction.getTargetOwnerName());
	}

	@Test
	void setTargetAccountIdTest() {
		transaction.setTargetAccountId(1);
		;
		assertEquals(1, transaction.getTargetAccountId());
	}

	@Test
	void setAmountTest() {
		transaction.setAmount(1000);
		assertEquals(1000, transaction.getAmount());
	}

	@Test
	void setReferenceTest() {
		transaction.setReference("Deposit");
		assertEquals("Deposit", transaction.getReference());
	}

	@Test
	void setInitiationDateTest() {
		transaction.setInitiationDate(null);
		assertEquals(null, transaction.getInitiationDate());
	}

}
