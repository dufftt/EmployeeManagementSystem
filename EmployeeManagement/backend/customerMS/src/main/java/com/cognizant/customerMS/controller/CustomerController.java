package com.cognizant.customerMS.controller;

import com.cognizant.customerMS.feign.AuthorizationFeign;
import com.cognizant.customerMS.model.CustomerEntity;
import com.cognizant.customerMS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.time.DateTimeException;


@RestController
public class CustomerController {  // /customer endpoint

	@Autowired
	private CustomerService customerService;  //customer interface

	@Autowired
	AuthorizationFeign authorizationFeign;   //auth feign

	/**
	 * @param token
	 * @param customer
	 * @param bindingResult
	 * @return ResponseEntity<?>
	 * @throws DateTimeException
	 * @throws BindException
	 * @apiNote creates the customer 
	 */
	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCustomer(@RequestHeader("Authorization") String token,@Valid @RequestBody CustomerEntity customer,BindingResult bindingResult) throws DateTimeException, BindException{
		
		//checks if the customer input's are valid 
		if(bindingResult.hasErrors())
		{
			throw new BindException(); 
		}
		
		//function to check if employee is valid to create a customer
		customerService.hasEmployeePermission(token);
		
		//create customer service from customer service class
		CustomerEntity customerEntity = customerService.createCustomer(token,customer);
		if (customerEntity != null)
			return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Customer Creation is UNSUCCESSFUL", HttpStatus.NOT_ACCEPTABLE);
	}
	
	/**
	 * @param token
	 * @param customer
	 * @return CustomerEntity
	 * @apiNote Save customer into the database
	 */
	@PostMapping("/saveCustomer")
	public CustomerEntity saveCustomer(@RequestHeader("Authorization") String token,@Valid @RequestBody CustomerEntity customer) {
		customerService.hasEmployeePermission(token);
		CustomerEntity customerEntity = customerService.saveCustomer(token,customer);
		if (customerEntity != null)
			return customerEntity;
		else
			return null;
	}
	
	/**
	 * @param token
	 * @param customer
	 * @return CustomerEntity
	 */ 
	@PostMapping("/updateCustomer")
	public CustomerEntity updateCustomer(@RequestHeader("Authorization") String token,@Valid @RequestBody CustomerEntity customer) {
		customerService.hasEmployeePermission(token);
		return customerService.updateCustomer(token,customer);
	}
	 
	/**
	 * @param token
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/getCustomerDetails/{id}")
	public ResponseEntity<?> getCustomerDetails(@RequestHeader("Authorization") String token, @PathVariable String id) {
		customerService.hasPermission(token);
		CustomerEntity toReturnCustomerDetails = customerService.getCustomerDetail(token,id);
		if (toReturnCustomerDetails == null)
			return new ResponseEntity<>("Customer Userid "+id+" DOES NOT EXISTS", HttpStatus.NOT_ACCEPTABLE);
		toReturnCustomerDetails.setPassword(null);
		return new ResponseEntity<>(toReturnCustomerDetails, HttpStatus.OK);
	}

	/**
	 * @param token
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@DeleteMapping("deleteCustomer/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> deleteCustomer(@RequestHeader("Authorization") String token, @PathVariable String id) {

		customerService.hasEmployeePermission(token);

		CustomerEntity checkCustomerIdExists = null;
		checkCustomerIdExists = customerService.getCustomerDetail(token , id);
		if (checkCustomerIdExists == null) {
			return new ResponseEntity<>("Customer Userid DOES NOT EXISTS", HttpStatus.NOT_ACCEPTABLE);
		}

		
		customerService.deleteCustomer(id);
		System.out.println("Deleted");
		return new ResponseEntity<>("Deleted SUCCESSFULLY", HttpStatus.OK);
	}

	/**
	 * @param token
	 * @return String
	 */
	@GetMapping("/check") 
	public String checkAccessWWithoutValidation(@RequestHeader("Authorization") String token) {
		customerService.hasEmployeePermission(token);
		return "Your Token is valid";
	}
	

}
