package com.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user", schema = "user_schema")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userId_generator")
	@SequenceGenerator(name = "userId_generator", sequenceName = "user_schema.user_id_seq", allocationSize = 1)
	private Integer id;
	
	private String username;
	private String password;
}
