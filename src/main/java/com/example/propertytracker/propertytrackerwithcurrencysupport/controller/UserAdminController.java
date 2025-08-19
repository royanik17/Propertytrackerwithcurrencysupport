package com.example.propertytracker.propertytrackerwithcurrencysupport.controller;

import com.example.propertytracker.propertytrackerwithcurrencysupport.client.*;
import com.example.propertytracker.propertytrackerwithcurrencysupport.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:9002")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;


    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Validated @RequestBody CreateUserRequest request) {
        UserResponse response = userAdminService.createUser(request);
        ApiResponse<UserResponse> apiResponse = ApiResponse.success("User created successfully", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(
            @PathVariable String userId,
            @Validated @RequestBody UpdateUserRequest request) {
        UserResponse response = userAdminService.updateUser(userId, request);
        return ResponseEntity.ok(ApiResponse.success("User updated successfully", response));
    }

    @PostMapping("/admin-login")
    public ResponseEntity<ApiResponse<LoginResponse>> adminLogin(@RequestBody LoginRequest request) {
        LoginResponse response = userAdminService.login(request);
        return ResponseEntity.ok(ApiResponse.success("Login successful", response));
    }
}
