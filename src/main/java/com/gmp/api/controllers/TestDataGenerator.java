package com.gmp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmp.api.models.User;
import com.gmp.api.services.UserService;

@RestController
public class TestDataGenerator {
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/users")
	public List<User> generateDummyData() {
		return userService.getUsers();
	}
	
}
