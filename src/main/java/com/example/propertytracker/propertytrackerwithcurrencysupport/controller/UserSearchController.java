package com.example.propertytracker.propertytrackerwithcurrencysupport.controller;

import com.example.propertytracker.propertytrackerwithcurrencysupport.client.ApiResponse;
import com.example.propertytracker.propertytrackerwithcurrencysupport.entity.User;
import com.example.propertytracker.propertytrackerwithcurrencysupport.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserSearchController {


    @Autowired
    private UserSearchService userSearchService;



    @GetMapping("/search/{email}")
    public ResponseEntity<ApiResponse<User>> getUserByEmail(
            @PathVariable String email) {

        return userSearchService.findByEmail(email)
                .map(user -> ResponseEntity.ok(ApiResponse.success("User found", user)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("User not found with email: " + email)));
    }

}
