package com.cognizant.accountMS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.accountMS.model.CustomerEntity;




@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {

	
}

