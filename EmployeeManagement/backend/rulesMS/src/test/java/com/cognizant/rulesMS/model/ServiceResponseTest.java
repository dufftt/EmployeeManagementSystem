package com.cognizant.rulesMS.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ServiceResponseTest {
	
   ServiceResponse res=new ServiceResponse();
   @Test
	void setAccountIdTest() {
		res.setAccountId(1);
		assertEquals(1, res.getAccountId());
	}
	
	@Test
	void setAmountTest() {
		res.setMessage("abcd");
		assertEquals("abcd", res.getMessage());
	}
    
}
