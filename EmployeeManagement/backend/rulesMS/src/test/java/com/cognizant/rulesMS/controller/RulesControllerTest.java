package com.cognizant.rulesMS.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cognizant.rulesMS.exception.MinimumBalanceException;
import com.cognizant.rulesMS.feign.AccountFeign;
import com.cognizant.rulesMS.feign.AuthorizationFeign;
import com.cognizant.rulesMS.model.Account;
import com.cognizant.rulesMS.model.AuthenticationResponse;
import com.cognizant.rulesMS.model.RulesInput;
import com.cognizant.rulesMS.model.ServiceResponse;
import com.cognizant.rulesMS.service.RulesServiceImpl;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RulesController.class)
@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class})
class RulesControllerTest {

		@Autowired
		MockMvc mockMvc;

		@MockBean
		AuthorizationFeign authProxy;
		
		@MockBean
		RulesServiceImpl rulesService;
		
		@Mock
		AccountFeign accountFeign;

		@Test
		void evaluateTest() throws Exception {
			//Evaluate method is checked
			when(rulesService.hasPermission("token")).thenReturn(new AuthenticationResponse("Employee101", "emp", true));
			RulesInput inp=new RulesInput(101,1200,100);
			when(rulesService.evaluate(inp)).thenReturn(true);
			mockMvc.perform(
					MockMvcRequestBuilders.post("/evaluateMinBal").content(asJsonString(inp))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
					).andExpect(status().isOk());
		   
			
		}
		

		@Test
		void evaluateTestEqual() throws Exception {
			//Evaluate method is checked when amount and current balance is same
			when(rulesService.hasPermission("token")).thenReturn(new AuthenticationResponse("Employee101", "emp", true));
			RulesInput inp=new RulesInput(101,100,100);
			when(rulesService.evaluate(inp)).thenReturn(true);
			mockMvc.perform(
					MockMvcRequestBuilders.post("/evaluateMinBal").content(asJsonString(inp))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
					).andExpect(status().isOk());
		   
			
		}
	
		@Test
		void evaluateTestNeg() throws Exception {
			when(rulesService.hasPermission("token")).thenReturn(new AuthenticationResponse("Employee101", "emp", true));
			RulesInput inp=new RulesInput(101,200,100);
			when(rulesService.evaluate(inp)).thenReturn(false);
			mockMvc.perform(
					MockMvcRequestBuilders.post("/evaluateMinBal").content(asJsonString(inp))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
					).andExpect(status().isOk());
			
	
		}
		
		
		
		@Test
		void serviceChargesTest() throws Exception {
			//Service Charges method with no detection criteria
			when(rulesService.hasPermission("token")).thenReturn(new AuthenticationResponse("Employee101", "emp", true));
			RulesInput inp=new RulesInput(101,1200,100);
			ServiceResponse res= new ServiceResponse("No Detection",101,(double) 100);
			when(rulesService.serviceCharges(inp)).thenReturn(res);
			mockMvc.perform(
					MockMvcRequestBuilders.post("/serviceCharges").content(asJsonString(inp))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token"))
					;
			
		}
		
		@Test
		void serviceChargesTestNegative() throws Exception {
			//Service Charges method with not passes same argument
			when(rulesService.hasPermission("token")).thenReturn(new AuthenticationResponse("Employee101", "emp", true));
			when(accountFeign.getAllacc("token")).thenReturn(new ResponseEntity<List<Account>>(new ArrayList<>(),HttpStatus.OK));
			mockMvc.perform(
					MockMvcRequestBuilders.post("/serviceCharges").header("Authorization", "token")
					).andExpect(status().is(500));
			verify(rulesService,timeout(1)).hasPermission("token");
			
		}
	

		@Test
		public void MinimumBal() throws MinimumBalanceException,Exception {
			//Webrequest
			//GlobalExceptionHandler handler = new GlobalExceptionHandler();
			RulesController con=new RulesController();
			RulesInput account=new RulesInput(0,0,0);
			 Throwable exception = assertThrows(MinimumBalanceException.class, () -> con.evaluate(account));
			    assertEquals("Send Valid Details.", exception.getMessage());
			

			
		}
		

		
		
		//reading and writing json content
		/**
		 * @param obj
		 * @return String
		 * @throws JsonProcessingException
		 */
		public static String asJsonString(final Object obj) throws JsonProcessingException {
			
				final ObjectMapper mapper = new ObjectMapper();
				final String jsonContent = mapper.writeValueAsString(obj);
				return jsonContent;
			
		}
		
}