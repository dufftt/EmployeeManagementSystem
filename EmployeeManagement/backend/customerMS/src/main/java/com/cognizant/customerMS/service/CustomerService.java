package com.cognizant.customerMS.service;

import com.cognizant.customerMS.model.AuthenticationResponse;
import com.cognizant.customerMS.model.CustomerEntity;

//FD

public interface CustomerService {

	/**
	 * @param token
	 * @param customer
	 * @return CustomerEntity
	 */
	public CustomerEntity createCustomer(String token, CustomerEntity customer);

	/**
	 * @param token
	 * @param id
	 * @return CustomerEntity
	 */
	public CustomerEntity getCustomerDetail(String token, String id);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasEmployeePermission(String token);

	/**
	 * @param id
	 * @return boolean
	 */
	public boolean deleteCustomer(String id);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	AuthenticationResponse hasCustomerPermission(String token);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasPermission(String token);

	/**
	 * @param token
	 * @param customer
	 * @return CustomerEntity
	 */
	public CustomerEntity saveCustomer(String token, CustomerEntity customer);

	/**
	 * @param token
	 * @param customer
	 * @return CustomerEntity
	 */
	public CustomerEntity updateCustomer(String token, CustomerEntity customer);

}
