package com.Team4.PFT.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Team4.PFT.DTOs.UpdateProfileRequest;
import com.Team4.PFT.Services.LoginService;
import com.Team4.PFT.Entities.LoginRequest;
import com.Team4.PFT.Entities.User;

@RestController
@RequestMapping("api/auth")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	

	//Registering User
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	void registerUser(@RequestBody User user) throws Exception {
		loginService.registerUser(user);
	}
	
	//Login user
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
		try {
			User user = loginService.authenticate(request.getEmail(), request.getPassword());
			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
}
