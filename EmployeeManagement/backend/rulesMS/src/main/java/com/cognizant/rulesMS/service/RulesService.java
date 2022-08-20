package com.cognizant.rulesMS.service;

import com.cognizant.rulesMS.model.AuthenticationResponse;
import com.cognizant.rulesMS.model.RulesInput;
import com.cognizant.rulesMS.model.ServiceResponse;


public interface RulesService {
	
	/**
	 * @param account
	 * @return boolean
	 */
	public boolean evaluate(RulesInput account);
	
	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasPermission(String token);
	
	/**
	 * @param account
	 * @return ServiceResponse
	 */
	public ServiceResponse serviceCharges(RulesInput account);
	
}
