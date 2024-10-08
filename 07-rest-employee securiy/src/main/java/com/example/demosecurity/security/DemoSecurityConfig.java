package com.example.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {
	
	
	@Bean
	
	public UserDetailsManager userDetailsManager(DataSource datasource) {
		JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(datasource);
		
		//define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw,active from members where user_id=?");
		
		//define query to retrieve the authorities/roles by username
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?");
		
		return jdbcUserDetailsManager;
	}

	
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer
		.requestMatchers("/").hasRole("EMPLOYEE")		
		.requestMatchers("/leaders/**").hasRole("MANAGER")
		.requestMatchers("/systems**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()

		).formLogin(form -> form.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				
				
				)
		
		.logout(logout ->logout.permitAll())
		.exceptionHandling(configurer->configurer.accessDeniedPage("/access-denied"))
		;

		
		return http.build();
		
		/*
		 * @Bean public InMemoryUserDetailsManager userDetailsManager() { UserDetails
		 * emre =
		 * User.builder().username("emre").password("{noop}emre123").roles("EMPLOYEE",
		 * "MANAGER").build(); UserDetails enes =
		 * User.builder().username("enes").password("{noop}enes123").roles("EMPLOYEE",
		 * "MANAGER","ADMIN").build(); UserDetails ali =
		 * User.builder().username("ali").password("{noop}ali123").roles("EMPLOYEE").
		 * build(); return new InMemoryUserDetailsManager(enes, emre, ali); }
		 */

	}
}
