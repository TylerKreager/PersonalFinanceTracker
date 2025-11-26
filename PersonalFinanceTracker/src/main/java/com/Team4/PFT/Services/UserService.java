package com.Team4.PFT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Team4.PFT.Entities.User;
import com.Team4.PFT.DTOs.UpdateProfileRequest;
import com.Team4.PFT.Repositories.LoginRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Update a user's profile
     * @param userId ID of the user to update
     * @param request DTO containing updated fields
     * @return updated User entity
     */
    public User updateProfile(Long userId, UpdateProfileRequest request) {
        User user = loginRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Update basic info
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        // Optional password update
        if(request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        // Optional profile fields
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());
        user.setPostalCode(request.getPostalCode());
        user.setPhone(request.getPhone());
        user.setBudget(request.getBudget());

        // Example role-based behavior
        // You could set defaults or flags used in dashboard based on userType
        switch (user.getUserType()) {
            case Student:
                // For students, set default monthly budget or tutorial tips
                // user.setBudget(defaultStudentBudget);
                break;
            case Free_Spender:
                // Enable more aggressive spending alerts
                // user.setAlertLevel(AlertLevel.HIGH);
                break;
            case Business_Owner:
                // Enable flexible budget settings or variable income support
                // user.setFlexibleBudget(true);
                break;
            case Financially_Inclined:
                // Provide advanced analytics features
                // user.setAdvancedDashboard(true);
                break;
            default:
                break;
        }

        return loginRepository.save(user);
    }
    
    public Double getUserBudget(Long userId) {
    	User user = loginRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    	
    	Double currentBudget = user.getBudget();
    	
    	return currentBudget;
    }
    
    public User updateBudget(Long userId, double newBudget) {
    	User user = loginRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    	
    	user.setBudget(newBudget);
    	return loginRepository.save(user);
    }

}
