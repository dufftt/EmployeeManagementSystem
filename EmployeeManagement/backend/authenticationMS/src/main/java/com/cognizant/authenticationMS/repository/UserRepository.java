package com.cognizant.authenticationMS.repository;

import com.cognizant.authenticationMS.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {

}