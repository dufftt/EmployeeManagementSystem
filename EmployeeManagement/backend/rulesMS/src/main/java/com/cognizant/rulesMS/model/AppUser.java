package com.cognizant.rulesMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//create or login the customer
public class AppUser {
	
	@Id
	@Column(name = "userid", length = 20)
	private String userid;
	
	@Column(name = "username", length = 20)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	private String authToken;
	
	private String role;
}