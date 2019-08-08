package com.bank.springApp.Filter;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class jwtFilter extends GenericFilter{
	
	private static final long serialVersionUID = 1L;
	@Value("${JWT_KEY}")
	private String secretkey;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 final HttpServletRequest request = (HttpServletRequest) req;
		    final HttpServletResponse response = (HttpServletResponse) res;
		    final String authHeader = request.getHeader("authorization");

		    if ("OPTIONS".equals(request.getMethod())) {
		        response.setStatus(HttpServletResponse.SC_OK);
		        
		        chain.doFilter(req, res);
		    } else {

		        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
		            throw new ServletException("Missing or invalid Authorization header");
		        }

		        final String token = authHeader.substring(7);

		        try {
		        	 String val = System.getenv("JWT_KEY"); 
		        	 System.out.println(secretkey);
		        	 
			            final Claims claims = Jwts.parser().setSigningKey(val).parseClaimsJws(token).getBody();
		            request.setAttribute("claims", claims);
		        } catch (final SignatureException e) {
		            throw new ServletException("Invalid token");
		        }
		        

		        chain.doFilter(req, res);
		    }
		
	}

}
