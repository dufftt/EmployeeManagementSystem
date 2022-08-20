package com.cognizant.rulesMS.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



class AuthenticationResponseTest {
	


		AuthenticationResponse response=new AuthenticationResponse();
		AuthenticationResponse response2=new AuthenticationResponse();

		@Test
		void setUserIdTest() {
			response.setUserid("emp101");
			assertEquals("emp101", response.getUserid());
		}
		
		@Test
		void setNameTest() {
			response.setName("eldon");
			assertEquals("eldon", response.getName());
		}
		
		@Test
		void setisValidTest() {
			response.setValid(true);
			assertEquals(true, response.isValid());
		}
		
	}