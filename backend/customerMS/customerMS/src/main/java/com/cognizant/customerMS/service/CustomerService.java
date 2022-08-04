package com.cognizant.customerMS.service;


import com.cognizant.customerMS.model.CustomerEntity;
import com.cognizant.customerMS.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepo;


    public CustomerEntity createCustomer(CustomerEntity customer){

        CustomerEntity checkCustomerExists = getCustomerDetail( customer.getUserid());


        //TODO create account for customer using account microservice and attach to customer entity
        customerRepo.save(customer);
        System.out.println("Customer is saved "+customer);
        return customer;

    }

    public CustomerEntity getCustomerDetail(String id){

        Optional<CustomerEntity> customer = customerRepo.findById(id);
        if(!customer.isPresent()){
            return null;
        }
        //TODO get account from account microservice and set it to customer

        return customer.get();
    }

    public boolean deleteCustomer(String id){
        CustomerEntity customer = customerRepo.findById(id).get();
        if(customer!=null){
            customerRepo.deleteById(id);
        }
        else{
            return false;
        }
        return true;
    }

    public CustomerEntity saveCustomer(CustomerEntity customer){

        //TODO UPDATE LOGIN INFO
        return customerRepo.save(customer);
    }

    public CustomerEntity updateCustomer(CustomerEntity customer){
        CustomerEntity toUpdate = customerRepo.findById(customer.getUserid()).get();
        toUpdate.setAccounts(customer.getAccounts());
        //TODO SET account here
        return customerRepo.save(toUpdate);

    }

}
