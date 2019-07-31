package com.bank.springApp.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class jwtFilter extends GenericFilter{

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
		            final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
		            request.setAttribute("claims", claims);
		        } catch (final SignatureException e) {
		            throw new ServletException("Invalid token");
		        }

		        chain.doFilter(req, res);
		    }
		
	}

}
