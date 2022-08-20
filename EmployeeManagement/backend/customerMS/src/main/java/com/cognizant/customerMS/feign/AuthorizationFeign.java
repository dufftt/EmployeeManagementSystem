package com.cognizant.customerMS.feign;

import com.cognizant.customerMS.model.AppUser;
import com.cognizant.customerMS.model.AuthenticationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "auth-service", url = "${feign.url-auth-service}")
@Component
public interface AuthorizationFeign {

	// Create Consumer
	/**
	 * @param appUserCredentials
	 * @return ResponseEntity<?>
	 */
	@PostMapping(value = "/createUser")
	public ResponseEntity<?> createUser(@RequestBody AppUser appUserCredentials);

	// Customer login
	/**
	 * @param appUserloginCredentials
	 * @return ResponseEntity<?>
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AppUser appUserloginCredentials);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	@GetMapping(value = "/validateToken")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);

	/**
	 * @param id
	 * @return String
	 */
	@GetMapping("/role/{id}")
	public String getRole(@PathVariable("id") String id);

}
