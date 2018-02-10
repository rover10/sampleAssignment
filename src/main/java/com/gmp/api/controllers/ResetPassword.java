package com.gmp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmp.api.models.User;
import com.gmp.api.services.PasswordResetService;

@RestController
public class ResetPassword {

	@Autowired
	PasswordResetService passwordResetService; // = new PasswordResetService();
	
	@RequestMapping(path = "/user/resetpassword", method = RequestMethod.POST)
	public String resetPassword(@ModelAttribute User user) {
		return passwordResetService.requestResetUrl(user);
		//return "Request initiated for request";
	}
}
