package com.bank.springApp.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.bank.springApp.Filter.*; 
@Configuration
public class JwtConig{
  
	@Bean
	public FilterRegistrationBean<jwtFilter> jwtFilter() {
		final FilterRegistrationBean<jwtFilter> registrationBean = new FilterRegistrationBean<jwtFilter>();
		registrationBean.setFilter(new com.bank.springApp.Filter.jwtFilter());
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
	}
}
