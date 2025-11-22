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
import com.Team4.PFT.Entities.UserType;

@RestController
@RequestMapping("api/auth")

public class LoginController {
	
	@Autowired
	LoginService loginService;
	

	//Registering User
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> registerUser(@RequestBody User user)  {
		try {
			User regUser = loginService.registerUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(regUser);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
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
	
	//Gathers the user types to populate dropdown
	@GetMapping("/user-types")
	public ResponseEntity<UserType[]> getUserTypes(){
		return ResponseEntity.ok(UserType.values());
	}
	
}
