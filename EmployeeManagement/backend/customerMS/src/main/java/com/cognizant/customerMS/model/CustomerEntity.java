package com.cognizant.customerMS.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {
	@Id
	@Column(name = "userid", length = 15,unique=true)
	@Pattern(regexp = "^[A-Za-z0-9_-]*$")
	private String userid;
	
	@Column(name = "username", length = 20)
	@NotBlank
	private String username;
	
	@Column(name = "password")
	@NotBlank
	private String password;
	
	@Column(name = "dateOfBirth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth; 
	
	@Pattern(regexp = "^[A-Z]{5}+[0-9]{4}+[A-Z]{1}$")
	@Column(name = "pan", length = 10)
	@NotBlank
	private String pan;
	
	
	@Column(name = "address")
	@NotBlank
	private String address;
	

	@Transient
	private List<Account> accounts = new ArrayList<>();
	
}
