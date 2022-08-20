package com.cognizant.rulesMS.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ErrorDetailsTest {
	
	ErrorDetails det=new ErrorDetails();
	
	@Test
	void setUserIdTest() {
		det.setDetails("/notresponding");
		assertEquals("/notresponding", det.getDetails());
	}
	
	@Test
	void setNameTest() {
		det.setMessage("prasad");
		assertEquals("prasad", det.getMessage());
	}
}
