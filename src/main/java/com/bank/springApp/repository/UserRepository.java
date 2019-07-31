package com.bank.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.springApp.model.Bank_branches;
import com.bank.springApp.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, String>  {
	UserDetails findByUsername(String username);

}
