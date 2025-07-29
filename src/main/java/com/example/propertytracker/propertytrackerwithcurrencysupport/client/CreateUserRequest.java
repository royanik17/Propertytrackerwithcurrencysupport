package com.example.propertytracker.propertytrackerwithcurrencysupport.client;

import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.NotificationSettings;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Preferences;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Role;
import lombok.Data;

@Data
public class CreateUserRequest {

    private String name;

    private String email;


    private String phone;


    private String password;

    private Role role;
    private Preferences preferences;
    private NotificationSettings notificationSettings;

}
