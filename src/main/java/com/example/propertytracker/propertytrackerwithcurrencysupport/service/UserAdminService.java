package com.example.propertytracker.propertytrackerwithcurrencysupport.service;

import com.example.propertytracker.propertytrackerwithcurrencysupport.client.*;
import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.User;
import com.example.propertytracker.propertytrackerwithcurrencysupport.exception.UserNotFoundException;
import com.example.propertytracker.propertytrackerwithcurrencysupport.userrepository.UserRepository;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Role;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAdminService {

    private final UserRepository userRepository;

    public UserResponse createUser(CreateUserRequest request) {
        // Check if email already exists
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists: " + request.getEmail());
        }

        // Create new user entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword()); // Store plain password (not recommended for production)
        user.setRole(request.getRole() != null ? request.getRole() : Role.USER);
        user.setPreferences(request.getPreferences());
        user.setNotificationSettings(request.getNotificationSettings());
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus(Status.ACTIVE);

        // Save to database
        User savedUser = userRepository.save(user);

        // Convert to response DTO
        return convertToResponse(savedUser);
    }

    public UserResponse updateUser(String userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        // Update all relevant fields
        if (request.getName() != null) user.setName(request.getName());
        if (request.getEmail() != null) user.setEmail(request.getEmail());
        if (request.getPhone() != null) user.setPhone(request.getPhone());
        if (request.getRole() != null) user.setRole(request.getRole());
        if (request.getPreferences() != null) user.setPreferences(request.getPreferences());
        if (request.getStatus() != null) user.setStatus(request.getStatus());
        if (request.getNotificationSettings() != null) {
            user.setNotificationSettings(request.getNotificationSettings());
        }

        User updatedUser = userRepository.save(user);
        return convertToResponse(updatedUser);
    }

    private UserResponse convertToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .preferences(user.getPreferences())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .notificationSettings(user.getNotificationSettings())
                .build();
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new LoginResponse(user.getId(), user.getName(), user.getRole().name());
    }

}