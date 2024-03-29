package com.cognizant.authenticationMS.service;

import com.cognizant.authenticationMS.exceptionhandling.AppUserNotFoundException;
import com.cognizant.authenticationMS.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class LoginService {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private CustomerDetailsService customerDetailservice;

	/**
	 * @param appuser
	 * @return AppUser
	 * @throws AppUserNotFoundException
	 */
	public AppUser userLogin(AppUser appuser) throws AppUserNotFoundException {
		final UserDetails userdetails = customerDetailservice.loadUserByUsername(appuser.getUserid());
		String userid = "";
		String role="";
		String token = "";
		
		log.info("LOGGING IN WITH USERNAME AND PASSWORD");

		if (userdetails.getPassword().equals(appuser.getPassword()) ) {
			userid = appuser.getUserid();
			token = jwtutil.generateToken(userdetails);
			role = appuser.getRole();
			return new AppUser(userid, null, null, token,role);
		} else {
			throw new AppUserNotFoundException("Username/Password is incorrect...Please check");
		}
	}
}