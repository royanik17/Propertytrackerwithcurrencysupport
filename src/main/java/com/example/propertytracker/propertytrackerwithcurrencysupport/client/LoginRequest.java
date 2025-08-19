package com.example.propertytracker.propertytrackerwithcurrencysupport.client;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
