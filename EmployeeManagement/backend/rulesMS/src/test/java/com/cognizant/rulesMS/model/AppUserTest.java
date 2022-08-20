package com.cognizant.rulesMS.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;




class AppUserTest {
	
AppUser accInp=new AppUser();
	
	@Test
	void setAccountIdTest() {
		accInp.setUsername("eldon");;
		assertEquals("eldon", accInp.getUsername());
	}
	
	@Test
	void setAmountTest() {
		accInp.setUserid("emp");
		assertEquals("emp", accInp.getUserid());
	}
}