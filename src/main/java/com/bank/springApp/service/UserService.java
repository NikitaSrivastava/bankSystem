package com.bank.springApp.service;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bank.springApp.model.UserDetails;
import com.bank.springApp.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Value("${jwt.secretkey}")
	private String secretKey;

	public UserDetails findByUsername(String username){
		return userRepository.findByUsername(username);
	}

	public String generateAuthToken(UserDetails user) throws ServletException {
		String jwtToken = "";

		if (user.getUsername() == null || user.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String username = user.getUsername();
		String password = user.getPassword();

		UserDetails userDetails = findByUsername(username);

		if (userDetails == null) {
			throw new ServletException("User not found.");
		}

		String pwd = userDetails.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		int expirationValidity = 5;
		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+ (expirationValidity *1000*60*60*24)))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();

		return jwtToken;

	}

}
