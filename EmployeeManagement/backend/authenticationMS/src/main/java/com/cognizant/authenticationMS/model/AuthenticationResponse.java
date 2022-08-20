package com.cognizant.authenticationMS.model;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
	private String userid;
	private String name;
	private boolean isValid;
}