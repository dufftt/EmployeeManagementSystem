package com.cognizant.rulesMS.service;

import com.cognizant.rulesMS.exception.AccessDeniedException;
import com.cognizant.rulesMS.feign.AuthorizationFeign;
import com.cognizant.rulesMS.model.AuthenticationResponse;
import com.cognizant.rulesMS.model.RulesInput;
import com.cognizant.rulesMS.model.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RulesServiceImpl implements RulesService {
	
	@Autowired
	AuthorizationFeign authorizationFeign;

	 
	@Override
	public boolean evaluate(RulesInput account) {
		int min=1000;
	  //if balance should higher than minimum balance
		double check = account.getCurrentBalance() - account.getAmount();
	    	if(check >= min)
	    		return true;
	    	else
	    		return false;
	}
	
	@Override
	public AuthenticationResponse hasPermission(String token) {
		//validating token
		AuthenticationResponse validity = authorizationFeign.getValidity(token);
		if (!authorizationFeign.getRole(validity.getUserid()).equals("EMPLOYEE"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}

	@Override
	public ServiceResponse serviceCharges(RulesInput account) {
		ServiceResponse response=new ServiceResponse();
		response.setAccountId(account.getAccountId());
		//checking balance
		if(account.getCurrentBalance()<1000)
		{
			//if balance is lesser then minimum balance 10% detected from minimum balance
			double detected=account.getCurrentBalance()/10;
			response.setMessage("Your Balance is lesser than the minimum balance so "+detected+" is detected from your account");
			response.setBalance(account.getCurrentBalance()- detected);
		}
		else
		{
			//if minimum balance is maintained no detection occurred
			response.setMessage("No Detection");
			response.setBalance(account.getCurrentBalance());
		}
		return response;
	}


	
}
