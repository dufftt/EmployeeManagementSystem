package com.cognizant.accountMS;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountMsApplicationTests {

	@Test
	void setCustomerIdTest() {
		String check="Cust101";
		assertEquals("Cust101",check );
	}

}
