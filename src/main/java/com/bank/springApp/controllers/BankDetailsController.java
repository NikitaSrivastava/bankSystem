package com.bank.springApp.controllers;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.springApp.model.UserDetails;
import com.bank.springApp.service.BankDetailsService;
import com.bank.springApp.service.UserService;
import com.bank.springApp.model.APIResponse;
import com.bank.springApp.model.Bank_branches;

@RestController
public class BankDetailsController {
	@Autowired
	private BankDetailsService bankDetailsService;
 @Autowired
	private UserService userService;
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserDetails user)  {
		
        try {
			return APIResponse.renderSuccess(userService.generateAuthToken(user));
		} catch (ServletException e) {
			return APIResponse.renderError(false, "login error", HttpStatus.UNAUTHORIZED);
		}
		
		
	}
	
	@GetMapping("/secure/bankDetails")
	public ResponseEntity<Bank_branches> getBankDetails(@RequestParam  String ifsc,@RequestParam(value = "offset",required= false,defaultValue = "0") Integer
			offset, @RequestParam(value = "limit",required= false,defaultValue = "10") Integer limit) {
		return APIResponse.renderSuccess(bankDetailsService.getBankDetailsFromIfsc(ifsc));

	}

	@GetMapping("/secure/bankDetailsFromCityAndName")
	public ResponseEntity<Bank_branches> getBankDetailsFromCityAndName(@RequestParam  String name
			,@RequestParam String city,@RequestParam(value = "offset",required= false,defaultValue = "0") Integer
			offset,@RequestParam(value = "limit",required= false,defaultValue = "10") Integer limit ) {
		return APIResponse.renderSuccess(bankDetailsService.getBankDetailsFromCityAndName(name, city,offset,limit));

	}

}
