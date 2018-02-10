package com.gmp.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
	@RequestMapping(path = "/")
	public String welcome() {
		return "Welcome to Get my parking!";
	}
}
