package com.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.data.domain.User;
import com.data.repository.UserRepository;
import com.data.service.UserService;
import com.data.vo.AddUser;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	public String addUser(AddUser addUser) throws Exception {
		User user = new User();
		if(null != addUser) {
			user.setUsername(addUser.getUserName());
			user.setPassword(addUser.getPassword());
		}
		
		try {
			userRepository.save(user);
		} catch (DataAccessException dae) {
			log.info("Data Access Exception happen at the time of Data Save in DB: {} {}", dae.getCause(), dae.getMessage());
			throw new Exception(dae.getMessage());
		} catch (Exception e) {
			log.info("Exception in saveing user Data: {}", e.getMessage());
			throw new Exception(e.getMessage());
		}
		return "SUCCESS";
	}
	
	public List<User> getAllUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		try {
			users = userRepository.findAll();
			if(users.isEmpty()) {
				log.info("User not found");
				throw new Exception("No Users are available");
			}
		} catch (Exception e) {
			log.error("Error while fetching user data: {}", e.getCause());
			throw new Exception(e.getMessage());
		}
		return users;
	}
}
