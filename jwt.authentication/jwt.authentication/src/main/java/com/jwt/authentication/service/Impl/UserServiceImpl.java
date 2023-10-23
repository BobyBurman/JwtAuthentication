package com.jwt.authentication.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.authentication.model.User;
import com.jwt.authentication.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	List<User> users=new ArrayList<User>();
	

	public UserServiceImpl() {
		super();
		
		users.add(new User(UUID.randomUUID().toString(),"Ramesh Shaw1","ramesh1@gmail.com"));
		users.add(new User(UUID.randomUUID().toString(),"Ramesh Shaw2","ramesh2@gmail.com"));
		users.add(new User(UUID.randomUUID().toString(),"Ramesh Shaw3","ramesh3@gmail.com"));
		users.add(new User(UUID.randomUUID().toString(),"Ramesh Shaw4","ramesh4@gmail.com"));
		users.add(new User(UUID.randomUUID().toString(),"Ramesh Shaw5","ramesh5@gmail.com"));
		users.add(new User(UUID.randomUUID().toString(),"Ramesh Shaw6","ramesh6@gmail.com"));	
	}

	@Override
	public List<User> getAllUser() {
		return users;
	}

}
