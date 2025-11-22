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
}

