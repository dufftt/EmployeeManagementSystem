package com.cognizant.customerMS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.customerMS.model.CustomerEntity;



@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {

	
}

