package com.jwt.authentication.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.authentication.security.JwtAuthenticationEntryPoint;
import com.jwt.authentication.security.JwtAuthenticationFilter;

@Configuration
public class JwtConfig {
	
	@Autowired
    private JwtAuthenticationEntryPoint point;
	
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	//configuration
    	http.csrf(csrf->csrf.disable())
    	.cors(cors->cors.disable())
    	.authorizeHttpRequests(auth->auth.requestMatchers("/test/**").authenticated()
    			.requestMatchers("auth/login").permitAll()
    			.anyRequest().authenticated())
    	        .exceptionHandling(ex->ex.authenticationEntryPoint(point))
    	        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    	
    	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
    	
    	return http.build();
       
    }


}
