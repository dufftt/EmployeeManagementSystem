package com.cognizant.customerMS.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {
	
	
	@Id
	@Column(name = "userid", length = 15,unique=true)
	private String userid;
	
	@Column(name = "username", length = 20)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "dateOfBirth")
	private Date dateOfBirth; 
	
	
	@Column(name = "pan", length = 10)
	private String pan;
	
	
	@Column(name = "address")
	private String address;
	


	
}


