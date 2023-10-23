package com.jwt.authentication.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.model.User;
import com.jwt.authentication.service.UserService;

@RestController
@RequestMapping("/test")
public class Controller {
	
	@Autowired
	private UserService userService;
	
	Logger logger=LoggerFactory.getLogger(Controller.class);
	
	//http://localhost:8080/test/users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		this.logger.warn("Entering inside UserService");
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}
	
	//http://localhost:8080/test/current-user
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	

}
