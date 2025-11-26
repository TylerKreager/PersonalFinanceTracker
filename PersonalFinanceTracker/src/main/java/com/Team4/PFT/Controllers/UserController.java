package com.Team4.PFT.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Team4.PFT.Entities.User;
import com.Team4.PFT.DTOs.UpdateProfileRequest;
import com.Team4.PFT.Services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to update user profile
    @PutMapping("/{id}")
    public ResponseEntity<User> updateProfile(@PathVariable Long id,
                                              @RequestBody UpdateProfileRequest request) {
        User updatedUser = userService.updateProfile(id, request);
        return ResponseEntity.ok(updatedUser);
    }
    
    @GetMapping("/budget")
    public ResponseEntity<Double> getBudget(@RequestParam("userId") Long userId) {
    	Double currentBudget = userService.getUserBudget(userId);
    	
    	return ResponseEntity.ok(currentBudget);
    }
    
    @PutMapping("/setBudget")
    public ResponseEntity<User> updateUserBudget(@RequestParam Long userId, 
    		@RequestBody double newBudget)
    {
    	User updatedUser = userService.updateBudget(userId, newBudget);
    	return ResponseEntity.ok(updatedUser);
    	
    }
   
    
    
}

