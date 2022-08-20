package com.cognizant.customerservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerInput {


    @Pattern(regexp = "^[A-Za-z0-9_-]*$")
    private String userid;


    private String username;


    private String password;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;


    @Pattern(regexp = "^[A-Z]{5}+[0-9]{4}+[A-Z]{1}$")
    private String pan;


    private String address;


    private String ownerName;
}
