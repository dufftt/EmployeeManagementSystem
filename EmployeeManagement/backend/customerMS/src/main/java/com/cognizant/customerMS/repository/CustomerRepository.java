package com.cognizant.customerMS.repository;

import com.cognizant.customerMS.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {

}
