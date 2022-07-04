package com.data.controller;

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
import com.data.service.UserService;
import com.data.vo.AddUser;

@RestController
public class DataController {
	
	@Autowired
	private UserService userService;
	
	private static Logger log = LoggerFactory.getLogger(DataController.class);
	
	@PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@RequestBody AddUser addUser) throws Exception {
		log.info("Inside Adduser Method : {}", addUser.getUserName());
		return new ResponseEntity<String>(userService.addUser(addUser), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUser() throws Exception {
		log.info("Inside getting all user");
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
}