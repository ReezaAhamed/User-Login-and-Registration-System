package com.reeza.userregistration.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.reeza.userregistration.applicationuser.ApplicationUserService;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final ApplicationUserService appUserService;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
				.authorizeRequests()
					.antMatchers("api/v*/registration/**")
					.permitAll() //we permit all request through the above mentioned enpoint
				.anyRequest()
				.authenticated().and() // requests must be authenticated
				.formLogin(); // we need to use form login, that's why
		
		http.csrf().disable(); //temperarily!, otherwise post requests won't work. Will be enabled when we use forms
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bcryptPasswordEncoder);
		provider.setUserDetailsService(appUserService);
		
		return provider;
		
	}

}
