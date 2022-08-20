package com.cognizant.authenticationMS.service;

import com.cognizant.authenticationMS.model.AuthenticationResponse;
import com.cognizant.authenticationMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Validationservice {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private UserRepository userRepo;

	/**
	 * @param token
	 * @return authenticationResponse
	 */
	public AuthenticationResponse validate(String token) {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();

		String jwt = token.substring(7);

		if (jwtutil.validateToken(jwt)) {
			authenticationResponse.setUserid(jwtutil.extractUsername(jwt));
			authenticationResponse.setValid(true);
			authenticationResponse.setName(userRepo.findById(jwtutil.extractUsername(jwt)).get().getUsername());
		} else {
			authenticationResponse.setValid(false);
		}
		return authenticationResponse;
	}
}