package com.cognizant.accountMS.controller;

import com.cognizant.accountMS.feignclient.AuthFeignClient;
import com.cognizant.accountMS.feignclient.TransactionFeign;
import com.cognizant.accountMS.model.Account;
import com.cognizant.accountMS.model.AccountCreationStatus;
import com.cognizant.accountMS.model.AccountInput;
import com.cognizant.accountMS.model.AuthenticationResponse;
import com.cognizant.accountMS.repository.AccountRepository;
import com.cognizant.accountMS.service.AccountServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthFeignClient authFeign;

	@MockBean
	private AccountServiceImpl accountServiceImpl;

	@MockBean
	private AccountRepository accountRepository;

	@MockBean
	private TransactionFeign transactionFeign;
	

	@Test
	void getAccountTest() throws Exception {
		when(accountServiceImpl.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		Account acc = new Account();
		when(accountServiceImpl.getAccount(1)).thenReturn(acc);
		mockMvc.perform(get("/getAccount/1").header("Authorization", "token")).andExpect(status().isOk());
		verify(accountServiceImpl, timeout(1)).getAccount(1);
	}

	@Test
	void getCustomerAccountTest() throws Exception {
		when(accountServiceImpl.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		when(accountServiceImpl.getCustomerAccount("token", "cust01")).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/getAccounts/cust01").header("Authorization", "token")).andExpect(status().isOk());
		verify(accountServiceImpl, timeout(1)).getCustomerAccount("token", "cust01");
	}

	@Test
	void createAccountTest() throws Exception {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/09/2021");
		when(accountServiceImpl.hasEmployeePermission("token")).thenReturn(new AuthenticationResponse("emp01", "emp", true));
		Account account = new Account(1l, "cust01", 3000.0, "Savings", date, "Pulkit", null);
		when(accountServiceImpl.createAccount("Cust101", account)).thenReturn(new AccountCreationStatus(1, "Sucessfully Created"));
		mockMvc.perform(MockMvcRequestBuilders
		.post("/createAccount/cust01")
		.content(asJsonString(account))
		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
		.header("Authorization", "token")).andExpect(status().isNotAcceptable());
		verify(accountServiceImpl, timeout(1)).hasEmployeePermission("token");
	}

	@Test
	void checkAccountBalanceTest() throws Exception {
		when(accountServiceImpl.hasPermission("token")).thenReturn(new AuthenticationResponse("cust01", "cust", true));
		AccountInput accountIp = new AccountInput();
		Account account = new Account();
		when(accountServiceImpl.getAccount(accountIp.getAccountId())).thenReturn(account);
		mockMvc.perform(MockMvcRequestBuilders.post("/checkBalance")
		.content(asJsonString(accountIp))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.header("Authorization", "token")).andExpect(status().isOk());
		verify(accountServiceImpl, timeout(1)).hasPermission("token");
	}
	
	@Test
	void  getAllAccountTest() throws Exception  {
		when(accountServiceImpl.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		when(accountServiceImpl.getAllAccounts()).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/find").header("Authorization", "token")).andExpect(status().isOk());
		verify(accountServiceImpl, timeout(1)).getAllAccounts();
	}


	// converting object to string
	/**
	 * @param obj
	 * @return String
	 */
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
}
