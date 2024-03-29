package com.cognizant.customerMS.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomerEntityTest {

	CustomerEntity customer = new CustomerEntity();

	@Test
	void setUserIdTest() {
		customer.setUserid("1");
		assertEquals("1", customer.getUserid());
	}

	@Test
	void setUserNameTest() {
		customer.setUsername("shiva");
		assertEquals("shiva", customer.getUsername());
	}

	@Test
	void setPasswordTest() {
		customer.setPassword("shiva@280");
		assertEquals("shiva@280", customer.getPassword());
	}

	@Test
	void setAddressTest() {
		customer.setAddress("manipal");
		assertEquals("manipal", customer.getAddress());
	}

	@Test
	void setPanTest() {
		customer.setPan("ABCDE1234R");
		assertEquals("ABCDE1234R", customer.getPan());
	}

	@Test
	void setDateTest() {
		Date d = new Date(0);
		customer.setDateOfBirth(d);
		assertEquals(d, customer.getDateOfBirth());
	}

	@Test
	void getAccTest() {
		customer.setUserid("1");
		assertEquals("1", customer.getUserid());
	}

	@Test
	void getUserNameTest() {
		customer.setUsername("sidd");
		assertEquals("sidd", customer.getUsername());
	}

	@Test
	void getPasswordTest() {
		customer.setPassword("sidd@211");
		assertEquals("sidd@211", customer.getPassword());
	}

	@Test
	void getAddressTest() {
		customer.setAddress("Pune");
		assertEquals("Pune", customer.getAddress());
	}

	@Test
	void getPanTest() {
		customer.setPan("abcde1234t");
		assertEquals("abcde1234t", customer.getPan());
	}

	@Test
	void getDateTest() {
		Date d = new Date(0);
		customer.setDateOfBirth(d);
		assertEquals(d, customer.getDateOfBirth());
	}

}
