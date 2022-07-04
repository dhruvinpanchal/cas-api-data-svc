package com.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddUser {

	@JsonProperty(value = "username")
	private String userName;
	
	@JsonProperty(value = "password")
	private String password;
}