package com.Team4.PFT;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	//This bean is used to Hash and salts the password
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//Registers the user
	public User registerUser(User user) {
		if (loginRepository.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("Email is already registered!");
		}
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		return loginRepository.save(user);
	}
	
	//User login
	public User authenticate(String email, String rawPass) {
		Optional<User> optionalUser = loginRepository.findByEmail(email);
		
		if (optionalUser.isEmpty()) {
			throw new IllegalArgumentException("Email does not exist!");
		}
		User user = optionalUser.get();
		
		if (!passwordEncoder.matches(rawPass, user.getPassword())) {
			throw new IllegalArgumentException("The password is incorrect!!");
		}
		
		return user;
	}
}
