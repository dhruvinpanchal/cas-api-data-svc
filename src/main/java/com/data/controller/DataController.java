package com.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.domain.User;
import com.data.repository.UserRepository;
import com.data.vo.AddUser;

@RestController
public class DataController {
	
	@Autowired
	private UserRepository userRepository;
	
	private static Logger log = LoggerFactory.getLogger(DataController.class);
	
	@PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@RequestBody AddUser addUser) throws Exception {
		log.info("Inside Adduser Method : {}", addUser.getUserName());
		User user = new User();
		user.setUsername(addUser.getUserName());
		user.setPassword(addUser.getPassword());
		try {
			userRepository.save(user);
		} catch (Exception e) {
			log.error("Exception occure in saving the data: {}", e.getMessage());
			throw new Exception(e.getCause());
		}
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUser() throws Exception {
		log.info("Inside getting all user");
		List<User> users = new ArrayList<User>();
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			log.error("Unable to fetch data of user: {}", e.getMessage());
			throw new Exception(e.getCause());
			// TODO: handle exception
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}