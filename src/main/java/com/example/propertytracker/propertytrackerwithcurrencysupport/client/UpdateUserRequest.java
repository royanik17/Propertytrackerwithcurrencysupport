package com.example.propertytracker.propertytrackerwithcurrencysupport.client;

import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.NotificationSettings;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Preferences;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Role;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {


    private String name;

    private String email;


    private String phone;

    private Role role;
    private Preferences preferences;

    private Status status;
    private NotificationSettings notificationSettings;
}
