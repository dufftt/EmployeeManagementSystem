package com.cognizant.customerMS;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerMsApplicationTests {

	@Test
	void contextLoads() {
		String check="Cust101";
		assertEquals("Cust101",check );
	}

}
