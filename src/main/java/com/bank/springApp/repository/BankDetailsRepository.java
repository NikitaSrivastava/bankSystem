package com.bank.springApp.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.springApp.model.*;
public interface BankDetailsRepository extends JpaRepository<Bank_branches, String> {

//	@Query("SELECT b FROM Bank_branches b  where bank_name = ?1 and city = ?2" )
//    List<Bank_branches> findByCityAndName(@Param("name") String name,
//    		@Param("city") String city);
	
	  List<Bank_branches> findByCityAndBankName(String city,String name,Pageable page);
}
