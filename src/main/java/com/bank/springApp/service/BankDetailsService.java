package com.bank.springApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.springApp.model.Bank_branches;
import com.bank.springApp.repository.BankDetailsRepository;

@Service
@ComponentScan(basePackages = {"com.bank.repository"})
public class BankDetailsService {
    @Autowired
    BankDetailsRepository bankDetailsRepository;
    
	public Optional<Bank_branches> getBankDetailsFromIfsc(String ifsc) {
		System.out.println(this.bankDetailsRepository.findById(ifsc));
		return this.bankDetailsRepository.findById(ifsc);
	}
	
	public List<Bank_branches>	 getBankDetailsFromCityAndName(String name, String city
			,int start, int end) {
		@SuppressWarnings({ "deprecation", "unused" })
		Pageable page = new PageRequest(start,end);
        return this.bankDetailsRepository.findByCityAndBankName(city, name,page);		
	}

}
