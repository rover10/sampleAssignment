package com.gmp.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmp.api.models.User;

@Service
public class PasswordResetService {
	@Autowired
	UserService userService;
	
	private String INVALID_USER_MSG = "The user does not exist. Please sign up first";
	
	/*public PasswordResetService() {
		userService = new UserService();
	}*/
	
	public String requestResetUrl(User user) {
		boolean registered = userService.isRegistered(user);
		if(registered) {
			return userService.resetUrl(user);
		}else {
			return INVALID_USER_MSG;
		}
		
	}
	
	
}
