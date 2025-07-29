package com.example.propertytracker.propertytrackerwithcurrencysupport.client;

import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.NotificationSettings;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Preferences;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Role;
import com.example.propertytracker.propertytrackerwithcurrencysupport.utiliti.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserResponse {
    @JsonProperty("user_id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("role")
    private Role role;
    @JsonProperty("preferences")
    private Preferences preferences;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    private NotificationSettings notificationSettings;
}
