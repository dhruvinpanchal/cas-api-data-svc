package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
