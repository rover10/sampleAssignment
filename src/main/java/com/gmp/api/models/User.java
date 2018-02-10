package com.gmp.api.models;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String user;
	private String email;
	private String mobile;
	private String fname;
	private String lName;
	
	public int getOtp() {
		return otp;
	}
	public void setResetRequestTime(long resetRequestTime) {
		this.resetRequestTime = resetRequestTime;
	}
	private String password;
	private long resetRequestTime;
	private String passwordResetUri;
	private int otp;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getResetRequestTime() {
		return resetRequestTime;
	}
	public void setResetRequestTime(Long resetRequestTime) {
		this.resetRequestTime = resetRequestTime;
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPasswordResetUri() {
		return passwordResetUri;
	}
	public void setPasswordResetUri(String passwordResetUri) {
		this.passwordResetUri = passwordResetUri;
	}
	public void setOtp(int otp) {
		// TODO Auto-generated method stub
		
	}
	
	
}
