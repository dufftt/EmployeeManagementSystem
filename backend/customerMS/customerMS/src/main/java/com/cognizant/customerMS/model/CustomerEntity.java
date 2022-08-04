package com.cognizant.customerMS.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;


import lombok.*;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

	@Transient
	private List<Account> accounts = new ArrayList<>();



}


