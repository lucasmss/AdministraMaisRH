package com.administra.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/api/usuarios").permitAll()
				.antMatchers("/api/clientes/**", 
						"/api/servico-prestado/**").authenticated()
				.anyRequest().denyAll();
				
	}
}
