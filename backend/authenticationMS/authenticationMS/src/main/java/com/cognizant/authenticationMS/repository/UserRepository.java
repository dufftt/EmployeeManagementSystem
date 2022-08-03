package com.cognizant.authenticationMS.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationMS.model.AppUser;



@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
}
