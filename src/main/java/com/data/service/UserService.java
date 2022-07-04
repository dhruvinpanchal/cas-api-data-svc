package com.data.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.data.domain.User;
import com.data.vo.AddUser;

@Configuration
public interface UserService {
	
	public String addUser(AddUser addUser) throws Exception;
	
	public List<User> getAllUsers() throws Exception;
	
}
