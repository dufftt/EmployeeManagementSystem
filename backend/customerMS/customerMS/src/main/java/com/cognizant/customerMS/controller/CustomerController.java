package com.cognizant.customerMS.controller;


import com.cognizant.customerMS.model.CustomerEntity;
import com.cognizant.customerMS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.BindException;
import java.time.DateTimeException;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;




    @PostMapping("/createCustomer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerEntity customer) {
        //TODO check for employee only access
        CustomerEntity customerEntity = customerService.createCustomer( customer);
        if (customerEntity != null)
            return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Customer Creation is UNSUCCESSFUL", HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/saveCustomer")
    public CustomerEntity saveCustomer(@RequestBody CustomerEntity customer) {
        //TODO check for employee only access
        CustomerEntity customerEntity = customerService.saveCustomer( customer);
        if (customerEntity != null)
            return customerEntity;
        else
            return null;
    }

    @PostMapping("/updateCustomer")
    public CustomerEntity updateCustomer(@RequestBody CustomerEntity customer) {
        //TODO check for employee only access
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/getCustomerDetails/{id}")
    public ResponseEntity<?> getCustomerDetails(@PathVariable String id) {
        //TODO check for access
        CustomerEntity toReturnCustomerDetails = customerService.getCustomerDetail( id);
        if (toReturnCustomerDetails == null)
            return new ResponseEntity<>("Customer Userid " + id + " DOES NOT EXISTS", HttpStatus.NOT_ACCEPTABLE);
        toReturnCustomerDetails.setPassword(null);
        return new ResponseEntity<>(toReturnCustomerDetails, HttpStatus.OK);
    }

  //TODO delete mapping
}
