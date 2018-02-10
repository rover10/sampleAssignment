package com.gmp.api.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gmp.api.models.User;

@Service
public class UserService {
	
	private List<User> users;
	private Random randomGenOtp =  new Random();
	private final long RESET_LIMIT = 5L;//	24 * 60 * 60L;

	private final String URI_EMAIL = "/resetpassword/email/";
	private final String URI_MOBILE = "/resetpassword/mobile/";
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserService() {

		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		
		u1.setUser("rake");
		u1.setEmail("rakesh.r1303@gmail.com");
		u1.setFname("Rakesh");
		u1.setMobile("9971588951");
		
		u2.setUser("scott");
		u2.setEmail("scott.random@gmail.com");
		u2.setFname("Scott");
		u2.setMobile("12345");
		
		
		u3.setUser("mark");
		u3.setEmail("mark.random@gmail.com");
		u3.setFname("Mark");
		u2.setMobile("99999");

		users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		

	}

	public boolean isRegistered(User user) {
		String email = user.getEmail(); 
		String mobile = user.getMobile(); 
		
		if( email != null ) {
			return users.stream()
					 .filter(u-> u.getEmail().equals(email))
					 .findFirst().isPresent();
				
		}else if(mobile != null){
			return users.stream()
					 .filter(u-> u.getMobile().equals(mobile))
					 .findFirst().isPresent();
				
		}
		return false;
		
	}

	public String resetUrl(User user) {
		
		Instant instant = Instant.now();
		long requestTime = instant.getEpochSecond();
		
		long lastRequestTime = getUserLastRequestTime(user);
		
		long duration = requestTime - lastRequestTime;
		if(duration < 0 ) {
			
			// Unregistred user
			return "Unregistered user";
			
		}else if(duration  > RESET_LIMIT) {
			
			//Generate new url
			String url = generateUrl(user);
			User u = getUser(user);
			u.setPasswordResetUri(url);
			u.setResetRequestTime(requestTime);
			return url;
			
		}else {
			
			// return existing reset usrl and set expiration time
			User u = getUser(user); 
			u.setResetRequestTime(requestTime);
			return u.getPasswordResetUri();
			
		}
	}

	private String generateUrl(User user) {
		if(user.getEmail()!= null) {
			return URI_EMAIL + generateUUIDString();
		}else if(user.getMobile() !=  null) {
			User dbUser = getUser(user);
			int otp = generateOTP();
			System.out.println("User = " + dbUser.getFname());
			System.out.println("OTP = " + otp);
			
			dbUser.setOtp(otp);
			return URI_MOBILE + generateUUIDString() ;
		}else {
			return "";
		}
	}

	private int generateOTP() {
		return randomGenOtp.nextInt(1000);
		
	}

	public static String generateUUIDString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
	
	private long getUserLastRequestTime(User user) {
		
		User u = getUser(user);
		System.out.println("User ---> ");
		System.out.println(user.getFname());
		System.out.println("User ---> ");
		
		if(u != null ) {
			return u.getResetRequestTime();
		}else {
			//User doesn't exist so valid time is negative
			return -1L;
		}
	}
	
	public User getUser(User user) {
		Optional<User> userOpt = this.users
				.stream()
				.filter((u) -> {
									return ((u.getEmail() != null && u.getEmail().equals(user.getEmail())) ||
											(u.getMobile() != null && u.getMobile().equals(user.getMobile())));
						})
				.findFirst();
		if(userOpt.isPresent()){
			return userOpt.get();
		}else {
			return new User();
		}
		
	}
}
